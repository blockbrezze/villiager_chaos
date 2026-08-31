package net.mcreator.villigerchaosremake.client.renderer;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.entity.state.ThrownItemRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;

import net.mcreator.villigerchaosremake.entity.CustomFireballEntity;

import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(value = Dist.CLIENT)
public class CustomFireballRenderer extends EntityRenderer<CustomFireballEntity, CustomFireballRenderer.CustomFireballRenderState> {
	@SubscribeEvent
	public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
		if (CustomFireballEntity.TYPE != null) {
			event.registerEntityRenderer(CustomFireballEntity.TYPE, CustomFireballRenderer::new);
		}
	}

	private final ItemModelResolver itemModelResolver;

	public CustomFireballRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.itemModelResolver = context.getItemModelResolver();
	}

	@Override
	protected int getBlockLightLevel(CustomFireballEntity entity, BlockPos blockPos) {
		return 15;
	}

	@Override
	public CustomFireballRenderState createRenderState() {
		return new CustomFireballRenderState();
	}

	@Override
	public void extractRenderState(CustomFireballEntity entity, CustomFireballRenderState state, float partialTick) {
		super.extractRenderState(entity, state, partialTick);
		state.customScale = entity.getCustomSize();
		this.itemModelResolver.updateForNonLiving(state.item, entity.getItem(), ItemDisplayContext.GROUND, entity);
	}

	@Override
	public void submit(CustomFireballRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
		if (!state.item.isEmpty()) {
			poseStack.pushPose();
			poseStack.mulPose(camera.orientation);
			float scale = state.customScale;
			poseStack.scale(scale, scale, scale);
			state.item.submit(poseStack, submitNodeCollector, 15728880, 0, 0);
			poseStack.popPose();
		}
		super.submit(state, poseStack, submitNodeCollector, camera);
	}

	public static class CustomFireballRenderState extends ThrownItemRenderState {
		public float customScale = 1.0F;
	}
}