package com.slimpopo.AllGolemsAgain.client.renderer.entity.RedstoneGolemRenderer;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.model.RedstoneGolemModel;
import com.slimpopo.AllGolemsAgain.core.entities.RedstoneGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
//WoodGolemEntity, WoodGolemModel<WoodGolemEntity>
public class RedstoneGolemRenderer extends MobRenderer<RedstoneGolemEntity, RedstoneGolemModel<RedstoneGolemEntity>>{

    private static final ResourceLocation SKIN = new ResourceLocation("allgolemsagain:textures/entity/redstone_golem.png");

    public RedstoneGolemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new RedstoneGolemModel<>(), 0.6F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(RedstoneGolemEntity entity) {
        return SKIN;
    }


}
