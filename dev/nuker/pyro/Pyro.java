/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.fml.client.config.GuiUtils
 *  net.minecraftforge.fml.client.registry.ClientRegistry
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.nuker.pyro.Class14;
import dev.nuker.pyro.Class2;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Class55;
import dev.nuker.pyro.Class8;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f02;
import dev.nuker.pyro.f0f;
import dev.nuker.pyro.f0h;
import dev.nuker.pyro.f5i;
import dev.nuker.pyro.f63;
import dev.nuker.pyro.f67;
import dev.nuker.pyro.few;
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
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="pyroclient", name="Pyro Client", version="1.4.1", acceptedMinecraftVersions="[1.12.2]")
public class Pyro {
    public static final String Field6174 = "pyroclient";
    public static final String Field6175 = "Pyro Client";
    public static final String Field6176 = "1.4.1";
    public static final String Field6177 = "this is a qq certified release";
    public static final File Field6178 = new File("pyro");
    public static final File Field6179 = f67.Field4191.Method5826();
    public static final KeyBinding Field6180 = new KeyBinding("Open Pyro Gui", Minecraft.IS_RUNNING_ON_MAC ? 43 : 157, "Pyro Client");
    public static final Gson Field6181 = new GsonBuilder().setPrettyPrinting().create();
    public static Pyro Field6182;
    public static final f0h Field6183;
    public static final f02 Field6184;
    public static final few Field6185;
    public static final f5i Field6186;
    public static long Field6187;
    private int Field6188 = 420;
    private static ResourceLocation Field6189;

    public static final ITextComponent Method8977() {
        return new TextComponentString("").appendSibling(new TextComponentString("[").setStyle(new Style().setColor(TextFormatting.DARK_RED).setBold(Boolean.valueOf(true)))).appendSibling(new TextComponentString(Config.Field3937.Field3935).setStyle(new Style().setColor(TextFormatting.DARK_RED))).appendSibling(new TextComponentString("] ").setStyle(new Style().setColor(TextFormatting.DARK_RED).setBold(Boolean.valueOf(true))));
    }

    public Pyro() {
        Field6182 = this;
    }

    public static final f0f Method8978() {
        return Field6183;
    }

    public static final f02 Method8979() {
        return Field6184;
    }

    public static few Method8980() {
        return Field6185;
    }

    public static f5i Method8981() {
        return Field6186;
    }

