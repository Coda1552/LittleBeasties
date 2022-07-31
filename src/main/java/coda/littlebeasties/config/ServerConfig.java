package coda.littlebeasties.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
	
	public final ForgeConfigSpec.IntValue blueSailfishSpawnWeight;
	public final ForgeConfigSpec.IntValue dugoinSpawnWeight;
	
	public ServerConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		this.blueSailfishSpawnWeight = buildInt(builder, "Blue Sailfish Spawn Weight", "all", 3, 1, 300, "The weight of Blue Sailfish in vanilla's spawn rate. Default is 3");
		this.dugoinSpawnWeight = buildInt(builder, "Dugoin Spawn Weight", "all", 5, 1, 300, "The weight of Dugoin in vanilla's spawn rate. Default is 5");
	}
	
	private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment) {
		return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
	}

}
