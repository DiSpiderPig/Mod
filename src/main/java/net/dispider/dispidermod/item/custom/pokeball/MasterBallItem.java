package net.dispider.dispidermod.item.custom.pokeball;

import net.dispider.dispidermod.entity.custom.projectile.MasterBallProjectileEntity;
import net.dispider.dispidermod.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MasterBallItem extends Item {
    public MasterBallItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(
                null,
                pPlayer.getX(),
                pPlayer.getY(),
                pPlayer.getZ(),
                ModSounds.kunaiThrow.get(),
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!pLevel.isClientSide) {
            MasterBallProjectileEntity snowball = new MasterBallProjectileEntity(pPlayer,pLevel);
            snowball.setItem(itemstack);
            snowball.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.75F, 1.0F);
            pLevel.addFreshEntity(snowball);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, pPlayer);
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());

    }
}
