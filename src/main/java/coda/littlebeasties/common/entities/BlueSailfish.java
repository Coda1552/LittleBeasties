package coda.littlebeasties.common.entities;

import coda.littlebeasties.registry.LBItems;
import coda.littlebeasties.registry.LBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class BlueSailfish extends AbstractFish {
	private static final EntityDataAccessor<Boolean> FINS_OPEN = SynchedEntityData.defineId(BlueSailfish.class, EntityDataSerializers.BOOLEAN);

	public BlueSailfish(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(FINS_OPEN, false);
	}

	public boolean areFinsOpen() {
		return this.entityData.get(FINS_OPEN);
	}

	public void setFinsOpen(boolean open) {
		this.entityData.set(FINS_OPEN, open);
	}

	@Override
	public ItemStack getBucketItemStack() {
	      return new ItemStack(LBItems.BLUE_SAILFISH_BUCKET.get());
	}

	@Override
	public void tick() {
		super.tick();

		List<LivingEntity> entityList = level.getNearbyEntities(LivingEntity.class, TargetingConditions.forNonCombat(), this, getBoundingBox().inflate(5));

		List<LivingEntity> predators = entityList.stream().filter(e -> e.getType().is(LBTags.BLUE_SAILFISH_PREDATORS)).toList();

		if (!predators.isEmpty() && !areFinsOpen()) {
			setFinsOpen(true);
		}
		else if (predators.isEmpty()) {
			setFinsOpen(false);
		}

		System.out.println(entityList.size());

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

	public static boolean canSailfishSpawn(EntityType<BlueSailfish> fish, LevelAccessor level, MobSpawnType reason, BlockPos pos, Random random) {
		return level.getFluidState(pos).is(FluidTags.WATER);
	}
}
