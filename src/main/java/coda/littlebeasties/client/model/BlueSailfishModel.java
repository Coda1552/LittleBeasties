package coda.littlebeasties.client.model;

import coda.littlebeasties.common.entities.BlueSailfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BlueSailfishModel extends EntityModel<BlueSailfish> {
	private final ModelPart Body;
	private final ModelPart CaudalFin;
	private final ModelPart LeftPectoralFin;
	private final ModelPart RightPectoralFin;
	private final ModelPart DorsalFin;

	public BlueSailfishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.CaudalFin = Body.getChild("CaudalFin");
		this.LeftPectoralFin = Body.getChild("LeftPectoralFin");
		this.RightPectoralFin = Body.getChild("RightPectoralFin");
		this.DorsalFin = Body.getChild("DorsalFin");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 1).addBox(0.0F, 0.5F, 0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.5F));

		PartDefinition RightPectoralFin = Body.addOrReplaceChild("RightPectoralFin", CubeListBuilder.create().texOffs(6, 5).addBox(0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

		PartDefinition LeftPectoralFin = Body.addOrReplaceChild("LeftPectoralFin", CubeListBuilder.create().texOffs(6, 5).mirror().addBox(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));

		PartDefinition CaudalFin = Body.addOrReplaceChild("CaudalFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.5F));

		PartDefinition DorsalFin = Body.addOrReplaceChild("DorsalFin", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -0.5F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(BlueSailfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.CaudalFin.yRot = Mth.cos(ageInTicks * 0.8F) * 0.45F;
		if (entity.areFinsOpen()) {
			this.LeftPectoralFin.yRot = Mth.cos(ageInTicks * 0.5F) * 0.45F + 0.5F;
			this.RightPectoralFin.yRot = Mth.cos(ageInTicks * 0.5F + Mth.PI) * 0.45F - 0.5F;
		}
		else {
			this.LeftPectoralFin.yRot = Mth.cos(ageInTicks * 0.25F) * 0.25F + 0.5F;
			this.RightPectoralFin.yRot = Mth.cos(ageInTicks * 0.256F + Mth.PI) * 0.25F - 0.5F;

		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}