/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.util.font;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.fek;
import dev.nuker.pyro.api.FontManager$CustomFontConfig;
import java.awt.Color;
import java.awt.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL20;

public class GameFontRenderer extends FontRenderer {
   private Font font;
   private FontManager$CustomFontConfig config;
   private fek defaultFont;
   private fek boldFont;
   private fek italicFont;
   private fek boldItalicFont;

   public GameFontRenderer(Font font, FontManager$CustomFontConfig config) {
      super(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().getTextureManager(), false);
      this.font = font;
      this.config = config;
      this.defaultFont = new fek(font);
      this.boldFont = new fek(font.deriveFont(1));
      this.italicFont = new fek(font.deriveFont(2));
      this.boldItalicFont = new fek(font.deriveFont(3));
      this.FONT_HEIGHT = this.getHeight();
   }

   public int getHeight() {
      return this.defaultFont.method_2053() / 2 + this.config.insets.yBegin + this.config.insets.yEnd;
   }

   public int getSize() {
      return this.defaultFont.method_2049().getSize();
   }

   public void drawString(String s, float x, float y, int color) {
      this.drawString(s, x, y, color, false);
   }

   public int drawStringWithShadow(String text, float x, float y, int color) {
      return this.drawString(text, x, y, color, true);
   }

   public void drawCenteredString(String s, float x, float y, int color, boolean shadow) {
      this.drawString(s, x - (float)this.getStringWidth(s) / 2.0F, y, color, shadow);
   }

   public void drawCenteredString(String s, float x, float y, int color) {
      this.drawString(s, x - (float)this.getStringWidth(s) / 2.0F, y, color);
   }

