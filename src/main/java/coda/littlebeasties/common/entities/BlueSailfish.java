package coda.littlebeasties.common.entities;

import java.util.Random;

import coda.littlebeasties.registry.LBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

// todo - fin-opening animation and logic
public class BlueSailfish extends AbstractFish {

	public BlueSailfish(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
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

	public static boolean canSailfishSpawn(EntityType<BlueSailfish> fish, LevelAccessor level, MobSpawnType reason, BlockPos pos, Random random) {
		return level.getFluidState(pos).is(FluidTags.WATER);
	}
}
