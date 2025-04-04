package net.dispider.dispidermod.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.windcharge.AbstractWindCharge;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Function;

public class RugaUsed extends AbstractWindCharge {
    private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new SimpleExplosionDamageCalculator(
            true, true, Optional.of(6.22F), BuiltInRegistries.BLOCK.getTag(BlockTags.ICE).map(Function.identity())
    );
    private static final float RADIUS = 5.5F;
    private int noDeflectTicks = 5;

    public RugaUsed(EntityType<? extends AbstractWindCharge> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public RugaUsed(Player pPlayer, Level pLevel, double pX, double pY, double pZ) {
        super(EntityType.WIND_CHARGE, pLevel, pPlayer, pX, pY, pZ);
    }


    @Override
    public void tick() {
        super.tick();
        if (this.noDeflectTicks > 0) {
            this.noDeflectTicks--;
        }
    }

    @Override
    public boolean deflect(ProjectileDeflection pDeflection, @Nullable Entity pEntity, @Nullable Entity pOwner, boolean pDeflectedByPlayer) {
        return this.noDeflectTicks > 0 ? false : super.deflect(pDeflection, pEntity, pOwner, pDeflectedByPlayer);
    }

    @Override
    protected void explode(Vec3 pPos) {
        this.level()
                .explode(
                        this,
                        null,
                        EXPLOSION_DAMAGE_CALCULATOR,
                        pPos.x(),
                        pPos.y(),
                        pPos.z(),
                        RADIUS,
                        true,
                        Level.ExplosionInteraction.TRIGGER,
                        ParticleTypes.CLOUD,
                        ParticleTypes.CLOUD,
                        SoundEvents.GENERIC_EXPLODE
                );
    }
}