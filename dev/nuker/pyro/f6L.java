/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f6L extends Module {
   public f6L() {
      super("friends", "Friends", "Globally enables/disables friends", true);
      this.c = (class_6)(new class_7(true, (Consumer)(new f6K(this))));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6L) net.minecraft.client.Minecraft
   public static Minecraft method_896(f6L var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6L, net.minecraft.client.Minecraft) void
   public static void method_897(f6L var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      if (var1) {
         FriendManager.Companion.loadFriends();
      }

      FriendManager.Companion.getINSTANCE().setEnabled(var1);
      FriendManager.Companion.saveFriends();
   }
}
