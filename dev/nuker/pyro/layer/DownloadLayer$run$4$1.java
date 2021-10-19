/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.launcher.LibraryCache;
import dev.nuker.pyro.launcher.LibraryCache$DownloadFile;
import java.util.function.Consumer;

public class DownloadLayer$run$4$1 implements Consumer {
   public static DownloadLayer$run$4$1 INSTANCE = new DownloadLayer$run$4$1();

   public void accept(LibraryCache$DownloadFile it) {
      LibraryCache.initLibrary(it.save);
   }

   public void accept(Object var1) {
      this.accept((LibraryCache$DownloadFile)var1);
   }
}
