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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =  DeferredRegister.create(ForgeRegistries.BLOCKS, FriedChickenMod.MOD_ID);

//the block
    public static final RegistryObject<Block> FLOWER = registerBlock("flower_block",
        () -> new FlowerBlock(MobEffects.BLINDNESS, 2 ,
            BlockBehaviour.Properties.copy(Blocks.DANDELION)));



    //registers any block
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
    //the registry
    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
