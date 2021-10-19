/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8d extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_289;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_290;
   // $FF: renamed from: 1 int
   public int field_291;

   // $FF: renamed from: c () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_421() {
      return this.field_289;
   }

   // $FF: renamed from: 3 (int) void
   public void method_422(int var1) {
      this.field_291 = var1;
   }

   // $FF: renamed from: 5 () java.lang.String
   @NotNull
   public String method_423() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 2 () void
   public void method_424() {
      if ((new File("pyro/chatsuffix.txt")).exists()) {
         this.field_290 = FilesKt.readLines(new File("pyro/chatsuffix.txt"), Charsets.UTF_8);
      } else {
         FilesKt.writeText(new File("pyro/chatsuffix.txt"), CollectionsKt.joinToString$default((Iterable)this.field_290, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null), Charsets.UTF_8);
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4j) void
   @f0g
   @LauncherEventHide
   public void method_425(@NotNull f4j var1) {
      if (this.c.getCurrentServerData() != null) {
         ServerData var10000 = this.c.getCurrentServerData();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (StringsKt.contains$default((CharSequence)var10000.serverIP, (CharSequence)"2b2t.org", false, 2, (Object)null)) {
            return;
         }
      }

      if (!StringsKt.startsWith$default(var1.method_3112(), "/", false, 2, (Object)null)) {
         var1.method_3111(var1.method_3112() + ' ' + this.method_423());
      }
   }

   // $FF: renamed from: 0 () int
   public int method_426() {
      return this.field_291;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.method_424();
      Pyro.INSTANCE.sendMessage("You can customize the ChatSuffix in chatsuffix.txt");
   }

   public f8d() {
      super("chatsuffix", "ChatSuffix", (String)null);
      this.field_289 = (f0o)this.register((f0w)(new f0o("mode", "Mode", "The way suffix picks your current suffix", (Enum)f8a.field_1882)));
      this.field_290 = CollectionsKt.listOf("» ҉ ᴘʏʀᴏ ᴄʟɪᴇɴᴛ ҉");
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_427() {
      return this.field_290;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_428(@NotNull List var1) {
      this.field_290 = var1;
   }
}
