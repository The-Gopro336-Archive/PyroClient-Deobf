/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fbd extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_653 = (BooleanSetting)this.register((f0w)(new BooleanSetting("customFont", "Custom Font", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_654 = (BooleanSetting)this.register((f0w)(new BooleanSetting("hudBackground", "HUD Background", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   public f0l field_655;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   public f0l field_656;
   // $FF: renamed from: 1 dev.nuker.pyro.f0l
   public f0l field_657;
   // $FF: renamed from: 2 dev.nuker.pyro.f0l
   public f0l field_658;
   // $FF: renamed from: 3 dev.nuker.pyro.f0l
   public f0l field_659;
   // $FF: renamed from: 4 dev.nuker.pyro.f0l
   public f0l field_660;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_661;

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_970() {
      return this.field_654;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_971() {
      return this.field_653;
   }

   public fbd() {
      super("clickgui", "ClickGUI", (String)null);
      this.field_655 = (f0l)this.register((f0w)(new f0l("primary_color", "Primary Color", (String)null, ClickGui.Companion.getSettings().method_3487())));
      this.field_656 = (f0l)this.register((f0w)(new f0l("accent_color", "Accent Color", (String)null, ClickGui.Companion.getSettings().method_3496())));
      this.field_657 = (f0l)this.register((f0w)(new f0l("active_color", "Active Color", (String)null, ClickGui.Companion.getSettings().method_3504())));
      this.field_658 = (f0l)this.register((f0w)(new f0l("inactive_color", "Inctive Color", (String)null, ClickGui.Companion.getSettings().method_3500())));
      this.field_659 = (f0l)this.register((f0w)(new f0l("background_color", "Background Color", (String)null, ClickGui.Companion.getSettings().method_3497())));
      this.field_660 = (f0l)this.register((f0w)(new f0l("background_color_hovered", "Hov. Background Color", (String)null, ClickGui.Companion.getSettings().method_3501())));
      this.field_661 = (DoubleSetting)this.register((f0w)(new DoubleSetting("scale", "Scale", (String)null, 1.0D, 0.1D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_655.c((Consumer)fb5.field_1487);
      this.field_656.c((Consumer)fb6.field_1489);
      this.field_657.c((Consumer)fb7.field_1493);
      this.field_658.c((Consumer)fb8.field_1496);
      this.field_659.c((Consumer)fb9.field_1482);
      this.field_660.c((Consumer)fba.field_1634);
      this.field_661.c((Consumer)fbb.field_1635);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      if (var1) {
         this.c.method_3033(false);
      }

   }
}
