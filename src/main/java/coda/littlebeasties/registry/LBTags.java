package coda.littlebeasties.registry;

import coda.littlebeasties.LittleBeasties;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class LBTags {
    public static final TagKey<EntityType<?>> BLUE_SAILFISH_PREDATORS = entityTag("blue_sailfish_predators");

    private static TagKey<EntityType<?>> entityTag(String name) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(LittleBeasties.MOD_ID, name));
    }
}
