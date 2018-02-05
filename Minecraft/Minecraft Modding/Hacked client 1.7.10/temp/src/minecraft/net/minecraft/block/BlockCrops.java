package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCrops extends BlockBush implements IGrowable {

   private IIcon[] field_149867_a;
   private static final String __OBFID = "CL_00000222";


   protected BlockCrops() {
      this.func_149675_a(true);
      float var1 = 0.5F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.func_149647_a((CreativeTabs)null);
      this.func_149711_c(0.0F);
      this.func_149672_a(field_149779_h);
      this.func_149649_H();
   }

   protected boolean func_149854_a(Block p_149854_1_) {
      return p_149854_1_ == Blocks.field_150458_ak;
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
      if(p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
         int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         if(var6 < 7) {
            float var7 = this.func_149864_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
            if(p_149674_5_.nextInt((int)(25.0F / var7) + 1) == 0) {
               ++var6;
               p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var6, 2);
            }
         }
      }

   }

   public void func_149863_m(World p_149863_1_, int p_149863_2_, int p_149863_3_, int p_149863_4_) {
      int var5 = p_149863_1_.func_72805_g(p_149863_2_, p_149863_3_, p_149863_4_) + MathHelper.func_76136_a(p_149863_1_.field_73012_v, 2, 5);
      if(var5 > 7) {
         var5 = 7;
      }

      p_149863_1_.func_72921_c(p_149863_2_, p_149863_3_, p_149863_4_, var5, 2);
   }

   private float func_149864_n(World p_149864_1_, int p_149864_2_, int p_149864_3_, int p_149864_4_) {
      float var5 = 1.0F;
      Block var6 = p_149864_1_.func_147439_a(p_149864_2_, p_149864_3_, p_149864_4_ - 1);
      Block var7 = p_149864_1_.func_147439_a(p_149864_2_, p_149864_3_, p_149864_4_ + 1);
      Block var8 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_);
      Block var9 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_);
      Block var10 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_ - 1);
      Block var11 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_ - 1);
      Block var12 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_ + 1);
      Block var13 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_ + 1);
      boolean var14 = var8 == this || var9 == this;
      boolean var15 = var6 == this || var7 == this;
      boolean var16 = var10 == this || var11 == this || var12 == this || var13 == this;

      for(int var17 = p_149864_2_ - 1; var17 <= p_149864_2_ + 1; ++var17) {
         for(int var18 = p_149864_4_ - 1; var18 <= p_149864_4_ + 1; ++var18) {
            float var19 = 0.0F;
            if(p_149864_1_.func_147439_a(var17, p_149864_3_ - 1, var18) == Blocks.field_150458_ak) {
               var19 = 1.0F;
               if(p_149864_1_.func_72805_g(var17, p_149864_3_ - 1, var18) > 0) {
                  var19 = 3.0F;
               }
            }

            if(var17 != p_149864_2_ || var18 != p_149864_4_) {
               var19 /= 4.0F;
            }

            var5 += var19;
         }
      }

      if(var16 || var14 && var15) {
         var5 /= 2.0F;
      }

      return var5;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      if(p_149691_2_ < 0 || p_149691_2_ > 7) {
         p_149691_2_ = 7;
      }

      return this.field_149867_a[p_149691_2_];
   }

   public int func_149645_b() {
      return 6;
   }

   protected Item func_149866_i() {
      return Items.field_151014_N;
   }

   protected Item func_149865_P() {
      return Items.field_151015_O;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
      if(!p_149690_1_.field_72995_K) {
         if(p_149690_5_ >= 7) {
            int var8 = 3 + p_149690_7_;

            for(int var9 = 0; var9 < var8; ++var9) {
               if(p_149690_1_.field_73012_v.nextInt(15) <= p_149690_5_) {
                  this.func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(this.func_149866_i(), 1, 0));
               }
            }
         }

      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return p_149650_1_ == 7?this.func_149865_P():this.func_149866_i();
   }

   public int func_149745_a(Random p_149745_1_) {
      return 1;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return this.func_149866_i();
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149867_a = new IIcon[8];

      for(int var2 = 0; var2 < this.field_149867_a.length; ++var2) {
         this.field_149867_a[var2] = p_149651_1_.func_94245_a(this.func_149641_N() + "_stage_" + var2);
      }

   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      return p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      this.func_149863_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
   }
}