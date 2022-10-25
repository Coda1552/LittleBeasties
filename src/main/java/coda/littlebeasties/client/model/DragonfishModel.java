package coda.littlebeasties.client.model;

import coda.littlebeasties.common.entities.Dragonfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DragonfishModel extends EntityModel<Dragonfish> {
	private final ModelPart Body;
	private final ModelPart DorsalFin;
	private final ModelPart CaudalFin;
	private final ModelPart AnalFin;
	private final ModelPart RightPectoralFin;
	private final ModelPart LeftPectoralFin;
	private final ModelPart RightBarble;
	private final ModelPart LeftBarble;

	public DragonfishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.CaudalFin = Body.getChild("CaudalFin");
		this.LeftPectoralFin = Body.getChild("LeftPectoralFin");
		this.RightPectoralFin = Body.getChild("RightPectoralFin");
		this.DorsalFin = Body.getChild("DorsalFin");
		this.AnalFin = Body.getChild("AnalFin");
		this.RightBarble = Body.getChild("RightBarble");
		this.LeftBarble = Body.getChild("LeftBarble");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, -5.0F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, -2.0F));

		PartDefinition DorsalFin = Body.addOrReplaceChild("DorsalFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -1.0F));

		PartDefinition CaudalFin = Body.addOrReplaceChild("CaudalFin", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition AnalFin = Body.addOrReplaceChild("AnalFin", CubeListBuilder.create().texOffs(20, 18).addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 4.0F));

		PartDefinition RightPectoralFin = Body.addOrReplaceChild("RightPectoralFin", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.5F, -1.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition LeftPectoralFin = Body.addOrReplaceChild("LeftPectoralFin", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition RightBarble = Body.addOrReplaceChild("RightBarble", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.5F, -4.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LeftBarble = Body.addOrReplaceChild("LeftBarble", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -0.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.5F, -4.5F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Dragonfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float degree = 1.0f;
		float speed = 0.75f;

		//limbSwing = ageInTicks * 0.3F;
		//limbSwingAmount = 0.2F;

		this.CaudalFin.yRot = Mth.cos(limbSwing * speed * 2.0F) * degree * limbSwingAmount;

		this.LeftPectoralFin.yRot = -Mth.sin(1.0F + limbSwing * speed) * degree * limbSwingAmount - 0.5F;
		this.RightPectoralFin.yRot = Mth.sin(1.0F + limbSwing * speed) * degree * limbSwingAmount + 0.5F;
		this.DorsalFin.zRot = Mth.sin(1.0F + limbSwing * speed) * degree * limbSwingAmount;

		this.LeftBarble.zRot = Mth.cos(1.0F + limbSwing * speed) * 0.6F * degree * limbSwingAmount + 0.15F;
		this.RightBarble.zRot = Mth.cos(1.0F + limbSwing * speed) * 0.6F * degree * limbSwingAmount - 0.15F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}