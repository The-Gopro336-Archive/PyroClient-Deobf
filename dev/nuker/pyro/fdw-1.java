/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;

public class fdw implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_1331;
   // $FF: renamed from: c float[]
   public float[] field_1332;

   public void accept(Object var1) {
      this.method_2006((EntityPlayerSP)var1);
   }

   public fdw(fdF var1, float[] var2) {
      this.field_1331 = var1;
      this.field_1332 = var2;
      super();
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_2006(EntityPlayerSP var1) {
      RayTraceResult var2 = few.method_1716().method_1734(this.field_1332[0], this.field_1332[1]);
      PlayerControllerMP var10000 = fdF.method_1303(this.field_1331).playerController;
      EntityPlayerSP var10001 = fdF.method_1303(this.field_1331).player;
      WorldClient var10002 = fdF.method_1303(this.field_1331).world;
      fdr var10003 = fdF.method_1292(this.field_1331);
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      var10000.processRightClickBlock(var10001, var10002, var10003.method_2004(), var2.sideHit, var2.hitVec, EnumHand.MAIN_HAND);
      fdF.method_1297(this.field_1331, true);
   }
}
