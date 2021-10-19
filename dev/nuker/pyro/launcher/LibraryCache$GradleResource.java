/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import java.io.File;
import java.net.URL;

public class LibraryCache$GradleResource {
   public String url;
   public String pkg;
   public String name;
   public String version;

   public String getGradleString() {
      return this.pkg + ":" + this.name + ":" + this.version;
   }

   public String toString() {
      return String.format("%s (Resource: %s URL: '%s', Package: '%s', Name: '%s', Version: '%s')", this.getDownloadUrl(), this.getGradleString(), this.url, this.pkg, this.name, this.version);
   }

   public LibraryCache$GradleResource(String resource) {
      this(resource.split("\\|")[0], resource.split("\\|")[1]);
   }

   public LibraryCache$DownloadFile getDownloadFile() {
      return new LibraryCache$DownloadFile(this.getDownloadUri(), this.getLocalFile());
   }

   public LibraryCache$GradleResource(String url, String resource) {
      this.url = url;
      this.pkg = resource.substring(0, resource.indexOf(":"));
      resource = resource.substring(resource.indexOf(":") + 1);
      this.name = resource.substring(0, resource.indexOf(":"));
      resource = resource.substring(resource.indexOf(":") + 1);
      this.version = resource;
   }

   public String getDownloadUrl() {
      return String.format("%s/%s/%s/%s/%s-%s.jar", this.url, this.pkg.replace(".", "/"), this.name, this.version, this.name, this.version);
   }

   public URL getDownloadUri() {
      return new URL(this.getDownloadUrl());
   }

   public File getLocalFile() {
      return new File(String.format("pyro/libraries/%s/%s/%s.jar", this.pkg, this.name, this.version));
   }

   public LibraryCache$GradleResource(String url, String pkg, String name, String version) {
      this.url = url;
      this.pkg = pkg;
      this.name = name;
      this.version = version;
   }
}
