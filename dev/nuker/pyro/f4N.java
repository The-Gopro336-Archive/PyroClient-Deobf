/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import dev.nuker.pyro.gui.ClickGui;
import dev.nuker.pyro.mixin.GuiChatAccessor;
import dev.nuker.pyro.mixin.GuiTextFieldAccessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class f4N extends GuiChat {
   // $FF: renamed from: c java.lang.String
   public String field_2154;
   // $FF: renamed from: c int
   public int field_2155;
   // $FF: renamed from: 0 java.lang.String
   @Nullable
   public String field_2156;
   // $FF: renamed from: c boolean
   public boolean field_2157 = true;
   // $FF: renamed from: 0 boolean
   public boolean field_2158;
   // $FF: renamed from: c com.mojang.brigadier.suggestion.Suggestions
   @Nullable
   public Suggestions field_2159;
   // $FF: renamed from: 0 int
   public int field_2160 = 1;
   // $FF: renamed from: 1 int
   public int field_2161 = -1;

   // $FF: renamed from: 0 (boolean) void
   public void method_3225(boolean var1) {
      if (this.field_2159 != null) {
         Suggestions var10000 = this.field_2159;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.getList().size() > 0) {
            Suggestions var10001;
            if (var1) {
               int var3 = this.field_2161;
               var10001 = this.field_2159;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               if (var3 >= var10001.getList().size() - 1) {
                  this.field_2161 = 0;
               } else {
                  int var4 = this.field_2161++;
               }
            } else if (this.field_2161 <= 0) {
               var10001 = this.field_2159;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               this.field_2161 = var10001.getList().size() - 1;
            } else {
               this.field_2161 += -1;
            }
         }
      }

   }

   // $FF: renamed from: c (com.mojang.brigadier.suggestion.Suggestions) void
   public void method_3226(@Nullable Suggestions var1) {
      this.field_2159 = var1;
   }

   // $FF: renamed from: c () java.lang.String
   @Nullable
   public String method_3227() {
      return this.field_2156;
   }

   // $FF: renamed from: 2 () int
   public int method_3228() {
      return this.field_2161;
   }

   // $FF: renamed from: 1 () com.mojang.brigadier.suggestion.Suggestions
   @Nullable
   public Suggestions method_3229() {
      return this.field_2159;
   }

   // $FF: renamed from: 1 (boolean) void
   public void method_3230(boolean var1) {
      this.field_2158 = var1;
   }

   public f4N(@NotNull String var1, @NotNull String var2, int var3) {
      super(var1);
      int var5 = Config.INSTANCE.chatPrefix.length();
      boolean var6 = false;
      String var8 = var1.substring(var5);
      this.method_3235(var8);
      this.field_2154 = var2;
      this.field_2155 = var3;
   }

   // $FF: renamed from: 0 () int
   public int method_3231() {
      return this.field_2160;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3232(@Nullable String var1) {
      this.field_2156 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4N, int) void
   public static void method_3233(f4N var0, int var1) {
      var0.field_2155 = var1;
   }

   public void drawScreen(int var1, int var2, float var3) {
      Gui.drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
      ITextComponent var4 = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
      if (var4 != null && var4.getStyle().getHoverEvent() != null) {
         this.handleComponentHover(var4, var1, var2);
      }

      boolean var5 = GL11.glIsEnabled(3042);
      boolean var6 = GL11.glIsEnabled(3553);
      GL11.glDisable(3042);
      GL11.glDisable(3553);
      GL11.glColor3f(ClickGui.Companion.getSettings().method_3496().meth7(), ClickGui.Companion.getSettings().method_3496().method_3446(), ClickGui.Companion.getSettings().method_3496().meth22());
      GL11.glLineWidth(1.5F);
      GL11.glBegin(1);
      boolean var8 = false;
      boolean var9 = false;
      f4N var10 = (f4N)this;
      boolean var11 = false;
      GL11.glVertex2f((float)var10.inputField.x - (float)2, (float)var10.inputField.y - (float)2);
      GL11.glVertex2f((float)(var10.inputField.x + var10.inputField.getWidth()) - (float)2, (float)var10.inputField.y - (float)2);
      GL11.glVertex2f((float)(var10.inputField.x + var10.inputField.getWidth()) - (float)2, (float)var10.inputField.y - (float)2);
      GL11.glVertex2f((float)(var10.inputField.x + var10.inputField.getWidth()) - (float)2, (float)(var10.inputField.y + var10.inputField.height) - (float)2);
      GL11.glVertex2f((float)(var10.inputField.x + var10.inputField.getWidth()) - (float)2, (float)(var10.inputField.y + var10.inputField.height) - (float)2);
      GL11.glVertex2f((float)var10.inputField.x - (float)2, (float)(var10.inputField.y + var10.inputField.height) - (float)2);
      GL11.glVertex2f((float)var10.inputField.x - (float)2, (float)(var10.inputField.y + var10.inputField.height) - (float)2);
      GL11.glVertex2f((float)var10.inputField.x - (float)2, (float)var10.inputField.y - (float)2);
      GL11.glEnd();
      if (var5) {
         GL11.glEnable(3042);
      }

      if (var6) {
         GL11.glEnable(3553);
      }

      String var7 = this.inputField.getText();
      GuiTextField var39;
      if (this.field_2158 && this.field_2159 != null && this.field_2160 <= this.inputField.getText().length()) {
         Suggestions var10000 = this.field_2159;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.getList().size() > 0) {
            FontRenderer var35 = this.fontRenderer;
            String var24 = this.inputField.getText();
            byte var26 = 0;
            int var28 = this.field_2160;
            FontRenderer var20 = var35;
            boolean var12 = false;
            if (var24 == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            String var21 = var24.substring(var26, var28);
            int var23 = var20.getStringWidth(var21) + 4;
            int var25 = (this.inputField.getEnableBackgroundDrawing() ? this.inputField.y + (this.inputField.height - 8) / 2 : this.inputField.y) - 5;
            int var27 = 0;
            List var29 = (List)(new ArrayList());
            var10000 = this.field_2159;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            Iterator var13 = var10000.getList().iterator();

            while(var13.hasNext()) {
               Suggestion var30 = (Suggestion)var13.next();
               var29.add(var30.getText());
               int var14 = this.fontRenderer.getStringWidth(var30.getText());
               if (var14 > var27) {
                  var27 = var14;
               }
            }

            Gui.drawRect(var23 - 1, var25 - var29.size() * this.fontRenderer.FONT_HEIGHT - 1, var23 + var27 + 1, var25 + 1, f00.field_2296.method_3687(0, 0, 0, 200).meth1());
            int var31 = 0;

            for(int var32 = var29.size(); var31 < var32; ++var31) {
               String var33 = (String)var29.get(var31);
               this.fontRenderer.drawString((this.field_2161 == var31 ? TextFormatting.YELLOW : TextFormatting.GRAY).toString() + var33, (float)var23, (float)(var25 - var31 * this.fontRenderer.FONT_HEIGHT) - (float)this.fontRenderer.FONT_HEIGHT, -1, true);
               if (var31 == this.field_2161) {
                  String var15 = this.inputField.getText();
                  boolean var16 = false;
                  if (var15 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  String var43 = var15.toLowerCase();
                  var16 = false;
                  if (var33 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var21 = var33.toLowerCase();
                  if (!StringsKt.endsWith$default(var43, var21, false, 2, (Object)null) && this.field_2156 == null) {
                     int var34 = 0;

                     while(true) {
                        int var17;
                        boolean var18;
                        byte var40;
                        if (var34 < var33.length()) {
                           String var36 = this.inputField.getText();
                           var17 = this.field_2160;
                           var18 = false;
                           if (var36 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           var36 = var36.substring(var17);
                           boolean var38 = false;
                           if (var36 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           String var37 = var36.toLowerCase();
                           var40 = 0;
                           var43 = var37;
                           var18 = false;
                           if (var33 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           var21 = var33.substring(var40, var34);
                           var38 = false;
                           if (var21 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           var21 = var21.toLowerCase();
                           if (StringsKt.startsWith$default(var43, var21, false, 2, (Object)null)) {
                              ++var34;
                              continue;
                           }
                        }

                        if (var34 != 0) {
                           var39 = this.inputField;
                           if (var39 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiTextFieldAccessor");
                           }

                           GuiTextFieldAccessor var41 = (GuiTextFieldAccessor)var39;
                           StringBuilder var10001 = new StringBuilder();
                           var40 = 0;
                           int var42 = this.inputField.getCursorPosition();
                           StringBuilder var45 = var10001;
                           GuiTextFieldAccessor var44 = var41;
                           boolean var19 = false;
                           if (var7 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           String var22 = var7.substring(var40, var42);
                           var10001 = var45.append(var22).append(TextFormatting.DARK_GRAY);
                           var17 = var34 - 1;
                           var45 = var10001;
                           var18 = false;
                           if (var33 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           var22 = var33.substring(var17);
                           var44.set(var45.append(var22).toString());
                        }
                        break;
                     }
                  }
               }
            }
         }
      }

      this.inputField.drawTextBox();
      var39 = this.inputField;
      if (var39 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiTextFieldAccessor");
      } else {
         ((GuiTextFieldAccessor)var39).set(var7);
      }
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_3234() {
      return this.field_2158;
   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_3235(@NotNull String var1) {
      String var2 = var1;
      if (this.field_2156 != null) {
         String var10000 = this.field_2156;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
         }

         var2 = var10000;
      } else {
         this.field_2161 = 0;
      }

      ParseResults var3 = f3e.field_2142.method_3214().parse((String)var2, new f1s());
      CompletableFuture var4 = f3e.field_2142.method_3214().getCompletionSuggestions(var3);
      this.field_2159 = (Suggestions)null;
      this.field_2160 = StringsKt.lastIndexOf$default((CharSequence)var2, " ", 0, false, 6, (Object)null);
      if (this.field_2160 != 0) {
         this.field_2160 += 1 + Config.INSTANCE.chatPrefix.length();
      }

      var4.whenComplete((BiConsumer)(new f4L(this)));
   }

   // $FF: renamed from: 0 (int) void
   public void method_3236(int var1) {
      this.field_2160 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_3237(int var1) {
      this.field_2161 = var1;
   }

   public void keyTyped(char var1, int var2) {
      if (this == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiChatAccessor");
      } else {
         ((GuiChatAccessor)this).setHistoryCursor(this.field_2155);
         String var3;
         int var4;
         boolean var5;
         String var9;
         int var13;
         Suggestions var10000;
         if (var2 == 15) {
            if (this.field_2159 != null) {
               var10000 = this.field_2159;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               if (var10000.getList().size() > 0) {
                  if (!this.field_2158) {
                     this.field_2158 = true;
                  } else {
                     if (this.field_2156 == null) {
                        var3 = this.inputField.getText();
                        var4 = Config.INSTANCE.chatPrefix.length();
                        var5 = false;
                        if (var3 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }

                        var9 = var3.substring(var4);
                        this.field_2156 = var9;
                        this.field_2157 = true;
                     } else if (this.field_2157) {
                        this.method_3225(false);
                     } else {
                        this.field_2157 = true;
                     }

                     GuiTextField var16 = this.inputField;
                     StringBuilder var10001 = new StringBuilder();
                     var3 = this.inputField.getText();
                     byte var11 = 0;
                     var13 = this.field_2160;
                     StringBuilder var15 = var10001;
                     GuiTextField var8 = var16;
                     boolean var6 = false;
                     if (var3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                     }

                     String var10 = var3.substring(var11, var13);
                     var10001 = var15.append(var10);
                     Suggestions var10002 = this.field_2159;
                     if (var10002 == null) {
                        Intrinsics.throwNpe();
                     }

                     var8.setText(var10001.append(((Suggestion)var10002.getList().get(this.field_2161)).getText()).toString());
                  }
               }
            }
         } else if (var2 == 200) {
            label460: {
               if (this.field_2158 && this.field_2159 != null) {
                  var10000 = this.field_2159;
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var10000.getList().size() > 0) {
                     if (this.field_2156 == null) {
                        var3 = this.inputField.getText();
                        var4 = Config.INSTANCE.chatPrefix.length();
                        var5 = false;
                        if (var3 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }

                        var9 = var3.substring(var4);
                        this.field_2156 = var9;
                     }

                     this.method_3225(true);
                     this.field_2157 = false;
                     break label460;
                  }
               }

               this.field_2156 = (String)null;
               this.field_2158 = false;
               super.keyTyped(var1, var2);
            }
         } else if (var2 == 208) {
            label453: {
               if (this.field_2158 && this.field_2159 != null) {
                  var10000 = this.field_2159;
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var10000.getList().size() > 0) {
                     if (this.field_2156 == null) {
                        var3 = this.inputField.getText();
                        var4 = Config.INSTANCE.chatPrefix.length();
                        var5 = false;
                        if (var3 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }

                        var9 = var3.substring(var4);
                        this.field_2156 = var9;
                     }

                     this.method_3225(false);
                     this.field_2157 = false;
                     break label453;
                  }
               }

               this.field_2156 = (String)null;
               this.field_2158 = false;
               super.keyTyped(var1, var2);
            }
         } else {
            this.field_2158 = true;
            this.field_2156 = (String)null;
            super.keyTyped(var1, var2);
         }

         this.field_2155 = ((GuiChatAccessor)this).getHistoryCursor();
         var3 = this.inputField.getText();
         if (Config.INSTANCE.chatPrefix != null && !StringsKt.startsWith$default(var3, Config.INSTANCE.chatPrefix, false, 2, (Object)null)) {
            GuiChat var12 = (GuiChat)(new f4M(this, var3, var3));
            ((GuiChatAccessor)var12).setHistoryBuffer(this.field_2154);
            this.mc.displayGuiScreen((GuiScreen)var12);
         } else {
            if (this.inputField.getCursorPosition() >= Config.INSTANCE.chatPrefix.length()) {
               var13 = Config.INSTANCE.chatPrefix.length();
               int var14 = this.inputField.getCursorPosition();
               boolean var7 = false;
               if (var3 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               var9 = var3.substring(var13, var14);
               this.method_3235(var9);
            }

         }
      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_3238(boolean var1) {
      this.field_2157 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4N) int
   public static int method_3239(f4N var0) {
      return var0.field_2155;
   }

   // $FF: renamed from: 4 () boolean
   public boolean method_3240() {
      return this.field_2157;
   }
}
