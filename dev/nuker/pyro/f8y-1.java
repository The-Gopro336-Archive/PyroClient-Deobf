/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8y extends Module {
   // $FF: renamed from: c java.io.File
   @NotNull
   public File field_258 = new File("packetlog.diff");
   // $FF: renamed from: 0 java.io.File
   @NotNull
   public File field_259 = new File("packetignore.txt");
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_260;
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_261;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_262;
   // $FF: renamed from: c dev.nuker.pyro.f49
   @Nullable
   public f49 field_263;
   // $FF: renamed from: c dev.nuker.pyro.f8v
   @Nullable
   public f8v field_264;

   // $FF: renamed from: 8 () dev.nuker.pyro.f8v
   @Nullable
   public f8v method_377() {
      return this.field_264;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f8v) void
   public void method_378(@Nullable f8v var1) {
      this.field_264 = var1;
   }

   // $FF: renamed from: 5 () java.lang.String
   @NotNull
   public String method_379() {
      String var1 = "";
      boolean var2 = false;
      StackTraceElement[] var3 = Thread.currentThread().getStackTrace();
      boolean var4 = false;
      StackTraceElement[] var5 = var3;
      int var6 = var3.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         StackTraceElement var8 = var5[var7];
         boolean var10 = false;
         if (var2) {
            var1 = var1 + var8.getClassName() + '.' + var8.getMethodName() + '\n';
         }

         if (!var2 && Intrinsics.areEqual((Object)(var8.getClassName() + '.' + var8.getMethodName()), (Object)"net.minecraft.client.network.NetHandlerPlayClient.sendPacket")) {
            var2 = true;
         }
      }

      return StringsKt.substringBeforeLast$default(var1, "\n", (String)null, 2, (Object)null);
   }

   // $FF: renamed from: c () dev.nuker.pyro.f49
   @Nullable
   public f49 method_380() {
      return this.field_263;
   }

   // $FF: renamed from: c (java.lang.String, java.lang.String) java.lang.String
   @NotNull
   public String method_381(@NotNull String var1, @NotNull String var2) {
      return var2 + CollectionsKt.joinToString$default((Iterable)StringsKt.split$default((CharSequence)var1, new char[]{'\n'}, false, 0, 6, (Object)null), (CharSequence)('\n' + var2), (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null) + '\n';
   }

   // $FF: renamed from: 7 () java.io.File
   @NotNull
   public File method_382() {
      return this.field_259;
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.String
   @NotNull
   public String method_383(@NotNull Object var1) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      Class var3 = var1.getClass();
      String var4 = var3.getName() + " {\n";
      Class var5 = var3.getSuperclass();
      Field[] var6;
      boolean var7;
      Field[] var8;
      int var9;
      int var10;
      Field var11;
      boolean var13;
      if (var5.getSuperclass() != null) {
         var4 = var4 + " super = " + var5.getName() + " {\n";
         var6 = var5.getDeclaredFields();
         var7 = false;
         var8 = var6;
         var9 = var6.length;

         for(var10 = 0; var10 < var9; ++var10) {
            var11 = var8[var10];
            var13 = false;
            var11.setAccessible(true);
            var4 = var4 + "  " + var11.getName() + " = " + var11.get(var1) + '\n';
         }

         var4 = var4 + " }\n";
      }

      var6 = var3.getDeclaredFields();
      var7 = false;
      var8 = var6;
      var9 = var6.length;

      for(var10 = 0; var10 < var9; ++var10) {
         var11 = var8[var10];
         var13 = false;
         var11.setAccessible(true);
         var4 = var4 + ' ' + var11.getName() + " = " + var11.get(var1) + '\n';
      }

      var4 = var4 + "}";
      return var4;
   }

   public f8y() {
      super("packetsniffer", "PacketSniffer", (String)null);
      boolean var1 = false;
      List var3 = CollectionsKt.emptyList();
      this.field_260 = var3;
      this.field_261 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f8v.field_1960)));
      this.field_262 = (BooleanSetting)this.register((f0w)(new BooleanSetting("trace", "Trace", (String)null, true)));
   }

   // $FF: renamed from: 2 () java.io.File
   @NotNull
   public File method_384() {
      return this.field_258;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f49) void
   @f0g
   public void method_385(@NotNull f49 var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   public void method_386(@Nullable f49 var1) {
      this.field_263 = var1;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_387(@NotNull List var1) {
      this.field_260 = var1;
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_388() {
      return this.field_260;
   }

   // $FF: renamed from: 1 (java.lang.String) void
   public void method_389(@NotNull String var1) {
      FilesKt.appendText(this.field_258, var1, Charsets.UTF_8);
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_390() {
      return this.field_261;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_263 = (f49)null;
      if (var1) {
         f8y var10000 = this;
         List var10001;
         if (this.field_259.isFile()) {
            var10001 = FilesKt.readLines(this.field_259, Charsets.UTF_8);
         } else {
            boolean var4 = false;
            List var11 = CollectionsKt.emptyList();
            var10000 = this;
            var10001 = var11;
         }

         var10000.field_260 = var10001;
         this.field_264 = (f8v)this.field_261.c();
         Pyro.INSTANCE.sendMessage("Logging packets to packetlog.diff", false);
         Collection var12 = (Collection)this.field_260;
         boolean var5 = false;
         if (!var12.isEmpty()) {
            Pyro.INSTANCE.sendMessage("Ignoring:", false);
            Iterable var13 = (Iterable)this.field_260;
            var5 = false;
            Iterator var6 = var13.iterator();

            while(var6.hasNext()) {
               Object var7 = var6.next();
               String var8 = (String)var7;
               boolean var9 = false;
               Pyro.INSTANCE.sendMessage(var8, false);
            }
         }

         this.field_258.delete();
         this.field_258.createNewFile();
         this.method_389("--- OLD\n+++ NEW\n@@ -1,2 +0,0 @@\n-LOG:\n+LOG:\n");
      }

   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_391() {
      return this.field_262;
   }
}
