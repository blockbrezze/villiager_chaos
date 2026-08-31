/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.villigerchaosremake.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.villigerchaosremake.block.VillagerportalframeBlock;
import net.mcreator.villigerchaosremake.block.VillagerheavenPortalBlock;
import net.mcreator.villigerchaosremake.block.PodiumBlock;
import net.mcreator.villigerchaosremake.VilligerChaosRemakeMod;

import java.util.function.Function;

public class VilligerChaosRemakeModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(VilligerChaosRemakeMod.MODID);
	public static final DeferredBlock<Block> VILLAGERPORTALFRAME;
	public static final DeferredBlock<Block> VILLAGERHEAVEN_PORTAL;
	public static final DeferredBlock<Block> PODIUM;
	static {
		VILLAGERPORTALFRAME = register("villagerportalframe", VillagerportalframeBlock::new);
		VILLAGERHEAVEN_PORTAL = register("villagerheaven_portal", VillagerheavenPortalBlock::new);
		PODIUM = register("podium", PodiumBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}