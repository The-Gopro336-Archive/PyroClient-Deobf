/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
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
import org.jetbrains.annotations.NotNull;

public class fau
extends far {
    public double Field2022 = far.Method2606();
    public double Field2023;
    public int Field2024 = 4;

    public int Method2376() {
        return this.Field2024;
    }

    @Override
    public void Method2364(@NotNull f4p f4p2) {
        block14: {
            block18: {
                block17: {
                    block16: {
                        block15: {
                            block13: {
                                block12: {
                                    block11: {
                                        if (f4p2.Method5619() != f41.Pre) break block11;
                                        boolean bl = ((Boolean)PyroStatic.Field6409.Field5236.Method5264()).booleanValue() ? false : f4p2.Method7947();
                                        if (!bl) break block12;
                                    }
                                    return;
                                }
                                if (!fec.Method727() || far.Field313.player.fallDistance > 5.0f) {
                                    f0b.Field5568.Method7904("speedhax");
                                    return;
                                }
                                if (((Boolean)PyroStatic.Field6406.Field5236.Method5264()).booleanValue()) {
                                    if (PyroStatic.Field6406.Method5402(((Number)PyroStatic.Field6406.Field3627.Method7979()).doubleValue()) > (double)0.0f) {
                                        return;
                                    }
                                }
                                if (((Boolean)PyroStatic.Field6430.Method213().Method7979()).booleanValue()) {
                                    f0b.Field5568.Method7902("speedhax", f07.MULTIPLY, 1.033f);
                                }
                                if (this.Field2024 != 1 || far.Field313.player.moveForward == 0.0f && far.Field313.player.moveStrafing == 0.0f) break block13;
                                this.Field2022 = 1.15 * far.Method2606() - 0.01;
                                break block14;
                            }
                            if (this.Field2024 != 2 || !far.Field313.player.collidedVertically) break block15;
                            double d = 0.411111115;
                            f4p f4p3 = f4p2;
                            boolean bl = false;
                            boolean bl2 = false;
                            double d2 = d;
                            boolean bl3 = false;
                            far.Field313.player.motionY = d2;
                            double d3 = d;
                            f4p3.Method5834(d3);
                            this.Field2022 *= 1.415;
                            break block14;
                        }
                        if (this.Field2024 != 3) break block16;
                        double d = 0.66 * (this.Field2023 - far.Method2606());
                        this.Field2022 = this.Field2023 - d;
                        break block14;
                    }
                    List list = far.Field313.world.getCollisionBoxes((Entity)far.Field313.player, far.Field313.player.getEntityBoundingBox().offset(0.0, far.Field313.player.motionY, 0.0));
                    if (list.size() > 0) break block17;
                    if (!far.Field313.player.collidedVertically) break block18;
                }
                if (this.Field2024 > 0) {
                    this.Field2024 = 1;
                }
            }
            this.Field2022 = this.Field2023 - this.Field2023 / 159.0;
        }
        f4p2.Method7948();
        this.Field2022 = Math.max(this.Field2022, far.Method2606());
        fec.Method744(f4p2, this.Field2022);
        ++this.Field2024;
    }

    @Override
    public void Method461() {
        this.Field2022 = far.Method2606();
        this.Field2024 = 4;
        this.Field2023 = 0.0;
    }

    public void Method2377(int n) {
        this.Field2024 = n;
    }

    @Override
    public void Method455() {
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
        fau fau2 = this;
        boolean bl = false;
        fau2.Field2023 = d = Math.sqrt(d4);
    }
}

