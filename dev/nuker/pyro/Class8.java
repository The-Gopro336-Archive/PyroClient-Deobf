/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonObject
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Class9;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f44;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f5A;
import dev.nuker.pyro.f5B;
import dev.nuker.pyro.f5C;
import dev.nuker.pyro.f5D;
import dev.nuker.pyro.f5G;
import dev.nuker.pyro.f5H;
import dev.nuker.pyro.f5I;
import dev.nuker.pyro.f5J;
import dev.nuker.pyro.f5K;
import dev.nuker.pyro.f5L;
import dev.nuker.pyro.f5O;
import dev.nuker.pyro.f5P;
import dev.nuker.pyro.f5Q;
import dev.nuker.pyro.f5R;
import dev.nuker.pyro.f5S;
import dev.nuker.pyro.f5U;
import dev.nuker.pyro.f5V;
import dev.nuker.pyro.f5X;
import dev.nuker.pyro.f5Z;
import dev.nuker.pyro.f5j;
import dev.nuker.pyro.f5k;
import dev.nuker.pyro.f5m;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5r;
import dev.nuker.pyro.f5u;
import dev.nuker.pyro.f5v;
import dev.nuker.pyro.f5w;
import dev.nuker.pyro.f5y;
import dev.nuker.pyro.f5z;
import dev.nuker.pyro.f66;
import dev.nuker.pyro.f67;
import dev.nuker.pyro.f6c;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;

