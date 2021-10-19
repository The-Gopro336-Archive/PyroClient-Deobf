/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

// $FF: renamed from: dev.nuker.pyro.fG
public class class_30 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.Module
   public Module field_2290;

   // $FF: renamed from: c (boolean) void
   public void method_3426(boolean var1) {
      Pyro.getEventManager().method_32(new f44(this.field_2290, var1));
      this.field_2290.method_116(var1, Minecraft.getMinecraft().player, (World)Minecraft.getMinecraft().world);
      class_37.field_2633.method_3978(this.field_2290);
   }

   public void accept(Object var1) {
      this.method_3426((Boolean)var1);
   }

   public class_30(Module var1) {
      this.field_2290 = var1;
      super();
   }
}
