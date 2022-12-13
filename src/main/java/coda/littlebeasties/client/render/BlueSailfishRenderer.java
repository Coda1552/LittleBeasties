package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.BlueSailfishModel;
import coda.littlebeasties.common.entities.BlueSailfish;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlueSailfishRenderer extends MobRenderer<BlueSailfish, EntityModel<BlueSailfish>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/blue_sailfish/blue_sailfish.png");
	private static final ResourceLocation OPEN_FINS = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/blue_sailfish/open_fins.png");

	public BlueSailfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BlueSailfishModel(renderManagerIn.bakeLayer(LBModelLayers.BLUE_SAILFISH)), 0.1F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(BlueSailfish entity) {
		return entity.areFinsOpen() ? OPEN_FINS : TEXTURE;
	}

}
