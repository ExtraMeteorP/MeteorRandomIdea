package com.meteor.meteorrandomidea.common.items;

import com.meteor.meteorrandomidea.MeteorRandomIdea;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ItemGemOfConquest extends Item {

    public ItemGemOfConquest() {
        super(new Properties().group(MeteorRandomIdea.itemGroup).rarity(Rarity.EPIC).maxStackSize(1).setNoRepair());
    }

}
