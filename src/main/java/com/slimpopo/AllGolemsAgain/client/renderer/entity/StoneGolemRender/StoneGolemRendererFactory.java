package com.slimpopo.AllGolemsAgain.client.renderer.entity.StoneGolemRender;

import com.slimpopo.AllGolemsAgain.core.entities.StoneGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

@OnlyIn(Dist.CLIENT)
public class StoneGolemRendererFactory implements IRenderFactory<StoneGolemEntity> {
    public static final StoneGolemRendererFactory INSTANCE = new StoneGolemRendererFactory();

    @Override
    public EntityRenderer<? super StoneGolemEntity> createRenderFor(EntityRendererManager manager){
        if(FMLEnvironment.dist.isDedicatedServer())
        throw new IllegalStateException("Only run this on client!");

        return new StoneGolemRenderer(manager);
    }
}
