/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f4j;
import dev.nuker.pyro.f8h;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import org.jetbrains.annotations.NotNull;

public class f8i
extends Module {
    @NotNull
    public f0o<f8h> Field3570 = (f0o)this.Method7264(new f0o("mode", "Mode", null, f8h.Smart));
    @NotNull
    public BooleanSetting Field3571 = (BooleanSetting)this.Method7264(new BooleanSetting("ignoreCommands", "IgnoreCommands", "Don't check server commands", false));
    @NotNull
    public BooleanSetting Field3572 = (BooleanSetting)this.Method7264(new BooleanSetting("msg", "/msg", "Don't check /msg", false));
    @NotNull
    public BooleanSetting Field3573 = (BooleanSetting)this.Method7264(new BooleanSetting("msgFriends", "/msg friends", "Don't check /msg to friends", false));

    @NotNull
    public BooleanSetting Method215() {
        return this.Field3573;
    }

    @NotNull
    public f0o Method241() {
        return this.Field3570;
    }

    public f8i() {
        super("coordchat", "CoordChat", "Checks for coordinates sent in chat, and asks for confirmation");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g(value=-10)
    @LauncherEventHide
    public void Method5362(@NotNull f4j var1_1) {
        block12: {
            block17: {
                block13: {
                    block15: {
                        block16: {
                            block14: {
                                var2_2 = var1_1.Method5798();
                                var3_3 = ((f8h)this.Field3570.Method7979()).Method5359();
                                var4_5 = false;
                                if (var3_3.Method12677(var2_2) == false) return;
                                if (((Boolean)this.Field3571.Method7979()).booleanValue()) {
                                    if (StringsKt.Method9998(var1_1.Method5798(), "/", false, 2, null) != false) return;
                                }
                                if (((Boolean)this.Field3572.Method7979()).booleanValue()) {
                                    var2_2 = var1_1.Method5798();
                                    var3_3 = new Regex("/(msg|w|whisper|tell).*");
                                    var4_5 = false;
                                    if (var3_3.Method12677(var2_2) != false) return;
                                }
                                if (!((Boolean)this.Field3573.Method7979()).booleanValue()) break block12;
                                var2_2 = var1_1.Method5798();
                                var3_3 = new Regex("/(msg|w|whisper|tell).*");
                                var4_5 = false;
                                if (!var3_3.Method12677(var2_2)) break block12;
                                var2_2 = var1_1.Method5798();
                                var3_4 = false;
                                var4_5 = false;
                                var5_6 = var2_2;
                                var6_7 = false;
                                var7_8 = var1_1.Method5798();
                                var8_9 = 1;
                                var9_11 = 0;
                                v0 = var7_8;
                                if (v0 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                var7_8 = StringsKt.Method11415(v0.substring(var8_9), " ", null, 2, null);
                                switch (var7_8.hashCode()) {
                                    case 108417: {
                                        if (!var7_8.equals("msg")) ** break;
                                        break;
                                    }
                                    case 119: {
                                        if (!var7_8.equals("w")) break block13;
                                        break block14;
                                    }
                                    case 3556273: {
                                        if (!var7_8.equals("tell")) ** break;
                                        break block15;
                                    }
                                    case 1316693890: {
                                        if (!var7_8.equals("whisper")) ** break;
                                        break block16;
                                    }
                                }
                                v1 = 3;
                                break block17;
                            }
                            v1 = 1;
                            break block17;
                        }
                        v1 = 7;
                        break block17;
                    }
                    v1 = 4;
                    break block17;
                }
                v1 = var10_12 = -1;
            }
            if (var10_12 != -1) {
                var8_10 = var1_1.Method5798();
                var9_11 = var10_12 + 2;
                var11_13 = false;
                v2 = var8_10;
                if (v2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var7_8 = StringsKt.Method11415(v2.substring(var9_11), " ", null, 2, null);
                v3 = FriendManager.Field2145.Method8958(var7_8);
            } else {
                v3 = false;
            }
            if (v3 != false) return;
        }
        Pyro.Field6182.Method8987(new TextComponentString("Message seems to have coords ").appendSibling(new TextComponentString("[SEND ANYWAY]").setStyle(new Style().setBold(Boolean.valueOf(true)).setColor(TextFormatting.DARK_RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Config.Field3937.Field3931 + "say " + var1_1.Method5798())))));
        var1_1.Method7948();
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field3572;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3571;
    }
}

