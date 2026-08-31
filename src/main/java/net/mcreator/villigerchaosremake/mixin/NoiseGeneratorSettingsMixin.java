package net.mcreator.villigerchaosremake.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import net.mcreator.villigerchaosremake.init.VilligerChaosRemakeModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements VilligerChaosRemakeModBiomes.VilligerChaosRemakeModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> villiger_chaos_remake_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.villiger_chaos_remake_dimensionTypeReference != null) {
			retval = VilligerChaosRemakeModBiomes.adaptSurfaceRule(retval, this.villiger_chaos_remake_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setvilliger_chaos_remakeDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.villiger_chaos_remake_dimensionTypeReference = dimensionType;
	}
}