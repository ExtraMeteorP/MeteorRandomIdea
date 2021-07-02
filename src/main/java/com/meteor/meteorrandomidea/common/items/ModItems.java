package com.meteor.meteorrandomidea.common.items;

import com.meteor.meteorrandomidea.common.libs.LibItemNames;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
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

    public static void registerItems(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();
        register(r, LibItemNames.MOTOR, motor);
        register(r, LibItemNames.GEMOFCONQUEST, gemofconquest);
        register(r, LibItemNames.FIRSTFRACTAL, firstfractal);
        register(r, LibItemNames.COSMICCARKEY, cosmiccarkey);
        register(r, LibItemNames.FLAMESCIONWEAPON, flamescionweapon);
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
