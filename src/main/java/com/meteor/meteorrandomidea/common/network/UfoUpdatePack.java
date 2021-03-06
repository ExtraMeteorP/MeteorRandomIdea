package com.meteor.meteorrandomidea.common.network;

import com.meteor.meteorrandomidea.common.entities.EntityMotor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class UfoUpdatePack {

    private boolean ctrlInputDown;
    private boolean upInputDown;

    public UfoUpdatePack(PacketBuffer buffer) {
        ctrlInputDown = buffer.readBoolean();
        upInputDown = buffer.readBoolean();
    }

    public UfoUpdatePack(boolean ctrlInputDown, boolean upInputDown) {
        this.ctrlInputDown = ctrlInputDown;
        this.upInputDown = upInputDown;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeBoolean(this.ctrlInputDown);
        buf.writeBoolean(this.upInputDown);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if(ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ctx.get().getSender();
                Entity riding = player.getRidingEntity();
                if (riding != null && riding instanceof EntityMotor) {
                    EntityMotor motor = (EntityMotor) riding;
                    motor.updateInput(ctrlInputDown, upInputDown);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
