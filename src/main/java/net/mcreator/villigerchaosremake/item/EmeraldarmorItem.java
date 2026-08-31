package net.mcreator.villigerchaosremake.item;

import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import java.util.Map;

public abstract class EmeraldarmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(39, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6), 17,
			DeferredHolder.create(Registries.SOUND_EVENT, Identifier.parse("item.armor.equip_diamond")), 4f, 0.2f, TagKey.create(Registries.ITEM, Identifier.parse("villiger_chaos_remake:emeraldarmor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("villiger_chaos_remake:emeraldarmor")));

	private EmeraldarmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends EmeraldarmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.rarity(Rarity.RARE).humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}
	}

	public static class Chestplate extends EmeraldarmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.rarity(Rarity.RARE).humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}
	}

	public static class Leggings extends EmeraldarmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.rarity(Rarity.RARE).humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}
	}

	public static class Boots extends EmeraldarmorItem {
		public Boots(Item.Properties properties) {
			super(properties.rarity(Rarity.RARE).humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}
	}
}