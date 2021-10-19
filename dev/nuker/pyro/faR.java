/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class faR extends Lambda implements Function0 {
   // $FF: renamed from: c int
   public int field_57;
   // $FF: renamed from: c net.minecraft.client.renderer.BufferBuilder
   public BufferBuilder field_58;
   // $FF: renamed from: c net.minecraft.client.gui.ScaledResolution
   public ScaledResolution field_59;
   // $FF: renamed from: c net.minecraft.client.renderer.Tessellator
   public Tessellator field_60;

   public Object invoke() {
      this.method_96();
      return Unit.INSTANCE;
   }

   public faR(int var1, BufferBuilder var2, ScaledResolution var3, Tessellator var4) {
      this.field_57 = var1;
      this.field_58 = var2;
      this.field_59 = var3;
      this.field_60 = var4;
      super(0);
   }

   // $FF: renamed from: c () void
   public void method_96() {
      int var1 = 0;

      for(int var2 = this.field_57; var1 < var2; ++var1) {
         this.field_58.begin(7, DefaultVertexFormats.POSITION_TEX);
         this.field_58.pos(0.0D, (double)this.field_59.getScaledHeight(), -90.0D).tex(0.0D, 1.0D).endVertex();
         this.field_58.pos((double)this.field_59.getScaledWidth(), (double)this.field_59.getScaledHeight(), -90.0D).tex(1.0D, 1.0D).endVertex();
         this.field_58.pos((double)this.field_59.getScaledWidth(), 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
         this.field_58.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
         this.field_60.draw();
      }

   }
}
