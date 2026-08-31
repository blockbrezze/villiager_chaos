package net.mcreator.villigerchaosremake.world;

import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.BlockPos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import com.mojang.serialization.Codec;

public class PortalSavedData extends SavedData {
	private static final String DATA_NAME = "teleport_block_portals";
	private final ConcurrentHashMap<TeleportBlockHandler.PortalKey, TeleportBlockHandler.TeleportData> portals = new ConcurrentHashMap<>();
	public static final Codec<PortalSavedData> CODEC = CompoundTag.CODEC.xmap(tag -> PortalSavedData.load(tag, null), data -> data.save(new CompoundTag(), null));
	public static final SavedDataType<PortalSavedData> TYPE = new SavedDataType<PortalSavedData>(Identifier.parse(DATA_NAME), PortalSavedData::new, CODEC, null);

	public static PortalSavedData get(ServerLevel level) {
		ServerLevel overworld = level.getServer().getLevel(Level.OVERWORLD);
		if (overworld == null)
			overworld = level;
		return overworld.getDataStorage().computeIfAbsent(TYPE);
	}

	public PortalSavedData() {
	}

	public ConcurrentHashMap<TeleportBlockHandler.PortalKey, TeleportBlockHandler.TeleportData> getPortals() {
		return portals;
	}

	public static PortalSavedData load(CompoundTag tag, HolderLookup.Provider provider) {
		PortalSavedData data = new PortalSavedData();
		ListTag list = tag.getList("Portals").orElseGet(ListTag::new);
		for (int i = 0; i < list.size(); i++) {
			CompoundTag pTag = list.getCompound(i).orElseGet(CompoundTag::new);
			String dimStr = pTag.getString("Dimension").orElse("minecraft:overworld");
			long posLong = pTag.getLong("Pos").orElse(0L);
			String targetDimStr = pTag.getString("TargetDimension").orElse("minecraft:overworld");
			ResourceKey<Level> dim = ResourceKey.create(Registries.DIMENSION, Identifier.parse(dimStr.isEmpty() ? "minecraft:overworld" : dimStr));
			BlockPos pos = BlockPos.of(posLong);
			ResourceKey<Level> targetDim = ResourceKey.create(Registries.DIMENSION, Identifier.parse(targetDimStr.isEmpty() ? "minecraft:overworld" : targetDimStr));
			double tx = pTag.getDouble("TargetX").orElse(0.0);
			double ty = pTag.getDouble("TargetY").orElse(0.0);
			double tz = pTag.getDouble("TargetZ").orElse(0.0);
			int ticks = pTag.getInt("RequiredTicks").orElse(0);
			int offsetY = pTag.getInt("TriggerOffsetY").orElse(0);
			String soundStr = pTag.getString("Sound").orElse("");
			SoundEvent sound = soundStr.isEmpty() ? null : BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse(soundStr));
			String particleStr = pTag.getString("Particle").orElse("");
			ParticleOptions particle = null;
			if (!particleStr.isEmpty()) {
				ParticleType<?> type = BuiltInRegistries.PARTICLE_TYPE.getValue(Identifier.parse(particleStr));
				if (type instanceof ParticleOptions opt) {
					particle = opt;
				}
			}
			TeleportBlockHandler.PortalKey key = new TeleportBlockHandler.PortalKey(dim, pos);
			TeleportBlockHandler.TeleportData tData = new TeleportBlockHandler.TeleportData(key, targetDim, tx, ty, tz, sound, particle, ticks, offsetY);
			data.portals.put(key, tData);
		}
		return data;
	}

	public CompoundTag save(CompoundTag tag, HolderLookup.Provider provider) {
		ListTag list = new ListTag();
		for (Map.Entry<TeleportBlockHandler.PortalKey, TeleportBlockHandler.TeleportData> entry : portals.entrySet()) {
			CompoundTag pTag = new CompoundTag();
			pTag.putString("Dimension", entry.getKey().dimension().identifier().toString());
			pTag.putLong("Pos", entry.getKey().pos().asLong());
			pTag.putString("TargetDimension", entry.getValue().targetDimension().identifier().toString());
			pTag.putDouble("TargetX", entry.getValue().targetX());
			pTag.putDouble("TargetY", entry.getValue().targetY());
			pTag.putDouble("TargetZ", entry.getValue().targetZ());
			pTag.putInt("RequiredTicks", entry.getValue().requiredTicks());
			pTag.putInt("TriggerOffsetY", entry.getValue().triggerOffsetY());
			if (entry.getValue().sound() != null) {
				Identifier soundId = BuiltInRegistries.SOUND_EVENT.getKey(entry.getValue().sound());
				if (soundId != null) {
					pTag.putString("Sound", soundId.toString());
				}
			}
			if (entry.getValue().particle() != null) {
				Identifier particleId = BuiltInRegistries.PARTICLE_TYPE.getKey(entry.getValue().particle().getType());
				if (particleId != null) {
					pTag.putString("Particle", particleId.toString());
				}
			}
			list.add(pTag);
		}
		tag.put("Portals", list);
		return tag;
	}
}