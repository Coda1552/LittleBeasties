package coda.littlebeasties.config;

import coda.littlebeasties.LittleBeasties;
import net.minecraftforge.fml.config.ModConfig;

public class LittleBeastiesConfig {
	public static int blueSailfishSpawnWeight = 3;
	public static int dugoinSpawnWeight = 5;
	public static int sealightSpawnWeight = 4;
	public static int dragonfishSpawnWeight = 5;
	public static int leafDartfishSpawnWeight = 6;
	public static int collectorSpawnWeight = 5;

	// todo - make the config file actually generate
	public static void bakeServer(final ModConfig config) {
		try {
			blueSailfishSpawnWeight = LBConfigHolder.SERVER.blueSailfishSpawnWeight.get();
			dugoinSpawnWeight = LBConfigHolder.SERVER.dugoinSpawnWeight.get();
			sealightSpawnWeight = LBConfigHolder.SERVER.sealightSpawnWeight.get();
			dragonfishSpawnWeight = LBConfigHolder.SERVER.dragonfishSpawnWeight.get();
			leafDartfishSpawnWeight = LBConfigHolder.SERVER.leafDartfishSpawnWeight.get();
			sealightSpawnWeight = LBConfigHolder.SERVER.sealightSpawnWeight.get();
			sealightSpawnWeight = LBConfigHolder.SERVER.sealightSpawnWeight.get();
			collectorSpawnWeight = LBConfigHolder.SERVER.collectorSpawnWeight.get();
		} catch (Exception e) {
			LittleBeasties.LOGGER.warn("An exception was caused trying to load the config for Little Beasties");
			e.printStackTrace();
		}
	}

}
