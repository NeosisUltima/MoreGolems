package com.slimpopo.AllGolemsAgain.core.entities;

import com.slimpopo.AllGolemsAgain.Constants;
import com.slimpopo.AllGolemsAgain.atlas.GolemTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class WoodGolemEntity extends IronGolemEntity{
    public static EntityType<?> WOOD_GOLEM = EntityType.Builder.create(WoodGolemEntity::new,EntityClassification.CREATURE).build(Constants.MOD_ID + ":wood_golem").setRegistryName(new ResourceLocation(Constants.MOD_ID, "wood_golem"));


    public WoodGolemEntity(EntityType<? extends IronGolemEntity> type, World worldIn) {
        super((EntityType<? extends IronGolemEntity>) GolemTypes.wood_golem, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this,1.20d));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(WoodGolemEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SkeletonEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SpiderEntity.class, true));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0d);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25d);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(Math.random() * 4 + 2);
    }

    /**
     * Determines whether or not a place is valid for spawning.
     *
     * @param wabbit
     * @param world
     * @param spawnReason
     * @param pos
     * @param random
     * @return True if it can spawn on that location.
     */
    public static boolean isValidSpawnPlacement(EntityType<WoodGolemEntity> wabbit, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        LOGGER.debug("Spawning Wabbit...");
        Block block = world.getBlockState(pos.down()).getBlock();
        return (block == Blocks.GRASS_BLOCK || block == Blocks.SNOW || block == Blocks.SAND) && world.getNeighborAwareLightSubtracted(pos, 0) > 5;
    }
}
