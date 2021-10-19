/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketCloseWindowAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f8E extends Module {
   // $FF: renamed from: 1 int
   public int field_397 = -1;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_398 = new BooleanSetting("forceCancel", "ForceCancel", (String)null, false);

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_600(f49 var1) {
      if (var1.c() == f41.field_2120 && this.c.player != null && var1.c() instanceof CPacketCloseWindow) {
         CPacketCloseWindowAccessor var2 = (CPacketCloseWindowAccessor)var1.c();
         if (var2.getWindowId() == this.c.player.inventoryContainer.windowId || (Boolean)this.field_398.c()) {
            var1.0();
         }
      }

   }

   public f8E() {
      super("xcarry", "XCarry", "Allows you to use your crafting slots as extra inventory slots.");
      this.register(this.field_398);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (!var1 && this.c.getConnection() != null && this.field_397 != -1) {
         this.c.getConnection().sendPacket(new CPacketCloseWindow(this.field_397));
      }

   }
}
