package com.meteor.meteorrandomidea.common.items;


import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBaubleCosmetic extends ItemBauble {

    public enum Variant {
        FOX_EAR(true), FOX_MASK(true), PYLON(true), BLACK_GLASSES(true), RED_SCARF, SUPER_CROWN(true), THUG_LIFE(true), MASK(true);
        private final boolean isHead;

        Variant(boolean isHead) {
            this.isHead = isHead;
        }

        Variant() {
            this(false);
        }
    }

    private final Variant variant;
    public static final int SUBTYPES = Variant.values().length;

    public ItemBaubleCosmetic(Variant variant, Properties props) {
        super(props);
        this.variant = variant;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void doRender(BipedModel<?> bipedModel, ItemStack stack, LivingEntity player, MatrixStack ms, IRenderTypeBuffer buffers, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Variant variant = ((ItemBaubleCosmetic) stack.getItem()).variant;
        if (variant.isHead) {
            bipedModel.bipedHead.translateRotate(ms);
            switch (variant) {
                case FOX_EAR:
                    ms.push();
                    ms.translate(0, -0.8, -0.1F);
                    ms.scale(0.8F, -0.8F, -0.8F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
                case FOX_MASK:
                    ms.push();
                    ms.translate(0.02F, -0.3, -0.25);
                    ms.scale(0.7F, -0.7F, -0.7F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
                case MASK:
                    ms.push();
                    ms.translate(0F, -0.3, -0.25);
                    ms.scale(0.65F, -0.65F, -0.65F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
                case BLACK_GLASSES:
                    ms.push();
                    ms.translate(0, -0.2, -0.3);
                    ms.scale(0.55F, 0.55F, -0.55F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
                case SUPER_CROWN:
                    ms.push();
                    ms.translate(0, -0.7, -0.1F);
                    ms.scale(0.65F, -0.65F, -0.65F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
                case PYLON:
                    ms.push();
                    ms.translate(0, -0.8, -0.1F);
                    ms.scale(0.5F, -0.5F, -0.5F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
                case THUG_LIFE:
                    ms.push();
                    ms.translate(0, -0.2, -0.3);
                    ms.scale(0.7F, -0.7F, -0.7F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
            }
        }else {
            bipedModel.bipedBody.translateRotate(ms);
            switch (variant) {
                case RED_SCARF:
                    ms.push();
                    ms.translate(0, 0.16, -0.15);
                    ms.scale(0.55F, -0.55F, -0.55F);
                    renderItem(stack, ms, buffers, light);
                    ms.pop();
                    break;
            }
        }
    }

    public static void renderItem(ItemStack stack, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.NO_OVERLAY, ms, buffers);
    }

}
