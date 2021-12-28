/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdF;
import dev.nuker.pyro.fdr;
import dev.nuker.pyro.fdt;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fds
extends Lambda
implements Function1 {
    public fdF Field394;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method297(@NotNull ItemStack itemStack) {
        boolean bl;
        Map map = this.Field394.Method302();
        boolean bl2 = false;
        if (map.isEmpty()) {
            return false;
        }
        Map map2 = map;
        boolean bl3 = false;
        Iterator iterator2 = map2.entrySet().iterator();
        do {
            Map.Entry entry;
            if (!iterator2.hasNext()) return false;
            Map.Entry entry2 = entry = iterator2.next();
            boolean bl4 = false;
            Map.Entry entry3 = entry2;
            boolean bl5 = false;
            fdr fdr2 = (fdr)entry3.getKey();
            entry3 = entry2;
            bl5 = false;
            ItemStack itemStack2 = (ItemStack)entry3.getValue();
            if (this.Field394.Method312(itemStack2, itemStack)) {
                IInventory iInventory = fdr2.Method607();
                if (iInventory == null) {
                    Intrinsics.Method6551();
                }
                if (this.Field394.Method315(iInventory, fdt.Field395)) {
                    return true;
                }
            }
            bl = false;
        } while (!bl);
        return true;
    }

    public Object Method41(Object object) {
        return this.Method297((ItemStack)object);
    }

    public fds(fdF fdF2) {
        this.Field394 = fdF2;
        super(1);
    }
}

