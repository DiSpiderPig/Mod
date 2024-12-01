package net.dispider.dispidermod.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CancerEffect extends MobEffect {
    public CancerEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.getHealth()>0.1f){
            pLivingEntity.hurt(pLivingEntity.damageSources().magic(),0.4f);
        }
        return super.applyEffectTick(pLivingEntity,pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        int i = 2500 >> pDuration;
        return i > 0 ? 3 % i == 0 : true;
    }
}
