package net.dispider.dispidermod.entity.client;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dispider.dispidermod.entity.custom.mob.GronEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GronModel<T extends GronEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "superzombie"), "main");
	private final ModelPart gron;
	private final ModelPart leg1;
	private final ModelPart bone;
	private final ModelPart arm1;
	private final ModelPart arm2;
	private final ModelPart leg2;
	private final ModelPart bone4;

	public GronModel(ModelPart root) {
		this.gron = root.getChild("gron");
		this.leg1 = this.gron.getChild("leg1");
		this.bone = this.gron.getChild("bone");
		this.arm1 = this.gron.getChild("arm1");
		this.arm2 = this.gron.getChild("arm2");
		this.leg2 = this.gron.getChild("leg2");
		this.bone4 = this.gron.getChild("bone4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gron = partdefinition.addOrReplaceChild("gron", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leg1 = gron.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(48, 44).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = gron.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 34).addBox(-5.0F, -19.0F, -5.0F, 10.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm1 = gron.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(40, 34).addBox(-1.0F, -19.0F, -7.0F, 19.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm2 = gron.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(40, 39).addBox(-1.0F, -19.0F, 5.0F, 19.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = gron.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(40, 44).addBox(-1.0F, -8.0F, 2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone4 = gron.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -16.0F, -9.0F, 14.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}




	@Override
	public ModelPart root() {
		return this.gron;
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
		super.renderToBuffer(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

	}
}