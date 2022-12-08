package coda.littlebeasties.client.model;

import coda.littlebeasties.common.entities.LeafDartfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class LeafDartfishModel extends EntityModel<LeafDartfish> {
	private final ModelPart body;
	private final ModelPart dorsalFin;
	private final ModelPart caudalFin;
	private final ModelPart analFin;

	public LeafDartfishModel(ModelPart root) {
		this.body = root.getChild("body");
		this.dorsalFin = body.getChild("dorsalFin");
		this.caudalFin = dorsalFin.getChild("caudalFin");
		this.analFin = caudalFin.getChild("analFin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, -1).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition dorsalFin = body.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition caudalFin = dorsalFin.addOrReplaceChild("caudalFin", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition analFin = caudalFin.addOrReplaceChild("analFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(LeafDartfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.y = Mth.cos(ageInTicks * 0.35F) * 0.75F + 22.5F;
		this.body.xRot = Mth.cos(1.0F - ageInTicks * 0.35F) * 0.1F;
		this.body.zRot = Mth.cos(ageInTicks * 0.35F) * 0.05F;
		this.dorsalFin.yRot = Mth.cos(ageInTicks * 0.5F) * 0.1F;
		this.dorsalFin.zRot = Mth.cos(ageInTicks * 0.5F) * 0.1F;


	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}