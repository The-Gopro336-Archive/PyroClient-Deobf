/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
   modid = "pyroclient",
   name = "Pyro Client",
   version = "1.4.1",
   acceptedMinecraftVersions = "[1.12.2]"
)
public class Pyro {
   public static final String MODID = "pyroclient";
   public static final String NAME = "Pyro Client";
   public static final String VERSION = "1.4.1";
   public static final String VERSIONTYPE = "this is a qq certified release";
   public static final File FOLDER = new File("pyro");
   public static final File HUDMODULESFOLDER;
   public static final KeyBinding KEY;
   public static final Gson GSON;
   public static Pyro INSTANCE;
   public static final f0h eventManager;
   public static final f02 rotationManager;
   public static final few rotationUtils;
   public static final f5i notificationManager;
   public static long STARTUP_TIME;
   private int lastChatLine = 420;
   private static ResourceLocation WATERMARK;

   public static final ITextComponent getPrefix() {
      return (new TextComponentString("")).appendSibling((new TextComponentString("[")).setStyle((new Style()).setColor(TextFormatting.DARK_RED).setBold(true))).appendSibling((new TextComponentString(Config.INSTANCE.watermark)).setStyle((new Style()).setColor(TextFormatting.DARK_RED))).appendSibling((new TextComponentString("] ")).setStyle((new Style()).setColor(TextFormatting.DARK_RED).setBold(true)));
   }

   public Pyro() {
      INSTANCE = this;
   }

   public static final f0f getEventManager() {
      return eventManager;
   }

   public static final f02 getRotationManager() {
      return rotationManager;
   }

   public static few getRotationUtils() {
      return rotationUtils;
   }

   public static f5i getNotificationManager() {
      return notificationManager;
   }

   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      INSTANCE = this;
      STARTUP_TIME = System.nanoTime() / 1000000L;
      ClientRegistry.registerKeyBinding(KEY);
      Config.load();
      FriendManager.loadFriends();
      class_59.field_2713.method_4139();
      class_59.field_2713.method_4138();
      this.register("Combat", PyroStatic.field_2523, 16721152);
      this.register("Combat", PyroStatic.field_2599, 7811649);
      this.register("Combat", PyroStatic.field_2509, 16590080);
      this.register("Combat", PyroStatic.field_2471, 10602124);
      this.register("Combat", PyroStatic.field_2480, 16065792);
      this.register("Combat", PyroStatic.field_2555, 10724261);
      this.register("Combat", PyroStatic.field_2547, 16396851);
      this.register("Combat", PyroStatic.field_2492, 10927747);
      this.register("Combat", PyroStatic.field_2508, 8912640);
      this.register("Combat", PyroStatic.field_2588, 13221015);
      this.register("Combat", PyroStatic.field_2581, 15018947);
      this.register("Combat", PyroStatic.field_2558, 6159434);
      this.register("Combat", PyroStatic.field_2499, 3657984);
      this.register("Combat", PyroStatic.field_2598, -1234904);
      this.register("Combat", PyroStatic.field_2574, 15925503);
      this.register("Combat", PyroStatic.field_2578, 11150242);
      this.register("Combat", PyroStatic.field_2554, 16281856);
      this.register("Combat", PyroStatic.field_2566, 16747264);
      this.register("Combat", PyroStatic.field_2570, 16749312);
      this.register("Combat", PyroStatic.field_2527, 65492);
      this.register("Combat", PyroStatic.field_2472, 6226575);
      this.register("Combat", PyroStatic.field_2510, 12136682);
      this.register("Combat", PyroStatic.field_2495, 7439241);
      this.register("Exploit", PyroStatic.field_2512, 5518690);
      this.register("Exploit", PyroStatic.field_2515, 187367);
      this.register("Exploit", PyroStatic.field_2516, 8645950);
      this.register("Exploit", PyroStatic.field_2548, 10323010);
      this.register("Exploit", PyroStatic.field_2536, 589568);
      this.register("Exploit", PyroStatic.field_2513, 15481627);
      this.register("Exploit", PyroStatic.field_2552, 1819821);
      this.register("Exploit", PyroStatic.field_2514, 4509108);
      this.register("Exploit", PyroStatic.field_2543, 711865);
      this.register("Exploit", PyroStatic.field_2544, 711865);
      this.register("Exploit", PyroStatic.field_2545, 711865);
      this.register("Exploit", PyroStatic.field_2611, 16711935);
      this.register("Exploit", PyroStatic.field_2549, 15658128);
      this.register("Exploit", PyroStatic.field_2605, 0);
      this.register("Movement", PyroStatic.field_2518, 14310417);
      this.register("Movement", PyroStatic.field_2538, 10066346);
      this.register("Movement", PyroStatic.field_2575, 3269598);
      this.register("Movement", PyroStatic.field_2525, 9154952);
      this.register("Movement", PyroStatic.field_2582, 6618880);
      this.register("Movement", PyroStatic.field_2468, 3513281);
      this.register("Movement", PyroStatic.field_2520, 1283104);
      this.register("Movement", PyroStatic.field_2521, 4431382);
      this.register("Movement", PyroStatic.field_2565, 16721152);
      this.register("Movement", PyroStatic.field_2539, 52221);
      this.register("Movement", PyroStatic.field_2511, 12034479);
      this.register("Movement", PyroStatic.field_2580, 5189976);
      this.register("Movement", PyroStatic.field_2502, 2212086);
      this.register("Movement", PyroStatic.field_2519, 1288070);
      this.register("Movement", PyroStatic.field_2500, 8639971);
      this.register("Movement", PyroStatic.field_2506, 4411349);
      this.register("Movement", PyroStatic.field_2496, 1832568);
      this.register("Movement", PyroStatic.field_2537, 4434825);
      this.register("Movement", PyroStatic.field_2526, 9425602);
      this.register("Movement", PyroStatic.field_2557, 4903164);
      this.register("Movement", PyroStatic.field_2596, 4508975);
      this.register("Movement", PyroStatic.field_2494, 3446712);
      this.register("Movement", PyroStatic.field_2493, 9153926);
      this.register("Movement", PyroStatic.field_2470, 9425609);
      this.register("Movement", PyroStatic.field_2501, 3716936);
      this.register("Movement", PyroStatic.field_2594, 2806225);
      this.register("Movement", PyroStatic.field_2469, 7155593);
      this.register("Advanced", PyroStatic.field_2467);
      if (PyroStatic.field_2489.method_537()) {
         this.register("Movement", PyroStatic.field_2489);
      }

