package coda.littlebeasties.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class LeafFlyModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Rightwing;
	private final ModelPart Leftwing;

	public LeafFlyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = Body.getChild("Tail");
		this.Rightwing = Body.getChild("Rightwing");
		this.Leftwing = Body.getChild("Leftwing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).mirror().addBox(-2.5F, -1.5F, -2.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(1.5F, -1.5F, -2.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(1.0F, -2.5F, -2.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-1.0F, -2.5F, -2.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.5F, -2.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(21, 1).addBox(0.5F, 0.0F, 4.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(21, 1).mirror().addBox(-2.5F, 0.0F, 4.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.0F, 2.5F));

		PartDefinition Rightwing = Body.addOrReplaceChild("Rightwing", CubeListBuilder.create().texOffs(7, 3).mirror().addBox(0.0F, 0.0F, -1.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, -1.5F, 0.5F));

		PartDefinition Leftwing = Body.addOrReplaceChild("Leftwing", CubeListBuilder.create().texOffs(7, 3).addBox(-6.0F, 0.0F, -1.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.5F, 0.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!entity.isOnGround()) {
			
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}