    @Mod.EventHandler
    public void Method8982(FMLPreInitializationEvent event) {
        Field6182 = this;
        Field6187 = System.nanoTime() / 1000000L;
        ClientRegistry.registerKeyBinding((KeyBinding)Field6180);
        Config.Method5632();
        FriendManager.Method2785();
        Class55.Field4429.Method6339();
        Class55.Field4429.Method6338();
        this.Method8984("Combat", PyroStatic.Field6459, 16721152);
        this.Method8984("Combat", PyroStatic.Field6535, 7811649);
        this.Method8984("Combat", PyroStatic.Field6445, 16590080);
        this.Method8984("Combat", PyroStatic.Field6407, 10602124);
        this.Method8984("Combat", PyroStatic.Field6416, 16065792);
        this.Method8984("Combat", PyroStatic.Field6491, 0xA3A3A5);
        this.Method8984("Combat", PyroStatic.Field6483, 16396851);
        this.Method8984("Combat", PyroStatic.Field6428, 10927747);
        this.Method8984("Combat", PyroStatic.Field6444, 8912640);
        this.Method8984("Combat", PyroStatic.Field6524, 13221015);
        this.Method8984("Combat", PyroStatic.Field6517, 15018947);
        this.Method8984("Combat", PyroStatic.Field6494, 6159434);
        this.Method8984("Combat", PyroStatic.Field6435, 3657984);
        this.Method8984("Combat", PyroStatic.Field6534, -1234904);
        this.Method8984("Combat", PyroStatic.Field6510, 0xF300FF);
        this.Method8984("Combat", PyroStatic.Field6514, 0xAA23A2);
        this.Method8984("Combat", PyroStatic.Field6490, 16281856);
        this.Method8984("Combat", PyroStatic.Field6502, 16747264);
        this.Method8984("Combat", PyroStatic.Field6506, 16749312);
        this.Method8984("Combat", PyroStatic.Field6463, 65492);
        this.Method8984("Combat", PyroStatic.Field6408, 6226575);
        this.Method8984("Combat", PyroStatic.Field6446, 12136682);
        this.Method8984("Combat", PyroStatic.Field6431, 7439241);
        this.Method8984("Exploit", PyroStatic.Field6448, 5518690);
        this.Method8984("Exploit", PyroStatic.Field6451, 187367);
        this.Method8984("Exploit", PyroStatic.Field6452, 8645950);
        this.Method8984("Exploit", PyroStatic.Field6484, 10323010);
        this.Method8984("Exploit", PyroStatic.Field6472, 589568);
        this.Method8984("Exploit", PyroStatic.Field6449, 15481627);
        this.Method8984("Exploit", PyroStatic.Field6488, 1819821);
        this.Method8984("Exploit", PyroStatic.Field6450, 4509108);
        this.Method8984("Exploit", PyroStatic.Field6479, 711865);
        this.Method8984("Exploit", PyroStatic.Field6480, 711865);
        this.Method8984("Exploit", PyroStatic.Field6481, 711865);
        this.Method8984("Exploit", PyroStatic.Field6547, 0xFF00FF);
        this.Method8984("Exploit", PyroStatic.Field6485, 15658128);
        this.Method8984("Exploit", PyroStatic.Field6541, 0);
        this.Method8984("Movement", PyroStatic.Field6454, 14310417);
        this.Method8984("Movement", PyroStatic.Field6474, 0x9999AA);
        this.Method8984("Movement", PyroStatic.Field6511, 3269598);
        this.Method8984("Movement", PyroStatic.Field6461, 0x8BB188);
        this.Method8984("Movement", PyroStatic.Field6518, 6618880);
        this.Method8984("Movement", PyroStatic.Field6404, 3513281);
        this.Method8984("Movement", PyroStatic.Field6456, 1283104);
        this.Method8984("Movement", PyroStatic.Field6457, 4431382);
        this.Method8984("Movement", PyroStatic.Field6501, 16721152);
        this.Method8984("Movement", PyroStatic.Field6475, 52221);
        this.Method8984("Movement", PyroStatic.Field6447, 12034479);
        this.Method8984("Movement", PyroStatic.Field6516, 5189976);
        this.Method8984("Movement", PyroStatic.Field6438, 2212086);
        this.Method8984("Movement", PyroStatic.Field6455, 1288070);
        this.Method8984("Movement", PyroStatic.Field6436, 8639971);
        this.Method8984("Movement", PyroStatic.Field6442, 4411349);
        this.Method8984("Movement", PyroStatic.Field6432, 1832568);
        this.Method8984("Movement", PyroStatic.Field6473, 4434825);
        this.Method8984("Movement", PyroStatic.Field6462, 9425602);
        this.Method8984("Movement", PyroStatic.Field6493, 4903164);
        this.Method8984("Movement", PyroStatic.Field6532, 4508975);
        this.Method8984("Movement", PyroStatic.Field6430, 3446712);
        this.Method8984("Movement", PyroStatic.Field6429, 9153926);
        this.Method8984("Movement", PyroStatic.Field6406, 9425609);
        this.Method8984("Movement", PyroStatic.Field6437, 3716936);
        this.Method8984("Movement", PyroStatic.Field6530, 2806225);
        this.Method8984("Movement", PyroStatic.Field6405, 7155593);
        this.Method8985("Advanced", PyroStatic.Field6403);
        if (PyroStatic.Field6425.Method4876()) {
            this.Method8985("Movement", PyroStatic.Field6425);
        }
        this.Method8985("Misc", PyroStatic.Field6414);
        this.Method8985("Misc", PyroStatic.Field6413);
        this.Method8984("Misc", PyroStatic.Field6469, 2538920);
        this.Method8984("Misc", PyroStatic.Field6526, 5179488);
        this.Method8984("Misc", PyroStatic.Field6498, 5329312);
        this.Method8984("Misc", PyroStatic.Field6543, 0xFFFE00);
        this.Method8984("Misc", PyroStatic.Field6527, 8994454);
        this.Method8984("Misc", PyroStatic.Field6410, 15442996);
        this.Method8984("Misc", PyroStatic.Field6415, 5131916);
        this.Method8984("Misc", PyroStatic.Field6505, 65396);
        this.Method8984("Misc", PyroStatic.Field6487, 1135767);
        this.Method8984("Misc", PyroStatic.Field6499, 511963);
        this.Method8984("Misc", PyroStatic.Field6419, 5147629);
        this.Method8984("Misc", PyroStatic.Field6497, 3461335);
        this.Method8984("Misc", PyroStatic.Field6531, 16026208);
        this.Method8984("Misc", PyroStatic.Field6540, 16084818);
        this.Method8984("Misc", PyroStatic.Field6545, 16084818);
        this.Method8984("Misc", PyroStatic.Field6421, 3461335);
        this.Method8984("Misc", PyroStatic.Field6422, 3784010);
        this.Method8984("Misc", PyroStatic.Field6519, 10363943);
        this.Method8984("Misc", PyroStatic.Field6503, 48821);
        this.Method8984("Misc", PyroStatic.Field6509, 65396);
        this.Method8984("Misc", PyroStatic.Field6423, 1832677);
        this.Method8984("Misc", PyroStatic.Field6522, 14344989);
        this.Method8984("Misc", PyroStatic.Field6486, 15217925);
        this.Method8984("Misc", PyroStatic.Field6411, 4501901);
        this.Method8984("Misc", PyroStatic.Field6542, 0);
        this.Method8984("Misc", PyroStatic.Field6496, 11093169);
        this.Method8984("Misc", PyroStatic.Field6536, 1171435);
        this.Method8984("Misc", PyroStatic.Field6529, 9197478);
        this.Method8984("Misc", PyroStatic.Field6426, 11995954);
        this.Method8984("Render", PyroStatic.Field6512, 3251683);
        this.Method8984("Render", PyroStatic.Field6513, 0xA81818);
        this.Method8984("Render", PyroStatic.Field6467, 1893181);
        this.Method8984("Render", PyroStatic.Field6427, 16228715);
        this.Method8984("Render", PyroStatic.Field6470, -1);
        this.Method8984("Render", PyroStatic.Field6465, 1832657);
        this.Method8984("Render", PyroStatic.Field6495, 16751360);
        this.Method8984("Render", PyroStatic.Field6523, 36863);
        this.Method8984("Render", PyroStatic.Field6464, 16128841);
        this.Method8984("Render", PyroStatic.Field6434, 16128920);
        this.Method8984("Render", PyroStatic.Field6507, 10317736);
        this.Method8984("Render", PyroStatic.Field6417, 12901754);
        this.Method8985("Render", PyroStatic.Field6420);
        this.Method8984("Render", PyroStatic.Field6500, 12662784);
        this.Method8984("Render", PyroStatic.Field6453, 16128795);
        this.Method8984("Render", PyroStatic.Field6537, -1);
        this.Method8984("Render", PyroStatic.Field6528, 4372703);
        this.Method8984("Render", PyroStatic.Field6476, -1);
        this.Method8984("Render", PyroStatic.Field6433, 6048976);
        this.Method8984("Render", PyroStatic.Field6477, 6115270);
        this.Method8984("Render", PyroStatic.Field6520, 9569541);
        this.Method8984("Render", PyroStatic.Field6468, 0xCACACA);
        this.Method8984("Render", PyroStatic.Field6478, 9361846);
        this.Method8984("Render", PyroStatic.Field6492, 0xFF00FF);
        this.Method8984("Render", PyroStatic.Field6418, 15755368);
        this.Method8984("Render", PyroStatic.Field6546, 0xFF00FF);
        this.Method8984("Render", PyroStatic.Field6443, 2111174);
        this.Method8984("Render", PyroStatic.Field6482, 15755368);
        this.Method8984("Render", PyroStatic.Field6489, 15755368);
        this.Method8984("Render", PyroStatic.Field6521, 1498794);
        this.Method8984("Render", PyroStatic.Field6515, 15025963);
        this.Method8984("Render", PyroStatic.Field6471, 14128996);
        this.Method8984("World", PyroStatic.Field6439, 6214907);
        this.Method8984("World", PyroStatic.Field6460, 6466756);
        this.Method8984("World", PyroStatic.Field6538, 1332280);
        this.Method8984("World", PyroStatic.Field6440, 14120230);
        this.Method8984("World", PyroStatic.Field6458, 11757871);
        this.Method8984("World", PyroStatic.Field6504, 9543702);
        this.Method8984("World", PyroStatic.Field6409, 9741652);
        this.Method8984("World", PyroStatic.Field6466, 10004081);
        this.Method8984("Advanced", PyroStatic.Field6544, 0);
        this.Method8984("World", PyroStatic.Field6412, 15695380);
        this.Method8984("World", PyroStatic.Field6424, 13398053);
        this.Method8984("World", PyroStatic.Field6525, 13398053);
        this.Method8984("World", PyroStatic.Field6441, 0x90EEEE);
        Field6184.Method7545();
        Field6185.Method462();
        f63.Field4208.Method5841();
        Class2.Field5304.Method7342();
        Class14.Field3028.Method455();
    }

