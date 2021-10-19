/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fbn extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_916;

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      double var3 = (double)(MathHelper.floor((this.c.player.lastTickPosX + (this.c.player.posX - this.c.player.lastTickPosX) * (double)var2 + 64.0D) / (double)128) * 128) - 64.0D;
      double var5 = (double)(MathHelper.floor((this.c.player.lastTickPosZ + (this.c.player.posZ - this.c.player.lastTickPosZ) * (double)var2 + 64.0D) / (double)128) * 128) - 64.0D;
      GlStateManager.glLineWidth(2.0F);
      fe5.field_1245.method_1915(1);
      fe5.field_1245.method_1913((float)var3, 0.0F, (float)var5, 128.0F, 0.0F, 128.0F, ((f00)this.field_916.c()).meth1(), 1);
      fe5.field_1245.method_1904(fe5.field_1245.getBuffer(), var3 + (double)64, 0.0D, var5 + (double)126, var3 + (double)64, 0.0D, var5 + (double)2, ((f00)this.field_916.c()).meth1(), ((f00)this.field_916.c()).meth1());
      fe5.field_1245.method_1904(fe5.field_1245.getBuffer(), var3 + (double)2, 0.0D, var5 + (double)64, var3 + (double)64, 0.0D, var5 + (double)2, ((f00)this.field_916.c()).meth1(), ((f00)this.field_916.c()).meth1());
      fe5.field_1245.method_1904(fe5.field_1245.getBuffer(), var3 + (double)126, 0.0D, var5 + (double)64, var3 + (double)64, 0.0D, var5 + (double)2, ((f00)this.field_916.c()).meth1(), ((f00)this.field_916.c()).meth1());
      fe5.field_1245.method_1912();
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1347() {
      return this.field_916;
   }

   public fbn() {
      super("mapborders", "MapBorders", "Shows the border of a 1x1 map in the world");
      this.field_916 = (f0l)this.register((f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3696(-11206401))));
   }
}
