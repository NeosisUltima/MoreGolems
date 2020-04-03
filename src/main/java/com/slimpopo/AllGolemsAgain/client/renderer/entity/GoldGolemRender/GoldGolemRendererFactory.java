package com.slimpopo.AllGolemsAgain.client.renderer.entity.GoldGolemRender;

import com.slimpopo.AllGolemsAgain.core.entities.GoldGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

@OnlyIn(Dist.CLIENT)
public class GoldGolemRendererFactory implements IRenderFactory<GoldGolemEntity> {
    public static final GoldGolemRendererFactory INSTANCE = new GoldGolemRendererFactory();

    @Override
    public EntityRenderer<? super GoldGolemEntity> createRenderFor(EntityRendererManager manager){
        if(FMLEnvironment.dist.isDedicatedServer())
        throw new IllegalStateException("Only run this on client!");

        return new GoldGolemRenderer(manager);
    }
}
