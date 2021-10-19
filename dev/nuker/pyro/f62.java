/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.collect.Ordering;
import com.mojang.authlib.GameProfile;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.mixin.GuiPlayerTabOverlayAccessor;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.IScoreCriteria.EnumRenderType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.Nullable;

public class f62 extends GuiPlayerTabOverlay {
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_2203;
   // $FF: renamed from: c com.google.common.collect.Ordering
   public static Ordering field_2204 = Ordering.from(new f61((f60)null));

   // $FF: renamed from: c (net.minecraft.scoreboard.ScoreObjective, int, java.lang.String, int, int, net.minecraft.client.network.NetworkPlayerInfo) void
   public void method_3285(ScoreObjective var1, int var2, String var3, int var4, int var5, NetworkPlayerInfo var6) {
      int var7 = var1.getScoreboard().getOrCreateScore(var3, var1).getScorePoints();
      if (var1.getRenderType() == EnumRenderType.HEARTS) {
         this.field_2203.getTextureManager().bindTexture(ICONS);
         long var8 = ((GuiPlayerTabOverlayAccessor)((GuiPlayerTabOverlayAccessor)this)).getLastTimeOpened();
         if (var8 == var6.getRenderVisibilityId()) {
            if (var7 < var6.getLastHealth()) {
               var6.setLastHealthTime(Minecraft.getSystemTime());
               var6.setHealthBlinkTime((long)(this.field_2203.ingameGUI.getUpdateCounter() + 20));
            } else if (var7 > var6.getLastHealth()) {
               var6.setLastHealthTime(Minecraft.getSystemTime());
               var6.setHealthBlinkTime((long)(this.field_2203.ingameGUI.getUpdateCounter() + 10));
            }
         }

         if (Minecraft.getSystemTime() - var6.getLastHealthTime() > 1000L || var8 != var6.getRenderVisibilityId()) {
            var6.setLastHealth(var7);
            var6.setDisplayHealth(var7);
            var6.setLastHealthTime(Minecraft.getSystemTime());
         }

         var6.setRenderVisibilityId(var8);
         var6.setLastHealth(var7);
         int var10 = MathHelper.ceil((float)Math.max(var7, var6.getDisplayHealth()) / 2.0F);
         int var11 = Math.max(MathHelper.ceil((float)(var7 / 2)), Math.max(MathHelper.ceil((float)(var6.getDisplayHealth() / 2)), 10));
         boolean var12 = var6.getHealthBlinkTime() > (long)this.field_2203.ingameGUI.getUpdateCounter() && (var6.getHealthBlinkTime() - (long)this.field_2203.ingameGUI.getUpdateCounter()) / 3L % 2L == 1L;
         if (var10 > 0) {
            float var13 = Math.min((float)(var5 - var4 - 4) / (float)var11, 9.0F);
            if (var13 > 3.0F) {
               int var14;
               for(var14 = var10; var14 < var11; ++var14) {
                  this.drawTexturedModalRect((float)var4 + (float)var14 * var13, (float)var2, var12 ? 25 : 16, 0, 9, 9);
               }

               for(var14 = 0; var14 < var10; ++var14) {
                  this.drawTexturedModalRect((float)var4 + (float)var14 * var13, (float)var2, var12 ? 25 : 16, 0, 9, 9);
                  if (var12) {
                     if (var14 * 2 + 1 < var6.getDisplayHealth()) {
                        this.drawTexturedModalRect((float)var4 + (float)var14 * var13, (float)var2, 70, 0, 9, 9);
                     }

                     if (var14 * 2 + 1 == var6.getDisplayHealth()) {
                        this.drawTexturedModalRect((float)var4 + (float)var14 * var13, (float)var2, 79, 0, 9, 9);
                     }
                  }

                  if (var14 * 2 + 1 < var7) {
                     this.drawTexturedModalRect((float)var4 + (float)var14 * var13, (float)var2, var14 >= 10 ? 160 : 52, 0, 9, 9);
                  }

                  if (var14 * 2 + 1 == var7) {
                     this.drawTexturedModalRect((float)var4 + (float)var14 * var13, (float)var2, var14 >= 10 ? 169 : 61, 0, 9, 9);
                  }
               }
            } else {
               float var18 = MathHelper.clamp((float)var7 / 20.0F, 0.0F, 1.0F);
               int var15 = (int)((1.0F - var18) * 255.0F) << 16 | (int)(var18 * 255.0F) << 8;
               String var16 = "" + (float)var7 / 2.0F;
               if (var5 - this.field_2203.fontRenderer.getStringWidth(var16 + "hp") >= var4) {
                  var16 = var16 + "hp";
               }

               this.field_2203.fontRenderer.drawStringWithShadow(var16, (float)((var5 + var4) / 2 - this.field_2203.fontRenderer.getStringWidth(var16) / 2), (float)var2, var15);
            }
         }
      } else {
         String var17 = TextFormatting.YELLOW + "" + var7;
         this.field_2203.fontRenderer.drawStringWithShadow(var17, (float)(var5 - this.field_2203.fontRenderer.getStringWidth(var17)), (float)var2, 16777215);
      }

   }

