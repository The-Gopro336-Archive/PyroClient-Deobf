/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f4Q extends fdZ {
   // $FF: renamed from: c java.lang.String
   public String field_1091;
   // $FF: renamed from: c float
   public float field_1092;
   // $FF: renamed from: 0 float
   public float field_1093;
   // $FF: renamed from: 1 float
   public float field_1094;
   // $FF: renamed from: 2 float
   public float field_1095;
   // $FF: renamed from: c java.util.List
   public List field_1096 = new ArrayList();
   // $FF: renamed from: c boolean
   public boolean field_1097 = false;
   // $FF: renamed from: 3 float
   public float field_1098;
   // $FF: renamed from: 0 boolean
   public boolean field_1099 = false;
   // $FF: renamed from: 0 java.lang.String
   public String field_1100 = null;

   // $FF: renamed from: 3 () boolean
   public boolean method_1619() {
      return this.field_1099;
   }

   // $FF: renamed from: 0 (float) void
   public void method_1620(float var1) {
      this.field_1094 = var1;
   }

   // $FF: renamed from: 0 () float
   public float method_1621() {
      return this.field_1098;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_1623(boolean var1) {
      this.field_1099 = var1;
   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_1624(String var1) {
      this.field_1091 = var1;
   }

   // $FF: renamed from: 2 () float
   public float method_1625() {
      return this.field_1092;
   }

   public f4Q(String var1, float var2, float var3, float var4, float var5) {
      this.field_1091 = var1;
      this.field_1092 = var2;
      this.field_1093 = var3;
      this.field_1094 = var4;
      this.field_1095 = var5;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_1626(List var1) {
      this.field_1096 = var1;
   }

   // $FF: renamed from: c (float, float, int) void
   public void method_1627(float var1, float var2, int var3) {
      this.field_1094 = var1;

      f4Q var5;
      for(Iterator var4 = this.field_1096.iterator(); var4.hasNext(); var5.method_1627(this.field_1094 - (var3 > 1 ? var2 : 0.0F), var2, var3 + 1)) {
         var5 = (f4Q)var4.next();
         if (var3 > 1) {
            var5.field_1094 = this.field_1094 - var2;
            var5.field_1092 = var2 * (float)var3;
         }
      }

   }

   // $FF: renamed from: 1 (java.lang.String) float
   public float method_1628(String var1) {
      return (Boolean)PyroStatic.field_2484.method_971().c() ? (float)class_59.field_2713.field_2715.getStringWidth(var1) : (float)c.fontRenderer.getStringWidth(var1);
   }

   public static void meth0(String var0, float var1, float var2, int var3) {
      if ((Boolean)PyroStatic.field_2484.method_971().c()) {
         class_59.field_2713.field_2715.drawString(var0, var1, var2, var3);
      } else {
         c.fontRenderer.drawString(var0, (int)var1, (int)var2, var3);
      }

   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_1629(String var1) {
      this.field_1100 = var1;
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      return this.field_1091;
   }

   // $FF: renamed from: 5 () java.util.List
   public List method_1631() {
      return this.field_1096;
   }

   // $FF: renamed from: c (char, int) void
   public void method_1632(char var1, int var2) {
   }

   // $FF: renamed from: 1 () java.lang.String
   public String method_1633() {
      return this.field_1100;
   }

   // $FF: renamed from: 9 () boolean
   public boolean method_1634() {
      return this.field_1097;
   }

   // $FF: renamed from: c () float
   public float method_1635() {
      return this.field_1094;
   }

   public float meth4() {
      return this.field_1095;
   }

   // $FF: renamed from: 1 (float) void
   public void method_1636(float var1) {
      this.field_1095 = var1;
   }

   // $FF: renamed from: c (float) void
   public void method_1637(float var1) {
      this.field_1098 = var1;
   }

   // $FF: renamed from: 6 () float
   public float method_1638() {
      return (Boolean)PyroStatic.field_2484.method_971().c() ? (float)class_59.field_2713.field_2715.getHeight() : (float)c.fontRenderer.FONT_HEIGHT;
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      return false;
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1640(int var1, int var2, int var3) {
   }

   // $FF: renamed from: 7 () float
   public float method_1641() {
      return this.field_1093;
   }

   // $FF: renamed from: c (boolean) void
   public void method_1642(boolean var1) {
      this.field_1097 = var1;
   }

   // $FF: renamed from: 2 (float) void
   public void method_1643(float var1) {
      this.field_1092 = var1;
   }

   // $FF: renamed from: c (java.lang.String, float, float, int) void
   public static void method_1644(String var0, float var1, float var2, int var3) {
      if ((Boolean)PyroStatic.field_2484.method_971().c()) {
         class_59.field_2713.field_2715.drawStringWithShadow(var0, var1, var2, var3);
      } else {
         c.fontRenderer.drawStringWithShadow(var0, var1, var2, var3);
      }

   }

   // $FF: renamed from: 3 (float) void
   public void method_1645(float var1) {
      this.field_1093 = var1;
   }
}
