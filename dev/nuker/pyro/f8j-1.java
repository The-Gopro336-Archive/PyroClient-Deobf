/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f8j extends Module {
   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1) {
         class_9.field_2271.method_3400();
      } else {
         class_9.field_2271.method_3396();
      }

   }

   public f8j() {
      super("discordrpc", "DiscordRPC", "Pyro discord status", true);
   }
}
