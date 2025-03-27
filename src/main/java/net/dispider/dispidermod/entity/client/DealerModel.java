package net.dispider.dispidermod.entity.client;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dispider.dispidermod.entity.custom.DealerEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class DealerModel<T extends DealerEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "dealer"), "main");
	private final ModelPart Ola;
	private final ModelPart head;

	public DealerModel(ModelPart root) {
		this.Ola = root.getChild("full");
		this.head = Ola.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition full = partdefinition.addOrReplaceChild("full", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = full.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition leg1 = legs.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(52, 70).addBox(4.0F, 13.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 66).addBox(4.0F, 14.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 46).addBox(4.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(38, 70).addBox(-6.0F, 14.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 46).addBox(-6.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 70).addBox(-6.0F, 13.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hands = full.addOrReplaceChild("hands", CubeListBuilder.create(), PartPose.offset(13.0F, -25.0F, 0.0F));

		PartDefinition leftarm = hands.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(38, 64).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -6.0F, 0.0F));

		PartDefinition cube_r1 = leftarm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(66, 34).addBox(-0.5F, -6.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 10.0F, -3.0F, -0.1212F, 0.5662F, 1.6613F));

		PartDefinition cube_r2 = leftarm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(54, 50).addBox(-0.5F, -5.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 8.0F, 0.0F, 0.6109F, 0.0F, -3.0543F));

		PartDefinition cube_r3 = leftarm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(54, 28).addBox(-1.0F, -6.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.0543F));

		PartDefinition cube_r4 = leftarm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(64, 7).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.7925F));

		PartDefinition cube_r5 = leftarm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(66, 28).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftarm2 = hands.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(66, 44).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, -6.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r6 = leftarm2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 60).addBox(-0.5F, -5.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.0F, 0.0F, -0.2182F, 0.0F, -3.0543F));

		PartDefinition cube_r7 = leftarm2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(66, 56).addBox(-0.5F, -6.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 10.0F, 2.0F, -0.0007F, 0.5382F, 1.561F));

		PartDefinition cube_r8 = leftarm2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(54, 39).addBox(-1.0F, -6.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.0543F));

		PartDefinition cube_r9 = leftarm2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 14).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.7925F));

		PartDefinition cube_r10 = leftarm2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(66, 50).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition body = full.addOrReplaceChild("body", CubeListBuilder.create().texOffs(54, 22).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-7.0F, -21.0F, -3.0F, 14.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition head = full.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-8.0F, -50.0F, -6.0F, 16.0F, 13.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -55.0F, -8.0F, 18.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cigar = head.addOrReplaceChild("cigar", CubeListBuilder.create().texOffs(64, 0).addBox(1.0F, -40.0F, -12.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return Ola;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(pNetHeadYaw, pHeadPitch);

		this.animateWalk(DealerAnimations.walk, pLimbSwing, pLimbSwingAmount, 2f, 2.5f);
		this.animate(pEntity.idleAnimation, DealerAnimations.idle, pAgeInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,int color) {
		Ola.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}