/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.SecManReplace
 *  javax.annotation.Nullable
 *  net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
 *  net.minecraftforge.fml.relauncher.IFMLLoadingPlugin$MCVersion
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BetterSecurityManager;
import dev.nuker.pyro.SecManReplace;
import dev.nuker.pyro.launcher.LoadingPluginImpl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@IFMLLoadingPlugin.MCVersion(value="1.12.2")
public class PyroClientLoadingPlugin
implements IFMLLoadingPlugin {
    public static Logger Field7533 = LogManager.getLogger((String)"Pyro Client");
    public static Map<String, byte[]> Field7534 = new HashMap<String, byte[]>();
    public static Thread Field7535 = Thread.currentThread();

    public static InputStream Method12460(String name) {
        if (Field7534.containsKey(name)) {
            return new ByteArrayInputStream(Field7534.get(name));
        }
        return PyroClientLoadingPlugin.class.getResourceAsStream(name);
    }

    public static void Method12461() {
        SecManReplace.replaceSecurityManager((SecurityManager)new BetterSecurityManager());
        System.exit(0);
    }

    public String[] getASMTransformerClass() {
        return LoadingPluginImpl.Method4781();
    }

    public String getModContainerClass() {
        return LoadingPluginImpl.Method4777();
    }

    @Nullable
    public String getSetupClass() {
        return LoadingPluginImpl.Method4778();
    }

    public void injectData(Map data) {
        LoadingPluginImpl.Method4784(data);
    }

    public String getAccessTransformerClass() {
        return LoadingPluginImpl.Method4775();
    }
}

