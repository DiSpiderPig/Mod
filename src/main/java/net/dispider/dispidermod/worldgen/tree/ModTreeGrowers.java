package net.dispider.dispidermod.worldgen.tree;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLUE = new TreeGrower(DiSpiderMod.MODID + ":blue",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLUE_KEY), Optional.empty());
    public static final TreeGrower WHITE = new TreeGrower(DiSpiderMod.MODID + ":white",
            Optional.empty(), Optional.of(ModConfiguredFeatures.WHITE_KEY), Optional.empty());

    public static final TreeGrower RED = new TreeGrower(DiSpiderMod.MODID + ":red",
            Optional.empty(), Optional.of(ModConfiguredFeatures.WHITE_KEY), Optional.empty());
}
