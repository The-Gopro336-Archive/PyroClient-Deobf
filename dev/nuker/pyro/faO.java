/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public class faO extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_755 = (BooleanSetting)this.register((f0w)(new BooleanSetting("csgo", "CSGO", (String)null, false)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_756 = (BooleanSetting)this.register((f0w)(new BooleanSetting("self", "Self", (String)null, false)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_757 = (BooleanSetting)this.register((f0w)(new BooleanSetting("Players", "Players", (String)null, true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_758 = (BooleanSetting)this.register((f0w)(new BooleanSetting("Monsters", "Monsters", (String)null, true)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_759 = (BooleanSetting)this.register((f0w)(new BooleanSetting("Animals", "Animals", (String)null, true)));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_760 = (BooleanSetting)this.register((f0w)(new BooleanSetting("vehicles", "Vehicles", (String)null, true)));
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_761 = (BooleanSetting)this.register((f0w)(new BooleanSetting("other", "Others", (String)null, true)));
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_762 = (BooleanSetting)this.register((f0w)(new BooleanSetting("xqz", "XQZ", "Through Walls", false)));

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1116() {
      return this.field_760;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1117() {
      return this.field_758;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1118() {
      return this.field_759;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1119() {
      return this.field_756;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1120() {
      return this.field_755;
   }

   public faO() {
      super("chams", "Chams", "See entities through walls", true);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_1121(@NotNull Entity var1) {
      if (Intrinsics.areEqual((Object)var1, (Object)this.c.player)) {
         return (Boolean)this.field_756.c();
      } else if (fdN.method_1862(var1)) {
         return (Boolean)this.field_758.c();
      } else if (var1 instanceof EntityPlayer) {
         return (Boolean)this.field_757.c();
      } else if (var1 instanceof EntityAnimal) {
         return (Boolean)this.field_759.c();
      } else if (var1 instanceof EntityMinecart) {
         return (Boolean)this.field_760.c();
      } else {
         return var1 instanceof EntityBoat ? (Boolean)this.field_760.c() : (Boolean)this.field_761.c();
      }
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1122() {
      return this.field_757;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1123() {
      return this.field_761;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4D) void
   @f0g
   @LauncherEventHide
   public void method_1124(@NotNull f4D var1) {
      if (PyroStatic.field_2498.method_986() && (Boolean)this.field_755.c() && this.method_1121((Entity)var1.0())) {
         var1.0();
         boolean var2 = GL11.glIsEnabled(2896);
         boolean var3 = GL11.glIsEnabled(3042);
         GL11.glPushAttrib(1048575);
         GL11.glDisable(3008);
         if (var2) {
            GL11.glDisable(2896);
         }

         if (!var3) {
            GL11.glEnable(3042);
         }

         GL11.glBlendFunc(770, 771);
         float var4;
         if ((Boolean)this.field_762.c()) {
            var4 = 0.0F;
            byte var5 = 0;
            float var6 = 1.0F;
            GL11.glColor4f(var6, var4, (float)var5, var6);
            GL11.glDepthMask(false);
            GL11.glDisable(2929);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
            var1.1().render((Entity)var1.0(), var1.method_3174(), var1.method_3171(), var1.method_3175(), var1.method_3172(), var1.method_3177(), var1.method_3168());
         }

         GL11.glDisable(3042);
         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         GL11.glEnable(2896);
         GL11.glEnable(3008);
         GL11.glPopAttrib();
         GL11.glPushAttrib(1048575);
         GL11.glDisable(3008);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         var4 = 1.0F;
         float var7 = 0.0F;
         GL11.glColor4f(var7, var4, var7, 1.0F);
         OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
         var1.1().render((Entity)var1.0(), var1.method_3174(), var1.method_3171(), var1.method_3175(), var1.method_3172(), var1.method_3177(), var1.method_3168());
         if (!var3) {
            GL11.glDisable(3042);
         }

         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         if (var2) {
            GL11.glEnable(2896);
         }

         GL11.glEnable(3008);
         GL11.glPopAttrib();
      }

   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1125() {
      return this.field_762;
   }
}