    @Mod.EventHandler
    public void Method8983(FMLPostInitializationEvent event) {
        f67.Field4191.Method5821();
        Class8.Field5278.Method7311();
        Class34.Field4599.Method6751();
        Class8.Field5278.Method4829();
    }

    public void Method8984(String category, Module module, int color) {
        module.Method7262(color);
        module.Method7275(category);
        Class34.Field4599.Method6754(category).Method6764(module);
    }

    public void Method8985(String category, Module module) {
        this.Method8984(category, module, -1);
    }

    public void Method8986(String s) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString("").appendSibling(Pyro.Method8977()).appendSibling((ITextComponent)new TextComponentString(s)), 0);
    }

    public void Method8987(ITextComponent s) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString("").appendSibling(Pyro.Method8977()).appendSibling(s), 0);
    }

    public void Method8988(String s, boolean clean) {
        if (clean) {
            this.Method8989(s);
        } else {
            this.Method8986(s);
        }
    }

    public void Method8989(String s) {
        if (Minecraft.getMinecraft().ingameGUI != null) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().deleteChatLine(this.Field6188);
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString("").appendSibling(Pyro.Method8977()).appendSibling((ITextComponent)new TextComponentString(s)), this.Field6188++);
            if (this.Field6188 > 423) {
                this.Field6188 = 420;
            }
        }
    }

    public static InputStream Method8990(String resource) {
        if (PyroClientLoadingPlugin.Field7534.containsKey(resource)) {
            return new ByteArrayInputStream(PyroClientLoadingPlugin.Field7534.get(resource));
        }
        System.out.println("No resource found: " + resource + " - Searching classpath");
        System.out.println("Resource cache: " + PyroClientLoadingPlugin.Field7534.keySet());
        return Pyro.class.getResourceAsStream("/" + resource);
    }

    public static void Method8991() {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.scale((float)0.7f, (float)0.7f, (float)1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.scale((double)0.5, (double)0.25, (double)0.0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(Field6189);
        GuiUtils.drawTexturedModalRect((int)0, (int)0, (int)0, (int)0, (int)256, (int)256, (float)0.0f);
        GlStateManager.popMatrix();
        PyroRenderUtil.Method12313("Release 1.4.1", 56.0f, 43.0f, 15492635);
        GlStateManager.popMatrix();
    }

    static Class Method8992() {
        return Map[].class;
    }

    static Class Method8993() {
        return Map.class;
    }

    static {
        Field6183 = new f0h();
        Field6184 = new f02();
        Field6185 = new few();
        Field6186 = new f5i();
        Field6187 = -1L;
        Field6189 = new ResourceLocation("pyro:assets/textures/logotext.png");
    }
}

