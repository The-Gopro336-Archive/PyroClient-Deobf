/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

public class LoadingPluginImpl {
   // $FF: renamed from: mf java.io.File
   @NotNull
   public static File field_1666;
   @NotNull
   public static List mixins;
   public static LoadingPluginImpl INSTANCE;

   @JvmStatic
   @Nullable
   public static String getAccessTransformerClass() {
      return null;
   }

   static {
      LoadingPluginImpl var0 = new LoadingPluginImpl();
      INSTANCE = var0;
   }

   @JvmStatic
   public static void init(@NotNull List mixins, @NotNull File mf) {
      LoadingPluginImpl.mixins = mixins;
      field_1666 = mf;
   }

   @JvmStatic
   @Nullable
   public static String getModContainerClass() {
      return null;
   }

   @JvmStatic
   @Nullable
   public static String getSetupClass() {
      return null;
   }

   public void setMixins(@NotNull List var1) {
      mixins = var1;
   }

   @NotNull
   public List getMixins() {
      List var10000 = mixins;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mixins");
      }

      return var10000;
   }

   @JvmStatic
   @Nullable
   public static String[] getASMTransformerClass() {
      return new String[]{null};
   }

   @NotNull
   public File getMf() {
      File var10000 = field_1666;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mf");
      }

      return var10000;
   }

   public void setMf(@NotNull File var1) {
      field_1666 = var1;
   }

   @JvmStatic
   public static void injectData(@Nullable Map data) {
      MixinBootstrap.init();
      System.out.println("Initialized Mixin Bootstrap");
      MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
      MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
      System.out.println("Loading Pyro Mixin Config");
      Mixins.addConfiguration("mixins.pyroclient.json");
      System.out.println("Binscure won't save your terrible security solution! - Crystallinqq");
   }
}
