package net.l1onkng.enderbeam.item;

import net.l1onkng.enderbeam.EnderBeam;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Use NeoForge's Deferred Register for Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnderBeam.MOD_ID);

    // Define the items with DeferredItem registration
    public static final DeferredItem<Item> LASERLENS = ITEMS.register("laserlens",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LASERLED = ITEMS.register("laserled",
            () -> new Item(new Item.Properties()));

    // New items to be added
    public static final DeferredItem<Item> BASIC_SATELITE_PANEL = ITEMS.register("basic_satelite_panel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ADVANCED_SATELITE_PANEL = ITEMS.register("advanced_satelite_panel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        // Register all items to the event bus so they are registered in the game
        ITEMS.register(eventBus);
    }
}
