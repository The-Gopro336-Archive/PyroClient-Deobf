/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.security;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Unsafe;

public class StructDissasembler {
    @Nullable
    public static Method Field7418;
    @Nullable
    public static ClassLoader Field7419;
    public static StructDissasembler Field7420;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public static Unsafe Method12335() {
        TypeCastException typeCastException;
        Field f;
        Class<Unsafe> class_;
        boolean $i$f$getUnsafe = false;
        try {
            class_ = Unsafe.class;
        }
        catch (Exception e) {
            throw (Throwable)new RuntimeException(e);
        }
        String string = "theUnsafe";
        Field field = class_.getDeclaredField(string);
        Field field2 = f = field;
        boolean bl = true;
        field2.setAccessible(bl);
        Field field3 = f;
        Object v6 = null;
        Object object = field3.get(v6);
        Object object2 = object;
        if (object != null) return (Unsafe)object2;
        TypeCastException typeCastException2 = typeCastException;
        TypeCastException typeCastException3 = typeCastException;
        String string2 = "null cannot be cast to non-null type sun.misc.Unsafe";
        typeCastException2(string2);
        throw typeCastException3;
    }

    /*
     * Exception decompiling
     */
    @JvmStatic
    public static void Method12336() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [24[TRYBLOCK], 37[TRYBLOCK]], but top level block is 40[TRYBLOCK]
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

    public static void Method12337(@Nullable Method method) {
        Method method2;
        Field7418 = method2;
    }

    /*
     * Exception decompiling
     */
    @JvmStatic
    public static boolean Method12338() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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

    /*
     * Exception decompiling
     */
    @JvmStatic
    public static void Method12339() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [24[TRYBLOCK], 37[TRYBLOCK]], but top level block is 40[TRYBLOCK]
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

    static {
        StructDissasembler structDissasembler;
        Field7420 = structDissasembler = new StructDissasembler();
    }

    /*
     * Exception decompiling
     */
    @JvmStatic
    public static int Method12340() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [42[TRYBLOCK]], but top level block is 165[CATCHBLOCK]
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

    @Nullable
    public static Method Method12341() {
        return Field7418;
    }

    public static void Method12342(@Nullable ClassLoader classLoader) {
        ClassLoader classLoader2;
        Field7419 = classLoader2;
    }

    @JvmStatic
    public static void Method12343() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static long Method12344(@NotNull String var0) {
        $i$f$getSymbol = false;
        v0 = StructDissasembler.Method12341();
        if (v0 == null) {
            Intrinsics.Method6551();
        }
        v1 = v0.invoke(null, new Object[]{StructDissasembler.Method12347(), symbol});
        if (v1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
        }
        address = (Long)v1;
        if (address == ((long)-1459845692 ^ -1459845692L)) {
            throw (Throwable)new NoSuchElementException(symbol);
        }
        $i$f$getUnsafe = false;
        try {
            v2 = Unsafe.class.getDeclaredField("theUnsafe");
        }
        catch (Exception e$iv) {
            throw (Throwable)new RuntimeException(e$iv);
        }
        v3 = f$iv = v2;
        v4 = true;
        v3.setAccessible(v4);
        v5 = f$iv;
        v6 = null;
        v7 = v5.get(v6);
        v8 = v7;
        if (v7 != null) ** GOTO lbl39
        v9 = v10;
        v11 = v10;
        v12 = "null cannot be cast to non-null type sun.misc.Unsafe";
        v9(v12);
        throw v11;
lbl39:
        // 1 sources

        var5_4 = (Unsafe)v8;
        return var5_4.getLong(address);
    }

    @JvmStatic
    public static void Method12345() {
    }

    @JvmStatic
    public static void Method12346() {
    }

    @Nullable
    public static ClassLoader Method12347() {
        return Field7419;
    }
}

