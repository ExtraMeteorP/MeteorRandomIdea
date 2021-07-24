package com.meteor.meteorrandomidea.common.items;

import com.meteor.meteorrandomidea.MeteorRandomIdea;
import com.meteor.meteorrandomidea.common.items.armor.goblinslayer.ItemGoblinSlayerArmor;
import com.meteor.meteorrandomidea.common.items.armor.maid.ItemMaidArmor;
import com.meteor.meteorrandomidea.common.items.armor.miku.ItemMikuArmor;
import com.meteor.meteorrandomidea.common.items.armor.shadowwarrior.ItemShadowWarriorArmor;
import com.meteor.meteorrandomidea.common.libs.LibItemNames;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModItems {

    public static final Item motor = new ItemMotor();
    public static final Item gemofconquest = new ItemGemOfConquest();
    public static final Item firstfractal = new ItemFirstFractal();
    public static final Item cosmiccarkey = new ItemCosmicCarKey();
    public static final Item flamescionweapon = new ItemFlamescionWeapon();
    public static final Item paimonmedal = new ItemPaimonMedal();

    public static final Item foxear = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.FOX_EAR, unstackable());
    public static final Item foxmask = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.FOX_MASK, unstackable());
    public static final Item blackglasses = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.BLACK_GLASSES, unstackable());
    public static final Item thuglife = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.THUG_LIFE, unstackable());
    public static final Item redscarf = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.RED_SCARF, unstackable());
    public static final Item supercrown = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.SUPER_CROWN, unstackable());
    public static final Item pylon = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.PYLON, unstackable());

    public static final Item armor_maid_helm = new ItemMaidArmor(EquipmentSlotType.HEAD, unstackable());
    public static final Item armor_maid_chest = new ItemMaidArmor(EquipmentSlotType.CHEST, unstackable());
    public static final Item armor_maid_legs = new ItemMaidArmor(EquipmentSlotType.LEGS, unstackable());
    public static final Item armor_maid_boots = new ItemMaidArmor(EquipmentSlotType.FEET, unstackable());

    public static final Item armor_miku_helm = new ItemMikuArmor(EquipmentSlotType.HEAD, unstackable());
    public static final Item armor_miku_chest = new ItemMikuArmor(EquipmentSlotType.CHEST, unstackable());
    public static final Item armor_miku_legs = new ItemMikuArmor(EquipmentSlotType.LEGS, unstackable());
    public static final Item armor_miku_boots = new ItemMikuArmor(EquipmentSlotType.FEET, unstackable());

    public static final Item armor_goblinslayer_helm = new ItemGoblinSlayerArmor(EquipmentSlotType.HEAD, unstackable());
    public static final Item armor_goblinslayer_chest = new ItemGoblinSlayerArmor(EquipmentSlotType.CHEST, unstackable());
    public static final Item armor_goblinslayer_legs = new ItemGoblinSlayerArmor(EquipmentSlotType.LEGS, unstackable());
    public static final Item armor_goblinslayer_boots = new ItemGoblinSlayerArmor(EquipmentSlotType.FEET, unstackable());

    public static final Item armor_shadowwarrior_helm = new ItemShadowWarriorArmor(EquipmentSlotType.HEAD, unstackable());
    public static final Item armor_shadowwarrior_chest = new ItemShadowWarriorArmor(EquipmentSlotType.CHEST, unstackable());
    public static final Item armor_shadowwarrior_legs = new ItemShadowWarriorArmor(EquipmentSlotType.LEGS, unstackable());
    public static final Item armor_shadowwarrior_boots = new ItemShadowWarriorArmor(EquipmentSlotType.FEET, unstackable());

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().group(MeteorRandomIdea.itemGroup);
    }

    private static Item.Properties unstackable() {
        return defaultBuilder().maxStackSize(1);
    }

    public static void registerItems(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();
        register(r, LibItemNames.MOTOR, motor);
        register(r, LibItemNames.GEMOFCONQUEST, gemofconquest);
        register(r, LibItemNames.FIRSTFRACTAL, firstfractal);
        register(r, LibItemNames.COSMICCARKEY, cosmiccarkey);
        register(r, LibItemNames.FLAMESCIONWEAPON, flamescionweapon);
        register(r, LibItemNames.PAIMONMEDAL, paimonmedal);

        register(r, LibItemNames.FOX_EAR, foxear);
        register(r, LibItemNames.FOX_MASK, foxmask);
        register(r, LibItemNames.PYLON, pylon);
        register(r, LibItemNames.BLACK_GLASSES, blackglasses);
        register(r, LibItemNames.RED_SCARF, redscarf);
        register(r, LibItemNames.THUG_LIFE, thuglife);
        register(r, LibItemNames.SUPER_CROWN, supercrown);

        register(r, LibItemNames.ARMOR_MAID_HELM, armor_maid_helm);
        register(r, LibItemNames.ARMOR_MAID_CHEST, armor_maid_chest);
        register(r, LibItemNames.ARMOR_MAID_LEGS, armor_maid_legs);
        register(r, LibItemNames.ARMOR_MAID_BOOTS, armor_maid_boots);

        register(r, LibItemNames.ARMOR_MIKU_HELM, armor_miku_helm);
        register(r, LibItemNames.ARMOR_MIKU_CHEST, armor_miku_chest);
        register(r, LibItemNames.ARMOR_MIKU_LEGS, armor_miku_legs);
        register(r, LibItemNames.ARMOR_MIKU_BOOTS, armor_miku_boots);

        register(r, LibItemNames.ARMOR_GOBLINSLAYER_HELM, armor_goblinslayer_helm);
        register(r, LibItemNames.ARMOR_GOBLINSLAYER_CHEST, armor_goblinslayer_chest);
        register(r, LibItemNames.ARMOR_GOBLINSLAYER_LEGS, armor_goblinslayer_legs);
        register(r, LibItemNames.ARMOR_GOBLINSLAYER_BOOTS, armor_goblinslayer_boots);

        register(r, LibItemNames.ARMOR_SHADOWWARRIOR_HELM, armor_shadowwarrior_helm);
        register(r, LibItemNames.ARMOR_SHADOWWARRIOR_CHEST, armor_shadowwarrior_chest);
        register(r, LibItemNames.ARMOR_SHADOWWARRIOR_LEGS, armor_shadowwarrior_legs);
        register(r, LibItemNames.ARMOR_SHADOWWARRIOR_BOOTS, armor_shadowwarrior_boots);
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, ResourceLocation name, IForgeRegistryEntry<V> thing) {
        reg.register(thing.setRegistryName(name));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, String name, IForgeRegistryEntry<V> thing) {
        register(reg, prefix(name), thing);
    }

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(LibMisc.MOD_ID, path);
    }
}
