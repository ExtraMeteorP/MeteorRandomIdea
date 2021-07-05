package com.meteor.meteorrandomidea.client.renderer;

import com.meteor.meteorrandomidea.client.ClientTickHandler;
import com.meteor.meteorrandomidea.client.model.ModelPaimon;
import com.meteor.meteorrandomidea.common.entities.EntityPaimon;
import com.meteor.meteorrandomidea.common.libs.LibMisc;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderPaimon extends EntityRenderer<EntityPaimon> {

    private EntityModel<EntityPaimon> paimonModel = new ModelPaimon();

    public RenderPaimon(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(EntityPaimon entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.0D, 1D, 0.0D);
        if(!entityIn.getFollowing())
            matrixStackIn.translate(0D, 0.06D*Math.sin(ClientTickHandler.ticksInGame*0.1F), 0D);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(entityIn.getRotation()));
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(entityIn.getPitch()));
        //matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
        float s = 0.65F;
        this.paimonModel.setRotationAngles(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.paimonModel.getRenderType(this.getEntityTexture(entityIn)));
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.scale(s, s, s);
        this.paimonModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.scale(1F/s, 1F/s, 1F/s);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPaimon entity) {
        return new ResourceLocation(LibMisc.MOD_ID, "textures/entity/paimon.png");
    }
}
