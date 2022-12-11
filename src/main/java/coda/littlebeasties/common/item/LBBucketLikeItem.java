package coda.littlebeasties.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class LBBucketLikeItem extends BucketItem implements DispensibleContainerItem {
	private final boolean hasTooltip;
	private final Item bucketLike;

	public LBBucketLikeItem(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid, Item bucketLike, Properties builder) {
		this(entityType, fluid, bucketLike, true, builder);
	}
	
	public LBBucketLikeItem(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid, Item bucketLike, boolean hasToolTip, Properties builder) {
		super(fluid, builder);
		this.entityTypeSupplier = entityType;
		this.bucketLike = bucketLike;
		this.hasTooltip = hasToolTip;
	}

	@Override
	public boolean emptyContents(@Nullable Player p_150716_, Level p_150717_, BlockPos p_150718_, @org.jetbrains.annotations.Nullable BlockHitResult p_150719_) {
		return super.emptyContents(p_150716_, p_150717_, p_150718_, p_150719_);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		BlockHitResult result = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.NONE);
		InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, result);
		if (ret != null) return ret;
		if (result.getType() == BlockHitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else if (result.getType() != BlockHitResult.Type.BLOCK) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			BlockPos blockpos = result.getBlockPos();
			Direction direction = result.getDirection();
			BlockPos blockpos1 = blockpos.relative(direction);
			if (worldIn.mayInteract(playerIn, blockpos) && playerIn.mayUseItemAt(blockpos1, direction, itemstack)) {
				BlockState blockstate = worldIn.getBlockState(blockpos);
				BlockPos blockpos2 = blockstate.getBlock() instanceof LiquidBlockContainer && ((LiquidBlockContainer) blockstate.getBlock()).canPlaceLiquid(worldIn, blockpos, blockstate, Fluids.WATER) ? blockpos : blockpos1;
				this.emptyContents(playerIn, worldIn, blockpos2, result);
				if (worldIn instanceof ServerLevel) this.spawn((ServerLevel)worldIn, itemstack, blockpos2);
				if (playerIn instanceof ServerPlayer) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) playerIn, blockpos2, itemstack);
				}

				playerIn.awardStat(Stats.ITEM_USED.get(this));

				return InteractionResultHolder.sidedSuccess(getEmptyItem(itemstack, playerIn), worldIn.isClientSide());
			} else {
				return InteractionResultHolder.fail(itemstack);
			}
		}
	}

	/*public void checkExtraContent(@Nullable Player player, Level level, ItemStack stack, BlockPos pos) {
		if (level instanceof ServerLevel) {
			this.spawn((ServerLevel)level, stack, pos);
			level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
		}
	}*/

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> toolTip, TooltipFlag flag) {
		super.appendHoverText(stack, level, toolTip, flag);
		if (hasTooltip && stack.hasTag()) {
			toolTip.add(new TranslatableComponent(getEntityType().getDescriptionId() + "." + stack.getTag().getInt("Variant")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
		}
	}
	
	private void spawn(ServerLevel level, ItemStack stack, BlockPos pos) {
		Entity entity = this.entityTypeSupplier.get().spawn(level, stack, null, pos, MobSpawnType.BUCKET, true, false);
		if (entity != null) {
			if (entity instanceof AbstractFish) {
				((AbstractFish)entity).setFromBucket(true);
			}
		}
	}
	
	private final Supplier<? extends EntityType<?>> entityTypeSupplier;

	protected EntityType<?> getEntityType() {
		return entityTypeSupplier.get();
	}

	private ItemStack getEmptyItem(ItemStack stack, Player player) {
		return !player.isCreative() ? new ItemStack(bucketLike) : stack;
	}
}
