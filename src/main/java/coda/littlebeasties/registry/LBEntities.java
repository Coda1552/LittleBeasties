package coda.littlebeasties.registry;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.common.entities.SealightEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LBEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, LittleBeasties.MOD_ID);

    public static final RegistryObject<EntityType<SealightEntity>> SEALIGHT = create("sealight", EntityType.Builder.of(SealightEntity::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.4F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(LittleBeasties.MOD_ID + "." + name));
    }
}
