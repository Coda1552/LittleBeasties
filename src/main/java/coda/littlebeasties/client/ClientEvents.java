package coda.littlebeasties.client;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.render.SealightRenderer;
import coda.littlebeasties.registry.LBEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LittleBeasties.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(LBEntities.SEALIGHT.get(), SealightRenderer::new);
    }
}
