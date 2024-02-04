package net.orca.dinoterrordimension.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.orca.dinoterrordimension.DinoTerrorDimension;
import net.orca.dinoterrordimension.block.custom.ModDinoPortalBlock;
import net.orca.dinoterrordimension.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DinoTerrorDimension.MOD_ID);

    public static final RegistryObject<Block> DINO_PORTAL = registerBlock("dino_portal",
            () -> new ModDinoPortalBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL).noLootTable().noOcclusion().noCollission()));





    private static <T extends  Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
