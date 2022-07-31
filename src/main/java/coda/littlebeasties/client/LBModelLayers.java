package coda.littlebeasties.client;

import coda.littlebeasties.LittleBeasties;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class LBModelLayers {
    public static ModelLayerLocation BLUE_SAILFISH = create("blue_sailfish");
    public static ModelLayerLocation DUGOIN = create("dugoin");
    public static ModelLayerLocation SEALIGHT = create("sealight");

    private static final ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(LittleBeasties.MOD_ID, name), name);
    }
}
