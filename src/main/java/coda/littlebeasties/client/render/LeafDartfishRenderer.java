package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.LeafDartfishModel;
import coda.littlebeasties.common.entities.LeafDartfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class LeafDartfishRenderer extends MobRenderer<LeafDartfish, EntityModel<LeafDartfish>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/leaf_dartfish.png");

	public LeafDartfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LeafDartfishModel(renderManagerIn.bakeLayer(LBModelLayers.LEAF_DARTFISH)), 0.3F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(LeafDartfish entity) {
		return TEXTURE;
	}

	@Override
	protected void setupRotations(LeafDartfish fish, PoseStack stack, float p_115319_, float p_115320_, float p_115321_) {
		super.setupRotations(fish, stack, p_115319_, p_115320_, p_115321_);

		if (!fish.isInWater()) {
			stack.translate(0.2F, 0.1F, 0.0D);
			stack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}
