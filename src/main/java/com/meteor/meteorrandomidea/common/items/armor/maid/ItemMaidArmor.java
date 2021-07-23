package com.meteor.meteorrandomidea.common.items.armor.maid;

import com.meteor.meteorrandomidea.client.model.armor.ModelMaidArmor;
import com.meteor.meteorrandomidea.common.items.armor.miku.ItemMikuArmor;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class ItemMaidArmor extends ItemMikuArmor {

    public ItemMaidArmor(EquipmentSlotType type, Properties props) {
        super(type, props);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelMaidArmor(slot);
    }

    @Nonnull
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return LibMisc.MOD_ID + ":textures/model/armor_maid.png";
    }
}
