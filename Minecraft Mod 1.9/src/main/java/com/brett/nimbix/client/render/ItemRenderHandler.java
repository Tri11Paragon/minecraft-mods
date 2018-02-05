package com.brett.nimbix.client.render;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.items.Dust;
import com.brett.nimbix.items.OtherItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderHandler {

	public static void registerItemRender(){
		register(Dust.FluxDust);
		register(Dust.CharcoalDust);
		register(Dust.CoalDust);
		register(Dust.CopperDust);
		register(Dust.DiamondDust);
		register(Dust.GoldDust);
		register(Dust.IronDust);
		register(Dust.LeadDust);
		register(Dust.TinDust);
		
		register(Dust.FluxIngot);
		register(Dust.CopperIngot);
		register(Dust.LeadIngot);
		register(Dust.TinIngot);
		
		register(OtherItems.teleporterMemory);
	}
	
	public static void register(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Item Model Loaded!");
	}
	
}
