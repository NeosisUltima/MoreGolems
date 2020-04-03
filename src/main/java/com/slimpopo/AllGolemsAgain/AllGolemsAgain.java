package com.slimpopo.AllGolemsAgain;

import com.slimpopo.AllGolemsAgain.atlas.GolemTypes;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.DiamondGolemRender.DiamondGolemRendererFactory;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.EmeraldGolemRender.EmeraldGolemRendererFactory;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.GoldGolemRender.GoldGolemRendererFactory;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.RedstoneGolemRenderer.RedstoneGolemRendererFactory;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.StoneGolemRender.StoneGolemRendererFactory;
import com.slimpopo.AllGolemsAgain.client.renderer.entity.WoodGolemRender.WoodGolemRendererFactory;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("allgolemsagain")
//@Mod.EventBusSubscriber
public class AllGolemsAgain
{
    private static final Logger LOGGER = LogManager.getLogger();

    public AllGolemsAgain() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        //GolemTypes.setGolemSpawnBiomes();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        if (FMLEnvironment.dist.isDedicatedServer())
            return;

        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderingRegistry.registerEntityRenderingHandler(GolemTypes.wood_golem,WoodGolemRendererFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(GolemTypes.stone_golem, StoneGolemRendererFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(GolemTypes.redstone_golem, RedstoneGolemRendererFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(GolemTypes.diamond_golem, DiamondGolemRendererFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(GolemTypes.gold_golem, GoldGolemRendererFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(GolemTypes.emerald_golem, EmeraldGolemRendererFactory.INSTANCE);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

}
