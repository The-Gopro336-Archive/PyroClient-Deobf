/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.jetbrains.annotations.Nullable;

public class fb0 extends Module {
   // $FF: renamed from: c net.minecraft.client.gui.GuiPlayerTabOverlay
   public GuiPlayerTabOverlay field_754;

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1115(f4t var1) {
      if (this.field_754 == null) {
         this.field_754 = this.c.ingameGUI.getTabList();
         ObfuscationReflectionHelper.setPrivateValue(GuiIngame.class, this.c.ingameGUI, new f62(this.c, this.c.ingameGUI), new String[]{"field_175196_v"});
      }

   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (!var1 && this.c.ingameGUI != null && this.field_754 != null) {
         ObfuscationReflectionHelper.setPrivateValue(GuiIngame.class, this.c.ingameGUI, this.field_754, new String[]{"field_175196_v"});
      }

   }

   public fb0() {
      super("extratab", "ExtraTab", "Removes the vanilla tab limit of 100", false);
   }
}
