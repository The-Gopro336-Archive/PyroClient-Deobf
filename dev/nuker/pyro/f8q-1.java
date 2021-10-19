/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import java.util.List;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketSoundEffect;

public class f8q extends Module {
   // $FF: renamed from: c java.util.List
   public List field_279;

   public f8q() {
      super("nosoundlag", "NoSoundLag", (String)null);
      this.field_279 = Arrays.asList(SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, SoundEvents.ITEM_ARMOR_EQUIP_IRON, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_408(f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketSoundEffect) {
         SPacketSoundEffect var2 = (SPacketSoundEffect)var1.c();
         if (this.field_279.contains(var2.getSound())) {
            var1.0();
         }
      }

   }
}
