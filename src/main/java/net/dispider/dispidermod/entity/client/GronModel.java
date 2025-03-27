package net.dispider.dispidermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.custom.GronEntity;
import net.dispider.dispidermod.entity.custom.ManEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.swing.text.html.parser.Entity;

public class GronModel<T extends GronEntity> extends HierarchicalModel<T>  {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, "gron"), "main");

    private final ModelPart Ola;
    private final ModelPart head;

    public GronModel(ModelPart root) {
        this.Ola = root.getChild("Ola");
        this.head = Ola.getChild("full").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Ola = partdefinition.addOrReplaceChild("Ola", CubeListBuilder.create().texOffs(0, 36).addBox(-5.0F, -55.0F, -5.0F, 10.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone15 = Ola.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(0.0F, -20.0F, 2.0F));

        PartDefinition bone14 = bone15.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(76, 104).addBox(-9.0F, -11.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(64, 104).addBox(-9.0F, -11.0F, 6.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 38).addBox(-2.0F, -11.0F, 6.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 24).addBox(-2.0F, -11.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 10.0F, -6.0F));

        PartDefinition fires = bone15.addOrReplaceChild("fires", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -2.0F));

        PartDefinition fire = fires.addOrReplaceChild("fire", CubeListBuilder.create().texOffs(64, 124).addBox(-1.1667F, 0.0F, -1.1819F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(32, 80).addBox(-0.1667F, 3.0F, -0.1819F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 80).addBox(-1.1667F, 1.0F, -0.1819F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 126).addBox(-0.1667F, 1.0F, -1.1819F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(126, 56).addBox(0.8333F, 1.0F, -0.1819F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 126).addBox(-0.1667F, 1.0F, 0.8181F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -9.0F, -4.0F));

        PartDefinition fire2 = fires.addOrReplaceChild("fire2", CubeListBuilder.create().texOffs(76, 124).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(126, 61).addBox(0.0F, 2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(126, 66).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(126, 71).addBox(0.0F, 0.0F, -1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(126, 76).addBox(1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(126, 81).addBox(0.0F, 0.0F, 0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -8.0F, -3.5F));

        PartDefinition fire3 = fires.addOrReplaceChild("fire3", CubeListBuilder.create().texOffs(88, 124).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(126, 86).addBox(-0.5F, 3.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(126, 91).addBox(-1.5F, 1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(128, 118).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 130).addBox(0.5F, 1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 130).addBox(-0.5F, 1.0F, 0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -9.0F, 3.5F));

        PartDefinition fire4 = fires.addOrReplaceChild("fire4", CubeListBuilder.create().texOffs(100, 124).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 130).addBox(-0.5F, 2.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 130).addBox(-1.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 130).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 130).addBox(0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 130).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -8.0F, 4.0F));

        PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(104, 0).addBox(-6.0F, 11.0F, 7.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(104, 6).addBox(-6.0F, 11.0F, 0.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(104, 12).addBox(1.0F, 11.0F, 7.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(104, 18).addBox(1.0F, 11.0F, 0.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

        PartDefinition full = Ola.addOrReplaceChild("full", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition bone = full.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(64, 100).addBox(0.0F, -21.0F, -6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(126, 52).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, -5.0F, 0.0F, 0.0F, 3.098F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(116, 48).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -29.0F, -5.0F, 0.0F, 0.0F, 3.098F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(44, 126).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -27.0F, -5.0F, 0.0F, 0.0F, 2.0944F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 126).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -24.0F, -5.0F, 0.0F, 0.0F, 1.5272F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 126).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -21.0F, -5.0F, 0.0F, 0.0F, 1.0908F));

        PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(110, 100).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -19.0F, -5.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(12.0F, -20.0F, -4.0F));

        PartDefinition bone3 = bone4.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(110, 76).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.4399F, 0.0F));

        PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(110, 82).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r8 = bone3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(110, 70).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r9 = bone3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(110, 64).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 112).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 1.4399F, 0.0F));

        PartDefinition cube_r10 = bone5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 112).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r11 = bone5.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(110, 94).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r12 = bone5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(110, 88).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone2 = bone4.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 106).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, 0.0F, 0.0F));

        PartDefinition cube_r13 = bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 106).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r14 = bone2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(110, 58).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r15 = bone2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(110, 52).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone6 = bone4.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(32, 114).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -6.0F, 0.0F));

        PartDefinition cube_r16 = bone6.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(48, 114).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r17 = bone6.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(104, 112).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r18 = bone6.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(88, 112).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone7 = bone.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(12.0F, -32.0F, -4.0F));

        PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(116, 36).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.4399F, 0.0F));

        PartDefinition cube_r19 = bone8.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(116, 42).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r20 = bone8.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(116, 30).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r21 = bone8.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(116, 24).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone9 = bone7.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(64, 118).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 1.4399F, 0.0F));

        PartDefinition cube_r22 = bone9.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(80, 118).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r23 = bone9.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(16, 118).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r24 = bone9.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 118).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone10 = bone7.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(32, 120).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, 0.0F, 0.0F));

        PartDefinition cube_r25 = bone10.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(48, 120).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r26 = bone10.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(112, 118).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r27 = bone10.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(96, 118).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone11 = bone7.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(120, 112).addBox(2.0F, -2.0F, 0.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -6.0F, 0.0F));

        PartDefinition cube_r28 = bone11.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 124).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition cube_r29 = bone11.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(120, 106).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -1.4835F, 0.0F));

        PartDefinition cube_r30 = bone11.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(120, 100).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition bone13 = bone.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(40, 62).addBox(7.5F, -13.0F, 9.0F, 15.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -29.0F, 6.0F));

        PartDefinition cube_r31 = bone13.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(74, 26).addBox(-10.0F, -11.0F, -1.0F, 13.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.0F, 3.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r32 = bone13.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(74, 78).addBox(-5.0F, -11.0F, -1.0F, 8.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -2.0F, 9.0F, 0.0F, -0.5672F, 0.0F));

        PartDefinition cube_r33 = bone13.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(94, 78).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.5F, -2.0F, 9.0F, 0.0F, 0.4363F, 0.0F));

        PartDefinition cube_r34 = bone13.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(94, 52).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.5F, -2.0F, 6.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition cube_r35 = bone13.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(48, 88).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5F, -2.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bone12 = full.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(40, 36).addBox(-22.5F, -6.0F, 7.0F, 15.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -36.0F, 8.0F));

        PartDefinition cube_r36 = bone12.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(79, 0).addBox(-5.0F, -11.0F, -1.0F, 8.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.5F, 5.0F, 1.0F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r37 = bone12.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(74, 52).addBox(-5.0F, -11.0F, -1.0F, 8.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.5F, 5.0F, 7.0F, 0.0F, -0.5672F, 0.0F));

        PartDefinition cube_r38 = bone12.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(32, 88).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 5.0F, 7.0F, 0.0F, 0.4363F, 0.0F));

        PartDefinition cube_r39 = bone12.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(16, 80).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 5.0F, 4.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition cube_r40 = bone12.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 80).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = full.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -62.0F, -10.0F, 18.0F, 17.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(112, 124).addBox(-5.0F, -59.0F, -12.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(124, 124).addBox(1.0F, -59.0F, -12.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r41 = head.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(124, 0).addBox(1.0F, -6.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -66.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r42 = head.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(16, 124).addBox(1.0F, -6.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -73.0F, 5.0F, 0.0F, 1.5708F, -0.2182F));

        PartDefinition cube_r43 = head.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(124, 12).addBox(1.0F, -6.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -73.0F, 5.0F, 0.0F, 1.5708F, 0.2182F));

        PartDefinition cube_r44 = head.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(64, 88).addBox(1.0F, -6.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -66.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r45 = head.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(104, 104).addBox(-1.0F, -2.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -57.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r46 = head.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(88, 104).addBox(-1.0F, -2.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -57.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Ola.render(poseStack, vertexConsumer, packedLight, packedOverlay,color);
    }

    @Override
    public ModelPart root() {
        return Ola;
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(pNetHeadYaw, pHeadPitch);

        this.animateWalk(GronAnimations.walk, pLimbSwing, pLimbSwingAmount, 2f, 2.5f);
        this.animate(pEntity.idleAnimation, GronAnimations.idle, pAgeInTicks, 1f);
    }
    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
}
