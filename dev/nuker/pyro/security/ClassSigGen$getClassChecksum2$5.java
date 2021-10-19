/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.util.Comparator;

public class ClassSigGen$getClassChecksum2$5 implements Comparator {
   public static ClassSigGen$getClassChecksum2$5 INSTANCE = new ClassSigGen$getClassChecksum2$5();

   public int compare(Object var1, Object var2) {
      return this.compare((String)var1, (String)var2);
   }

   public int compare(String a, String b) {
      return a.compareTo(b);
   }
}
