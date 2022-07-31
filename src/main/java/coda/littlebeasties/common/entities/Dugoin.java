package coda.littlebeasties.common.entities;

import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import coda.littlebeasties.registry.LBEntities;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TurtleEggBlock;

public class Dugoin extends Animal implements NeutralMob {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Dugoin.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LAYING_EGG = SynchedEntityData.defineId(Dugoin.class, EntityDataSerializers.BOOLEAN);
	int layEggCounter;
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private int remainingPersistentAngerTime;
	@Nullable
	private UUID persistentAngerTarget;
	
	public Dugoin(EntityType<? extends Dugoin> p_29519_, Level p_29520_) {
		super(p_29519_, p_29520_);
	}

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}

	void setHasEgg(boolean p_30235_) {
		this.entityData.set(HAS_EGG, p_30235_);
	}

	public boolean isLayingEgg() {
		return this.entityData.get(LAYING_EGG);
	}

	void setLayingEgg(boolean p_30237_) {
		this.layEggCounter = p_30237_ ? 1 : 0;
		this.entityData.set(LAYING_EGG, p_30237_);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(LAYING_EGG, false);
	}

	public void addAdditionalSaveData(CompoundTag p_30176_) {
		p_30176_.putBoolean("HasEgg", this.hasEgg());
	}

	public void readAdditionalSaveData(CompoundTag p_30162_) {
		super.readAdditionalSaveData(p_30162_);
		this.setHasEgg(p_30162_.getBoolean("HasEgg"));
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(1, new Dugoin.DugoinBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new Dugoin.DugoinLayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new Dugoin.DugoinMeleeAttackGoal());
		this.goalSelector.addGoal(1, new Dugoin.DugoinPanicGoal());
		this.targetSelector.addGoal(1, new Dugoin.DugoinHurtByTargetGoal());
		this.targetSelector.addGoal(2, new Dugoin.DugoinAttackPlayersGoal());
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractFish.class, 10, true, true, (Predicate<LivingEntity>)null));
		this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.15D).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	public boolean doHurtTarget(Entity p_29522_) {
		boolean flag = p_29522_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, p_29522_);
		}

		return flag;
	}

	class DugoinAttackPlayersGoal extends NearestAttackableTargetGoal<Player> {
		public DugoinAttackPlayersGoal() {
			super(Dugoin.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Dugoin.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Dugoin polarbear : Dugoin.this.level.getEntitiesOfClass(Dugoin.class, Dugoin.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (polarbear.isBaby()) {
							return true;
						}
					}
				}

				return false;
			}
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	class DugoinHurtByTargetGoal extends HurtByTargetGoal {
		public DugoinHurtByTargetGoal() {
			super(Dugoin.this);
		}

		public void start() {
			super.start();
			if (Dugoin.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob p_29580_, LivingEntity p_29581_) {
			if (p_29580_ instanceof Dugoin && !p_29580_.isBaby()) {
				super.alertOther(p_29580_, p_29581_);
			}

		}
	}

	class DugoinMeleeAttackGoal extends MeleeAttackGoal {
		public DugoinMeleeAttackGoal() {
			super(Dugoin.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity p_29589_, double p_29590_) {
			double d0 = this.getAttackReachSqr(p_29589_);
			if (p_29590_ <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(p_29589_);
			} else if (p_29590_ <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity p_29587_) {
			return (double)(4.0F + p_29587_.getBbWidth());
		}
	}

	class DugoinPanicGoal extends PanicGoal {
		public DugoinPanicGoal() {
			super(Dugoin.this, 2.0D);
		}

		protected boolean shouldPanic() {
			return this.mob.getLastHurtByMob() != null && this.mob.isBaby() || this.mob.isOnFire();
		}
	}

	@Nullable
	public AgeableMob getBreedOffspring(ServerLevel p_149068_, AgeableMob p_149069_) {
		return LBEntities.DUGOIN.get().create(p_149068_);
	}

	public boolean isFood(ItemStack p_30231_) {
		return p_30231_.is(Blocks.SEAGRASS.asItem());
	}

	static class DugoinBreedGoal extends BreedGoal {
		private final Dugoin dugoin;

		DugoinBreedGoal(Dugoin p_30244_, double p_30245_) {
			super(p_30244_, p_30245_);
			this.dugoin = p_30244_;
		}

		public boolean canUse() {
			return super.canUse() && !this.dugoin.hasEgg();
		}

		protected void breed() {
			ServerPlayer serverplayer = this.animal.getLoveCause();
			if (serverplayer == null && this.partner.getLoveCause() != null) {
				serverplayer = this.partner.getLoveCause();
			}

			if (serverplayer != null) {
				serverplayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayer, this.animal, this.partner, (AgeableMob)null);
			}

			this.dugoin.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class DugoinLayEggGoal extends MoveToBlockGoal {
		private final Dugoin dugoin;

		DugoinLayEggGoal(Dugoin p_30276_, double p_30277_) {
			super(p_30276_, p_30277_, 16);
			this.dugoin = p_30276_;
		}

		public boolean canUse() {
			return this.dugoin.hasEgg() && super.canUse();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.dugoin.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = this.dugoin.blockPosition();
			if (!this.dugoin.isInWater() && this.isReachedTarget()) {
				if (this.dugoin.layEggCounter < 1) {
					this.dugoin.setLayingEgg(true);
				} else if (this.dugoin.layEggCounter > this.adjustedTickDelay(200)) {
					Level level = this.dugoin.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), Blocks.TURTLE_EGG.defaultBlockState().setValue(TurtleEggBlock.EGGS, Integer.valueOf(this.dugoin.random.nextInt(4) + 1)), 3);
					this.dugoin.setHasEgg(false);
					this.dugoin.setLayingEgg(false);
					this.dugoin.setInLoveTime(600);
				}

				if (this.dugoin.isLayingEgg()) {
					++this.dugoin.layEggCounter;
				}
			}

		}

		protected boolean isValidTarget(LevelReader p_30280_, BlockPos p_30281_) {
			return !p_30280_.isEmptyBlock(p_30281_.above()) ? false : TurtleEggBlock.isSand(p_30280_, p_30281_);
		}
	}
	
	public static boolean canDugoinSpawn(EntityType<? extends Animal> animal, LevelAccessor levelIn, MobSpawnType reason, BlockPos pos, Random random) {
		return (levelIn.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK) || levelIn.getBlockState(pos.below()).is(net.minecraftforge.common.Tags.Blocks.SAND)) && isBrightEnoughToSpawn(levelIn, pos);
	}


	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	public void setRemainingPersistentAngerTime(int p_29543_) {
		this.remainingPersistentAngerTime = p_29543_;
	}

	public int getRemainingPersistentAngerTime() {
		return this.remainingPersistentAngerTime;
	}

	public void setPersistentAngerTarget(@Nullable UUID p_29539_) {
		this.persistentAngerTarget = p_29539_;
	}

	@Nullable
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

}
