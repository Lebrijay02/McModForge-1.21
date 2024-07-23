package net.lebrijay02.lebrijasmod.item;

import net.lebrijay02.lebrijasmod.LebrijasMod;
import net.lebrijay02.lebrijasmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LebrijasMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEBRIJASMOD_TAB = CREATIVE_MODE_TABS.register("lebrijasmod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.lebrijasmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_CRYSTAL.get());
                        output.accept(ModItems.CRYSTAL_SWORD.get());
                        output.accept(Items.STRIPPED_MANGROVE_LOG);
                        output.accept(ModBlocks.CRYSTAL_ORE_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
