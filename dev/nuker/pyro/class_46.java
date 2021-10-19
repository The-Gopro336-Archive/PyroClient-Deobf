/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiPageButtonList.GuiResponder;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.LogicOp;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.math.MathHelper;

// $FF: renamed from: dev.nuker.pyro.fo
public class class_46 extends Gui {
   // $FF: renamed from: c int
   public int field_2650;
   // $FF: renamed from: c net.minecraft.client.gui.FontRenderer
   public FontRenderer field_2651;
   // $FF: renamed from: 0 int
   public int field_2652;
   // $FF: renamed from: 1 int
   public int field_2653;
   // $FF: renamed from: 2 int
   public int field_2654;
   // $FF: renamed from: 3 int
   public int field_2655;
   // $FF: renamed from: c java.lang.String
   public String field_2656 = "";
   // $FF: renamed from: 4 int
   public int field_2657 = 32;
   // $FF: renamed from: 5 int
   public int field_2658;
   // $FF: renamed from: c boolean
   public boolean field_2659 = true;
   // $FF: renamed from: 0 boolean
   public boolean field_2660 = true;
   // $FF: renamed from: 1 boolean
   public boolean field_2661;
   // $FF: renamed from: 2 boolean
   public boolean field_2662 = true;
   // $FF: renamed from: 6 int
   public int field_2663;
   // $FF: renamed from: 7 int
   public int field_2664;
   // $FF: renamed from: 8 int
   public int field_2665;
   // $FF: renamed from: 9 int
   public int field_2666 = 14737632;
   // $FF: renamed from: a int
   public int field_2667 = 7368816;
   // $FF: renamed from: 3 boolean
   public boolean field_2668 = true;
   // $FF: renamed from: c net.minecraft.client.gui.GuiPageButtonList.GuiResponder
   public GuiResponder field_2669;
   // $FF: renamed from: c com.google.common.base.Predicate
   public Predicate field_2670 = Predicates.alwaysTrue();

   // $FF: renamed from: 1 (boolean) void
   public void method_4009(boolean var1) {
      this.field_2668 = var1;
   }

