/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraftforge.event.world.WorldEvent
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fev;
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

public class f6z
extends Module {
    public BooleanSetting Field3342 = (BooleanSetting)this.Method7264(new BooleanSetting("players", "Players", null, true));
    public BooleanSetting Field3343 = (BooleanSetting)this.Method7264(new BooleanSetting("monsters", "Monsters", null, false));
    public BooleanSetting Field3344 = (BooleanSetting)this.Method7264(new BooleanSetting("neutrals", "Neutrals", null, false));
    public BooleanSetting Field3345 = (BooleanSetting)this.Method7264(new BooleanSetting("animals", "Animals", null, false));
    public BooleanSetting Field3346 = (BooleanSetting)this.Method7264(new BooleanSetting("tamed", "Tamed", null, false));
    public BooleanSetting Field3347 = (BooleanSetting)this.Method7264(new BooleanSetting("invisibles", "Invisibles", null, true));
    public BooleanSetting Field3348 = (BooleanSetting)this.Method7264(new BooleanSetting("armorcheck", "ArmorCheck", null, true));
    public BooleanSetting Field3349 = (BooleanSetting)this.Method7264(new BooleanSetting("teams", "Teams", null, false));
    public EntityLivingBase Field3350 = null;
    public float Field3351;
    public float Field3352;

    public boolean Method5178(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayerSP) {
            return false;
        }
        if (entityLivingBase.isInvisible()) {
            if (!((Boolean)this.Field3347.Method7979()).booleanValue()) {
                return false;
            }
        }
        if (entityLivingBase instanceof EntityPlayer) {
            if (!((Boolean)this.Field3342.Method7979()).booleanValue()) {
                return false;
            }
            if (((Boolean)this.Field3348.Method7979()).booleanValue()) {
                boolean bl = false;
                for (ItemStack itemStack : ((EntityPlayer)entityLivingBase).inventory.armorInventory) {
                    if (itemStack.isEmpty()) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    return false;
                }
            }
            return !fdN.Method361(entityLivingBase) || (Boolean)this.Field3349.Method7979() != false;
        }
        if (fdN.Method351((Entity)entityLivingBase) && !((Boolean)this.Field3343.Method7979()).booleanValue()) {
            return false;
        }
        if (fdN.Method357((Entity)entityLivingBase) && !((Boolean)this.Field3344.Method7979()).booleanValue()) {
            return false;
        }
        if (fdN.Method363((Entity)entityLivingBase)) {
            boolean bl = false;
            if (entityLivingBase instanceof EntityTameable) {
                bl = true;
                if (((EntityTameable)entityLivingBase).isTamed()) {
                    if (!((Boolean)this.Field3346.Method7979()).booleanValue()) {
                        return false;
                    }
                }
            } else if (entityLivingBase instanceof AbstractHorse) {
                bl = true;
                if (((AbstractHorse)entityLivingBase).isTame()) {
                    if (!((Boolean)this.Field3346.Method7979()).booleanValue()) {
                        return false;
                    }
                }
            }
            if (!bl && !((Boolean)this.Field3345.Method7979()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public f6z() {
        super("bowaim", "BowAim", "Automatically aims your bow at targets");
    }

    public boolean Method4876() {
        return this.Field3350 != null && this.Field5233.player.getActiveItemStack().getItem() instanceof ItemBow;
    }

    @f0g
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre) {
            this.Field3350 = this.Method5180(f4u2, 360.0f);
            if (this.Method4876()) {
                float f;
                float f2;
                float f3 = (float)(this.Field5233.player.getActiveItemStack().getMaxItemUseDuration() - this.Field5233.player.getItemInUseCount()) / 20.0f;
                float f4 = (f3 * f3 + f3 * 2.0f) / 3.0f;
                if (f2 >= 1.0f) {
                    f4 = 1.0f;
                }
                if (Double.isNaN(f = (float)(-Math.toDegrees(this.Method5179(this.Field3350, f4 * 3.0f, 0.05f))))) {
                    return;
                }
                double d = this.Field3350.posX - this.Field3350.lastTickPosX;
                f4 = (float)(this.Field3350.posZ - this.Field3350.lastTickPosZ);
                double d2 = this.Field5233.player.getDistance((Entity)this.Field3350);
                double d3 = d2 - d2 % 2.0;
                boolean bl = this.Field3350.isSprinting();
                d = (float)(d3 / 2.0 * d * (bl ? 1.3 : 1.1));
                f4 = (float)(d3 / 2.0 * (double)f4 * (bl ? 1.3 : 1.1));
                d = (float)(this.Field3350.posX + d - this.Field5233.player.posX);
                f4u2.Method7948();
                this.Field3351 = (float)Math.toDegrees(Math.atan2(this.Field3350.posZ + (double)f4 - this.Field5233.player.posZ, d)) - 90.0f;
                f4u2.Method5653(this.Field3351);
                this.Field3352 = f;
                f4u2.Method5647(this.Field3352);
            }
        }
    }

    public float Method5179(EntityLivingBase entityLivingBase, double d, double d2) {
        double d3 = entityLivingBase.posY + (double)(entityLivingBase.getEyeHeight() / 2.0f) - (this.Field5233.player.posY + (double)this.Field5233.player.getEyeHeight());
        double d4 = entityLivingBase.posX - this.Field5233.player.posX;
        double d5 = entityLivingBase.posZ - this.Field5233.player.posZ;
        double d6 = d4;
        double d7 = d6 * d6;
        double d8 = d5;
        return this.Method5181(d, d2, Math.sqrt(d7 + d8 * d8), d3);
    }

    public EntityLivingBase Method5180(f4u f4u2, float f) {
        Iterator iterator2;
        float f2 = f;
        EntityLivingBase entityLivingBase = null;
        Iterator iterator3 = iterator2 = this.Field5233.world.loadedEntityList.iterator();
        while (iterator3.hasNext()) {
            float f3;
            Entity entity = (Entity)iterator2.next();
            if (!(entity instanceof EntityLivingBase)) {
                iterator3 = iterator2;
                continue;
            }
            EntityLivingBase entityLivingBase2 = (EntityLivingBase)entity;
            if (!this.Method5178(entityLivingBase2)) {
                iterator3 = iterator2;
                continue;
            }
            float[] arrf = this.Method5183(entityLivingBase2);
            float f4 = fev.Method825(f4u2.Method5817(), arrf[0]);
            float f5 = fev.Method825(f4u2.Method5651(), arrf[1]);
            if (f4 > f) {
                iterator3 = iterator2;
                continue;
            }
            if (f5 > f) {
                iterator3 = iterator2;
                continue;
            }
            float f6 = (f4 + f5) / 2.0f;
            if (f3 > f2) {
                iterator3 = iterator2;
                continue;
            }
            f2 = f6;
            entityLivingBase = entityLivingBase2;
            iterator3 = iterator2;
        }
        return entityLivingBase;
    }

    public float Method5181(double d, double d2, double d3, double d4) {
        double d5 = 2.0 * d4;
        double d6 = d;
        d4 = d5 * (d6 * d6);
        d4 = d2 * (d2 * (d3 * d3) + d4);
        double d7 = d;
        d4 = Math.sqrt(d7 * d7 * d * d - d4);
        double d8 = d;
        double d9 = d8 * d8 + d4;
        double d10 = d;
        d = d10 * d10 - d4;
        d4 = Math.atan2(d9, d2 * d3);
        d = Math.atan2(d, d2 * d3);
        return (float)Math.min(d4, d);
    }

    @f0g
    @LauncherEventHide
    public void Method5182(WorldEvent worldEvent) {
        this.Field3350 = null;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field3351 = 0.0f;
        this.Field3352 = 0.0f;
        this.Field3350 = null;
    }

    public float[] Method5183(EntityLivingBase entityLivingBase) {
        double d = entityLivingBase.posX - this.Field5233.player.posX;
        double d2 = entityLivingBase.posY - this.Field5233.player.posY + (double)(entityLivingBase.getEyeHeight() / 1.4f);
        double d3 = entityLivingBase.posZ - this.Field5233.player.posZ;
        double d4 = d;
        double d5 = d4 * d4;
        double d6 = d3;
        return new float[]{(float)(Math.atan2(d3, d) * 180.0 / Math.PI) - 90.0f, (float)(-(Math.atan2(d2, Math.sqrt(d5 + d6 * d6)) * 180.0 / Math.PI))};
    }
}