      this.register("Misc", PyroStatic.field_2478);
      this.register("Misc", PyroStatic.field_2477);
      this.register("Misc", PyroStatic.field_2533, 2538920);
      this.register("Misc", PyroStatic.field_2590, 5179488);
      this.register("Misc", PyroStatic.field_2562, 5329312);
      this.register("Misc", PyroStatic.field_2607, 16776704);
      this.register("Misc", PyroStatic.field_2591, 8994454);
      this.register("Misc", PyroStatic.field_2474, 15442996);
      this.register("Misc", PyroStatic.field_2479, 5131916);
      this.register("Misc", PyroStatic.field_2569, 65396);
      this.register("Misc", PyroStatic.field_2551, 1135767);
      this.register("Misc", PyroStatic.field_2563, 511963);
      this.register("Misc", PyroStatic.field_2483, 5147629);
      this.register("Misc", PyroStatic.field_2561, 3461335);
      this.register("Misc", PyroStatic.field_2595, 16026208);
      this.register("Misc", PyroStatic.field_2604, 16084818);
      this.register("Misc", PyroStatic.field_2609, 16084818);
      this.register("Misc", PyroStatic.field_2485, 3461335);
      this.register("Misc", PyroStatic.field_2486, 3784010);
      this.register("Misc", PyroStatic.field_2583, 10363943);
      this.register("Misc", PyroStatic.field_2567, 48821);
      this.register("Misc", PyroStatic.field_2573, 65396);
      this.register("Misc", PyroStatic.field_2487, 1832677);
      this.register("Misc", PyroStatic.field_2586, 14344989);
      this.register("Misc", PyroStatic.field_2550, 15217925);
      this.register("Misc", PyroStatic.field_2475, 4501901);
      this.register("Misc", PyroStatic.field_2606, 0);
      this.register("Misc", PyroStatic.field_2560, 11093169);
      this.register("Misc", PyroStatic.field_2600, 1171435);
      this.register("Misc", PyroStatic.field_2593, 9197478);
      this.register("Misc", PyroStatic.field_2490, 11995954);
      this.register("Render", PyroStatic.field_2576, 3251683);
      this.register("Render", PyroStatic.field_2577, 11016216);
      this.register("Render", PyroStatic.field_2531, 1893181);
      this.register("Render", PyroStatic.field_2491, 16228715);
      this.register("Render", PyroStatic.field_2534, -1);
      this.register("Render", PyroStatic.field_2529, 1832657);
      this.register("Render", PyroStatic.field_2559, 16751360);
      this.register("Render", PyroStatic.field_2587, 36863);
      this.register("Render", PyroStatic.field_2528, 16128841);
      this.register("Render", PyroStatic.field_2498, 16128920);
      this.register("Render", PyroStatic.field_2571, 10317736);
      this.register("Render", PyroStatic.field_2481, 12901754);
      this.register("Render", PyroStatic.field_2484);
      this.register("Render", PyroStatic.field_2564, 12662784);
      this.register("Render", PyroStatic.field_2517, 16128795);
      this.register("Render", PyroStatic.field_2601, -1);
      this.register("Render", PyroStatic.field_2592, 4372703);
      this.register("Render", PyroStatic.field_2540, -1);
      this.register("Render", PyroStatic.field_2497, 6048976);
      this.register("Render", PyroStatic.field_2541, 6115270);
      this.register("Render", PyroStatic.field_2584, 9569541);
      this.register("Render", PyroStatic.field_2532, 13290186);
      this.register("Render", PyroStatic.field_2542, 9361846);
      this.register("Render", PyroStatic.field_2556, 16711935);
      this.register("Render", PyroStatic.field_2482, 15755368);
      this.register("Render", PyroStatic.field_2610, 16711935);
      this.register("Render", PyroStatic.field_2507, 2111174);
      this.register("Render", PyroStatic.field_2546, 15755368);
      this.register("Render", PyroStatic.field_2553, 15755368);
      this.register("Render", PyroStatic.field_2585, 1498794);
      this.register("Render", PyroStatic.field_2579, 15025963);
      this.register("Render", PyroStatic.field_2535, 14128996);
      this.register("World", PyroStatic.field_2503, 6214907);
      this.register("World", PyroStatic.field_2524, 6466756);
      this.register("World", PyroStatic.field_2602, 1332280);
      this.register("World", PyroStatic.field_2504, 14120230);
      this.register("World", PyroStatic.field_2522, 11757871);
      this.register("World", PyroStatic.field_2568, 9543702);
      this.register("World", PyroStatic.field_2473, 9741652);
      this.register("World", PyroStatic.field_2530, 10004081);
      this.register("Advanced", PyroStatic.field_2608, 0);
      this.register("World", PyroStatic.field_2476, 15695380);
      this.register("World", PyroStatic.field_2488, 13398053);
      this.register("World", PyroStatic.field_2589, 13398053);
      this.register("World", PyroStatic.field_2505, 9498350);
      rotationManager.method_3463();
      rotationUtils.method_1728();
      f63.field_2206.method_3286();
      class_9.field_2271.method_3399();
      class_4.field_993.method_1461();
   }

   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {
      f67.field_2201.method_3274();
      class_5.field_1004.method_1477();
      class_37.field_2633.method_3976();
      class_5.field_1004.method_1487();
   }

   public void register(String category, Module module, int color) {
      module.method_125(color);
      module.method_137(category);
      class_37.field_2633.method_3979(category).method_3990(module);
   }

   public void register(String category, Module module) {
      this.register(category, module, -1);
   }

   public void sendAndKeepMessage(String s) {
      Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((new TextComponentString("")).appendSibling(getPrefix()).appendSibling(new TextComponentString(s)), 0);
   }

   public void sendAndKeepMessage(ITextComponent s) {
      Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((new TextComponentString("")).appendSibling(getPrefix()).appendSibling(s), 0);
   }

   public void sendMessage(String s, boolean clean) {
      if (clean) {
         this.sendMessage(s);
      } else {
         this.sendAndKeepMessage(s);
      }

   }

   public void sendMessage(String s) {
      if (Minecraft.getMinecraft().ingameGUI != null) {
         Minecraft.getMinecraft().ingameGUI.getChatGUI().deleteChatLine(this.lastChatLine);
         Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((new TextComponentString("")).appendSibling(getPrefix()).appendSibling(new TextComponentString(s)), this.lastChatLine++);
         if (this.lastChatLine > 423) {
            this.lastChatLine = 420;
         }
      }

   }

   public static InputStream getResourceAsStream(String resource) {
      if (PyroClientLoadingPlugin.resources.containsKey(resource)) {
         return new ByteArrayInputStream((byte[])PyroClientLoadingPlugin.resources.get(resource));
      } else {
         System.out.println("No resource found: " + resource + " - Searching classpath");
         System.out.println("Resource cache: " + PyroClientLoadingPlugin.resources.keySet());
         return Pyro.class.getResourceAsStream("/" + resource);
      }
   }

   public static void drawWMMain() {
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.scale(0.7F, 0.7F, 1.0F);
      GlStateManager.pushMatrix();
      GlStateManager.scale(0.5D, 0.25D, 0.0D);
      Minecraft.getMinecraft().getTextureManager().bindTexture(WATERMARK);
      GuiUtils.drawTexturedModalRect(0, 0, 0, 0, 256, 256, 0.0F);
      GlStateManager.popMatrix();
      PyroRenderUtil.meth1("Release 1.4.1", 56.0F, 43.0F, 15492635);
      GlStateManager.popMatrix();
   }

   static Class getMapArrayClass() {
      return Map[].class;
   }

   static Class getMapClass() {
      return Map.class;
   }

   static {
      HUDMODULESFOLDER = f67.field_2201.method_3279();
      KEY = new KeyBinding("Open Pyro Gui", Minecraft.IS_RUNNING_ON_MAC ? 43 : 157, "Pyro Client");
      GSON = (new GsonBuilder()).setPrettyPrinting().create();
      eventManager = new f0h();
      rotationManager = new f02();
      rotationUtils = new few();
      notificationManager = new f5i();
      STARTUP_TIME = -1L;
      WATERMARK = new ResourceLocation("pyro:assets/textures/logotext.png");
   }
}
