package coda.littlebeasties.common.item;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LBBucketItem extends BucketItem {
	
	private final boolean hasTooltip;
	
	public LBBucketItem(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid, Properties builder) {
		this(entityType, fluid, builder, true);
	}
	
	public LBBucketItem(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid, Properties builder, boolean hasToolTip) {
		super(fluid, builder);
		this.hasTooltip = hasToolTip;
		this.entityTypeSupplier = entityType;
	}
	
	public void checkExtraContent(@Nullable Player player, Level level, ItemStack stack, BlockPos pos) {
		if (level instanceof ServerLevel) {
			this.spawn((ServerLevel)level, stack, pos);
			level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> toolTip, TooltipFlag flag) {
		super.appendHoverText(stack, level, toolTip, flag);
		if (hasTooltip && stack.hasTag()) {
			toolTip.add(new TranslatableComponent(getEntityType().getDescriptionId() + "." + stack.getTag().getInt("Variant")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
		}
	}
	
	private void spawn(ServerLevel level, ItemStack stack, BlockPos pos) {
		Entity entity = this.entityTypeSupplier.get().spawn(level, stack, (Player)null, pos, MobSpawnType.BUCKET, true, false);
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

}
