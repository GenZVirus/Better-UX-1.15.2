package com.GenZVirus.BetterUX.Client.GUI;

import java.util.List;

import com.GenZVirus.BetterUX.Client.File.XMLFileJava;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EditOverlay extends Screen {

	private SelectedOverlay leftShield, rightShield, healthBar, foodBar, expBar, fireBar, airBar;
	private Minecraft mc = Minecraft.getInstance();

	public static EditOverlay instance = new EditOverlay(new TranslationTextComponent("EditOverlay"));

	public EditOverlay(ITextComponent titleIn) {
		super(titleIn);
	}

	@Override
	protected void init() {
		leftShield = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("LeftShieldPosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("LeftShieldPosY")), 32, 32, "", "LeftShield");
		rightShield = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("RightShieldPosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("RightShieldPosY")), 32, 32, "", "RightShield");
		healthBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("HealthBarPosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("HealthBarPosY")), 90, 10, "", "HealthBar");
		foodBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("FoodBarPosX")) - 90, mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("FoodBarPosY")), 90, 10, "", "FoodBar");
		expBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("ExpBarPosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("ExpBarPosY")), 182, 16, "", "ExpBar");
		fireBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("FirePosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("FirePosY")), 200, 32, "", "Fire");
		airBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("AirBarPosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("AirBarPosY")), 182, 16, "", "AirBar");
		this.addButton(leftShield);
		this.addButton(rightShield);
		this.addButton(healthBar);
		this.addButton(foodBar);
		this.addButton(expBar);
		this.addButton(fireBar);
		this.addButton(airBar);
	}

	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		leftShield.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("LeftShieldPosX"));
		leftShield.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("LeftShieldPosY"));
		rightShield.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("RightShieldPosX"));
		rightShield.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("RightShieldPosY"));
		healthBar.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("HealthBarPosX"));
		healthBar.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("HealthBarPosY"));
		foodBar.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("FoodBarPosX")) - 90;
		foodBar.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("FoodBarPosY"));
		expBar.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("ExpBarPosX"));
		expBar.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("ExpBarPosY"));
		fireBar.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("FirePosX"));
		fireBar.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("FirePosY"));
		airBar.x = mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("AirBarPosX"));
		airBar.y = mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("AirBarPosY"));
		if (!mc.player.isBurning()) {
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.FIRE));
			AbstractGui.blit(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("FirePosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("FirePosY")), 0, 0, 0, 200, 32, 5792, 200);
		}
		if (!mc.player.areEyesInFluid(FluidTags.WATER) || !(mc.player.getAir() < mc.player.getMaxAir())) {
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.WATER_BREATHING_BAR));
			AbstractGui.blit(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("AirBarPosX")), mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("AirBarPosY")), 0, 0, 0, 182, 16, 16, 182);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.WATER_BREATHING_BAR_FILL));
			AbstractGui.blit(mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("AirBarPosX")) + 1, mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("AirBarPosY")) + 1, 0, 0, 0, 180, 14, 14, 180);
		}
		if (mc.player.getTotalArmorValue() <= 0) {
			RenderSystem.scalef(0.5F, 0.5F, 0.5F);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.ARMOR_LEFT));
			AbstractGui.blit((mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("LeftShieldPosX"))) * 2, (mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("LeftShieldPosY"))) * 2, 0, 0, 0, 64, 64, 64, 64);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.ARMOR_RIGHT));
			AbstractGui.blit((mc.getMainWindow().getScaledWidth() / 2 + Integer.parseInt(XMLFileJava.readElement("RightShieldPosX"))) * 2, (mc.getMainWindow().getScaledHeight() + Integer.parseInt(XMLFileJava.readElement("RightShieldPosY"))) * 2, 0, 0, 0, 64, 64, 64, 64);
			RenderSystem.scalef(2.0F, 2.0F, 2.0F);
		}
		super.render(p_render_1_, p_render_2_, p_render_3_);

	}

	public List<Widget> getButtons() {
		return this.buttons;
	}

}
