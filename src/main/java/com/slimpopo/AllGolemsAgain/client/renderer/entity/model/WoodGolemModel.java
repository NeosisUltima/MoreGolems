package com.slimpopo.AllGolemsAgain.client.renderer.entity.model;

import com.slimpopo.AllGolemsAgain.core.entities.WoodGolemEntity;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WoodGolemModel<T extends WoodGolemEntity> extends IronGolemModel<WoodGolemEntity> {

}
