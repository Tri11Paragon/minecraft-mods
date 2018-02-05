package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBigMushroom extends WorldGenerator {

   private int field_76523_a = -1;
   private static final String __OBFID = "CL_00000415";


   public WorldGenBigMushroom(int p_i2017_1_) {
      super(true);
      this.field_76523_a = p_i2017_1_;
   }

   public WorldGenBigMushroom() {
      super(false);
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(2);
      if(this.field_76523_a >= 0) {
         var6 = this.field_76523_a;
      }

      int var7 = p_76484_2_.nextInt(3) + 4;
      boolean var8 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var7 + 1 < 256) {
         int var11;
         int var12;
         for(int var9 = p_76484_4_; var9 <= p_76484_4_ + 1 + var7; ++var9) {
            byte var10 = 3;
            if(var9 <= p_76484_4_ + 3) {
               var10 = 0;
            }

            for(var11 = p_76484_3_ - var10; var11 <= p_76484_3_ + var10 && var8; ++var11) {
               for(var12 = p_76484_5_ - var10; var12 <= p_76484_5_ + var10 && var8; ++var12) {
                  if(var9 >= 0 && var9 < 256) {
                     Block var13 = p_76484_1_.func_147439_a(var11, var9, var12);
                     if(var13.func_149688_o() != Material.field_151579_a && var13.func_149688_o() != Material.field_151584_j) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if(!var8) {
            return false;
         } else {
            Block var16 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
            if(var16 != Blocks.field_150346_d && var16 != Blocks.field_150349_c && var16 != Blocks.field_150391_bh) {
               return false;
            } else {
               int var17 = p_76484_4_ + var7;
               if(var6 == 1) {
                  var17 = p_76484_4_ + var7 - 3;
               }

               for(var11 = var17; var11 <= p_76484_4_ + var7; ++var11) {
                  var12 = 1;
                  if(var11 < p_76484_4_ + var7) {
                     ++var12;
                  }

                  if(var6 == 0) {
                     var12 = 3;
                  }

                  for(int var18 = p_76484_3_ - var12; var18 <= p_76484_3_ + var12; ++var18) {
                     for(int var14 = p_76484_5_ - var12; var14 <= p_76484_5_ + var12; ++var14) {
                        int var15 = 5;
                        if(var18 == p_76484_3_ - var12) {
                           --var15;
                        }

                        if(var18 == p_76484_3_ + var12) {
                           ++var15;
                        }

                        if(var14 == p_76484_5_ - var12) {
                           var15 -= 3;
                        }

                        if(var14 == p_76484_5_ + var12) {
                           var15 += 3;
                        }

                        if(var6 == 0 || var11 < p_76484_4_ + var7) {
                           if((var18 == p_76484_3_ - var12 || var18 == p_76484_3_ + var12) && (var14 == p_76484_5_ - var12 || var14 == p_76484_5_ + var12)) {
                              continue;
                           }

                           if(var18 == p_76484_3_ - (var12 - 1) && var14 == p_76484_5_ - var12) {
                              var15 = 1;
                           }

                           if(var18 == p_76484_3_ - var12 && var14 == p_76484_5_ - (var12 - 1)) {
                              var15 = 1;
                           }

                           if(var18 == p_76484_3_ + (var12 - 1) && var14 == p_76484_5_ - var12) {
                              var15 = 3;
                           }

                           if(var18 == p_76484_3_ + var12 && var14 == p_76484_5_ - (var12 - 1)) {
                              var15 = 3;
                           }

                           if(var18 == p_76484_3_ - (var12 - 1) && var14 == p_76484_5_ + var12) {
                              var15 = 7;
                           }

                           if(var18 == p_76484_3_ - var12 && var14 == p_76484_5_ + (var12 - 1)) {
                              var15 = 7;
                           }

                           if(var18 == p_76484_3_ + (var12 - 1) && var14 == p_76484_5_ + var12) {
                              var15 = 9;
                           }

                           if(var18 == p_76484_3_ + var12 && var14 == p_76484_5_ + (var12 - 1)) {
                              var15 = 9;
                           }
                        }

                        if(var15 == 5 && var11 < p_76484_4_ + var7) {
                           var15 = 0;
                        }

                        if((var15 != 0 || p_76484_4_ >= p_76484_4_ + var7 - 1) && !p_76484_1_.func_147439_a(var18, var11, var14).func_149730_j()) {
                           this.func_150516_a(p_76484_1_, var18, var11, var14, Block.func_149729_e(Block.func_149682_b(Blocks.field_150420_aW) + var6), var15);
                        }
                     }
                  }
               }

               for(var11 = 0; var11 < var7; ++var11) {
                  Block var19 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + var11, p_76484_5_);
                  if(!var19.func_149730_j()) {
                     this.func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + var11, p_76484_5_, Block.func_149729_e(Block.func_149682_b(Blocks.field_150420_aW) + var6), 10);
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }
}
