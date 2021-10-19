/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import org.jetbrains.annotations.NotNull;

public class f8J extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_407 = (BooleanSetting)this.register((f0w)(new BooleanSetting("boats", "Boats", "Mounts boats", true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_408 = (BooleanSetting)this.register((f0w)(new BooleanSetting("horses", "Horses", "Mounts Horses", true)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_409 = (BooleanSetting)this.register((f0w)(new BooleanSetting("skeletonhorses", "SkeletonHorses", "Mounts SkeletonHorses", true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_410 = (BooleanSetting)this.register((f0w)(new BooleanSetting("donkeys", "Donkeys", "Mounts Donkeys", true)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_411 = (BooleanSetting)this.register((f0w)(new BooleanSetting("pigs", "Pigs", "Mounts Pigs", true)));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_412 = (BooleanSetting)this.register((f0w)(new BooleanSetting("llamas", "Llamas", "Mounts Llamas", true)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_413 = (DoubleSetting)this.register((f0w)(new DoubleSetting("range", "Range", "Range to search for mountable entities", 6.0D, 0.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_414 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", "Delay to use", 1.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_415 = new fe8();

   // $FF: renamed from: c (dev.nuker.pyro.f8J) net.minecraft.client.Minecraft
   public static Minecraft method_617(f8J var0) {
      return var0.c;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_618() {
      return this.field_413;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_619(@NotNull Entity var1) {
      if ((double)var1.getDistance((Entity)this.c.player) > ((Number)this.field_413.c()).doubleValue()) {
         return false;
      } else if (!this.c.player.canEntityBeSeen(var1) && var1.getDistanceSq((Entity)this.c.player) >= 9.0D) {
         return false;
      } else if (var1 instanceof AbstractHorse && ((AbstractHorse)var1).isChild()) {
         return false;
      } else if (var1 instanceof EntityBoat && (Boolean)this.field_407.c()) {
         return true;
      } else if (var1 instanceof EntitySkeletonHorse && (Boolean)this.field_409.c()) {
         return true;
      } else if (var1 instanceof EntityHorse && (Boolean)this.field_408.c()) {
         return true;
      } else if (var1 instanceof EntityDonkey && (Boolean)this.field_410.c()) {
         return true;
      } else if (var1 instanceof EntityPig && (Boolean)this.field_411.c()) {
         return ((EntityPig)var1).getSaddled();
      } else {
         return var1 instanceof EntityLlama && (Boolean)this.field_412.c() && !((EntityLlama)var1).isChild();
      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_620() {
      return this.field_407;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_621() {
      return this.field_414;
   }

   public f8J() {
      super("autoMount", "AutoMount", "Automatically mounts onto entities");
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_622() {
      return this.field_409;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_623() {
      return this.field_410;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_624(@NotNull fe8 var1) {
      this.field_415 = var1;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_625() {
      return this.field_415;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_626() {
      return this.field_411;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_627(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         if (!this.c.player.isRiding()) {
            Entity var2 = (Entity)this.c.world.loadedEntityList.stream().filter((Predicate)(new f8H(this))).min(Comparator.comparing((Function)(new f8I(this)))).orElse((Object)null);
            if (var2 != null) {
               fex var3 = few.method_1716().method_1725(var2.getEntityBoundingBox(), false, true, false, true);
               if (var3 != null) {
                  var1.0();
                  var1.method_3140(var3.method_2076().meth4());
                  var1.method_3139(var3.method_2076().meth3());
                  if (!this.field_415.method_1980(((Number)this.field_414.c()).doubleValue() * (double)1000)) {
                     return;
                  }

                  this.field_415.method_1979();
                  var1.method_3133((Consumer)(new f8G(this, var2)));
               }
            }

         }
      }
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_628() {
      return this.field_412;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_629() {
      return this.field_408;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f8J, net.minecraft.client.Minecraft) void
   public static void method_630(f8J var0, Minecraft var1) {
      var0.c = var1;
   }
}
