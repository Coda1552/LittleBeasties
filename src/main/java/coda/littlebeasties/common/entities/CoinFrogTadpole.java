package coda.littlebeasties.common.entities;

import coda.littlebeasties.registry.LBItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CoinFrogTadpole extends AbstractFish implements Bucketable {

	// todo - add bottling feature
	public CoinFrogTadpole(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	@Override
	public ItemStack getBucketItemStack() {
	      return new ItemStack(LBItems.COIN_FROG_TADPOLE_BOTTLE.get());
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.COD_FLOP;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource p_21239_) {
		return SoundEvents.COD_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.COD_DEATH;
	}

	public static boolean canSpawn(EntityType<CoinFrogTadpole> fish, LevelAccessor level, MobSpawnType reason, BlockPos pos, Random random) {
		return level.getFluidState(pos).is(FluidTags.WATER);
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(LBItems.COIN_FROG_SPAWN_EGG.get());
	}

	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == Items.POTION && PotionUtils.getPotion(itemstack).equals(Potions.WATER) && isAlive()) {
			playSound(getPickupSound(), 1.0F, 1.0F);
			ItemStack itemstack1 = getBucketItemStack();
			saveToBucketTag(itemstack1);
			ItemStack itemstack2 = new ItemStack(LBItems.COIN_FROG_TADPOLE_BOTTLE.get());
			player.setItemInHand(hand, itemstack2);
			Level level = player.level;

			if (!level.isClientSide) {
				CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)player, itemstack1);
			}

			discard();
			return InteractionResult.sidedSuccess(level.isClientSide);
		}
		else {
			return super.mobInteract(player, hand);
		}
	}
}
