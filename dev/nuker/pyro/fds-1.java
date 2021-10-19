/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fds extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_70;

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_105(@NotNull ItemStack var1) {
      Map var2 = (Map)this.field_70.method_1290();
      boolean var3 = false;
      boolean var10000;
      if (var2.isEmpty()) {
         var10000 = false;
      } else {
         boolean var5 = false;
         Iterator var6 = var2.entrySet().iterator();

         while(true) {
            if (!var6.hasNext()) {
               var10000 = false;
               break;
            }

            label75: {
               Entry var7 = (Entry)var6.next();
               boolean var9 = false;
               boolean var11 = false;
               fdr var12 = (fdr)var7.getKey();
               var11 = false;
               ItemStack var13 = (ItemStack)var7.getValue();
               if (this.field_70.method_1302(var13, var1)) {
                  fdF var14 = this.field_70;
                  IInventory var10001 = var12.method_1995();
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var14.method_1306(var10001, (Function1)fdt.field_69)) {
                     var10000 = true;
                     break label75;
                  }
               }

               var10000 = false;
            }

            if (var10000) {
               var10000 = true;
               break;
            }
         }
      }

      return var10000;
   }

   public Object invoke(Object var1) {
      return this.method_105((ItemStack)var1);
   }

   public fds(fdF var1) {
      this.field_70 = var1;
      super(1);
   }
}
