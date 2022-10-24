package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.DragonfishModel;
import coda.littlebeasties.common.entities.Dragonfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DragonfishRenderer extends MobRenderer<Dragonfish, EntityModel<Dragonfish>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/dragonfish.png");

	public DragonfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DragonfishModel(renderManagerIn.bakeLayer(LBModelLayers.DRAGONFISH)), 0.3F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Dragonfish entity) {
		return TEXTURE;
	}

	@Override
	protected void setupRotations(Dragonfish fish, PoseStack stack, float p_115319_, float p_115320_, float p_115321_) {
		super.setupRotations(fish, stack, p_115319_, p_115320_, p_115321_);

		if (!fish.isInWater()) {
			stack.translate(0.2F, 0.1F, 0.0D);
			stack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}
