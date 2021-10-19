/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.mixin.TimerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5S extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1061 = "";
   // $FF: renamed from: c double
   public double field_1062;
   // $FF: renamed from: c java.util.ArrayDeque
   @NotNull
   public ArrayDeque field_1063 = new ArrayDeque(20);

   // $FF: renamed from: c (java.util.ArrayDeque) void
   public void method_1571(@NotNull ArrayDeque var1) {
      this.field_1063 = var1;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   // $FF: renamed from: c () double
   public double method_1572() {
      return this.field_1062;
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1061;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1573(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.player != null) {
         if (this.field_1063.size() > 20) {
            this.field_1063.poll();
         }

         float var10000 = (float)50;
         Minecraft var10001 = fdZ.field_976;
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
         }

         Timer var20 = ((MinecraftAccessor)var10001).getTimer();
         if (var20 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.TimerAccessor");
         }

         float var2 = var10000 / ((TimerAccessor)var20).getTickLength();
         double var3 = fec.method_1759((Entity)fdZ.field_976.player) * (double)var2;
         this.field_1063.add(var3);
         double var14 = 0.0D;
         Iterable var5 = (Iterable)this.field_1063;
         boolean var6 = false;

         Double var9;
         for(Iterator var7 = var5.iterator(); var7.hasNext(); var14 += var9) {
            Object var8 = var7.next();
            var9 = (Double)var8;
            boolean var10 = false;
         }

         this.field_1062 = var14 / (double)this.field_1063.size();
         StringBuilder var21 = (new StringBuilder("Speed ")).append(ChatFormatting.WHITE);
         StringCompanionObject var16 = StringCompanionObject.INSTANCE;
         String var17 = "%.2f km/h";
         Object[] var18 = new Object[]{this.field_1062};
         StringBuilder var12 = var21;
         boolean var19 = false;
         String var13 = String.format(var17, Arrays.copyOf(var18, var18.length));
         this.field_1061 = var12.append(var13).toString();
      }

   }

   public f5S() {
      super("speed");
   }

   // $FF: renamed from: c (double) void
   public void method_1574(double var1) {
      this.field_1062 = var1;
   }

   // $FF: renamed from: 0 () java.util.ArrayDeque
   @NotNull
   public ArrayDeque method_1575() {
      return this.field_1063;
   }
}
