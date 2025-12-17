package io.github.robak132.tinker_create_equipment.integration.create;

import com.simibubi.create.content.equipment.armor.BacktankUtil;
import io.github.robak132.tinker_create_equipment.integration.tconstruct.ToolModifierHelper;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingBreatheEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

/**
 * Handles special Netherite diving behavior:
 * - Fire immunity
 * - Lava breathing using Create backtank air
 * This class does NOT override Create logic.
 * It only adds a conditional extension when a full set is worn.
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class NetheriteDivingEvents {

    private NetheriteDivingEvents() {}

    private static boolean hasFullNetheriteDivingSet(LivingEntity entity) {
        ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest  = entity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack boots  = entity.getItemBySlot(EquipmentSlot.FEET);

        if (helmet.isEmpty() || chest.isEmpty() || boots.isEmpty())
            return false;

        return ToolModifierHelper.hasDivingHelmet(helmet)
                && ToolModifierHelper.hasBacktank(chest)
                && ToolModifierHelper.hasDivingBoots(boots)
                && helmet.getItem().isFireResistant()
                && chest.getItem().isFireResistant()
                && boots.getItem().isFireResistant();
    }

    @SubscribeEvent
    public static void onLivingAttacked(LivingAttackEvent event) {
        LivingEntity entity = event.getEntity();

        if (!event.getSource().is(DamageTypeTags.IS_FIRE))
            return;

        if (hasFullNetheriteDivingSet(entity)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingBreathe(LivingBreatheEvent event) {
        LivingEntity entity = event.getEntity();

        // Only apply in lava
        if (!entity.isInLava())
            return;

        // Only with full netherite diving setup
        if (!hasFullNetheriteDivingSet(entity))
            return;

        // Ask Create for all valid backtanks with air
        List<ItemStack> backtanks = BacktankUtil.getAllWithAir(entity);

        if (backtanks.isEmpty()) {
            return;
        }

        // Consume air using Create's own logic
        ItemStack backtank = backtanks.get(0);

        // This value matches Create's per-tick consumption pattern
        BacktankUtil.consumeAir(entity, backtank, 1);

        // Allow breathing for this tick
        event.setCanBreathe(true);
    }
}
