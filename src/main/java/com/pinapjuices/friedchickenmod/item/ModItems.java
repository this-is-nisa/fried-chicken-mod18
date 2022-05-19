package com.pinapjuices.friedchickenmod.item;

import com.pinapjuices.friedchickenmod.FriedChickenMod;
import com.pinapjuices.friedchickenmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =   // def-regis is an array list that forge uses to keep track of items u made
            DeferredRegister.create(ForgeRegistries.ITEMS, FriedChickenMod.MOD_ID);


    //making item start
    public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().nutrition(10).saturationMod(10f).build())));  //this line registers the item (fried chicken), gives it a name, and properties
    // .tab() property determines where the item will be placed in the creative obj menu
    // making item end   -- the item in created but u still gotta make a json file for texture

    public static final RegistryObject<Item> FRIEDCHICKEN_SEEDS = ITEMS.register("friedchicken_seeds", () -> new ItemNameBlockItem(ModBlocks.FRIEDCHICKENPLANT.get(),new Item.Properties().tab(CreativeModeTab.TAB_MISC)));



    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);  // method that registers items i made as being about of my testingmod
    }

}


