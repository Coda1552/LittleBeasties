package coda.littlebeasties.client.model.layers;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.common.entities.SealightEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class SealightGlowLayer extends GeoLayerRenderer<SealightEntity> {
    private static final ResourceLocation MODEL = new ResourceLocation(LittleBeasties.MOD_ID, "geo/sealight.geo.json");
    private static final ResourceLocation OVERLAY = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_1.png");

    public SealightGlowLayer(IGeoRenderer<SealightEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, SealightEntity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType cameo = RenderType.eyes(OVERLAY);
        this.getRenderer().render(this.getEntityModel().getModel(MODEL), entityLivingBaseIn, partialTicks, cameo, matrixStackIn, bufferIn,
                bufferIn.getBuffer(cameo), 15000, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1.0f);
    }
}
