package coda.littlebeasties.common.entities;

import coda.littlebeasties.registry.LBItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class LeafDartfish extends AbstractSchoolingFish {

	public LeafDartfish(EntityType<? extends AbstractSchoolingFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0d, false));
		this.targetSelector.addGoal(0, new HurtByTargetGoal(this).setAlertOthers());
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(LBItems.LEAF_DARTFISH_BUCKET.get());
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(LBItems.LEAF_DARTFISH_SPAWN_EGG.get());
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

	@Override
	public int getMaxSchoolSize() {
		return 15;
	}
}
