package coda.littlebeasties.config;

import coda.littlebeasties.LittleBeasties;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class LBCOnfig {
	public static int blueSailfishSpawnWeight;
	public static int dugoinSpawnWeight;
	public static int sealightSpawnWeight;
	public static int dragonfishSpawnWeight;
	public static int leafDartfishSpawnWeight;

	@SubscribeEvent
	public static void configLoad(ModConfigEvent.Reloading event) {
		try {
			IConfigSpec spec = event.getConfig().getSpec();
			if (spec == Common.SPEC) Common.reload();
		}
		catch (Throwable e) {
			LittleBeasties.LOGGER.error("Something went wrong updating the Ambient Additions config, using previous or default values! {}", e.toString());
		}
	}

	public static class Common {
		public static final Common INSTANCE;
		public static final ForgeConfigSpec SPEC;

		static {
			Pair<Common, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(Common::new);
			INSTANCE = pair.getLeft();
			SPEC = pair.getRight();
		}

		public final ForgeConfigSpec.IntValue blueSailfishSpawnWeight;
		public final ForgeConfigSpec.IntValue dugoinSpawnWeight;
		public final ForgeConfigSpec.IntValue sealightSpawnWeight;
		public final ForgeConfigSpec.IntValue dragonfishSpawnWeight;
		public final ForgeConfigSpec.IntValue leafDartfishSpawnWeight;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("Spawn Weights");
			blueSailfishSpawnWeight = buildInt(builder, "Blue Sailfish Spawn Weight", "all", 3, 1, 300, "The spawn weight of Blue Sailfish. Default is 3");
			dugoinSpawnWeight = buildInt(builder, "Dugoin Spawn Weight", "all", 5, 1, 300, "The spawn weight of Dugoins. Default is 5");
			sealightSpawnWeight = buildInt(builder, "Sealight Spawn Weight", "all", 4, 1, 300, "The spawn weight of Sealight. Default is 4");
			dragonfishSpawnWeight = buildInt(builder, "Dragonfish Spawn Weight", "all", 5, 1, 300, "The spawn weight of Dragonfish. Default is 5");
			leafDartfishSpawnWeight = buildInt(builder, "Leaf Dartfish Spawn Weight", "all", 6, 1, 300, "The spawn weight of Leaf Dartfish. Default is 6");
		}

		private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String category, int defaultValue, int min, int max, String comment) {
			return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
		}

		public static void reload() {
			LBCOnfig.blueSailfishSpawnWeight = INSTANCE.blueSailfishSpawnWeight.get();
			LBCOnfig.dugoinSpawnWeight = INSTANCE.dugoinSpawnWeight.get();
			LBCOnfig.sealightSpawnWeight = INSTANCE.sealightSpawnWeight.get();
			LBCOnfig.dragonfishSpawnWeight = INSTANCE.dragonfishSpawnWeight.get();
			LBCOnfig.leafDartfishSpawnWeight = INSTANCE.leafDartfishSpawnWeight.get();
			LBCOnfig.sealightSpawnWeight = INSTANCE.sealightSpawnWeight.get();
			LBCOnfig.sealightSpawnWeight = INSTANCE.sealightSpawnWeight.get();
		}
	}
}
