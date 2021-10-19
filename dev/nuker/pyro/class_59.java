/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.api.FontManager$CustomFontConfig;
import dev.nuker.pyro.util.font.GameFontRenderer;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: dev.nuker.pyro.fy
public class class_59 {
   // $FF: renamed from: c dev.nuker.pyro.fy
   public static class_59 field_2713 = new class_59();
   // $FF: renamed from: c dev.nuker.pyro.util.font.GameFontRenderer
   public GameFontRenderer field_2714;
   // $FF: renamed from: 0 dev.nuker.pyro.util.font.GameFontRenderer
   public GameFontRenderer field_2715;
   // $FF: renamed from: 1 dev.nuker.pyro.util.font.GameFontRenderer
   public GameFontRenderer field_2716;
   // $FF: renamed from: 2 dev.nuker.pyro.util.font.GameFontRenderer
   public GameFontRenderer field_2717;
   // $FF: renamed from: c dev.nuker.pyro.api.FontManager$CustomFontConfig
   public FontManager$CustomFontConfig field_2718;
   // $FF: renamed from: 0 dev.nuker.pyro.api.FontManager$CustomFontConfig
   public FontManager$CustomFontConfig field_2719;

   // $FF: renamed from: c () dev.nuker.pyro.api.FontManager$CustomFontConfig
   public FontManager$CustomFontConfig method_4134() {
      return this.field_2717 != null ? this.field_2719 : this.field_2718;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.util.font.GameFontRenderer
   public GameFontRenderer method_4135() {
      return this.field_2717 != null ? this.field_2717 : this.field_2714;
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_4136() {
      this.field_2717 = null;
      File var1 = new File("pyro/font.ttf");
      if (var1.exists()) {
         FontManager$CustomFontConfig var2 = new FontManager$CustomFontConfig();
         File var3 = new File("pyro/font.json");
         if (var3.exists()) {
            try {
               FileReader var4 = new FileReader(var3);
               var2 = (FontManager$CustomFontConfig)Pyro.GSON.fromJson(var4, FontManager$CustomFontConfig.class);
               var4.close();
            } catch (IOException var8) {
               System.err.println("Pyro: Could not read font config");
            }
         }

         try {
            FileInputStream var9 = new FileInputStream(var1);
            Font var5 = Font.createFont(0, var9);
            var5 = var5.deriveFont(0, (float)var2.size);
            var9.close();
            this.field_2717 = new GameFontRenderer(var5, var2);
            this.field_2719 = var2;
            if (!var3.exists()) {
               FileWriter var6 = new FileWriter(var3);
               Pyro.GSON.toJson(var2, var6);
               var6.close();
            }

            return true;
         } catch (Exception var7) {
            System.err.println("Pyro: Could not load custom font");
            return false;
         }
      } else {
         return false;
      }
   }

   // $FF: renamed from: c (java.lang.String, float) java.awt.Font
   public static Font method_4137(String var0, float var1) {
      try {
         InputStream var2 = Pyro.getResourceAsStream("assets/fonts/" + var0);
         Font var3 = Font.createFont(0, var2);
         var3 = var3.deriveFont(0, var1);
         var2.close();
         return var3;
      } catch (Exception var4) {
         var4.printStackTrace();
         return new Font("default", 0, (int)var1);
      }
   }

   // $FF: renamed from: 1 () void
   public void method_4138() {
      this.field_2718 = new FontManager$CustomFontConfig();
      File var1 = new File("pyro/font_default.json");
      if (var1.exists()) {
         try {
            FileReader var2 = new FileReader(var1);
            this.field_2718 = (FontManager$CustomFontConfig)Pyro.GSON.fromJson(var2, FontManager$CustomFontConfig.class);
            var2.close();
         } catch (IOException var4) {
            System.err.println("Pyro: Could not read default font config");
         }
      } else {
         try {
            FileWriter var5 = new FileWriter(var1);
            Pyro.GSON.toJson(this.field_2718, var5);
            var5.close();
         } catch (IOException var3) {
            System.err.println("Pyro: Could not save default font config");
         }
      }

      this.field_2714 = new GameFontRenderer(method_4137("Roboto-Medium.ttf", (float)this.field_2718.size), this.field_2718);
      this.field_2715 = new GameFontRenderer(method_4137("Roboto-Medium.ttf", 44.0F), this.field_2718);
      this.field_2716 = new GameFontRenderer(method_4137("badaboom.ttf", 40.0F), this.field_2718);
      this.method_4136();
   }

   // $FF: renamed from: 0 () void
   public void method_4139() {
   }
}
