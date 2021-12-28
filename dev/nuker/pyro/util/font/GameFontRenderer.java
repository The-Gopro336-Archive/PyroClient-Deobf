/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL20
 */
package dev.nuker.pyro.util.font;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.api.FontManager$CustomFontConfig;
import dev.nuker.pyro.fek;
import dev.nuker.pyro.util.font.GameFontRenderer$ColorUtils;
import java.awt.Color;
import java.awt.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL20;

public class GameFontRenderer
extends FontRenderer {
    private Font Field4005;
    private FontManager$CustomFontConfig Field4006;
    private fek Field4007;
    private fek Field4008;
    private fek Field4009;
    private fek Field4010;

    public GameFontRenderer(Font font, FontManager$CustomFontConfig config) {
        super(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().getTextureManager(), false);
        this.Field4005 = font;
        this.Field4006 = config;
        this.Field4007 = new fek(font);
        this.Field4008 = new fek(font.deriveFont(1));
        this.Field4009 = new fek(font.deriveFont(2));
        this.Field4010 = new fek(font.deriveFont(3));
        this.FONT_HEIGHT = this.Method5667();
    }

    public int Method5667() {
        return this.Field4007.Method818() / 2 + this.Field4006.Field1897.Field7350 + this.Field4006.Field1897.Field7352;
    }

    public int Method5668() {
        return this.Field4007.Method814().getSize();
    }

    public void Method5669(String s, float x, float y, int color) {
        this.drawString(s, x, y, color, false);
    }

    public int drawStringWithShadow(String text, float x, float y, int color) {
        return this.drawString(text, x, y, color, true);
    }

    public void Method5670(String s, float x, float y, int color, boolean shadow) {
        this.drawString(s, x - (float)this.getStringWidth(s) / 2.0f, y, color, shadow);
    }

    public void Method5671(String s, float x, float y, int color) {
        this.Method5669(s, x - (float)this.getStringWidth(s) / 2.0f, y, color);
    }

    public int drawString(String text, float x, float y, int color, boolean dropShadow) {
        x += (float)this.Field4006.Field1897.Field7349;
        float currY = (y += (float)this.Field4006.Field1897.Field7350) - 3.0f;
        if (text.contains("\n")) {
            String[] parts = text.split("\n");
            float newY = 0.0f;
            for (String s : parts) {
                this.Method5672(s, x, currY + newY, color, dropShadow);
                newY += (float)this.Method5667();
            }
            return 0;
        }
        if (dropShadow) {
            GL20.glUseProgram((int)0);
            this.Method5672(text, x + 0.5f, currY + 0.5f, new Color(0, 0, 0, 150).getRGB(), true);
        }
        return this.Method5672(text, x, currY, color, false);
    }

    private int Method5672(String text, float x, float y, int color, boolean ignoreColor) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return (int)x;
        }
        GlStateManager.translate((double)((double)x - 1.5), (double)((double)y + 0.5), (double)0.0);
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.enableTexture2D();
        int currentColor = color;
        if ((currentColor & 0xFC000000) == 0) {
            currentColor |= 0xFF000000;
        }
        int alpha = currentColor >> 24 & 0xFF;
        if (text.contains("\u00a7")) {
            String[] parts = text.split("\u00a7");
            fek currentFont = this.Field4007;
            double width = 0.0;
            boolean randomCase = false;
            boolean bold = false;
            boolean italic = false;
            boolean strikeThrough = false;
            boolean underline = false;
            for (int index = 0; index < parts.length; ++index) {
                String part = parts[index];
                if (part.isEmpty()) continue;
                if (index == 0) {
                    currentFont.Method819(part, width, 0.0, currentColor);
                    width += (double)currentFont.Method815(part);
                    continue;
                }
                String words = part.substring(1);
                char type = part.charAt(0);
                int colorIndex = "0123456789abcdefklmnor".indexOf(type);
                switch (colorIndex) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: {
                        if (!ignoreColor) {
                            currentColor = GameFontRenderer$ColorUtils.Field5764[colorIndex] | alpha << 24;
                        }
                        bold = false;
                        italic = false;
                        randomCase = false;
                        underline = false;
                        strikeThrough = false;
                        break;
                    }
                    case 16: {
                        randomCase = true;
                        break;
                    }
                    case 17: {
                        bold = true;
                        break;
                    }
                    case 18: {
                        strikeThrough = true;
                        break;
                    }
                    case 19: {
                        underline = true;
                        break;
                    }
                    case 20: {
                        italic = true;
                        break;
                    }
                    case 21: {
                        currentColor = color;
                        if ((currentColor & 0xFC000000) == 0) {
                            currentColor |= 0xFF000000;
                        }
                        bold = false;
                        italic = false;
                        randomCase = false;
                        underline = false;
                        strikeThrough = false;
                    }
                }
                currentFont = bold && italic ? this.Field4010 : (bold ? this.Field4008 : (italic ? this.Field4009 : this.Field4007));
                if (randomCase) {
                    currentFont.Method819(GameFontRenderer$ColorUtils.Method8299(words), width, 0.0, currentColor);
                } else {
                    currentFont.Method819(words, width, 0.0, currentColor);
                }
                if (strikeThrough) {
                    PyroRenderUtil.Method12301(width / 2.0 + 1.0, (double)currentFont.Method818() / 3.0, (width + (double)currentFont.Method815(words)) / 2.0 + 1.0, (double)currentFont.Method818() / 3.0, (float)this.FONT_HEIGHT / 16.0f);
                }
                if (underline) {
                    PyroRenderUtil.Method12301(width / 2.0 + 1.0, (double)currentFont.Method818() / 2.0, (width + (double)currentFont.Method815(words)) / 2.0 + 1.0, (double)currentFont.Method818() / 2.0, (float)this.FONT_HEIGHT / 16.0f);
                }
                width += (double)currentFont.Method815(words);
            }
        } else {
            this.Field4007.Method819(text, 0.0, 0.0, currentColor);
        }
        GlStateManager.disableBlend();
        GlStateManager.translate((double)(-((double)x - 1.5)), (double)(-((double)y + 0.5)), (double)0.0);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        return (int)(x + (float)this.getStringWidth(text));
    }

    public int getColorCode(char charCode) {
        return GameFontRenderer$ColorUtils.Field5764[GameFontRenderer.Method5673(charCode)];
    }

    public int getStringWidth(String text) {
        String currentText = text;
        if (text.contains("\u00a7")) {
            String[] parts = text.split("\u00a7");
            fek currentFont = this.Field4007;
            int width = 0;
            boolean bold = false;
            boolean italic = false;
            for (int index = 0; index < parts.length; ++index) {
                String part = parts[index];
                if (part.isEmpty()) continue;
                if (index == 0) {
                    width += currentFont.Method815(part);
                    continue;
                }
                String words = part.substring(1);
                char type = part.charAt(0);
                int colorIndex = GameFontRenderer.Method5673(type);
                if (colorIndex < 16) {
                    bold = false;
                    italic = false;
                } else if (colorIndex == 17) {
                    bold = true;
                } else if (colorIndex == 20) {
                    italic = true;
                } else if (colorIndex == 21) {
                    bold = false;
                    italic = false;
                }
                currentFont = bold && italic ? this.Field4010 : (bold ? this.Field4008 : (italic ? this.Field4009 : this.Field4007));
                width += currentFont.Method815(words) + this.Field4006.Field1897.Field7349 + this.Field4006.Field1897.Field7351;
            }
            return width / 2;
        }
        return this.Field4007.Method815(currentText) / 2 + this.Field4006.Field1897.Field7349 + this.Field4006.Field1897.Field7351;
    }

    public int getCharWidth(char character) {
        return this.getStringWidth(String.valueOf(character));
    }

    public void onResourceManagerReload(IResourceManager resourceManager) {
    }

    protected void bindTexture(ResourceLocation location) {
    }

    public static int Method5673(char type) {
        switch (type) {
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                return type - 48;
            }
            case 'a': 
            case 'b': 
            case 'c': 
            case 'd': 
            case 'e': 
            case 'f': {
                return type - 97 + 10;
            }
            case 'k': 
            case 'l': 
            case 'm': 
            case 'n': 
            case 'o': {
                return type - 107 + 16;
            }
            case 'r': {
                return 21;
            }
        }
        return -1;
    }
}

