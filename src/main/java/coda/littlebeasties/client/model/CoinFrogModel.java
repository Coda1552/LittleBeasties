package coda.littlebeasties.client.model;

import coda.littlebeasties.common.entities.CoinFrog;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CoinFrogModel extends EntityModel<CoinFrog> {
	private final ModelPart body;
	private final ModelPart rightLeg;
	private final ModelPart rightLeg2;
	private final ModelPart leftLeg;
	private final ModelPart leftLeg2;

	public CoinFrogModel(ModelPart root) {
		this.body = root.getChild("Body");
		this.rightLeg = body.getChild("RightLeg");
		this.rightLeg2 = body.getChild("RightLeg2");
		this.leftLeg = body.getChild("LeftLeg");
		this.leftLeg2 = body.getChild("LeftLeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.0F, -2.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, 0.0F, -1.5F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -0.5F));

		PartDefinition RightLeg2 = Body.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(6, 8).mirror().addBox(0.0F, 0.0F, -0.5F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 2.5F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(-2.0F, 0.0F, -1.5F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, -0.5F));

		PartDefinition LeftLeg2 = Body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(6, 8).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 2.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(CoinFrog entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}