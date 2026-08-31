package net.mcreator.villigerchaosremake.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.villigerchaosremake.entity.AngryvillagerEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VillagerdamagefloorProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (sourceentity instanceof AngryvillagerEntity) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 2) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(2);
				}
			}
		}
	}
}