package net.dispider.dispidermod.entity.client;

import net.dispider.dispidermod.entity.PrinterEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;

public class PrinterRenderer extends EntityRenderer<PrinterEntity> {
    public PrinterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(PrinterEntity pEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(PrinterEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }
}

