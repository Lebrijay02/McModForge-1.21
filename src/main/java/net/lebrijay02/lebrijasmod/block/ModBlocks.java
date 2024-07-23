package net.lebrijay02.lebrijasmod.block;

import net.lebrijay02.lebrijasmod.LebrijasMod;
import net.lebrijay02.lebrijasmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LebrijasMod.MOD_ID);

    //block list
        //regular block
    public static final RegistryObject<Block> CRYSTAL_BLOCK = registerBlock("crystal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK).sound(SoundType.AMETHYST)));
        //ore block
    public static final RegistryObject<Block> CRYSTAL_ORE_BLOCK = registerBlock("crystal_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                                .strength(2f).requiresCorrectToolForDrops()
                        ));
    //creates block function
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        //registers block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        //registers block item
        registerBlockItem(name, toReturn);
        //returns block
        return toReturn;
    }

    //registers item associated with block, makes sure that the T item is a block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //register to mod function
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
