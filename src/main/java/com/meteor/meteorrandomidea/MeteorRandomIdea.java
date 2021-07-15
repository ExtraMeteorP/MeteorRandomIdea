package com.meteor.meteorrandomidea;

import com.meteor.meteorrandomidea.client.ClientProxy;
import com.meteor.meteorrandomidea.common.MeteorRandomIdeaGroup;
import com.meteor.meteorrandomidea.common.ServerProxy;
import com.meteor.meteorrandomidea.common.capability.CapabilityHandler;
import com.meteor.meteorrandomidea.common.core.ConfigHandler;
import com.meteor.meteorrandomidea.common.core.EquipmentHandler;
import com.meteor.meteorrandomidea.common.core.IProxy;
import com.meteor.meteorrandomidea.common.core.ModSounds;
import com.meteor.meteorrandomidea.common.entities.ModEntities;
import com.meteor.meteorrandomidea.common.items.ModItems;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import com.meteor.meteorrandomidea.common.potions.ModPotions;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LibMisc.MOD_ID)
public class MeteorRandomIdea {

    public static ItemGroup itemGroup = new MeteorRandomIdeaGroup();

    public static IProxy proxy;

    public static boolean curiosLoaded = false;

    @OnlyIn(Dist.CLIENT)
    public static KeyBinding keyForward;
    @OnlyIn(Dist.CLIENT)
    public static KeyBinding keyBackward;
    @OnlyIn(Dist.CLIENT)
    public static KeyBinding keyLeft;
    @OnlyIn(Dist.CLIENT)
    public static KeyBinding keyRight;
    @OnlyIn(Dist.CLIENT)
    public static KeyBinding keyUp;
    @OnlyIn(Dist.CLIENT)
    public static KeyBinding keyFlight;

    public MeteorRandomIdea() {
        proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        proxy.registerHandlers();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigHandler.CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        modBus.addGenericListener(EntityType.class, ModEntities::registerEntities);
        modBus.addGenericListener(SoundEvent.class, ModSounds::registerSounds);
        modBus.addGenericListener(Item.class, ModItems::registerItems);
        modBus.addGenericListener(Effect.class, ModPotions::registerPotions);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        curiosLoaded = ModList.get().isLoaded("curios");
        CapabilityHandler.register();
        EquipmentHandler.init();
    }

}
