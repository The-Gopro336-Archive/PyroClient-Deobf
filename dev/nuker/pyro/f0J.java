/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0I;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0J {
    public static f0J Field5485;

    public void Method7772(int n, int n2, int n3, int n4, int n5, int n6) {
        double d = 0.0;
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos((double)(n + 0), (double)(n2 + n6), d).tex((double)((float)(n3 + 0) * 0.00390625f), (double)((float)(n4 + n6) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n + n5), (double)(n2 + n6), d).tex((double)((float)(n3 + n5) * 0.00390625f), (double)((float)(n4 + n6) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n + n5), (double)(n2 + 0), d).tex((double)((float)(n3 + n5) * 0.00390625f), (double)((float)(n4 + 0) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n + 0), (double)(n2 + 0), d).tex((double)((float)(n3 + 0) * 0.00390625f), (double)((float)(n4 + 0) * 0.00390625f)).endVertex();
        tessellator.draw();
    }

    public void Method7773(@NotNull FontRenderer fontRenderer, @Nullable String string, int n, int n2, int n3) {
        fontRenderer.drawString(string, n, n2, n3);
    }

    @JvmOverloads
    public void Method7774(@NotNull FontRenderer fontRenderer, @Nullable String string, int n, int n2, int n3, int n4, @NotNull f0G f0G2, int n5, int n6, boolean bl) {
        int n7 = n;
        int n8 = n2;
        int n9 = n3;
        int n10 = n4;
        int n11 = fontRenderer.getStringWidth(string);
        int n12 = fontRenderer.FONT_HEIGHT;
        n7 += n5;
        n8 += n5;
        n9 -= n5;
        n8 += (n10 -= n5) / 2 - n12 / 2 - 1;
        switch (f0I.Field5484[f0G2.ordinal()]) {
            case 1: {
                n7 += n9 - n11;
                break;
            }
            case 2: {
                n7 += n9 / 2 - n11 / 2;
            }
        }
        if (bl) {
            this.Method7777(fontRenderer, string, n7, n8, n6);
        } else {
            this.Method7773(fontRenderer, string, n7, n8, n6);
        }
    }

    public static void Method7775(f0J f0J2, FontRenderer fontRenderer, String string, int n, int n2, int n3, int n4, f0G f0G2, int n5, int n6, boolean bl, int n7, Object object) {
        if ((n7 & 0x200) != 0) {
            bl = false;
        }
        f0J2.Method7774(fontRenderer, string, n, n2, n3, n4, f0G2, n5, n6, bl);
    }

    public int Method7776(@NotNull FontRenderer fontRenderer, @Nullable String string) {
        int n;
        if (string == null) {
            n = 0;
        } else {
            int n2 = 0;
            boolean bl = false;
            for (int i = 0; i < string.length(); ++i) {
                char c = string.charAt(i);
                int n3 = fontRenderer.getCharWidth(c);
                if (n3 < 0 && i < string.length() - 1) {
                    if ((c = string.charAt(++i)) != 'l' && c != 'L') {
                        if (c == 'r' || c == 'R') {
                            bl = false;
                        }
                    } else {
                        bl = true;
                    }
                    n3 = 0;
                }
                n2 += n3;
                if (!bl || n3 <= 0) continue;
                ++n2;
            }
            n = n2;
        }
        return n;
    }

    public void Method7777(@NotNull FontRenderer fontRenderer, @Nullable String string, int n, int n2, int n3) {
        fontRenderer.drawStringWithShadow(string, (float)n, (float)n2, n3);
    }

    static {
        f0J f0J2;
        Field5485 = f0J2 = new f0J();
    }

    @JvmStatic
    public static void Method7778(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        Gui.drawRect((int)n, (int)n2, (int)(n + n3), (int)(n2 + n4), (int)n5);
        Gui.drawRect((int)n, (int)n2, (int)(n + n7), (int)(n2 + n4), (int)n6);
        Gui.drawRect((int)(n + n3 - n7), (int)n2, (int)(n + n3), (int)(n2 + n4), (int)n6);
        Gui.drawRect((int)n, (int)n2, (int)(n + n3), (int)(n2 + n7), (int)n6);
        Gui.drawRect((int)n, (int)(n2 + n4 - n7), (int)(n + n3), (int)(n2 + n4), (int)n6);
    }

    @JvmOverloads
    public void Method7779(@NotNull FontRenderer fontRenderer, @Nullable String string, int n, int n2, int n3, int n4, @NotNull f0G f0G2, int n5, int n6) {
        f0J.Method7775(this, fontRenderer, string, n, n2, n3, n4, f0G2, n5, n6, false, 512, null);
    }
}

