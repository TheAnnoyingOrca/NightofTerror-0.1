package net.orca.dinoterrordimension.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.orca.dinoterrordimension.DinoTerrorDimension;
import net.orca.dinoterrordimension.block.ModBlocks;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DinoTerrorDimension.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DINODIMTAB = CREATIVE_MODE_TABS.register("dinodim_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DINO_TOOTH.get()))
                    .title(Component.translatable("creativetab.dinodim_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DINO_TOOTH.get());
                        pOutput.accept(ModBlocks.DINO_PORTAL.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}