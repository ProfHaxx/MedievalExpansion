package com.medievalexp.client.models;

import com.medievalexp.entities.EntityGoat;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityGoatModel extends EntityModel<EntityGoat> {
    private final RendererModel one;
    private final RendererModel two;
    private final RendererModel three;
    private final RendererModel Body;
    private final RendererModel neck;
    private final RendererModel Head;
    private final RendererModel main;
    private final RendererModel mouth;
    private final RendererModel horn;
    private final RendererModel Legs;
    private final RendererModel mid;
    private final RendererModel bottom;
    private final RendererModel back;
    private final RendererModel main2;
    private final RendererModel second;

    public EntityGoatModel() {
        textureWidth = 64;
        textureHeight = 64;

        Body = new RendererModel(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 0, 0, -3.0F, -15.0F, -4.0F, 7, 7, 10, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 0, 29, 3.75F, -13.25F, -3.5F, 1, 6, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 28, 10, -3.75F, -13.25F, -3.5F, 1, 6, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 24, 0, -3.0F, -15.35F, -3.5F, 7, 1, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 31, 31, 3.55F, -15.1F, -3.5F, 1, 2, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 20, 29, -3.55F, -15.1F, -3.5F, 1, 2, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 0, 17, -4.0F, -8.75F, -4.0F, 9, 2, 10, 0.0F, false));

        neck = new RendererModel(this);
        neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(neck, -0.2618F, 0.0F, 0.0F);
        Body.addChild(neck);
        neck.cubeList.add(new ModelBox(neck, 44, 25, -2.0F, -14.8257F, -8.7424F, 5, 3, 1, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 42, 35, -2.0F, -14.5757F, -7.7424F, 5, 3, 1, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 44, 44, -2.0F, -15.3257F, -10.7424F, 5, 3, 1, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 0, 44, -2.0F, -15.0757F, -9.7424F, 5, 3, 1, 0.0F, false));

        Head = new RendererModel(this);
        Head.setRotationPoint(0.0F, 19.5F, -0.75F);

        main = new RendererModel(this);
        main.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(main, 0.0873F, 0.0F, 0.0F);
        Head.addChild(main);
        main.cubeList.add(new ModelBox(main, 35, 26, -1.0F, -13.4243F, -8.4924F, 3, 2, 4, 0.0F, false));
        main.cubeList.add(new ModelBox(main, 42, 31, -1.0F, -14.25F, -8.25F, 3, 1, 4, 0.0F, false));

        mouth = new RendererModel(this);
        mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(mouth, 0.3491F, 0.0F, 0.0F);
        Head.addChild(mouth);
        mouth.cubeList.add(new ModelBox(mouth, 0, 23, -0.5F, -13.934F, -7.3794F, 2, 1, 3, 0.0F, false));
        mouth.cubeList.add(new ModelBox(mouth, 0, 0, -0.5F, -14.5F, -7.5F, 2, 1, 3, 0.0F, false));

        horn = new RendererModel(this);
        horn.setRotationPoint(0.0F, 0.0F, 0.0F);
        Head.addChild(horn);

        one = new RendererModel(this);
        one.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(one, -0.2618F, 0.0F, 0.0F);
        one.addChild(one);
        one.cubeList.add(new ModelBox(one, 4, 48, 1.25F, -13.25F, -9.75F, 1, 2, 1, 0.0F, false));
        one.cubeList.add(new ModelBox(one, 0, 48, -1.25F, -13.25F, -9.75F, 1, 2, 1, 0.0F, false));

        two = new RendererModel(this);
        two.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(two, -0.4363F, 0.0F, 0.0F);
        horn.addChild(two);
        two.cubeList.add(new ModelBox(two, 41, 42, 1.5F, -13.0F, -11.75F, 1, 2, 1, 0.0F, false));
        two.cubeList.add(new ModelBox(two, 36, 31, -1.5F, -13.0F, -11.75F, 1, 2, 1, 0.0F, false));

        three = new RendererModel(this);
        three.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(three, -0.6109F, 0.0F, 0.0F);
        horn.addChild(three);
        three.cubeList.add(new ModelBox(three, 33, 16, 1.75F, -12.5F, -13.5F, 1, 2, 1, 0.0F, false));
        three.cubeList.add(new ModelBox(three, 25, 32, -1.75F, -12.5F, -13.5F, 1, 2, 1, 0.0F, false));

        Legs = new RendererModel(this);
        Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
        Legs.cubeList.add(new ModelBox(Legs, 32, 42, 2.5F, -9.5F, -4.5F, 3, 5, 3, 0.0F, false));
        Legs.cubeList.add(new ModelBox(Legs, 39, 10, 2.5F, -9.5F, 3.5F, 3, 5, 3, 0.0F, false));
        Legs.cubeList.add(new ModelBox(Legs, 11, 29, -4.5F, -9.5F, 3.5F, 3, 5, 3, 0.0F, false));
        Legs.cubeList.add(new ModelBox(Legs, 20, 40, -4.5F, -9.5F, -4.5F, 3, 5, 3, 0.0F, false));

        mid = new RendererModel(this);
        mid.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(mid, -0.1745F, 0.0F, 0.0F);
        Legs.addChild(mid);
        mid.cubeList.add(new ModelBox(mid, 0, 29, 3.0F, -4.1527F, -4.5696F, 2, 4, 2, 0.0F, false));
        mid.cubeList.add(new ModelBox(mid, 24, 0, -4.0F, -4.4027F, -4.3196F, 2, 4, 2, 0.0F, false));
        mid.cubeList.add(new ModelBox(mid, 0, 17, -4.0F, -5.6527F, 3.3804F, 2, 4, 2, 0.0F, false));
        mid.cubeList.add(new ModelBox(mid, 0, 4, 3.0F, -5.4027F, 3.3804F, 2, 4, 2, 0.0F, false));

        bottom = new RendererModel(this);
        bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bottom, 0.1745F, 0.0F, 0.0F);
        Legs.addChild(bottom);
        bottom.cubeList.add(new ModelBox(bottom, 47, 5, 3.0F, -1.8473F, -5.2196F, 2, 1, 2, 0.0F, false));
        bottom.cubeList.add(new ModelBox(bottom, 0, 35, -4.0F, -1.8473F, -4.7196F, 2, 1, 2, 0.0F, false));
        bottom.cubeList.add(new ModelBox(bottom, 20, 29, -4.0F, -0.4532F, 2.8896F, 2, 1, 2, 0.0F, false));
        bottom.cubeList.add(new ModelBox(bottom, 24, 6, 3.0F, -0.4532F, 2.6396F, 2, 1, 2, 0.0F, false));

        back = new RendererModel(this);
        back.setRotationPoint(0.0F, 24.0F, 0.0F);

        main2 = new RendererModel(this);
        main2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(main2, -0.3491F, 0.0F, 0.0F);
        back.addChild(main2);
        main2.cubeList.add(new ModelBox(main2, 47, 0, -0.25F, -15.0F, 1.0F, 1, 2, 3, 0.0F, false));
        main2.cubeList.add(new ModelBox(main2, 12, 44, 0.25F, -15.0F, 1.0F, 1, 2, 3, 0.0F, false));
        main2.cubeList.add(new ModelBox(main2, 31, 31, -0.75F, -15.0F, 1.0F, 1, 2, 3, 0.0F, false));

        second = new RendererModel(this);
        second.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(second, -0.4887F, 0.0F, 0.0F);
        back.addChild(second);
        second.cubeList.add(new ModelBox(second, 20, 34, -0.25F, -14.75F, 1.75F, 1, 1, 3, 0.0F, false));
    }

    public void render(EntityGoat entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        Body.render(scale);
        Head.render(scale);
        Legs.render(scale);
        back.render(scale);
    }

    private void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
