/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class faJ extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_800 = new BooleanSetting("render", "Render", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_801 = new DoubleSetting("delay", "Delay", (String)null, 0.0D, 0.0D, 10.0D);
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_802 = new DoubleSetting("width", "Width", (String)null, 1.600000023841858D, 0.10000000149011612D, 10.0D);
   // $FF: renamed from: c dev.nuker.pyro.f0l
   public f0l field_803 = new f0l("color", "Color", (String)null, new f00(0.0F, 1.0F, 0.5F, 1.0F));
   // $FF: renamed from: c java.util.LinkedList
   public LinkedList field_804 = new LinkedList();
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_805 = new fe8();

   public faJ() {
      super("breadcrumbs", "BreadCrumbs", "Draws a path from the places you have gone through");
      this.register(this.field_800);
      this.register(this.field_801);
      this.register(this.field_802);
      this.register(this.field_803);
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      if ((Boolean)this.field_800.c()) {
         synchronized(this.field_804) {
            GL11.glPushMatrix();
            GL11.glDisable(3553);
            GL11.glBlendFunc(770, 771);
            double var4 = (Double)this.field_802.c();
            GL11.glLineWidth((float)var4);
            GL11.glEnable(2848);
            GL11.glEnable(3042);
            GL11.glDisable(2929);
            this.c.entityRenderer.disableLightmap();
            GL11.glBegin(3);
            fe2.method_1844(((f00)this.field_803.c()).meth8());
            double var6 = this.c.getRenderManager().viewerPosX;
            double var8 = this.c.getRenderManager().viewerPosY;
            double var10 = this.c.getRenderManager().viewerPosZ;
            Iterator var12 = this.field_804.iterator();

            while(var12.hasNext()) {
               double[] var13 = (double[])var12.next();
               GL11.glVertex3d(var13[0] - var6, var13[1] - var8, var13[2] - var10);
            }

            GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
            GL11.glEnd();
            GL11.glEnable(2929);
            GL11.glDisable(2848);
            GL11.glDisable(3042);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
         }
      }
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1) {
         if (this.c.player == null) {
            return;
         }

         synchronized(this.field_804) {
            this.field_804.add(new double[]{this.c.player.posX, this.c.player.getEntityBoundingBox().minY + (double)(this.c.player.getEyeHeight() * 0.5F), this.c.player.posZ});
            this.field_804.add(new double[]{this.c.player.posX, this.c.player.getEntityBoundingBox().minY, this.c.player.posZ});
         }
      } else {
         synchronized(this.field_804) {
            this.field_804.clear();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1181(f4t var1) {
      if (this.field_805.method_1980((Double)this.field_801.c() * 1000.0D)) {
         this.field_805.method_1979();
         synchronized(this.field_804) {
            this.field_804.add(new double[]{this.c.player.posX, this.c.player.getEntityBoundingBox().minY, this.c.player.posZ});
         }
      }
   }
}
