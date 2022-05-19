package com.pinapjuices.friedchickenmod.block;

import com.pinapjuices.friedchickenmod.FriedChickenMod;
import com.pinapjuices.friedchickenmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import com.pinapjuices.friedchickenmod.block.custom.FriedChickenPlant;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FriedChickenMod.MOD_ID);

//the blocks
    public static final RegistryObject<Block> CHICKEN_FLOWER = registerBlock("chicken_flower",
        () -> new FlowerBlock(MobEffects.BLINDNESS, 2,
            BlockBehaviour.Properties.copy(Blocks.DANDELION)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> POTTED_CHICKEN_FLOWER = registerBlockWithoutBlockItem("potted_chicken_flower",
            () -> new FlowerPotBlock(null, ModBlocks.CHICKEN_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }


    public static final RegistryObject<Block> FRIEDCHICKENPLANT = BLOCKS.register("friedchickenplant",
            () -> new FriedChickenPlant(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
// the friedchickenplant after new must match the custom




    //registers any block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                        CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));

    }
    //the registry
    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
