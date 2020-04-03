package com.slimpopo.AllGolemsAgain.client.renderer.entity.GoldGolemRender;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.model.GoldGolemModel;
import com.slimpopo.AllGolemsAgain.core.entities.GoldGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
//WoodGolemEntity, WoodGolemModel<WoodGolemEntity>
public class GoldGolemRenderer extends MobRenderer<GoldGolemEntity, GoldGolemModel<GoldGolemEntity>>{

    private static final ResourceLocation SKIN = new ResourceLocation("allgolemsagain:textures/entity/gold_golem.png");

    public GoldGolemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new GoldGolemModel<>(), 0.6F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GoldGolemEntity entity) {
        return SKIN;
    }


}
