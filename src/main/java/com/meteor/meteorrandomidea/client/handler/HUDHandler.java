package com.meteor.meteorrandomidea.client.handler;

import com.meteor.meteorrandomidea.common.handler.HerrscherHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HUDHandler {

    public static void onOverlayRender(RenderGameOverlayEvent event){
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        if (Minecraft.getInstance().player == null ) {
            return;
        }

        if(HerrscherHandler.isHerrscherOfThunder(Minecraft.getInstance().player) && !Minecraft.getInstance().player.isCreative()) {
            HerrscherGUI gui = new HerrscherGUI(event.getMatrixStack());
            gui.render();
        }

        MotorGUI motorGui = new MotorGUI(event.getMatrixStack());
        motorGui.render();

        FlamescionGUI flamescionGUI = new FlamescionGUI(event.getMatrixStack());
        flamescionGUI.render();
    }

}
