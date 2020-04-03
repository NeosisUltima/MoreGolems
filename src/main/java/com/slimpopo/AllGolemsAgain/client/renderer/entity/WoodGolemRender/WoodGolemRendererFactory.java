package com.slimpopo.AllGolemsAgain.client.renderer.entity.WoodGolemRender;

import com.slimpopo.AllGolemsAgain.core.entities.WoodGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

@OnlyIn(Dist.CLIENT)
public class WoodGolemRendererFactory implements IRenderFactory<WoodGolemEntity> {
    public static final WoodGolemRendererFactory INSTANCE = new WoodGolemRendererFactory();

    @Override
    public EntityRenderer<? super WoodGolemEntity> createRenderFor(EntityRendererManager manager){
        if(FMLEnvironment.dist.isDedicatedServer())
        throw new IllegalStateException("Only run this on client!");

        return new WoodGolemRenderer(manager);
    }
}
