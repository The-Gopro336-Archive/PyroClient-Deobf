/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.mixin.TimerAccessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0b {
   // $FF: renamed from: c java.util.Map
   public Map field_2411;
   // $FF: renamed from: 0 java.util.Map
   public Map field_2412;
   // $FF: renamed from: c boolean
   public boolean field_2413;
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_2414;
   // $FF: renamed from: c dev.nuker.pyro.f0b
   @JvmField
   @NotNull
   public static f0b field_2415 = new f0b(Minecraft.getMinecraft());
   // $FF: renamed from: c dev.nuker.pyro.f05
   public static f05 field_2416 = new f05((DefaultConstructorMarker)null);

   // $FF: renamed from: c (java.lang.String) void
   public void method_3664(@NotNull String var1) {
      this.field_2412.remove(var1);
   }

   // $FF: renamed from: c (java.lang.String, dev.nuker.pyro.f08) void
   public void method_3665(@NotNull String var1, @NotNull f08 var2) {
      this.field_2411.put(var1, var2);
   }

   public f0b(@NotNull Minecraft var1) {
      this.field_2414 = var1;
      this.field_2411 = (Map)(new HashMap());
      this.field_2412 = (Map)(new HashMap());
   }

   // $FF: renamed from: c (java.lang.String, float, java.lang.Runnable) void
   public void method_3666(@NotNull String var1, float var2, @NotNull Runnable var3) {
      this.field_2412.put(var1, new f09(var3, var2, var2));
   }

   // $FF: renamed from: c (java.lang.String, dev.nuker.pyro.f07, float) void
   public void method_3667(@NotNull String var1, @NotNull f07 var2, float var3) {
      this.method_3665(var1, new f08(var2, var3));
   }

   // $FF: renamed from: 0 (java.lang.String) dev.nuker.pyro.f06
   @Nullable
   public f06 method_3668(@NotNull String var1) {
      return (f06)this.field_2412.get(var1);
   }

   // $FF: renamed from: 1 (java.lang.String) void
   public void method_3669(@NotNull String var1) {
      this.field_2411.remove(var1);
   }

   // $FF: renamed from: 0 () void
   public void method_3670() {
      Minecraft var10000 = this.field_2414;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
      } else {
         Timer var6 = ((MinecraftAccessor)var10000).getTimer();
         if (var6 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.TimerAccessor");
         } else {
            TimerAccessor var1 = (TimerAccessor)var6;
            float var2 = 50.0F;
            if (this.field_2411.isEmpty()) {
               if (this.field_2413) {
                  var1.setTickLength(var2);
                  this.field_2413 = false;
               }
            } else {
               Optional var3 = this.field_2411.values().stream().filter((Predicate)f0a.field_2409).findFirst();
               f08 var4;
               if (var3.isPresent()) {
                  var2 = ((f08)var3.get()).method_3468();
               } else {
                  for(Iterator var5 = this.field_2411.values().iterator(); var5.hasNext(); var2 *= (float)1 / var4.method_3468()) {
                     var4 = (f08)var5.next();
                  }
               }

               var1.setTickLength(var2);
               this.field_2413 = true;
            }

         }
      }
   }

   // $FF: renamed from: c () void
   public void method_3671() {
      Iterator var2 = this.field_2412.values().iterator();

      while(var2.hasNext()) {
         f06 var1 = (f06)var2.next();
         var1.method_3472().updateTimer();
         int var3 = 0;

         for(int var4 = var1.method_3472().elapsedTicks; var3 < var4; ++var3) {
            var1.method_3471();
         }
      }

   }
}
