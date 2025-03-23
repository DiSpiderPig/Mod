package net.dispider.dispidermod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.AppaVariant;
import net.dispider.dispidermod.entity.custom.AppaEntity;
import net.dispider.dispidermod.entity.custom.ManEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class AppaRenderer extends MobRenderer<AppaEntity,AppaModel<AppaEntity>> {
    private static final Map<AppaVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AppaVariant.class), map -> {
                map.put(AppaVariant.BROWN,
                        ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, "textures/entity/appa/brown_appa.png"));
                map.put(AppaVariant.BLUE,
                        ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, "textures/entity/appa/blue_appa.png"));
            });

    public AppaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AppaModel<>(pContext.bakeLayer(AppaModel.LAYER_LOCATION)),1f);
    }

    @Override
    public ResourceLocation getTextureLocation(AppaEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(AppaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()){
            pPoseStack.scale(1f,1f,1f);
        }else{
            pPoseStack.scale(4f,4f,4f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

}
