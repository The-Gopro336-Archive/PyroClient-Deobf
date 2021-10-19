/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class f63 {
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public static Minecraft field_2205;
   // $FF: renamed from: c dev.nuker.pyro.f63
   public static f63 field_2206;

   static {
      f63 var0 = new f63();
      field_2206 = var0;
      field_2205 = Minecraft.getMinecraft();
   }

   // $FF: renamed from: c () void
   public void method_3286() {
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4s) void
   @f0g
   @LauncherEventHide
   public void method_3287(@NotNull f4s var1) {
      if ((Boolean)PyroStatic.field_2472.method_920().c() && !(Boolean)PyroStatic.field_2472.c.method_3034() && field_2205.player.onGround && PyroStatic.field_2472.method_904((Entity)field_2205.player)) {
         PyroStatic.field_2472.c.method_3033(true);
      }

   }
}
