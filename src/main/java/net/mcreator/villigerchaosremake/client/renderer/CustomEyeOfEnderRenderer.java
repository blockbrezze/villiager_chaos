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

import net.mcreator.villigerchaosremake.entity.CustomEyeOfEnderEntity;

import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(value = Dist.CLIENT)
public class CustomEyeOfEnderRenderer extends EntityRenderer<CustomEyeOfEnderEntity, CustomEyeOfEnderRenderer.CustomEyeRenderState> {
	@SubscribeEvent
	public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CustomEyeOfEnderEntity.TYPE, CustomEyeOfEnderRenderer::new);
	}

	private final ItemModelResolver itemModelResolver;

	public CustomEyeOfEnderRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.itemModelResolver = context.getItemModelResolver();
	}

	@Override
	protected int getBlockLightLevel(CustomEyeOfEnderEntity entity, BlockPos blockPos) {
		return 15;
	}

	@Override
	public CustomEyeRenderState createRenderState() {
		return new CustomEyeRenderState();
	}

	@Override
	public void extractRenderState(CustomEyeOfEnderEntity entity, CustomEyeRenderState state, float partialTick) {
		super.extractRenderState(entity, state, partialTick);
		this.itemModelResolver.updateForNonLiving(state.item, entity.getItem(), ItemDisplayContext.GROUND, entity);
	}

	@Override
	public void submit(CustomEyeRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
		if (!state.item.isEmpty()) {
			poseStack.pushPose();
			poseStack.mulPose(camera.orientation);
			poseStack.scale(2F, 2F, 2F);
			state.item.submit(poseStack, submitNodeCollector, 15728880, 0, 0);
			poseStack.popPose();
		}
		super.submit(state, poseStack, submitNodeCollector, camera);
	}

	public static class CustomEyeRenderState extends ThrownItemRenderState {
	}
}