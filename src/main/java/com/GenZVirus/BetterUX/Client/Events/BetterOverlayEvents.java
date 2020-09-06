package com.GenZVirus.BetterUX.Client.Events;

import com.GenZVirus.BetterUX.BetterUX;
import com.GenZVirus.BetterUX.Client.GUI.BetterOverlay;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent.OverlayType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = BetterUX.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class BetterOverlayEvents {

	private static boolean insideWorld = false;
	
	@SubscribeEvent(receiveCanceled = true)
	public static void Overlay(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH
			|| event.getType() == RenderGameOverlayEvent.ElementType.FOOD
			|| event.getType() == RenderGameOverlayEvent.ElementType.ARMOR
			|| event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE
			|| event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT
			|| event.getType() == RenderGameOverlayEvent.ElementType.JUMPBAR) {
			event.setCanceled(true);
			BetterOverlay.renderOverlay();
		}
	}
	
	@SubscribeEvent(receiveCanceled = true)
	public static void FireOverlay(RenderBlockOverlayEvent event) {
		if(event.getOverlayType() == OverlayType.FIRE) {
			event.setCanceled(true);
		}
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void left(ClientTickEvent event) {
		if(Minecraft.getInstance().world == null) { 
			insideWorld = false;
			return;
		}
		if(insideWorld) return;
		insideWorld = true;
		String message = "\n\u00A7c >>> \u00A7r\u00A7l\u00A7eThank you for using Better UX, click here to receive an invite to the \u00A7r\u00A7n\u00A7bOfficial Discord Server\u00A7r\u00A7c <<< \n";
		TranslationTextComponent link = new TranslationTextComponent(message);
		link.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.com/invite/ty6gQaD"));
		Minecraft.getInstance().ingameGUI.getChatGUI().printChatMessage(link);
	}
	
}
