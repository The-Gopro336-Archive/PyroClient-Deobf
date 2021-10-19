/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

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
   // $FF: renamed from: c dev.nuker.pyro.f0J
   public static f0J field_2340;

   // $FF: renamed from: c (int, int, int, int, int, int) void
   public void method_3552(int var1, int var2, int var3, int var4, int var5, int var6) {
      double var7 = 0.0D;
      float var9 = 0.00390625F;
      float var10 = 0.00390625F;
      Tessellator var11 = Tessellator.getInstance();
      BufferBuilder var12 = var11.getBuffer();
      var12.begin(7, DefaultVertexFormats.POSITION_TEX);
      var12.pos((double)(var1 + 0), (double)(var2 + var6), var7).tex((double)((float)(var3 + 0) * 0.00390625F), (double)((float)(var4 + var6) * 0.00390625F)).endVertex();
      var12.pos((double)(var1 + var5), (double)(var2 + var6), var7).tex((double)((float)(var3 + var5) * 0.00390625F), (double)((float)(var4 + var6) * 0.00390625F)).endVertex();
      var12.pos((double)(var1 + var5), (double)(var2 + 0), var7).tex((double)((float)(var3 + var5) * 0.00390625F), (double)((float)(var4 + 0) * 0.00390625F)).endVertex();
      var12.pos((double)(var1 + 0), (double)(var2 + 0), var7).tex((double)((float)(var3 + 0) * 0.00390625F), (double)((float)(var4 + 0) * 0.00390625F)).endVertex();
      var11.draw();
   }

   // $FF: renamed from: 0 (net.minecraft.client.gui.FontRenderer, java.lang.String, int, int, int) void
   public void method_3553(@NotNull FontRenderer var1, @Nullable String var2, int var3, int var4, int var5) {
      var1.drawString(var2, var3, var4, var5);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.FontRenderer, java.lang.String, int, int, int, int, dev.nuker.pyro.f0G, int, int, boolean) void
   @JvmOverloads
   public void method_3554(@NotNull FontRenderer var1, @Nullable String var2, int var3, int var4, int var5, int var6, @NotNull f0G var7, int var8, int var9, boolean var10) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0J, net.minecraft.client.gui.FontRenderer, java.lang.String, int, int, int, int, dev.nuker.pyro.f0G, int, int, boolean, int, java.lang.Object) void
   public static void method_3555(f0J var0, FontRenderer var1, String var2, int var3, int var4, int var5, int var6, f0G var7, int var8, int var9, boolean var10, int var11, Object var12) {
      if ((var11 & 512) != 0) {
         var10 = false;
      }

      var0.method_3554(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.FontRenderer, java.lang.String) int
   public int method_3556(@NotNull FontRenderer var1, @Nullable String var2) {
      int var10000;
      if (var2 == null) {
         var10000 = 0;
      } else {
         int var3 = 0;
         boolean var4 = false;

         for(int var5 = 0; var5 < var2.length(); ++var5) {
            char var6 = var2.charAt(var5);
            int var7 = var1.getCharWidth(var6);
            if (var7 < 0 && var5 < var2.length() - 1) {
               ++var5;
               var6 = var2.charAt(var5);
               if (var6 != 'l' && var6 != 'L') {
                  if (var6 == 'r' || var6 == 'R') {
                     var4 = false;
                  }
               } else {
                  var4 = true;
               }

               var7 = 0;
            }

            var3 += var7;
            if (var4 && var7 > 0) {
               ++var3;
            }
         }

         var10000 = var3;
      }

      return var10000;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.FontRenderer, java.lang.String, int, int, int) void
   public void method_3557(@NotNull FontRenderer var1, @Nullable String var2, int var3, int var4, int var5) {
      var1.drawStringWithShadow(var2, (float)var3, (float)var4, var5);
   }

   static {
      f0J var0 = new f0J();
      field_2340 = var0;
   }

   // $FF: renamed from: c (int, int, int, int, int, int, int) void
   @JvmStatic
   public static void method_3558(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      Gui.drawRect(var0, var1, var0 + var2, var1 + var3, var4);
      Gui.drawRect(var0, var1, var0 + var6, var1 + var3, var5);
      Gui.drawRect(var0 + var2 - var6, var1, var0 + var2, var1 + var3, var5);
      Gui.drawRect(var0, var1, var0 + var2, var1 + var6, var5);
      Gui.drawRect(var0, var1 + var3 - var6, var0 + var2, var1 + var3, var5);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.FontRenderer, java.lang.String, int, int, int, int, dev.nuker.pyro.f0G, int, int) void
   @JvmOverloads
   public void method_3559(@NotNull FontRenderer var1, @Nullable String var2, int var3, int var4, int var5, int var6, @NotNull f0G var7, int var8, int var9) {
      method_3555(this, var1, var2, var3, var4, var5, var6, var7, var8, var9, false, 512, (Object)null);
   }
}
