package com.slimpopo.AllGolemsAgain.client.renderer.entity.model;

import com.slimpopo.AllGolemsAgain.core.entities.StoneGolemEntity;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StoneGolemModel <T extends StoneGolemEntity> extends IronGolemModel<StoneGolemEntity> {
}
