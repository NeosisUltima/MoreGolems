package com.slimpopo.AllGolemsAgain.client.renderer.entity.model;

import com.slimpopo.AllGolemsAgain.core.entities.EmeraldGolemEntity;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EmeraldGolemModel <T extends EmeraldGolemEntity> extends IronGolemModel<EmeraldGolemEntity> {
}
