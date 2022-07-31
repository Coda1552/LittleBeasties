package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.ClientEvents;
import coda.littlebeasties.client.model.BlueSailfishModel;
import coda.littlebeasties.common.entities.BlueSailfish;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlueSailfishRenderer extends MobRenderer<BlueSailfish, EntityModel<BlueSailfish>> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/blue_sailfish/blue_sailfish.png");
	
	public BlueSailfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BlueSailfishModel(renderManagerIn.bakeLayer(ClientEvents.BLUE_SAILFISH)), 0.375F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(BlueSailfish entity) {
		return TEXTURE;
	}

}
