package coda.littlebeasties.common.entities;

import coda.littlebeasties.registry.LBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CoinFrog extends AbstractFish {

	public CoinFrog(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	@Override
	public ItemStack getBucketItemStack() {
	      return new ItemStack(LBItems.BLUE_SAILFISH_BUCKET.get());
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

	public static boolean canSpawn(EntityType<CoinFrog> fish, LevelAccessor level, MobSpawnType reason, BlockPos pos, Random random) {
		return level.getFluidState(pos).is(FluidTags.WATER);
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(LBItems.COIN_FROG_SPAWN_EGG.get());
	}
}
