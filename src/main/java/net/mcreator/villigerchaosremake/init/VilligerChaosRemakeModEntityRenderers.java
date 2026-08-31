/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.villigerchaosremake.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.villigerchaosremake.client.renderer.VillagergodRenderer;
import net.mcreator.villigerchaosremake.client.renderer.RideablevillagerRenderer;
import net.mcreator.villigerchaosremake.client.renderer.AngryvillagerRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class VilligerChaosRemakeModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(VilligerChaosRemakeModEntities.ANGRYVILLAGER.get(), AngryvillagerRenderer::new);
		event.registerEntityRenderer(VilligerChaosRemakeModEntities.VILLAGERGOD.get(), VillagergodRenderer::new);
		event.registerEntityRenderer(VilligerChaosRemakeModEntities.RIDEABLEVILLAGER.get(), RideablevillagerRenderer::new);
	}
}