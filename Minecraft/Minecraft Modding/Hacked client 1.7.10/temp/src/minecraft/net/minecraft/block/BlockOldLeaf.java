package net.minecraft.block;

import java.util.List;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOldLeaf extends BlockLeaves {

   public static final String[][] field_150130_N = new String[][]{{"leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle"}, {"leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque"}};
   public static final String[] field_150131_O = new String[]{"oak", "spruce", "birch", "jungle"};
   private static final String __OBFID = "CL_00000280";


   public int func_149741_i(int p_149741_1_) {
      return (p_149741_1_ & 3) == 1?ColorizerFoliage.func_77466_a():((p_149741_1_ & 3) == 2?ColorizerFoliage.func_77469_b():super.func_149741_i(p_149741_1_));
   }

   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      int var5 = p_149720_1_.func_72805_g(p_149720_2_, p_149720_3_, p_149720_4_);
      return (var5 & 3) == 1?ColorizerFoliage.func_77466_a():((var5 & 3) == 2?ColorizerFoliage.func_77469_b():super.func_149720_d(p_149720_1_, p_149720_2_, p_149720_3_, p_149720_4_));
   }

   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
      if((p_150124_5_ & 3) == 0 && p_150124_1_.field_73012_v.nextInt(p_150124_6_) == 0) {
         this.func_149642_a(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.field_151034_e, 1, 0));
      }

   }

   protected int func_150123_b(int p_150123_1_) {
      int var2 = super.func_150123_b(p_150123_1_);
      if((p_150123_1_ & 3) == 3) {
         var2 = 40;
      }

      return var2;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return (p_149691_2_ & 3) == 1?this.field_150129_M[this.field_150127_b][1]:((p_149691_2_ & 3) == 3?this.field_150129_M[this.field_150127_b][3]:((p_149691_2_ & 3) == 2?this.field_150129_M[this.field_150127_b][2]:this.field_150129_M[this.field_150127_b][0]));
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      for(int var2 = 0; var2 < field_150130_N.length; ++var2) {
         this.field_150129_M[var2] = new IIcon[field_150130_N[var2].length];

         for(int var3 = 0; var3 < field_150130_N[var2].length; ++var3) {
            this.field_150129_M[var2][var3] = p_149651_1_.func_94245_a(field_150130_N[var2][var3]);
         }
      }

   }

   public String[] func_150125_e() {
      return field_150131_O;
   }

}
