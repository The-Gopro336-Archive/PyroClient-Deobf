/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  com.google.common.collect.Multimaps
 */
package dev.nuker.pyro;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import dev.nuker.pyro.f0f;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0i;
import dev.nuker.pyro.f0j;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class f0h
implements f0f {
    public Multimap<Class<?>, f0i> Field5581 = Multimaps.newSetMultimap(new ConcurrentHashMap(), ConcurrentHashMap::newKeySet);
    public Multimap<Object, f0i> Field5582 = Multimaps.newSetMultimap(new ConcurrentHashMap(), ConcurrentHashMap::newKeySet);
    public static Multimap<String, f0i> Field5583 = Multimaps.newSetMultimap(new ConcurrentHashMap(), ConcurrentHashMap::newKeySet);

    public void Method7914(Object object, Method method, int n) {
        boolean bl = method.isAccessible();
        method.setAccessible(true);
        f0j f0j2 = new f0j(object, method);
        f0j2.Method7923(n);
        method.setAccessible(bl);
        if (f0j2 != null) {
            if (!this.Field5582.containsEntry(object, (Object)f0j2)) {
                this.Field5582.get(object).add(f0j2);
            }
            this.Field5581.get((Object)f0j2.Method7925()).add(f0j2);
        }
    }

    @Override
    public void Method7915(Object object) {
        Arrays.stream(object.getClass().getDeclaredMethods()).filter(f0h::Method7917).forEach(arg_0 -> this.Method7916(object, arg_0));
        if (Field5583.containsKey((Object)object.getClass().getName())) {
            for (f0i f0i2 : Field5583.get((Object)object.getClass().getName())) {
                if (!this.Field5582.containsEntry(object, (Object)f0i2)) {
                    this.Field5582.get(object).add(f0i2);
                }
                this.Field5581.get((Object)f0i2.Method7925()).add(f0i2);
            }
        }
    }

    public void Method7916(Object object, Method method) {
        this.Method7914(object, method, method.getAnnotation(f0g.class).Method7913());
    }

    public static boolean Method7917(Method method) {
        return method.isAnnotationPresent(f0g.class) && method.getParameterCount() == 1;
    }

    @Override
    public void Method7918(Object object) {
        Multimap<Class<?>, f0i> multimap = this.Field5581;
        Object object2 = object;
        Class<?> class_ = object2.getClass();
        Collection collection = multimap.get(class_);
        Stream stream = collection.stream();
        Comparator comparator = f0h::Method7922;
        Stream stream2 = stream.sorted(comparator);
        Consumer<f0i> consumer = arg_0 -> f0h.Method7919(object, arg_0);
        try {
            stream2.forEach(consumer);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void Method7919(Object object, f0i f0i2) {
        f0i2.accept(object);
    }

    public void Method7920(f0i f0i2) {
        ArrayList arrayList = new ArrayList(this.Field5581.keySet());
        for (Class class_ : arrayList) {
            this.Field5581.get((Object)class_).remove(f0i2);
        }
    }

    @Override
    public void Method7921(Object object) {
        this.Field5582.get(object).forEach(this::Method7920);
    }

    public static int Method7922(f0i f0i2, f0i f0i3) {
        return Integer.compare(f0i3.Method7924(), f0i2.Method7924());
    }
}

