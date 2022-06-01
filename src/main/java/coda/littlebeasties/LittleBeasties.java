package coda.littlebeasties;

import coda.littlebeasties.common.entities.SealightEntity;
import coda.littlebeasties.registry.LBEntities;
import coda.littlebeasties.registry.LBItems;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LittleBeasties.MOD_ID)
public class LittleBeasties {
    public static final String MOD_ID = "littlebeasties";

    public LittleBeasties() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LBEntities.ENTITIES.register(bus);
        LBItems.ITEMS.register(bus);

        bus.addListener(this::createAttributes);
    }

    private void createAttributes(EntityAttributeCreationEvent event) {
        event.put(LBEntities.SEALIGHT.get(), SealightEntity.createAttributes().build());
    }
}
