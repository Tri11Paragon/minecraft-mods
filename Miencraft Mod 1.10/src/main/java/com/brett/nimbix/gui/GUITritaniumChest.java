package com.brett.nimbix.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import cjminecraft.api.gui.GUIMouse;
import cjminecraft.api.gui.ProgressBar;

import com.brett.nimbix.container.ContainerTestTile;
import com.brett.nimbix.tileentitys.TileTest;

public class GUITritaniumChest extends GuiContainer {
	private TileTest te;
	private IInventory playerInv;
	
	public GUITritaniumChest(IInventory playerInv, TileTest te) {
		super(new ContainerTestTile(playerInv, te));
		
		this.te = te;
		this.playerInv = playerInv;
		
		this.xSize = 176;
		this.ySize = 168;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		String string = this.te.hasCustomName() ? this.te.getName() : I18n.format(this.te.getName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
		//this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		String s = this.te.getDisplayName().getUnformattedText();
		//this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		//this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 75, 4210752);
		//this.mc.getTextureManager().bindTexture(new ResourceLocation("mod:textures/gui/testTile.png"));
	}
}
