package coda.littlebeasties.client.model;

import coda.littlebeasties.common.entities.Collector;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CollectorModel extends EntityModel<Collector> {
	private final ModelPart Body;

	public CollectorModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -7.0F, -5.5F, 11.0F, 14.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-2.5F, -7.0F, -11.5F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 59).addBox(-6.0F, 2.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(46, 46).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 7.0F, 1.5F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(46, 46).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 7.0F, 1.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 26).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 74).addBox(-4.0F, -1.5F, 0.5F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 5.5F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(45, 25).addBox(-2.5F, 0.0F, -7.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 8.0F));

		PartDefinition Fin = Tail2.addOrReplaceChild("Fin", CubeListBuilder.create().texOffs(44, 9).addBox(-3.5F, -0.5F, -4.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, -5.0F));

		PartDefinition RightEye = Body.addOrReplaceChild("RightEye", CubeListBuilder.create().texOffs(19, 48).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -7.0F, 1.5F));

		PartDefinition LeftEye = Body.addOrReplaceChild("LeftEye", CubeListBuilder.create().texOffs(19, 48).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -7.0F, 1.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -5.5F, -0.3927F, -0.3927F, 0.0F));

		PartDefinition RightHand = RightArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(2, 3).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -5.5F, -0.3927F, 0.3927F, 0.0F));

		PartDefinition LeftHand = LeftArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(2, 3).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition RightAntenna = Body.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(33, 0).addBox(-0.5F, -9.0F, 0.0F, 13.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -7.0F, -10.5F));

		PartDefinition LeftAntenna = Body.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-12.5F, -9.0F, 0.0F, 13.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -7.0F, -10.5F));

		PartDefinition RightBag = Body.addOrReplaceChild("RightBag", CubeListBuilder.create().texOffs(5, 63).addBox(0.0F, -1.0F, -3.5F, 3.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 74).addBox(1.0F, 7.0F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, 0.5F));

		PartDefinition LeftBag = Body.addOrReplaceChild("LeftBag", CubeListBuilder.create().texOffs(5, 63).mirror().addBox(-3.0F, -1.0F, -3.5F, 3.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 74).mirror().addBox(-1.0F, 7.0F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 2.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Collector entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}