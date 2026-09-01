/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.villigerchaosremake.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.villigerchaosremake.VilligerChaosRemakeMod;

@EventBusSubscriber
public class VilligerChaosRemakeModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VilligerChaosRemakeMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VILLAGERCHAOS = REGISTRY.register("villagerchaos",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.villiger_chaos_remake.villagerchaos")).icon(() -> new ItemStack(VilligerChaosRemakeModItems.VILLAGERSTORMBREAKER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(VilligerChaosRemakeModItems.VILLAGERHEAVEN.get());
				tabData.accept(VilligerChaosRemakeModItems.VILLAGERSTORMBREAKER.get());
				tabData.accept(VilligerChaosRemakeModItems.EMERALDARMOR_HELMET.get());
				tabData.accept(VilligerChaosRemakeModItems.EMERALDARMOR_CHESTPLATE.get());
				tabData.accept(VilligerChaosRemakeModItems.EMERALDARMOR_LEGGINGS.get());
				tabData.accept(VilligerChaosRemakeModItems.EMERALDARMOR_BOOTS.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(VilligerChaosRemakeModItems.ANGRYVILLAGER_SPAWN_EGG.get());
			tabData.accept(VilligerChaosRemakeModItems.VILLAGERGOD_SPAWN_EGG.get());
			tabData.accept(VilligerChaosRemakeModItems.RIDEABLEVILLAGER_SPAWN_EGG.get());
		}
	}
}