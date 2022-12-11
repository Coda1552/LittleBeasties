package coda.littlebeasties.client;

import coda.littlebeasties.LittleBeasties;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class LBModelLayers {
    public static ModelLayerLocation BLUE_SAILFISH = create("blue_sailfish");
    public static ModelLayerLocation DUGOIN = create("dugoin");
    public static ModelLayerLocation SEALIGHT = create("sealight");
    public static ModelLayerLocation LEAF_FLY = create("leaf_fly");
    public static ModelLayerLocation DRAGONFISH = create("dragonfish");
    public static ModelLayerLocation LEAF_DARTFISH = create("leaf_dartfish");
    public static ModelLayerLocation COLLECTOR = create("collector");
    public static ModelLayerLocation COIN_FROG = create("coin_frog");
    public static ModelLayerLocation COIN_FROG_TADPOLE = create("coin_frog_tadpole");

    private static final ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(LittleBeasties.MOD_ID, name), name);
    }
}
