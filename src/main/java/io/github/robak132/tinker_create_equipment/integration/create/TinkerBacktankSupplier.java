package io.github.robak132.tinker_create_equipment.integration.create;

import com.simibubi.create.content.equipment.armor.BacktankUtil;
import io.github.robak132.tinker_create_equipment.integration.tconstruct.ToolModifierHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public final class TinkerBacktankSupplier {

    private TinkerBacktankSupplier() {}

    public static void register() {
        BacktankUtil.addBacktankSupplier(TinkerBacktankSupplier::findBacktanks);
    }

    private static List<ItemStack> findBacktanks(LivingEntity entity) {
        List<ItemStack> result = new ArrayList<>();

        for (ItemStack stack : entity.getArmorSlots()) {
            if (ToolModifierHelper.hasBacktank(stack)) {
                result.add(stack);
            }
        }

        return result;
    }
}
