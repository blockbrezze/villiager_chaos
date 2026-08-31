/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.villigerchaosremake.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.villigerchaosremake.entity.VillagergodEntity;
import net.mcreator.villigerchaosremake.entity.RideablevillagerEntity;
import net.mcreator.villigerchaosremake.entity.AngryvillagerEntity;
import net.mcreator.villigerchaosremake.VilligerChaosRemakeMod;

@EventBusSubscriber
public class VilligerChaosRemakeModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, VilligerChaosRemakeMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<AngryvillagerEntity>> ANGRYVILLAGER = register("angryvillager",
			EntityType.Builder.<AngryvillagerEntity>of(AngryvillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<VillagergodEntity>> VILLAGERGOD = register("villagergod",
			EntityType.Builder.<VillagergodEntity>of(VillagergodEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<RideablevillagerEntity>> RIDEABLEVILLAGER = register("rideablevillager",
			EntityType.Builder.<RideablevillagerEntity>of(RideablevillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(0.6f, 1.95f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VilligerChaosRemakeMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		AngryvillagerEntity.init(event);
		VillagergodEntity.init(event);
		RideablevillagerEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ANGRYVILLAGER.get(), AngryvillagerEntity.createAttributes().build());
		event.put(VILLAGERGOD.get(), VillagergodEntity.createAttributes().build());
		event.put(RIDEABLEVILLAGER.get(), RideablevillagerEntity.createAttributes().build());
	}
}