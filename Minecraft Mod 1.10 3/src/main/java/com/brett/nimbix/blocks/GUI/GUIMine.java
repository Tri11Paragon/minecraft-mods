package com.brett.nimbix.blocks.GUI;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.event.MouseInputListener;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.container.ContainerMine;
import com.brett.nimbix.blocks.te.tileMine;

import cjminecraft.core.config.CJCoreConfig;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiConfigEntries.ButtonEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GUIMine extends GuiContainer {

	public static int sync = 0;
	
	private tileMine te;
	private IInventory playerInv;
	
	//private EnergyBar energyBar;
	private GuiButton deleteJunk;
	
	public GUIMine(IInventory playerInv, tileMine te) {
		super(new ContainerMine(playerInv, te));
		
		//this.xSize = 176;
		//this.ySize = 166;
		
		this.te=te;
		this.playerInv=playerInv;
		
	}
	
	@Override
	public void initGui() {
		//energyBar = new EnergyBar(0, (this.xSize * 3) - 78, (this.height / 2 - this.ySize / 2) + 12, 18, 60, 0, 0);
		deleteJunk = new GuiButton(1, (this.width / 2) - 65, (this.height / 2 - this.ySize / 2) + 20, 135, 20, "Delete Junk Items: " + te.getShouldDeleteItems());
		//this.buttonList.add(energyBar);
		this.buttonList.add(deleteJunk);
		super.initGui();
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(MainClass.MODID, "textures/gui/infuser.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0,0, this.xSize, this.ySize);
		sync++;
		sync %= 10;
		if (sync == 0){
			//this.energyBar.syncData(this.te.getPos(), EnumFacing.NORTH);
			this.deleteJunk.displayString = "Delete Junk Items: " + te.getShouldDeleteItems();
		}
		
	}
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		String s = I18n.format(te.getName());
		this.fontRendererObj.drawString(s, 8, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
		//if (this.energyBar.isMouseOver()){
			//this.drawHoveringText(Arrays.asList(this.energyBar.energy + " " + CJCoreConfig.DEFAULT_ENERGY_UNIT.getSuffix() + " / " + this.energyBar.capacity + " " + CJCoreConfig.DEFAULT_ENERGY_UNIT.getSuffix()), mouseX / 4, mouseY / 2);
		//}
		
	}
	//@SideOnly(Side.SERVER)
	protected void actionPerformed(GuiButton button) throws IOException {
	    if (button == this.deleteJunk) {
	    	te.setShouldDeleteItems(!te.getShouldDeleteItems());
	        System.out.println("WORKING " + te.getShouldDeleteItems() + " : " + te.getPos().getX() + " : " + te.getPos().getY() + " : " + te.getPos().getZ());
	        //this.mc.displayGuiScreen(null);
	        
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }
	}

}
