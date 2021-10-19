/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class f7C implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f7G
   public f7G field_1760;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_1761;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   public EnumFacing field_1762;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_1763;
   // $FF: renamed from: 0 kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_1764;
   // $FF: renamed from: 1 kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_1765;

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_2989(EntityPlayerSP var1) {
      NetHandlerPlayClient var10000 = f7G.method_803(this.field_1760).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock(this.field_1761, this.field_1762, EnumHand.MAIN_HAND, this.field_1763.element, this.field_1764.element, this.field_1765.element)));
      var10000 = f7G.method_803(this.field_1760).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
      Pyro.INSTANCE.sendMessage("Pressed button!");
      f7G var2 = this.field_1760;
      Vec3d var10001 = this.field_1760.method_759();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var2.method_836(var10001);
      PyroStatic.field_2509.c.method_3033(true);
   }

   public f7C(f7G var1, BlockPos var2, EnumFacing var3, Ref.FloatRef var4, Ref.FloatRef var5, Ref.FloatRef var6) {
      this.field_1760 = var1;
      this.field_1761 = var2;
      this.field_1762 = var3;
      this.field_1763 = var4;
      this.field_1764 = var5;
      this.field_1765 = var6;
      super();
   }

   public void accept(Object var1) {
      this.method_2989((EntityPlayerSP)var1);
   }
}
