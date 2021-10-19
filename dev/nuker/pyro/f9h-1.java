/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9h extends Module {
   // $FF: renamed from: 1 java.util.Map
   @NotNull
   public Map field_200;
   // $FF: renamed from: c dev.nuker.pyro.f0z
   @NotNull
   public f0z field_201;
   // $FF: renamed from: c dev.nuker.pyro.faj
   @NotNull
   public faj field_202;

   // $FF: renamed from: 2 () java.util.Map
   @NotNull
   public Map method_284() {
      return this.field_200;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.faj
   @NotNull
   public faj method_285() {
      return this.field_202;
   }

   public f9h() {
      super("elytraflight", "ElytraFlight2", "Greater control over elytra based flight");
      this.field_200 = MapsKt.mapOf(new Pair[]{TuplesKt.method_2843(f9g.field_2231, new fai(this)), TuplesKt.method_2843(f9g.field_2232, new fam(this)), TuplesKt.method_2843(f9g.field_2233, new faa(this))});
      f0z var10002 = new f0z;
      Enum var10007 = (Enum)f9g.field_2231;
      List[] var10008 = new List[3];
      Object var10011 = this.field_200.get(f9g.field_2231);
      if (var10011 == null) {
         Intrinsics.throwNpe();
      }

      var10008[0] = ((faj)var10011).method_2673();
      var10011 = this.field_200.get(f9g.field_2232);
      if (var10011 == null) {
         Intrinsics.throwNpe();
      }

      var10008[1] = ((faj)var10011).method_2673();
      var10011 = this.field_200.get(f9g.field_2233);
      if (var10011 == null) {
         Intrinsics.throwNpe();
      }

      var10008[2] = ((faj)var10011).method_2673();
      var10002.<init>("mode", "Mode", (String)null, var10007, var10008);
      this.field_201 = (f0z)this.register((f0w)var10002);
      this.field_202 = this.method_290();
      this.field_201.method_3334().c((Consumer)(new f9f(this)));
   }

   // $FF: renamed from: 3 () void
   public void method_286() {
      faj var1 = this.method_290();
      if (Intrinsics.areEqual((Object)var1, (Object)this.field_202) ^ true && (Boolean)this.c.method_3034()) {
         this.field_202.method_2668(false);
         Pyro.getEventManager().method_33(this.field_202);
         this.field_202 = var1;
         this.field_202.method_2668(true);
         Pyro.getEventManager().method_31(this.field_202);
      }

      this.5(((f9g)this.field_201.method_3334().c()).toString());
   }

   // $FF: renamed from: c (dev.nuker.pyro.f9h) void
   public static void method_287(f9h var0) {
      var0.method_286();
   }

   // $FF: renamed from: c (dev.nuker.pyro.faj) void
   public void method_288(@NotNull faj var1) {
      this.field_202 = var1;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      this.field_202.method_2668(var1);
      if (var1) {
         Pyro.getEventManager().method_31(this.field_202);
      } else {
         Pyro.getEventManager().method_33(this.field_202);
      }

      this.5(((f9g)this.field_201.method_3334().c()).toString());
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0z
   @NotNull
   public f0z method_289() {
      return this.field_201;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.faj
   public faj method_290() {
      Object var10000 = this.field_200.get(this.field_201.method_3334().c());
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      return (faj)var10000;
   }
}
