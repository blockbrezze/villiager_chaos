package net.mcreator.villigerchaosremake.client.renderer;

import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(value = Dist.CLIENT)
public class SemiAquaticRenderer {
	@SubscribeEvent
	public static void onRenderLiving(RenderLivingEvent.Pre<?, ?, ?> event) {
		LivingEntityRenderState state = event.getRenderState();
		if (state != null && state.isInWater && state.xRot < -5.0F) {
			PoseStack poseStack = event.getPoseStack();
			poseStack.pushPose();
			float centerY = state.boundingBoxHeight / 2.0F;
			float targetRotationX = -10.0F - state.xRot;
			poseStack.rotateAround(Axis.XP.rotationDegrees(targetRotationX), 0.0F, centerY, 0.0F);
		}
	}

	@SubscribeEvent
	public static void onRenderLivingPost(RenderLivingEvent.Post<?, ?, ?> event) {
		LivingEntityRenderState state = event.getRenderState();
		if (state != null && state.isInWater && state.xRot < -5.0F) {
			event.getPoseStack().popPose();
		}
	}
}