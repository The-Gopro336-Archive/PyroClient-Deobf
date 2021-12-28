/*
 * Decompiled with CFR 0.150.
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

public class fan
extends far {
    public double Field1990;
    public double Field1991;
    public int Field1992 = 0;
    public int Field1993 = 0;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method2364(f4p f4p2) {
        if (f4p2.Method7947() || f4p2.Method5619() != f41.Pre) {
            return;
        }
        if (fec.Method725().collidedHorizontally || this.Field1993 > 0 || fec.Method725().moveForward == 0.0f && fec.Method725().moveStrafing == 0.0f) {
            if (this.Field1993 > 0) {
                --this.Field1993;
            }
            this.Field1992 = 0;
            this.Field1990 = 0.0;
            this.Field1991 = 0.0;
            f4p2.Method7948();
            f4p2.Method5837(0.0);
            f4p2.Method5820(0.0);
            f0b.Field5568.Method7904("longjump");
            return;
        }
        if (((Boolean)PyroStatic.Field6455.Method276().Method7979()).booleanValue()) {
            f0b.Field5568.Method7902("longjump", f07.MULTIPLY, 2.5f);
        }
        if (this.Field1992 == 1 && fec.Method725().collidedVertically) {
            this.Field1990 = 1.0 + far.Method2606() - 0.05;
        } else if (this.Field1992 == 2 && fec.Method725().collidedVertically) {
            fec.Method725().motionY = 0.415;
            f4p2.Method5834(0.415);
            this.Field1990 *= ((Double)PyroStatic.Field6455.Method5279().Method7979()).doubleValue();
        } else if (this.Field1992 == 3) {
            double d = 0.66 * (this.Field1991 - far.Method2606());
            this.Field1990 = this.Field1991 - d;
        } else {
            this.Field1990 = this.Field1991 - this.Field1991 / 159.0;
            if (fec.Method725().collidedVertically && this.Field1992 > 3) {
                this.Field1993 = 10;
                this.Field1992 = 1;
            }
        }
        f4p2.Method7948();
        this.Field1990 = Math.max(this.Field1990, fan.Method2606());
        fec.Method744(f4p2, this.Field1990);
        ++this.Field1992;
    }

    @Override
    public void Method455() {
    }

    @Override
    public void Method461() {
    }

    @Override
    public void Method2363(f4u f4u2) {
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        double d = fan.Field313.player.posX - fan.Field313.player.prevPosX;
        double d2 = fan.Field313.player.posZ - fan.Field313.player.prevPosZ;
        this.Field1991 = Math.sqrt(d * d + d2 * d2);
        f4u2.Method7948();
        f4u2.Method5597(true);
    }
}

