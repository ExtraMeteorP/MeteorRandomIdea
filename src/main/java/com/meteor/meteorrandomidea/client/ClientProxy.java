package com.meteor.meteorrandomidea.client;

import com.meteor.meteorrandomidea.MeteorRandomIdea;
import com.meteor.meteorrandomidea.client.handler.HUDHandler;
import com.meteor.meteorrandomidea.client.renderer.*;
import com.meteor.meteorrandomidea.common.core.IProxy;
import com.meteor.meteorrandomidea.common.entities.ModEntities;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Map;

public class ClientProxy implements IProxy {

    public void registerModels(ModelRegistryEvent evt) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MOTOR, RenderMotor::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.KEY_OF_TRUTH, RenderKeyOfTruth::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SLASH, RenderSlash::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.UFO, RenderUfo::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PHANTOMSWORD, RenderPhantomSword::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FLAMESCIONSLASH, RenderFlamescionSlash::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SRENGTHENSLASH, RenderStrengthenSlash::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PAIMON, RenderPaimon::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ULT, RenderFlamescionUlt::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SWORD, RenderFlamescionSword::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.VOID, RenderFlamescionVoid::new);
    }

    public void onClientSetUpEvent(FMLClientSetupEvent event) {
        Minecraft mc = Minecraft.getInstance();
        GameSettings gameSettings = mc.gameSettings;
        MeteorRandomIdea.keyForward = gameSettings.keyBindForward;
        MeteorRandomIdea.keyBackward = gameSettings.keyBindBack;
        MeteorRandomIdea.keyLeft = gameSettings.keyBindLeft;
        MeteorRandomIdea.keyRight = gameSettings.keyBindRight;
        MeteorRandomIdea.keyUp = gameSettings.keyBindJump;
        MeteorRandomIdea.keyFlight = gameSettings.keyBindSprint;
    }

    @Override
    public void registerHandlers() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::onClientSetUpEvent);
        modBus.addListener(this::loadComplete);
        modBus.addListener(this::registerModels);
        modBus.addListener(MiscellaneousIcons.INSTANCE::onModelRegister);
        modBus.addListener(MiscellaneousIcons.INSTANCE::onModelBake);


        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(HUDHandler::onOverlayRender);
        forgeBus.addListener(ClientTickHandler::clientTickEnd);
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        DeferredWorkQueue.runLater(() -> {
            initAuxiliaryRender();
        });
    }

    private void initAuxiliaryRender() {
        Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getRenderManager().getSkinMap();
        PlayerRenderer render;
        render = skinMap.get("default");

        render.addLayer(new LayerHerrscher(render));
        render.addLayer(new LayerFlamescion(render));

        render = skinMap.get("slim");

        render.addLayer(new LayerHerrscher(render));
        render.addLayer(new LayerFlamescion(render));
    }

}
