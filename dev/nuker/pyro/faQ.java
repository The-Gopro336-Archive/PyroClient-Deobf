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

public class faq
extends far {
    public double Field1940;
    public double Field1941;
    public int Field1942 = 0;
    public int Field1943 = 2;

    @Override
    public void Method2364(f4p f4p2) {
        block22: {
            block23: {
                block21: {
                    block20: {
                        if (f4p2.Method7947()) break block20;
                        if (f4p2.Method5619() == f41.Pre) break block21;
                    }
                    return;
                }
                if (fec.Method725().collidedHorizontally || fec.Method725().moveForward == 0.0f && fec.Method725().moveStrafing == 0.0f) {
                    this.Field1942 = 0;
                    this.Field1943 = 2;
                    f4p2.Method7948();
                    f4p2.Method5837(0.0);
                    f4p2.Method5820(0.0);
                    f0b.Field5568.Method7904("longjump");
                    return;
                }
                if (((Boolean)PyroStatic.Field6455.Method276().Method7979()).booleanValue()) {
                    f0b.Field5568.Method7902("longjump", f07.MULTIPLY, 2.5f);
                }
                if (this.Field1943 > 0 && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
                    this.Field1940 = 0.09;
                    --this.Field1943;
                } else if (this.Field1942 == 1 && fec.Method725().collidedVertically && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
                    this.Field1940 = 1.0 + far.Method2606() - 0.05;
                } else if (this.Field1942 == 2 && fec.Method725().collidedVertically && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
                    fec.Method725().motionY = 0.415;
                    f4p2.Method5834(0.415);
                    this.Field1940 *= ((Double)PyroStatic.Field6455.Method5279().Method7979()).doubleValue();
                } else if (this.Field1942 == 3) {
                    double d = 0.66 * (this.Field1941 - far.Method2606());
                    this.Field1940 = this.Field1941 - d;
                } else {
                    this.Field1940 = this.Field1941 - this.Field1941 / 159.0;
                }
                f4p2.Method7948();
                fec.Method744(f4p2, this.Field1940);
                List list = faq.Field313.world.getCollisionBoxes((Entity)faq.Field313.player, faq.Field313.player.getEntityBoundingBox().offset(0.0, faq.Field313.player.motionY, 0.0));
                List list2 = faq.Field313.world.getCollisionBoxes((Entity)faq.Field313.player, faq.Field313.player.getEntityBoundingBox().offset(0.0, -0.4, 0.0));
                if (fec.Method725().collidedVertically) break block22;
                if (list.size() > 0) break block23;
                if (list2.size() <= 0) break block22;
            }
            if (this.Field1942 > 10) {
                if (this.Field1942 >= 38) {
                    fec.Method725().motionY = -0.4;
                    f4p2.Method5834(-0.4);
                    this.Field1942 = 0;
                    this.Field1943 = 5;
                } else {
                    fec.Method725().motionY = -0.001;
                    f4p2.Method5834(-0.001);
                }
            }
        }
        if (this.Field1943 <= 0 && (fec.Method725().moveForward != 0.0f || fec.Method725().moveStrafing != 0.0f)) {
            ++this.Field1942;
        }
    }

    @Override
    public void Method461() {
    }

    @Override
    public void Method2363(f4u f4u2) {
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        double d = faq.Field313.player.posX - faq.Field313.player.prevPosX;
        double d2 = faq.Field313.player.posZ - faq.Field313.player.prevPosZ;
        this.Field1941 = Math.sqrt(d * d + d2 * d2);
    }

    @Override
    public void Method455() {
    }
}

