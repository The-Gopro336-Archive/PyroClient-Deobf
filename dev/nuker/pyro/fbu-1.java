/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TypeCastException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityStatus;
import org.jetbrains.annotations.NotNull;

public class fbu extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_887;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_888;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_889;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_890;
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_891;
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_892;
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_893;
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_894;
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_895;
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_896;
   // $FF: renamed from: 8 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_897;
   // $FF: renamed from: 9 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_898;
   // $FF: renamed from: a dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_899;
   // $FF: renamed from: b dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_900;
   // $FF: renamed from: d dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_901;
   // $FF: renamed from: e dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_902;
   // $FF: renamed from: f dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_903;

   // $FF: renamed from: 8 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1317() {
      return this.field_890;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_1318(@NotNull f4e var1) {
      if (this.c.world != null) {
         if (var1.c() == f41.field_2120) {
            if (this.c.world != null && this.c.player != null) {
               if (var1.c() instanceof SPacketEntityStatus && (Boolean)this.field_891.c()) {
                  Packet var10000 = var1.c();
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntityStatus");
                  }

                  SPacketEntityStatus var2 = (SPacketEntityStatus)var10000;
                  if (var2.getOpCode() == 35) {
                     var1.0();
                  }
               }

            }
         }
      }
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1319() {
      return this.field_891;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1320() {
      return this.field_902;
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1321() {
      return this.field_897;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1322(@NotNull f4t var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      Iterable var4 = (Iterable)this.c.world.loadedEntityList;
      boolean var5 = false;
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         Entity var8 = (Entity)var7;
         boolean var9 = false;
         if ((Boolean)this.field_902.c() && var8 instanceof EntityFallingBlock) {
            var2.add(var8);
         }

         if ((fbt)this.field_887.c() == fbt.field_959 && var8 instanceof EntityItem) {
            var3.add(var8);
         }
      }

      Iterator var12;
      if ((Boolean)this.field_902.c()) {
         var12 = var2.iterator();

         while(var12.hasNext()) {
            EntityFallingBlock var10 = (EntityFallingBlock)var12.next();
            this.c.world.removeEntityFromWorld(var10.getEntityId());
         }
      }

      if ((fbt)this.field_887.c() == fbt.field_959) {
         var12 = var3.iterator();

         while(var12.hasNext()) {
            EntityItem var11 = (EntityItem)var12.next();
            this.c.world.removeEntityFromWorld(var11.getEntityId());
         }
      }

   }

   // $FF: renamed from: f () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1323() {
      return this.field_894;
   }

   // $FF: renamed from: d () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1324() {
      return this.field_896;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1325() {
      return this.field_893;
   }

   // $FF: renamed from: g () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1326() {
      return this.field_901;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1327() {
      return this.field_900;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1328(@NotNull f43 var1) {
      if (this.c.player != null && (double)this.c.player.timeInPortal > 0.1D && (Boolean)this.field_893.c()) {
         this.c.player.timeInPortal = 0.1F;
      }

   }

   // $FF: renamed from: 5 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1329() {
      return this.field_887;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1330() {
      return this.field_903;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1331() {
      return this.field_895;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1332() {
      return this.field_889;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1333() {
      return this.field_892;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1334() {
      return this.field_888;
   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1335() {
      return this.field_899;
   }

   public fbu() {
      super("norender", "NoRender", "Dosen't render certain things in the world", true);
      this.field_887 = (f0o)this.register((f0w)(new f0o("items", "Items", (String)null, (Enum)fbt.field_957)));
      this.field_888 = (BooleanSetting)this.register((f0w)(new BooleanSetting("fire", "Fire", (String)null, true)));
      this.field_889 = (BooleanSetting)this.register((f0w)(new BooleanSetting("water", "Water", (String)null, true)));
      this.field_890 = (BooleanSetting)this.register((f0w)(new BooleanSetting("blocks", "Suffocation", (String)null, true)));
      this.field_891 = (BooleanSetting)this.register((f0w)(new BooleanSetting("totem", "Totem", (String)null, false)));
      this.field_892 = (BooleanSetting)this.register((f0w)(new BooleanSetting("hurtcam", "Hurtcam", (String)null, false)));
      this.field_893 = (BooleanSetting)this.register((f0w)(new BooleanSetting("portal", "Portal", (String)null, true)));
      this.field_894 = (BooleanSetting)this.register((f0w)(new BooleanSetting("liquid_fog", "Liquid Fog", (String)null, true)));
      this.field_895 = (BooleanSetting)this.register((f0w)(new BooleanSetting("fog", "Fog", (String)null, true)));
      this.field_896 = (BooleanSetting)this.register((f0w)(new BooleanSetting("blindness", "Blindness", (String)null, true)));
      this.field_897 = (BooleanSetting)this.register((f0w)(new BooleanSetting("boss_color", "Wither Coloring", (String)null, true)));
      this.field_898 = (BooleanSetting)this.register((f0w)(new BooleanSetting("vignette", "Vignette", (String)null, false)));
      this.field_899 = (BooleanSetting)this.register((f0w)(new BooleanSetting("skylight", "Skylight Updates", (String)null, false)));
      this.field_900 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noArmor", "NoArmor", "Doesn't render armor", false)));
      this.field_901 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noSignText", "NoSignText", "Doesn't render sign text", false)));
      this.field_902 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noFallingBlocks", "NoFallingBlocks", "Doesn't render falling blocks", false)));
      this.field_903 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noBossHealth", "NoBossHealth", "Prevents rendering boss health (Withers)", false)));
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1336() {
      return this.field_898;
   }
}
