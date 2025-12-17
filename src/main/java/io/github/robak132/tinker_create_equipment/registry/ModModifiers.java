package io.github.robak132.tinker_create_equipment.registry;

import io.github.robak132.tinker_create_equipment.content.modifiers.BacktankModifier;
import io.github.robak132.tinker_create_equipment.content.modifiers.DivingBootsModifier;
import io.github.robak132.tinker_create_equipment.content.modifiers.DivingHelmetModifier;
import io.github.robak132.tinker_create_equipment.core.TCEMod;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public final class ModModifiers {

    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TCEMod.MOD_ID);

    public static final StaticModifier<BacktankModifier> BACKTANK_MODIFIER = MODIFIERS.register("backtank", BacktankModifier::new);
    public static final StaticModifier<DivingBootsModifier> DIVING_BOOTS_MODIFIER = MODIFIERS.register("diving_boots", DivingBootsModifier::new);
    public static final StaticModifier<DivingHelmetModifier> DIVING_HELMET_MODIFIER = MODIFIERS.register("diving_helmet", DivingHelmetModifier::new);

    public static void register(IEventBus bus) {
        MODIFIERS.register(bus);
    }
}
