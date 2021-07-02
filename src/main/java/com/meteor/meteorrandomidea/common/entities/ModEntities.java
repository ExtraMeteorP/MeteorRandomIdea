package com.meteor.meteorrandomidea.common.entities;

import com.meteor.meteorrandomidea.common.libs.LibEntityNames;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModEntities {

    public static final EntityType<EntityMotor> MOTOR = EntityType.Builder.<EntityMotor>create(
            EntityMotor::new, EntityClassification.MISC)
            .size(1.675F, 1.875F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static final EntityType<EntityKeyOfTruth> KEY_OF_TRUTH = EntityType.Builder.<EntityKeyOfTruth>create(
            EntityKeyOfTruth::new, EntityClassification.MISC)
            .size(0.1F, 0.1F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static final EntityType<EntitySlash> SLASH = EntityType.Builder.<EntitySlash>create(
            EntitySlash::new, EntityClassification.MISC)
            .size(0.1F, 0.1F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static final EntityType<EntityUfo> UFO = EntityType.Builder.<EntityUfo>create(
            EntityUfo::new, EntityClassification.MISC)
            .size(1.5F, 1.5F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static final EntityType<EntityPhantomSword> PHANTOMSWORD = EntityType.Builder.<EntityPhantomSword>create(
            EntityPhantomSword::new, EntityClassification.MISC)
            .size(0.1F, 0.1F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static final EntityType<EntityFlamescionSlash> FLAMESCIONSLASH = EntityType.Builder.<EntityFlamescionSlash>create(
            EntityFlamescionSlash::new, EntityClassification.MISC)
            .size(0.1F, 0.1F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static final EntityType<EntityStrengthenSlash> SRENGTHENSLASH = EntityType.Builder.<EntityStrengthenSlash>create(
            EntityStrengthenSlash::new, EntityClassification.MISC)
            .size(0.1F, 0.1F)
            .setUpdateInterval(10)
            .setTrackingRange(64)
            .setShouldReceiveVelocityUpdates(true)
            .build("");

    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        IForgeRegistry<EntityType<?>> r = evt.getRegistry();
        register(r, LibEntityNames.KEYOFTRUTH, KEY_OF_TRUTH);
        register(r, LibEntityNames.MOTOR, MOTOR);
        register(r, LibEntityNames.SLASH, SLASH);
        register(r, LibEntityNames.UFO, UFO);
        register(r, LibEntityNames.PHANTONSWORD, PHANTOMSWORD);
        register(r, LibEntityNames.FLAMESCIONSLASH, FLAMESCIONSLASH);
        register(r, LibEntityNames.STRENGTHENSLASH, SRENGTHENSLASH);
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, ResourceLocation name, IForgeRegistryEntry<V> thing) {
        reg.register(thing.setRegistryName(name));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, String name, IForgeRegistryEntry<V> thing) {
        register(reg, new ResourceLocation(LibMisc.MOD_ID, name), thing);
    }

}
