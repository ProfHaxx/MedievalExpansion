package com.medievalexp.client.renders;

import com.medievalexp.MedievalExpansion;
import com.medievalexp.client.models.EntityGoatModel;
import com.medievalexp.entities.EntityGoat;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class EntityGoatRender extends LivingRenderer<EntityGoat, EntityGoatModel> {

    private EntityGoatRender(EntityRendererManager manager) {
        super(manager, new EntityGoatModel(), 0f);
    }

    @SuppressWarnings("all")
    @Override
    protected ResourceLocation getEntityTexture(EntityGoat entity) {
        return MedievalExpansion.RegistryEvents.location("textures/entity/goat_entity.png");
    }

    public static class RenderFactory implements IRenderFactory {

        @Override
        public EntityRenderer createRenderFor(EntityRendererManager manager) {
            return new EntityGoatRender(manager);
        }
    }
}
