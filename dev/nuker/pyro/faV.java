/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fec;
import java.util.List;
import net.minecraft.entity.Entity;

public class fav
extends far {
    public double Field2026 = fav.Method2606();
    public double Field2027;
    public int Field2028;
    public int Field2029 = 0;

    @Override
    public void Method2363(f4u f4u2) {
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        double d = fav.Field313.player.posX - fav.Field313.player.prevPosX;
        double d2 = fav.Field313.player.posZ - fav.Field313.player.prevPosZ;
        this.Field2027 = Math.sqrt(d * d + d2 * d2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method2364(f4p f4p2) {
        if (f4p2.Method5619() != f41.Pre) return;
        if (((Boolean)PyroStatic.Field6409.Field5236.Method5264()).booleanValue()) {
            return;
        }
        if (f4p2.Method7947()) {
            return;
        }
        if (!fec.Method727()) {
            this.Field2029 = 0;
            f0b.Field5568.Method7904("speedhax");
            f0b.Field5568.Method7904("speeedupp");
            return;
        }
        if (fav.Field313.player.fallDistance > 5.0f) {
            return;
        }
        ++this.Field2029;
        if (((Boolean)PyroStatic.Field6430.Method213().Method7979()).booleanValue()) {
            f0b.Field5568.Method7902("speedhax", f07.MULTIPLY, 1.088f);
            if (this.Field2029 >= 50) {
                f0b.Field5568.Method7904("speedhax");
                f0b.Field5568.Method7902("speeedupp", f07.MULTIPLY, 1.2f);
                if (this.Field2029 > 52) {
                    this.Field2029 = 0;
                }
            } else {
                f0b.Field5568.Method7904("speeedupp");
            }
        }
        if (((Boolean)PyroStatic.Field6406.Field5236.Method5264()).booleanValue() && PyroStatic.Field6406.Method5402((Double)PyroStatic.Field6406.Field3627.Method7979()) > 0.0) {
            return;
        }
        if (this.Field2028 == 1 && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
            this.Field2026 = 1.35 * fav.Method2606() - 0.01;
        } else if (this.Field2028 == 2 && fav.Field313.player.collidedVertically && (fav.Field313.player.moveForward != 0.0f || fav.Field313.player.moveStrafing != 0.0f)) {
            f4p2.Method7948();
            fav.Field313.player.motionY = 0.3994f;
            f4p2.Method5834(0.3994f);
            this.Field2026 *= 3.0;
        } else if (this.Field2028 == 3) {
            double d = 0.66 * (this.Field2027 - fav.Method2606());
            this.Field2026 = this.Field2027 - d;
        } else {
            List list = fav.Field313.world.getCollisionBoxes((Entity)fav.Field313.player, fav.Field313.player.getEntityBoundingBox().offset(0.0, fav.Field313.player.motionY, 0.0));
            if ((list.size() > 0 || fec.Method725().collidedVertically) && this.Field2028 > 0) {
                this.Field2028 = fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f ? 1 : 0;
            }
            this.Field2026 = this.Field2027 - this.Field2027 / 159.0;
        }
        this.Field2026 = Math.max(this.Field2026, fav.Method2606());
        this.Field2026 = Math.min(this.Field2026, 0.551);
        f4p2.Method7948();
        fec.Method744(f4p2, this.Field2026);
        if (fav.Field313.player.moveForward == 0.0f) {
            if (fav.Field313.player.moveStrafing == 0.0f) return;
        }
        ++this.Field2028;
    }

    @Override
    public void Method461() {
        this.Field2029 = 0;
    }

    @Override
    public void Method455() {
    }
}

