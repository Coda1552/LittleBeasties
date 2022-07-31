package coda.littlebeasties.client;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.model.BlueSailfishModel;
import coda.littlebeasties.client.model.DugoinModel;
import coda.littlebeasties.client.render.BlueSailfishRenderer;
import coda.littlebeasties.client.render.DugoinRenderer;
import coda.littlebeasties.client.render.SealightRenderer;
import coda.littlebeasties.registry.LBEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LittleBeasties.MOD_ID)
public class ClientEvents {
	
	public static ModelLayerLocation BLUE_SAILFISH = new ModelLayerLocation(new ResourceLocation(LittleBeasties.MOD_ID, "blue_sailfish"), "blue_sailfish");
	public static ModelLayerLocation DUGOIN = new ModelLayerLocation(new ResourceLocation(LittleBeasties.MOD_ID, "dugoin"), "dugoin");

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(LBEntities.SEALIGHT.get(), SealightRenderer::new);
        EntityRenderers.register(LBEntities.DUGOIN.get(), DugoinRenderer::new);
    }
    
    @SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
    	event.registerEntityRenderer(LBEntities.BLUE_SAILFISH.get(), BlueSailfishRenderer::new);
    	event.registerEntityRenderer(LBEntities.DUGOIN.get(), DugoinRenderer::new);
    }
    
    @SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
    	event.registerLayerDefinition(BLUE_SAILFISH, BlueSailfishModel::createBodyLayer);
    	event.registerLayerDefinition(DUGOIN, DugoinModel::createBodyLayer);
    }
}
