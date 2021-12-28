/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.launcher.LibraryCache$DownloadFile$DownloadThread
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.launcher.LibraryCache$DownloadFile;
import java.io.File;
import java.net.URL;
import java.util.function.Consumer;

public class LibraryCache$DownloadFile {
    public URL Field2793;
    public File Field2794;
    public Consumer<LibraryCache$DownloadFile> Field2795 = null;
    public boolean Field2796;
    public boolean Field2797 = false;
    public boolean Field2798 = false;
    public long Field2799 = (long)242497833 ^ 0xE743929L;
    public long Field2800 = (long)-1731744961 ^ 0xFFFFFFFF98C7AB3FL;

    public LibraryCache$DownloadFile(URL url, File save) {
        this.Field2793 = url;
        this.Field2794 = save;
        this.Field2796 = save.exists();
    }

    public boolean Method4619() {
        return this.Field2797;
    }

    public boolean Method4620() {
        return this.Field2796;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean Method4621(LibraryCache$DownloadFile libraryCache$DownloadFile, boolean bl) {
        LibraryCache$DownloadFile x0;
        void x1;
        x0.Field2796 = x1;
        return x0.Field2796;
    }

    public void Method4622() {
        if (!this.Method4620()) {
            new DownloadThread(this).start();
        } else {
            this.Field2795.accept(this);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static boolean Method4623(LibraryCache$DownloadFile libraryCache$DownloadFile, boolean bl) {
        LibraryCache$DownloadFile x0;
        void x1;
        x0.Field2797 = x1;
        return x0.Field2797;
    }

    public boolean Method4624() {
        return this.Field2798;
    }
}

