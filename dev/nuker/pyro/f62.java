/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Ordering
 *  com.mojang.authlib.GameProfile
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.GuiPlayerTabOverlay
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.entity.player.EnumPlayerModelParts
 *  net.minecraft.scoreboard.IScoreCriteria$EnumRenderType
 *  net.minecraft.scoreboard.ScoreObjective
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.world.GameType
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.common.collect.Ordering;
import com.mojang.authlib.GameProfile;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.f61;
import dev.nuker.pyro.mixin.GuiPlayerTabOverlayAccessor;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.Nullable;

public class f62
extends GuiPlayerTabOverlay {
    public Minecraft Field4203;
    public static Ordering<NetworkPlayerInfo> Field4204 = Ordering.from((Comparator)new f61(null));

    public void Method5840(ScoreObjective scoreObjective, int n, String string, int n2, int n3, NetworkPlayerInfo networkPlayerInfo) {
        int n4 = scoreObjective.getScoreboard().getOrCreateScore(string, scoreObjective).getScorePoints();
        if (scoreObjective.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS) {
            boolean bl;
            this.Field4203.getTextureManager().bindTexture(ICONS);
            long l = ((GuiPlayerTabOverlayAccessor)((Object)this)).Method12404();
            if (l == networkPlayerInfo.getRenderVisibilityId()) {
                if (n4 < networkPlayerInfo.getLastHealth()) {
                    networkPlayerInfo.setLastHealthTime(Minecraft.getSystemTime());
                    networkPlayerInfo.setHealthBlinkTime((long)(this.Field4203.ingameGUI.getUpdateCounter() + 20));
                } else if (n4 > networkPlayerInfo.getLastHealth()) {
                    networkPlayerInfo.setLastHealthTime(Minecraft.getSystemTime());
                    networkPlayerInfo.setHealthBlinkTime((long)(this.Field4203.ingameGUI.getUpdateCounter() + 10));
                }
            }
            if (Minecraft.getSystemTime() - networkPlayerInfo.getLastHealthTime() > 1000L || l != networkPlayerInfo.getRenderVisibilityId()) {
                networkPlayerInfo.setLastHealth(n4);
                networkPlayerInfo.setDisplayHealth(n4);
                networkPlayerInfo.setLastHealthTime(Minecraft.getSystemTime());
            }
            networkPlayerInfo.setRenderVisibilityId(l);
            networkPlayerInfo.setLastHealth(n4);
            int n5 = MathHelper.ceil((float)((float)Math.max(n4, networkPlayerInfo.getDisplayHealth()) / 2.0f));
            int n6 = Math.max(MathHelper.ceil((float)(n4 / 2)), Math.max(MathHelper.ceil((float)(networkPlayerInfo.getDisplayHealth() / 2)), 10));
            boolean bl2 = bl = networkPlayerInfo.getHealthBlinkTime() > (long)this.Field4203.ingameGUI.getUpdateCounter() && (networkPlayerInfo.getHealthBlinkTime() - (long)this.Field4203.ingameGUI.getUpdateCounter()) / 3L % 2L == 1L;
            if (n5 > 0) {
                float f = Math.min((float)(n3 - n2 - 4) / (float)n6, 9.0f);
                if (f > 3.0f) {
                    int n7;
                    for (n7 = n5; n7 < n6; ++n7) {
                        this.drawTexturedModalRect((float)n2 + (float)n7 * f, n, bl ? 25 : 16, 0, 9, 9);
                    }
                    for (n7 = 0; n7 < n5; ++n7) {
                        this.drawTexturedModalRect((float)n2 + (float)n7 * f, n, bl ? 25 : 16, 0, 9, 9);
                        if (bl) {
                            if (n7 * 2 + 1 < networkPlayerInfo.getDisplayHealth()) {
                                this.drawTexturedModalRect((float)n2 + (float)n7 * f, n, 70, 0, 9, 9);
                            }
                            if (n7 * 2 + 1 == networkPlayerInfo.getDisplayHealth()) {
                                this.drawTexturedModalRect((float)n2 + (float)n7 * f, n, 79, 0, 9, 9);
                            }
                        }
                        if (n7 * 2 + 1 < n4) {
                            this.drawTexturedModalRect((float)n2 + (float)n7 * f, n, n7 >= 10 ? 160 : 52, 0, 9, 9);
                        }
                        if (n7 * 2 + 1 != n4) continue;
                        this.drawTexturedModalRect((float)n2 + (float)n7 * f, n, n7 >= 10 ? 169 : 61, 0, 9, 9);
                    }
                } else {
                    float f2 = MathHelper.clamp((float)((float)n4 / 20.0f), (float)0.0f, (float)1.0f);
                    int n8 = (int)((1.0f - f2) * 255.0f) << 16 | (int)(f2 * 255.0f) << 8;
                    String string2 = "" + (float)n4 / 2.0f;
                    if (n3 - this.Field4203.fontRenderer.getStringWidth(string2 + "hp") >= n2) {
                        string2 = string2 + "hp";
                    }
                    this.Field4203.fontRenderer.drawStringWithShadow(string2, (float)((n3 + n2) / 2 - this.Field4203.fontRenderer.getStringWidth(string2) / 2), (float)n, n8);
                }
            }
        } else {
            String string3 = (Object)TextFormatting.YELLOW + "" + n4;
            this.Field4203.fontRenderer.drawStringWithShadow(string3, (float)(n3 - this.Field4203.fontRenderer.getStringWidth(string3)), (float)n, 0xFFFFFF);
        }
    }

    public void renderPlayerlist(int n, Scoreboard scoreboard, @Nullable ScoreObjective scoreObjective) {
        int n2;
        boolean bl;
        int n3;
        int n4;
        NetHandlerPlayClient netHandlerPlayClient = this.Field4203.player.connection;
        List list = Field4204.sortedCopy((Iterable)netHandlerPlayClient.getPlayerInfoMap());
        int n5 = 0;
        int n6 = 0;
        for (NetworkPlayerInfo networkPlayerInfo : list) {
            n4 = this.Field4203.fontRenderer.getStringWidth(this.getPlayerName(networkPlayerInfo));
            n5 = Math.max(n5, n4);
            if (scoreObjective == null) continue;
            if (scoreObjective.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS) continue;
            n4 = this.Field4203.fontRenderer.getStringWidth(" " + scoreboard.getOrCreateScore(networkPlayerInfo.getGameProfile().getName(), scoreObjective).getScorePoints());
            n6 = Math.max(n6, n4);
        }
        list = list.subList(0, Math.min(list.size(), 1000));
        int n7 = n3 = list.size();
        n4 = 1;
        while (n7 > 20) {
            n7 = (n3 + ++n4 - 1) / n4;
        }
        boolean bl2 = bl = this.Field4203.isIntegratedServerRunning() || this.Field4203.getConnection().getNetworkManager().isEncrypted();
        int n8 = scoreObjective != null ? (scoreObjective.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS ? 90 : n6) : 0;
        int n9 = Math.min(n4 * ((bl ? 9 : 0) + n5 + n8 + 13), n - 50) / n4;
        int n10 = n / 2 - (n9 * n4 + (n4 - 1) * 5) / 2;
        int n11 = 10;
        int n12 = n9 * n4 + (n4 - 1) * 5;
        List list2 = null;
        ITextComponent iTextComponent = ((GuiPlayerTabOverlayAccessor)((Object)this)).Method12403();
        ITextComponent iTextComponent2 = ((GuiPlayerTabOverlayAccessor)((Object)this)).Method12402();
        if (iTextComponent != null) {
            list2 = this.Field4203.fontRenderer.listFormattedStringToWidth(iTextComponent.getFormattedText(), n - 50);
            for (Iterator iterator2 : list2) {
                n12 = Math.max(n12, this.Field4203.fontRenderer.getStringWidth((String)((Object)iterator2)));
            }
        }
        Object object = null;
        if (iTextComponent2 != null) {
            Iterator iterator2;
            object = this.Field4203.fontRenderer.listFormattedStringToWidth(iTextComponent2.getFormattedText(), n - 50);
            iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                String string = (String)iterator2.next();
                n12 = Math.max(n12, this.Field4203.fontRenderer.getStringWidth(string));
            }
        }
        if (list2 != null) {
            f62.drawRect((int)(n / 2 - n12 / 2 - 1), (int)(n11 - 1), (int)(n / 2 + n12 / 2 + 1), (int)(n11 + list2.size() * this.Field4203.fontRenderer.FONT_HEIGHT), (int)Integer.MIN_VALUE);
            for (String string : list2) {
                n2 = this.Field4203.fontRenderer.getStringWidth(string);
                this.Field4203.fontRenderer.drawStringWithShadow(string, (float)(n / 2 - n2 / 2), (float)n11, -1);
                n11 += this.Field4203.fontRenderer.FONT_HEIGHT;
            }
            ++n11;
        }
        f62.drawRect((int)(n / 2 - n12 / 2 - 1), (int)(n11 - 1), (int)(n / 2 + n12 / 2 + 1), (int)(n11 + n7 * 9), (int)Integer.MIN_VALUE);
        for (int i = 0; i < n3; ++i) {
            int n13;
            int n14;
            String string;
            int n15 = i / n7;
            n2 = i % n7;
            int n16 = n10 + n15 * n9 + n15 * 5;
            int n17 = n11 + n2 * 9;
            f62.drawRect((int)n16, (int)n17, (int)(n16 + n9), (int)(n17 + 8), (int)0x20FFFFFF);
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            if (i >= list.size()) continue;
            NetworkPlayerInfo networkPlayerInfo = (NetworkPlayerInfo)list.get(i);
            GameProfile gameProfile = networkPlayerInfo.getGameProfile();
            if (bl) {
                string = this.Field4203.world.getPlayerEntityByUUID(gameProfile.getId());
                n14 = string != null && string.isWearing(EnumPlayerModelParts.CAPE) && ("Dinnerbone".equals(gameProfile.getName()) || "Grumm".equals(gameProfile.getName())) ? 1 : 0;
                this.Field4203.getTextureManager().bindTexture(networkPlayerInfo.getLocationSkin());
                n13 = 8 + (n14 != 0 ? 8 : 0);
                int n18 = 8 * (n14 != 0 ? -1 : 1);
                Gui.drawScaledCustomSizeModalRect((int)n16, (int)n17, (float)8.0f, (float)n13, (int)8, (int)n18, (int)8, (int)8, (float)64.0f, (float)64.0f);
                if (string != null && string.isWearing(EnumPlayerModelParts.HAT)) {
                    int n19 = 8 + (n14 != 0 ? 8 : 0);
                    int n20 = 8 * (n14 != 0 ? -1 : 1);
                    Gui.drawScaledCustomSizeModalRect((int)n16, (int)n17, (float)40.0f, (float)n19, (int)8, (int)n20, (int)8, (int)8, (float)64.0f, (float)64.0f);
                }
                n16 += 9;
            }
            string = this.getPlayerName(networkPlayerInfo);
            if (networkPlayerInfo.getGameType() == GameType.SPECTATOR) {
                this.Field4203.fontRenderer.drawStringWithShadow((Object)TextFormatting.ITALIC + string, (float)n16, (float)n17, -1862270977);
            } else {
                this.Field4203.fontRenderer.drawStringWithShadow(string, (float)n16, (float)n17, FriendManager.Field2145.Method8958(ChatFormatting.stripFormatting((String)string)) ? 1831126 : -1);
            }
            if (scoreObjective != null && networkPlayerInfo.getGameType() != GameType.SPECTATOR && (n13 = (n14 = n16 + n5 + 1) + n8) - n14 > 5) {
                this.Method5840(scoreObjective, n17, gameProfile.getName(), n14, n13, networkPlayerInfo);
            }
            this.drawPing(n9, n16 - (bl ? 9 : 0), n17, networkPlayerInfo);
        }
        if (object != null) {
            n11 = n11 + n7 * 9 + 1;
            f62.drawRect((int)(n / 2 - n12 / 2 - 1), (int)(n11 - 1), (int)(n / 2 + n12 / 2 + 1), (int)(n11 + object.size() * this.Field4203.fontRenderer.FONT_HEIGHT), (int)Integer.MIN_VALUE);
            Iterator iterator3 = object.iterator();
            while (iterator3.hasNext()) {
                String string = (String)iterator3.next();
                n2 = this.Field4203.fontRenderer.getStringWidth(string);
                this.Field4203.fontRenderer.drawStringWithShadow(string, (float)(n / 2 - n2 / 2), (float)n11, -1);
                n11 += this.Field4203.fontRenderer.FONT_HEIGHT;
            }
        }
    }

    public f62(Minecraft minecraft, GuiIngame guiIngame) {
        super(minecraft, guiIngame);
        this.Field4203 = minecraft;
    }
}

