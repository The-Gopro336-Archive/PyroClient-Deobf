/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class faY implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fbc
   public fbc field_1483;
   // $FF: renamed from: c java.util.List
   public List field_1484;

   // $FF: renamed from: c (net.minecraft.entity.Entity) void
   public void method_2657(@NotNull Entity var1) {
      ICamera var10000 = PyroRenderUtil.field_983;
      Entity var10001 = fbc.method_996(this.field_1483).getRenderViewEntity();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      double var2 = var10001.posX;
      Entity var10002 = fbc.method_996(this.field_1483).getRenderViewEntity();
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      double var3 = var10002.posY;
      Entity var10003 = fbc.method_996(this.field_1483).getRenderViewEntity();
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      var10000.setPosition(var2, var3, var10003.posZ);
      if (PyroRenderUtil.field_983.isBoundingBoxInFrustum(var1.getEntityBoundingBox())) {
         this.field_1484.add(var1);
      }

   }

   public void accept(Object var1) {
      this.method_2657((Entity)var1);
   }

   public faY(fbc var1, List var2) {
      this.field_1483 = var1;
      this.field_1484 = var2;
      super();
   }
}
