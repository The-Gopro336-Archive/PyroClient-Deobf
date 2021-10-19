/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import com.formdev.flatlaf.FlatDarculaLaf;
import dev.nuker.pyro.launcher.LoaderGui;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public class SecondLayer {
   public static SecondLayer INSTANCE;

   static {
      SecondLayer var0 = new SecondLayer();
      INSTANCE = var0;
   }

   @JvmStatic
   public static void run(@NotNull DataInputStream si, @NotNull DataOutputStream so) {
      FlatDarculaLaf.install();
      LoaderGui gui = new LoaderGui();
      ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new SecondLayer$run$1(so, gui, si)), 30, (Object)null);
   }
}
