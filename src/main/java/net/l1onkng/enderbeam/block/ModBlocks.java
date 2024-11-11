package net.l1onkng.enderbeam.block;

import net.l1onkng.enderbeam.EnderBeam;
import net.l1onkng.enderbeam.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EnderBeam.MOD_ID);

    // Define each block
    public static final DeferredBlock<Block> LASERLENS_BLOCK = registerBlock("laserlens_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> LASERLED_BLOCK = registerBlock("laserled_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> BASIC_DATA_PORT = registerBlock("basic_data_port",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BASIC_FUEL_INTAKE = registerBlock("basic_fuel_intake",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BASIC_PARABOLIC_LASER = registerBlock("basic_parabolic_laser",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BASIC_POWER_INTAKE = registerBlock("basic_power_intake",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BASIC_ROCKET_STABILIZER = registerBlock("basic_rocket_stabilizer",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> LASER_PARABOLE = registerBlock("laser_parabole",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
