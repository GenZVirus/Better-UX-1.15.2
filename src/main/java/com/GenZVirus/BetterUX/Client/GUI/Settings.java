package com.GenZVirus.BetterUX.Client.GUI;

import com.GenZVirus.BetterUX.Client.File.XMLFileJava;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Settings extends Screen{

	private Button closeButton, resetButton, editButton, changeButton, enable_or_disable_BetterUX, enable_or_disable_text, enable_or_disable_soundeffects;
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
			XMLFileJava.load();
		});
		
		editButton = new Button(mc.getMainWindow().getScaledWidth() / 2 + 5, mc.getMainWindow().getScaledHeight() / 2 - 5, 100, 20, "Edit UI", (x) -> {
			mc.displayGuiScreen(EditOverlay.instance);
		});
		
		changeButton = new Button(mc.getMainWindow().getScaledWidth() / 2 - 105, mc.getMainWindow().getScaledHeight() / 2 + 20, 100, 20, "Change Textures", (x) -> {
			mc.displayGuiScreen(ChangeTextures.instance);
		});
		enable_or_disable_BetterUX = new Button(mc.getMainWindow().getScaledWidth() / 2 - 105, mc.getMainWindow().getScaledHeight() / 2 + 45, 210, 20, XMLFileJava.readElement("Enabled_Disabled").contentEquals("enabled")? "Disable Better UX Overlay" : "Enable Better UX Overlay", (x) -> {
			XMLFileJava.checkFileAndMake();
			if(XMLFileJava.readElement("Enabled_Disabled").contentEquals("enabled")) {
				XMLFileJava.editElement("Enabled_Disabled", "disabled");
			} else XMLFileJava.editElement("Enabled_Disabled", "enabled");
			this.enable_or_disable_BetterUX.setMessage(XMLFileJava.readElement("Enabled_Disabled").contentEquals("enabled")? "Disable Better UX Overlay" : "Enable Better UX Overlay");
			XMLFileJava.load();
		});
		
		enable_or_disable_text = new Button(mc.getMainWindow().getScaledWidth() / 2 - 105, mc.getMainWindow().getScaledHeight() / 2 + 70, 210, 20, XMLFileJava.readElement("TextDisabled").contentEquals("false")? "Disable Text" : "Enable Text", (x) -> {
			XMLFileJava.checkFileAndMake();
			if(XMLFileJava.readElement("TextDisabled").contentEquals("false")) {
				XMLFileJava.editElement("TextDisabled", "true");
			} else XMLFileJava.editElement("TextDisabled", "false");
			this.enable_or_disable_text.setMessage(XMLFileJava.readElement("TextDisabled").contentEquals("false")? "Disable Text" : "Enable Text");
			XMLFileJava.load();
		});
		enable_or_disable_soundeffects = new Button(mc.getMainWindow().getScaledWidth() / 2 - 105, mc.getMainWindow().getScaledHeight() / 2 - 30, 210, 20, XMLFileJava.readElement("SoundEffects").contentEquals("false")? "Enable Sound Effects" : "Disable Sound Effects", (x) -> {
			XMLFileJava.checkFileAndMake();
			if(XMLFileJava.readElement("SoundEffects").contentEquals("false")) {
				XMLFileJava.editElement("SoundEffects", "true");
			} else XMLFileJava.editElement("SoundEffects", "false");
			this.enable_or_disable_soundeffects.setMessage(XMLFileJava.readElement("SoundEffects").contentEquals("false")? "Enable Sound Effects" : "Disable Sound Effects");
			XMLFileJava.load();
		});
		this.addButton(closeButton);
		this.addButton(resetButton);
		this.addButton(editButton);
		this.addButton(changeButton);
		this.addButton(enable_or_disable_BetterUX);
		this.addButton(enable_or_disable_text);
		this.addButton(enable_or_disable_soundeffects);
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
