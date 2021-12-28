/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 */
package dev.nuker.pyro.launcher;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Config {
    public static transient Config Field7637 = new Config();
    public String Field7638 = null;
    public String Field7639 = null;
    public String Field7640 = null;

    public static void Method12580() {
        try {
            if (new File("pyro/launcher.json").exists()) {
                Gson gson = new Gson();
                FileReader reader = new FileReader("pyro/launcher.json");
                Field7637 = (Config)gson.fromJson((Reader)reader, Config.class);
                reader.close();
            } else {
                Field7637 = new Config();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Method12581() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("pyro/launcher.json");
            gson.toJson((Object)Field7637, (Appendable)writer);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

