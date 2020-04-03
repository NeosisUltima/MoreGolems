package com.slimpopo.AllGolemsAgain.client.renderer.entity.DiamondGolemRender;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.model.DiamondGolemModel;
import com.slimpopo.AllGolemsAgain.core.entities.DiamondGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
//WoodGolemEntity, WoodGolemModel<WoodGolemEntity>
public class DiamondGolemRenderer extends MobRenderer<DiamondGolemEntity, DiamondGolemModel<DiamondGolemEntity>>{

    private static final ResourceLocation SKIN = new ResourceLocation("allgolemsagain:textures/entity/diamond_golem.png");

    public DiamondGolemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new DiamondGolemModel<>(), 0.6F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(DiamondGolemEntity entity) {
        return SKIN;
    }


}
