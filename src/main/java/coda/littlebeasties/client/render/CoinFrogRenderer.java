package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.CoinFrogModel;
import coda.littlebeasties.common.entities.CoinFrog;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoinFrogRenderer extends MobRenderer<CoinFrog, EntityModel<CoinFrog>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/coin_frog/coin_frog.png");

	public CoinFrogRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoinFrogModel(renderManagerIn.bakeLayer(LBModelLayers.COIN_FROG)), 0.1F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(CoinFrog entity) {
		return TEXTURE;
	}

}
