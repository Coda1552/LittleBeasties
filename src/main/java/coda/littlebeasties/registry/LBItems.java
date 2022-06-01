package coda.littlebeasties.registry;

import coda.littlebeasties.LittleBeasties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LittleBeasties.MOD_ID);

    public static final RegistryObject<Item> SEALIGHT_SPAWN_EGG = ITEMS.register("sealight_spawn_egg", () -> new ForgeSpawnEggItem(LBEntities.SEALIGHT, 0xa2c6ee, 0xe5fcd2, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
