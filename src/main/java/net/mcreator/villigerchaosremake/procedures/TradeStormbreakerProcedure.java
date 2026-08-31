package net.mcreator.villigerchaosremake.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.villigerchaosremake.init.VilligerChaosRemakeModItems;

public class TradeStormbreakerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (hasEntityInInventory(entity, new ItemStack(Blocks.EMERALD_BLOCK))) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Blocks.EMERALD_BLOCK);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(VilligerChaosRemakeModItems.VILLAGERSTORMBREAKER.get()).copy();
				_setstack.setCount(1);
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}