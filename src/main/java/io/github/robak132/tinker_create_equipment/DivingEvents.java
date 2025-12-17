package io.github.robak132.tinker_create_equipment;

import io.github.robak132.tinker_create_equipment.content.backtank.BacktankPlacementHandler;
import io.github.robak132.tinker_create_equipment.core.TCEMod;
import io.github.robak132.tinker_create_equipment.integration.tconstruct.ToolModifierHelper;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = TCEMod.MOD_ID)
public class DivingEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock evt) {
        Player p = evt.getEntity();
        ItemStack hand = p.getMainHandItem();
        if (hand.isEmpty() || !ToolModifierHelper.hasBacktank(hand)) return;

        BacktankPlacementHandler.tryPlaceBacktank(p, hand);

        evt.setCanceled(true);
        evt.setCancellationResult(InteractionResult.SUCCESS);
    }
}