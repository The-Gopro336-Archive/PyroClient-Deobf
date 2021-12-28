/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class58;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.fe4;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.fed;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f6A
extends Module {
    public f0l Field2915 = new f0l("renderBlockColor", "RenderBlockColor", null, new f00(0.8527778f, 1.0f, 0.5f, 0.3f));
    public BlockPos Field2916 = null;

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (Class58.Field4487.Method5755() != null && Class58.Field4487.Method5755() == this) {
            Class58.Field4487.Method4824(false);
            return;
        }
        if (bl) {
            for (EntityPlayer entityPlayer : this.Field5233.world.playerEntities) {
                if (entityPlayer.isEntityAlive() && !(entityPlayer instanceof EntityPlayerSP) && fe4.Field250.Method387(entityPlayer)) {
                    for (BlockPos blockPos : PyroStatic.Field6495.Method2381(entityPlayer)) {
                        if (!feg.Method689(blockPos)) continue;
                        this.Field2916 = blockPos;
                        break;
                    }
                }
                if (this.Field2916 == null) continue;
                break;
            }
            if (this.Field2916 != null) {
                Class58.Field4487.Method6420(this, this.Field2916, true, this::Method4806);
            } else {
                Pyro.Field6182.Method8989("There is no one to CityBoss!");
                this.Field5236.Method5266(false);
            }
        }
    }

    @f0g
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre) {
            if (!f4u2.Method7947()) {
                if (Class58.Field4487.Method5755() != null) {
                    if (Class58.Field4487.Method5755() != this) {
                        Pyro.Field6182.Method8989("CityBoss disabling due to an override!");
                        this.Field5236.Method5266(false);
                        return;
                    }
                }
                if (Class58.Field4487.Method5755() == this) {
                    if (this.Field2916 != null) {
                        float[] arrf = fed.Method664((double)this.Field2916.getX() + 0.5, (double)this.Field2916.getY() - 0.5, (double)this.Field2916.getZ() + 0.5);
                        f4u2.Method7948();
                        f4u2.Method5653(arrf[0]);
                        f4u2.Method5647(arrf[1]);
                        return;
                    }
                }
                Pyro.Field6182.Method8989("CityBoss disabling due to completion");
                this.Field5236.Method5266(false);
            }
        }
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        if (this.Field2916 != null) {
            fe5.Field252.Method408(7);
            fe5.Field252.Method410(this.Field2916, ((f00)this.Field2915.Method7979()).Method7515(), 63);
            fe5.Field252.Method405();
        }
    }

    public void Method4806(Boolean bl) {
        this.Field2916 = null;
    }

    public f6A() {
        super("cityboss", "CityBoss", "Mines a block by an opponent that can be city bossed");
        this.Method7264(this.Field2915);
    }
}

