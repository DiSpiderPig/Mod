package net.dispider.dispidermod.item.custom;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {

    private int burnTIme = 0;


    public FuelItem(Properties pProperties, int burnTime) {
        super(pProperties);
        this.burnTIme = burnTime;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level pLevel = pContext.getLevel();
        Block pBlock = pLevel.getBlockState(pContext.getClickedPos()).getBlock();

        if(!pLevel.isClientSide()){
            ((ServerLevel) pLevel).sendParticles(ParticleTypes.ASH,
                    pContext.getClickedPos().getX() + 0.5,
                    pContext.getClickedPos().getY() + 2.0, pContext.getClickedPos().getZ() + 0.5, 10,0,0,0,1);
        }


        return InteractionResult.SUCCESS;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTIme;
    }
}
