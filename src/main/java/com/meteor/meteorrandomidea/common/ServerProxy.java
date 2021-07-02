package com.meteor.meteorrandomidea.common;

import com.meteor.meteorrandomidea.common.core.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

public class ServerProxy implements IProxy {

    @Override
    public void registerHandlers() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
    }

}
