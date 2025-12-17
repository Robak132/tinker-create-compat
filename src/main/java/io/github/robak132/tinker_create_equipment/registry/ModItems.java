package io.github.robak132.tinker_create_equipment.registry;

import io.github.robak132.tinker_create_equipment.core.TCEMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TCEMod.MOD_ID);

    public static final RegistryObject<Item> TINKER_BACKTANK = ITEMS.register("tinker_backtank",
            () -> new BlockItem(ModBlocks.TINKER_BACKTANK.get(), new Item.Properties()));

    private ModItems() {
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
