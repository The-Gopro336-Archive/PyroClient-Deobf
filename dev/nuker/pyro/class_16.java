/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLCallHook;

// $FF: renamed from: dev.nuker.pyro.f7
public class class_16 implements IFMLCallHook {
   public Object call() {
      return this.method_3408();
   }

   public void injectData(Map var1) {
      ClassLoader var2 = (ClassLoader)var1.get("classLoader");

      try {
         var2.loadClass("net.shadowfacts.forgelin.KotlinAdapter");
      } catch (ClassNotFoundException var4) {
         throw new RuntimeException("Couldn't find Forgelin langague adapter, this shouldn't be happening", var4);
      }
   }

   // $FF: renamed from: c () java.lang.Void
   public Void method_3408() {
      return null;
   }
}
