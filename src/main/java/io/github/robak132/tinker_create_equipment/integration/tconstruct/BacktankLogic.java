package io.github.robak132.tinker_create_equipment.integration.tconstruct;

import io.github.robak132.tinker_create_equipment.integration.create.CreateConfigBridge;
import net.minecraft.world.item.ItemStack;

public final class BacktankLogic {

    private BacktankLogic() {}

    public static int getMaxAir(ItemStack stack) {
        int level = ToolModifierHelper.getBacktankLevel(stack);
        if (level <= 0) return 0;

        int base = CreateConfigBridge.baseBacktankAir();
        int perLevel = CreateConfigBridge.capacityPerEnchantment();

        return base + perLevel * (level - 1);
    }

    public static boolean canStoreAir(ItemStack stack) {
        return ToolModifierHelper.hasBacktank(stack);
    }

}
