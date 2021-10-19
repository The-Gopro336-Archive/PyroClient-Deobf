/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.util.math.BlockPos;

public class fa0 extends Lambda implements Function0 {
   // $FF: renamed from: c dev.nuker.pyro.fa1
   public fa1 field_62;

   // $FF: renamed from: c () void
   public void method_98() {
      Pyro var10000 = Pyro.INSTANCE;
      fa6 var10001 = this.field_62.method_1194();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendMessage(var10001.method_2637().name());
      fa1 var16 = this.field_62;
      var10001 = this.field_62.method_1194();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      LinkedList var17 = var10001.method_2638();
      if (var17 == null) {
         Intrinsics.throwNpe();
      }

      Iterable var1 = (Iterable)var17;
      fa1 var10 = var16;
      boolean var2 = false;
      Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var1, 10)));
      boolean var5 = false;
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         fa3 var8 = (fa3)var7;
         boolean var9 = false;
         BlockPos var14 = var8.method_2609();
         var4.add(var14);
      }

      List var13 = (List)var4;
      Collection var15 = (Collection)var13;
      var10.method_1210(new LinkedList(var15));
   }

   public fa0(fa1 var1) {
      this.field_62 = var1;
      super(0);
   }

   public Object invoke() {
      this.method_98();
      return Unit.INSTANCE;
   }
}
