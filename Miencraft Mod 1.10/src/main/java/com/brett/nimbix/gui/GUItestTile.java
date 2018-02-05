package com.brett.nimbix.gui;

import java.util.ArrayList;
import java.util.List;

import cjminecraft.api.gui.GUIMouse;
import cjminecraft.api.gui.ProgressBar;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.container.ContainerTestTile;
import com.brett.nimbix.tileentitys.TileTest;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUItestTile extends GuiContainer {
	
	private TileTest te;
	private IInventory playerInv;
	
	public GUItestTile(IInventory playerInv, TileTest te) {
		super(new ContainerTestTile(playerInv, te));
		
		this.te = te;
		this.playerInv = playerInv;
		
		this.xSize = 176;
		this.ySize = 168;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("mod:textures/gui/testTile.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		String s = this.te.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 75, 4210752);
		
		if(this.te.getField(0) >= this.te.getField(1) || this.te.getField(2) <= 0) {
			this.fontRendererObj.drawString("RF/t: 0", 36, 25, 900000);
		}
		else {
			this.fontRendererObj.drawString("RF/t: " + this.te.getField(3), 36, 25, 900000);
		}
		this.fontRendererObj.drawString("Cooldown: " + this.te.getField(2), 36, 36, 500000);
		this.fontRendererObj.drawString("Time Left: " + (this.te.getField(2)/20) + "s", 36, 47, 600000);
		
		GUIMouse mouse = new GUIMouse(width, height, xSize, ySize, mouseX, mouseY);
		ProgressBar bar = new ProgressBar(this.te.getField(0), this.te.getField(1), ProgressBar.TOP_TO_BOTTOM);
		
		//MainClass.print(mouse.getActualMouseX() + " : " + mouse.getActualMouseY());
		
		int progressLevel = getProgressLevel(51);
		
		this.mc.getTextureManager().bindTexture(new ResourceLocation("mod:textures/gui/testTile.png"));
		
		//MainClass.print(" " + getProgressLevel(51));
		
		this.drawTexturedModalRect(120, 20, 184, 71, 22, 22); //changed 20 to 71
		
		//this.drawTexturedModalRect(145, 20, 184, 21, 22, 51 - getProgressLevel(51));
		
		if(mouse.getActualMouseX() >= 144 && mouse.getActualMouseX() <= 166 && mouse.getActualMouseY() >= 19 && mouse.getActualMouseY() <= 72) {
			List<String> text = new ArrayList<String>();
			text.add(this.te.getField(0) + "RF/" + this.te.getField(1) + "RF");
			this.drawHoveringText(text, mouse.getActualMouseX(), mouse.getActualMouseY());
		}
		
	}
	
	private int getProgressLevel(int progressIndicatorPixelHeight) { //added this
		int rf = this.te.getField(0);
		int maxRF = this.te.getField(1);
		return maxRF != 0 && rf != 0 ? (rf * progressIndicatorPixelHeight) / maxRF : 0;
	}

}
