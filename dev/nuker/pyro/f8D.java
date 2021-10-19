/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8D extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_399 = (BooleanSetting)this.register((f0w)(new BooleanSetting("loop", "Loop", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_400 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 1.5D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_401 = (BooleanSetting)this.register((f0w)(new BooleanSetting("random", "Random", (String)null, false)));
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_402;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_403;
   // $FF: renamed from: c java.util.concurrent.ConcurrentLinkedQueue
   @NotNull
   public ConcurrentLinkedQueue field_404;

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_602(@NotNull f4t var1) {
      this.5(String.valueOf(this.field_404.size()));
      if (this.field_403.method_1980(((Number)this.field_400.c()).doubleValue() * (double)1000)) {
         this.field_403.method_1979();
         if ((f8B)this.field_402.c() == f8B.field_1827) {
            try {
               NetHandlerPlayClient var10000 = this.c.getConnection();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               Iterable var2 = (Iterable)var10000.getPlayerInfoMap();
               boolean var3 = false;
               Iterator var4 = var2.iterator();

               while(var4.hasNext()) {
                  Object var5 = var4.next();
                  NetworkPlayerInfo var6 = (NetworkPlayerInfo)var5;
                  boolean var7 = false;
                  if (var6.getGameProfile() != null) {
                     String var8 = var6.getGameProfile().getName();
                     if (!FriendManager.Companion.isFriend(var8)) {
                        this.c.player.sendChatMessage("/ban " + var8 + " You are banned!");
                        return;
                     }
                  }
               }
            } catch (Exception var9) {
            }
         } else if (this.field_404.isEmpty()) {
            if ((Boolean)this.field_399.c()) {
               this.method_606();
            }
         } else {
            this.c.player.sendChatMessage((String)this.field_404.poll());
         }
      }

   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_603() {
      return this.field_401;
   }

   public f8D() {
      super("spammer", "Spammer", (String)null);
      this.field_402 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f8B.field_1826)));
      this.field_403 = new fe8();
      this.field_404 = new ConcurrentLinkedQueue();
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_604() {
      return this.field_402;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_605() {
      return this.field_400;
   }

   // $FF: renamed from: 5 () void
   public void method_606() {
      this.field_404.clear();
      if ((f8B)this.field_402.c() == f8B.field_1826) {
         if ((new File("pyro/spammer.txt")).exists()) {
            try {
               FileReader var1 = new FileReader("pyro/spammer.txt");
               Ref.ObjectRef var2 = new Ref.ObjectRef();
               var2.element = new ArrayList();
               TextStreamsKt.forEachLine((Reader)var1, (Function1)(new f8C(var2)));
               var1.close();
               if ((Boolean)this.field_401.c()) {
                  List var3 = (List)((ArrayList)var2.element);
                  boolean var4 = false;
                  Collections.shuffle(var3);
               }

               this.field_404.addAll((Collection)((ArrayList)var2.element));
            } catch (IOException var5) {
               var5.printStackTrace();
            }
         } else {
            (new FileWriter("pyro/spammer.txt")).close();
         }
      } else {
         this.field_404.add("艾吉诶西艾伊迪艾吉艾迪伊勒娜艾娜诶弗勒迪");
         this.field_404.add("下∪匚Ｋㄚ口∪");
         this.field_404.add("ㄗㄚ尺口匚ㄥ工モれ匕");
         this.field_404.add("丹れ匕工丹下Ｋ " + Math.random() * (double)10100);
         this.field_404.add(String.valueOf(Math.random() * (double)3818));
         this.field_404.add(String.valueOf(3.141592653589793D));
         this.field_404.add("诶娜艾吉比杰艾吾伊诶吉弗杰伊弗吉屁杰勒马艾吾艾");
         this.field_404.add("♿♿♿♿");
         this.field_404.add("匕卄モ 匚丹Ｋモ 山丹ち 丹 ㄥ工モ");
         this.field_404.add("下丹Ｋモ 匚尺ㄚち匕丹ㄥち");
         this.field_404.add("♿" + Math.random() * (double)1387);
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_607() {
      return this.field_403;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_608() {
      return this.field_399;
   }

   // $FF: renamed from: c () java.util.concurrent.ConcurrentLinkedQueue
   @NotNull
   public ConcurrentLinkedQueue method_609() {
      return this.field_404;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_403.method_1979();
      this.method_606();
      if ((f8B)this.field_402.c() == f8B.field_1826) {
         if (this.field_404.isEmpty()) {
            Pyro.INSTANCE.sendMessage("Please fill the spammer file with content.");
         } else {
            Pyro.INSTANCE.sendMessage("Spammer file has " + this.field_404.size() + " lines to spam!");
         }
      }

   }
}
