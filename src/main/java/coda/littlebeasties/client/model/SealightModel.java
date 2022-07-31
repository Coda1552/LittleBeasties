package coda.littlebeasties.client.model;

import java.util.Map;

import com.google.common.collect.Maps;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.common.entities.SealightEntity;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SealightModel extends AnimatedGeoModel<SealightEntity> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_1.png"));
        hashMap.put(1, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_2.png"));
        hashMap.put(2, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_3.png"));
        hashMap.put(3, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_4.png"));
        hashMap.put(4, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_5.png"));
    });

    @Override
    public ResourceLocation getModelLocation(SealightEntity object) {
        return new ResourceLocation(LittleBeasties.MOD_ID, "geo/sealight.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SealightEntity object) {
        return TEXTURES.getOrDefault(object.getVariant(), TEXTURES.get(0));
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SealightEntity animatable) {
        return /*new ResourceLocation(LittleBeasties.MOD_ID, "animations/sealight.animation.json")*/ null;
    }
}
