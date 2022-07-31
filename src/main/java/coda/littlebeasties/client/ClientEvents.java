package coda.littlebeasties.client;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.model.BlueSailfishModel;
import coda.littlebeasties.client.model.DugoinModel;
import coda.littlebeasties.client.render.BlueSailfishRenderer;
import coda.littlebeasties.client.render.DugoinRenderer;
import coda.littlebeasties.registry.LBEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LittleBeasties.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
    	event.registerEntityRenderer(LBEntities.BLUE_SAILFISH.get(), BlueSailfishRenderer::new);
    	event.registerEntityRenderer(LBEntities.DUGOIN.get(), DugoinRenderer::new);
    }
    
    @SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
    	event.registerLayerDefinition(LBModelLayers.BLUE_SAILFISH, BlueSailfishModel::createBodyLayer);
    	event.registerLayerDefinition(LBModelLayers.DUGOIN, DugoinModel::createBodyLayer);
    }
}
