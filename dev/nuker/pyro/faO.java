/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4D;
import dev.nuker.pyro.fdN;
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

public class faO
extends Module {
    @NotNull
    public BooleanSetting Field1725 = (BooleanSetting)this.Method7264(new BooleanSetting("csgo", "CSGO", null, false));
    @NotNull
    public BooleanSetting Field1726 = (BooleanSetting)this.Method7264(new BooleanSetting("self", "Self", null, false));
    @NotNull
    public BooleanSetting Field1727 = (BooleanSetting)this.Method7264(new BooleanSetting("Players", "Players", null, true));
    @NotNull
    public BooleanSetting Field1728 = (BooleanSetting)this.Method7264(new BooleanSetting("Monsters", "Monsters", null, true));
    @NotNull
    public BooleanSetting Field1729 = (BooleanSetting)this.Method7264(new BooleanSetting("Animals", "Animals", null, true));
    @NotNull
    public BooleanSetting Field1730 = (BooleanSetting)this.Method7264(new BooleanSetting("vehicles", "Vehicles", null, true));
    @NotNull
    public BooleanSetting Field1731 = (BooleanSetting)this.Method7264(new BooleanSetting("other", "Others", null, true));
    @NotNull
    public BooleanSetting Field1732 = (BooleanSetting)this.Method7264(new BooleanSetting("xqz", "XQZ", "Through Walls", false));

    @NotNull
    public BooleanSetting Method274() {
        return this.Field1730;
    }

    @NotNull
    public BooleanSetting Method2424() {
        return this.Field1728;
    }

    @NotNull
    public BooleanSetting Method284() {
        return this.Field1729;
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field1726;
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field1725;
    }

    public faO() {
        super("chams", "Chams", "See entities through walls", true);
    }

    public boolean Method2425(@NotNull Entity entity) {
        if (Intrinsics.Method6572((Object)entity, (Object)this.Field5233.player)) {
            return (Boolean)this.Field1726.Method7979();
        }
        if (fdN.Method351(entity)) {
            return (Boolean)this.Field1728.Method7979();
        }
        Entity entity2 = entity;
        if (entity2 instanceof EntityPlayer) {
            return (Boolean)this.Field1727.Method7979();
        }
        if (entity2 instanceof EntityAnimal) {
            return (Boolean)this.Field1729.Method7979();
        }
        if (entity2 instanceof EntityMinecart) {
            return (Boolean)this.Field1730.Method7979();
        }
        if (entity2 instanceof EntityBoat) {
            return (Boolean)this.Field1730.Method7979();
        }
        return (Boolean)this.Field1731.Method7979();
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field1727;
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field1731;
    }

    @f0g
    @LauncherEventHide
    public void Method2426(@NotNull f4D f4D2) {
        if (PyroStatic.Field6434.Method2715()) {
            if (((Boolean)this.Field1725.Method7979()).booleanValue() && this.Method2425((Entity)f4D2.Method5696())) {
                float f;
                f4D2.Method7948();
                boolean bl = GL11.glIsEnabled((int)2896);
                boolean bl2 = GL11.glIsEnabled((int)3042);
                GL11.glPushAttrib((int)1048575);
                GL11.glDisable((int)3008);
                if (bl) {
                    GL11.glDisable((int)2896);
                }
                if (!bl2) {
                    GL11.glEnable((int)3042);
                }
                GL11.glBlendFunc((int)770, (int)771);
                if (((Boolean)this.Field1732.Method7979()).booleanValue()) {
                    f = 0.0f;
                    boolean bl3 = false;
                    float f2 = 1.0f;
                    GL11.glColor4f((float)f2, (float)f, (float)((float)bl3), (float)f2);
                    GL11.glDepthMask((boolean)false);
                    GL11.glDisable((int)2929);
                    OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
                    f4D2.Method5697().render((Entity)f4D2.Method5696(), f4D2.Method5648(), f4D2.Method5645(), f4D2.Method5649(), f4D2.Method5646(), f4D2.Method5651(), f4D2.Method5642());
                }
                GL11.glDisable((int)3042);
                GL11.glEnable((int)2929);
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)3008);
                GL11.glPopAttrib();
                GL11.glPushAttrib((int)1048575);
                GL11.glDisable((int)3008);
                GL11.glDisable((int)2896);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                f = 1.0f;
                float f3 = 0.0f;
                GL11.glColor4f((float)f3, (float)f, (float)f3, (float)1.0f);
                OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
                f4D2.Method5697().render((Entity)f4D2.Method5696(), f4D2.Method5648(), f4D2.Method5645(), f4D2.Method5649(), f4D2.Method5646(), f4D2.Method5651(), f4D2.Method5642());
                if (!bl2) {
                    GL11.glDisable((int)3042);
                }
                GL11.glEnable((int)2929);
                GL11.glDepthMask((boolean)true);
                if (bl) {
                    GL11.glEnable((int)2896);
                }
                GL11.glEnable((int)3008);
                GL11.glPopAttrib();
            }
        }
    }

    @NotNull
    public BooleanSetting Method276() {
        return this.Field1732;
    }
}

