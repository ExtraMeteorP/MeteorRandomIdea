package com.meteor.meteorrandomidea.common.handler;

import com.meteor.meteorrandomidea.MeteorRandomIdea;
import com.meteor.meteorrandomidea.common.entities.EntityMotor;
import com.meteor.meteorrandomidea.common.entities.EntityUfo;
import com.meteor.meteorrandomidea.common.network.MotorUpdatePack;
import com.meteor.meteorrandomidea.common.network.NetworkHandler;
import com.meteor.meteorrandomidea.common.network.UfoCatchPack;
import com.meteor.meteorrandomidea.common.network.UfoUpdatePack;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class KeyInputHandler {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        PlayerEntity p = Minecraft.getInstance().player;
        if(p == null)
            return;
        Entity riding = p.getRidingEntity();
        if(riding == null)
            return;
        if (riding instanceof EntityMotor) {
            EntityMotor steerable = (EntityMotor) riding;
            steerable.updateInput(MeteorRandomIdea.keyFlight.isKeyDown(), MeteorRandomIdea.keyUp.isKeyDown());
            NetworkHandler.INSTANCE.sendToServer(new MotorUpdatePack(MeteorRandomIdea.keyFlight.isKeyDown(), MeteorRandomIdea.keyUp.isKeyDown()));
        }
        if (riding instanceof EntityUfo) {
            EntityUfo steerable = (EntityUfo) riding;
            steerable.updateInput(MeteorRandomIdea.keyFlight.isKeyDown(), MeteorRandomIdea.keyUp.isKeyDown());
            NetworkHandler.INSTANCE.sendToServer(new UfoUpdatePack(MeteorRandomIdea.keyFlight.isKeyDown(), MeteorRandomIdea.keyUp.isKeyDown()));

            if(event.getAction() == GLFW.GLFW_PRESS && event.getKey() == GLFW.GLFW_KEY_R){

                if(steerable.getCatchedID() != -1){
                    steerable.setCatchedID(-1);
                    NetworkHandler.INSTANCE.sendToServer(new UfoCatchPack(-1));
                    return;
                }

                if(steerable.getCatchedID() == -1){
                    List<LivingEntity> entities = steerable.getEntitiesBelow();
                    if(entities.size() > 0) {
                        int id = -1;
                        float distance = 16F;
                        for(Entity e : entities){
                            if(e == p)
                                continue;
                            if(e.getDistance(steerable) < distance){
                                distance = e.getDistance(steerable);
                                id = e.getEntityId();
                            }
                        }
                        steerable.setCatchedID(id);
                        NetworkHandler.INSTANCE.sendToServer(new UfoCatchPack(id));
                    }
                }
            }
        }
    }

}
