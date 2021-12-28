/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.fbc;
import java.util.List;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class faY
implements Consumer {
    public fbc Field1737;
    public List Field1738;

    public void Method2429(@NotNull Entity entity) {
        Entity entity2 = fbc.Method2722(this.Field1737).getRenderViewEntity();
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        Entity entity3 = fbc.Method2722(this.Field1737).getRenderViewEntity();
        if (entity3 == null) {
            Intrinsics.Method6551();
        }
        Entity entity4 = fbc.Method2722(this.Field1737).getRenderViewEntity();
        if (entity4 == null) {
            Intrinsics.Method6551();
        }
        PyroRenderUtil.Field7388.setPosition(entity2.posX, entity3.posY, entity4.posZ);
        if (PyroRenderUtil.Field7388.isBoundingBoxInFrustum(entity.getEntityBoundingBox())) {
            this.Field1738.add(entity);
        }
    }

    public void accept(Object object) {
        this.Method2429((Entity)object);
    }

    public faY(fbc fbc2, List list) {
        this.Field1737 = fbc2;
        this.Field1738 = list;
    }
}

