/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.villigerchaosremake.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.villigerchaosremake.client.gui.StormbreakertradeScreen;

@EventBusSubscriber(Dist.CLIENT)
public class VilligerChaosRemakeModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(VilligerChaosRemakeModMenus.STORMBREAKERTRADE.get(), StormbreakertradeScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}