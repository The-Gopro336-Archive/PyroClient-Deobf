/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.launcher.LoadingPluginImpl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@MCVersion("1.12.2")
public class PyroClientLoadingPlugin implements IFMLLoadingPlugin {
   public static Logger LOG = LogManager.getLogger("Pyro Client");
   public static Map resources = new HashMap();
   public static Thread baseThread = Thread.currentThread();

   public static InputStream getResourceAsStream(String name) {
      return (InputStream)(resources.containsKey(name) ? new ByteArrayInputStream((byte[])resources.get(name)) : PyroClientLoadingPlugin.class.getResourceAsStream(name));
   }

   public static void shutdown() {
      SecManReplace.replaceSecurityManager(new BetterSecurityManager());
      System.exit(0);
   }

   public String[] getASMTransformerClass() {
      return LoadingPluginImpl.getASMTransformerClass();
   }

   public String getModContainerClass() {
      return LoadingPluginImpl.getModContainerClass();
   }

   @Nullable
   public String getSetupClass() {
      return LoadingPluginImpl.getSetupClass();
   }

   public void injectData(Map data) {
      LoadingPluginImpl.injectData(data);
   }

   public String getAccessTransformerClass() {
      return LoadingPluginImpl.getAccessTransformerClass();
   }
}
