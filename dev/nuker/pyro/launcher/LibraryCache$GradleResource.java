/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.launcher.LibraryCache$DownloadFile;
import java.io.File;
import java.net.URL;

public class LibraryCache$GradleResource {
    public String Field435;
    public String Field436;
    public String Field437;
    public String Field438;

    public String Method648() {
        return this.Field436 + ":" + this.Field437 + ":" + this.Field438;
    }

    public String toString() {
        return String.format("%s (Resource: %s URL: '%s', Package: '%s', Name: '%s', Version: '%s')", this.Method650(), this.Method648(), this.Field435, this.Field436, this.Field437, this.Field438);
    }

    public LibraryCache$GradleResource(String resource) {
        this(resource.split("\\|")[0], resource.split("\\|")[1]);
    }

    public LibraryCache$DownloadFile Method649() {
        return new LibraryCache$DownloadFile(this.Method651(), this.Method652());
    }

    public LibraryCache$GradleResource(String url, String resource) {
        this.Field435 = url;
        this.Field436 = resource.substring(0, resource.indexOf(":"));
        resource = resource.substring(resource.indexOf(":") + 1);
        this.Field437 = resource.substring(0, resource.indexOf(":"));
        this.Field438 = resource = resource.substring(resource.indexOf(":") + 1);
    }

    public String Method650() {
        return String.format("%s/%s/%s/%s/%s-%s.jar", this.Field435, this.Field436.replace(".", "/"), this.Field437, this.Field438, this.Field437, this.Field438);
    }

    public URL Method651() {
        return new URL(this.Method650());
    }

    public File Method652() {
        return new File(String.format("pyro/libraries/%s/%s/%s.jar", this.Field436, this.Field437, this.Field438));
    }

    public LibraryCache$GradleResource(String url, String pkg, String name, String version) {
        this.Field435 = url;
        this.Field436 = pkg;
        this.Field437 = name;
        this.Field438 = version;
    }
}

