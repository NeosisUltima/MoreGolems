package com.slimpopo.AllGolemsAgain.client.renderer.entity.RedstoneGolemRenderer;

import com.slimpopo.AllGolemsAgain.core.entities.RedstoneGolemEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

@OnlyIn(Dist.CLIENT)
public class RedstoneGolemRendererFactory implements IRenderFactory<RedstoneGolemEntity> {
    public static final RedstoneGolemRendererFactory INSTANCE = new RedstoneGolemRendererFactory();

    @Override
    public EntityRenderer<? super RedstoneGolemEntity> createRenderFor(EntityRendererManager manager){
        if(FMLEnvironment.dist.isDedicatedServer())
        throw new IllegalStateException("Only run this on client!");

        return new RedstoneGolemRenderer(manager);
    }
}
