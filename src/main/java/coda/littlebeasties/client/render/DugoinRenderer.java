package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.ClientEvents;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.DugoinModel;
import coda.littlebeasties.common.entities.Dugoin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DugoinRenderer extends MobRenderer<Dugoin, EntityModel<Dugoin>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/dugoin/dugoin.png");
	
	public DugoinRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DugoinModel(renderManagerIn.bakeLayer(LBModelLayers.DUGOIN)), 0.375F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Dugoin entity) {
		return TEXTURE;
	}

}
