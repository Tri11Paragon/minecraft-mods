package net.minecraft.client.resources.data;

import net.minecraft.client.resources.data.IMetadataSection;

public class PackMetadataSection implements IMetadataSection {

   private final String field_110464_a;
   private final int field_110463_b;
   private static final String __OBFID = "CL_00001112";


   public PackMetadataSection(String p_i1312_1_, int p_i1312_2_) {
      this.field_110464_a = p_i1312_1_;
      this.field_110463_b = p_i1312_2_;
   }

   public String func_110461_a() {
      return this.field_110464_a;
   }

   public int func_110462_b() {
      return this.field_110463_b;
   }
}