   public void renderPlayerlist(int var1, Scoreboard var2, @Nullable ScoreObjective var3) {
      NetHandlerPlayClient var4 = this.field_2203.player.connection;
      List var5 = field_2204.sortedCopy(var4.getPlayerInfoMap());
      int var6 = 0;
      int var7 = 0;
      Iterator var8 = var5.iterator();

      int var10;
      while(var8.hasNext()) {
         NetworkPlayerInfo var9 = (NetworkPlayerInfo)var8.next();
         var10 = this.field_2203.fontRenderer.getStringWidth(this.getPlayerName(var9));
         var6 = Math.max(var6, var10);
         if (var3 != null && var3.getRenderType() != EnumRenderType.HEARTS) {
            var10 = this.field_2203.fontRenderer.getStringWidth(" " + var2.getOrCreateScore(var9.getGameProfile().getName(), var3).getScorePoints());
            var7 = Math.max(var7, var10);
         }
      }

      var5 = var5.subList(0, Math.min(var5.size(), 1000));
      int var34 = var5.size();
      int var35 = var34;

      for(var10 = 1; var35 > 20; var35 = (var34 + var10 - 1) / var10) {
         ++var10;
      }

      boolean var11 = this.field_2203.isIntegratedServerRunning() || this.field_2203.getConnection().getNetworkManager().isEncrypted();
      int var12;
      if (var3 != null) {
         if (var3.getRenderType() == EnumRenderType.HEARTS) {
            var12 = 90;
         } else {
            var12 = var7;
         }
      } else {
         var12 = 0;
      }

      int var13 = Math.min(var10 * ((var11 ? 9 : 0) + var6 + var12 + 13), var1 - 50) / var10;
      int var14 = var1 / 2 - (var13 * var10 + (var10 - 1) * 5) / 2;
      int var15 = 10;
      int var16 = var13 * var10 + (var10 - 1) * 5;
      List var17 = null;
      ITextComponent var18 = ((GuiPlayerTabOverlayAccessor)((GuiPlayerTabOverlayAccessor)this)).getHeader();
      ITextComponent var19 = ((GuiPlayerTabOverlayAccessor)((GuiPlayerTabOverlayAccessor)this)).getFooter();
      if (var18 != null) {
         var17 = this.field_2203.fontRenderer.listFormattedStringToWidth(var18.getFormattedText(), var1 - 50);

         String var21;
         for(Iterator var20 = var17.iterator(); var20.hasNext(); var16 = Math.max(var16, this.field_2203.fontRenderer.getStringWidth(var21))) {
            var21 = (String)var20.next();
         }
      }

      List var36 = null;
      String var22;
      Iterator var37;
      if (var19 != null) {
         var36 = this.field_2203.fontRenderer.listFormattedStringToWidth(var19.getFormattedText(), var1 - 50);

         for(var37 = var36.iterator(); var37.hasNext(); var16 = Math.max(var16, this.field_2203.fontRenderer.getStringWidth(var22))) {
            var22 = (String)var37.next();
         }
      }

      int var23;
      if (var17 != null) {
         drawRect(var1 / 2 - var16 / 2 - 1, var15 - 1, var1 / 2 + var16 / 2 + 1, var15 + var17.size() * this.field_2203.fontRenderer.FONT_HEIGHT, Integer.MIN_VALUE);

         for(var37 = var17.iterator(); var37.hasNext(); var15 += this.field_2203.fontRenderer.FONT_HEIGHT) {
            var22 = (String)var37.next();
            var23 = this.field_2203.fontRenderer.getStringWidth(var22);
            this.field_2203.fontRenderer.drawStringWithShadow(var22, (float)(var1 / 2 - var23 / 2), (float)var15, -1);
         }

         ++var15;
      }

      drawRect(var1 / 2 - var16 / 2 - 1, var15 - 1, var1 / 2 + var16 / 2 + 1, var15 + var35 * 9, Integer.MIN_VALUE);

      for(int var38 = 0; var38 < var34; ++var38) {
         int var39 = var38 / var35;
         var23 = var38 % var35;
         int var24 = var14 + var39 * var13 + var39 * 5;
         int var25 = var15 + var23 * 9;
         drawRect(var24, var25, var24 + var13, var25 + 8, 553648127);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableAlpha();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
         if (var38 < var5.size()) {
            NetworkPlayerInfo var26 = (NetworkPlayerInfo)var5.get(var38);
            GameProfile var27 = var26.getGameProfile();
            int var30;
            if (var11) {
               EntityPlayer var28 = this.field_2203.world.getPlayerEntityByUUID(var27.getId());
               boolean var29 = var28 != null && var28.isWearing(EnumPlayerModelParts.CAPE) && ("Dinnerbone".equals(var27.getName()) || "Grumm".equals(var27.getName()));
               this.field_2203.getTextureManager().bindTexture(var26.getLocationSkin());
               var30 = 8 + (var29 ? 8 : 0);
               int var31 = 8 * (var29 ? -1 : 1);
               Gui.drawScaledCustomSizeModalRect(var24, var25, 8.0F, (float)var30, 8, var31, 8, 8, 64.0F, 64.0F);
               if (var28 != null && var28.isWearing(EnumPlayerModelParts.HAT)) {
                  int var32 = 8 + (var29 ? 8 : 0);
                  int var33 = 8 * (var29 ? -1 : 1);
                  Gui.drawScaledCustomSizeModalRect(var24, var25, 40.0F, (float)var32, 8, var33, 8, 8, 64.0F, 64.0F);
               }

               var24 += 9;
            }

            String var40 = this.getPlayerName(var26);
            if (var26.getGameType() == GameType.SPECTATOR) {
               this.field_2203.fontRenderer.drawStringWithShadow(TextFormatting.ITALIC + var40, (float)var24, (float)var25, -1862270977);
            } else {
               this.field_2203.fontRenderer.drawStringWithShadow(var40, (float)var24, (float)var25, FriendManager.Companion.isFriend(ChatFormatting.stripFormatting(var40)) ? 1831126 : -1);
            }

            if (var3 != null && var26.getGameType() != GameType.SPECTATOR) {
               int var41 = var24 + var6 + 1;
               var30 = var41 + var12;
               if (var30 - var41 > 5) {
                  this.method_3285(var3, var25, var27.getName(), var41, var30, var26);
               }
            }

            this.drawPing(var13, var24 - (var11 ? 9 : 0), var25, var26);
         }
      }

      if (var36 != null) {
         var15 = var15 + var35 * 9 + 1;
         drawRect(var1 / 2 - var16 / 2 - 1, var15 - 1, var1 / 2 + var16 / 2 + 1, var15 + var36.size() * this.field_2203.fontRenderer.FONT_HEIGHT, Integer.MIN_VALUE);

         for(var37 = var36.iterator(); var37.hasNext(); var15 += this.field_2203.fontRenderer.FONT_HEIGHT) {
            var22 = (String)var37.next();
            var23 = this.field_2203.fontRenderer.getStringWidth(var22);
            this.field_2203.fontRenderer.drawStringWithShadow(var22, (float)(var1 / 2 - var23 / 2), (float)var15, -1);
         }
      }

   }

   public f62(Minecraft var1, GuiIngame var2) {
      super(var1, var2);
      this.field_2203 = var1;
   }
}
