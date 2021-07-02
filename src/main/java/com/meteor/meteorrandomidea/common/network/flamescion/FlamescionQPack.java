package com.meteor.meteorrandomidea.common.network.flamescion;

import com.meteor.meteorrandomidea.common.capability.CapabilityHandler;
import com.meteor.meteorrandomidea.common.capability.IFlamescion;
import com.meteor.meteorrandomidea.common.handler.FlamescionHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class FlamescionQPack {

    public FlamescionQPack(PacketBuffer buffer) {

    }

    public FlamescionQPack() {

    }

    public void toBytes(PacketBuffer buf) {

    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ctx.get().getSender();
                LazyOptional<IFlamescion> cap = player.getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
                cap.ifPresent((c) -> {
                    c.setEnergy(FlamescionHandler.MAX_FLAMESCION_ENERGY);
                    c.setOverloaded(true);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
