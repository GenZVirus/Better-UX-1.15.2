package com.GenZVirus.BetterUX.Client.GUI;

import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EditOverlay extends Screen {

	private SelectedOverlay leftShield, rightShield, healthBar, foodBar, expBar, fireBar, airBar, bossBar;
	private Minecraft mc = Minecraft.getInstance();

	public static EditOverlay instance = new EditOverlay(new TranslationTextComponent("EditOverlay"));

	public EditOverlay(ITextComponent titleIn) {
		super(titleIn);
	}

	@Override
	protected void init() {
		leftShield = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.LeftShieldPosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.LeftShieldPosY, 32, 32, "", mc.getMainWindow().getScaledWidth() / 2, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.LeftShieldPosX += number;
				BetterOverlay.updateLeftShieldPosX();
				leftShield.x =  BetterOverlay.leftShieldPosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.LeftShieldPosY += number;
				BetterOverlay.updateLeftShieldPosY();
				leftShield.y = BetterOverlay.leftShieldPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.LeftShieldPosX -= number;
				BetterOverlay.updateLeftShieldPosX();
				leftShield.x =  BetterOverlay.leftShieldPosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.LeftShieldPosY -= number;
				BetterOverlay.updateLeftShieldPosY();
				leftShield.y = BetterOverlay.leftShieldPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.LeftShieldPosX = X;
				BetterOverlay.updateLeftShieldPosX();
				leftShield.x =  BetterOverlay.leftShieldPosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.LeftShieldPosY = Y;
				BetterOverlay.updateLeftShieldPosY();
				leftShield.y = BetterOverlay.leftShieldPosY;
				super.setY(Y);
			}
		};
		rightShield = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.RightShieldPosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.RightShieldPosY, 32, 32, "", mc.getMainWindow().getScaledWidth() / 2, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.RightShieldPosX += number;
				BetterOverlay.updateRightSHieldPosX();
				rightShield.x = BetterOverlay.rightShieldPosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.RightShieldPosY += number;
				BetterOverlay.updateRightSHieldPosY();
				rightShield.y = BetterOverlay.rightShieldPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.RightShieldPosX -= number;
				BetterOverlay.updateRightSHieldPosX();
				rightShield.x = BetterOverlay.rightShieldPosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.RightShieldPosY -= number;
				BetterOverlay.updateRightSHieldPosY();
				rightShield.y = BetterOverlay.rightShieldPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.RightShieldPosX = X;
				BetterOverlay.updateRightSHieldPosX();
				rightShield.x = BetterOverlay.rightShieldPosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.RightShieldPosY = Y;
				BetterOverlay.updateRightSHieldPosY();
				rightShield.y = BetterOverlay.rightShieldPosY;
				super.setY(Y);
			}
		};
		healthBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.HealthBarPosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.HealthBarPosY, 90, 10, "", mc.getMainWindow().getScaledWidth() / 2, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.HealthBarPosX += number;
				BetterOverlay.updateHealthPosX();
				healthBar.x = BetterOverlay.HealthPosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.HealthBarPosY += number;
				BetterOverlay.updateHealthPosY();
				healthBar.y = BetterOverlay.HealthPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.HealthBarPosX -= number;
				BetterOverlay.updateHealthPosX();
				healthBar.x = BetterOverlay.HealthPosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.HealthBarPosY -= number;
				BetterOverlay.updateHealthPosY();
				healthBar.y = BetterOverlay.HealthPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.HealthBarPosX = X;
				BetterOverlay.updateHealthPosX();
				healthBar.x = BetterOverlay.HealthPosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.HealthBarPosY = Y;
				BetterOverlay.updateHealthPosY();
				healthBar.y = BetterOverlay.HealthPosY;
				super.setY(Y);
			}
		};
		foodBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.FoodBarPosX - 90, mc.getMainWindow().getScaledHeight() + BetterOverlay.FoodBarPosY, 90, 10, "", mc.getMainWindow().getScaledWidth() / 2 -90, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.FoodBarPosX += number;
				BetterOverlay.updateFoodPosX();
				foodBar.x = BetterOverlay.foodPosX - 90;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.FoodBarPosY += number;
				BetterOverlay.updateFoodPosY();
				foodBar.y = BetterOverlay.foodPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.FoodBarPosX -= number;
				BetterOverlay.updateFoodPosX();
				foodBar.x = BetterOverlay.foodPosX - 90;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.FoodBarPosY -= number;
				BetterOverlay.updateFoodPosY();
				foodBar.y = BetterOverlay.foodPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.FoodBarPosX = X;
				BetterOverlay.updateFoodPosX();
				foodBar.x = BetterOverlay.foodPosX - 90;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.FoodBarPosY = Y;
				BetterOverlay.updateFoodPosY();
				foodBar.y = BetterOverlay.foodPosY;
				super.setY(Y);
			}
		};
		expBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.ExpBarPosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.ExpBarPosY, 182, 16, "", mc.getMainWindow().getScaledWidth() / 2, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.ExpBarPosX += number;
				BetterOverlay.updateExpPosX();
				expBar.x = BetterOverlay.expPosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.ExpBarPosY += number;
				BetterOverlay.updateExpPosY();
				expBar.y = BetterOverlay.expPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.ExpBarPosX -= number;
				BetterOverlay.updateExpPosX();
				expBar.x = BetterOverlay.expPosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.ExpBarPosY -= number;
				BetterOverlay.updateExpPosY();
				expBar.y = BetterOverlay.expPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.ExpBarPosX = X;
				BetterOverlay.updateExpPosX();
				expBar.x = BetterOverlay.expPosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.ExpBarPosY = Y;
				BetterOverlay.updateExpPosY();
				expBar.y = BetterOverlay.expPosY;
				super.setY(Y);
			}
		};
		fireBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.FirePosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.FirePosY, 200, 32, "", mc.getMainWindow().getScaledWidth() / 2, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.FirePosX += number;
				BetterOverlay.updateFirePosX();
				fireBar.x = BetterOverlay.firePosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.FirePosY += number;
				BetterOverlay.updateFirePosY();
				fireBar.y = BetterOverlay.firePosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.FirePosX -= number;
				BetterOverlay.updateFirePosX();
				fireBar.x = BetterOverlay.firePosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.FirePosY -= number;
				BetterOverlay.updateFirePosY();
				fireBar.y = BetterOverlay.firePosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.FirePosX = X;
				BetterOverlay.updateFirePosX();
				fireBar.x = BetterOverlay.firePosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.FirePosY = Y;
				BetterOverlay.updateFirePosY();
				fireBar.y = BetterOverlay.firePosY;
				super.setY(Y);
			}
		};
		airBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.AirBarPosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.AirBarPosY, 182, 16, "", mc.getMainWindow().getScaledWidth() / 2, mc.getMainWindow().getScaledHeight()) {
			@Override
			public void addX(int number) {
				BetterOverlay.AirBarPosX += number;
				BetterOverlay.updateAirPosX();
				airBar.x = BetterOverlay.airPosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.AirBarPosY += number;
				BetterOverlay.updateAirPosY();
				airBar.y = BetterOverlay.airPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.AirBarPosX -= number;
				BetterOverlay.updateAirPosX();
				airBar.x = BetterOverlay.airPosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.AirBarPosY -= number;
				BetterOverlay.updateAirPosY();
				airBar.y = BetterOverlay.airPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.AirBarPosX = X;
				BetterOverlay.updateAirPosX();
				airBar.x = BetterOverlay.airPosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.AirBarPosY = Y;
				BetterOverlay.updateAirPosY();
				airBar.y = BetterOverlay.airPosY;
				super.setY(Y);
			}
		};
		bossBar = new SelectedOverlay(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.BossBarPosX, BetterOverlay.BossBarPosY, 320, 32, "", mc.getMainWindow().getScaledWidth() / 2, 0) {
			@Override
			public void addX(int number) {
				BetterOverlay.BossBarPosX += number;
				BetterOverlay.updateBossPosX();
				bossBar.x = BetterOverlay.bossPosX;
				super.addX(number);
			}

			@Override
			public void addY(int number) {
				BetterOverlay.BossBarPosY += number;
				BetterOverlay.updateBossPosY();
				bossBar.y = BetterOverlay.bossPosY;
				super.addY(number);
			}

			@Override
			public void substractX(int number) {
				BetterOverlay.BossBarPosX -= number;
				BetterOverlay.updateBossPosX();
				bossBar.x = BetterOverlay.bossPosX;
				super.substractX(number);
			}

			@Override
			public void substractY(int number) {
				BetterOverlay.BossBarPosY -= number;
				BetterOverlay.updateBossPosY();
				bossBar.y = BetterOverlay.bossPosY;
				super.substractY(number);
			}

			@Override
			public void setX(int X) {
				BetterOverlay.BossBarPosX = X;
				BetterOverlay.updateBossPosX();
				bossBar.x = BetterOverlay.bossPosX;
				super.setX(X);
			}

			@Override
			public void setY(int Y) {
				BetterOverlay.BossBarPosY = Y;
				BetterOverlay.updateBossPosY();
				bossBar.y = BetterOverlay.bossPosY;
				super.setY(Y);
			}
		};
		this.addButton(leftShield);
		this.addButton(rightShield);
		this.addButton(healthBar);
		this.addButton(foodBar);
		this.addButton(expBar);
		this.addButton(fireBar);
		this.addButton(airBar);
		this.addButton(bossBar);
	}

	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		if (!mc.player.isBurning()) {
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.FIRE));
			AbstractGui.blit(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.FirePosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.FirePosY, 0, 0, 0, 200, 32, 5792, 200);
		}
		if (!mc.player.areEyesInFluid(FluidTags.WATER) || !(mc.player.getAir() < mc.player.getMaxAir())) {
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.WATER_BREATHING_BAR));
			AbstractGui.blit(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.AirBarPosX, mc.getMainWindow().getScaledHeight() + BetterOverlay.AirBarPosY, 0, 0, 0, 182, 16, 16, 182);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.WATER_BREATHING_BAR_FILL));
			AbstractGui.blit(mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.AirBarPosX + 1, mc.getMainWindow().getScaledHeight() + BetterOverlay.AirBarPosY + 1, 0, 0, 0, 180, 14, 14, 180);
		}
		if (mc.player.getTotalArmorValue() <= 0) {
			RenderSystem.scalef(0.5F, 0.5F, 0.5F);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.ARMOR_LEFT));
			AbstractGui.blit((mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.LeftShieldPosX) * 2, (mc.getMainWindow().getScaledHeight() + BetterOverlay.LeftShieldPosY) * 2, 0, 0, 0, 64, 64, 64, 64);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.ARMOR_RIGHT));
			AbstractGui.blit((mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.RightShieldPosX) * 2, (mc.getMainWindow().getScaledHeight() + BetterOverlay.RightShieldPosY) * 2, 0, 0, 0, 64, 64, 64, 64);
			RenderSystem.scalef(2.0F, 2.0F, 2.0F);
		}
		if (mc.ingameGUI.getBossOverlay().mapBossInfos.isEmpty()) {
			int posX = mc.getMainWindow().getScaledWidth() / 2 + BetterOverlay.BossBarPosX;
			int posY = BetterOverlay.BossBarPosY;
			RenderSystem.scalef(1.0F, 0.8F, 1.0F);
			RenderSystem.enableBlend();
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.BOSS_BAR_BACKGROUND));
			AbstractGui.blit(posX, (int) (posY * 1.25F), 0, 0, 0, 320, 40, 40, 320);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.BOSS_BAR_HEALTH));
			AbstractGui.blit(posX, (int) (posY * 1.25F), 0, 0, 0, 320, 40, 40, 320);
			mc.getTextureManager().bindTexture(BetterUXResources.getResourceOf(BetterUXResources.BOSS_BAR_OVERLAY));
			AbstractGui.blit(posX, (int) (posY * 1.25F), 0, 0, 0, 320, 40, 40, 320);
			RenderSystem.disableBlend();
			RenderSystem.scalef(1.0F, 1.25F, 1.0F);
		}
		super.render(p_render_1_, p_render_2_, p_render_3_);

	}

	public List<Widget> getButtons() {
		return this.buttons;
	}

}
