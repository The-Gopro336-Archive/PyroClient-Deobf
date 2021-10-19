/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

public class f4G extends f42 {
   // $FF: renamed from: c net.minecraft.client.renderer.entity.RenderLivingBase
   @NotNull
   public RenderLivingBase field_2088;
   // $FF: renamed from: c net.minecraft.client.model.ModelBase
   @NotNull
   public ModelBase field_2089;
   // $FF: renamed from: c net.minecraft.entity.EntityLivingBase
   @NotNull
   public EntityLivingBase field_2090;

   // $FF: renamed from: 0 () net.minecraft.entity.EntityLivingBase
   @NotNull
   public EntityLivingBase method_3165() {
      return this.field_2090;
   }

   // $FF: renamed from: 1 () net.minecraft.client.model.ModelBase
   @NotNull
   public ModelBase method_3166() {
      return this.field_2089;
   }

   public f4G(@NotNull RenderLivingBase var1, @NotNull ModelBase var2, @NotNull EntityLivingBase var3) {
      this.field_2088 = var1;
      this.field_2089 = var2;
      this.field_2090 = var3;
   }

   // $FF: renamed from: c () net.minecraft.client.renderer.entity.RenderLivingBase
   @NotNull
   public RenderLivingBase method_3167() {
      return this.field_2088;
   }
}