   // $FF: renamed from: 9 () java.lang.String
   public String method_4010() {
      return this.field_2656;
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_4011(int var1, int var2, int var3) {
      boolean var4 = var1 >= this.field_2652 && var1 < this.field_2652 + this.field_2654 && var2 >= this.field_2653 && var2 < this.field_2653 + this.field_2655;
      if (this.field_2660) {
         this.method_4037(var4);
      }

      if (this.field_2661 && var4 && var3 == 0) {
         int var5 = var1 - this.field_2652;
         if (this.field_2659) {
            var5 -= 4;
         }

         String var6 = this.field_2651.trimStringToWidth(this.field_2656.substring(this.field_2663), this.method_4045());
         this.method_4029(this.field_2651.trimStringToWidth(var6, var5).length() + this.field_2663);
      }

   }

   // $FF: renamed from: 8 () int
   public int method_4012() {
      return this.field_2657;
   }

   // $FF: renamed from: 1 (int) int
   public int method_4013(int var1) {
      return this.method_4040(var1, this.method_4030());
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_4014() {
      return this.field_2668;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.GuiPageButtonList.GuiResponder) void
   public void method_4015(GuiResponder var1) {
      this.field_2669 = var1;
   }

   // $FF: renamed from: a () int
   public int method_4016() {
      return this.field_2665;
   }

   // $FF: renamed from: c (int, int, boolean) int
   public int method_4017(int var1, int var2, boolean var3) {
      int var4 = var2;
      boolean var5 = var1 < 0;
      int var6 = Math.abs(var1);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (!var5) {
            int var8 = this.field_2656.length();
            var4 = this.field_2656.indexOf(32, var4);
            if (var4 == -1) {
               var4 = var8;
            } else {
               while(var3 && var4 < var8 && this.field_2656.charAt(var4) == ' ') {
                  ++var4;
               }
            }
         } else {
            while(var3 && var4 > 0 && this.field_2656.charAt(var4 - 1) == ' ') {
               --var4;
            }

            while(var4 > 0 && this.field_2656.charAt(var4 - 1) != ' ') {
               --var4;
            }
         }
      }

      return var4;
   }

   // $FF: renamed from: 0 () void
   public void method_4018() {
      this.method_4029(0);
   }

   // $FF: renamed from: c (int, int, int, int) void
   public void method_4019(int var1, int var2, int var3, int var4) {
      int var5;
      if (var1 < var3) {
         var5 = var1;
         var1 = var3;
         var3 = var5;
      }

      if (var2 < var4) {
         var5 = var2;
         var2 = var4;
         var4 = var5;
      }

      if (var3 > this.field_2652 + this.field_2654) {
         var3 = this.field_2652 + this.field_2654;
      }

      if (var1 > this.field_2652 + this.field_2654) {
         var1 = this.field_2652 + this.field_2654;
      }

      Tessellator var7 = Tessellator.getInstance();
      BufferBuilder var6 = var7.getBuffer();
      GlStateManager.color(0.0F, 0.0F, 255.0F, 255.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.enableColorLogic();
      GlStateManager.colorLogicOp(LogicOp.OR_REVERSE);
      var6.begin(7, DefaultVertexFormats.POSITION);
      var6.pos((double)var1, (double)var4, 0.0D).endVertex();
      var6.pos((double)var3, (double)var4, 0.0D).endVertex();
      var6.pos((double)var3, (double)var2, 0.0D).endVertex();
      var6.pos((double)var1, (double)var2, 0.0D).endVertex();
      var7.draw();
      GlStateManager.disableColorLogic();
      GlStateManager.enableTexture2D();
   }

   // $FF: renamed from: c (int) void
   public void method_4020(int var1) {
      this.field_2657 = var1;
      if (this.field_2656.length() > var1) {
         this.field_2656 = this.field_2656.substring(0, var1);
      }

   }

   // $FF: renamed from: c (com.google.common.base.Predicate) void
   public void method_4021(Predicate var1) {
      this.field_2670 = var1;
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_4022(boolean var1) {
      this.field_2660 = var1;
   }

   // $FF: renamed from: 4 (int) void
   public void method_4023(int var1) {
      this.field_2667 = var1;
   }

   // $FF: renamed from: 4 () boolean
   public boolean method_4024() {
      return this.field_2661;
   }

   // $FF: renamed from: b () void
   public void method_4025() {
      this.method_4029(this.field_2656.length());
   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_4026(String var1) {
      String var2 = "";
      String var3 = ChatAllowedCharacters.filterAllowedCharacters(var1);
      int var4 = this.field_2664 < this.field_2665 ? this.field_2664 : this.field_2665;
      int var5 = this.field_2664 < this.field_2665 ? this.field_2665 : this.field_2664;
      int var6 = this.field_2657 - this.field_2656.length() - (var4 - var5);
      if (!this.field_2656.isEmpty()) {
         var2 = var2 + this.field_2656.substring(0, var4);
      }

      int var7;
      if (var6 < var3.length()) {
         var2 = var2 + var3.substring(0, var6);
         var7 = var6;
      } else {
         var2 = var2 + var3;
         var7 = var3.length();
      }

      if (!this.field_2656.isEmpty() && var5 < this.field_2656.length()) {
         var2 = var2 + this.field_2656.substring(var5);
      }

      if (this.field_2670.apply(var2)) {
         this.field_2656 = var2;
         this.method_4027(var4 - this.field_2665 + var7);
         this.method_4028(this.field_2650, this.field_2656);
      }

   }

   // $FF: renamed from: 5 (int) void
   public void method_4027(int var1) {
      this.method_4029(this.field_2665 + var1);
   }

   // $FF: renamed from: c (int, java.lang.String) void
   public void method_4028(int var1, String var2) {
      if (this.field_2669 != null) {
         this.field_2669.setEntryValue(var1, var2);
      }

   }

   // $FF: renamed from: 6 (int) void
   public void method_4029(int var1) {
      this.field_2664 = var1;
      int var2 = this.field_2656.length();
      this.field_2664 = MathHelper.clamp(this.field_2664, 0, var2);
      this.method_4031(this.field_2664);
   }

   // $FF: renamed from: c () int
   public int method_4030() {
      return this.field_2664;
   }

   // $FF: renamed from: 3 (int) void
   public void method_4031(int var1) {
      int var2 = this.field_2656.length();
      if (var1 > var2) {
         var1 = var2;
      }

      if (var1 < 0) {
         var1 = 0;
      }

      this.field_2665 = var1;
      if (this.field_2651 != null) {
         if (this.field_2663 > var2) {
            this.field_2663 = var2;
         }

         int var3 = this.method_4045();
         String var4 = this.field_2651.trimStringToWidth(this.field_2656.substring(this.field_2663), var3);
         int var5 = var4.length() + this.field_2663;
         if (var1 == this.field_2663) {
            this.field_2663 -= this.field_2651.trimStringToWidth(this.field_2656, var3, true).length();
         }

         if (var1 > var5) {
            this.field_2663 += var1 - var5;
         } else if (var1 <= this.field_2663) {
            this.field_2663 -= this.field_2663 - var1;
         }

         this.field_2663 = MathHelper.clamp(this.field_2663, 0, var2);
      }

   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_4032(String var1) {
      if (this.field_2670.apply(var1)) {
         if (var1.length() > this.field_2657) {
            this.field_2656 = var1.substring(0, this.field_2657);
         } else {
            this.field_2656 = var1;
         }

         this.method_4025();
      }

   }

   public class_46(int var1, FontRenderer var2, int var3, int var4, int var5, int var6) {
      this.field_2650 = var1;
      this.field_2651 = var2;
      this.field_2652 = var3;
      this.field_2653 = var4;
      this.field_2654 = var5;
      this.field_2655 = var6;
   }

   // $FF: renamed from: 2 (boolean) void
   public void method_4033(boolean var1) {
      this.field_2662 = var1;
   }

   // $FF: renamed from: 3 (boolean) void
   public void method_4034(boolean var1) {
      this.field_2659 = var1;
   }

   // $FF: renamed from: 1 () int
   public int method_4035() {
      return this.field_2650;
   }

   // $FF: renamed from: 2 (int) void
   public void method_4036(int var1) {
      this.field_2666 = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_4037(boolean var1) {
      if (var1 && !this.field_2661) {
         this.field_2658 = 0;
      }

      this.field_2661 = var1;
   }

   // $FF: renamed from: 7 () void
   public void method_4038() {
      if (this.method_4014()) {
         if (this.method_4041()) {
            drawRect(this.field_2652 - 1, this.field_2653 - 1, this.field_2652 + this.field_2654 + 1, this.field_2653 + this.field_2655 + 1, -6250336);
            drawRect(this.field_2652, this.field_2653, this.field_2652 + this.field_2654, this.field_2653 + this.field_2655, -16777216);
         }

         int var1 = this.field_2662 ? this.field_2666 : this.field_2667;
         int var2 = this.field_2664 - this.field_2663;
         int var3 = this.field_2665 - this.field_2663;
         String var4 = this.field_2651.trimStringToWidth(this.field_2656.substring(this.field_2663), this.method_4045());
         boolean var5 = var2 >= 0 && var2 <= var4.length();
         boolean var6 = this.field_2661 && this.field_2658 / 6 % 2 == 0 && var5;
         int var7 = this.field_2659 ? this.field_2652 + 4 : this.field_2652;
         int var8 = this.field_2659 ? this.field_2653 + (this.field_2655 - 8) / 2 : this.field_2653;
         int var9 = var7;
         if (var3 > var4.length()) {
            var3 = var4.length();
         }

         if (!var4.isEmpty()) {
            String var10 = var5 ? var4.substring(0, var2) : var4;
            var9 = this.field_2651.drawStringWithShadow(var10.replaceAll("(?s).", "*"), (float)var7, (float)var8, var1);
         }

         boolean var13 = this.field_2664 < this.field_2656.length() || this.field_2656.length() >= this.method_4012();
         int var11 = var9;
         if (!var5) {
            var11 = var2 > 0 ? var7 + this.field_2654 : var7;
         } else if (var13) {
            var11 = var9 - 1;
            --var9;
         }

         if (!var4.isEmpty() && var5 && var2 < var4.length()) {
            var9 = this.field_2651.drawStringWithShadow(var4.substring(var2), (float)var9, (float)var8, var1);
         }

         if (var6) {
            if (var13) {
               Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.field_2651.FONT_HEIGHT, -3092272);
            } else {
               this.field_2651.drawStringWithShadow("_", (float)var11, (float)var8, var1);
            }
         }

         if (var3 != var2) {
            int var12 = var7 + this.field_2651.getStringWidth(var4.substring(0, var3));
            this.method_4019(var11, var8 - 1, var12 - 1, var8 + 1 + this.field_2651.FONT_HEIGHT);
         }
      }

   }

   // $FF: renamed from: c (char, int) boolean
   public boolean method_4039(char var1, int var2) {
      if (!this.field_2661) {
         return false;
      } else if (GuiScreen.isKeyComboCtrlA(var2)) {
         this.method_4025();
         this.method_4031(0);
         return true;
      } else if (GuiScreen.isKeyComboCtrlC(var2)) {
         GuiScreen.setClipboardString(this.method_4042());
         return true;
      } else if (GuiScreen.isKeyComboCtrlV(var2)) {
         if (this.field_2662) {
            this.method_4026(GuiScreen.getClipboardString());
         }

         return true;
      } else if (GuiScreen.isKeyComboCtrlX(var2)) {
         GuiScreen.setClipboardString(this.method_4042());
         if (this.field_2662) {
            this.method_4026("");
         }

         return true;
      } else {
         switch(var2) {
         case 14:
            if (GuiScreen.isCtrlKeyDown()) {
               if (this.field_2662) {
                  this.method_4044(-1);
               }
            } else if (this.field_2662) {
               this.method_4043(-1);
            }

            return true;
         case 199:
            if (GuiScreen.isShiftKeyDown()) {
               this.method_4031(0);
            } else {
               this.method_4018();
            }

            return true;
         case 203:
            if (GuiScreen.isShiftKeyDown()) {
               if (GuiScreen.isCtrlKeyDown()) {
                  this.method_4031(this.method_4040(-1, this.method_4016()));
               } else {
                  this.method_4031(this.method_4016() - 1);
               }
            } else if (GuiScreen.isCtrlKeyDown()) {
               this.method_4029(this.method_4013(-1));
            } else {
               this.method_4027(-1);
            }

            return true;
         case 205:
            if (GuiScreen.isShiftKeyDown()) {
               if (GuiScreen.isCtrlKeyDown()) {
                  this.method_4031(this.method_4040(1, this.method_4016()));
               } else {
                  this.method_4031(this.method_4016() + 1);
               }
            } else if (GuiScreen.isCtrlKeyDown()) {
               this.method_4029(this.method_4013(1));
            } else {
               this.method_4027(1);
            }

            return true;
         case 207:
            if (GuiScreen.isShiftKeyDown()) {
               this.method_4031(this.field_2656.length());
            } else {
               this.method_4025();
            }

            return true;
         case 211:
            if (GuiScreen.isCtrlKeyDown()) {
               if (this.field_2662) {
                  this.method_4044(1);
               }
            } else if (this.field_2662) {
               this.method_4043(1);
            }

            return true;
         default:
            if (ChatAllowedCharacters.isAllowedCharacter(var1)) {
               if (this.field_2662) {
                  this.method_4026(Character.toString(var1));
               }

               return true;
            } else {
               return false;
            }
         }
      }
   }

   // $FF: renamed from: c (int, int) int
   public int method_4040(int var1, int var2) {
      return this.method_4017(var1, var2, true);
   }

   // $FF: renamed from: 5 () boolean
   public boolean method_4041() {
      return this.field_2659;
   }

   // $FF: renamed from: d () java.lang.String
   public String method_4042() {
      int var1 = this.field_2664 < this.field_2665 ? this.field_2664 : this.field_2665;
      int var2 = this.field_2664 < this.field_2665 ? this.field_2665 : this.field_2664;
      return this.field_2656.substring(var1, var2);
   }

   // $FF: renamed from: 7 (int) void
   public void method_4043(int var1) {
      if (!this.field_2656.isEmpty()) {
         if (this.field_2665 != this.field_2664) {
            this.method_4026("");
         } else {
            boolean var2 = var1 < 0;
            int var3 = var2 ? this.field_2664 + var1 : this.field_2664;
            int var4 = var2 ? this.field_2664 : this.field_2664 + var1;
            String var5 = "";
            if (var3 >= 0) {
               var5 = this.field_2656.substring(0, var3);
            }

            if (var4 < this.field_2656.length()) {
               var5 = var5 + this.field_2656.substring(var4);
            }

            if (this.field_2670.apply(var5)) {
               this.field_2656 = var5;
               if (var2) {
                  this.method_4027(var1);
               }

               this.method_4028(this.field_2650, this.field_2656);
            }
         }
      }

   }

   // $FF: renamed from: 0 (int) void
   public void method_4044(int var1) {
      if (!this.field_2656.isEmpty()) {
         if (this.field_2665 != this.field_2664) {
            this.method_4026("");
         } else {
            this.method_4043(this.method_4013(var1) - this.field_2664);
         }
      }

   }

   // $FF: renamed from: 3 () int
   public int method_4045() {
      return this.method_4041() ? this.field_2654 - 8 : this.field_2654;
   }

   // $FF: renamed from: 6 () void
   public void method_4046() {
      ++this.field_2658;
   }
}
