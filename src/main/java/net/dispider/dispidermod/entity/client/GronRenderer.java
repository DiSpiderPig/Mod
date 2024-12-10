package net.dispider.dispidermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.custom.mob.GronEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GronRenderer extends MobRenderer<GronEntity,GronModel<GronEntity>> {
    public GronRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GronModel<>(pContext.bakeLayer(ModModelLayers.GRON_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(GronEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(DiSpiderMod.EXAMPLEMOD,"textures/entity/gron.png");


    }

    @Override
    public void render(GronEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }


}
