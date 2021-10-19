/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import org.jetbrains.annotations.Nullable;

public class f6z extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_432 = (BooleanSetting)this.register(new BooleanSetting("players", "Players", (String)null, true));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_433 = (BooleanSetting)this.register(new BooleanSetting("monsters", "Monsters", (String)null, false));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_434 = (BooleanSetting)this.register(new BooleanSetting("neutrals", "Neutrals", (String)null, false));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_435 = (BooleanSetting)this.register(new BooleanSetting("animals", "Animals", (String)null, false));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_436 = (BooleanSetting)this.register(new BooleanSetting("tamed", "Tamed", (String)null, false));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_437 = (BooleanSetting)this.register(new BooleanSetting("invisibles", "Invisibles", (String)null, true));
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_438 = (BooleanSetting)this.register(new BooleanSetting("armorcheck", "ArmorCheck", (String)null, true));
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_439 = (BooleanSetting)this.register(new BooleanSetting("teams", "Teams", (String)null, false));
   // $FF: renamed from: c net.minecraft.entity.EntityLivingBase
   public EntityLivingBase field_440 = null;
   // $FF: renamed from: c float
   public float field_441;
   // $FF: renamed from: 0 float
   public float field_442;

   // $FF: renamed from: c (net.minecraft.entity.EntityLivingBase) boolean
   public boolean method_647(EntityLivingBase var1) {
      if (var1 instanceof EntityPlayerSP) {
         return false;
      } else if (var1.isInvisible() && !(Boolean)this.field_437.c()) {
         return false;
      } else {
         boolean var2;
         if (var1 instanceof EntityPlayer) {
            if (!(Boolean)this.field_432.c()) {
               return false;
            } else {
               if ((Boolean)this.field_438.c()) {
                  var2 = false;
                  Iterator var3 = ((EntityPlayer)var1).inventory.armorInventory.iterator();

                  while(var3.hasNext()) {
                     ItemStack var4 = (ItemStack)var3.next();
                     if (!var4.isEmpty()) {
                        var2 = true;
                        break;
                     }
                  }

                  if (!var2) {
                     return false;
                  }
               }

               return !fdN.method_1872(var1) || (Boolean)this.field_439.c();
            }
         } else if (fdN.method_1862(var1) && !(Boolean)this.field_433.c()) {
            return false;
         } else if (fdN.method_1868(var1) && !(Boolean)this.field_434.c()) {
            return false;
         } else {
            if (fdN.method_1874(var1)) {
               var2 = false;
               if (var1 instanceof EntityTameable) {
                  var2 = true;
                  if (((EntityTameable)var1).isTamed() && !(Boolean)this.field_436.c()) {
                     return false;
                  }
               } else if (var1 instanceof AbstractHorse) {
                  var2 = true;
                  if (((AbstractHorse)var1).isTame() && !(Boolean)this.field_436.c()) {
                     return false;
                  }
               }

               if (!var2 && !(Boolean)this.field_435.c()) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public f6z() {
      super("bowaim", "BowAim", "Automatically aims your bow at targets");
   }

   // $FF: renamed from: c () boolean
   public boolean method_648() {
      return this.field_440 != null && this.c.player.getActiveItemStack().getItem() instanceof ItemBow;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_649(f4u var1) {
      if (var1.c() == f41.field_2120) {
         this.field_440 = this.method_651(var1, 360.0F);
         if (this.method_648()) {
            float var2 = (float)(this.c.player.getActiveItemStack().getMaxItemUseDuration() - this.c.player.getItemInUseCount()) / 20.0F;
            float var3;
            if ((var3 = (var2 * var2 + var2 * 2.0F) / 3.0F) >= 1.0F) {
               var3 = 1.0F;
            }

            float var4;
            if (Double.isNaN((double)(var4 = (float)(-Math.toDegrees((double)this.method_650(this.field_440, (double)(var3 * 3.0F), 0.05000000074505806D)))))) {
               return;
            }

            double var5 = this.field_440.posX - this.field_440.lastTickPosX;
            var3 = (float)(this.field_440.posZ - this.field_440.lastTickPosZ);
            double var7 = (double)this.c.player.getDistance(this.field_440);
            double var9 = var7 - var7 % 2.0D;
            boolean var11 = this.field_440.isSprinting();
            var5 = (double)((float)(var9 / 2.0D * var5 * (var11 ? 1.3D : 1.1D)));
            var3 = (float)(var9 / 2.0D * (double)var3 * (var11 ? 1.3D : 1.1D));
            var5 = (double)((float)(this.field_440.posX + var5 - this.c.player.posX));
            var1.0();
            var1.method_3139(this.field_441 = (float)Math.toDegrees(Math.atan2(this.field_440.posZ + (double)var3 - this.c.player.posZ, var5)) - 90.0F);
            var1.method_3140(this.field_442 = var4);
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.entity.EntityLivingBase, double, double) float
   public float method_650(EntityLivingBase var1, double var2, double var4) {
      double var6 = var1.posY + (double)(var1.getEyeHeight() / 2.0F) - (this.c.player.posY + (double)this.c.player.getEyeHeight());
      double var8 = var1.posX - this.c.player.posX;
      double var10 = var1.posZ - this.c.player.posZ;
      double var14 = var8 * var8;
      return this.method_652(var2, var4, Math.sqrt(var14 + var10 * var10), var6);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u, float) net.minecraft.entity.EntityLivingBase
   public EntityLivingBase method_651(f4u var1, float var2) {
      float var3 = var2;
      EntityLivingBase var4 = null;
      Iterator var5;
      Iterator var6 = var5 = this.c.world.loadedEntityList.iterator();

      while(var6.hasNext()) {
         Entity var7;
         if (!((var7 = (Entity)var5.next()) instanceof EntityLivingBase)) {
            var6 = var5;
         } else {
            EntityLivingBase var8 = (EntityLivingBase)var7;
            if (!this.method_647(var8)) {
               var6 = var5;
            } else {
               float[] var9 = this.method_654(var8);
               float var10 = fev.method_1742(var1.method_3134(), var9[0]);
               float var11 = fev.method_1742(var1.method_3131(), var9[1]);
               if (var10 > var2) {
                  var6 = var5;
               } else if (var11 > var2) {
                  var6 = var5;
               } else {
                  float var12;
                  if ((var12 = (var10 + var11) / 2.0F) > var3) {
                     var6 = var5;
                  } else {
                     var3 = var12;
                     var4 = var8;
                     var6 = var5;
                  }
               }
            }
         }
      }

      return var4;
   }

   // $FF: renamed from: c (double, double, double, double) float
   public float method_652(double var1, double var3, double var5, double var7) {
      double var9 = 2.0D * var7;
      var7 = var9 * var1 * var1;
      var7 = var3 * (var3 * var5 * var5 + var7);
      var7 = Math.sqrt(var1 * var1 * var1 * var1 - var7);
      double var17 = var1 * var1 + var7;
      var1 = var1 * var1 - var7;
      var7 = Math.atan2(var17, var3 * var5);
      var1 = Math.atan2(var1, var3 * var5);
      return (float)Math.min(var7, var1);
   }

   // $FF: renamed from: c (net.minecraftforge.event.world.WorldEvent) void
   @f0g
   @LauncherEventHide
   public void method_653(WorldEvent var1) {
      this.field_440 = null;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_441 = 0.0F;
      this.field_442 = 0.0F;
      this.field_440 = null;
   }

   // $FF: renamed from: 0 (net.minecraft.entity.EntityLivingBase) float[]
   public float[] method_654(EntityLivingBase var1) {
      double var2 = var1.posX - this.c.player.posX;
      double var4 = var1.posY - this.c.player.posY + (double)(var1.getEyeHeight() / 1.4F);
      double var6 = var1.posZ - this.c.player.posZ;
      double var10 = var2 * var2;
      return new float[]{(float)(Math.atan2(var6, var2) * 180.0D / 3.141592653589793D) - 90.0F, (float)(-(Math.atan2(var4, Math.sqrt(var10 + var6 * var6)) * 180.0D / 3.141592653589793D))};
   }
}
