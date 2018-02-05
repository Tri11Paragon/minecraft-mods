package net.minecraft.client.gui;

import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiYesNo extends GuiScreen {

   protected GuiScreen field_146355_a;
   protected String field_146351_f;
   private String field_146354_r;
   protected String field_146352_g;
   protected String field_146356_h;
   protected int field_146357_i;
   private int field_146353_s;
   private static final String __OBFID = "CL_00000684";


   public GuiYesNo(GuiScreen p_i1025_1_, String p_i1025_2_, String p_i1025_3_, int p_i1025_4_) {
      this.field_146355_a = p_i1025_1_;
      this.field_146351_f = p_i1025_2_;
      this.field_146354_r = p_i1025_3_;
      this.field_146357_i = p_i1025_4_;
      this.field_146352_g = I18n.func_135052_a("gui.yes", new Object[0]);
      this.field_146356_h = I18n.func_135052_a("gui.no", new Object[0]);
   }

   public GuiYesNo(GuiScreen p_i1026_1_, String p_i1026_2_, String p_i1026_3_, String p_i1026_4_, String p_i1026_5_, int p_i1026_6_) {
      this.field_146355_a = p_i1026_1_;
      this.field_146351_f = p_i1026_2_;
      this.field_146354_r = p_i1026_3_;
      this.field_146352_g = p_i1026_4_;
      this.field_146356_h = p_i1026_5_;
      this.field_146357_i = p_i1026_6_;
   }

   public void func_73866_w_() {
      this.field_146292_n.add(new GuiOptionButton(0, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 96, this.field_146352_g));
      this.field_146292_n.add(new GuiOptionButton(1, this.field_146294_l / 2 - 155 + 160, this.field_146295_m / 6 + 96, this.field_146356_h));
   }

   protected void func_146284_a(GuiButton p_146284_1_) {
      this.field_146355_a.func_73878_a(p_146284_1_.field_146127_k == 0, this.field_146357_i);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.func_73732_a(this.field_146289_q, this.field_146351_f, this.field_146294_l / 2, 70, 16777215);
      this.func_73732_a(this.field_146289_q, this.field_146354_r, this.field_146294_l / 2, 90, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_146350_a(int p_146350_1_) {
      this.field_146353_s = p_146350_1_;

      GuiButton var3;
      for(Iterator var2 = this.field_146292_n.iterator(); var2.hasNext(); var3.field_146124_l = false) {
         var3 = (GuiButton)var2.next();
      }

   }

   public void func_73876_c() {
      super.func_73876_c();
      GuiButton var2;
      if(--this.field_146353_s == 0) {
         for(Iterator var1 = this.field_146292_n.iterator(); var1.hasNext(); var2.field_146124_l = true) {
            var2 = (GuiButton)var1.next();
         }
      }

   }
}
