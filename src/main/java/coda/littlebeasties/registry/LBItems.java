package coda.littlebeasties.registry;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.common.item.LBBucketItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LittleBeasties.MOD_ID);
    public static final CreativeModeTab GROUP = new CreativeModeTab(LittleBeasties.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(LBItems.SEALIGHT_BUCKET.get());
        }
    };

    public static final RegistryObject<Item> SEALIGHT_SPAWN_EGG = ITEMS.register("sealight_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.SEALIGHT, 0xa2c6ee, 0xe5fcd2, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> BLUE_SAILFISH_SPAWN_EGG = ITEMS.register("blue_sailfish_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.BLUE_SAILFISH, 0x2C28A4, 0x3E52D2, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> DUGOIN_SPAWN_EGG = ITEMS.register("dugoin_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.DUGOIN, 0x60737e, 0xe7c961, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> LEAF_FLY_SPAWN_EGG = ITEMS.register("leaf_fly_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.LEAF_FLY, 0xdbd4d2, 0x494746, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> DRAGONFISH_SPAWN_EGG = ITEMS.register("dragonfish_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.DRAGONFISH, 0x2a2424, 0x5c2626, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> COLLECTOR_SPAWN_EGG = ITEMS.register("collector_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.COLLECTOR, 0xa8c9d0, 0x374963, new Item.Properties().tab(GROUP)));

	public static final RegistryObject<Item> BLUE_SAILFISH_BUCKET = ITEMS.register("blue_sailfish_bucket", () -> new LBBucketItem(LBEntities.BLUE_SAILFISH, () -> Fluids.WATER, (new Item.Properties()).stacksTo(1).tab(GROUP)));
	public static final RegistryObject<Item> SEALIGHT_BUCKET = ITEMS.register("sealight_bucket", () -> new LBBucketItem(LBEntities.SEALIGHT, () -> Fluids.WATER, (new Item.Properties()).stacksTo(1).tab(GROUP)));

    public static final RegistryObject<Item> SEALIGHT_VEIL = ITEMS.register("sealight_veil", () -> new Item(new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> BLUE_SAILFISH = ITEMS.register("blue_sailfish", () -> new Item(new Item.Properties().tab(GROUP).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build())));

}
