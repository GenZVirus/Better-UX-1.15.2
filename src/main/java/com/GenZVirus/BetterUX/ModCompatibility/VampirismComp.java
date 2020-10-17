package com.GenZVirus.BetterUX.ModCompatibility;

import com.GenZVirus.BetterUX.Client.File.XMLFileJava;
import com.GenZVirus.BetterUX.Client.GUI.BetterUXResources;
import com.mojang.blaze3d.systems.RenderSystem;

import de.teamlapen.vampirism.api.VReference;
import de.teamlapen.vampirism.api.VampirismAPI;
import de.teamlapen.vampirism.api.entity.player.vampire.IBloodStats;
import de.teamlapen.vampirism.api.entity.player.vampire.IVampirePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.FoodStats;

public class VampirismComp {

	public static void bloodOverlay() {
		Minecraft mc = Minecraft.getInstance();
		int posX = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("FoodBarPosX"));
		int posY = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("FoodBarPosY"));
		if (!VampirismAPI.getFactionPlayerHandler((mc.player)).map(h -> VReference.VAMPIRE_FACTION.equals(h.getCurrentFaction())).orElse(false)) {
			FoodStats stats = mc.player.getFoodStats();
			int level = stats.getFoodLevel();
			int maxLevel = 20;
			int percentage = (int) (88 * level / maxLevel);
			if (percentage > 88)
				percentage = 88;
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.FOOD_BAR_FILL));
			AbstractGui.blit(posX - 1, posY + 1, 0, 0, 0, -percentage, 8, 8, 88);
			level = (int) stats.getSaturationLevel();
			maxLevel = 20;
			percentage = (int) (88 * level / maxLevel);
			if (percentage > 88)
				percentage = 88;
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.SATURATION_BAR_FILL));
			AbstractGui.blit(posX - 1, posY + 1, 0, 0, 0, -percentage, 8, 8, 88);
			String food = ((int) stats.getFoodLevel()) + " | " + ((int) stats.getSaturationLevel());
			int stringWidth = mc.fontRenderer.getStringWidth(food);
			mc.fontRenderer.drawString(food, posX - 45 - stringWidth / 2, posY + 1, 0xFFFFFFFF);
			RenderSystem.disableBlend();
			mc.getProfiler().endSection();
		} else {
			IBloodStats stats = (IBloodStats) ((IVampirePlayer) VampirismAPI.getFactionPlayerHandler((mc.player)).map(h -> h.getCurrentFactionPlayer().get()).orElse(null)).getBloodStats();
			int level = stats.getBloodLevel();
			int maxLevel = stats.getMaxBlood();
			int percentage = (int) (88 * level / maxLevel);
			if (percentage > 88)
				percentage = 88;
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.BLOOD_BAR_FILL));
			AbstractGui.blit(posX - 1, posY + 1, 0, 0, 0, -percentage, 8, 8, 88);
			String food = level + " / " + maxLevel + " | " + "\u00A7dLv " + ((IVampirePlayer) VampirismAPI.getFactionPlayerHandler((mc.player)).map(h -> h.getCurrentFactionPlayer().get()).orElse(null)).getLevel();
			int stringWidth = mc.fontRenderer.getStringWidth(food);
			mc.fontRenderer.drawString(food, posX - 45 - stringWidth / 2, posY + 1, 0xFFFFFFFF);
			RenderSystem.disableBlend();
			mc.getProfiler().endSection();
		}
	}
	
	public static void vampireFeedCommand(PlayerEntity player) {
		if (!VampirismAPI.getFactionPlayerHandler((player)).map(h -> VReference.VAMPIRE_FACTION.equals(h.getCurrentFaction())).orElse(false)) {
			player.getFoodStats().setFoodLevel(20);
			player.getFoodStats().setFoodSaturationLevel(20);
		} else {
			IVampirePlayer vplayer = (IVampirePlayer) VampirismAPI.getFactionPlayerHandler((player)).map(h -> h.getCurrentFactionPlayer().get()).orElse(null);
			vplayer.drinkBlood(vplayer.getBloodStats().getMaxBlood(), 1.0F);
		}
	}
	
}
