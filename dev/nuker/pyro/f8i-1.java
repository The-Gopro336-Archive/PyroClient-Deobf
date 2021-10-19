/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import org.jetbrains.annotations.NotNull;

public class f8i extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_299;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_300;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_301;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_302;

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_438() {
      return this.field_302;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_439() {
      return this.field_299;
   }

   public f8i() {
      super("coordchat", "CoordChat", "Checks for coordinates sent in chat, and asks for confirmation");
      this.field_299 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f8h.field_1890)));
      this.field_300 = (BooleanSetting)this.register((f0w)(new BooleanSetting("ignoreCommands", "IgnoreCommands", "Don't check server commands", false)));
      this.field_301 = (BooleanSetting)this.register((f0w)(new BooleanSetting("msg", "/msg", "Don't check /msg", false)));
      this.field_302 = (BooleanSetting)this.register((f0w)(new BooleanSetting("msgFriends", "/msg friends", "Don't check /msg to friends", false)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4j) void
   @f0g(-10)
   @LauncherEventHide
   public void method_440(@NotNull f4j var1) {
      CharSequence var2 = (CharSequence)var1.method_3112();
      Regex var3 = ((f8h)this.field_299.c()).method_3044();
      boolean var4 = false;
      if (var3.matches(var2) && (!(Boolean)this.field_300.c() || !StringsKt.startsWith$default(var1.method_3112(), "/", false, 2, (Object)null))) {
         if ((Boolean)this.field_301.c()) {
            var2 = (CharSequence)var1.method_3112();
            var3 = new Regex("/(msg|w|whisper|tell).*");
            var4 = false;
            if (var3.matches(var2)) {
               return;
            }
         }

         if ((Boolean)this.field_302.c()) {
            var2 = (CharSequence)var1.method_3112();
            var3 = new Regex("/(msg|w|whisper|tell).*");
            var4 = false;
            if (var3.matches(var2)) {
               String var12 = var1.method_3112();
               boolean var13 = false;
               var4 = false;
               boolean var6 = false;
               String var7 = var1.method_3112();
               byte var8 = 1;
               boolean var9 = false;
               if (var7 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               byte var10000;
               label340: {
                  var7 = StringsKt.substringBefore$default(var7.substring(var8), " ", (String)null, 2, (Object)null);
                  switch(var7.hashCode()) {
                  case 119:
                     if (var7.equals("w")) {
                        var10000 = 1;
                        break label340;
                     }
                     break;
                  case 108417:
                     if (var7.equals("msg")) {
                        var10000 = 3;
                        break label340;
                     }
                     break;
                  case 3556273:
                     if (var7.equals("tell")) {
                        var10000 = 4;
                        break label340;
                     }
                     break;
                  case 1316693890:
                     if (var7.equals("whisper")) {
                        var10000 = 7;
                        break label340;
                     }
                  }

                  var10000 = -1;
               }

               byte var10 = var10000;
               boolean var16;
               if (var10 != -1) {
                  String var14 = var1.method_3112();
                  int var15 = var10 + 2;
                  boolean var11 = false;
                  if (var14 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  var7 = StringsKt.substringBefore$default(var14.substring(var15), " ", (String)null, 2, (Object)null);
                  var16 = FriendManager.Companion.isFriend(var7);
               } else {
                  var16 = false;
               }

               if (var16) {
                  return;
               }
            }
         }

         Pyro.INSTANCE.sendAndKeepMessage((new TextComponentString("Message seems to have coords ")).appendSibling((new TextComponentString("[SEND ANYWAY]")).setStyle((new Style()).setBold(true).setColor(TextFormatting.DARK_RED).setClickEvent(new ClickEvent(Action.RUN_COMMAND, Config.INSTANCE.chatPrefix + "say " + var1.method_3112())))));
         var1.0();
      }

   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_441() {
      return this.field_301;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_442() {
      return this.field_300;
   }
}
