package com.meteor.meteorrandomidea.common.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.meteorrandomidea.common.core.EquipmentHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;

public abstract class ItemBauble extends Item {

    private static final String TAG_BAUBLE_UUID_MOST = "baubleUUIDMost";
    private static final String TAG_BAUBLE_UUID_LEAST = "baubleUUIDLeast";

    public ItemBauble(Properties props) {
        super(props);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return EquipmentHandler.initBaubleCap(stack);
    }

    public void onWornTick(ItemStack stack, LivingEntity entity) {}

    public void onEquipped(ItemStack stack, LivingEntity entity) {

    }

    public void onUnequipped(ItemStack stack, LivingEntity entity) {}

    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return true;
    }

    public Multimap<Attribute, AttributeModifier> getEquippedAttributeModifiers(ItemStack stack) {
        return HashMultimap.create();
    }

}
