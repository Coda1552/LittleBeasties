package coda.littlebeasties.client.render.layer;

import coda.littlebeasties.LittleBeasties;
import coda.littlebeasties.client.model.SealightModel;
import coda.littlebeasties.common.entities.Sealight;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SealightGlowLayer<T extends Sealight, M extends SealightModel<T>> extends RenderLayer<T, M> {
    public static final ResourceLocation EYES = new ResourceLocation(LittleBeasties.MOD_ID, "textures/entity/sealight/sealight_e.png");

    public SealightGlowLayer(RenderLayerParent<T, M> p_116981_) {
        super(p_116981_);
    }

    public void render(PoseStack p_116983_, MultiBufferSource p_116984_, int p_116985_, T p_116986_, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
        VertexConsumer vertexconsumer = p_116984_.getBuffer(RenderType.eyes(EYES));
        this.getParentModel().renderToBuffer(p_116983_, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.75F);
    }

}