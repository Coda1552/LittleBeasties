package coda.littlebeasties.config;

import coda.littlebeasties.LittleBeasties;
import net.minecraftforge.fml.config.ModConfig;

public class LittleBeastiesConfig {
	
	public static int blueSailfishSpawnWeight = 3;
	public static int dugoinSpawnWeight = 5;
	
	public static void bakeServer(final ModConfig config) {
		try {
			blueSailfishSpawnWeight = LBConfigHolder.SERVER.blueSailfishSpawnWeight.get();
			dugoinSpawnWeight = LBConfigHolder.SERVER.dugoinSpawnWeight.get();
		} catch (Exception e) {
			LittleBeasties.LOGGER.warn("An exception was caused trying to load the config for Little Beasties");
			e.printStackTrace();
		}
	}

}
