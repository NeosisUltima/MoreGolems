package com.slimpopo.AllGolemsAgain.client.renderer.entity.WoodGolemRender;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.model.WoodGolemModel;
import com.slimpopo.AllGolemsAgain.core.entities.WoodGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
//WoodGolemEntity, WoodGolemModel<WoodGolemEntity>
public class WoodGolemRenderer extends MobRenderer<WoodGolemEntity,WoodGolemModel<WoodGolemEntity>>{

    private static final ResourceLocation SKIN = new ResourceLocation("allgolemsagain:textures/entity/wood_golem.png");

    public WoodGolemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new WoodGolemModel<>(), 0.6F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(WoodGolemEntity entity) {
        return SKIN;
    }


}
