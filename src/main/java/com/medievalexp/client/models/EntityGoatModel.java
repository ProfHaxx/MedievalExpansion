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
        Body.cubeList.add(new ModelBox(Body, 0, 12, -3.0F, -11.0F, -4.0F, 7, 4, 10, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 0, 26, 3.75F, -10.0F, -4.0F, 1, 3, 10, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 24, 24, -3.75F, -10.0F, -4.0F, 1, 3, 10, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 24, 12, -2.5F, -11.25F, -3.5F, 6, 1, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 13, 30, 3.5F, -10.5F, -3.5F, 1, 1, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 28, 0, -3.5F, -10.5F, -3.5F, 1, 1, 9, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 0, 0, -4.0F, -7.0F, -4.0F, 9, 2, 10, 0.0F, false));

        neck = new RendererModel(this);
        neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(neck, -0.0873F, 0.0F, 0.0F);
        Body.addChild(neck);
        neck.cubeList.add(new ModelBox(neck, 12, 44, -2.0F, -11.8257F, -5.4924F, 5, 3, 1, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 12, 40, -2.0F, -11.3257F, -4.4924F, 5, 3, 1, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 42, 37, -2.0F, -12.3257F, -7.4924F, 5, 3, 1, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 42, 42, -2.0F, -12.0757F, -6.4924F, 5, 3, 1, 0.0F, false));

        Head = new RendererModel(this);
        Head.setRotationPoint(0.0F, 24.0F, 0.0F);

        main = new RendererModel(this);
        main.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(main, 0.0873F, 0.0F, 0.0F);
        Head.addChild(main);
        main.cubeList.add(new ModelBox(main, 36, 29, -1.0F, -13.4243F, -7.7424F, 3, 2, 3, 0.0F, false));
        main.cubeList.add(new ModelBox(main, 12, 26, -1.0F, -14.25F, -7.5F, 3, 1, 3, 0.0F, false));

        mouth = new RendererModel(this);
        mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(mouth, 0.3491F, 0.0F, 0.0F);
        Head.addChild(mouth);
        mouth.cubeList.add(new ModelBox(mouth, 0, 4, -0.5F, -13.684F, -6.1294F, 2, 1, 3, 0.0F, false));
        mouth.cubeList.add(new ModelBox(mouth, 0, 0, -0.5F, -14.25F, -6.25F, 2, 1, 3, 0.0F, false));

        horn = new RendererModel(this);
        horn.setRotationPoint(0.0F, 0.0F, 0.0F);
        Head.addChild(horn);

        one = new RendererModel(this);
        one.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(one, -0.2618F, 0.0F, 0.0F);
        horn.addChild(one);
        one.cubeList.add(new ModelBox(one, 34, 44, 1.25F, -13.25F, -9.75F, 1, 2, 1, 0.0F, false));
        one.cubeList.add(new ModelBox(one, 30, 44, -1.25F, -13.25F, -9.75F, 1, 2, 1, 0.0F, false));

        two = new RendererModel(this);
        two.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(two, -0.4363F, 0.0F, 0.0F);
        horn.addChild(two);
        two.cubeList.add(new ModelBox(two, 29, 17, 1.5F, -13.0F, -11.75F, 1, 2, 1, 0.0F, false));
        two.cubeList.add(new ModelBox(two, 29, 12, -1.5F, -13.0F, -11.75F, 1, 2, 1, 0.0F, false));

        three = new RendererModel(this);
        three.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(three, -0.6109F, 0.0F, 0.0F);
        horn.addChild(three);
        three.cubeList.add(new ModelBox(three, 5, 17, 1.75F, -12.5F, -13.5F, 1, 2, 1, 0.0F, false));
        three.cubeList.add(new ModelBox(three, 5, 12, -1.75F, -12.5F, -13.5F, 1, 2, 1, 0.0F, false));

        Legs = new RendererModel(this);
        Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
        Legs.cubeList.add(new ModelBox(Legs, 39, 0, 2.5F, -7.0F, -4.5F, 3, 4, 3, 0.0F, false));
        Legs.cubeList.add(new ModelBox(Legs, 30, 37, 2.5F, -7.0F, 3.25F, 3, 4, 3, 0.0F, false));
        Legs.cubeList.add(new ModelBox(Legs, 36, 22, -4.5F, -7.0F, 3.25F, 3, 4, 3, 0.0F, false));
        Legs.cubeList.add(new ModelBox(Legs, 0, 39, -4.5F, -7.0F, -4.5F, 3, 4, 3, 0.0F, false));

        mid = new RendererModel(this);
        mid.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(mid, -0.1745F, 0.0F, 0.0F);
        Legs.addChild(mid);
        mid.cubeList.add(new ModelBox(mid, 12, 30, 3.0F, -2.9027F, -4.3196F, 2, 3, 2, 0.0F, false));
        mid.cubeList.add(new ModelBox(mid, 28, 0, -4.0F, -2.9027F, -4.3196F, 2, 3, 2, 0.0F, false));
        mid.cubeList.add(new ModelBox(mid, 24, 26, -4.0F, -3.9027F, 2.8804F, 2, 3, 2, 0.0F, false));
        mid.cubeList.add(new ModelBox(mid, 0, 26, 3.0F, -3.9027F, 2.8804F, 2, 3, 2, 0.0F, false));

        bottom = new RendererModel(this);
        bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bottom, 0.1745F, 0.0F, 0.0F);
        Legs.addChild(bottom);
        bottom.cubeList.add(new ModelBox(bottom, 23, 42, 3.0F, -1.3473F, -4.7196F, 2, 1, 2, 0.0F, false));
        bottom.cubeList.add(new ModelBox(bottom, 24, 31, -4.0F, -1.3473F, -4.7196F, 2, 1, 2, 0.0F, false));
        bottom.cubeList.add(new ModelBox(bottom, 0, 31, -4.0F, 0.0468F, 2.3896F, 2, 1, 2, 0.0F, false));
        bottom.cubeList.add(new ModelBox(bottom, 28, 5, 3.0F, 0.0468F, 2.3896F, 2, 1, 2, 0.0F, false));

        back = new RendererModel(this);
        back.setRotationPoint(0.0F, 24.0F, 0.0F);

        main2 = new RendererModel(this);
        main2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(main2, -0.3491F, 0.0F, 0.0F);
        back.addChild(main2);
        main2.cubeList.add(new ModelBox(main2, 24, 12, -0.25F, -12.0F, 2.0F, 1, 2, 3, 0.0F, false));
        main2.cubeList.add(new ModelBox(main2, 0, 17, 0.25F, -12.0F, 2.0F, 1, 2, 3, 0.0F, false));
        main2.cubeList.add(new ModelBox(main2, 0, 12, -0.75F, -12.0F, 2.0F, 1, 2, 3, 0.0F, false));

        second = new RendererModel(this);
        second.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(second, -0.4887F, 0.0F, 0.0F);
        back.addChild(second);
        second.cubeList.add(new ModelBox(second, 24, 17, -0.25F, -12.0F, 2.75F, 1, 1, 3, 0.0F, false));
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
