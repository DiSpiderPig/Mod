package net.dispider.dispidermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.dispider.dispidermod.block.entity.custom.PrinterBlockEntity;
import net.dispider.dispidermod.entity.ModEntities;
import net.dispider.dispidermod.entity.PrinterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PrinterBlock extends BaseEntityBlock {

    public static final MapCodec<PrinterBlock> CODEC = simpleCodec(PrinterBlock::new);
    public static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    public PrinterBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
       return SHAPE;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PrinterBlockEntity(pPos,pState);
    }
    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos,
                            BlockState pNewState, boolean pMovedByPiston) {
        if(pState.getBlock() != pNewState.getBlock()) {
            if(pLevel.getBlockEntity(pPos) instanceof PrinterBlockEntity pedestalBlockEntity) {
                pedestalBlockEntity.drops();
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel,
                                              BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {

        if(pLevel.getBlockEntity(pPos) instanceof PrinterBlockEntity printerBlockEntity) {
            if(pPlayer.isCrouching() && !pLevel.isClientSide()) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(printerBlockEntity, Component.literal("Printer")), pPos);
                return ItemInteractionResult.SUCCESS;
            }

            if(pPlayer.isCrouching() && pLevel.isClientSide()) {
                return ItemInteractionResult.SUCCESS;
            }



            if(printerBlockEntity.inventory.getStackInSlot(0).isEmpty() && !pStack.isEmpty()) {
                printerBlockEntity.inventory.insertItem(0, pStack.copy(), false);
                pStack.shrink(1);
                pLevel.playSound(pPlayer, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
            } else if(pStack.isEmpty()) {
                ItemStack stackOnPrinter = printerBlockEntity.inventory.extractItem(0, 1, false);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, stackOnPrinter);
                printerBlockEntity.clearContents();
                pLevel.playSound(pPlayer, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
            }
        }

        return ItemInteractionResult.SUCCESS;
    }


    /*

    public static final MapCodec<PrinterBlock> CODEC = simpleCodec(PrinterBlock::new);
    public static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    public PrinterBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if(!pLevel.isClientSide()){
            Entity entity = null;
            List<PrinterEntity> entities = pLevel.getEntities(ModEntities.Printer.get(),new AABB(pPos), printerEntity -> true);
            if(entities.isEmpty()){
                entity = ModEntities.Printer.get().spawn((ServerLevel) pLevel,pPos, MobSpawnType.TRIGGERED);
            }else{
                entity = entities.get(0);
            }

            pPlayer.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING,pContext.getHorizontalDirection().getOpposite());
    } */
}
