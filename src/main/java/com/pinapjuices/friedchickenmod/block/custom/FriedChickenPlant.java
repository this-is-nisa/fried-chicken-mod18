package com.pinapjuices.friedchickenmod.block.custom;

import com.pinapjuices.friedchickenmod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class FriedChickenPlant extends CropBlock {

    public FriedChickenPlant(Properties p_52247_) {

        super(p_52247_);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.FRIEDCHICKEN_SEEDS.get();
    }
}
