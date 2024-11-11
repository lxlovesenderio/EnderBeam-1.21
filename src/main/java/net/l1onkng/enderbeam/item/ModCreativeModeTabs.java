package net.l1onkng.enderbeam.item;

import net.l1onkng.enderbeam.EnderBeam;
import net.l1onkng.enderbeam.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnderBeam.MOD_ID);

    // Custom Creative Tab for Items
    public static final Supplier<CreativeModeTab> ENDERBEAM_ITEMS_TAB = CREATIVE_MODE_TABS.register("enderbeam_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BASIC_SATELITE_PANEL.get()))
                    .title(Component.translatable("creativetab.enderbeam.enderbeam_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BASIC_SATELITE_PANEL.get());
                        output.accept(ModItems.ADVANCED_SATELITE_PANEL.get());
                        output.accept(ModItems.LASERLENS.get());
                        output.accept(ModItems.LASERLED.get());
                    }).build());

    // Custom Creative Tab for Blocks
    public static final Supplier<CreativeModeTab> ENDERBEAM_BLOCKS_TAB = CREATIVE_MODE_TABS.register("enderbeam_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.LASERLENS_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.tryParse(EnderBeam.MOD_ID + ":enderbeam_items_tab")) // Using tryParse() here
                    .title(Component.translatable("creativetab.enderbeam.enderbeam_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LASERLENS_BLOCK.get());
                        output.accept(ModBlocks.LASERLED_BLOCK.get());
                        output.accept(ModBlocks.BASIC_DATA_PORT.get());
                        output.accept(ModBlocks.BASIC_FUEL_INTAKE.get());
                        output.accept(ModBlocks.BASIC_POWER_INTAKE.get());
                        output.accept(ModBlocks.BASIC_ROCKET_STABILIZER.get());
                        output.accept(ModBlocks.BASIC_PARABOLIC_LASER.get());
                        output.accept(ModBlocks.LASER_PARABOLE.get());
                    }).build());

    // Register method for EventBus
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
