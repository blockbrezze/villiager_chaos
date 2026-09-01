package net.mcreator.villigerchaosremake.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class VillagerstormbreakerItem extends Item {
	public VillagerstormbreakerItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC));
	}
}