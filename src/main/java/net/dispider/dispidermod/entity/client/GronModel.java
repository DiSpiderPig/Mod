package net.dispider.dispidermod.entity.client;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dispider.dispidermod.DiSpiderMod;
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

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, "gron_layer"), "main");
	private final ModelPart body;
	/*private final ModelPart leg1;
	private final ModelPart bone;
	private final ModelPart arm1;
	private final ModelPart arm2;
	private final ModelPart leg2;
	private final ModelPart bone4;*/

	public GronModel(ModelPart root) {
		this.body = root.getChild("body");
		/*this.leg1 = root.getChild("leg1");
		this.bone = root.getChild("bone");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
		this.leg2 = root.getChild("leg2");
		this.bone4 = root.getChild("bone4");*/
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(48, 44).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 34).addBox(-5.0F, -19.0F, -5.0F, 10.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(40, 34).addBox(-1.0F, -19.0F, -7.0F, 19.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm2 = body.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(40, 39).addBox(-1.0F, -19.0F, 5.0F, 19.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(40, 44).addBox(-1.0F, -8.0F, 2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone4 = body.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -16.0F, -9.0F, 14.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack var1, VertexConsumer var2, int var3, int var4, int var5) {
		body.render(var1, var2, var3, var4, -1);
		/*leg1.render(var1, var2, var3, var4, -1);
		bone.render(var1, var2, var3, var4, -1);
		arm1.render(var1, var2, var3, var4, -1);
		arm2.render(var1, var2, var3, var4, -1);
		leg2.render(var1, var2, var3, var4, -1);
		bone4.render(var1, var2, var3, var4, -1);*/
	}

	@Override
	public ModelPart root() {
		return body;
	}

	/*@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
		super.renderToBuffer(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
	}*/

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

	}
}