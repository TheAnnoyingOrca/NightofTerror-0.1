package net.orca.dinoterrordimension.worldgen.dimension;

import com.ibm.icu.impl.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.orca.dinoterrordimension.DinoTerrorDimension;
import net.orca.dinoterrordimension.worldgen.biome.ModBiomes;

import java.util.List;
import java.util.OptionalLong;

public class ModDinoDimensions {
    public static final ResourceKey<LevelStem> DINODIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(DinoTerrorDimension.MOD_ID, "dinodim"));
    public static final ResourceKey<Level> DINODIM_LEVEL = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(DinoTerrorDimension.MOD_ID, "dinodim"));
    public static final ResourceKey<DimensionType> DINODIM_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(DinoTerrorDimension.MOD_ID, "dinodim"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(DINODIM_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                true, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.TALL_GRASS_FIELD)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        //NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                //MultiNoiseBiomeSource.createFromList(
                        //new Climate.ParameterList<>(List.of(Pair.of(
                                        //Climate.parameters(0.1F, 0.2F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TALL_GRASS_FIELD)),
                                //Pair.of(
                                        //Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
                                //Pair.of(
                                        //Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
                                //Pair.of(
                                        //Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST))

                        //))),
                //noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDinoDimensions.DINODIM_DIM_TYPE), wrappedChunkGenerator);

        context.register(DINODIM_KEY, stem);
    }

}
