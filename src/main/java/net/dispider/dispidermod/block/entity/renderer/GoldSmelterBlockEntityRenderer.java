package net.dispider.dispidermod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.dispider.dispidermod.block.entity.custom.GoldSmelterBlockEntity;
import net.dispider.dispidermod.block.entity.custom.PrinterBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class GoldSmelterBlockEntityRenderer implements BlockEntityRenderer<GoldSmelterBlockEntity>{
    public GoldSmelterBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(GoldSmelterBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.itemHandler.getStackInSlot(0);

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 0.25f, 0.3f);
        pPoseStack.scale(0.2f, 0.2f, 0.2f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getRenderingRotation()));

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();

    }
    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
