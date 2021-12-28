/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdF;
import dev.nuker.pyro.fdr;
import dev.nuker.pyro.few;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;

public class fdw
implements Consumer {
    public fdF Field409;
    public float[] Field410;

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }

    public fdw(fdF fdF2, float[] arrf) {
        this.Field409 = fdF2;
        this.Field410 = arrf;
    }

    public void Method597(EntityPlayerSP entityPlayerSP) {
        RayTraceResult rayTraceResult = few.Method835().Method849(this.Field410[0], this.Field410[1]);
        fdr fdr2 = fdF.Method303(this.Field409);
        if (fdr2 == null) {
            Intrinsics.Method6551();
        }
        fdF.Method313((fdF)this.Field409).playerController.processRightClickBlock(fdF.Method313((fdF)this.Field409).player, fdF.Method313((fdF)this.Field409).world, fdr2.Method616(), rayTraceResult.sideHit, rayTraceResult.hitVec, EnumHand.MAIN_HAND);
        fdF.Method307(this.Field409, true);
    }
}

