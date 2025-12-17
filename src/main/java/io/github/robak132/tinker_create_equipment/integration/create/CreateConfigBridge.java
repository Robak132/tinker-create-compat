package io.github.robak132.tinker_create_equipment.integration.create;

import com.simibubi.create.infrastructure.config.AllConfigs;

public final class CreateConfigBridge {

    private CreateConfigBridge() {}

    public static int baseBacktankAir() {
        return AllConfigs.server().equipment.airInBacktank.get();
    }

    public static int capacityPerEnchantment() {
        return AllConfigs.server().equipment.enchantedBacktankCapacity.get();
    }
}
