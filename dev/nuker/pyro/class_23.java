/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

// $FF: renamed from: dev.nuker.pyro.fP
public class class_23 implements Comparator {
   public int compare(Object var1, Object var2) {
      boolean var3 = false;
      f0w var4 = (f0w)var1;
      boolean var5 = false;
      CharSequence var6 = (CharSequence)var4.method_3315();
      boolean var7 = false;
      int var8 = 0;
      CharSequence var9 = var6;

      int var10;
      char var11;
      boolean var13;
      for(var10 = 0; var10 < var9.length(); ++var10) {
         var11 = var9.charAt(var10);
         var13 = false;
         if (var11 == '.') {
            ++var8;
         }
      }

      Comparable var10000 = (Comparable)var8;
      var4 = (f0w)var2;
      Comparable var14 = var10000;
      var5 = false;
      var6 = (CharSequence)var4.method_3315();
      var7 = false;
      var8 = 0;
      var9 = var6;

      for(var10 = 0; var10 < var9.length(); ++var10) {
         var11 = var9.charAt(var10);
         var13 = false;
         if (var11 == '.') {
            ++var8;
         }
      }

      Integer var15 = var8;
      return ComparisonsKt.compareValues(var14, (Comparable)var15);
   }
}
