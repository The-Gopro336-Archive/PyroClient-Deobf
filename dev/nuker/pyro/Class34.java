/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.nuker.pyro.Class17;
import dev.nuker.pyro.Class33;
import dev.nuker.pyro.Class36;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f03;
import dev.nuker.pyro.f67;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.gui.ClickGui;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.JvmField;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public class Class34 {
    @JvmField
    @NotNull
    public Map<String, Class36> Field4597 = new HashMap();
    public boolean Field4598;
    @JvmField
    @NotNull
    public static Class34 Field4599;
    public static Class17 Field4600;

    @NotNull
    public List Method6748() {
        List list = new ArrayList();
        for (Class36 class36 : this.Field4597.values()) {
            list.addAll(class36.Method6760());
        }
        list.remove(PyroStatic.Field6421);
        return list;
    }

    public void Method6749(@NotNull ClickGui clickGui) {
        for (Class36 class36 : this.Field4597.values()) {
            class36.Method6769(clickGui);
        }
        clickGui.Method4000();
    }

    public void Method6750(float f) {
        Vec3d vec3d = fdN.Method350(Objects.requireNonNull(Minecraft.getMinecraft().getRenderViewEntity()), f);
        for (Class36 class36 : this.Field4597.values()) {
            for (Module module : class36.Method6763()) {
                if (!((Boolean)module.Field5236.Method5264()).booleanValue()) continue;
                fe5.Field252.getBuffer().setTranslation(-vec3d.x, -vec3d.y, -vec3d.z);
                GlStateManager.pushMatrix();
                module.Method195(vec3d, f);
                GlStateManager.popMatrix();
            }
        }
        fe5.Field252.getBuffer().setTranslation(0.0, 0.0, 0.0);
        fe5.Field252.Method401();
    }

    public void Method6751() {
        Pyro.Method8978().Method7915(this);
    }

    public void Method6752(int n) {
        for (Class36 class36 : this.Field4597.values()) {
            for (Module module : class36.Method6763()) {
                module.Method7268(n);
            }
        }
    }

    public void Method6753(@NotNull Module module) {
        f03.Field5394.Method7611(module);
    }

    @NotNull
    public Class36 Method6754(@NotNull String string) {
        return this.Field4597.computeIfAbsent(string, Class33.Field4580);
    }

    public void Method6755() {
        if (this.Field4598) {
            return;
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Object object = this.Field4597;
        boolean bl = false;
        for (Map.Entry<String, Class36> entry : object.entrySet()) {
            Object object22 = entry;
            boolean bl2 = false;
            object = object22.getKey();
            object22 = entry;
            bl2 = false;
            Class36 class36 = object22.getValue();
            for (Object object22 : class36.Method6763()) {
                StringBuilder stringBuilder;
                File file;
                FileWriter fileWriter;
                JsonObject jsonObject = new JsonObject();
                jsonObject.add(((Module)object22).Method7279(), (JsonElement)((Module)object22).Method7255());
                File file2 = Pyro.Field6178;
                file2.mkdirs();
                f67 f672 = f67.Field4191;
                File file3 = f672.Method5829();
                file3.mkdirs();
                FileWriter fileWriter2 = fileWriter;
                FileWriter fileWriter3 = fileWriter;
                File file4 = file;
                File file5 = file;
                f67 f673 = f67.Field4191;
                File file6 = f673.Method5829();
                StringBuilder stringBuilder2 = stringBuilder;
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2();
                Object object3 = object22;
                String string = ((Module)object3).Method7265();
                StringBuilder stringBuilder4 = stringBuilder3.append(string);
                String string2 = ".json";
                StringBuilder stringBuilder5 = stringBuilder4.append(string2);
                String string3 = stringBuilder5.toString();
                file4(file6, string3);
                boolean bl3 = false;
                fileWriter2(file5, bl3);
                FileWriter fileWriter4 = fileWriter3;
                Gson gson2 = gson;
                JsonElement jsonElement = (JsonElement)jsonObject;
                Appendable appendable = fileWriter4;
                gson2.toJson(jsonElement, appendable);
                FileWriter fileWriter5 = fileWriter4;
                try {
                    fileWriter5.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
    }

    @NotNull
    public List Method6756() {
        List list = new ArrayList();
        for (Class36 class36 : this.Field4597.values()) {
            list.addAll(class36.Method6763());
        }
        return list;
    }

    public void Method6757(int n) {
        for (Class36 class36 : this.Field4597.values()) {
            for (Module module : class36.Method6763()) {
                module.Method7253(n);
            }
        }
    }

    static {
        Field4600 = new Class17(null);
        Field4599 = new Class34();
    }

    /*
     * Exception decompiling
     */
    public void Method6758() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [41[DOLOOP]], but top level block is 42[UNCONDITIONALDOLOOP]
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
}

