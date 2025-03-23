package net.dispider.dispidermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.kinds.App;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.custom.AppaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class AppaModel<T extends AppaEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, "appa"), "main");
    private final ModelPart Full;
    private final ModelPart head;

    public AppaModel(ModelPart root) {
        this.Full = root.getChild("Full");
        this.head = this.Full.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Full = partdefinition.addOrReplaceChild("Full", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone = Full.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -30.0F, -22.0F, 24.0F, 19.0F, 44.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs = bone.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(68, 97).addBox(3.0F, -12.0F, 11.0F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(108, 109).addBox(3.0F, -12.0F, -3.0F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(100, 63).addBox(-12.0F, -12.0F, -3.0F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(68, 120).addBox(-12.0F, -12.0F, 11.0F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 127).addBox(-12.0F, -12.0F, -17.0F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(108, 86).addBox(3.0F, -12.0F, -17.0F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = Full.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 97).addBox(-9.0F, -27.0F, -38.0F, 18.0F, 14.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(136, 25).addBox(5.0F, -33.0F, -29.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 33).addBox(-8.0F, -33.0F, -29.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 5).addBox(7.0F, -40.0F, -29.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 15).addBox(-10.0F, -40.0F, -29.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(108, 132).addBox(-9.0F, -27.0F, -41.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(40, 127).addBox(-5.0F, -18.0F, -41.0F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 0).addBox(-9.0F, -17.0F, -39.0F, 18.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 132).addBox(-5.0F, -18.0F, -40.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(100, 86).addBox(-1.0F, -21.0F, -32.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back = Full.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, -25.0F, 18.0F));

        PartDefinition back_r1 = back.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 63).addBox(-9.0F, -1.0F, -1.0F, 22.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, 5.0F, -0.7418F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(AppaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(AppaAnimations.Walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimation, AppaAnimations.Idle, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,int color) {
        Full.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
    @Override
    public ModelPart root() {
        return Full;
    }
}
