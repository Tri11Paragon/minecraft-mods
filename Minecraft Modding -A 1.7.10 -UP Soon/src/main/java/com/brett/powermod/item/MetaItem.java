package com.brett.powermod.item;

import java.util.List;

import com.brett.powermod.MainClass;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MetaItem extends Item {
	
	
    public MetaItem(String unlocalizedName) {
        super();
        this.setHasSubtypes(true);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    public IIcon[] icons = new IIcon[6];

  //...

  @Override
  public void registerIcons(IIconRegister reg) {
      for (int i = 0; i < 6; i ++) {
          this.icons[i] = reg.registerIcon(MainClass.MODID + ":multitexture_" + (i));
      }
  }
  
  @Override
  public String getUnlocalizedName(ItemStack stack) {
      return this.getUnlocalizedName() + "_" + stack.getItemDamage();
  }
  
  @Override
  public IIcon getIconFromDamage(int meta) {
      if (meta > 5)
          meta = 0;

      return this.icons[meta];
  }

  @Override
  public void getSubItems(Item item, CreativeTabs tab, List list) {
      for (int i = 0; i < 6; i ++) {
          list.add(new ItemStack(item, 1, i));
      }
  }

    
}
