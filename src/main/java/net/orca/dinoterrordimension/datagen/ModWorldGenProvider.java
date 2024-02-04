package net.orca.dinoterrordimension.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.registries.ForgeRegistries;
import net.orca.dinoterrordimension.DinoTerrorDimension;
import net.orca.dinoterrordimension.worldgen.biome.ModBiomes;
import net.orca.dinoterrordimension.worldgen.dimension.ModDinoDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDinoDimensions::bootstrapType)
            .add(Registries.BIOME, ModBiomes::boostrap)
            .add(Registries.LEVEL_STEM, ModDinoDimensions::bootstrapStem);

    //public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        //super(output, registries, BUILDER, Set.of(DinoTerrorDimension.MOD_ID));
    //}
}
