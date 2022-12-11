package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.CoinFrogTadpoleModel;
import coda.littlebeasties.common.entities.CoinFrogTadpole;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoinFrogTadpoleRenderer extends MobRenderer<CoinFrogTadpole, EntityModel<CoinFrogTadpole>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/coin_frog/tadpole.png");

	public CoinFrogTadpoleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoinFrogTadpoleModel(renderManagerIn.bakeLayer(LBModelLayers.COIN_FROG_TADPOLE)), 0.1F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(CoinFrogTadpole entity) {
		return TEXTURE;
	}

}
