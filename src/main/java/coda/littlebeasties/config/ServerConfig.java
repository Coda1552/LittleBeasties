package coda.littlebeasties.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
	public final ForgeConfigSpec.IntValue blueSailfishSpawnWeight;
	public final ForgeConfigSpec.IntValue dugoinSpawnWeight;
	public final ForgeConfigSpec.IntValue sealightSpawnWeight;
	public final ForgeConfigSpec.IntValue dragonfishSpawnWeight;
	public final ForgeConfigSpec.IntValue leafDartfishSpawnWeight;

	public ServerConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		this.blueSailfishSpawnWeight = buildInt(builder, "Blue Sailfish Spawn Weight", "all", 3, 1, 300, "The weight of Blue Sailfish in vanilla's spawn rate. Default is 3");
		this.dugoinSpawnWeight = buildInt(builder, "Dugoin Spawn Weight", "all", 5, 1, 300, "The weight of Dugoin in vanilla's spawn rate. Default is 5");
		this.sealightSpawnWeight = buildInt(builder, "Sealight Spawn Weight", "all", 4, 1, 300, "The weight of Sealight in vanilla's spawn rate. Default is 4");
		this.dragonfishSpawnWeight = buildInt(builder, "Dragonfish Spawn Weight", "all", 5, 1, 300, "The weight of Dragonfish in vanilla's spawn rate. Default is 5");
		this.leafDartfishSpawnWeight = buildInt(builder, "Leaf Dartfish Spawn Weight", "all", 6, 1, 300, "The weight of Leaf Dartfish in vanilla's spawn rate. Default is 6");
	}

	private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String category, int defaultValue, int min, int max, String comment) {
		return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
	}

}
