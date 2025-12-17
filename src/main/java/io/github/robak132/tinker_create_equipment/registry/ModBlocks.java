package io.github.robak132.tinker_create_equipment.registry;

import io.github.robak132.tinker_create_equipment.content.backtank.TinkerBacktankBlock;
import io.github.robak132.tinker_create_equipment.core.TCEMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TCEMod.MOD_ID);

    public static final RegistryObject<Block> TINKER_BACKTANK = BLOCKS.register("tinker_backtank", TinkerBacktankBlock::new);

    private ModBlocks() {
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
