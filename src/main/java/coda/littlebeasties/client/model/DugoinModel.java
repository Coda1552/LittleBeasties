package coda.littlebeasties.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import coda.littlebeasties.common.entities.Dugoin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class DugoinModel extends EntityModel<Dugoin> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart TailFin;
	private final ModelPart Head;
	private final ModelPart LeftForelegFur;
	private final ModelPart RightForelegFur;
	private final ModelPart RightHintLegFur;
	private final ModelPart LeftHintlegFur;

	public DugoinModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = Body.getChild("Tail");
		this.TailFin = Tail.getChild("TailFin");
		this.Head = Body.getChild("Head");
		this.LeftForelegFur = Body.getChild("LeftForelegFur");
		this.RightForelegFur = Body.getChild("RightForelegfur");
		this.RightHintLegFur = Body.getChild("RightHintLegFur");
		this.LeftHintlegFur = Body.getChild("LeftHintlegFur");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition TailFin = Tail.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(9, 26).addBox(0.0F, -3.5F, -1.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition RightSideFin = Body.addOrReplaceChild("RightSideFin", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, -0.6F));

		PartDefinition RightSideFin_r1 = RightSideFin.addOrReplaceChild("RightSideFin_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 39).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -3.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(19, 41).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -3.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftForelegFur = Body.addOrReplaceChild("LeftForelegFur", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, -1.5F));

		PartDefinition LeftForeleg = LeftForelegFur.addOrReplaceChild("LeftForeleg", CubeListBuilder.create().texOffs(47, 49).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition RightForelegfur = Body.addOrReplaceChild("RightForelegfur", CubeListBuilder.create(), PartPose.offset(2.0F, 2.0F, -1.5F));

		PartDefinition RightForelegfur_r1 = RightForelegfur.addOrReplaceChild("RightForelegfur_r1", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(0.5F, -6.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 5.0F, 1.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition RightForeleg = RightForelegfur.addOrReplaceChild("RightForeleg", CubeListBuilder.create().texOffs(47, 49).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.05F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LeftSideFin = Body.addOrReplaceChild("LeftSideFin", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, -0.5F));

		PartDefinition LeftSideFin_r1 = LeftSideFin.addOrReplaceChild("LeftSideFin_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition RightHintLegFur = Body.addOrReplaceChild("RightHintLegFur", CubeListBuilder.create().texOffs(34, 47).mirror().addBox(-1.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 1.0F, 3.0F));

		PartDefinition RightHintleg = RightHintLegFur.addOrReplaceChild("RightHintleg", CubeListBuilder.create().texOffs(47, 49).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 3.0F, 1.0F));

		PartDefinition LeftHintlegFur = Body.addOrReplaceChild("LeftHintlegFur", CubeListBuilder.create().texOffs(34, 47).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, 3.0F));

		PartDefinition LeftHintleg = LeftHintlegFur.addOrReplaceChild("LeftHintleg", CubeListBuilder.create().texOffs(47, 49).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Dugoin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		if (entity.isInWater()) {
			this.Body.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 0.5F * limbSwingAmount;
			this.Tail.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * -0.55F * limbSwingAmount;
			this.TailFin.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * -0.55F * limbSwingAmount;
			this.Head.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 0.55F * limbSwingAmount;
			this.LeftForelegFur.xRot = Mth.cos(3.0F + limbSwing* speed * 0.3F) * degree * 1.0F * limbSwingAmount;
			this.RightForelegFur.xRot = Mth.cos(limbSwing* speed * 0.3F) * degree * 1.0F * limbSwingAmount;
			this.RightHintLegFur.xRot = Mth.cos(2.0F + limbSwing* speed * 0.3F) * degree * 1.0F * limbSwingAmount;
			this.LeftHintlegFur.xRot = Mth.cos(1.0F + limbSwing* speed * 0.3F) * degree * 1.0F * limbSwingAmount;
		} else {
			this.Tail.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * -0.15F * limbSwingAmount;
			this.TailFin.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * -0.15F * limbSwingAmount;
			this.Head.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount;
			this.LeftHintlegFur.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount;
			this.RightHintLegFur.xRot = Mth.cos(1.5F + limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount;
			this.LeftForelegFur.xRot = Mth.cos(1.5F + limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount;
			this.RightForelegFur.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}