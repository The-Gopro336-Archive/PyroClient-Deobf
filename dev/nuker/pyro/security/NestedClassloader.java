/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.security;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NestedClassloader
extends ClassLoader {
    public Map<String, Class<?>> Field2869;
    public Map<String, byte[]> Field2870;

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Class Method4760(@NotNull String string, @NotNull byte[] arrby) {
        void bytes;
        void name;
        this.Method4761((String)name, (byte[])bytes);
        return this.loadClass((String)name);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public InputStream getResourceAsStream(@NotNull String string) {
        void name;
        return this.Field2870.containsKey(name) ? (InputStream)new ByteArrayInputStream(this.Field2870.get(name)) : this.getParent().getResourceAsStream((String)name);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Class loadClass(@NotNull String string) {
        Class<?> class_;
        void name;
        if (this.Field2870.containsKey(name)) {
            Class<?> class_2;
            if (this.Field2869.containsKey(name)) {
                Class<?> class_3 = this.Field2869.get(name);
                if (class_3 == null) {
                    Intrinsics.Method6551();
                }
                class_2 = class_3;
            } else {
                void var3_3;
                byte[] bytes = this.Field2870.get(name);
                if (bytes == null) {
                    Intrinsics.Method6551();
                }
                Class<?> clazz = this.defineClass(bytes, 0, bytes.length);
                this.resolveClass(clazz);
                this.Field2869.put((String)name, clazz);
                class_2 = var3_3;
            }
            class_ = class_2;
        } else {
            class_ = this.getParent().loadClass((String)name);
        }
        return class_;
    }

    /*
     * WARNING - void declaration
     */
    public void Method4761(@NotNull String string, @NotNull byte[] arrby) {
        void bytes;
        void name;
        this.Field2870.put((String)name, (byte[])bytes);
        if (StringsKt.Method10002((String)name, ".class", false, 2, null)) {
            this.Field2870.put(StringsKt.Method11423(StringsKt.Method9966((String)name, '/', '.', false, 4, null), ".class", null, 2, null), (byte[])bytes);
        } else {
            this.Field2870.put(StringsKt.Method9966((String)name, '.', '/', false, 4, null) + ".class", (byte[])bytes);
        }
    }

    public NestedClassloader(@Nullable ClassLoader parentLoader) {
        super(parentLoader);
        Map map;
        NestedClassloader nestedClassloader = this;
        boolean bl = false;
        nestedClassloader.Field2869 = map = (Map)new LinkedHashMap();
        nestedClassloader = this;
        bl = false;
        nestedClassloader.Field2870 = map = (Map)new LinkedHashMap();
    }
}

