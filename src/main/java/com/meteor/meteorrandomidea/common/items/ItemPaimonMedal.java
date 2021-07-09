package com.meteor.meteorrandomidea.common.items;

import com.meteor.meteorrandomidea.MeteorRandomIdea;
import com.meteor.meteorrandomidea.common.core.ModSounds;
import com.meteor.meteorrandomidea.common.entities.EntityPaimon;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import top.theillusivec4.curios.api.event.DropRulesEvent;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.List;

public class ItemPaimonMedal extends ItemBauble {

    public static String TAG_PAIMONID = "paimon_id";
    public static String TAG_PAIMONREWARD = "paimonreward";

    public ItemPaimonMedal() {
        super(new Properties().group(MeteorRandomIdea.itemGroup).rarity(Rarity.EPIC).maxStackSize(1).setNoRepair());
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerJoinWorld);
        MinecraftForge.EVENT_BUS.addListener(this::keepCurioDrops);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        super.addInformation(stack, world, tooltip, flags);
        tooltip.add(new TranslationTextComponent("meteorrandomidea.paimonmedalinfo").mergeStyle(TextFormatting.ITALIC));
    }

    @Override
    public void onWornTick(ItemStack stack, LivingEntity entity) {
        super.onWornTick(stack, entity);
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            CompoundNBT nbt = stack.getOrCreateTag();
            if (!nbt.contains(TAG_PAIMONID))
                nbt.putInt(TAG_PAIMONID, -1);

            int id = nbt.getInt(TAG_PAIMONID);
            Entity e = player.world.getEntityByID(id);
            if (e == null || !(e instanceof EntityPaimon)) {
                Vector3d lookVec = player.getLookVec().normalize().scale(1.5D);
                Vector3d spawnPoint = player.getPositionVec().add(lookVec.x, 1D, lookVec.z);
                EntityPaimon paimon = new EntityPaimon(player.world, spawnPoint.x, spawnPoint.y, spawnPoint.z);
                paimon.setOwnerID(player.getEntityId());
                paimon.faceEntity(player, 360, 360);
                if (!player.world.isRemote) {
                    player.world.addEntity(paimon);
                    randomVanishSound(paimon, player.world.rand.nextInt(2));
                }
                nbt.putInt(TAG_PAIMONID, paimon.getEntityId());
            }

        }
    }

    public void randomVanishSound(Entity entity, int i){
        switch (i){
            case 0:
                entity.playSound(ModSounds.paimon_spawn_0, 1F, 1F);
                break;
            case 1:
                entity.playSound(ModSounds.paimon_0, 1F, 1F);
                break;
        }
    }

    @SubscribeEvent
    public void keepCurioDrops(DropRulesEvent event) {
        event.addOverride(stack -> {
            if (stack.getItem() == this) {
                return true;
            }
            return false;
        }, ICurio.DropRule.ALWAYS_KEEP);
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event){
        CompoundNBT nbtData = event.getPlayer().getPersistentData();
        CompoundNBT data = nbtData.getCompound(PlayerEntity.PERSISTED_NBT_TAG);
        if (!data.getBoolean(TAG_PAIMONREWARD)) {
            ItemHandlerHelper.giveItemToPlayer(event.getPlayer(), new ItemStack(ModItems.paimonmedal));
            data.putBoolean(TAG_PAIMONREWARD, true);
            nbtData.put(PlayerEntity.PERSISTED_NBT_TAG, data);
        }
    }

}
