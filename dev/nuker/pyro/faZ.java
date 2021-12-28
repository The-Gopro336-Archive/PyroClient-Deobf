/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
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
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class faz
extends far {
    public double Field2013 = far.Method2606();
    public double Field2014;
    public int Field2015 = 4;
    public int Field2016;
    public boolean Field2017;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method2364(@NotNull f4p f4p2) {
        int n;
        double d;
        if (f4p2.Method5619() != f41.Pre) return;
        if (((Boolean)PyroStatic.Field6409.Field5236.Method5264()).booleanValue()) {
            return;
        }
        boolean bl = f4p2.Method7947();
        if (bl) {
            return;
        }
        if (!fec.Method727() || far.Field313.player.fallDistance > 5.0f) {
            f0b.Field5568.Method7904("speedhax");
            return;
        }
        if (((Boolean)PyroStatic.Field6406.Field5236.Method5264()).booleanValue() && PyroStatic.Field6406.Method5402(((Number)PyroStatic.Field6406.Field3627.Method7979()).doubleValue()) > (double)0.0f) {
            return;
        }
        if (((Boolean)PyroStatic.Field6430.Method213().Method7979()).booleanValue()) {
            f0b.Field5568.Method7902("speedhax", f07.MULTIPLY, 1.088f);
        }
        if (far.Field313.player.collidedHorizontally) {
            if (far.Field313.player.onGround && (d = PyroStatic.Field6406.Method5402(1.0)) == 1.0) {
                n = this.Field2016;
                this.Field2016 = n + 1;
            }
            if (this.Field2016 > 0) {
                switch (this.Field2016) {
                    case 1: {
                        f4p2.Method7948();
                        f4p2.Method5834(0.41999998688698);
                        int n2 = this.Field2016;
                        this.Field2016 = n2 + 1;
                        return;
                    }
                    case 2: {
                        f4p2.Method7948();
                        f4p2.Method5834(0.33319999363422);
                        int n3 = this.Field2016;
                        this.Field2016 = n3 + 1;
                        return;
                    }
                    case 3: {
                        float f = (float)fec.Method718();
                        f4p2.Method5834(0.24813599859094704);
                        f4p2.Method5837((double)(-MathHelper.sin((float)f)) * 0.2);
                        f4p2.Method5820((double)MathHelper.cos((float)f) * 0.2);
                        this.Field2016 = 0;
                        far.Field313.player.motionY = 0.0;
                        f4p2.Method7948();
                        return;
                    }
                }
                return;
            }
        }
        this.Field2016 = 0;
        if (this.Field2015 == 1 && (far.Field313.player.moveForward != 0.0f || far.Field313.player.moveStrafing != 0.0f)) {
            this.Field2013 = 1.35 * far.Method2606() - 0.01;
        } else if (this.Field2015 == 2 && far.Field313.player.collidedVertically) {
            d = 0.4;
            f4p f4p3 = f4p2;
            boolean bl2 = false;
            n = 0;
            double d2 = d;
            boolean bl3 = false;
            far.Field313.player.motionY = d2;
            double d3 = d;
            f4p3.Method5834(d3);
            this.Field2017 = !this.Field2017;
            this.Field2013 *= this.Field2017 ? 1.6835 : 1.395;
        } else if (this.Field2015 == 3) {
            d = 0.66 * (this.Field2014 - far.Method2606());
            this.Field2013 = this.Field2014 - d;
        } else {
            List list = far.Field313.world.getCollisionBoxes((Entity)far.Field313.player, far.Field313.player.getEntityBoundingBox().offset(0.0, far.Field313.player.motionY, 0.0));
            if ((list.size() > 0 || far.Field313.player.collidedVertically) && this.Field2015 > 0) {
                this.Field2015 = 1;
            }
            this.Field2013 = this.Field2014 - this.Field2014 / 159.0;
        }
        f4p2.Method7948();
        this.Field2013 = Math.max(this.Field2013, far.Method2606());
        fec.Method744(f4p2, this.Field2013);
        ++this.Field2015;
    }

    public int Method2679() {
        return this.Field2015;
    }

    public void Method2680(int n) {
        this.Field2015 = n;
    }

    @Override
    public void Method2363(@NotNull f4u f4u2) {
        double d;
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        double d2 = far.Field313.player.posX - far.Field313.player.prevPosX;
        double d3 = far.Field313.player.posZ - far.Field313.player.prevPosZ;
        double d4 = d2 * d2 + d3 * d3;
        faz faz2 = this;
        boolean bl = false;
        faz2.Field2014 = d = Math.sqrt(d4);
    }

    public int Method2376() {
        return this.Field2016;
    }

    @Override
    public void Method461() {
        this.Field2013 = far.Method2606();
        this.Field2015 = 4;
        this.Field2014 = 0.0;
        this.Field2016 = 0;
    }

    @Override
    public void Method455() {
    }

    public void Method2377(int n) {
        this.Field2016 = n;
    }
}

