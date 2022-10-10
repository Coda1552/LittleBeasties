package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.BlueSailfishModel;
import coda.littlebeasties.client.model.DragonfishModel;
import coda.littlebeasties.common.entities.BlueSailfish;
import coda.littlebeasties.common.entities.Dragonfish;
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

}
