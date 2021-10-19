/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.callbacks.DisconnectedCallback;
import net.arikia.dev.drpc.callbacks.ErroredCallback;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// $FF: renamed from: dev.nuker.pyro.f4
public class class_9 {
   // $FF: renamed from: c long
   public static long field_2269;
   // $FF: renamed from: c java.lang.String[]
   @NotNull
   public static String[] field_2270;
   // $FF: renamed from: c dev.nuker.pyro.f4
   public static class_9 field_2271;

   // $FF: renamed from: 4 () java.lang.Boolean
   public Boolean method_3393() {
      return (Boolean)PyroStatic.field_2485.c.method_3034();
   }

   // $FF: renamed from: 3 () long
   public long method_3394() {
      return field_2269;
   }

   // $FF: renamed from: c () void
   public void method_3395() {
      try {
         if (this.method_3393()) {
            String var10000;
            boolean var7;
            label216: {
               if (field_2270[0] != null) {
                  var10000 = field_2270[0];
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var10000.length() > 1) {
                     var7 = true;
                     break label216;
                  }
               }

               var7 = false;
            }

            boolean var1;
            label208: {
               var1 = var7;
               if (field_2270[1] != null) {
                  var10000 = field_2270[1];
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var10000.length() > 1) {
                     var7 = true;
                     break label208;
                  }
               }

               var7 = false;
            }

            boolean var2 = var7;
            String var3 = var1 && var2 ? field_2270[1] : (var2 ? field_2270[1] : field_2270[0]);
            String var4 = var1 && var2 ? field_2270[0] : null;
            DiscordRichPresence.Builder var5 = (new DiscordRichPresence.Builder(var3)).setBigImage("logo", "https://pyroclient.com");
            if (var4 != null && var4.length() > 1) {
               var5.setDetails(var4);
            }

            var5.setStartTimestamps(field_2269);
            DiscordRPC.discordUpdatePresence(var5.build());
         }
      } catch (Throwable var6) {
         System.err.println("Could not update discord presence");
      }

   }

   // $FF: renamed from: 5 () void
   public void method_3396() {
      try {
         DiscordRPC.discordClearPresence();
      } catch (Throwable var2) {
         System.err.println("Could not update discord presence");
      }

   }

   // $FF: renamed from: 2 () java.lang.String[]
   @NotNull
   public String[] method_3397() {
      return field_2270;
   }

   // $FF: renamed from: c (int, java.lang.String) void
   public void method_3398(int var1, @Nullable String var2) {
      field_2270[var1] = var2;
      switch(var1) {
      case 0:
         Config.INSTANCE.rpcLine1 = var2;
         break;
      case 1:
         Config.INSTANCE.rpcLine2 = var2;
      }

      Config.Companion.save();
   }

   // $FF: renamed from: 0 () void
   public void method_3399() {
      try {
         DiscordEventHandlers var1 = (new DiscordEventHandlers.Builder()).setReadyEventHandler((ReadyCallback)class_10.field_2272).setErroredEventHandler((ErroredCallback)class_11.field_2273).setDisconnectedEventHandler((DisconnectedCallback)class_8.field_2268).build();
         DiscordRPC.discordInitialize("740056531286098001", var1, true);
         field_2270[0] = Config.INSTANCE.rpcLine1;
         field_2270[1] = Config.INSTANCE.rpcLine2;
         ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)class_1.field_15, 30, (Object)null);
      } catch (Throwable var2) {
         System.err.println("Could not initialize discord");
      }

   }

   static {
      class_9 var0 = new class_9();
      field_2271 = var0;
      field_2269 = System.currentTimeMillis();
      field_2270 = new String[]{(String)null, (String)null};
   }

   // $FF: renamed from: 1 () void
   public void method_3400() {
      this.method_3395();
   }
}
