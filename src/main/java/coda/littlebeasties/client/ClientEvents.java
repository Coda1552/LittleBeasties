package coda.littlebeasties.client;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.model.BlueSailfishModel;
import coda.littlebeasties.client.model.DugoinModel;
import coda.littlebeasties.client.model.LeafFlyModel;
import coda.littlebeasties.client.model.SealightModel;
import coda.littlebeasties.client.render.BlueSailfishRenderer;
import coda.littlebeasties.client.render.DugoinRenderer;
import coda.littlebeasties.client.render.LeafFlyRenderer;
import coda.littlebeasties.client.render.SealightRenderer;
import coda.littlebeasties.registry.LBEntities;
import coda.littlebeasties.registry.LBItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LittleBeasties.MOD_ID)
public class ClientEvents {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ItemProperties.register(LBItems.SEALIGHT_BUCKET.get(), new ResourceLocation(LittleBeasties.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getTag().getInt("Variant") : 0);
	}

    @SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
    	event.registerEntityRenderer(LBEntities.BLUE_SAILFISH.get(), BlueSailfishRenderer::new);
    	event.registerEntityRenderer(LBEntities.DUGOIN.get(), DugoinRenderer::new);
    	event.registerEntityRenderer(LBEntities.SEALIGHT.get(), SealightRenderer::new);
    	event.registerEntityRenderer(LBEntities.LEAF_FLY.get(), LeafFlyRenderer::new);
    }
    
    @SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
    	event.registerLayerDefinition(LBModelLayers.BLUE_SAILFISH, BlueSailfishModel::createBodyLayer);
    	event.registerLayerDefinition(LBModelLayers.DUGOIN, DugoinModel::createBodyLayer);
    	event.registerLayerDefinition(LBModelLayers.SEALIGHT, SealightModel::createBodyLayer);
    	event.registerLayerDefinition(LBModelLayers.LEAF_FLY, LeafFlyModel::createBodyLayer);
    }
}
