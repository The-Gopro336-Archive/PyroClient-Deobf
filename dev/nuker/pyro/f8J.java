/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.entity.passive.EntitySkeletonHorse
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f8G;
import dev.nuker.pyro.f8H;
import dev.nuker.pyro.f8I;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.few;
import dev.nuker.pyro.fex;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Comparator;
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

public class f8J
extends Module {
    @NotNull
    public BooleanSetting Field3381 = (BooleanSetting)this.Method7264(new BooleanSetting("boats", "Boats", "Mounts boats", true));
    @NotNull
    public BooleanSetting Field3382 = (BooleanSetting)this.Method7264(new BooleanSetting("horses", "Horses", "Mounts Horses", true));
    @NotNull
    public BooleanSetting Field3383 = (BooleanSetting)this.Method7264(new BooleanSetting("skeletonhorses", "SkeletonHorses", "Mounts SkeletonHorses", true));
    @NotNull
    public BooleanSetting Field3384 = (BooleanSetting)this.Method7264(new BooleanSetting("donkeys", "Donkeys", "Mounts Donkeys", true));
    @NotNull
    public BooleanSetting Field3385 = (BooleanSetting)this.Method7264(new BooleanSetting("pigs", "Pigs", "Mounts Pigs", true));
    @NotNull
    public BooleanSetting Field3386 = (BooleanSetting)this.Method7264(new BooleanSetting("llamas", "Llamas", "Mounts Llamas", true));
    @NotNull
    public DoubleSetting Field3387 = (DoubleSetting)this.Method7264(new DoubleSetting("range", "Range", "Range to search for mountable entities", 6.0, 0.0, 6.0, 0.0, 64, null));
    @NotNull
    public DoubleSetting Field3388 = (DoubleSetting)this.Method7264(new DoubleSetting("delay", "Delay", "Delay to use", 1.0, 0.0, 10.0, 0.0, 64, null));
    @NotNull
    public fe8 Field3389 = new fe8();

    public static Minecraft Method5200(f8J f8J2) {
        return f8J2.Field5233;
    }

    @NotNull
    public DoubleSetting Method226() {
        return this.Field3387;
    }

    public boolean Method2425(@NotNull Entity entity) {
        if ((double)entity.getDistance((Entity)this.Field5233.player) > ((Number)this.Field3387.Method7979()).doubleValue()) {
            return false;
        }
        if (!this.Field5233.player.canEntityBeSeen(entity) && entity.getDistanceSq((Entity)this.Field5233.player) >= 9.0) {
            return false;
        }
        if (entity instanceof AbstractHorse && ((AbstractHorse)entity).isChild()) {
            return false;
        }
        if (entity instanceof EntityBoat && ((Boolean)this.Field3381.Method7979()).booleanValue()) {
            return true;
        }
        if (entity instanceof EntitySkeletonHorse) {
            if (((Boolean)this.Field3383.Method7979()).booleanValue()) {
                return true;
            }
        }
        if (entity instanceof EntityHorse) {
            if (((Boolean)this.Field3382.Method7979()).booleanValue()) {
                return true;
            }
        }
        if (entity instanceof EntityDonkey && ((Boolean)this.Field3384.Method7979()).booleanValue()) {
            return true;
        }
        if (entity instanceof EntityPig && ((Boolean)this.Field3385.Method7979()).booleanValue()) {
            return ((EntityPig)entity).getSaddled();
        }
        return entity instanceof EntityLlama && (Boolean)this.Field3386.Method7979() != false && !((EntityLlama)entity).isChild();
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field3381;
    }

    @NotNull
    public DoubleSetting Method219() {
        return this.Field3388;
    }

    public f8J() {
        super("autoMount", "AutoMount", "Automatically mounts onto entities");
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field3383;
    }

    @NotNull
    public BooleanSetting Method279() {
        return this.Field3384;
    }

    public void Method4965(@NotNull fe8 fe82) {
        this.Field3389 = fe82;
    }

    @NotNull
    public fe8 Method5201() {
        return this.Field3389;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3385;
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        fex fex2;
        if (f4u2.Method5619() != f41.Pre || f4u2.Method7947()) {
            return;
        }
        if (this.Field5233.player.isRiding()) {
            return;
        }
        Entity entity = this.Field5233.world.loadedEntityList.stream().filter(new f8H(this)).min(Comparator.comparing(new f8I(this))).orElse(null);
        if (entity != null && (fex2 = few.Method835().Method843(entity.getEntityBoundingBox(), false, true, false, true)) != null) {
            f4u2.Method7948();
            f4u2.Method5647(fex2.Method891().Method6936());
            f4u2.Method5653(fex2.Method891().Method6942());
            if (!this.Field3389.Method491(((Number)this.Field3388.Method7979()).doubleValue() * (double)1000)) {
                return;
            }
            this.Field3389.Method490();
            f4u2.Method5816(new f8G(this, entity));
        }
    }

    @NotNull
    public BooleanSetting Method276() {
        return this.Field3386;
    }

    @NotNull
    public BooleanSetting Method2424() {
        return this.Field3382;
    }

    public static void Method5202(f8J f8J2, Minecraft minecraft) {
        f8J2.Field5233 = minecraft;
    }
}

