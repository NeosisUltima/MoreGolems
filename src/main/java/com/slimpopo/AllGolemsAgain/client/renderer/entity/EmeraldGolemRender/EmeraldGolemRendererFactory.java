package com.slimpopo.AllGolemsAgain.client.renderer.entity.EmeraldGolemRender;

import com.slimpopo.AllGolemsAgain.core.entities.EmeraldGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

@OnlyIn(Dist.CLIENT)
public class EmeraldGolemRendererFactory implements IRenderFactory<EmeraldGolemEntity> {
    public static final EmeraldGolemRendererFactory INSTANCE = new EmeraldGolemRendererFactory();

    @Override
    public EntityRenderer<? super EmeraldGolemEntity> createRenderFor(EntityRendererManager manager){
        if(FMLEnvironment.dist.isDedicatedServer())
        throw new IllegalStateException("Only run this on client!");

        return new EmeraldGolemRenderer(manager);
    }
}
