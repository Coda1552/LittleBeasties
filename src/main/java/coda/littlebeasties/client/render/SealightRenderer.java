package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.SealightModel;
import coda.littlebeasties.client.render.layer.SealightGlowLayer;
import coda.littlebeasties.common.entities.Sealight;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Cod;

import java.util.Map;

public class SealightRenderer extends MobRenderer<Sealight, EntityModel<Sealight>> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(0, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_1.png"));
		hashMap.put(1, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_2.png"));
		hashMap.put(2, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_3.png"));
		hashMap.put(3, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_4.png"));
		hashMap.put(4, new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_5.png"));
	});

	public SealightRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SealightModel<>(renderManagerIn.bakeLayer(LBModelLayers.SEALIGHT)), 0.375F);
		this.addLayer(new SealightGlowLayer(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(Sealight entity) {
		return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
	}

	protected void setupRotations(Sealight p_114017_, PoseStack p_114018_, float p_114019_, float p_114020_, float p_114021_) {
		super.setupRotations(p_114017_, p_114018_, p_114019_, p_114020_, p_114021_);
		float f = 4.3F * Mth.sin(0.6F * p_114019_);
		p_114018_.mulPose(Vector3f.YP.rotationDegrees(f));
		if (!p_114017_.isInWater()) {
			p_114018_.translate((double)0.1F, (double)0.1F, (double)-0.1F);
			p_114018_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}

	}
}
