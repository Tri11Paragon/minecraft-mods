package com.brett.randomthings.machines.GUI;

import java.util.Random;

import com.brett.nimbix.MainClass;
import com.brett.randomthings.machines.Container.ContainerInfuser;
import com.brett.randomthings.machines.tileEntity.tileBlockInfuser;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

public class GUIInfuser extends GuiContainer {

	private tileBlockInfuser te;
	private IInventory playerInv;

	public GUIInfuser(IInventory playerInv, tileBlockInfuser te) {
		super(new ContainerInfuser(playerInv, te));

		this.xSize = 176;
		this.ySize = 166;

		this.te = te;
		this.playerInv = playerInv;

	}
	int e = 0;
	int f = 0;
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(MainClass.MODID, "textures/gui/infuser.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        //System.out.println(this.te.isBurning());
        //this.drawTexturedModalRect(i, j, 176, 14, 14, 17);
        
        e = (int) (this.te.getField(0) * 1.9f);
		f = this.te.getField(2);
        //System.out.println(getRespace(e, f));
        this.drawTexturedModalRect((i + 79), (j + 34), 176, 14, getRespace(e, f), 17);

		String s = I18n.format(te.getName()); // Gets the formatted name for the block breaker from the language file -
		// NOTE ADD "container.block_breaker=Block Breaker" to the language file
		// (without quotes) and then delete this note
			this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6,
			4210752); // Draws the block breaker name in the center on the top of the gui
			this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); 
			this.mc.fontRendererObj.drawString("I know this is somewhat broken.", i + 5, j + 5, 4210752); 
			this.mc.fontRendererObj.drawString("It still crafts", i + 90, j + 20, 4210752); 
		
	}
	/**
	 * 
	 * WHY THE F*** DOES THIS WORK?
	 * 
	 * BUT YET THIS DOES NOT:
	 * 
	 * if (x != 0 && y != 0){
	 * 	return x/y;
	 * }
	 * 
	 * ???????????
	 * IF YOU HAVE THE ANWER PLEASE EMAIL ME AT 
	 * brettmaster02@hotmail.com
	 * 
	 * THANK YOU
	 */
	private int getRespace(int x, int y) {
		//System.out.println(y + " ");
		return (int) (x != 0 && y != 0 ? 24 / (x / y) : 0);
	}

	private int getCookProgressScaled(int pixels) {
		int i = this.te.getField(0);
		int j = this.te.getField(2);
		//System.out.println(j != 0 && i != 0 ? i * pixels / j : 0);
		//return j / i * pixels;
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}

	private int getBurnLeftScaled(int pixels) {
		int i = this.te.getField(1);

		if (i == 0) {
			i = 200;
		}

		return this.te.getField(0) * pixels / i;
	}

}
