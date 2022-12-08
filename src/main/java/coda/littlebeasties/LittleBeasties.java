package coda.littlebeasties;

import coda.littlebeasties.common.entities.*;
import coda.littlebeasties.registry.LBBlocks;
import net.minecraft.world.entity.animal.AbstractFish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import coda.littlebeasties.config.LBConfigHolder;
import coda.littlebeasties.config.LittleBeastiesConfig;
import coda.littlebeasties.registry.LBEntities;
import coda.littlebeasties.registry.LBItems;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LittleBeasties.MOD_ID)
@Mod.EventBusSubscriber(modid = LittleBeasties.MOD_ID)
public class LittleBeasties {
    public static final String MOD_ID = "littlebeasties";
    
    public static final Logger LOGGER = LogManager.getLogger();

    public LittleBeasties() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		bus.addListener(this::setup);

        LBEntities.ENTITIES.register(bus);
        LBItems.ITEMS.register(bus);
        LBBlocks.BLOCKS.register(bus);

		modLoadingContext.registerConfig(ModConfig.Type.SERVER, LBConfigHolder.SERVER_SPEC);
        bus.addListener(this::createAttributes);
    }

    private void createAttributes(EntityAttributeCreationEvent event) {
        event.put(LBEntities.SEALIGHT.get(), Sealight.createAttributes().build());
        event.put(LBEntities.BLUE_SAILFISH.get(), BlueSailfish.createAttributes().build());
        event.put(LBEntities.DUGOIN.get(), Dugoin.createAttributes().build());
        event.put(LBEntities.LEAF_FLY.get(), LeafFly.createAttributes().build());
        event.put(LBEntities.DRAGONFISH.get(), Dragonfish.createAttributes().build());
        event.put(LBEntities.COLLECTOR.get(), Collector.createCollectorAttributes().build());
        event.put(LBEntities.LEAF_DARTFISH.get(), LeafDartfish.createAttributes().build());
    }
    
	public void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(LBEntities.BLUE_SAILFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlueSailfish::canSailfishSpawn);
		SpawnPlacements.register(LBEntities.DUGOIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dugoin::canDugoinSpawn);
		SpawnPlacements.register(LBEntities.SEALIGHT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Sealight::canSealightSpawn);
		SpawnPlacements.register(LBEntities.DRAGONFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Dragonfish::canSpawn);
		SpawnPlacements.register(LBEntities.LEAF_DARTFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, AbstractFish::checkSurfaceWaterAnimalSpawnRules);
	}

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {

		if (event.getCategory() == BiomeCategory.BEACH) {
			event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(LBEntities.DUGOIN.get(), LittleBeastiesConfig.dugoinSpawnWeight, 4, 10));
		}

		if (event.getCategory() == BiomeCategory.JUNGLE) {
			event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(LBEntities.DRAGONFISH.get(), LittleBeastiesConfig.dragonfishSpawnWeight, 1, 1));
		}

		String name = event.getName().getPath();
		if (name.equals("warm_ocean")) {
			event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(LBEntities.BLUE_SAILFISH.get(), LittleBeastiesConfig.blueSailfishSpawnWeight, 1, 1));
		}

		if (name.equals("lukewarm_ocean")) {
			event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(LBEntities.LEAF_DARTFISH.get(), LittleBeastiesConfig.leafDartfishSpawnWeight, 4, 8));
		}

		if (name.equals("deep_frozen_ocean") || name.equals("frozen_ocean")) {
			event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(LBEntities.SEALIGHT.get(), LittleBeastiesConfig.sealightSpawnWeight, 5, 10));
		}
	}

    
}
