/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class f5X extends f5o {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1078 = (BooleanSetting)this.c((f0w)(new BooleanSetting("showFriends", "ShowFriends", (String)null, true)));

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1592(@NotNull f4t var1) {
      List var2 = fdZ.field_976.world.playerEntities;
      Iterator var4 = this.c.field_1084.iterator();

      while(var4.hasNext()) {
         f5k var3 = (f5k)var4.next();
         if (!var2.stream().anyMatch((Predicate)(new f5W(var3)))) {
            var3.method_1513();
         }
      }

      var4 = var2.iterator();

      while(true) {
         EntityPlayer var8;
         boolean var9;
         do {
            boolean var5;
            do {
               do {
                  if (!var4.hasNext()) {
                     return;
                  }

                  var8 = (EntityPlayer)var4.next();
               } while(Intrinsics.areEqual((Object)var8, (Object)fdZ.field_976.player));

               var5 = false;
               Iterator var7 = this.c.field_1084.iterator();

               while(var7.hasNext()) {
                  f5k var6 = (f5k)var7.next();
                  f5q var10000 = var6.field_1005;
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.TextRadarPlayer");
                  }

                  if (((f5Y)var10000).method_1569() == var8.getEntityId()) {
                     var10000 = var6.field_1005;
                     if (var10000 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.TextRadarPlayer");
                     }

                     ((f5Y)var10000).meth2();
                     boolean var10 = var6.field_1010;
                     var5 = true;
                     break;
                  }
               }
            } while(var5);

            var9 = FriendManager.Companion.isFriend(var8);
         } while(!(Boolean)this.field_1078.c() && var9);

         this.c.method_1614(new f5k("textRadarPlayer", "General", (f5q)(new f5Y(var8.getName(), var9, var8.getName(), var8.getEntityId())), (f5l)null, false, 24, (DefaultConstructorMarker)null), false);
      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1593() {
      return this.field_1078;
   }

   public f5X(int var1) {
      super("arrayList", var1);
   }
}
