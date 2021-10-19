/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Arrays;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0R extends f0M {
   // $FF: renamed from: 1 boolean
   public boolean field_2375;

   // $FF: renamed from: 0 (boolean) void
   public void method_3619(boolean var1) {
      this.field_2375 = var1;
   }

   // $FF: renamed from: c (double) java.lang.String
   @Nullable
   public String method_3617(double var1) {
      StringCompanionObject var3 = StringCompanionObject.INSTANCE;
      String var4 = "%d";
      Object[] var5 = new Object[]{(int)var1};
      boolean var6 = false;
      return String.format(var4, Arrays.copyOf(var5, var5.length));
   }

   // $FF: renamed from: c () boolean
   public boolean method_3620() {
      return this.field_2375;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      if (var3 instanceof f15 && var3.method_3645() == 0) {
         class_6 var10000 = this.c;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         double var4 = ((Number)var10000.method_3034()).doubleValue() + ((f15)var3).method_3655() / ((double)(var1.method_3581() - f0H.field_2335 * 2) / this.1);
         if (var4 > this.0) {
            var4 = this.0;
         } else if (var4 < this.c) {
            var4 = this.c;
         }

         class_6 var10001 = this.c;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         if (Intrinsics.areEqual(var4, (Double)var10001.method_3034()) ^ true) {
            var10000 = this.c;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.method_3033(var4);
         }

         this.0 = -1;
         this.0 = (String)null;
      } else if (var3 instanceof f18 && !(var3 instanceof f16) && var3.method_3645() == 0) {
         if (this.0 == -1) {
            this.0 = 0;
            class_6 var10002 = this.c;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            this.0 = this.method_3617(((Number)var10002.method_3034()).doubleValue());
         } else {
            this.method_3615();
         }
      }

   }

   // $FF: renamed from: 1 () void
   public void method_3615() {
      try {
         Integer var1 = Integer.valueOf(this.0);
         if (Double.compare((double)var1, this.c) >= 0 && Double.compare((double)var1, this.0) <= 0) {
            class_6 var10000 = this.c;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.method_3033((double)var1);
            this.0 = (String)null;
         } else {
            this.0 = true;
         }
      } catch (NumberFormatException var2) {
         this.0 = true;
      }

      if (!this.0) {
         this.0 = -1;
      }

   }

   public f0R(@NotNull IntegerSetting var1) {
      super((f0w)var1);
      this.c = var1.c();
      this.c = (class_6)(new class_7((double)((Number)var1.c()).intValue(), (Consumer)(new f0P(this, var1))));
      this.c(new class_7((double)((Number)var1.c()).intValue(), (Consumer)(new f0Q(this))));
      this.c = (double)var1.method_3342();
      this.0 = (double)var1.method_3340();
      this.1 = (double)var1.method_3339();
   }
}
