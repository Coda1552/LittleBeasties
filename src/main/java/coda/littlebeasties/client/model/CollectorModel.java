package coda.littlebeasties.client.model;

import coda.littlebeasties.common.entities.Collector;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CollectorModel extends EntityModel<Collector> {
	private final ModelPart body;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart fin;
	private final ModelPart rightEye;
	private final ModelPart leftEye;
	private final ModelPart rightAntenna;
	private final ModelPart leftAntenna;
	private final ModelPart rightBag;
	private final ModelPart leftBag;
	private final ModelPart rightArm;
	private final ModelPart rightHand;
	private final ModelPart leftArm;
	private final ModelPart leftHand;

	public CollectorModel(ModelPart root) {
		this.body = root.getChild("Body");
		this.rightLeg = body.getChild("RightLeg");
		this.leftLeg = body.getChild("LeftLeg");
		this.rightAntenna = body.getChild("RightAntenna");
		this.leftAntenna = body.getChild("LeftAntenna");
		this.tail = body.getChild("Tail");
		this.tail2 = tail.getChild("Tail2");
		this.fin = tail2.getChild("Fin");
		this.rightEye = body.getChild("RightEye");
		this.leftEye = body.getChild("LeftEye");
		this.rightBag = body.getChild("RightBag");
		this.leftBag = body.getChild("LeftBag");
		this.rightArm = body.getChild("RightArm");
		this.rightHand = rightArm.getChild("RightHand");
		this.leftArm = body.getChild("LeftArm");
		this.leftHand = leftArm.getChild("LeftHand");
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
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.7F) * 1.4F * limbSwingAmount * 0.5F;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.7F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;

		this.rightAntenna.xRot = Mth.cos(limbSwing * 0.8F) * 0.4F * limbSwingAmount * 0.5F;
		this.rightAntenna.zRot = Mth.cos(-1.0F + limbSwing * 0.8F) * 0.4F * limbSwingAmount * 0.5F + 0.2F;
		this.leftAntenna.xRot = Mth.cos(limbSwing * 0.8F + (float)Math.PI) * 0.4F * limbSwingAmount * 0.5F;
		this.leftAntenna.zRot = Mth.cos(-1.0F + limbSwing * 0.8F + (float)Math.PI) * 0.4F * limbSwingAmount * 0.5F - 0.2F;

		this.tail.xRot = Mth.cos(limbSwing * 0.7F) * 0.25F * limbSwingAmount - 0.2F;
		this.tail.zRot = Mth.cos(limbSwing * 0.35F) * 0.15F * limbSwingAmount;
		this.fin.xRot = Mth.cos(limbSwing * 1.2F) * 0.5F * limbSwingAmount;

		this.leftBag.y = Mth.cos(-3.0F + limbSwing * 0.85F) * limbSwingAmount * 1.0F + 2.0F;
		this.rightBag.y = Mth.cos(-1.0F + limbSwing * 0.85F) * limbSwingAmount * 1.0F + 2.0F;

		this.rightArm.xRot = Mth.cos(limbSwing * 0.7F) * limbSwingAmount * 0.3F - 0.45F;
		this.rightHand.xRot = Mth.cos(-1.0F + limbSwing * 0.7F) * limbSwingAmount * 0.5F + 0.45F;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.7F + (float)Math.PI) * limbSwingAmount * 0.3F - 0.45F;
		this.leftHand.xRot = Mth.cos(-1.0F + limbSwing * 0.7F + (float)Math.PI) * limbSwingAmount * 0.5F + 0.45F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}