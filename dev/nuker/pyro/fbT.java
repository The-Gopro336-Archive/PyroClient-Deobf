/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class fbT extends Module {
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_704 = (IntegerSetting)this.register((f0w)(new IntegerSetting("opacity", "Wallhack Opacity", "Changes the opacity level of rendered blocks", 128, 0, 255, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_705 = (IntegerSetting)this.register((f0w)(new IntegerSetting("opacityXray", "Xray Opacity", "Same as above, but only affects xray", 128, 0, 255, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_706 = (BooleanSetting)this.register((f0w)(new BooleanSetting("xray", "Xray", "Enables Xray when wallhack is enabled", false)));
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_707 = (BindSetting)this.register((f0w)(new BindSetting("xrayBind", "Wallhack Bind", "Keybind to toggle xray, so you can use wallhack separately", -1)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_708 = (BooleanSetting)this.register((f0w)(new BooleanSetting("preload", "Preload", "Prerender everything as transparent (usually a bad idea)", false)));
   // $FF: renamed from: c dev.nuker.pyro.fbR
   @NotNull
   public fbR field_709;
   // $FF: renamed from: 1 int
   public int field_710 = 255;

   // $FF: renamed from: c (net.minecraft.block.Block, net.minecraft.block.state.IBlockState, net.minecraft.world.IBlockAccess, net.minecraft.util.math.BlockPos, net.minecraft.util.EnumFacing, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable) void
   public void method_1036(@NotNull Block var1, @NotNull IBlockState var2, @NotNull IBlockAccess var3, @NotNull BlockPos var4, @NotNull EnumFacing var5, @NotNull CallbackInfoReturnable var6) {
      if (this.method_1044(var1)) {
         var6.cancel();
         var6.setReturnValue(true);
      }

   }

   // $FF: renamed from: c (net.minecraft.block.Block, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable) void
   public void method_1037(@NotNull Block var1, @NotNull CallbackInfoReturnable var2) {
      if (this.method_1044(var1)) {
         var2.cancel();
         var2.setReturnValue(15);
      }

   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      if (((Number)this.field_707.c()).intValue() != -1 && var1) {
         this.field_706.c(false);
      }

   }

   // $FF: renamed from: 4 () void
   public void method_1038() {
      if ((new File("pyro/xray_blocks.json")).exists()) {
         try {
            FileReader var1 = new FileReader("pyro/xray_blocks.json");
            this.field_709 = (fbR)Pyro.GSON.fromJson((Reader)var1, fbR.class);
            var1.close();
         } catch (IOException var13) {
            var13.printStackTrace();
         }
      } else {
         this.field_709 = new fbR();
         fbR var10000 = this.field_709;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         Iterable var14 = (Iterable)CollectionsKt.listOf(new Block[]{Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.COAL_ORE, Blocks.REDSTONE_ORE, Blocks.LAPIS_ORE, Blocks.QUARTZ_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.TNT, (Block)Blocks.BEACON, Blocks.MOB_SPAWNER, (Block)Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.FURNACE, Blocks.LIT_FURNACE, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX});
         fbR var10 = var10000;
         boolean var2 = false;
         Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var14, 10)));
         boolean var5 = false;
         Iterator var6 = var14.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            Block var8 = (Block)var7;
            boolean var9 = false;
            String var12 = ((ResourceLocation)Block.REGISTRY.getNameForObject(var8)).toString();
            var4.add(var12);
         }

         List var11 = (List)var4;
         var10.method_2818(CollectionsKt.toMutableList((Collection)var11));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.fbT) net.minecraft.client.Minecraft
   public static Minecraft method_1039(fbT var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f45) void
   @f0g
   @LauncherEventHide
   public void method_1040(@NotNull f45 var1) {
      if (var1.method_3193()) {
         int var2 = Keyboard.getEventKey();
         if (var2 == ((Number)this.field_707.c()).intValue()) {
            if ((Boolean)this.c.method_3034()) {
               if ((Boolean)this.field_706.c()) {
                  this.c.method_3033(false);
                  this.field_706.c(false);
               } else {
                  this.field_706.c(true);
               }
            } else {
               this.c.method_3033(true);
               this.field_706.c(true);
            }
         }
      }

   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1041() {
      return this.field_708;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbT, net.minecraft.client.Minecraft) void
   public static void method_1042(fbT var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1043() {
      return this.field_705;
   }

   // $FF: renamed from: c (net.minecraft.block.Block) boolean
   public boolean method_1044(@Nullable Block var1) {
      boolean var2;
      if (var1 != null && (Boolean)this.c.method_3034() && (Boolean)this.field_706.c()) {
         fbR var10000 = this.field_709;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         if (var10000.method_2817().contains(((ResourceLocation)Block.REGISTRY.getNameForObject(var1)).toString())) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   // $FF: renamed from: 3 (int) void
   public void method_1045(int var1) {
      this.field_710 = var1;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.fbR
   @NotNull
   public fbR method_1046() {
      fbR var10000 = this.field_709;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("storage");
      }

      return var10000;
   }

   // $FF: renamed from: 7 () int
   public int method_1047() {
      return this.field_710;
   }

   public fbT() {
      super("wallhack", "Wallhack", "See through walls");
      this.method_1038();
      this.field_706.c((Consumer)(new fbQ(this)));
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1048() {
      return this.field_706;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_1049() {
      return this.field_707;
   }

   // $FF: renamed from: c () void
   public void method_1050() {
      try {
         FileWriter var1 = new FileWriter("pyro/xray_blocks.json");
         Gson var10000 = Pyro.GSON;
         fbR var10001 = this.field_709;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         var10000.toJson(var10001, (Appendable)var1);
         var1.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   // $FF: renamed from: 2 () int
   public int method_1051() {
      return (Boolean)this.c.method_3034() ? ((Boolean)this.field_706.c() ? ((Number)this.field_705.c()).intValue() : ((Number)this.field_704.c()).intValue()) : 255;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbR) void
   public void method_1052(@NotNull fbR var1) {
      this.field_709 = var1;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1053() {
      return this.field_704;
   }

   // $FF: renamed from: 8 () void
   public void method_1054() {
      boolean var1 = this.method_1056();
      int var10001;
      int var2;
      byte var3;
      boolean var4;
      int var6;
      int var7;
      if (this.field_710 < this.method_1051()) {
         var10001 = this.field_710;
         var2 = this.method_1051() - this.field_710;
         var3 = 10;
         var6 = var10001;
         var4 = false;
         var7 = Math.min(var2, var3);
         this.field_710 = var6 + var7;
      } else if (this.field_710 > this.method_1051()) {
         var10001 = this.field_710;
         var2 = this.field_710 - this.method_1051();
         var3 = 10;
         var6 = var10001;
         var4 = false;
         var7 = Math.min(var2, var3);
         this.field_710 = var6 - var7;
      }

      if (var1 != this.method_1056()) {
         if (this.c.world != null && this.c.renderGlobal != null) {
            this.c.addScheduledTask((Runnable)(new fbS(this)));
         }

         ForgeModContainer.forgeLightPipelineEnabled = !this.method_1056();
      }

   }

   // $FF: renamed from: c (net.minecraft.block.Block, net.minecraft.util.BlockRenderLayer, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable) void
   public void method_1055(@NotNull Block var1, @NotNull BlockRenderLayer var2, @NotNull CallbackInfoReturnable var3) {
      if (!this.method_1044(var1)) {
         var3.cancel();
         var3.setReturnValue(var2 == BlockRenderLayer.TRANSLUCENT);
      }

   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1056() {
      return this.field_710 != 255 || (Boolean)this.field_708.c();
   }
}
