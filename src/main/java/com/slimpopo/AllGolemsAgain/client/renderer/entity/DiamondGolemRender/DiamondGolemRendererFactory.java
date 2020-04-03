package com.slimpopo.AllGolemsAgain.client.renderer.entity.DiamondGolemRender;

import com.slimpopo.AllGolemsAgain.core.entities.DiamondGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

@OnlyIn(Dist.CLIENT)
public class DiamondGolemRendererFactory implements IRenderFactory<DiamondGolemEntity> {
    public static final DiamondGolemRendererFactory INSTANCE = new DiamondGolemRendererFactory();

    @Override
    public EntityRenderer<? super DiamondGolemEntity> createRenderFor(EntityRendererManager manager){
        if(FMLEnvironment.dist.isDedicatedServer())
        throw new IllegalStateException("Only run this on client!");

        return new DiamondGolemRenderer(manager);
    }
}
