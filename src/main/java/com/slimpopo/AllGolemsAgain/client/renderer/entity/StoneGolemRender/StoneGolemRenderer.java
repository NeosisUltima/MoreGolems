package com.slimpopo.AllGolemsAgain.client.renderer.entity.StoneGolemRender;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.model.StoneGolemModel;
import com.slimpopo.AllGolemsAgain.core.entities.StoneGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
//WoodGolemEntity, WoodGolemModel<WoodGolemEntity>
public class StoneGolemRenderer extends MobRenderer<StoneGolemEntity, StoneGolemModel<StoneGolemEntity>>{

    private static final ResourceLocation SKIN = new ResourceLocation("allgolemsagain:textures/entity/stone_golem.png");

    public StoneGolemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new StoneGolemModel<>(), 0.6F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(StoneGolemEntity entity) {
        return SKIN;
    }


}
