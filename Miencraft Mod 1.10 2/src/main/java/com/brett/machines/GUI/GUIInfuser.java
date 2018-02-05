package com.brett.machines.GUI;

import com.brett.machines.Container.ContainerInfuser;
import com.brett.machines.tileEntity.tileBlockInfuser;
import com.brett.nimbix.MainClass;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUIInfuser extends GuiContainer {

	private tileBlockInfuser te;
	private IInventory playerInv;
	
	public GUIInfuser(IInventory playerInv, tileBlockInfuser te) {
		super(new ContainerInfuser(playerInv, te));
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.te=te;
		this.playerInv=playerInv;
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(MainClass.MODID, "textures/gui/infuser.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0,0, this.xSize, this.ySize);
		
		String s = I18n.format(te.getName()); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=Block Breaker" to the language file (without quotes) and then delete this note
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
	}

}
