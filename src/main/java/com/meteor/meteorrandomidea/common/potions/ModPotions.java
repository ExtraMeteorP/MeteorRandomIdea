package com.meteor.meteorrandomidea.common.potions;

import com.meteor.meteorrandomidea.common.libs.LibPotionNames;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.meteor.meteorrandomidea.common.items.ModItems.register;

public class ModPotions {

    public static final Effect incandescence = new PotionIncandescence();
    public static final Effect timelock = new PotionTimeLock();
    public static final Effect flamescion = new PotionFlamescion();

    public static void registerPotions(RegistryEvent.Register<Effect> evt) {
        IForgeRegistry<Effect> r = evt.getRegistry();
        register(r, LibPotionNames.INCANDESCENCE, incandescence);
        register(r, LibPotionNames.TIMELOCK, timelock);
        register(r, LibPotionNames.FLAMESCION, flamescion);
    }
}