public class Class8
extends fdZ {
    public List<f5k> Field5269 = new ArrayList<f5k>();
    public f5m[] Field5270 = new f5m[4];
    public Map<Module, f5k> Field5271 = new HashMap<Module, f5k>();
    public List<f5u> Field5272 = new CopyOnWriteArrayList<f5u>();
    public int Field5273 = 0;
    public f5w Field5274;
    public boolean Field5275 = false;
    public int Field5276 = 0;
    public Timer Field5277 = new Timer();
    public static Class8 Field5278 = new Class8();

    public Class8() {
        this.Field5277.schedule((TimerTask)new Class9(), 0L, 16L);
    }

    public void Method5760(@NotNull Module module) {
        if (((Boolean)module.Field5236.Method5264()).booleanValue() && !this.Field5271.containsKey(module)) {
            f5r f5r2 = new f5r(module);
            this.Field5271.put(module, f5r2);
            this.Field5274.Field2980.Method4826(f5r2);
        } else {
            f5k f5k2 = null;
            if (this.Field5271.containsKey(module)) {
                f5k2 = this.Field5271.get(module);
            }
            if (f5k2 != null) {
                f5k2.Field3022 = () -> this.Method7313(module);
                f5k2.Method731();
            }
        }
        this.Field5274.Field2980.Method4829();
    }

    public void Method462() {
        for (f5m f5m2 : this.Field5270) {
            f5m2.Method462();
        }
        ScaledResolution scaledResolution = new ScaledResolution(Field313);
        this.Field5272.forEach(arg_0 -> Class8.Method7319(scaledResolution, arg_0));
    }

    public void Method7302(ScaledResolution scaledResolution, int n, int n2, boolean bl) {
        if (Class8.Field313.world == null || Class8.Field313.player == null) {
            return;
        }
        for (f5m f5m2 : this.Field5270) {
            f5m2.Method4835(scaledResolution, n, n2, bl);
        }
        this.Field5272.forEach(arg_0 -> Class8.Method7307(scaledResolution, n, n2, arg_0));
    }

    public List Method7303() {
        return this.Field5269;
    }

    public void Method7304(@NotNull Module module) {
        if (this.Field5271.containsKey(module)) {
            ((f5G)this.Field5271.get((Object)module).Field3010).Method5736(module.Method7260());
            this.Field5274.Field2980.Method4829();
        }
    }

    public void Method7305() {
        for (f5m f5m2 : this.Field5270) {
            f5m2.Method4825();
        }
        if (Class8.Field313.currentScreen instanceof GuiChat) {
            if (this.Field5276 < 14) {
                ++this.Field5276;
            }
        } else if (this.Field5276 > 0) {
            --this.Field5276;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @f0g
    @LauncherEventHide
    public void Method7306(f44 f442) {
        if (f442.Method5594() && !this.Field5271.containsKey(f442.Method5595())) {
            f5r f5r2 = new f5r(f442.Method5595());
            this.Field5271.put(f442.Method5595(), f5r2);
            this.Field5274.Field2980.Method4826(f5r2);
            return;
        }
        f5k f5k2 = null;
        if (this.Field5271.containsKey(f442.Method5595())) {
            f5k2 = this.Field5271.get(f442.Method5595());
        }
        if (f5k2 == null) return;
        f5k2.Field3022 = () -> this.Method7317(f442);
        f5k2.Method731();
    }

    public static void Method7307(ScaledResolution scaledResolution, int n, int n2, f5u f5u2) {
        if (f5u2.Method4913() == null && f5u2.Method4907()) {
            f5u2.Method4904(scaledResolution, n, n2);
        }
    }

    public void Method7308(@NotNull Module module) {
        if (this.Field5271.containsKey(module)) {
            ((f5G)this.Field5271.get((Object)module).Field3010).Method5736(module.Method7260());
            this.Field5274.Field2980.Method4829();
        }
    }

    public void Method7309(f5u f5u2, int n) {
        this.Field5272.remove(f5u2);
        this.Method7322(n).Method4833(f5u2, false);
    }

    public f5k Method7310(f5k f5k2) {
        f5q f5q2 = f5k2.Field3010;
        File file = new File(Pyro.Field6179, f5q2.Method4955() + ".json");
        if (file.exists()) {
            FileReader fileReader;
            f5q f5q3 = f5q2;
            Gson gson = Pyro.Field6181;
            FileReader fileReader2 = fileReader;
            FileReader fileReader3 = fileReader;
            File file2 = file;
            fileReader2(file2);
            Class<JsonObject> class_ = JsonObject.class;
            Object object = gson.fromJson((Reader)fileReader3, class_);
            JsonObject jsonObject = (JsonObject)object;
            try {
                f5q3.Method4956(jsonObject);
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        this.Field5269.add(f5k2);
        return f5k2;
    }

    public void Method7311() {
        Pyro.Method8978().Method7915(this);
    }

    /*
     * Exception decompiling
     */
    public void Method7312() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[TRYBLOCK]], but top level block is 83[WHILELOOP]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static void Method4825() {
        Class8.Field5278.Field5275 = false;
        Class8.Field5278.Field5269.clear();
        Class8.Field5278.Field5272.clear();
        Field5278.Method455();
        Class8.Field5278.Field5275 = false;
        Field5278.Method7312();
        Field5278.Method461();
        Field5278.Method4829();
        Class8.Field5278.Field5275 = true;
    }

    public void Method865() {
        if (Class8.Field313.gameSettings.showDebugInfo || Class8.Field313.currentScreen instanceof f5j) {
            return;
        }
        ScaledResolution scaledResolution = new ScaledResolution(Field313);
        this.Method7302(scaledResolution, -420, -420, false);
    }

    public void Method7313(Module module) {
        this.Field5271.remove(module);
    }

    public void Method7314(f5u f5u2) {
        if (f5u2.Method4913() != null) {
            f5u2.Method4913().Method4831(f5u2);
            f5u2.Method4902(null);
            this.Field5272.add(f5u2);
        }
    }

    public Map Method7315(Map map, f5k f5k2) {
        map.put("visible", f5k2.Method4907());
        map.put("name", f5k2.Method4911());
        return map;
    }

    public void Method461() {
        this.Method7320().forEach(Class8::Method4834);
    }

    public void Method7316(Module module) {
        f5r f5r2 = new f5r(module);
        this.Field5271.put(module, f5r2);
        this.Field5274.Field2980.Method4826(f5r2);
    }

    public void Method7317(f44 f442) {
        this.Field5271.remove(f442.Method5595());
    }

    @f0g
    @LauncherEventHide
    public void Method498(f4t f4t2) {
        for (f5m f5m2 : this.Field5270) {
            for (f5k f5k2 : f5m2.Method4836()) {
                if (!(f5k2 instanceof f5u)) continue;
                ((f5u)f5k2).Method455();
            }
        }
        for (f5k f5k3 : this.Field5272) {
            if (!(f5k3 instanceof f5u)) continue;
            ((f5u)f5k3).Method455();
        }
    }

    public void Method455() {
        this.Field5270 = new f5m[4];
        this.Field5270[0] = new f5m(0);
        this.Field5270[1] = new f5m(1);
        this.Field5270[2] = new f5m(2);
        this.Field5270[3] = new f5m(3);
        this.Field5274 = new f5w(this.Field5273);
        this.Field5270[0].Method4833(this.Method7310(new f5u("ArrayList", "General", this.Field5274)), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("FPS", "General", new f5C())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("Speed", "Misc", new f5S())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("Chests", "Misc", new f5y())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("TPS", "General", new f5U())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("ServerBrand", "Misc", new f5Q())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("Elytras", "Misc", new f5B())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("Ping", "General", new f5J())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("TargetInfo", "Combat", new f5V())), false);
        this.Field5270[1].Method4833(this.Method7310(new f5u("Notifications", "General", new f5H())), false);
        this.Field5270[2].Method4833(this.Method7310(new f5u("Direction", "General", new f5A())), false);
        this.Field5270[2].Method4833(this.Method7310(new f5u("Coords", "General", new f5z())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("Watermark", "Misc", new f6c())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("Armor", "Combat", new f5v())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("PlayerInfo", "General", new f5K())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("Inventory", "General", new f5D())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("PotionEffects", "General", new f5O(3))), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("PVPInfo", "Combat", new f5I())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("ServerNotResponding", "General", new f5R())), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("TextRadar", "General", (f5q)new f5X(3), true)), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("PlayerModel", "General", (f5q)new f5L(), true)), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("PvPResources", "Combat", (f5q)new f5P(), true)), false);
        this.Field5270[3].Method4833(this.Method7310(new f5u("TrueDurability", "General", (f5q)new f5Z(), true)), false);
        this.Field5275 = true;
    }

    public void Method4829() {
        this.Field5271.clear();
        this.Field5274.Field2980.Method461();
        Class34.Field4599.Method6748().forEach(this::Method7316);
    }

    public void Method4810(int n, int n2, int n3) {
        this.Field5272.forEach(arg_0 -> Class8.Method7318(n, n2, n3, arg_0));
        for (f5m f5m2 : this.Field5270) {
            f5m2.Method4827(n, n2, n3);
        }
    }

    public static void Method7318(int n, int n2, int n3, f5u f5u2) {
        f5u2.Method4810(n, n2, n3);
    }

    public static void Method4834(f5k f5k2) {
        Pyro.Field6183.Method7921(f5k2.Field3010);
        Pyro.Field6183.Method7915(f5k2.Field3010);
    }

    public static void Method7319(ScaledResolution scaledResolution, f5u f5u2) {
        f5u2.Method4899(scaledResolution);
    }

    public List Method7320() {
        return this.Field5269;
    }

    public void Method7321() {
        File file;
        FileWriter fileWriter;
        Object object;
        if (!this.Field5275) {
            return;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<f5k> arrayList2 = new ArrayList<f5k>();
        int n = this.Field5270.length;
        for (int i = 0; i < n; ++i) {
            object = this.Field5270[i];
            CopyOnWriteArrayList<f5k> copyOnWriteArrayList = ((f5m)object).Field2944;
            for (int j = 0; j < copyOnWriteArrayList.size(); ++j) {
                f5k f5k2 = copyOnWriteArrayList.get(j);
                arrayList2.add(f5k2);
                HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                this.Method7315(hashMap, f5k2);
                hashMap.put("corner", i);
                arrayList.add(hashMap);
            }
        }
        for (f5u f5u2 : this.Field5272) {
            if (arrayList2.contains(f5u2)) continue;
            arrayList2.add(f5u2);
            object = new HashMap();
            this.Method7315((Map)object, f5u2);
            object.put("x", Float.valueOf(f5u2.Method4906()));
            object.put("y", Float.valueOf(f5u2.Method4898()));
            arrayList.add(object);
        }
        FileWriter fileWriter2 = fileWriter;
        FileWriter fileWriter3 = fileWriter;
        File file2 = file;
        File file3 = file;
        f67 f672 = f67.Field4191;
        f66 f662 = f672.Method5824();
        File file4 = f662.Method5809();
        String string = "hud.json";
        file2(file4, string);
        fileWriter2(file3);
        FileWriter fileWriter4 = fileWriter3;
        Gson gson = Pyro.Field6181;
        ArrayList<Object> arrayList3 = arrayList;
        FileWriter fileWriter5 = fileWriter4;
        gson.toJson(arrayList3, (Appendable)fileWriter5);
        Object object2 = fileWriter4;
        try {
            ((OutputStreamWriter)object2).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public f5m Method7322(int n) {
        return this.Field5270[n];
    }
}

