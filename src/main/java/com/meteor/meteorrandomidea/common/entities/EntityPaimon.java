package com.meteor.meteorrandomidea.common.entities;

import com.meteor.meteorrandomidea.common.core.EquipmentHandler;
import com.meteor.meteorrandomidea.common.core.ModSounds;
import com.meteor.meteorrandomidea.common.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityPaimon extends ThrowableEntity {

    private static final String TAG_PITCH = "pitch";
    private static final String TAG_ROTATION = "rotation";
    private static final String TAG_OWNER_ID = "owner_id";
    private static final String TAG_FOLLOWING = "following";
    private static final String TAG_ANIMATION = "animation";
    private static final String TAG_VOICECD = "voicecd";
    private static final String TAG_TPCD = "tpcd";

    private static final DataParameter<Integer> OWNER_ID = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.VARINT);
    private static final DataParameter<Float> PITCH = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.FLOAT);
    private static final DataParameter<Float> ROTATION = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.FLOAT);
    private static final DataParameter<Boolean> FOLLOWING = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> ANIMATION = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.VARINT);
    private static final DataParameter<Integer> VOICECD = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.VARINT);
    private static final DataParameter<Integer> TPCD = EntityDataManager.createKey(EntityPaimon.class,
            DataSerializers.VARINT);

    public EntityPaimon(EntityType<? extends EntityPaimon> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public EntityPaimon(World worldIn, double x, double y, double z) {
        super(ModEntities.PAIMON, worldIn);
        this.setPosition(x, y, z);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.setMotion(Vector3d.ZERO);
        this.setNoGravity(true);
        setAnimation(MAX_ANIMATION_TICKS);
        setVoiceCD(400);
        setTPCD(200);
        setMotion(Vector3d.ZERO);
    }

    @Override
    public void registerData() {
        this.dataManager.register(ROTATION, 0F);
        this.dataManager.register(PITCH, 0F);
        this.dataManager.register(OWNER_ID, -1);
        this.dataManager.register(FOLLOWING, false);
        this.dataManager.register(ANIMATION, 0);
        this.dataManager.register(VOICECD, 0);
        this.dataManager.register(TPCD, 0);
    }

    private int stayTicks = 0;
    private int tooFarTicks = 0;
    private int i = 0;
    private int MAX_ANIMATION_TICKS = 20;

    @Override
    public void tick() {

        PlayerEntity player = null;

        super.tick();

        if(getAnimation() > 0){
            setAnimation(getAnimation()-1);
            if(getAnimation() <= MAX_ANIMATION_TICKS) {
                this.setMotion(0D, 0.08D, 0D);
                if (world.isRemote) {
                    i += 30;
                    float r = 1F;
                    double x = this.getPosX() + r * Math.cos(Math.toRadians(i));
                    double y = this.getPosY() + i / 24 * 0.05F;
                    double z = this.getPosZ() + r * Math.sin(Math.toRadians(i));
                    world.addParticle(ParticleTypes.END_ROD, x, y, z, 0, -0.04D, 0);
                }
                Vector3d v = this.getPositionVec().add(this.getLookVec().rotateYaw((float) Math.toRadians(60D)));
                facePos(v.x, v.y, v.z);
            }
            return;
        }

        if(getVoiceCD() > 0)
            setVoiceCD(getVoiceCD()-1);
        if(getTPCD() > 0)
            setTPCD(getTPCD()-1);

        if(getOwnerID() != -1){
            Entity owner = world.getEntityByID(getOwnerID());
            if(owner instanceof PlayerEntity) {
                player = (PlayerEntity) owner;
            }
        }

        if(player == null || EquipmentHandler.findOrEmpty(ModItems.paimonmedal, player).isEmpty()) {
            if(world.isRemote)
                for(i = 0; i < 720; i+=24) {
                    float r = 0.6F;
                    double x = this.getPosX() + r * Math.cos(Math.toRadians(i));
                    double y = this.getPosY() - 0.25D + i / 15 * 0.05F;
                    double z = this.getPosZ() + r * Math.sin(Math.toRadians(i));
                    world.addParticle(ParticleTypes.END_ROD, x, y, z, 0, -0.04D, 0);
                }
            if(!world.isRemote) {
                setVoiceCD(200);
                setTPCD(200);
                randomVanishSound(world.rand.nextInt(7));
            }
            remove();
            return;
        }

        Vector3d playerPos = player.getPositionVec();
        Vector3d lookVec = new Vector3d(player.getLookVec().x, 0, player.getLookVec().z).normalize().rotateYaw((float) Math.toRadians(30D)).inverse().scale(1.1D);
        Vector3d targetPos = playerPos.add(lookVec.x, lookVec.y, lookVec.z).add(0, 1.2D, 0);

        if(this.getPositionVec().distanceTo(targetPos) >= 16)
            tooFarTicks++;
        else
            tooFarTicks=0;

        if(tooFarTicks >= 20){
            tooFarTicks=0;
            this.setPositionAndUpdate(targetPos.x, targetPos.y, targetPos.z);
            this.setMotion(Vector3d.ZERO);
            if(getTPCD() == 0){
                if(!world.isRemote)
                    randomTPSound(world.rand.nextInt(3));
                setTPCD(400);
                setVoiceCD(300);
            }
            setAnimation(MAX_ANIMATION_TICKS);
            return;
        }

        i=0;

        if(getVoiceCD() == 0){
            if(!world.isRemote)
                randomSound(world.rand.nextInt(10)+1);
            setVoiceCD((int) (600 + Math.random()*300));
            setTPCD(200);
        }

        if(posEqual(this.getPositionVec(), targetPos))
            stayTicks++;
        else
            stayTicks=0;

        if(stayTicks >= 8 && posEqual(this.getPositionVec(), targetPos))
            setFollowing(false);
        else
            setFollowing(true);

        if(getFollowing()){
            Vector3d motion = new Vector3d(targetPos.x - getPosX(), targetPos.y - getPosY(), targetPos.z - getPosZ()).normalize().scale(0.22F);
            if(!posEqual(this.getPositionVec(), targetPos)) {
                this.setMotion(motion);
                this.faceEntity(player, 360F, 360F);
                if(this.ticksExisted % 12 == 0){
                    if(world.isRemote)
                        world.addParticle(ParticleTypes.END_ROD, getPosX()-motion.x, getPosY(), getPosZ()-motion.z, -motion.x, -0.05D, -motion.z);
                }
            }else
                this.setMotion(Vector3d.ZERO);
        }else {
            this.setMotion(Vector3d.ZERO);
        }

    }

    public void randomVanishSound(int i){
        switch (i) {
            case 0:
                this.playSound(ModSounds.paimon_vanish_0, 1F, 1F);
                break;
            case 1:
                this.playSound(ModSounds.paimon_vanish_1, 1F, 1F);
                break;
            case 2:
                this.playSound(ModSounds.paimon_vanish_2, 1F, 1F);
                break;
            case 3:
                this.playSound(ModSounds.paimon_vanish_3, 1F, 1F);
                break;
            case 4:
                this.playSound(ModSounds.paimon_vanish_4, 1F, 1F);
                break;
            case 5:
                this.playSound(ModSounds.paimon_vanish_5, 1F, 1F);
                break;
            case 6:
                this.playSound(ModSounds.paimon_vanish_6, 1F, 1F);
                break;
        }
    }

    public void randomTPSound(int i) {
        switch (i) {
            case 0:
                this.playSound(ModSounds.paimon_tp_0, 1F, 1F);
                break;
            case 1:
                this.playSound(ModSounds.paimon_tp_1, 1F, 1F);
                break;
            case 2:
                this.playSound(ModSounds.paimon_tp_2, 1F, 1F);
                break;
        }
    }

    public void randomSound(int i){
        switch(i){
            case 1:
                this.playSound(ModSounds.paimon_1, 1F, 1F);
                break;
            case 2:
                this.playSound(ModSounds.paimon_2, 1F, 1F);
                break;
            case 3:
                this.playSound(ModSounds.paimon_3, 1F, 1F);
                break;
            case 4:
                this.playSound(ModSounds.paimon_4, 1F, 1F);
                break;
            case 5:
                this.playSound(ModSounds.paimon_5, 1F, 1F);
                break;
            case 6:
                this.playSound(ModSounds.paimon_6, 1F, 1F);
                break;
            case 7:
                this.playSound(ModSounds.paimon_7, 1F, 1F);
                break;
            case 8:
                this.playSound(ModSounds.paimon_8, 1F, 1F);
                break;
            case 9:
                this.playSound(ModSounds.paimon_9, 1F, 1F);
                break;
            case 10:
                this.playSound(ModSounds.paimon_10, 1F, 1F);
                break;
        }
    }

    @Override
    protected void func_234617_x_() {

    }

    public void facePos(double x, double y, double z){
        double d0 = x - this.getPosX();
        double d2 = z - this.getPosZ();
        double d1 = y;

        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
        float f1 = (float) (-(MathHelper.atan2(d1, d3) * (double) (180F / (float) Math.PI)));
        this.rotationPitch = this.updateRotation(this.rotationPitch, f1, 360);
        this.rotationYaw = this.updateRotation(this.rotationYaw, f, 360);
    }

    public void faceEntity(Entity entityIn, float maxYawIncrease, float maxPitchIncrease) {
        double d0 = entityIn.getPosX() - this.getPosX();
        double d2 = entityIn.getPosZ() - this.getPosZ();
        double d1;
        if (entityIn instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) entityIn;
            d1 = livingentity.getPosYEye() - this.getPosYEye();
        } else {
            d1 = (entityIn.getBoundingBox().minY + entityIn.getBoundingBox().maxY) / 2.0D - this.getPosYEye();
        }

        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
        float f1 = (float) (-(MathHelper.atan2(d1, d3) * (double) (180F / (float) Math.PI)));
        this.rotationPitch = this.updateRotation(this.rotationPitch, f1, maxPitchIncrease);
        this.rotationYaw = this.updateRotation(this.rotationYaw, f, maxYawIncrease);
    }

    private float updateRotation(float angle, float targetAngle, float maxIncrease) {
        float f = MathHelper.wrapDegrees(targetAngle - angle);
        if (f > maxIncrease) {
            f = maxIncrease;
        }

        if (f < -maxIncrease) {
            f = -maxIncrease;
        }

        return angle + f;
    }

    public boolean posEqual(Vector3d v1, Vector3d v2){
        return v1.distanceTo(v2) <= 0.25D;
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        setOwnerID(compound.getInt(TAG_OWNER_ID));
        setRotation(compound.getFloat(TAG_ROTATION));
        setPitch(compound.getFloat(TAG_PITCH));
        setFollowing(compound.getBoolean(TAG_FOLLOWING));
        setAnimation(compound.getInt(TAG_ANIMATION));
        setVoiceCD(compound.getInt(TAG_VOICECD));
        setTPCD(compound.getInt(TAG_TPCD));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putInt(TAG_OWNER_ID, getOwnerID());
        compound.putFloat(TAG_ROTATION, getRotation());
        compound.putFloat(TAG_PITCH, getPitch());
        compound.putBoolean(TAG_FOLLOWING, getFollowing());
        compound.putInt(TAG_ANIMATION, getAnimation());
        compound.putInt(TAG_VOICECD, getVoiceCD());
        compound.putInt(TAG_TPCD, getTPCD());
    }

    public void setAnimation(int i) {
        this.dataManager.set(ANIMATION, i);
    }

    public int getAnimation() {
        return this.dataManager.get(ANIMATION);
    }

    public void setVoiceCD(int i) {
        this.dataManager.set(VOICECD, i);
    }

    public int getVoiceCD() {
        return this.dataManager.get(VOICECD);
    }

    public void setTPCD(int i) {
        this.dataManager.set(TPCD, i);
    }

    public int getTPCD() {
        return this.dataManager.get(TPCD);
    }

    public void setOwnerID(int i) {
        this.dataManager.set(OWNER_ID, i);
    }

    public int getOwnerID() {
        return this.dataManager.get(OWNER_ID);
    }

    public float getRotation() {
        return dataManager.get(ROTATION);
    }

    public void setRotation(float rot) {
        dataManager.set(ROTATION, rot);
    }

    public float getPitch() {
        return dataManager.get(PITCH);
    }

    public void setPitch(float rot) {
        dataManager.set(PITCH, rot);
    }

    public boolean getFollowing(){
        return dataManager.get(FOLLOWING);
    }

    public void setFollowing(boolean following){
        dataManager.set(FOLLOWING, following);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
