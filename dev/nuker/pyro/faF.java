/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fec;
import java.util.List;
import net.minecraft.entity.Entity;

public class faF
extends far {
    public double Field1678 = faF.Method2606();
    public double Field1679;
    public int Field1680;

    @Override
    public void Method461() {
    }

    @Override
    public void Method455() {
    }

    @Override
    public void Method2364(f4p f4p2) {
        block25: {
            block24: {
                block23: {
                    block22: {
                        if (f4p2.Method5619() != f41.Pre) break block22;
                        if (!((Boolean)PyroStatic.Field6409.Field5236.Method5264()).booleanValue() && !f4p2.Method7947()) break block23;
                    }
                    return;
                }
                f4p2.Method7948();
                if (faF.Method2607(fec.Method725().posY - (double)((int)fec.Method725().posY), 3) == faF.Method2607(0.4, 3)) {
                    fec.Method725().motionY = 0.31;
                    f4p2.Method5834(0.31);
                } else if (faF.Method2607(fec.Method725().posY - (double)((int)fec.Method725().posY), 3) == faF.Method2607(0.71, 3)) {
                    fec.Method725().motionY = 0.04;
                    f4p2.Method5834(0.04);
                } else if (faF.Method2607(fec.Method725().posY - (double)((int)fec.Method725().posY), 3) == faF.Method2607(0.75, 3)) {
                    fec.Method725().motionY = -0.2;
                    f4p2.Method5834(-0.2);
                } else if (faF.Method2607(fec.Method725().posY - (double)((int)fec.Method725().posY), 3) == faF.Method2607(0.55, 3)) {
                    fec.Method725().motionY = -0.14;
                    f4p2.Method5834(-0.14);
                } else if (faF.Method2607(fec.Method725().posY - (double)((int)fec.Method725().posY), 3) == faF.Method2607(0.41, 3)) {
                    fec.Method725().motionY = -0.2;
                    f4p2.Method5834(-0.2);
                }
                if (this.Field1680 == 1 && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
                    this.Field1678 = 1.35 * faF.Method2606() - 0.01;
                } else if (this.Field1680 == 2 && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
                    fec.Method725().motionY = 0.4;
                    f4p2.Method5834(0.4);
                    this.Field1678 *= 2.149;
                } else if (this.Field1680 == 3) {
                    double d = 0.66 * (this.Field1679 - faF.Method2606());
                    this.Field1678 = this.Field1679 - d;
                } else {
                    List list = faF.Field313.world.getCollisionBoxes((Entity)faF.Field313.player, faF.Field313.player.getEntityBoundingBox().offset(0.0, faF.Field313.player.motionY, 0.0));
                    if ((list.size() > 0 || fec.Method725().collidedVertically) && this.Field1680 > 0) {
                        this.Field1680 = fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f ? 1 : 0;
                    }
                    this.Field1678 = this.Field1679 - this.Field1679 / 159.0;
                }
                this.Field1678 = Math.max(this.Field1678, faF.Method2606());
                fec.Method744(f4p2, this.Field1678);
                if (fec.Method725().moveForward != 0.0f) break block24;
                if (fec.Method725().moveStrafing == 0.0f) break block25;
            }
            ++this.Field1680;
        }
    }

    @Override
    public void Method2363(f4u f4u2) {
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        double d = faF.Field313.player.posX - faF.Field313.player.prevPosX;
        double d2 = faF.Field313.player.posZ - faF.Field313.player.prevPosZ;
        this.Field1679 = Math.sqrt(d * d + d2 * d2);
    }
}

