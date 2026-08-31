package net.mcreator.villigerchaosremake.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.villigerchaosremake.init.VilligerChaosRemakeModItems;

public class FlightProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = (hasEntityInInventory(entity, new ItemStack(VilligerChaosRemakeModItems.VILLAGERSTORMBREAKER.get())));
			_player.getAbilities().mayfly = (entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE);
			_player.onUpdateAbilities();
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}