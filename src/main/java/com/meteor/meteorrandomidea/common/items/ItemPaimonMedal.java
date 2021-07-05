package com.meteor.meteorrandomidea.common.items;

import com.meteor.meteorrandomidea.MeteorRandomIdea;
import com.meteor.meteorrandomidea.common.core.ModSounds;
import com.meteor.meteorrandomidea.common.entities.EntityPaimon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.vector.Vector3d;

public class ItemPaimonMedal extends ItemBauble {

    public static String TAG_PAIMONID = "paimon_id";

    public ItemPaimonMedal() {
        super(new Properties().group(MeteorRandomIdea.itemGroup).rarity(Rarity.EPIC).maxStackSize(1).setNoRepair());
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

}
