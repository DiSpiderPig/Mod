package net.dispider.dispidermod.event;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.entity.custom.mob.GronEntity;
import net.dispider.dispidermod.item.ModItems;
import net.dispider.dispidermod.item.custom.HammerItem;
import net.dispider.dispidermod.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = DiSpiderMod.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }

    }
    @SubscribeEvent
    public static  void onLivingDamage(LivingDamageEvent event){
        if(event.getEntity() instanceof Pig pig && event.getSource().getDirectEntity() instanceof Player player){
            LightningBolt lightningBolt;
            player.sendSystemMessage(Component.literal("YOU MONSTER, DONT HIT THE PIGS"));
            player.sendSystemMessage(Component.literal("I AM SO MAD RIGHT NOW"));
            player.sendSystemMessage(Component.literal("YOU ARE GONNA PAY!"));
            player.addEffect(new MobEffectInstance(MobEffects.POISON,600,5));
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,600,5));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,600,5));
            player.getMainHandItem().shrink(64);
        }
    }

@SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event){
    PotionBrewing.Builder builder = event.getBuilder();
    builder.addMix(Potions.AWKWARD, ModItems.VAPE.get(), ModPotions.CANCER_POTION.getHolder().get());
    }



}
