package coda.littlebeasties.client.render;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.LBModelLayers;
import coda.littlebeasties.client.model.CollectorModel;
import coda.littlebeasties.common.entities.Collector;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CollectorRenderer extends MobRenderer<Collector, EntityModel<Collector>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/collector.png");

	public CollectorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CollectorModel(renderManagerIn.bakeLayer(LBModelLayers.COLLECTOR)), 0.5F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Collector entity) {
		return TEXTURE;
	}

}
