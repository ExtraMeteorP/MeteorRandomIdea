package com.meteor.meteorrandomidea.common;

import com.meteor.meteorrandomidea.common.items.ModItems;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MeteorRandomIdeaGroup extends ItemGroup {

    public MeteorRandomIdeaGroup() {
        super(LibMisc.MOD_ID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.gemofconquest);
    }
}
