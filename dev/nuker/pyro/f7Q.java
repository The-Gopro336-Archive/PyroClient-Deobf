/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketTabComplete;
import org.jetbrains.annotations.NotNull;

public class f7Q extends Module {
   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_719(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketTabComplete) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketTabComplete");
         }

         SPacketTabComplete var2 = (SPacketTabComplete)var10000;
         ArrayList var3 = new ArrayList();
         var1.0();
         Ref.ObjectRef var4 = new Ref.ObjectRef();
         String[] var6 = var2.getMatches();
         boolean var7 = false;
         boolean var8 = false;
         boolean var10 = false;
         var4.element = var6;
         int var5 = ((Object[])var6).length;
         int var18 = 0;

         boolean var11;
         boolean var13;
         Ref.ObjectRef var20;
         for(int var19 = 0; var18 < var5; var18 = var19) {
            var20 = new Ref.ObjectRef();
            Collection var9 = (Collection)StringsKt.split$default((CharSequence)((String[])var4.element)[var19], new String[]{":"}, false, 0, 6, (Object)null);
            var10 = false;
            Object[] var33 = var9.toArray(new String[0]);
            if (var33 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            Object[] var21 = var33;
            var10 = false;
            var11 = false;
            String[] var12 = (String[])var21;
            var13 = false;
            var20.element = var12;
            if (var21.length > 1) {
               String var22 = ((String[])var20.element)[0];
               byte var25 = 1;
               var11 = false;
               if (var22 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               String var17 = var22.substring(var25);
               if (!var3.contains(var17)) {
                  var22 = ((String[])var20.element)[0];
                  var25 = 1;
                  var11 = false;
                  if (var22 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var17 = var22.substring(var25);
                  var3.add(var17);
               }
            }

            ++var19;
         }

         var20 = new Ref.ObjectRef();
         StringBuilder var23 = new StringBuilder();
         var10 = false;
         var11 = false;
         var13 = false;
         var20.element = var23;
         var23.append(String.format("Found plugins (%s): ", var3.size()));
         Ref.ObjectRef var24 = new Ref.ObjectRef();
         Iterator var27 = var3.iterator();
         boolean var28 = false;
         var13 = false;
         boolean var15 = false;
         var24.element = var27;
         Iterator var26 = var27;

         while(((Iterator)var24.element).hasNext()) {
            String var30 = (String)var26.next();
            var24.element = var26;
            ((StringBuilder)var20.element).append(var30);
            ((StringBuilder)var20.element).append(", ");
         }

         StringBuilder var31 = new StringBuilder();
         byte var29 = 0;
         byte var32 = 0;
         StringBuilder var14 = (StringBuilder)var20.element;
         Pyro.INSTANCE.sendMessage(var31.insert(var29, var14.substring(var32, var14.length() - 2)).append(".").toString());
         this.c.method_3033(false);
      }

   }

   public f7Q() {
      super("plugins", "Plugins", (String)null, true);
   }
}
