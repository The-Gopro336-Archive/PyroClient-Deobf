/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.Minecraft;

public class faf extends Lambda implements Function0 {
   // $FF: renamed from: c dev.nuker.pyro.fai
   public fai field_50;
   // $FF: renamed from: c dev.nuker.pyro.f4p
   public f4p field_51;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$DoubleRef
   public Ref.DoubleRef field_52;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$FloatRef
   public Ref.FloatRef field_53;
   // $FF: renamed from: c double
   public double field_54;

   public Object invoke() {
      this.method_93();
      return Unit.INSTANCE;
   }

   // $FF: renamed from: c () void
   public void method_93() {
      this.field_51.method_3125(this.field_52.element * Math.cos(Math.toRadians((double)this.field_53.element + (double)90.0F)) + this.field_54 * this.field_52.element * Math.sin(Math.toRadians((double)this.field_53.element + (double)90.0F)));
      this.field_51.method_3127(this.field_52.element * Math.sin(Math.toRadians((double)this.field_53.element + (double)90.0F)) - this.field_54 * this.field_52.element * Math.cos(Math.toRadians((double)this.field_53.element + (double)90.0F)));
      fai var1 = this.field_50;
      boolean var2 = false;
      Minecraft.getMinecraft().player.motionX = this.field_51.method_3128();
      var1 = this.field_50;
      var2 = false;
      Minecraft.getMinecraft().player.motionY = this.field_51.method_3119();
      var1 = this.field_50;
      var2 = false;
      Minecraft.getMinecraft().player.motionZ = this.field_51.method_3123();
      this.field_51.0();
   }

   public faf(fai var1, f4p var2, Ref.DoubleRef var3, Ref.FloatRef var4, double var5) {
      this.field_50 = var1;
      this.field_51 = var2;
      this.field_52 = var3;
      this.field_53 = var4;
      this.field_54 = var5;
      super(0);
   }
}
