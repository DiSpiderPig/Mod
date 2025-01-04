package net.dispider.dispidermod.entity.client;

import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {



    public static final ModelLayerLocation GRON_LAYER = register("gron_layer");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, name), "main");
    }

    private static ModelLayerLocation register(String name, String layerName) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID, name), layerName);
    }
}