/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.relauncher.IFMLCallHook
 */
package dev.nuker.pyro;

import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLCallHook;

public class Class11
implements IFMLCallHook {
    public Object call() {
        return this.Method4801();
    }

    public void injectData(Map map) {
        ClassLoader classLoader;
        ClassLoader classLoader2 = (ClassLoader)map.get("classLoader");
        try {
            classLoader = classLoader2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Couldn't find Forgelin langague adapter, this shouldn't be happening", classNotFoundException);
        }
        String string = "net.shadowfacts.forgelin.KotlinAdapter";
        classLoader.loadClass(string);
    }

    public Void Method4801() {
        return null;
    }
}

