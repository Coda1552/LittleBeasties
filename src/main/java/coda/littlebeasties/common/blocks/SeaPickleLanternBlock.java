package coda.littlebeasties.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class SeaPickleLanternBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERED = BooleanProperty.create("watered");;

    public SeaPickleLanternBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERED, false));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return pContext.getLevel().getBlockState(pContext.getClickedPos()).getFluidState().is(FluidTags.WATER) ? defaultBlockState().setValue(WATERED, true) : defaultBlockState().setValue(WATERED, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERED);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!isWatered() && player.getItemInHand(hand).is(Items.POTION) && PotionUtils.getPotion(player.getItemInHand(hand)) == Potions.WATER) {
            setWatered(true);
            level.playSound(player, pos, SoundEvents.FISHING_BOBBER_SPLASH, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        if (isWatered() && player.getItemInHand(hand).is(Items.BUCKET)) {
            setWatered(false);
        }

        return super.use(state, level, pos, player, hand, result);
    }

    private void setWatered(boolean watered) {
        defaultBlockState().setValue(WATERED, watered);
    }

    private boolean isWatered() {
        return defaultBlockState().getValue(WATERED);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return isWatered() ? 15 : 0;
    }
}
