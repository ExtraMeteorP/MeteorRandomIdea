package com.meteor.meteorrandomidea.common.core;

import com.google.common.collect.Multimap;
import com.meteor.meteorrandomidea.common.capability.SimpleCapProvider;
import com.meteor.meteorrandomidea.common.items.ItemBauble;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.function.Predicate;

public class CurioIntegration extends EquipmentHandler{

    public static void sendImc(InterModEnqueueEvent evt) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CHARM.getMessageBuilder().build());
    }

    @Override
    protected LazyOptional<IItemHandlerModifiable> getAllWornItems(LivingEntity living) {
        return CuriosApi.getCuriosHelper().getEquippedCurios(living);
    }

    @Override
    protected ItemStack findItem(Item item, LivingEntity living) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(item, living)
                .map(ImmutableTriple::getRight)
                .orElse(ItemStack.EMPTY);
    }

    @Override
    protected ItemStack findItem(Predicate<ItemStack> pred, LivingEntity living) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(pred, living)
                .map(ImmutableTriple::getRight)
                .orElse(ItemStack.EMPTY);
    }

    @Override
    protected ICapabilityProvider initCap(ItemStack stack) {
        return new SimpleCapProvider<>(CuriosCapability.ITEM, new Wrapper(stack));
    }

    public static class Wrapper implements ICurio {
        private final ItemStack stack;

        Wrapper(ItemStack stack) {
            this.stack = stack;
        }

        private ItemBauble getItem() {
            return (ItemBauble) stack.getItem();
        }

        @Override
        public void curioTick(String identifier, int index, LivingEntity entity) {
            getItem().onWornTick(stack, entity);
        }

        @Override
        public void onEquip(String identifier, int index, LivingEntity entity) {
            getItem().onEquipped(stack, entity);
        }

        @Override
        public void onUnequip(String identifier, int index, LivingEntity entity) {
            getItem().onUnequipped(stack, entity);
        }

        @Override
        public boolean canEquip(String identifier, LivingEntity entity) {
            return getItem().canEquip(stack, entity);
        }

        @Override
        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier) {
            return getItem().getEquippedAttributeModifiers(stack);
        }

        @Override
        public boolean canSync(String identifier, int index, LivingEntity livingEntity) {
            return true;
        }

        @Override
        public void playRightClickEquipSound(LivingEntity entity) {

        }

        @Override
        public boolean canRightClickEquip() {
            return true;
        }

    }
}