package coda.littlebeasties.common.entities;

import coda.littlebeasties.registry.LBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Dragonfish extends AbstractFish {

	public Dragonfish(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	@Override
	public ItemStack getBucketItemStack() {
	      return ItemStack.EMPTY;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(LBItems.DRAGONFISH_SPAWN_EGG.get());
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

	public static boolean canSpawn(EntityType<Dragonfish> fish, LevelAccessor level, MobSpawnType reason, BlockPos pos, Random random) {
		return level.getFluidState(pos).is(FluidTags.WATER);
	}

	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (player.getItemInHand(hand).is(Items.WATER_BUCKET)) {
			return InteractionResult.PASS;
		}
		else {
			return super.mobInteract(player, hand);
		}
	}
}
