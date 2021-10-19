/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import org.jetbrains.annotations.Nullable;

public class fbv {
   // $FF: renamed from: c (dev.nuker.pyro.f00, dev.nuker.pyro.f00, double) dev.nuker.pyro.f0w[]
   public f0w[] method_1412(f00 var1, f00 var2, double var3) {
      return new f0w[]{(f0w)(new BooleanSetting("flat_color", "Flat Color", "Use only the far color", false)), (f0w)(new f0l("far_color", "Far Color", "Color used when entities are far away", var1)), (f0w)(new f0l("near_color", "Near Color", "Color used when entities are near", var2)), (f0w)(new DoubleSetting("scale", "Arrow Scale", (String)null, var3, 0.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null))};
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_1413(@Nullable Entity var1) {
      if (var1 instanceof EntityWolf && ((EntityWolf)var1).isAngry()) {
         return false;
      } else if (!(var1 instanceof EntityAnimal) && !(var1 instanceof EntityAgeable) && !(var1 instanceof EntityTameable) && !(var1 instanceof EntityAmbientCreature) && !(var1 instanceof EntitySquid)) {
         return var1 instanceof EntityIronGolem && ((EntityIronGolem)var1).getRevengeTarget() == null;
      } else {
         return true;
      }
   }

   public fbv(DefaultConstructorMarker var1) {
      this();
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbv, dev.nuker.pyro.f00, dev.nuker.pyro.f00, double) dev.nuker.pyro.f0w[]
   public static f0w[] method_1414(fbv var0, f00 var1, f00 var2, double var3) {
      return var0.method_1412(var1, var2, var3);
   }

   public fbv() {
   }
}
