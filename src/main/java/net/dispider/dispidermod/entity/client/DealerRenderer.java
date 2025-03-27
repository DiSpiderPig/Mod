package net.dispider.dispidermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.custom.DealerEntity;
import net.dispider.dispidermod.entity.custom.GronEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DealerRenderer extends MobRenderer<DealerEntity, DealerModel<DealerEntity>> {
    public DealerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DealerModel<>(pContext.bakeLayer(DealerModel.LAYER_LOCATION)),0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DealerEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID,"textures/entity/dealer.png");
    }

    @Override
    public void render(DealerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()){
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }else{
            pPoseStack.scale(1f,1f,1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
