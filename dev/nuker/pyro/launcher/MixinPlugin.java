/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import java.io.File;
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

public class MixinPlugin implements IMixinConfigPlugin {
   public static List mixins = new ArrayList();

   public void onLoad(String mixinPackage) {
      Logger log = LogManager.getLogger("Hi");
      File dir = new File("pyro");

      try {
         if (!dir.exists()) {
            dir.mkdirs();
            dir.createNewFile();
         }

         byte[] refmap = IOUtils.toByteArray(PCL.class.getResourceAsStream("refmap.json"));
         if (!(new File(dir, "refmap")).exists()) {
            (new File(dir, "refmap")).createNewFile();
         }

         Files.write((new File(dir, "refmap")).toPath(), refmap, new OpenOption[0]);
         System.out.println("Loading mixin classes");
         mixins.add("AbstractHorseMixin");
         mixins.add("BlockAccessor");
         mixins.add("BlockCollisionBBMixin");
         mixins.add("BlockLiquidMixin");
         mixins.add("BlockMixin");
         mixins.add("BlockModelRendererMixin");
         mixins.add("BlockRendererDispatcherMixin");
         mixins.add("CPacketAnimationAccessor");
         mixins.add("CPacketChatMessageAccessor");
         mixins.add("CPacketCloseWindowAccessor");
         mixins.add("CPacketPlayerAccessor");
         mixins.add("CPacketPlayerTryUseItemOnBlockAccessor");
         mixins.add("CPacketVehicleMoveAccessor");
         mixins.add("ChunkRenderWorkerMixin");
         mixins.add("DefaultResourcePackMixin");
         mixins.add("EntityAccessor");
         mixins.add("EntityAgeableMixin");
         mixins.add("EntityAnimalMixin");
         mixins.add("EntityBoatMixin");
         mixins.add("EntityCreatureMixin");
         mixins.add("EntityFlagAccessor");
         mixins.add("EntityLivingAccessor");
         mixins.add("EntityLivingBaseAccessor");
         mixins.add("EntityLivingBaseMixin");
         mixins.add("EntityLivingMixin");
         mixins.add("EntityLlamaMixin");
         mixins.add("EntityMixin");
         mixins.add("EntityPigMixin");
         mixins.add("EntityPlayerAccessor");
         mixins.add("EntityPlayerClientMixin");
         mixins.add("EntityPlayerMixin");
         mixins.add("EntityPlayerSPAccessor");
         mixins.add("EntityPlayerSPMixin");
         mixins.add("EntityRendererAccessor");
         mixins.add("EntityRendererMixin");
         mixins.add("EntityWolfAccessor");
         mixins.add("GuiBossOverlayMixin");
         mixins.add("GuiChatAccessor");
         mixins.add("GuiChatMixin");
         mixins.add("GuiChestAccessor");
         mixins.add("GuiDisconnectedAccessor");
         mixins.add("GuiDisconnectedMixin");
         mixins.add("GuiIngameMenuMixin");
         mixins.add("GuiIngameMixin");
         mixins.add("GuiMainMenuMixin");
         mixins.add("GuiPlayerTabOverlayAccessor");
         mixins.add("GuiScreenMixin");
         mixins.add("GuiSubtitleOverlayMixin");
         mixins.add("GuiTextFieldAccessor");
         mixins.add("InventoryBasicAccessor");
         mixins.add("ItemRendererMixin");
         mixins.add("KeyBindingAccessor");
         mixins.add("LayerBipedArmorMixin");
         mixins.add("MinecraftAccessor");
         mixins.add("MinecraftMixin");
         mixins.add("ModelBoatMixin");
         mixins.add("ModelPlayerMixin");
         mixins.add("MovementInputOptionsMixin");
         mixins.add("NetHandlerPlayClientMixin");
         mixins.add("NetworkManagerMixin");
         mixins.add("PacketCompressionFixMixin");
         mixins.add("PlayerControllerMPAccessor");
         mixins.add("PlayerControllerMPMixin");
         mixins.add("RenderDragonMixin");
         mixins.add("RenderGlobalAccessor");
         mixins.add("RenderGlobalMixin");
         mixins.add("RenderGuardianMixin");
         mixins.add("RenderLivingBaseMixin");
         mixins.add("RenderLivingMixin");
         mixins.add("RenderManagerAccessor");
         mixins.add("RenderManagerMixin");
         mixins.add("RenderMinecartMixin");
         mixins.add("RenderMixin");
         mixins.add("RenderPlayerMixin");
         mixins.add("SPacketChatAccessor");
         mixins.add("SPacketEntityVelocityAccessor");
         mixins.add("SPacketExplosionAccessor");
         mixins.add("SPacketPlayerPosLookAccessor");
         mixins.add("SRRRMMixin");
         mixins.add("ShaderGroupAccessor");
         mixins.add("TESRMixin");
         mixins.add("TileEntityMixin");
         mixins.add("TileEntitySignRendererMixin");
         mixins.add("TimerAccessor");
         mixins.add("WorldClientAccessor");
         mixins.add("WorldClientMixin");
         mixins.add("WorldMixin");
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
         ((LaunchClassLoader)MixinPlugin.class.getClassLoader()).addURL((new File(dir, "refmap")).toURI().toURL());
      } catch (Throwable var6) {
         var6.printStackTrace();
      }

   }

   public void preApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
   }

   public void postApply(String var1, ClassNode var2, String var3, IMixinInfo var4) {
   }

   public String getRefMapperConfig() {
      File dir = new File("pyro");

      try {
         return (new File(dir, "refmap")).toURI().toURL().toString();
      } catch (MalformedURLException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public boolean shouldApplyMixin(String var1, String var2) {
      return false;
   }

   public void acceptTargets(Set var1, Set var2) {
   }

   public List getMixins() {
      return mixins;
   }
}
