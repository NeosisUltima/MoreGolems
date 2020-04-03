package com.slimpopo.AllGolemsAgain.core;

import com.slimpopo.AllGolemsAgain.Constants;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class EventHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event){
        if (event.getName().equals(new ResourceLocation("minecraft","oak_wood.json")))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Constants.MOD_ID,"oak_wood.json"))).build());
            LOGGER.info("Wood Golem Has Been Added!!!");
        }
        if (event.getName().equals(new ResourceLocation("minecraft","dark_oak_wood.json")))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Constants.MOD_ID,"dark_oak_wood.json"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","spruce_wood.json")))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Constants.MOD_ID,"spruce_wood.json"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","birch_wood.json")))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Constants.MOD_ID,"birch_wood.json"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","acacia_wood.json")))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Constants.MOD_ID,"acacia_wood.json"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","jungle_wood.json")))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Constants.MOD_ID,"jungle_wood.json"))).build());
        }

    }
}
