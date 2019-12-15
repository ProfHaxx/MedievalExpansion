package com.medievalexp.client.renders;

import com.medievalexp.entities.EntityGoat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
    @SuppressWarnings("unchecked")
    public static void registryEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, new EntityGoatRender.RenderFactory());
    }
}
