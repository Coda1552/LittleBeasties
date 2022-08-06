package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.LeafFlyModel;
import coda.littlebeasties.common.entities.LeafFly;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LeafFlyRenderer extends MobRenderer<LeafFly, EntityModel<LeafFly>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/leaf_fly/leaf_fly.png");

	public LeafFlyRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LeafFlyModel(renderManagerIn.bakeLayer(LBModelLayers.LEAF_FLY)), 0.3F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(LeafFly entity) {
		return TEXTURE;
	}

}
