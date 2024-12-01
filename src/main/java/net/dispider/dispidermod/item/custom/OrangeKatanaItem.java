package net.dispider.dispidermod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.List;

public class OrangeKatanaItem extends SwordItem {

    public static int i = 0;
    public static int k = 1;// Amplifier
    boolean has5Kills = false;


    public OrangeKatanaItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        if(has5Kills) {


            pTarget.igniteForSeconds(5f);
            pTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING,50,1),pTarget);

            pTarget.playSound(SoundEvents.BEACON_ACTIVATE);
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        if(!pTarget.isAlive()){
            i++;
            if(pAttacker.hasEffect(MobEffects.GLOWING)){
                if(i==5){
                    pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,60,1),pAttacker);
                }
                if(i >= 5){
                    has5Kills = true;
                }
            }
            else{
                k = 0;
            }
            pAttacker.addEffect(new MobEffectInstance(MobEffects.GLOWING,125,k),pAttacker);
        }

        super.postHurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("Kill to gain Powers!"));
        }
        else{
            pTooltipComponents.add(Component.translatable("You have "+i+" Kills"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
