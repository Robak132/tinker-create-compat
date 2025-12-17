package io.github.robak132.tinker_create_equipment.content.modifiers;

import net.minecraft.world.entity.EquipmentSlot;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.BlockInteractionModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class BacktankModifier extends Modifier implements BlockInteractionModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder builder) {
        builder.addHook(this, ModifierHooks.BLOCK_INTERACT);
    }

    public boolean canApply(ToolStack tool, EquipmentSlot slot) {
        return slot == EquipmentSlot.CHEST && tool.getModifierLevel(this.getId()) < 6;
    }
}