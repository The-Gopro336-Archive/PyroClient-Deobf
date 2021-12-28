/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f75;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f76
extends Module {
    @NotNull
    public DoubleSetting Field3049 = (DoubleSetting)this.Method7264(new DoubleSetting("offset", "Offset", null, 2.0, -20.0, 20.0, 0.0, 64, null));

    public static void Method4933(f76 f762, Minecraft minecraft) {
        f762.Field5233 = minecraft;
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field3049;
    }

    public f76() {
        super("burrow", "Burrow", "Attempt to place a block and rubberband you into it");
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        block11: {
            Ref.IntRef intRef;
            block12: {
                block10: {
                    if (feg.Method700(new BlockPos(this.Field5233.player.getPositionVector()))) break block10;
                    Pyro.Field6182.Method8989("Burrowed into a block... disabling");
                    this.Field5236.Method5266(false);
                    break block11;
                }
                if (this.Field5233.player.onGround) break block11;
                boolean bl = true;
                if (!this.Field5233.player.getHeldItemMainhand().isEmpty()) {
                    if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
                        Item item = this.Field5233.player.getHeldItemMainhand().getItem();
                        if (item == null) {
                            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                        }
                        intRef = (ItemBlock)item;
                        if (Intrinsics.Method6572((Object)intRef.getBlock(), (Object)Blocks.OBSIDIAN)) {
                            bl = false;
                        }
                    }
                }
                intRef = new Ref.IntRef();
                intRef.Field284 = -1;
                if (bl) {
                    int n = 8;
                    for (int i = 0; i <= n; ++i) {
                        if (!(this.Field5233.player.inventory.getStackInSlot(i).getItem() instanceof ItemBlock)) continue;
                        Item item = this.Field5233.player.inventory.getStackInSlot(i).getItem();
                        if (item == null) {
                            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                        }
                        ItemBlock itemBlock = (ItemBlock)item;
                        if (!Intrinsics.Method6572((Object)itemBlock.getBlock(), (Object)Blocks.OBSIDIAN)) continue;
                        intRef.Field284 = i;
                        break;
                    }
                }
                if (intRef.Field284 != -1) break block12;
                if (bl) break block11;
            }
            f4u2.Method5647(90.0f);
            f4u2.Method7948();
            f4u2.Method5816(new f75(this, intRef));
        }
    }

    public static Minecraft Method4934(f76 f762) {
        return f762.Field5233;
    }
}

