/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltManager;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import org.lwjgl.input.Mouse;

// $FF: renamed from: dev.nuker.pyro.fq
public class class_44 {
   // $FF: renamed from: c net.minecraft.world.World
   public World field_2645;
   // $FF: renamed from: c dev.nuker.pyro.fd
   public class_33 field_2646;
   // $FF: renamed from: c net.minecraft.client.entity.EntityPlayerSP
   public EntityPlayerSP field_2647;
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_2648 = Minecraft.getMinecraft();

   // $FF: renamed from: c (dev.nuker.pyro.fp, com.mojang.authlib.GameProfile) void
   public void method_4002(class_47 var1, GameProfile var2) {
      var1.field_2671 = new EntityOtherPlayerMP(this.field_2645, var2);
   }

   // $FF: renamed from: c () void
   public void method_4003() {
      try {
         boolean var1 = this.field_2645 == null;
         WorldSettings var2 = new WorldSettings(0L, GameType.NOT_SET, true, false, WorldType.DEFAULT);
         this.field_2646 = new class_33(this.field_2648);
         if (var1) {
            this.field_2645 = new class_56(var2, this.field_2646);
         }

         this.field_2646.method_3957(this.field_2648.getSession().getProfile());
         this.field_2647 = new EntityPlayerSP(this.field_2648, this.field_2645, this.field_2646, (StatisticsManager)null, (RecipeBook)null);
         int var3 = 0;

         EnumPlayerModelParts var5;
         for(Iterator var4 = this.field_2648.gameSettings.getModelParts().iterator(); var4.hasNext(); var3 |= var5.getPartMask()) {
            var5 = (EnumPlayerModelParts)var4.next();
         }

         this.field_2647.setPrimaryHand(this.field_2648.gameSettings.mainHand);
         this.field_2647.dimension = 0;
         this.field_2647.movementInput = new MovementInputFromOptions(this.field_2648.gameSettings);
         this.field_2647.eyeHeight = 1.82F;
         class_35.method_3970(this.field_2648, this.field_2645);
         this.field_2648.getRenderManager().cacheActiveRenderInfo(this.field_2645, this.field_2648.fontRenderer, this.field_2647, this.field_2647, this.field_2648.gameSettings, 0.0F);
      } catch (Throwable var6) {
         var6.printStackTrace();
         this.field_2647 = null;
         this.field_2645 = null;
      }

   }

   // $FF: renamed from: 0 (com.mojang.authlib.GameProfile) dev.nuker.pyro.fp
   public class_47 method_4004(GameProfile var1) {
      if (this.field_2646 == null) {
         this.method_4003();
      }

      this.field_2646.method_3957(var1);
      class_47 var2 = new class_47();
      EntityOtherPlayerMP var3 = new EntityOtherPlayerMP(this.field_2645, AltManager.INSTANCE.fillProfileAsync(var1, fq::c));
      if (var2.field_2671 == null) {
         var2.field_2671 = var3;
      }

      return var2;
   }

   // $FF: renamed from: c (dev.nuker.pyro.alt.Alt) dev.nuker.pyro.fp
   public class_47 method_4005(Alt var1) {
      GameProfile var2 = var1.getGameProfile();
      if (this.field_2646 != null) {
         this.field_2646.method_3957(var2);
      }

      class_47 var3 = new class_47();
      EntityOtherPlayerMP var4 = new EntityOtherPlayerMP(this.field_2645, AltManager.INSTANCE.getAltProfile(var1, this::c));
      if (var3.field_2671 == null) {
         var3.field_2671 = var4;
      }

      return var3;
   }

   // $FF: renamed from: c (int, int, int, net.minecraft.entity.player.EntityPlayer) void
   public void method_4006(int var1, int var2, int var3, EntityPlayer var4) {
      try {
         if (this.field_2647 == null || this.field_2647.world == null) {
            this.method_4003();
         }

         if (this.field_2648.getRenderManager().world == null || this.field_2648.getRenderManager().renderViewEntity == null) {
            this.field_2648.getRenderManager().cacheActiveRenderInfo(this.field_2645, this.field_2648.fontRenderer, this.field_2647, var4, this.field_2648.gameSettings, 0.0F);
         }

         if (this.field_2645 != null && this.field_2647 != null && var4 != null) {
            this.field_2648.player = this.field_2647;
            ScaledResolution var5 = new ScaledResolution(this.field_2648);
            int var6 = Mouse.getX() * var5.getScaledWidth() / this.field_2648.displayWidth;
            int var7 = var5.getScaledHeight() - Mouse.getY() * var5.getScaledHeight() / this.field_2648.displayHeight - 1;
            class_35.method_3971(var1, var2, (float)var3, (float)(var1 - var6), (float)var2 - var4.height * (float)var3 * (var4.getEyeHeight() / var4.height) - (float)var7, var4);
         }
      } catch (Throwable var8) {
         var8.printStackTrace();
         this.field_2647 = null;
         this.field_2645 = null;
      }

      this.field_2648.player = null;
      this.field_2648.world = null;
   }

   // $FF: renamed from: c (com.mojang.authlib.GameProfile) void
   public static void method_4007(GameProfile var0) {
   }

   public class_44() {
      this.method_4003();
   }
}
