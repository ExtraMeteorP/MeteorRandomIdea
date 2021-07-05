package com.meteor.meteorrandomidea.client.model;

import com.meteor.meteorrandomidea.client.ClientTickHandler;
import com.meteor.meteorrandomidea.common.entities.EntityPaimon;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPaimon extends EntityModel<EntityPaimon> {

    private final ModelRenderer bone;
    private final ModelRenderer cube_r1;
    private final ModelRenderer bone6;
    private final ModelRenderer bone5;
    private final ModelRenderer bone2;
    private final ModelRenderer bone8;
    private final ModelRenderer bone9;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone7;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;

    public ModelPaimon() {
        textureWidth = 80;
        textureHeight = 80;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.setTextureOffset(21, 19).addBox(-3.0F, -13.0F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(4.5F, -15.5F, -4.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -0.1309F, -0.3927F);
        cube_r1.setTextureOffset(0, 0).addBox(-2.6F, -0.35F, -0.3F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        cube_r1.setTextureOffset(0, 1).addBox(-0.6F, -0.35F, -0.3F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        cube_r1.setTextureOffset(13, 24).addBox(-1.6F, -1.1F, -0.3F, 1.0F, 3.0F, 0.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, -19.3167F, 0.05F);
        bone.addChild(bone6);
        setRotationAngle(bone6, -0.2531F, 0.0F, 0.0F);
        bone6.setTextureOffset(0, 16).addBox(-0.5F, -1.5833F, -2.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(47, 62).addBox(2.5F, -0.5833F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(0, 62).addBox(-3.5F, -0.5833F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(4, 62).addBox(-3.5F, -0.5833F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(8, 62).addBox(2.5F, -0.5833F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(12, 62).addBox(1.5F, -0.5833F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(24, 56).addBox(-2.5F, -0.5833F, 3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(38, 62).addBox(-2.5F, -0.5833F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone6.setTextureOffset(58, 2).addBox(3.5F, -0.5833F, -0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone6.setTextureOffset(55, 57).addBox(-4.5F, -0.5833F, -0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.setTextureOffset(0, 8).addBox(-4.0F, -16.0F, -3.0F, 8.0F, 1.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(0, 16).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(63, 21).addBox(-5.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 0).addBox(6.0F, -13.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone5.setTextureOffset(34, 62).addBox(7.0F, -12.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(42, 44).addBox(5.0F, -11.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(0, 33).addBox(-6.0F, -14.0F, -3.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(15, 40).addBox(-6.0F, -11.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(30, 29).addBox(3.0F, -12.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(36, 9).addBox(1.0F, -12.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 29).addBox(-3.0F, -12.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(13, 28).addBox(-5.0F, -12.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 0).addBox(-5.0F, -15.0F, -3.0F, 10.0F, 1.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(31, 44).addBox(-4.0F, -13.0F, 3.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(42, 17).addBox(-4.0F, -15.0F, 4.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(36, 29).addBox(-4.0F, -14.0F, 5.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(51, 48).addBox(-3.0F, -15.0F, 5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(51, 46).addBox(-3.0F, -8.0F, 5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(42, 52).addBox(-3.0F, -16.0F, 4.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(23, 8).addBox(4.0F, -13.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(38, 18).addBox(3.0F, -10.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(22, 48).addBox(-4.0F, -10.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 24).addBox(-5.0F, -13.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(63, 2).addBox(-4.0F, -13.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(63, 0).addBox(3.0F, -13.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(53, 28).addBox(-3.0F, -16.0F, -4.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(43, 15).addBox(-4.0F, -15.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(28, 49).addBox(0.0F, -12.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(4, 24).addBox(4.0F, -13.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(4, 16).addBox(-5.0F, -13.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(0, 24).addBox(2.0F, -14.0F, -3.0F, 3.0F, 2.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(23, 9).addBox(-5.0F, -14.0F, -3.0F, 3.0F, 2.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(28, 50).addBox(4.0F, -16.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone5.setTextureOffset(27, 33).addBox(5.0F, -14.0F, -3.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
        bone5.setTextureOffset(21, 48).addBox(5.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone5.setTextureOffset(36, 36).addBox(-5.0F, -7.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 60).addBox(-6.0F, -8.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(58, 21).addBox(-6.0F, -9.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone5.setTextureOffset(0, 12).addBox(-6.0F, -8.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone5.setTextureOffset(20, 62).addBox(-6.0F, -7.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 8).addBox(-7.0F, -13.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone5.setTextureOffset(28, 62).addBox(-8.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(24, 62).addBox(-7.0F, -8.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(9, 48).addBox(-6.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone5.setTextureOffset(35, 51).addBox(3.0F, -17.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone5.setTextureOffset(49, 31).addBox(-5.0F, -16.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone5.setTextureOffset(49, 37).addBox(-4.0F, -17.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone5.setTextureOffset(9, 33).addBox(4.0F, -9.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(63, 40).addBox(2.0F, -4.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(22, 54).addBox(-1.0F, -13.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(36, 13).addBox(-5.0F, -14.0F, -4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 33).addBox(3.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(63, 19).addBox(4.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(63, 17).addBox(4.0F, -7.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(16, 40).addBox(3.0F, -8.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(24, 45).addBox(3.0F, -9.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(24, 58).addBox(5.0F, -9.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone5.setTextureOffset(16, 62).addBox(5.0F, -8.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(19, 19).addBox(5.0F, -9.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone5.setTextureOffset(19, 16).addBox(-6.0F, -9.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone5.setTextureOffset(61, 62).addBox(3.0F, -6.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(51, 62).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(36, 38).addBox(3.0F, -7.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 45).addBox(-4.0F, -7.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(60, 14).addBox(3.0F, -8.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 43).addBox(-5.0F, -8.0F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(27, 0).addBox(-5.0F, -13.0F, 4.0F, 10.0F, 5.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(37, 37).addBox(3.0F, -10.0F, -2.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
        bone5.setTextureOffset(62, 60).addBox(-5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(0, 38).addBox(-5.0F, -9.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(9, 38).addBox(-5.0F, -8.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(36, 6).addBox(-6.0F, -10.0F, -2.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
        bone5.setTextureOffset(49, 37).addBox(-4.0F, -8.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(35, 50).addBox(-5.0F, -9.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone5.setTextureOffset(31, 63).addBox(-3.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 24.0F, 0.5F);


        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(3.5F, -7.75F, 0.25F);
        bone2.addChild(bone8);
        setRotationAngle(bone8, 0.0F, 0.0F, -0.7418F);
        bone8.setTextureOffset(16, 54).addBox(-1.5273F, 0.1303F, -0.75F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        bone8.setTextureOffset(29, 58).addBox(-1.0273F, 4.1303F, -1.25F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(-3.25F, -8.0F, 0.5F);
        bone2.addChild(bone9);
        setRotationAngle(bone9, 0.0F, 0.0F, 0.7418F);
        bone9.setTextureOffset(32, 6).addBox(-1.1745F, 4.3203F, -1.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        bone9.setTextureOffset(47, 54).addBox(-0.6745F, 0.3203F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 16.5F, 0.0F);
        setRotationAngle(bone3, 0.2182F, 0.0F, 0.0F);
        bone3.setTextureOffset(16, 29).addBox(-2.5F, -0.9F, -1.25F, 5.0F, 7.0F, 4.0F, 0.0F, false);
        bone3.setTextureOffset(48, 2).addBox(1.0F, 5.7F, -1.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);
        bone3.setTextureOffset(0, 47).addBox(-3.0F, 5.7F, -1.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 6.75F, 0.5F);
        bone3.addChild(bone4);
        setRotationAngle(bone4, 0.3927F, 0.0F, 0.0F);
        bone4.setTextureOffset(8, 54).addBox(-2.25F, -1.25F, -0.75F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        bone4.setTextureOffset(56, 37).addBox(-2.75F, 2.25F, -1.25F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone4.setTextureOffset(13, 24).addBox(1.75F, 2.25F, -1.25F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone4.setTextureOffset(0, 52).addBox(0.25F, -1.25F, -0.75F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, 7.5F, 0.0F);
        bone3.addChild(bone7);
        bone7.setTextureOffset(35, 57).addBox(-2.0F, -8.0F, 2.4F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(23, 13).addBox(-1.0F, -7.0F, -1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(51, 44).addBox(-3.0F, -7.0F, 1.9F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(56, 33).addBox(-2.0F, -4.6F, 3.6F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(48, 10).addBox(-3.0F, -3.0F, 3.7F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(37, 59).addBox(-1.5F, -2.5F, 4.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(0, 4).addBox(-0.7F, -1.6F, 5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(61, 38).addBox(-1.3F, 1.0F, 4.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(0, 21).addBox(-1.1F, 0.0F, 4.7F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(56, 30).addBox(-1.75F, -3.6F, 4.2F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(48, 7).addBox(-3.0F, -5.0F, 3.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(16, 48).addBox(3.0F, -5.0F, 2.75F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(10, 47).addBox(-4.0F, -5.0F, 2.75F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(61, 6).addBox(2.5F, -6.0F, 2.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(60, 18).addBox(-3.5F, -6.0F, 2.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(55, 55).addBox(-2.5F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(49, 0).addBox(-3.0F, -7.0F, 2.9F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(43, 24).addBox(-3.0F, -7.0F, -1.1F, 6.0F, 1.0F, 3.0F, 0.0F, false);
        bone7.setTextureOffset(57, 12).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setTextureOffset(54, 50).addBox(2.0F, -8.0F, -1.3F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone7.setTextureOffset(16, 48).addBox(-3.0F, -8.0F, -1.3F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone7.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.0873F);
        cube_r2.setTextureOffset(24, 43).addBox(-4.3F, -3.0F, 3.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(18, 45).addBox(-4.9F, -1.0F, 3.35F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(38, 22).addBox(-4.9F, -2.9F, 2.85F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(49, 40).addBox(-5.1F, -2.0F, 3.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(60, 57).addBox(-4.3F, -2.0F, 3.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(61, 36).addBox(-3.3F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(38, 6).addBox(-5.5F, 0.5F, 3.05F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(61, 9).addBox(-4.5F, 0.0F, 3.55F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(60, 52).addBox(-4.1F, -1.0F, 3.85F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(31, 61).addBox(-3.1F, -1.0F, 4.35F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone7.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, -0.0873F);
        cube_r3.setTextureOffset(58, 25).addBox(1.4F, -3.0F, 3.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(44, 61).addBox(2.4F, 0.0F, 4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(54, 61).addBox(3.4F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(14, 54).addBox(3.2F, 0.0F, 3.55F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(42, 54).addBox(3.9F, -1.0F, 3.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(35, 53).addBox(4.2F, -2.0F, 2.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(60, 16).addBox(4.0F, -3.0F, 2.45F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(60, 50).addBox(3.4F, -2.0F, 3.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(58, 61).addBox(2.4F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-3.8F, -4.2F, 2.85F);
        bone7.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.1309F);
        cube_r4.setTextureOffset(0, 47).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone7.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(60, 42).addBox(1.9F, 1.0F, 4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(EntityPaimon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        if(entity.getFollowing()){
            setRotationAngle(bone8, 0F, 0F, (float) Math.toRadians(-42.5F + 4F*Math.sin(ClientTickHandler.ticksInGame*0.1F)));
            setRotationAngle(bone9, 0F, 0F, (float) Math.toRadians(42.5F - 4F*Math.sin(ClientTickHandler.ticksInGame*0.1F)));
            setRotationAngle(bone3, (float) Math.toRadians(12.5F), 0F,0F);
            setRotationAngle(bone4, (float) Math.toRadians(22.5F + 5F*Math.sin(ClientTickHandler.ticksInGame*0.1F)), 0F, 0F);
        }else {
            setRotationAngle(bone8, 0F, 0F, (float) Math.toRadians(-27.5F + 4F*Math.sin(ClientTickHandler.ticksInGame*0.1F)));
            setRotationAngle(bone9, 0F, 0F, (float) Math.toRadians(27.5F - 4F*Math.sin(ClientTickHandler.ticksInGame*0.1F)));
            setRotationAngle(bone3, (float) Math.toRadians(-2.5F), 0F,0F);
            setRotationAngle(bone4, (float) Math.toRadians(-2.5F + 5F*Math.sin(ClientTickHandler.ticksInGame*0.1F)), 0F, 0F);
        }
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
        bone2.render(matrixStack, buffer, packedLight, packedOverlay);
        bone3.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
