package io.github.robak132.tinker_create_equipment.mixin;

import com.simibubi.create.content.equipment.armor.DivingHelmetItem;
import io.github.robak132.tinker_create_equipment.integration.tconstruct.ToolModifierHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = DivingHelmetItem.class, remap = false)
public class DivingHelmetItemMixin {

    @Inject(method = "getWornItem", at = @At("HEAD"), cancellable = true)
    private static void tce$recognizeTinkersHelmet(Entity entity, CallbackInfoReturnable<ItemStack> cir) {
        if (!(entity instanceof LivingEntity living)) {
            return;
        }

        ItemStack helmet = living.getItemBySlot(EquipmentSlot.HEAD);
        if (helmet.isEmpty()) {
            return;
        }

        if (ToolModifierHelper.hasDivingHelmet(helmet)) {
            cir.setReturnValue(helmet);
        }
    }
}
