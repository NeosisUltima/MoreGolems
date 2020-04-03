package com.slimpopo.AllGolemsAgain.client.renderer.entity.EmeraldGolemRender;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.model.EmeraldGolemModel;
import com.slimpopo.AllGolemsAgain.core.entities.EmeraldGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
//WoodGolemEntity, WoodGolemModel<WoodGolemEntity>
public class EmeraldGolemRenderer extends MobRenderer<EmeraldGolemEntity, EmeraldGolemModel<EmeraldGolemEntity>>{

    private static final ResourceLocation SKIN = new ResourceLocation("allgolemsagain:textures/entity/emerald_golem.png");

    public EmeraldGolemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new EmeraldGolemModel<>(), 0.6F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(EmeraldGolemEntity entity) {
        return SKIN;
    }


}
