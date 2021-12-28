/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.crystallinqq.pyrocrackloader.PCL
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.apache.commons.io.IOUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package dev.nuker.pyro.launcher;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import me.crystallinqq.pyrocrackloader.PCL;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public class MixinPlugin
implements IMixinConfigPlugin {
    public static List<String> Field7078 = new ArrayList<String>();

    @Override
    public void Method6040(String mixinPackage) {
        Logger log = LogManager.getLogger((String)"Hi");
        File dir = new File("pyro");
        try {
            if (!dir.exists()) {
                dir.mkdirs();
                dir.createNewFile();
            }
            byte[] refmap = IOUtils.toByteArray((InputStream)PCL.class.getResourceAsStream("refmap.json"));
            if (!new File(dir, "refmap").exists()) {
                new File(dir, "refmap").createNewFile();
            }
            Files.write(new File(dir, "refmap").toPath(), refmap, new OpenOption[0]);
            System.out.println("Loading mixin classes");
            Field7078.add("AbstractHorseMixin");
            Field7078.add("BlockAccessor");
            Field7078.add("BlockCollisionBBMixin");
            Field7078.add("BlockLiquidMixin");
            Field7078.add("BlockMixin");
            Field7078.add("BlockModelRendererMixin");
            Field7078.add("BlockRendererDispatcherMixin");
            Field7078.add("CPacketAnimationAccessor");
            Field7078.add("CPacketChatMessageAccessor");
            Field7078.add("CPacketCloseWindowAccessor");
            Field7078.add("CPacketPlayerAccessor");
            Field7078.add("CPacketPlayerTryUseItemOnBlockAccessor");
            Field7078.add("CPacketVehicleMoveAccessor");
            Field7078.add("ChunkRenderWorkerMixin");
            Field7078.add("DefaultResourcePackMixin");
            Field7078.add("EntityAccessor");
            Field7078.add("EntityAgeableMixin");
            Field7078.add("EntityAnimalMixin");
            Field7078.add("EntityBoatMixin");
            Field7078.add("EntityCreatureMixin");
            Field7078.add("EntityFlagAccessor");
            Field7078.add("EntityLivingAccessor");
            Field7078.add("EntityLivingBaseAccessor");
            Field7078.add("EntityLivingBaseMixin");
            Field7078.add("EntityLivingMixin");
            Field7078.add("EntityLlamaMixin");
            Field7078.add("EntityMixin");
            Field7078.add("EntityPigMixin");
            Field7078.add("EntityPlayerAccessor");
            Field7078.add("EntityPlayerClientMixin");
            Field7078.add("EntityPlayerMixin");
            Field7078.add("EntityPlayerSPAccessor");
            Field7078.add("EntityPlayerSPMixin");
            Field7078.add("EntityRendererAccessor");
            Field7078.add("EntityRendererMixin");
            Field7078.add("EntityWolfAccessor");
            Field7078.add("GuiBossOverlayMixin");
            Field7078.add("GuiChatAccessor");
            Field7078.add("GuiChatMixin");
            Field7078.add("GuiChestAccessor");
            Field7078.add("GuiDisconnectedAccessor");
            Field7078.add("GuiDisconnectedMixin");
            Field7078.add("GuiIngameMenuMixin");
            Field7078.add("GuiIngameMixin");
            Field7078.add("GuiMainMenuMixin");
            Field7078.add("GuiPlayerTabOverlayAccessor");
            Field7078.add("GuiScreenMixin");
            Field7078.add("GuiSubtitleOverlayMixin");
            Field7078.add("GuiTextFieldAccessor");
            Field7078.add("InventoryBasicAccessor");
            Field7078.add("ItemRendererMixin");
            Field7078.add("KeyBindingAccessor");
            Field7078.add("LayerBipedArmorMixin");
            Field7078.add("MinecraftAccessor");
            Field7078.add("MinecraftMixin");
            Field7078.add("ModelBoatMixin");
            Field7078.add("ModelPlayerMixin");
            Field7078.add("MovementInputOptionsMixin");
            Field7078.add("NetHandlerPlayClientMixin");
            Field7078.add("NetworkManagerMixin");
            Field7078.add("PacketCompressionFixMixin");
            Field7078.add("PlayerControllerMPAccessor");
            Field7078.add("PlayerControllerMPMixin");
            Field7078.add("RenderDragonMixin");
            Field7078.add("RenderGlobalAccessor");
            Field7078.add("RenderGlobalMixin");
            Field7078.add("RenderGuardianMixin");
            Field7078.add("RenderLivingBaseMixin");
            Field7078.add("RenderLivingMixin");
            Field7078.add("RenderManagerAccessor");
            Field7078.add("RenderManagerMixin");
            Field7078.add("RenderMinecartMixin");
            Field7078.add("RenderMixin");
            Field7078.add("RenderPlayerMixin");
            Field7078.add("SPacketChatAccessor");
            Field7078.add("SPacketEntityVelocityAccessor");
            Field7078.add("SPacketExplosionAccessor");
            Field7078.add("SPacketPlayerPosLookAccessor");
            Field7078.add("SRRRMMixin");
            Field7078.add("ShaderGroupAccessor");
            Field7078.add("TESRMixin");
            Field7078.add("TileEntityMixin");
            Field7078.add("TileEntitySignRendererMixin");
            Field7078.add("TimerAccessor");
            Field7078.add("WorldClientAccessor");
            Field7078.add("WorldClientMixin");
            Field7078.add("WorldMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.AbstractHorseMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.BlockAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.BlockCollisionBBMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.BlockLiquidMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.BlockMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.BlockModelRendererMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.BlockRendererDispatcherMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.CPacketAnimationAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.CPacketChatMessageAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.CPacketCloseWindowAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.CPacketPlayerAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.CPacketVehicleMoveAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.ChunkRenderWorkerMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.DefaultResourcePackMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityAgeableMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityAnimalMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityBoatMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityCreatureMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityFlagAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityLivingAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityLivingBaseAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityLivingBaseMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityLivingMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityLlamaMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityPigMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityPlayerAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityPlayerClientMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityPlayerMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityPlayerSPAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityPlayerSPMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityRendererAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityRendererMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.EntityWolfAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiBossOverlayMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiChatAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiChatMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiChestAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiDisconnectedAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiDisconnectedMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiIngameMenuMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiIngameMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiMainMenuMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiPlayerTabOverlayAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiScreenMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiSubtitleOverlayMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.GuiTextFieldAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.InventoryBasicAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.ItemRendererMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.KeyBindingAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.LayerBipedArmorMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.MinecraftAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.MinecraftMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.ModelBoatMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.ModelPlayerMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.MovementInputOptionsMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.NetHandlerPlayClientMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.NetworkManagerMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.PacketCompressionFixMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.PlayerControllerMPAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.PlayerControllerMPMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderDragonMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderGlobalAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderGlobalMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderGuardianMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderLivingBaseMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderLivingMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderManagerAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderManagerMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderMinecartMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.RenderPlayerMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.SPacketChatAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.SPacketEntityVelocityAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.SPacketExplosionAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.SPacketPlayerPosLookAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.SRRRMMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.ShaderGroupAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.TESRMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.TileEntityMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.TileEntitySignRendererMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.TimerAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.WorldClientAccessor");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.WorldClientMixin");
            MixinPlugin.class.getClassLoader().loadClass("dev.nuker.pyro.mixin.WorldMixin");
            ((LaunchClassLoader)MixinPlugin.class.getClassLoader()).addURL(new File(dir, "refmap").toURI().toURL());
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Method6045(String string, ClassNode classNode, String string2, IMixinInfo iMixinInfo) {
    }

    @Override
    public void Method6046(String string, ClassNode classNode, String string2, IMixinInfo iMixinInfo) {
    }

    @Override
    public String Method6041() {
        File dir = new File("pyro");
        try {
            return new File(dir, "refmap").toURI().toURL().toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean Method6042(String string, String string2) {
        return false;
    }

    public void Method6043(Set set, Set set2) {
    }

    public List Method6044() {
        return Field7078;
    }
}

