package io.github.robak132.tinker_create_equipment.core;

import com.mojang.logging.LogUtils;
import io.github.robak132.tinker_create_equipment.integration.create.TinkerBacktankSupplier;
import io.github.robak132.tinker_create_equipment.registry.ModBlockEntities;
import io.github.robak132.tinker_create_equipment.registry.ModBlocks;
import io.github.robak132.tinker_create_equipment.registry.ModItems;
import io.github.robak132.tinker_create_equipment.registry.ModModifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TCEMod.MOD_ID)
public final class TCEMod {

    public static final String MOD_ID = "tinker_create_equipment";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TCEMod() {
        if (!ModList.get().isLoaded("create") || !ModList.get().isLoaded("tconstruct")) {
            LOGGER.warn("Create or Tinkers' Construct not detected. TCE disabled.");
            return;
        }

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(bus);
        ModItems.register(bus);
        ModBlockEntities.register(bus);
        ModModifiers.register(bus);
        TinkerBacktankSupplier.register();

        LOGGER.info("Create integration enabled (Backtank, Diving Helmet, Diving Boots)");
    }

}
