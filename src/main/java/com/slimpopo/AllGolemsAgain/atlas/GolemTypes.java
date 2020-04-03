package com.slimpopo.AllGolemsAgain.atlas;

import com.slimpopo.AllGolemsAgain.Constants;
import com.slimpopo.AllGolemsAgain.core.entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

@ObjectHolder(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GolemTypes {
    //Logging
    private static final Logger LOGGER = LogManager.getLogger();

    //Entities
    @ObjectHolder("wood_golem")
    public static EntityType<WoodGolemEntity> wood_golem;

    @ObjectHolder("stone_golem")
    public static EntityType<StoneGolemEntity> stone_golem;

    @ObjectHolder("diamond_golem")
    public static EntityType<DiamondGolemEntity> diamond_golem;

    @ObjectHolder("emerald_golem")
    public static EntityType<EmeraldGolemEntity> emerald_golem;

    @ObjectHolder("gold_golem")
    public static EntityType<GoldGolemEntity> gold_golem;

    @ObjectHolder("redstone_golem")
    public static EntityType<RedstoneGolemEntity> redstone_golem;

    //SpawnEggs
    @ObjectHolder("wood_golem_egg")
    public static Item wood_golem_egg;

    @ObjectHolder("stone_golem_egg")
    public static Item stone_golem_egg;

    @ObjectHolder("diamond_golem_egg")
    public static Item diamond_golem_egg;

    @ObjectHolder("emerald_golem_egg")
    public static Item emerald_golem_egg;

    @ObjectHolder("gold_golem_egg")
    public static Item gold_golem_egg;

    @ObjectHolder("redstone_golem_egg")
    public static Item redstone_golem_egg;

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        LOGGER.debug("Golems: Registering Entities...");
        event.getRegistry().registerAll(
                wood_golem, stone_golem,diamond_golem,emerald_golem,gold_golem,redstone_golem
        );
    } //registerEntities()

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        generateEntityTypes();
        LOGGER.debug("Golem: Registering Spawn Eggs...");
        event.getRegistry().registerAll(
                wood_golem_egg = new SpawnEggItem(wood_golem, 0x4c3d26,0x987849, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Constants.MOD_ID,"wood_golem_egg"),
                stone_golem_egg = new SpawnEggItem(stone_golem, 0xa39f92,0x5e5b52, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Constants.MOD_ID,"stone_golem_egg"),
                diamond_golem_egg = new SpawnEggItem(diamond_golem, 0x84ebd1,0x43bbba, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Constants.MOD_ID,"diamond_golem_egg"),
                gold_golem_egg = new SpawnEggItem(gold_golem, 0xeccb4e,0xd0a129, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Constants.MOD_ID,"gold_golem_egg"),
                emerald_golem_egg = new SpawnEggItem(emerald_golem, 0x69ea8a,0x299637, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Constants.MOD_ID,"emerald_golem_egg"),
                redstone_golem_egg = new SpawnEggItem(redstone_golem, 0xd94125,0x84230f, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Constants.MOD_ID,"redstone_golem_egg")

        );

        //wood_golem_egg.getTranslationKey();
    } //registerSpawnEggs()

    public static Item registerSpawnEggs(EntityType<?> type, int color1, int color2,String name){
        SpawnEggItem golemEgg = new SpawnEggItem(type,color1,color2,new Item.Properties().group(ItemGroup.MATERIALS));
        golemEgg.setRegistryName(name);
        return golemEgg;
    }

    private static void generateEntityTypes() {
        LOGGER.debug("Golem: Creating EntityTypes...");
        wood_golem = EntityType.Builder
                .create(WoodGolemEntity::new, EntityClassification.CREATURE)
                .size(0.8F, 1F)
                .build("wood_golem");
        wood_golem.setRegistryName(Constants.MOD_ID, "wood_golem");

        stone_golem = EntityType.Builder
                .create(StoneGolemEntity::new, EntityClassification.CREATURE)
                .size(0.8F, 1F)
                .build("stone_golem");
        stone_golem.setRegistryName(Constants.MOD_ID, "stone_golem");

        diamond_golem = EntityType.Builder
                .create(DiamondGolemEntity::new, EntityClassification.CREATURE)
                .size(0.8F, 1F)
                .build("diamond_golem");
        diamond_golem.setRegistryName(Constants.MOD_ID, "diamond_golem");

        gold_golem = EntityType.Builder
                .create(GoldGolemEntity::new, EntityClassification.CREATURE)
                .size(0.8F, 1F)
                .build("gold_golem");
        gold_golem.setRegistryName(Constants.MOD_ID, "gold_golem");

        emerald_golem = EntityType.Builder
                .create(EmeraldGolemEntity::new, EntityClassification.CREATURE)
                .size(0.8F, 1F)
                .build("emerald_golem");
        emerald_golem.setRegistryName(Constants.MOD_ID, "emerald_golem");

        redstone_golem = EntityType.Builder
                .create(RedstoneGolemEntity::new, EntityClassification.CREATURE)
                .size(0.8F, 1F)
                .build("redstone_golem");
        redstone_golem.setRegistryName(Constants.MOD_ID, "redstone_golem");
    }

    public static void registerEntityWorldSpawn(EntityType<?> entity, Biome...biomes){
        for(Biome biome: biomes){
            if(biome != null){
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(WoodGolemEntity.WOOD_GOLEM,10,1,10));
            }
        }
    }

    public static void registerEntityWorldSpawn(){

    }

    public static void setGolemSpawnBiomes() {
        EntitySpawnPlacementRegistry.register(wood_golem,
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, spawnReason, pos, random) -> {
                    if (entityType != wood_golem)
                        throw new IllegalArgumentException(wood_golem.getRegistryName() + " only!");

                    return WoodGolemEntity.isValidSpawnPlacement((EntityType<WoodGolemEntity>) entityType, world, spawnReason, pos, random);
                }
        );



        //In reality, it would be better to take each biome ands set a custom weight
        //instead of using the generalEntry... But I'm lazy, so all biomes get
        //the same probability. ^_^
        Biome[] biomes = {Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.DESERT_LAKES,
                Biomes.BADLANDS, Biomes.BADLANDS_PLATEAU, Biomes.WOODED_BADLANDS_PLATEAU,
                Biomes.ERODED_BADLANDS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS,
                Biomes.DARK_FOREST, Biomes.DARK_FOREST_HILLS, Biomes.PLAINS,
        };
        for(Biome biome: biomes){
            if(biome != null){
                biome.getSpawns(wood_golem.getClassification()).add(new Biome.SpawnListEntry(WoodGolemEntity.WOOD_GOLEM,10,1,10));
            }
        }
    }
}
