/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f67;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.concurrent.ConcurrentLinkedQueue;

public class f03 {
    public ConcurrentLinkedQueue<Module> Field5392 = new ConcurrentLinkedQueue();
    public ConcurrentLinkedQueue<f5q> Field5393 = new ConcurrentLinkedQueue();
    public static f03 Field5394 = new f03();

    public void Method7610(f5q f5q2) {
        if (!this.Field5393.contains(f5q2)) {
            this.Field5393.add(f5q2);
        }
    }

    public void Method7611(Module module) {
        if (!this.Field5392.contains(module)) {
            this.Field5392.add(module);
        }
    }

    public void Method7612() {
        Object object6;
        JsonObject jsonObject;
        Object object2;
        Gson gson;
        Pyro.Field6178.mkdirs();
        f67.Field4191.Method5829().mkdirs();
        Pyro.Field6179.mkdirs();
        if (!this.Field5392.isEmpty()) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            while (!this.Field5392.isEmpty()) {
                StringBuilder stringBuilder;
                File file;
                FileWriter fileWriter;
                object2 = this.Field5392.poll();
                jsonObject = new JsonObject();
                jsonObject.add(((Module)object2).Method7279(), (JsonElement)((Module)object2).Method7255());
                FileWriter fileWriter2 = fileWriter;
                FileWriter fileWriter3 = fileWriter;
                File file2 = file;
                File file3 = file;
                f67 f672 = f67.Field4191;
                File file4 = f672.Method5829();
                StringBuilder stringBuilder2 = stringBuilder;
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2();
                Object object3 = object2;
                String string = ((Module)object3).Method7265();
                StringBuilder stringBuilder4 = stringBuilder3.append(string);
                String string2 = ".json";
                StringBuilder stringBuilder5 = stringBuilder4.append(string2);
                String string3 = stringBuilder5.toString();
                file2(file4, string3);
                boolean bl = false;
                fileWriter2(file3, bl);
                object6 = fileWriter3;
                Gson gson2 = gson;
                JsonObject jsonObject2 = jsonObject;
                Object object4 = object6;
                gson2.toJson((JsonElement)jsonObject2, (Appendable)object4);
                Object object5 = object6;
                try {
                    ((OutputStreamWriter)object5).close();
                }
                catch (Exception object6) {
                    ((Throwable)object6).printStackTrace();
                }
            }
        }
        if (!this.Field5393.isEmpty()) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            while (!this.Field5393.isEmpty()) {
                StringBuilder stringBuilder;
                File file;
                FileWriter fileWriter;
                object2 = this.Field5393.poll();
                jsonObject = ((f5q)object2).Method4958();
                FileWriter fileWriter4 = fileWriter;
                FileWriter fileWriter5 = fileWriter;
                File file5 = file;
                File file6 = file;
                File file7 = Pyro.Field6179;
                StringBuilder stringBuilder6 = stringBuilder;
                StringBuilder stringBuilder7 = stringBuilder;
                stringBuilder6();
                Object object7 = object2;
                String string = ((f5q)object7).Method4955();
                StringBuilder stringBuilder8 = stringBuilder7.append(string);
                String string4 = ".json";
                StringBuilder stringBuilder9 = stringBuilder8.append(string4);
                String string5 = stringBuilder9.toString();
                file5(file7, string5);
                boolean bl = false;
                fileWriter4(file6, bl);
                object6 = fileWriter5;
                Gson gson3 = gson;
                JsonObject jsonObject3 = jsonObject;
                Object object8 = object6;
                gson3.toJson((JsonElement)jsonObject3, (Appendable)object8);
                Object object9 = object6;
                try {
                    ((OutputStreamWriter)object9).close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

