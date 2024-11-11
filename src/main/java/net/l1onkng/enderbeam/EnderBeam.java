package net.l1onkng.enderbeam;

import com.mojang.logging.LogUtils;
import net.l1onkng.enderbeam.block.ModBlocks;
import net.l1onkng.enderbeam.item.ModCreativeModeTabs;
import net.l1onkng.enderbeam.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(EnderBeam.MOD_ID)
public class EnderBeam {
    public static final String MOD_ID = "enderbeam";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor is the entry point for mod loading in NeoForge
    public EnderBeam(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register this class to listen for server and other game events
        NeoForge.EVENT_BUS.register(this);

        // Register custom creative tabs, items, and blocks
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register method for adding items to the creative tabs
        modEventBus.addListener(this::addCreative);

        // Register configuration file
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup logic
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.LASERLENS);
            event.accept(ModItems.LASERLED);
            event.accept(ModItems.BASIC_SATELITE_PANEL);
            event.accept(ModItems.ADVANCED_SATELITE_PANEL);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.LASERLENS_BLOCK);
            event.accept(ModBlocks.LASERLED_BLOCK);
            event.accept(ModBlocks.BASIC_DATA_PORT);
            event.accept(ModBlocks.BASIC_FUEL_INTAKE);
            event.accept(ModBlocks.BASIC_POWER_INTAKE);
            event.accept(ModBlocks.BASIC_ROCKET_STABILIZER);
            event.accept(ModBlocks.BASIC_PARABOLIC_LASER);
            event.accept(ModBlocks.LASER_PARABOLE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Code to execute when the server is starting
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Client-side setup logic
        }
    }
}
