/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import kotlin.ranges.RangesKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class faN extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_763;
   // $FF: renamed from: c float
   public float field_764;

   // $FF: renamed from: 0 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1126() {
      return this.field_763;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1 && (faM)this.field_763.c() == faM.field_1478) {
         this.field_764 = this.c.gameSettings.gammaSetting;
      } else {
         this.c.gameSettings.gammaSetting = this.field_764;
      }

      if ((faM)this.field_763.c() == faM.field_1479) {
         if (var1) {
            this.c.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION));
         } else {
            this.c.player.removePotionEffect(MobEffects.NIGHT_VISION);
         }
      }

      if (!var1) {
         this.c.gameSettings.gammaSetting = RangesKt.coerceAtMost(1.0F, this.c.gameSettings.gammaSetting);
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1127(@NotNull f4t var1) {
      if ((faM)this.field_763.c() == faM.field_1478) {
         this.c.player.removePotionEffect(MobEffects.NIGHT_VISION);
         if (this.c.gameSettings.gammaSetting <= 100.0F) {
            ++this.c.gameSettings.gammaSetting;
         }
      }

      if ((faM)this.field_763.c() == faM.field_1479) {
         this.c.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 300));
      }

   }

   public faN() {
      super("brightness", "Brightness", "Allows you to see even the darkest spots");
      this.field_763 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)faM.field_1478)));
      this.field_763.c((Consumer)(new faL(this)));
   }

   // $FF: renamed from: c (float) void
   public void method_1128(float var1) {
      this.field_764 = var1;
   }

   // $FF: renamed from: c () float
   public float method_1129() {
      return this.field_764;
   }
}
