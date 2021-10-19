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

public class f9y implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9A
   public f9A field_2246;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_2247;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$BooleanRef
   public Ref.BooleanRef field_2248;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_2249;
   // $FF: renamed from: 0 kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_2250;
   // $FF: renamed from: 1 kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_2251;

   public f9y(f9A var1, Ref.ObjectRef var2, Ref.BooleanRef var3, Ref.FloatRef var4, Ref.FloatRef var5, Ref.FloatRef var6) {
      this.field_2246 = var1;
      this.field_2247 = var2;
      this.field_2248 = var3;
      this.field_2249 = var4;
      this.field_2250 = var5;
      this.field_2251 = var6;
      super();
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3364(EntityPlayerSP var1) {
      NetHandlerPlayClient var10000 = f9A.method_487(this.field_2246).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock((BlockPos)this.field_2246.method_503(), (EnumFacing)this.field_2247.element, this.field_2248.element ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.field_2249.element, this.field_2250.element, this.field_2251.element)));
      var10000 = f9A.method_487(this.field_2246).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketAnimation(this.field_2248.element ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND)));
      this.field_2246.method_504(true);
      Pyro.INSTANCE.sendMessage("Placed crystal, waiting for spawn");
   }

   public void accept(Object var1) {
      this.method_3364((EntityPlayerSP)var1);
   }
}
