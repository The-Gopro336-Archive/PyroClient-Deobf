/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.launcher.LibraryCache.DownloadFile.DownloadThread;
import java.io.File;
import java.net.URL;
import java.util.function.Consumer;

public class LibraryCache$DownloadFile {
   public URL url;
   public File save;
   public Consumer completionRunnable = null;
   public boolean downloaded;
   public boolean downloading = false;
   public boolean cantDownload = false;
   public long progress = (long)242497833 ^ 242497833L;
   public long byteCount = (long)-1731744961 ^ -1731744961L;

   public LibraryCache$DownloadFile(URL url, File save) {
      this.url = url;
      this.save = save;
      this.downloaded = save.exists();
   }

   public boolean isDownloading() {
      return this.downloading;
   }

   public boolean isDownloaded() {
      return this.downloaded;
   }

   public static boolean access$102(LibraryCache$DownloadFile x0, boolean x1) {
      return x0.downloaded = x1;
   }

   public void download() {
      if (!this.isDownloaded()) {
         (new DownloadThread(this)).start();
      } else {
         this.completionRunnable.accept(this);
      }

   }

   public static boolean access$002(LibraryCache$DownloadFile x0, boolean x1) {
      return x0.downloading = x1;
   }

   public boolean cantDownload() {
      return this.cantDownload;
   }
}
