package com.GenZVirus.BetterUX.Client.GUI;

import com.GenZVirus.BetterUX.Client.File.XMLFileJava;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Settings extends Screen{

	private Button closeButton, resetButton, editButton, changeButton;
	private Minecraft mc = Minecraft.getInstance();
	
	public static Settings instance = new Settings(new TranslationTextComponent("Settings"));
	
	public Settings(ITextComponent titleIn) {
		super(titleIn);
	}
	
	@Override
	protected void init() {
		super.init();
		closeButton = new Button(mc.getMainWindow().getScaledWidth() / 2 + 5, mc.getMainWindow().getScaledHeight() / 2 + 20, 100, 20, "Close", (x) -> {
			this.onClose();
		});
		
		resetButton = new Button(mc.getMainWindow().getScaledWidth() / 2 - 105, mc.getMainWindow().getScaledHeight() / 2 - 5, 100, 20, "Reset to Default", (x) -> {
			XMLFileJava.resetToDefault();
		});
		
		editButton = new Button(mc.getMainWindow().getScaledWidth() / 2 + 5, mc.getMainWindow().getScaledHeight() / 2 - 5, 100, 20, "Edit UI", (x) -> {
			mc.displayGuiScreen(EditOverlay.instance);
		});
		
		changeButton = new Button(mc.getMainWindow().getScaledWidth() / 2 - 105, mc.getMainWindow().getScaledHeight() / 2 + 20, 100, 20, "Change Textures", (x) -> {
			mc.displayGuiScreen(ChangeTextures.instance);
		});
		this.addButton(closeButton);
		this.addButton(resetButton);
		this.addButton(editButton);
		this.addButton(changeButton);
	}
	
	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}
	
	@Override
	public boolean isPauseScreen() {
		return true;
	}
	
	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground();
		super.render(p_render_1_, p_render_2_, p_render_3_);
	}
	
}
