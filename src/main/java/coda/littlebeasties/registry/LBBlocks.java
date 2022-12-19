package coda.littlebeasties.registry;

import coda.littlebeasties.LittleBeasties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class LBBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LittleBeasties.MOD_ID);

    // todo - custom block for leaf fly nests
    public static final RegistryObject<Block> LEAF_FLY_NEST = register("leaf_fly_nest", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.4F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MARINE_CLAY = register("marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WHITE_MARINE_CLAY = register("white_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> ORANGE_MARINE_CLAY = register("orange_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> MAGENTA_MARINE_CLAY = register("magenta_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> LIGHT_BLUE_MARINE_CLAY = register("light_blue_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> YELLOW_MARINE_CLAY = register("yellow_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> LIME_MARINE_CLAY = register("lime_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> PINK_MARINE_CLAY = register("pink_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> GRAY_MARINE_CLAY = register("gray_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> LIGHT_GRAY_MARINE_CLAY = register("light_gray_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> CYAN_MARINE_CLAY = register("cyan_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> PURPLE_MARINE_CLAY = register("purple_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> BLUE_MARINE_CLAY = register("blue_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> BROWN_MARINE_CLAY = register("brown_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> GREEN_MARINE_CLAY = register("green_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> RED_MARINE_CLAY = register("red_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> BLACK_MARINE_CLAY = register("black_marine_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, new Item.Properties().tab(LBItems.GROUP));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties itemProperties) {
        return register(name, block, BlockItem::new, itemProperties);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, BiFunction<Block, Item.Properties, BlockItem> item, Item.Properties itemProperties) {
        final RegistryObject<T> registryObject = BLOCKS.register(name, block);
        if (itemProperties != null) LBItems.ITEMS.register(name, () -> item == null ? new BlockItem(registryObject.get(), itemProperties) : item.apply(registryObject.get(), itemProperties));
        return registryObject;
    }
}
