package io.github.robak132.tinker_create_equipment.registry;

import io.github.robak132.tinker_create_equipment.content.backtank.TinkerBacktankBlockEntity;
import io.github.robak132.tinker_create_equipment.core.TCEMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TCEMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<TinkerBacktankBlockEntity>> TINKER_BACKTANK = BLOCK_ENTITIES.register("tinker_backtank",
            () -> BlockEntityType.Builder.of(TinkerBacktankBlockEntity::new, ModBlocks.TINKER_BACKTANK.get()).build(null));

    private ModBlockEntities() {
    }

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
