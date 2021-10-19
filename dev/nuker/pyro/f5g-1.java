/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import net.minecraft.client.renderer.GlStateManager;

public class f5g extends f4T {
   // $FF: renamed from: c dev.nuker.pyro.f5f
   public f5f field_1137;
   // $FF: renamed from: c dev.nuker.pyro.f4Q
   public f4Q field_1138 = null;
   // $FF: renamed from: 2 boolean
   public boolean field_1139 = true;

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      if (this.field_1138 != null) {
         this.field_1138.method_1622(var1, var2, var3);
         boolean var4 = this.field_1138.method_1630().equals("Confirm");
         boolean var5 = this.field_1138.method_1630().equals("Cancel");
         if (var4 || var5) {
            f5b var6 = (f5b)c.currentScreen;
            var6.method_2944(var4);
         }
      }

   }

   public f5g(String var1, float var2, float var3) {
      super(var1, var2, var3, 200.0F, 80.0F, 20.0F);
      this.5().add(this.field_1137 = new f5f("TEXTFIELD", 30.0F, this.meth4() / 2.0F, 140.0F, 10.0F));
      this.5().add(new f5e("Confirm", 30.0F, this.meth4() / 2.0F + 15.0F, 65.0F, 20.0F));
      this.5().add(new f5e("Cancel", 105.0F, this.meth4() / 2.0F + 15.0F, 65.0F, 20.0F));
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      GlStateManager.pushMatrix();
      GlStateManager.translate(this.2(), this.7(), 0.0F);
      PyroRenderUtil.meth0(0.0F, 0.0F, this.c(), this.meth4(), -16777216);
      PyroRenderUtil.meth0(0.0F, 0.0F, this.c(), this.meth1(), f0H.field_2338.method_3505());
      class_59.field_2713.field_2715.drawCenteredString(this.8(), this.c() / 2.0F, 4.0F, -1, true);
      PyroRenderUtil.meth0("Set the exact value", this.c() / 2.0F, 25.0F, -1);
      this.field_1139 = true;
      Iterator var4 = this.5().iterator();

      while(var4.hasNext()) {
         f4Q var5 = (f4Q)var4.next();
         if (var1 >= this.2() + var5.method_1625() && var1 <= this.2() + var5.method_1635() + var5.method_1625() && var2 >= this.7() + var5.method_1641() && var2 <= this.7() + var5.method_1641() + var5.meth4() && this.field_1139) {
            this.field_1139 = false;
            this.field_1138 = var5;
         }

         var5.method_1623(this.field_1138 == var5);
         var5.method_1639(var1, var2, var3);
      }

      GlStateManager.popMatrix();
      if (this.field_1139 && this.field_1138 != null) {
         this.field_1138 = null;
      }

      return super.method_1639(var1, var2, var3);
   }

   // $FF: renamed from: c (char, int) void
   public void method_1632(char var1, int var2) {
      super.c(var1, var2);
      this.field_1137.method_1632(var1, var2);
   }

   // $FF: renamed from: c () dev.nuker.pyro.f5f
   public f5f method_1677() {
      return this.field_1137;
   }
}
