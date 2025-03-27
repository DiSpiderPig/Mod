package net.dispider.dispidermod.event;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.entity.client.AppaModel;
import net.dispider.dispidermod.entity.client.GronModel;
import net.dispider.dispidermod.entity.client.ManModel;
import net.dispider.dispidermod.entity.custom.AppaEntity;
import net.dispider.dispidermod.entity.custom.GronEntity;
import net.dispider.dispidermod.entity.custom.ManEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DiSpiderMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
@SubscribeEvent
       public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
           event.registerLayerDefinition(ManModel.LAYER_LOCATION, ManModel::createBodyLayer);
           event.registerLayerDefinition(AppaModel.LAYER_LOCATION,AppaModel::createBodyLayer);
           event.registerLayerDefinition(GronModel.LAYER_LOCATION, GronModel::createBodyLayer);
       }
@SubscribeEvent
       public static void registerAttributes(EntityAttributeCreationEvent event){
    event.put(ModEntities.MAN.get(), ManEntity.createAttributes().build());
    event.put(ModEntities.APPA.get(), AppaEntity.createAttributes().build());
    event.put(ModEntities.Gron.get(), GronEntity.createAttributes().build());
       }

}
