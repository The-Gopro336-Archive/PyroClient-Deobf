/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.math.MathHelper;

public class f04 {
   // $FF: renamed from: c long
   public long field_2313 = -1L;
   // $FF: renamed from: c float[]
   public float[] field_2314 = new float[20];
   // $FF: renamed from: c int
   public int field_2315;
   // $FF: renamed from: c dev.nuker.pyro.f04
   public static f04 field_2316 = new f04();

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_3477(f4e var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof SPacketTimeUpdate) {
            if (this.field_2313 != -1L) {
               this.field_2314[this.field_2315 % this.field_2314.length] = MathHelper.clamp(20.0F / ((float)(System.currentTimeMillis() - this.field_2313) / 1000.0F), 0.0F, 20.0F);
               ++this.field_2315;
            }

            this.field_2313 = System.currentTimeMillis();
         }

      }
   }

   // $FF: renamed from: c () float
   public float method_3478() {
      int var1 = 0;
      float var2 = 0.0F;

      for(int var3 = 0; var3 < this.field_2314.length; ++var3) {
         float var4 = this.field_2314[var3];
         if (var4 > 0.0F) {
            var2 += var4;
            ++var1;
         }
      }

      return MathHelper.clamp(var2 / (float)var1, 0.0F, 20.0F);
   }

   public f04() {
      int var1 = 0;

      for(int var2 = this.field_2314.length; var1 < var2; ++var1) {
         this.field_2314[var1] = 0.0F;
      }

      Pyro.getEventManager().method_31(this);
   }
}
