/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalBlock
 *  net.minecraft.block.BlockChest
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumFacing$Plane
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.items.VanillaDoubleChestItemHandler
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f4w;
import dev.nuker.pyro.fdA;
import dev.nuker.pyro.fdB;
import dev.nuker.pyro.fdC;
import dev.nuker.pyro.fdD;
import dev.nuker.pyro.fdE;
import dev.nuker.pyro.fdY;
import dev.nuker.pyro.fdn;
import dev.nuker.pyro.fdo;
import dev.nuker.pyro.fdp;
import dev.nuker.pyro.fdq;
import dev.nuker.pyro.fdr;
import dev.nuker.pyro.fds;
import dev.nuker.pyro.fdu;
import dev.nuker.pyro.fdv;
import dev.nuker.pyro.fdw;
import dev.nuker.pyro.fdx;
import dev.nuker.pyro.fdz;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.few;
import dev.nuker.pyro.mixin.GuiChestAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.items.VanillaDoubleChestItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdF
extends Module {
    @NotNull
    public ConcurrentHashMap<fdr, ItemStack> Field214 = new ConcurrentHashMap();
    @NotNull
    public CopyOnWriteArrayList<fdr> Field215 = new CopyOnWriteArrayList();
    @NotNull
    public BooleanSetting Field216 = (BooleanSetting)this.Method7264(new BooleanSetting("selectSort", "SelectSortChests", null, false));
    @NotNull
    public BooleanSetting Field217 = (BooleanSetting)this.Method7264(new BooleanSetting("selectOn", "SelectPullChests", null, false));
    @NotNull
    public BooleanSetting Field218 = (BooleanSetting)this.Method7264(new BooleanSetting("active", "Active", null, false));
    @Nullable
    public BlockPos Field219;
    public int Field220;
    public fdr Field221;
    public boolean Field222;
    public ItemStack Field223;
    public fe8 Field224;
    public boolean Field225;
    public boolean Field226;
    public int Field227;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Nullable
    public Map.Entry Method299() {
        var1_1 = this.Field214;
        var2_2 = false;
        var3_3 = var1_1;
        var4_4 = new LinkedHashMap<K, V>();
        var5_6 = false;
        var6_8 = var3_3;
        var7_13 = false;
        var9_16 = var6_8.entrySet().iterator();
        while (var9_16.hasNext()) {
            var12_22 = var10_19 = var9_16.next();
            var13_24 = false;
            var14_26 = var12_22;
            var15_29 = false;
            var16_32 = (fdr)var14_26.getKey();
            var14_26 = var12_22;
            var15_29 = false;
            var17_33 = (ItemStack)var14_26.getValue();
            if (var16_32.Method607() == null) ** GOTO lbl-1000
            v0 = var16_32.Method607();
            if (v0 == null) {
                Intrinsics.Method6551();
            }
            if (this.Method315(v0, fdv.Field398)) {
                v1 = true;
            } else lbl-1000:
            // 2 sources

            {
                v1 = false;
            }
            if (!v1) continue;
            var4_4.put(var10_19.getKey(), var10_19.getValue());
        }
        var1_1 = var4_4;
        var2_2 = false;
        var3_3 = var1_1;
        var4_4 = new LinkedHashMap<K, V>();
        var5_6 = false;
        var6_9 = var3_3;
        var7_13 = false;
        var9_16 = var6_9.entrySet().iterator();
        while (var9_16.hasNext()) {
            var12_22 = var10_19 = var9_16.next();
            var13_24 = false;
            var14_26 = var12_22;
            var15_29 = false;
            var16_32 = (fdr)var14_26.getKey();
            var14_26 = var12_22;
            var15_29 = false;
            var17_33 = (ItemStack)var14_26.getValue();
            if (!this.Method315((IInventory)this.Field5233.player.inventory, new fdu(var17_33, this))) continue;
            var4_4.put(var10_19.getKey(), var10_19.getValue());
        }
        var1_1 = var4_4;
        var2_2 = false;
        var3_3 = var1_1.entrySet();
        var4_5 = false;
        var5_7 = var3_3.iterator();
        if (!var5_7.hasNext()) {
            v2 = null;
            return v2;
        }
        var6_10 = var5_7.next();
        if (!var5_7.hasNext()) {
            v2 = var6_10;
            return v2;
        }
        var7_14 = (Map.Entry)var6_10;
        var9_17 = false;
        var10_19 = var7_14;
        var12_23 = false;
        var13_25 = (fdr)var10_19.getKey();
        var10_19 = var7_14;
        var12_23 = false;
        var14_26 = (ItemStack)var10_19.getValue();
        var7_15 = this.Field5233.player.getDistanceSq(var13_25.Method610());
        do {
            var9_18 = var5_7.next();
            var10_20 = (Map.Entry)var9_18;
            var12_23 = false;
            var13_25 = var10_20;
            var14_28 = false;
            var15_31 = (fdr)var13_25.getKey();
            var13_25 = var10_20;
            var14_28 = false;
            var16_32 = (ItemStack)var13_25.getValue();
            var10_21 = this.Field5233.player.getDistanceSq(var15_31.Method610());
            if (Double.compare(var7_15, var10_21) <= 0) continue;
            var6_12 = var9_18;
            var7_15 = var10_21;
        } while (var5_7.hasNext());
        v2 = var6_11;
        return v2;
    }

    public void Method300(@NotNull ConcurrentHashMap concurrentHashMap) {
        this.Field214 = concurrentHashMap;
    }

    public static boolean Method301(fdF fdF2) {
        return fdF2.Field225;
    }

    public void Method209(@Nullable BlockPos blockPos) {
        this.Field219 = blockPos;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u var1_1) {
        if (var1_1.Method5619() != f41.Pre) return;
        if (var1_1.Method7947()) {
            return;
        }
        if (this.Field5233.currentScreen instanceof GuiChest) {
            block57: {
                var2_2 = (GuiChest)this.Field5233.currentScreen;
                v0 = (GuiChestAccessor)var2_2;
                if (v0 == null) {
                    Intrinsics.Method6551();
                }
                var3_4 = v0.Method787();
                var5_12 = this.Field215;
                var6_23 = false;
                for (Object var8_33 : var5_12) {
                    var9_34 = (fdr)var8_33;
                    var10_36 = false;
                    if (!(Intrinsics.Method6572((Object)var9_34.Method616(), (Object)this.Field219) != false || Intrinsics.Method6572((Object)var9_34.Method609(), (Object)this.Field219) != false)) continue;
                    v1 = var8_33;
                    break block57;
                }
                v1 = null;
            }
            if ((v2 = (fdr)v1) == null) {
                block58: {
                    var5_13 = (ConcurrentHashMap.KeySetView)this.Field214.keySet();
                    var6_23 = false;
                    for (Object var8_33 : var5_13) {
                        var9_34 = (fdr)var8_33;
                        var10_36 = false;
                        if (!(Intrinsics.Method6572((Object)var9_34.Method616(), (Object)this.Field219) != false || Intrinsics.Method6572((Object)var9_34.Method609(), (Object)this.Field219) != false)) continue;
                        v3 = var8_33;
                        break block58;
                    }
                    v3 = null;
                }
                v2 = v3;
            }
            var4_38 = v2;
            v4 = var4_38;
            if (v4 != null) {
                v4.Method617(var3_4);
            }
        }
        if (!((Boolean)this.Field218.Method7979()).booleanValue()) {
            this.Field220 = 0;
            return;
        }
        switch (this.Field220) {
            case 0: {
                if (!this.Field226) ** GOTO lbl64
                this.Field221 = this.Method314();
                var2_2 = (Iterable)this.Field5233.player.inventory.mainInventory;
                var3_5 = false;
                if (!(var2_2 instanceof Collection) || !((Collection)var2_2).isEmpty()) ** GOTO lbl49
                v5 = true;
                ** GOTO lbl59
lbl49:
                // 1 sources

                var4_38 = var2_2.iterator();
                while (var4_38.hasNext()) {
                    var5_16 = var4_38.next();
                    var6_24 = (ItemStack)var5_16;
                    var7_29 = false;
                    if (!var6_24.isEmpty()) continue;
                    v5 = false;
                    ** GOTO lbl59
                }
                v5 = true;
lbl59:
                // 3 sources

                if (v5 || this.Field221 == null) {
                    this.Field226 = false;
                    return;
                }
                this.Field222 = false;
                ** GOTO lbl71
lbl64:
                // 1 sources

                var2_2 = this.Method299();
                if (var2_2 == null) {
                    this.Field226 = true;
                    return;
                }
                this.Field222 = true;
                this.Field223 = (ItemStack)var2_2.getValue();
                this.Field221 = (fdr)var2_2.getKey();
lbl71:
                // 2 sources

                if (this.Field221 == null) return;
                v6 = BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess();
                v7 = this.Field221;
                if (v7 == null) {
                    Intrinsics.Method6551();
                }
                v6.setGoal((Goal)new GoalBlock(v7.Method610()));
                BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().path();
                this.Field220 = 1;
                return;
            }
            case 1: {
                if (this.Method304() != false) return;
                if (this.Field227 > 0) {
                    var2_3 = this.Field227;
                    this.Field227 = var2_3 + -1;
                }
                v8 = new BlockPos(this.Field5233.player.getPositionVector());
                v9 = this.Field221;
                if (v9 == null) {
                    Intrinsics.Method6551();
                }
                if (Intrinsics.Method6572((Object)v8, (Object)v9.Method610()) ^ true) {
                    v10 = this.Field221;
                    if (v10 == null) {
                        Intrinsics.Method6551();
                    }
                    if (this.Field5233.player.getDistanceSq(v10.Method616()) > (double)36) {
                        v11 = BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess();
                        v12 = this.Field221;
                        if (v12 == null) {
                            Intrinsics.Method6551();
                        }
                        v11.setGoal((Goal)new GoalBlock(v12.Method610()));
                        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().path();
                        this.Field227 = 20;
                        return;
                    }
                }
                this.Field220 = 2;
                return;
            }
            case 2: {
                if (this.Field5233.currentScreen instanceof GuiChest && this.Field225) {
                    this.Field225 = false;
                    this.Field220 = 4;
                }
                v13 = this.Field221;
                if (v13 == null) {
                    Intrinsics.Method6551();
                }
                if (this.Field5233.player.getDistanceSq(v13.Method616()) > (double)36) {
                    this.Field220 = 1;
                    return;
                }
                Pyro.Field6182.Method8989("Attempting to open chest");
                v14 = this.Field221;
                if (v14 == null) {
                    Intrinsics.Method6551();
                }
                var2_2 = few.Method848(v14.Method616(), true);
                v15 = few.Method835();
                v16 = this.Field221;
                if (v16 == null) {
                    Intrinsics.Method6551();
                }
                var3_6 = v15.Method850(v16.Method616(), (EnumFacing)var2_2);
                var1_1.Method7948();
                var1_1.Method5653(var3_6[0]);
                var1_1.Method5647(var3_6[1]);
                if (this.Field224.Method491(1000.0) == false) return;
                if (this.Field5233.currentScreen instanceof GuiChest) {
                    this.Field5233.player.closeScreen();
                }
                this.Field224.Method490();
                var1_1.Method5816(new fdw(this, var3_6));
                return;
            }
            case 3: {
                if (this.Field5233.currentScreen instanceof GuiChest == false) return;
                this.Field220 = 4;
                return;
            }
            case 4: {
                if (!(this.Field5233.currentScreen instanceof GuiChest)) ** GOTO lbl226
                if (!this.Field222) ** GOTO lbl179
                var2_2 = (Iterable)this.Field5233.player.inventory.mainInventory;
                var3_7 = false;
                if (!(var2_2 instanceof Collection) || !((Collection)var2_2).isEmpty()) ** GOTO lbl157
                v17 = false;
                ** GOTO lbl170
lbl157:
                // 1 sources

                var4_38 = var2_2.iterator();
                while (var4_38.hasNext()) {
                    var5_18 = var4_38.next();
                    var6_25 = (ItemStack)var5_18;
                    var7_30 = false;
                    v18 = this.Field223;
                    if (v18 == null) {
                        Intrinsics.Method6551();
                    }
                    if (!this.Method312(var6_25, v18)) continue;
                    v17 = true;
                    ** GOTO lbl170
                }
                v17 = false;
lbl170:
                // 3 sources

                if (!v17) ** GOTO lbl179
                v19 = this.Field5233.currentScreen;
                if (v19 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                }
                v20 = (GuiChestAccessor)((GuiChest)v19);
                if (v20 == null) {
                    Intrinsics.Method6551();
                }
                if (this.Method315(v20.Method787(), fdx.Field434)) ** GOTO lbl205
lbl179:
                // 3 sources

                if (this.Field222 || this.Field222) ** GOTO lbl226
                var2_2 = (Iterable)this.Field5233.player.inventory.mainInventory;
                var3_8 = false;
                if (!(var2_2 instanceof Collection) || !((Collection)var2_2).isEmpty()) ** GOTO lbl186
                v21 = false;
                ** GOTO lbl196
lbl186:
                // 1 sources

                var4_38 = var2_2.iterator();
                while (var4_38.hasNext()) {
                    var5_20 = var4_38.next();
                    var6_26 = (ItemStack)var5_20;
                    var7_31 = false;
                    if (!var6_26.isEmpty()) continue;
                    v21 = true;
                    ** GOTO lbl196
                }
                v21 = false;
lbl196:
                // 3 sources

                if (!v21) ** GOTO lbl226
                v22 = this.Field5233.currentScreen;
                if (v22 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                }
                v23 = (GuiChestAccessor)((GuiChest)v22);
                if (v23 == null) {
                    Intrinsics.Method6551();
                }
                if (!this.Method315(v23.Method787(), new fdz(this))) ** GOTO lbl226
lbl205:
                // 2 sources

                v24 = this.Field5233.currentScreen;
                if (v24 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                }
                v25 = (GuiChestAccessor)((GuiChest)v24);
                if (v25 == null) {
                    Intrinsics.Method6551();
                }
                PyroStatic.Field6531.Method5344(v25.Method787());
                if (PyroStatic.Field6531.Method5208().Method491(((Number)PyroStatic.Field6531.Method2279().Method7979()).doubleValue() * (double)100) == false) return;
                v26 = this.Field5233.currentScreen;
                if (v26 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                }
                v27 = (GuiChestAccessor)((GuiChest)v26);
                if (v27 == null) {
                    Intrinsics.Method6551();
                }
                var2_2 = v27.Method787();
                var3_10 = 0;
                v28 = var2_2;
                if (v28 == null) {
                    Intrinsics.Method6551();
                }
                if (var3_10 > (var4_39 = v28.getSizeInventory())) return;
                break;
lbl226:
                // 4 sources

                this.Field220 = 5;
                return;
            }
            case 5: {
                this.Field5233.player.closeScreen();
                Pyro.Field6182.Method8989("Marked as done");
                this.Field220 = 6;
                return;
            }
            case 6: {
                this.Field220 = 0;
            }
            default: {
                return;
            }
        }
        while (true) {
            block61: {
                block59: {
                    block62: {
                        block60: {
                            if (!(var5_22 = var2_2.getStackInSlot((int)(++var3_11))).isEmpty()) break block60;
                            if (this.Field222) {
                                PyroStatic.Field6531.Method5349((int)var3_11, new fdA(this));
                                return;
                            }
                            break block61;
                        }
                        if (this.Field222 || var5_22.isEmpty()) break block61;
                        var6_27 = this.Field214;
                        var7_32 = false;
                        if (!var6_27.isEmpty()) break block62;
                        v29 = false;
                        break block59;
                    }
                    var8_33 = var6_27;
                    var9_35 = false;
                    var10_37 = var8_33.entrySet().iterator();
                    while (var10_37.hasNext()) {
                        var12_41 = var11_40 = var10_37.next();
                        var13_42 = false;
                        var14_43 = var12_41;
                        var15_44 = false;
                        var16_45 = (fdr)var14_43.getKey();
                        var14_43 = var12_41;
                        var15_44 = false;
                        var17_46 = (ItemStack)var14_43.getValue();
                        if (!this.Method312(var17_46, var5_22)) ** GOTO lbl-1000
                        v30 = var16_45.Method607();
                        if (v30 == null) {
                            Intrinsics.Method6551();
                        }
                        if (this.Method315(v30, fdB.Field229)) {
                            v31 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v31 = false;
                        }
                        if (!v31) continue;
                        v29 = true;
                        break block59;
                    }
                    v29 = false;
                }
                if (v29) {
                    PyroStatic.Field6531.Method541((int)var3_11);
                    return;
                }
            }
            if (var3_11 == var4_39) return;
        }
    }

    @NotNull
    public ConcurrentHashMap Method302() {
        return this.Field214;
    }

    @NotNull
    public BooleanSetting Method279() {
        return this.Field217;
    }

    public static fdr Method303(fdF fdF2) {
        return fdF2.Field221;
    }

    public boolean Method304() {
        return BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().getGoal() != null;
    }

    public int Method305(@NotNull IInventory iInventory, @NotNull Function1 function1) {
        int n = 0;
        int n2 = iInventory.getSizeInventory();
        for (int i = 0; i < n2; ++i) {
            if (!((Boolean)function1.Method41(iInventory.getStackInSlot(i))).booleanValue()) continue;
            ++n;
        }
        return n;
    }

    @NotNull
    public BooleanSetting Method284() {
        return this.Field216;
    }

    public static ItemStack Method306(fdF fdF2) {
        return fdF2.Field223;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        boolean bl;
        Object object;
        int n;
        boolean bl2;
        super.Method195(vec3d, f);
        fe5.Field252.Method408(7);
        for (fdr object2 : this.Field215) {
            if (object2.Method616() == null) continue;
            bl2 = object2.Method611();
            int n2 = n = bl2 ? 0x50888800 : 1344414344;
            if (object2.Method609() != null) {
                BlockPos blockPos = object2.Method616();
                if (blockPos == null) {
                    Intrinsics.Method6551();
                }
                BlockPos blockPos2 = object2.Method609();
                if (blockPos2 == null) {
                    Intrinsics.Method6551();
                }
                object = new fdq(blockPos, blockPos2);
                fe5.Field252.Method394(((fdq)object).Method606().getX(), ((fdq)object).Method606().getY(), ((fdq)object).Method606().getZ(), (float)((fdq)object).Method605().getX() - (float)((fdq)object).Method606().getX() + 1.0f, (float)((fdq)object).Method605().getY() - (float)((fdq)object).Method606().getY() + 1.0f, (float)((fdq)object).Method605().getZ() - (float)((fdq)object).Method606().getZ() + 1.0f, n, 63);
                continue;
            }
            BlockPos blockPos = object2.Method616();
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            fe5.Field252.Method410(blockPos, n, 63);
        }
        for (fdr fdr2 : (ConcurrentHashMap.KeySetView)this.Field214.keySet()) {
            if (fdr2.Method616() == null) continue;
            IInventory iInventory = fdr2.Method607();
            bl2 = iInventory != null ? this.Method319(iInventory, fdE.Field213) : false;
            int n3 = n = bl2 ? 1342233890 : 0x5000DDDD;
            if (fdr2.Method609() != null) {
                BlockPos blockPos = fdr2.Method616();
                if (blockPos == null) {
                    Intrinsics.Method6551();
                }
                BlockPos blockPos3 = fdr2.Method609();
                if (blockPos3 == null) {
                    Intrinsics.Method6551();
                }
                object = new fdq(blockPos, blockPos3);
                fe5.Field252.Method394(((fdq)object).Method606().getX(), ((fdq)object).Method606().getY(), ((fdq)object).Method606().getZ(), (float)((fdq)object).Method605().getX() - (float)((fdq)object).Method606().getX() + 1.0f, (float)((fdq)object).Method605().getY() - (float)((fdq)object).Method606().getY() + 1.0f, (float)((fdq)object).Method605().getZ() - (float)((fdq)object).Method606().getZ() + 1.0f, n, 63);
                continue;
            }
            BlockPos blockPos = fdr2.Method616();
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            fe5.Field252.Method410(blockPos, n, 63);
        }
        fe5.Field252.Method405();
        for (fdr fdr3 : this.Field215) {
            Ref.ObjectRef objectRef;
            Vec3d vec3d2;
            if (fdr3.Method616() == null || fdr3.Method607() == null) continue;
            if (fdr3.Method609() != null) {
                BlockPos blockPos = fdr3.Method616();
                if (blockPos == null) {
                    Intrinsics.Method6551();
                }
                double d = blockPos.getX();
                EnumFacing enumFacing = fdr3.Method614();
                if (enumFacing == null) {
                    Intrinsics.Method6551();
                }
                double d2 = d + (double)((float)enumFacing.getFrontOffsetX() / 2.0f);
                BlockPos blockPos4 = fdr3.Method616();
                if (blockPos4 == null) {
                    Intrinsics.Method6551();
                }
                double d3 = blockPos4.getY();
                EnumFacing enumFacing2 = fdr3.Method614();
                if (enumFacing2 == null) {
                    Intrinsics.Method6551();
                }
                double d4 = d3 + (double)((float)enumFacing2.getFrontOffsetY() / 2.0f);
                BlockPos blockPos5 = fdr3.Method616();
                if (blockPos5 == null) {
                    Intrinsics.Method6551();
                }
                double d5 = blockPos5.getZ();
                EnumFacing enumFacing3 = fdr3.Method614();
                if (enumFacing3 == null) {
                    Intrinsics.Method6551();
                }
                vec3d2 = new Vec3d(d2, d4, d5 + (double)((float)enumFacing3.getFrontOffsetZ() / 2.0f));
            } else {
                vec3d2 = new Vec3d((Vec3i)fdr3.Method616());
            }
            Vec3d vec3d3 = vec3d2;
            Ref.ObjectRef objectRef2 = objectRef = new Ref.ObjectRef();
            boolean bl3 = false;
            List list = new ArrayList();
            objectRef2.Field5552 = list;
            object = this.Field214.values();
            bl = false;
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                int n4;
                boolean bl4;
                ItemStack itemStack;
                block35: {
                    Object t = iterator2.next();
                    itemStack = (ItemStack)t;
                    boolean bl5 = false;
                    Iterable iterable = (List)objectRef.Field5552;
                    boolean bl6 = false;
                    if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                        bl4 = false;
                    } else {
                        for (Object t2 : iterable) {
                            Pair pair = (Pair)t2;
                            boolean bl7 = false;
                            if (!this.Method312((ItemStack)pair.Method998(), itemStack)) continue;
                            bl4 = true;
                            break block35;
                        }
                        bl4 = false;
                    }
                }
                if (bl4) continue;
                IInventory iInventory = fdr3.Method607();
                if (iInventory == null) {
                    Intrinsics.Method6551();
                }
                if ((n4 = this.Method305(iInventory, new fdC(itemStack, this, objectRef, fdr3))) <= 0) continue;
                ((List)objectRef.Field5552).add(TuplesKt.Method2826(itemStack, String.valueOf(n4)));
            }
            if (((List)objectRef.Field5552).isEmpty()) {
                ((List)objectRef.Field5552).add(TuplesKt.Method2826(new ItemStack(Blocks.BARRIER), ""));
            }
            this.Method311(vec3d3, (List)objectRef.Field5552, f);
        }
        Object object2 = this.Field214;
        boolean bl8 = false;
        for (Map.Entry entry : object2.entrySet()) {
            Vec3d vec3d4;
            object = entry;
            bl = false;
            object2 = (fdr)object.getKey();
            object = entry;
            bl = false;
            ItemStack itemStack = (ItemStack)object.getValue();
            if (((fdr)object2).Method616() == null || ((fdr)object2).Method607() == null) continue;
            if (((fdr)object2).Method609() != null) {
                BlockPos blockPos = ((fdr)object2).Method616();
                if (blockPos == null) {
                    Intrinsics.Method6551();
                }
                double d = blockPos.getX();
                EnumFacing enumFacing = ((fdr)object2).Method614();
                if (enumFacing == null) {
                    Intrinsics.Method6551();
                }
                double d6 = d + (double)((float)enumFacing.getFrontOffsetX() / 2.0f);
                BlockPos blockPos6 = ((fdr)object2).Method616();
                if (blockPos6 == null) {
                    Intrinsics.Method6551();
                }
                double d7 = blockPos6.getY();
                EnumFacing enumFacing4 = ((fdr)object2).Method614();
                if (enumFacing4 == null) {
                    Intrinsics.Method6551();
                }
                double d8 = d7 + (double)((float)enumFacing4.getFrontOffsetY() / 2.0f);
                BlockPos blockPos7 = ((fdr)object2).Method616();
                if (blockPos7 == null) {
                    Intrinsics.Method6551();
                }
                double d9 = blockPos7.getZ();
                EnumFacing enumFacing5 = ((fdr)object2).Method614();
                if (enumFacing5 == null) {
                    Intrinsics.Method6551();
                }
                vec3d4 = new Vec3d(d6, d8, d9 + (double)((float)enumFacing5.getFrontOffsetZ() / 2.0f));
            } else {
                vec3d4 = new Vec3d((Vec3i)((fdr)object2).Method616());
            }
            object = vec3d4;
            IInventory iInventory = ((fdr)object2).Method607();
            if (iInventory == null) {
                Intrinsics.Method6551();
            }
            this.Method311((Vec3d)object, CollectionsKt.Method9007(TuplesKt.Method2826(itemStack, String.valueOf(this.Method305(iInventory, fdD.Field211)))), f);
        }
        GlStateManager.enableBlend();
    }

    public static void Method307(fdF fdF2, boolean bl) {
        fdF2.Field225 = bl;
    }

    public static void Method308(fdF fdF2, fdr fdr2) {
        fdF2.Field221 = fdr2;
    }

    public static void Method309(fdF fdF2, Minecraft minecraft) {
        fdF2.Field5233 = minecraft;
    }

    public fdF() {
        super("stashsorter", "StashSorter", null);
        this.Field217.Method7980(new fdn(this));
        this.Field216.Method7980(new fdo(this));
        this.Field218.Method7980(new fdp(this));
        this.Field224 = new fe8();
        this.Field226 = true;
    }

    @NotNull
    public CopyOnWriteArrayList Method310() {
        return this.Field215;
    }

    public void Method311(@NotNull Vec3d vec3d, @NotNull List list, float f) {
        Entity entity = this.Field5233.getRenderViewEntity();
        Vec3d vec3d2 = fdY.Method512(vec3d, f);
        double d = vec3d2.x;
        double d2 = vec3d2.y + 0.65;
        double d3 = vec3d2.z;
        double d4 = d2 + (double)0.08f;
        vec3d2 = fdY.Method364(entity, f);
        Entity entity2 = entity;
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        double d5 = entity2.posX;
        double d6 = entity.posY;
        double d7 = entity.posZ;
        entity.posX = vec3d2.x;
        entity.posY = vec3d2.y;
        entity.posZ = vec3d2.z;
        d2 = entity.getDistance(d, d2, d3);
        double d8 = 0.05;
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((double)(d + 0.5), (double)(d4 - 0.25), (double)(d3 + 0.5));
        float f2 = -this.Field5233.getRenderManager().playerViewY;
        float f3 = 1.0f;
        float f4 = 0.0f;
        GlStateManager.rotate((float)f2, (float)f4, (float)f3, (float)f4);
        GlStateManager.rotate((float)this.Field5233.getRenderManager().playerViewX, (float)(this.Field5233.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((double)(-d8), (double)(-d8), (double)d8);
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        float f5 = 0.0f;
        GlStateManager.pushMatrix();
        int n = 0;
        int n2 = 0;
        boolean bl = false;
        int n3 = list.size();
        int n4 = 1;
        int n5 = n3;
        for (int i = 1; i < n5; ++i) {
            if (n3 / i >= i) continue;
            n4 = i;
            break;
        }
        float f6 = n3 == 2 ? 0.5f : 1.0f / (float)n4;
        GlStateManager.pushMatrix();
        GlStateManager.scale((float)f6, (float)f6, (float)f6);
        GlStateManager.translate((double)(-n4 * 8), (double)(-n4 * 8), (double)0.0);
        for (Pair pair : list) {
            GlStateManager.depthMask((boolean)true);
            GlStateManager.clear((int)256);
            RenderHelper.enableStandardItemLighting();
            this.Field5233.getRenderItem().zLevel = -150.0f;
            GlStateManager.disableAlpha();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            this.Field5233.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)pair.Method998(), n * 16, n2 * 16);
            String string = (String)pair.Method999();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            GlStateManager.disableBlend();
            this.Field5233.fontRenderer.drawStringWithShadow(string, (float)(n * 16 + 19 - 2) - (float)this.Field5233.fontRenderer.getStringWidth(string), (float)9 + (float)n2 * 16.0f, 0xFFFFFF);
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            GlStateManager.enableBlend();
            this.Field5233.getRenderItem().zLevel = 0.0f;
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.enableAlpha();
            if (++n % n4 != 0) continue;
            n = 0;
            ++n2;
        }
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
        GlStateManager.popMatrix();
        entity.posX = d5;
        entity.posY = d6;
        entity.posZ = d7;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method312(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        if (!Intrinsics.Method6572((Object)itemStack2.getItem(), (Object)itemStack.getItem())) return false;
        if (itemStack.getMetadata() != itemStack2.getMetadata()) return false;
        if (!Intrinsics.Method6572((Object)itemStack.getSubCompound("display"), (Object)itemStack2.getSubCompound("display"))) return false;
        if (!Intrinsics.Method6572((Object)itemStack.getSubCompound("BlockEntityTag"), (Object)itemStack2.getSubCompound("BlockEntityTag"))) return false;
        return true;
    }

    public static Minecraft Method313(fdF fdF2) {
        return fdF2.Field5233;
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field218;
    }

    @Nullable
    public fdr Method314() {
        Collection collection;
        Iterable iterable = this.Field215;
        boolean bl = false;
        Iterator iterator2 = iterable;
        Collection collection2 = new ArrayList();
        boolean bl2 = false;
        Iterator iterator3 = iterator2.iterator();
        while (iterator3.hasNext()) {
            Object t = iterator3.next();
            fdr fdr2 = (fdr)t;
            boolean bl3 = false;
            IInventory iInventory = fdr2.Method607();
            if (iInventory == null) {
                Intrinsics.Method6551();
            }
            if (!this.Method315(iInventory, new fds(this))) continue;
            collection2.add(t);
        }
        iterable = (List)collection2;
        bl = false;
        iterator2 = iterable.iterator();
        if (!iterator2.hasNext()) {
            collection = null;
        } else {
            collection2 = iterator2.next();
            if (!iterator2.hasNext()) {
                collection = collection2;
            } else {
                fdr fdr3 = (fdr)((Object)collection2);
                boolean bl4 = false;
                double d = this.Field5233.player.getDistanceSq(fdr3.Method610());
                do {
                    Object e = iterator2.next();
                    fdr fdr4 = (fdr)e;
                    boolean bl5 = false;
                    double d2 = this.Field5233.player.getDistanceSq(fdr4.Method610());
                    if (Double.compare(d, d2) <= 0) continue;
                    collection2 = e;
                    d = d2;
                } while (iterator2.hasNext());
                collection = collection2;
            }
        }
        return (fdr)((Object)collection);
    }

    public boolean Method315(@NotNull IInventory iInventory, @NotNull Function1 function1) {
        int n = iInventory.getSizeInventory();
        for (int i = 0; i < n; ++i) {
            if (!((Boolean)function1.Method41(iInventory.getStackInSlot(i))).booleanValue()) continue;
            return true;
        }
        return false;
    }

    public void Method316(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field215 = copyOnWriteArrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    @f0g
    @LauncherEventHide
    public void Method317(@NotNull f4w f4w2) {
        Object v0;
        Object object;
        IBlockState iBlockState;
        block11: {
            iBlockState = this.Field5233.world.getBlockState(f4w2.Method5858());
            if (!(iBlockState.getBlock() instanceof BlockChest)) return;
            this.Field219 = f4w2.Method5858();
            if (!((Boolean)this.Field217.Method7979()).booleanValue() && !((Boolean)this.Field216.Method7979()).booleanValue()) {
                return;
            }
            object = ((Boolean)this.Field216.Method7979()).booleanValue() ? (Set)((ConcurrentHashMap.KeySetView)this.Field214.keySet()) : CollectionsKt.Method3151((Iterable)this.Field215);
            boolean bl = false;
            EnumFacing enumFacing = object.iterator();
            while (enumFacing.hasNext()) {
                Object t = enumFacing.next();
                EnumFacing[] arrenumFacing = (EnumFacing[])t;
                int n = 0;
                if (!(Intrinsics.Method6572((Object)arrenumFacing.Method616(), (Object)f4w2.Method5858()) || Intrinsics.Method6572((Object)arrenumFacing.Method609(), (Object)f4w2.Method5858()))) continue;
                v0 = t;
                break block11;
            }
            v0 = null;
        }
        fdr fdr2 = v0;
        if (fdr2 != null) {
            if (((Boolean)this.Field216.Method7979()).booleanValue()) {
                this.Field214.remove(fdr2);
                return;
            }
            this.Field215.remove(fdr2);
            return;
        }
        object = new fdr();
        ((fdr)object).Method612(f4w2.Method5858());
        TileEntity tileEntity = this.Field5233.world.getTileEntity(f4w2.Method5858());
        if (tileEntity == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.tileentity.TileEntityChest");
        }
        VanillaDoubleChestItemHandler vanillaDoubleChestItemHandler = ((TileEntityChest)tileEntity).doubleChestHandler;
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL.facings()) {
            if (!Intrinsics.Method6572((Object)this.Field5233.world.getBlockState(f4w2.Method5858().offset(enumFacing)).getBlock(), (Object)iBlockState.getBlock())) continue;
            ((fdr)object).Method615(f4w2.Method5858().offset(enumFacing));
            ((fdr)object).Method613(enumFacing);
            break;
        }
        if (vanillaDoubleChestItemHandler != null) {
            TileEntityChest tileEntityChest = vanillaDoubleChestItemHandler.getChest(false);
            if (tileEntityChest == null) {
                Intrinsics.Method6551();
            }
            TileEntityChest tileEntityChest2 = vanillaDoubleChestItemHandler.getChest(Intrinsics.Method6572((Object)tileEntityChest.getPos(), (Object)((fdr)object).Method616()));
            if (tileEntityChest2 == null) {
                Intrinsics.Method6551();
            }
            ((fdr)object).Method615(tileEntityChest2.getPos());
        }
        ((fdr)object).Method608(this.Field5233.player.getPosition());
        if (!((Boolean)this.Field216.Method7979()).booleanValue()) {
            this.Field215.add((fdr)object);
            return;
        }
        if (this.Field5233.player.getHeldItemMainhand().isEmpty()) {
            Pyro.Field6182.Method8989("You must set a sorting item");
            return;
        }
        ((Map)this.Field214).put(object, this.Field5233.player.getHeldItemMainhand());
    }

    public void Method318(@NotNull Vec3d vec3d, @NotNull IInventory iInventory, float f) {
        NonNullList nonNullList = NonNullList.create();
        int n = iInventory.getSizeInventory();
        for (int i = 0; i < n; ++i) {
            nonNullList.add((Object)iInventory.getStackInSlot(i));
        }
        Entity entity = this.Field5233.getRenderViewEntity();
        Vec3d vec3d2 = fdY.Method514(vec3d, f);
        double d = vec3d2.x;
        double d2 = vec3d2.y + 0.65;
        double d3 = vec3d2.z;
        double d4 = d2 + (double)0.08f;
        vec3d2 = fdY.Method364(entity, f);
        Entity entity2 = entity;
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        double d5 = entity2.posX;
        double d6 = entity.posY;
        double d7 = entity.posZ;
        entity.posX = vec3d2.x;
        entity.posY = vec3d2.y;
        entity.posZ = vec3d2.z;
        d2 = entity.getDistance(d, d2, d3);
        double d8 = 0.01;
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((double)(d + 0.5), (double)d4, (double)(d3 + 0.5));
        float f2 = -this.Field5233.getRenderManager().playerViewY;
        float f3 = 1.0f;
        float f4 = 0.0f;
        GlStateManager.rotate((float)f2, (float)f4, (float)f3, (float)f4);
        GlStateManager.rotate((float)this.Field5233.getRenderManager().playerViewX, (float)(this.Field5233.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((double)(-d8), (double)(-d8), (double)d8);
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        float f5 = 0.0f;
        GlStateManager.pushMatrix();
        int n2 = -52;
        int n3 = -24;
        int n4 = 0;
        int n5 = ((Collection)nonNullList).size();
        for (int i = 0; i < n5; ++i) {
            ItemStack itemStack = (ItemStack)nonNullList.get(i);
            PyroStatic.Field6433.Method193(itemStack, n2, n3, n4);
            PyroStatic.Field6433.Method196(itemStack, n2, n3 * 2);
            PyroStatic.Field6433.Method189(itemStack, n2, n3 - 2);
            n2 += 16;
            if (i % 9 != 0) continue;
            n2 = -52;
            n3 += 16;
        }
        GlStateManager.popMatrix();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
        GlStateManager.popMatrix();
        entity.posX = d5;
        entity.posY = d6;
        entity.posZ = d7;
    }

    public boolean Method319(@NotNull IInventory iInventory, @NotNull Function1 function1) {
        int n = iInventory.getSizeInventory();
        for (int i = 0; i < n; ++i) {
            if (!((Boolean)function1.Method41(iInventory.getStackInSlot(i))).booleanValue()) continue;
            return false;
        }
        return true;
    }

    @Nullable
    public BlockPos Method320() {
        return this.Field219;
    }

    public static void Method321(fdF fdF2, ItemStack itemStack) {
        fdF2.Field223 = itemStack;
    }
}

