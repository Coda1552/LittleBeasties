package coda.littlebeasties.registry;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.common.entities.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LBEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, LittleBeasties.MOD_ID);

    public static final RegistryObject<EntityType<Sealight>> SEALIGHT = create("sealight", EntityType.Builder.of(Sealight::new, MobCategory.WATER_AMBIENT).sized(0.3F, 0.4F));
    public static final RegistryObject<EntityType<BlueSailfish>> BLUE_SAILFISH = create("blue_sailfish", EntityType.Builder.of(BlueSailfish::new, MobCategory.WATER_AMBIENT).sized(0.25F, 0.25F));
    public static final RegistryObject<EntityType<Dugoin>> DUGOIN = create("dugoin", EntityType.Builder.of(Dugoin::new, MobCategory.CREATURE).sized(0.65F, 0.6F));
    public static final RegistryObject<EntityType<LeafFly>> LEAF_FLY = create("leaf_fly", EntityType.Builder.of(LeafFly::new, MobCategory.CREATURE).sized(0.55F, 0.2F));
    public static final RegistryObject<EntityType<Dragonfish>> DRAGONFISH = create("dragonfish", EntityType.Builder.of(Dragonfish::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.35F));
    public static final RegistryObject<EntityType<LeafDartfish>> LEAF_DARTFISH = create("leaf_dartfish", EntityType.Builder.of(LeafDartfish::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(LittleBeasties.MOD_ID + "." + name));
    }
}
