package com.meteor.meteorrandomidea.common.network.flamescion;

import com.meteor.meteorrandomidea.common.handler.FlamescionHandler;
import com.meteor.meteorrandomidea.common.items.ItemFlamescionWeapon;
import com.meteor.meteorrandomidea.common.items.ModItems;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class FlamescionStrengthenPack {

    public FlamescionStrengthenPack(PacketBuffer buffer) {

    }

    public FlamescionStrengthenPack() {

    }

    public void toBytes(PacketBuffer buf) {

    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if(ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ctx.get().getSender();
                ctx.get().enqueueWork(() -> ((ItemFlamescionWeapon) ModItems.flamescionweapon).tryStrengthenAttack(player));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
