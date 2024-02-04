package net.orca.dinoterrordimension.datagen;

import net.minecraft.core.BlockPos;
import net.minecraft.data.PackOutput;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.orca.dinoterrordimension.DinoTerrorDimension;
import net.orca.dinoterrordimension.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super();
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DINO_PORTAL);
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return null;
    }

    @Override
    public BlockState getState(RandomSource pRandom, BlockPos pPos) {
        return null;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}