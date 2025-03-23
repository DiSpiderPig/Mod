package net.dispider.dispidermod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.AppaVariant;
import net.dispider.dispidermod.entity.custom.ManEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class ManRenderer extends MobRenderer<ManEntity, ManModel<ManEntity>> {

    public ManRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ManModel<>(pContext.bakeLayer(ManModel.LAYER_LOCATION)),1f);
    }

    @Override
    public ResourceLocation getTextureLocation(ManEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID,"textures/entity/man/texture.png");
    }

    @Override
    public void render(ManEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()){
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }else{
            pPoseStack.scale(1f,1f,1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }


}
