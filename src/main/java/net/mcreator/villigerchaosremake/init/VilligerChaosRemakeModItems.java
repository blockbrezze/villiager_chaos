/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.villigerchaosremake.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.villigerchaosremake.item.VillagerstormbreakerItem;
import net.mcreator.villigerchaosremake.item.VillagerheavenItem;
import net.mcreator.villigerchaosremake.item.EmeraldarmorItem;
import net.mcreator.villigerchaosremake.VilligerChaosRemakeMod;

import java.util.function.Function;

public class VilligerChaosRemakeModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(VilligerChaosRemakeMod.MODID);
	public static final DeferredItem<Item> ANGRYVILLAGER_SPAWN_EGG;
	public static final DeferredItem<Item> VILLAGERPORTALFRAME;
	public static final DeferredItem<Item> VILLAGERHEAVEN;
	public static final DeferredItem<Item> VILLAGERSTORMBREAKER;
	public static final DeferredItem<Item> VILLAGERGOD_SPAWN_EGG;
	public static final DeferredItem<Item> PODIUM;
	public static final DeferredItem<Item> EMERALDARMOR_HELMET;
	public static final DeferredItem<Item> EMERALDARMOR_CHESTPLATE;
	public static final DeferredItem<Item> EMERALDARMOR_LEGGINGS;
	public static final DeferredItem<Item> EMERALDARMOR_BOOTS;
	public static final DeferredItem<Item> RIDEABLEVILLAGER_SPAWN_EGG;
	static {
		ANGRYVILLAGER_SPAWN_EGG = register("angryvillager_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(VilligerChaosRemakeModEntities.ANGRYVILLAGER.get())));
		VILLAGERPORTALFRAME = block(VilligerChaosRemakeModBlocks.VILLAGERPORTALFRAME);
		VILLAGERHEAVEN = register("villagerheaven", VillagerheavenItem::new);
		VILLAGERSTORMBREAKER = register("villagerstormbreaker", VillagerstormbreakerItem::new);
		VILLAGERGOD_SPAWN_EGG = register("villagergod_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(VilligerChaosRemakeModEntities.VILLAGERGOD.get())));
		PODIUM = block(VilligerChaosRemakeModBlocks.PODIUM);
		EMERALDARMOR_HELMET = register("emeraldarmor_helmet", EmeraldarmorItem.Helmet::new);
		EMERALDARMOR_CHESTPLATE = register("emeraldarmor_chestplate", EmeraldarmorItem.Chestplate::new);
		EMERALDARMOR_LEGGINGS = register("emeraldarmor_leggings", EmeraldarmorItem.Leggings::new);
		EMERALDARMOR_BOOTS = register("emeraldarmor_boots", EmeraldarmorItem.Boots::new);
		RIDEABLEVILLAGER_SPAWN_EGG = register("rideablevillager_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(VilligerChaosRemakeModEntities.RIDEABLEVILLAGER.get())));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}
}