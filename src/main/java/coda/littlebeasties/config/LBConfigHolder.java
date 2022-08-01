package coda.littlebeasties.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public class LBConfigHolder {
	public static final ForgeConfigSpec SERVER_SPEC;
	static final ServerConfig SERVER;
	
	static {
		final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
		SERVER = specPair.getLeft();
		SERVER_SPEC = specPair.getRight();
	}

}
