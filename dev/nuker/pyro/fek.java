/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fej;
import dev.nuker.pyro.fel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class fek {
    public static boolean Field489;
    public static ArrayList<fek> Field490;
    public static int Field491;
    public static int Field492;
    public static int Field493;
    public Font Field494;
    public int Field495;
    public int Field496;
    public int Field497 = -1;
    public fej[] Field498 = null;
    public HashMap<String, fel> Field499 = new HashMap();
    public int Field500 = 0;
    public int Field501 = 0;
    public int Field502 = 0;

    public void Method812(Map.Entry entry) {
        GL11.glDeleteLists((int)((fel)entry.getValue()).Method748(), (int)1);
        ((fel)entry.getValue()).Method746(true);
        this.Field499.remove(entry.getKey());
    }

    public fek(Font font) {
        this(font, 0, 255);
    }

    public static void Method813() {
        if (Field491++ > 600) {
            Field490.forEach(fek::Method822);
            Field491 = 0;
        }
    }

    public Font Method814() {
        return this.Field494;
    }

    public int Method815(String string) {
        int n = 0;
        for (int n2 : string.toCharArray()) {
            fej fej2;
            int n3 = n2 < this.Field498.length ? n2 : 3;
            if (this.Field498.length <= n3 || (fej2 = this.Field498[n3]) == null) continue;
            n += fej.Method802(fej2) - 8;
        }
        return n / 2;
    }

    public static boolean Method816(long l, Map.Entry entry) {
        return l - ((fel)entry.getValue()).Method750() > 30000L;
    }

    public void Method817(fej fej2, float f, float f2) {
        float f3 = fej.Method802(fej2);
        float f4 = fej.Method805(fej2);
        float f5 = fej.Method803(fej2);
        float f6 = fej.Method804(fej2);
        float f7 = f5 / (float)this.Field501;
        float f8 = f6 / (float)this.Field502;
        float f9 = f3 / (float)this.Field501;
        float f64 = f4 / (float)this.Field502;
        GL11.glTexCoord2f((float)f7, (float)f8);
        GL11.glVertex2f((float)f, (float)f2);
        GL11.glTexCoord2f((float)f7, (float)(f8 + f64));
        GL11.glVertex2f((float)f, (float)(f2 + f4));
        GL11.glTexCoord2f((float)(f7 + f9), (float)(f8 + f64));
        GL11.glVertex2f((float)(f + f3), (float)(f2 + f4));
        GL11.glTexCoord2f((float)(f7 + f9), (float)f8);
        GL11.glVertex2f((float)(f + f3), (float)f2);
    }

    public fek(Font font, int n, int n2) {
        this.Field494 = font;
        this.Field495 = n;
        this.Field496 = n2;
        this.Field498 = new fej[n2];
        this.Method821(n, n2);
        Field490.add(this);
    }

    public int Method818() {
        return (this.Field497 - 8) / 2;
    }

    public void Method819(String string, double d, double d2, int n) {
        double d3 = 0.25;
        double d4 = 4.0;
        GlStateManager.pushMatrix();
        GlStateManager.scale((double)0.25, (double)0.25, (double)0.25);
        GL11.glTranslated((double)(d * 2.0), (double)(d2 * 2.0 - 2.0), (double)0.0);
        GlStateManager.bindTexture((int)this.Field500);
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        float f4 = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)f, (float)f2, (float)f3, (float)f4);
        double d5 = 0.0;
        fel fel2 = this.Field499.get(string);
        if (fel2 != null) {
            GL11.glCallList((int)fel2.Method748());
            fel2.Method747(System.currentTimeMillis());
            GlStateManager.popMatrix();
            return;
        }
        int n2 = -1;
        if (Field489) {
            n2 = GL11.glGenLists((int)1);
            GL11.glNewList((int)n2, (int)4865);
        }
        GL11.glBegin((int)7);
        for (char c : string.toCharArray()) {
            fej fej2;
            if (Character.getNumericValue(c) >= this.Field498.length) {
                GL11.glEnd();
                GlStateManager.scale((double)4.0, (double)4.0, (double)4.0);
                Minecraft.getMinecraft().fontRenderer.drawString(String.valueOf(c), (float)d5 * 0.25f + 1.0f, 2.0f, n, false);
                d5 += (double)Minecraft.getMinecraft().fontRenderer.getStringWidth(String.valueOf(c)) * 4.0;
                GlStateManager.scale((double)0.25, (double)0.25, (double)0.25);
                GlStateManager.bindTexture((int)this.Field500);
                GlStateManager.color((float)f, (float)f2, (float)f3, (float)f4);
                GL11.glBegin((int)7);
                continue;
            }
            if (this.Field498.length <= c || (fej2 = this.Field498[c]) == null) continue;
            this.Method817(fej2, (float)d5, 0.0f);
            d5 += (double)fej.Method802(fej2) - 8.0;
        }
        GL11.glEnd();
        if (Field489) {
            this.Field499.put(string, new fel(n2, System.currentTimeMillis()));
            GL11.glEndList();
        }
        GlStateManager.popMatrix();
    }

    public BufferedImage Method820(char c) {
        int n;
        Graphics2D graphics2D = (Graphics2D)new BufferedImage(1, 1, 2).getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setFont(this.Field494);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n2 = fontMetrics.charWidth(c) + 8;
        if (n2 <= 8) {
            n2 = 7;
        }
        if ((n = fontMetrics.getHeight() + 3) <= 0) {
            n = this.Field494.getSize();
        }
        BufferedImage bufferedImage = new BufferedImage(n2, n, 2);
        Graphics2D graphics2D2 = (Graphics2D)bufferedImage.getGraphics();
        graphics2D2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D2.setFont(this.Field494);
        graphics2D2.setColor(Color.WHITE);
        graphics2D2.drawString(String.valueOf(c), 3, 1 + fontMetrics.getAscent());
        return bufferedImage;
    }

    public void Method821(int n, int n2) {
        Object object;
        BufferedImage[] arrbufferedImage = new BufferedImage[n2];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (int i = n; i < n2; ++i) {
            object = this.Method820((char)i);
            fej fej2 = new fej(n4, n5, ((BufferedImage)object).getWidth(), ((BufferedImage)object).getHeight());
            if (fej.Method805(fej2) > this.Field497) {
                this.Field497 = fej.Method805(fej2);
            }
            if (fej.Method805(fej2) > n3) {
                n3 = fej.Method805(fej2);
            }
            if (this.Field498.length <= i) continue;
            this.Field498[i] = fej2;
            arrbufferedImage[i] = object;
            if ((n4 += fej.Method802(fej2)) <= 2048) continue;
            if (n4 > this.Field501) {
                this.Field501 = n4;
            }
            n4 = 0;
            n5 += n3;
            n3 = 0;
        }
        this.Field502 = n5 + n3;
        BufferedImage bufferedImage = new BufferedImage(this.Field501, this.Field502, 2);
        object = (Graphics2D)bufferedImage.getGraphics();
        ((Graphics)object).setFont(this.Field494);
        ((Graphics)object).setColor(new Color(255, 255, 255, 0));
        ((Graphics)object).fillRect(0, 0, this.Field501, this.Field502);
        ((Graphics)object).setColor(Color.WHITE);
        for (int i = n; i < n2; ++i) {
            if (arrbufferedImage[i] == null || this.Field498[i] == null) continue;
            ((Graphics)object).drawImage(arrbufferedImage[i], fej.Method803(this.Field498[i]), fej.Method804(this.Field498[i]), null);
        }
        this.Field500 = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)bufferedImage, (boolean)true, (boolean)true);
    }

    public void Method822() {
        long l = System.currentTimeMillis();
        this.Field499.entrySet().stream().filter(arg_0 -> fek.Method816(l, arg_0)).forEach(this::Method812);
    }

    static {
        Field493 = 30000;
        Field492 = 600;
        Field489 = false;
        Field490 = new ArrayList();
        Field491 = 0;
    }
}

