package io.github.robak132.tinker_create_equipment.integration.tconstruct;

import io.github.robak132.tinker_create_equipment.registry.ModModifiers;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Optional;

public final class ToolModifierHelper {

    private ToolModifierHelper() {}

    public static Optional<ToolStack> getTool(ItemStack stack) {
        if (stack.isEmpty()) return Optional.empty();
        if (!ToolStack.isInitialized(stack)) return Optional.empty();
        return Optional.of(ToolStack.from(stack));
    }


    public static int getBacktankLevel(ItemStack stack) {
        return getTool(stack)
                .map(tool -> tool.getModifierLevel(ModModifiers.BACKTANK_MODIFIER.get()))
                .orElse(0);
    }

    public static boolean hasBacktank(ItemStack stack) {
        return getBacktankLevel(stack) > 0;
    }

    public static boolean hasDivingHelmet(ItemStack stack) {
        return getTool(stack)
                .map(tool -> tool.getModifierLevel(ModModifiers.DIVING_HELMET_MODIFIER.get()) > 0)
                .orElse(false);
    }

    public static boolean hasDivingBoots(ItemStack stack) {
        return getTool(stack)
                .map(tool -> tool.getModifierLevel(ModModifiers.DIVING_BOOTS_MODIFIER.get()) > 0)
                .orElse(false);
    }
}
