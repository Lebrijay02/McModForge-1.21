package net.lebrijay02.lebrijasmod.item;

import net.lebrijay02.lebrijasmod.LebrijasMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //long list of items. DeferredRegister is a list
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, LebrijasMod.MOD_ID);

    //adds raw crystal to game
    public static final RegistryObject<Item> RAW_CRYSTAL = ITEMS.register("raw_crystal",
            () -> new Item(new Item.Properties()));
    //adds crystal sword to game
    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
