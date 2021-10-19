/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f7g implements Runnable {
   // $FF: renamed from: c java.lang.Thread
   public Thread field_1838;
   // $FF: renamed from: c dev.nuker.pyro.f7i
   @NotNull
   public f7i field_1839;

   public void run() {
      long var1 = System.currentTimeMillis();
      if (f7i.method_645(this.field_1839).player != null && (f7f)f7i.method_638(this.field_1839).c() == f7f.field_1833) {
         f7i var10000 = this.field_1839;
         double var3 = f7i.method_645(this.field_1839).player.posX;
         f7i var13 = var10000;
         boolean var5 = false;
         double var14 = Math.floor(var3);
         var13.method_637((int)var14);
         var10000 = this.field_1839;
         var3 = f7i.method_645(this.field_1839).player.posZ;
         var13 = var10000;
         var5 = false;
         var14 = Math.floor(var3);
         var13.method_639((int)var14);
         int var16 = 0;

         for(int var4 = var16; var4 <= (int)((Number)this.field_1839.method_643().c()).doubleValue(); var4 = var16) {
            var5 = false;
            int var22 = (int)((Number)this.field_1839.method_642().c()).doubleValue();
            int var6 = (int)((Number)this.field_1839.method_643().c()).doubleValue();
            int var21 = var22;
            boolean var7 = false;
            boolean var8 = false;
            boolean var10 = false;
            int var17 = var6;

            for(var4 = var21 + var6; var4 >= (int)((Number)this.field_1839.method_642().c()).doubleValue(); var4 = var17) {
               Ref.IntRef var18 = new Ref.IntRef();
               var8 = false;
               boolean var9 = false;
               boolean var11 = false;
               var18.element = var16;

               for(var4 = -var16; var4 < var16; var4 = var18.element) {
                  Ref.IntRef var19 = new Ref.IntRef();
                  var9 = false;
                  var10 = false;
                  boolean var12 = false;
                  var19.element = var16;

                  for(var4 = -var16; var4 < var16; var4 = var19.element) {
                     ArrayList var23 = this.field_1839.method_636();
                     int var10003 = this.field_1839.method_633() + var18.element;
                     int var10005 = this.field_1839.method_631();
                     int var20;
                     var19.element = (var20 = var19.element) + 1;
                     var23.add(new BlockPos(var10003, var17, var10005 + var20));
                  }

                  ++var18.element;
               }

               var17 += -1;
            }

            ++var16;
         }

         this.field_1839.method_641(this.field_1839.method_636().size() - 1);
      }

   }

   // $FF: renamed from: 0 () void
   public void method_3015() {
      if (this.field_1838 == null) {
         this.field_1838 = new Thread((Runnable)this);
         Thread var10000 = this.field_1838;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.setPriority(1);
         var10000 = this.field_1838;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.start();

         try {
            var10000 = this.field_1838;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.join(1000L);
            return;
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

   }

   public f7g(@NotNull f7i var1) {
      this.field_1839 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f7i
   @NotNull
   public f7i method_3016() {
      return this.field_1839;
   }
}
