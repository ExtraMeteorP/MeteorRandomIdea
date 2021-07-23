package com.meteor.meteorrandomidea.common.items.armor.miku;

import com.meteor.meteorrandomidea.client.model.armor.ModelMikuArmor;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nonnull;

public class ItemMikuArmor extends ArmorItem {

    private final LazyValue<BipedModel<?>> model;
    public final EquipmentSlotType type;

    public ItemMikuArmor(EquipmentSlotType type, Properties props) {
        this(type, ArmorMaterial.IRON, props);
    }

    public ItemMikuArmor(EquipmentSlotType type, IArmorMaterial mat, Properties props) {
        super(mat, type, props);
        this.type = type;
        this.model = DistExecutor.unsafeRunForDist(() -> () -> new LazyValue<>(() -> this.provideArmorModelForSlot(type)),
                () -> () -> null);
    }

    @Nonnull
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return LibMisc.MOD_ID + ":textures/model/armor_miku.png";
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A original) {
        return (A) model.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelMikuArmor(slot);
    }

}