   public int drawString(String text, float x, float y, int color, boolean dropShadow) {
      x += (float)this.config.insets.xBegin;
      y += (float)this.config.insets.yBegin;
      float currY = y - 3.0F;
      if (!text.contains("\n")) {
         if (dropShadow) {
            GL20.glUseProgram(0);
            this.drawText(text, x + 0.5F, currY + 0.5F, (new Color(0, 0, 0, 150)).getRGB(), true);
         }

         return this.drawText(text, x, currY, color, false);
      } else {
         String[] parts = text.split("\n");
         float newY = 0.0F;
         String[] var9 = parts;
         int var10 = parts.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            String s = var9[var11];
            this.drawText(s, x, currY + newY, color, dropShadow);
            newY += (float)this.getHeight();
         }

         return 0;
      }
   }

   private int drawText(String text, float x, float y, int color, boolean ignoreColor) {
      if (text == null) {
         return 0;
      } else if (text.isEmpty()) {
         return (int)x;
      } else {
         GlStateManager.translate((double)x - 1.5D, (double)y + 0.5D, 0.0D);
         GlStateManager.enableAlpha();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.enableTexture2D();
         int currentColor = color;
         if ((color & -67108864) == 0) {
            currentColor = color | -16777216;
         }

         int alpha = currentColor >> 24 & 255;
         if (text.contains("§")) {
            String[] parts = text.split("§");
            fek currentFont = this.defaultFont;
            double width = 0.0D;
            boolean randomCase = false;
            boolean bold = false;
            boolean italic = false;
            boolean strikeThrough = false;
            boolean underline = false;

            for(int index = 0; index < parts.length; ++index) {
               String part = parts[index];
               if (!part.isEmpty()) {
                  if (index == 0) {
                     currentFont.method_2054(part, width, 0.0D, currentColor);
                     width += (double)currentFont.method_2050(part);
                  } else {
                     String words = part.substring(1);
                     char type = part.charAt(0);
                     int colorIndex = "0123456789abcdefklmnor".indexOf(type);
                     switch(colorIndex) {
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
                     case 15:
                        if (!ignoreColor) {
                           currentColor = GameFontRenderer$ColorUtils.hexColors[colorIndex] | alpha << 24;
                        }

                        bold = false;
                        italic = false;
                        randomCase = false;
                        underline = false;
                        strikeThrough = false;
                        break;
                     case 16:
                        randomCase = true;
                        break;
                     case 17:
                        bold = true;
                        break;
                     case 18:
                        strikeThrough = true;
                        break;
                     case 19:
                        underline = true;
                        break;
                     case 20:
                        italic = true;
                        break;
                     case 21:
                        currentColor = color;
                        if ((color & -67108864) == 0) {
                           currentColor = color | -16777216;
                        }

                        bold = false;
                        italic = false;
                        randomCase = false;
                        underline = false;
                        strikeThrough = false;
                     }

                     if (bold && italic) {
                        currentFont = this.boldItalicFont;
                     } else if (bold) {
                        currentFont = this.boldFont;
                     } else if (italic) {
                        currentFont = this.italicFont;
                     } else {
                        currentFont = this.defaultFont;
                     }

                     if (randomCase) {
                        currentFont.method_2054(GameFontRenderer$ColorUtils.randomMagicText(words), width, 0.0D, currentColor);
                     } else {
                        currentFont.method_2054(words, width, 0.0D, currentColor);
                     }

                     if (strikeThrough) {
                        PyroRenderUtil.method_1429(width / 2.0D + 1.0D, (double)currentFont.method_2053() / 3.0D, (width + (double)currentFont.method_2050(words)) / 2.0D + 1.0D, (double)currentFont.method_2053() / 3.0D, (float)this.FONT_HEIGHT / 16.0F);
                     }

                     if (underline) {
                        PyroRenderUtil.method_1429(width / 2.0D + 1.0D, (double)currentFont.method_2053() / 2.0D, (width + (double)currentFont.method_2050(words)) / 2.0D + 1.0D, (double)currentFont.method_2053() / 2.0D, (float)this.FONT_HEIGHT / 16.0F);
                     }

                     width += (double)currentFont.method_2050(words);
                  }
               }
            }
         } else {
            this.defaultFont.method_2054(text, 0.0D, 0.0D, currentColor);
         }

         GlStateManager.disableBlend();
         GlStateManager.translate(-((double)x - 1.5D), -((double)y + 0.5D), 0.0D);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         return (int)(x + (float)this.getStringWidth(text));
      }
   }

   public int getColorCode(char charCode) {
      return GameFontRenderer$ColorUtils.hexColors[getColorIndex(charCode)];
   }

   public int getStringWidth(String text) {
      if (!text.contains("§")) {
         return this.defaultFont.method_2050(text) / 2 + this.config.insets.xBegin + this.config.insets.xEnd;
      } else {
         String[] parts = text.split("§");
         fek currentFont = this.defaultFont;
         int width = 0;
         boolean bold = false;
         boolean italic = false;

         for(int index = 0; index < parts.length; ++index) {
            String part = parts[index];
            if (!part.isEmpty()) {
               if (index == 0) {
                  width += currentFont.method_2050(part);
               } else {
                  String words = part.substring(1);
                  char type = part.charAt(0);
                  int colorIndex = getColorIndex(type);
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

                  if (bold && italic) {
                     currentFont = this.boldItalicFont;
                  } else if (bold) {
                     currentFont = this.boldFont;
                  } else if (italic) {
                     currentFont = this.italicFont;
                  } else {
                     currentFont = this.defaultFont;
                  }

                  width += currentFont.method_2050(words) + this.config.insets.xBegin + this.config.insets.xEnd;
               }
            }
         }

         return width / 2;
      }
   }

   public int getCharWidth(char character) {
      return this.getStringWidth(String.valueOf(character));
   }

   public void onResourceManagerReload(IResourceManager resourceManager) {
   }

   protected void bindTexture(ResourceLocation location) {
   }

   public static int getColorIndex(char type) {
      switch(type) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
         return type - 48;
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
      case 'g':
      case 'h':
      case 'i':
      case 'j':
      case 'p':
      case 'q':
      default:
         return -1;
      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
         return type - 97 + 10;
      case 'k':
      case 'l':
      case 'm':
      case 'n':
      case 'o':
         return type - 107 + 16;
      case 'r':
         return 21;
      }
   }
}
