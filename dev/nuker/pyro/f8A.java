/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Set;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f8A extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_452 = (DoubleSetting)this.register(new DoubleSetting("delay", "Delay", (String)null, 0.1D, 0.0D, 20.0D));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_453 = (BooleanSetting)this.register(new BooleanSetting("random", "Random", (String)null, false));
   // $FF: renamed from: c java.util.Set
   public Set field_454;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_455 = new fe8();

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_671(f4t var1) {
      if (this.field_455.method_1980((Double)this.field_452.c() * 1000.0D)) {
         EnumPlayerModelParts[] var2;
         int var3 = (var2 = EnumPlayerModelParts.values()).length;
         int var4 = 0;

         for(int var5 = 0; var4 < var3; var4 = var5) {
            EnumPlayerModelParts var6 = var2[var5];
            this.c.gameSettings.setModelPartEnabled(var6, (Boolean)this.field_453.c() ? Math.random() < 0.5D : !this.c.gameSettings.getModelParts().contains(var6));
            ++var5;
         }

         this.field_455.method_1979();
      }

   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (this.c.gameSettings != null) {
         if (this.field_454 == null) {
            this.field_454 = this.c.gameSettings.getModelParts();
         }

         if (!var1 && this.c.player != null) {
            EnumPlayerModelParts[] var4;
            int var5 = (var4 = EnumPlayerModelParts.values()).length;
            int var6 = 0;

            for(int var7 = 0; var6 < var5; var6 = var7) {
               EnumPlayerModelParts var8 = var4[var7];
               GameSettings var9 = this.c.gameSettings;
               Set var10 = this.field_454;
               ++var7;
               var9.setModelPartEnabled(var8, var10.contains(var8));
            }
         }

      }
   }

   public f8A() {
      super("skinBlink", "SkinBlink", (String)null);
   }
}
