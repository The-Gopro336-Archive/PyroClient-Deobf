/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fa2;
import dev.nuker.pyro.fa3;
import dev.nuker.pyro.fa4;
import dev.nuker.pyro.fa5;
import dev.nuker.pyro.fdJ;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fa6 {
    @Nullable
    public LinkedList<fa3> Field1626;
    @NotNull
    public double[] Field1627;
    @NotNull
    public fa3[] Field1628;
    @NotNull
    public Double[] Field1629;
    @NotNull
    public CopyOnWriteArrayList<BlockPos> Field1630;
    @NotNull
    public CopyOnWriteArrayList<BlockPos> Field1631;
    @NotNull
    public CopyOnWriteArrayList<BlockPos> Field1632;
    public boolean Field1633;
    @Nullable
    public fa3 Field1634;
    @NotNull
    public BlockPos[] Field1635;
    @NotNull
    public BlockPos[] Field1636;
    @NotNull
    public BlockPos Field1637;
    @NotNull
    public BlockPos Field1638;
    public double Field1639;
    public double Field1640;
    @NotNull
    public World Field1641;
    public long Field1642;

    @Nullable
    public fa3 Method2325() {
        double d = 0.0;
        fa3 fa32 = null;
        int n = this.Field1627.length;
        for (int i = 0; i < n; ++i) {
            if (this.Field1628[i] == null) continue;
            fa3 fa33 = this.Field1628[i];
            if (fa33 == null) {
                Intrinsics.Method6551();
            }
            double d2 = this.Field1637.distanceSq((Vec3i)fa33.Method2295());
            if (!(d2 > d)) continue;
            if (!(d2 > 25.0)) continue;
            d = d2;
            fa32 = this.Field1628[i];
        }
        return fa32;
    }

    public void Method2326(@Nullable LinkedList linkedList) {
        this.Field1626 = linkedList;
    }

    @NotNull
    public CopyOnWriteArrayList Method2327() {
        return this.Field1632;
    }

    public void Method2328(@NotNull Double[] arrdouble) {
        this.Field1629 = arrdouble;
    }

    public void Method2329(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field1631 = copyOnWriteArrayList;
    }

    public boolean Method2330(BlockPos blockPos, BlockPos blockPos2) {
        int n;
        int n2 = blockPos.getX();
        int n3 = blockPos2.getX();
        fa6 fa62 = this;
        boolean bl = false;
        int n4 = Math.min(n2, n3);
        n2 = blockPos.getY();
        n3 = blockPos2.getY();
        --n4;
        bl = false;
        int n5 = Math.min(n2, n3);
        n2 = blockPos.getZ();
        n3 = blockPos2.getZ();
        bl = false;
        int n6 = Math.min(n2, n3);
        int n7 = n6 - 1;
        int n8 = --n5;
        int n9 = n4;
        n2 = blockPos.getX();
        n3 = blockPos2.getX();
        BlockPos blockPos3 = new BlockPos(n9, n8, n7);
        bl = false;
        n5 = Math.max(n2, n3);
        n2 = blockPos.getY();
        n3 = blockPos2.getY();
        bl = false;
        n6 = Math.max(n2, n3);
        n2 = blockPos.getZ();
        n3 = blockPos2.getZ();
        bl = false;
        int n10 = n = Math.max(n2, n3);
        int n11 = n6;
        int n12 = n5;
        return fa62.Method2334(blockPos3, new BlockPos(n12, n11, n10));
    }

    @NotNull
    public CopyOnWriteArrayList Method2331() {
        return this.Field1630;
    }

    public double Method2332() {
        return this.Field1639;
    }

    public void Method2333(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field1632 = copyOnWriteArrayList;
    }

    public boolean Method2334(BlockPos blockPos, BlockPos blockPos2) {
        int n = blockPos.getX();
        int n2 = blockPos2.getX();
        int n3 = 0;
        int n4 = Math.min(n, n2);
        n = blockPos.getX();
        n2 = blockPos2.getX();
        n3 = 0;
        int n5 = Math.max(n, n2);
        if (n4 <= n5) {
            while (true) {
                n3 = blockPos.getY();
                int n6 = blockPos2.getY();
                int n7 = 0;
                n = Math.min(n3, n6);
                n3 = blockPos.getY();
                n6 = blockPos2.getY();
                n7 = 0;
                n2 = Math.max(n3, n6);
                if (n <= n2) {
                    while (true) {
                        n7 = blockPos.getZ();
                        int n8 = blockPos2.getZ();
                        boolean bl = false;
                        n3 = Math.min(n7, n8);
                        n7 = blockPos.getZ();
                        n8 = blockPos2.getZ();
                        bl = false;
                        n6 = Math.max(n7, n8);
                        if (n3 <= n6) {
                            while (true) {
                                IBlockState iBlockState = this.Field1641.getBlockState(new BlockPos(n4, n, n3));
                                if (!this.Method2341(iBlockState)) {
                                    return false;
                                }
                                if (n3 == n6) break;
                                ++n3;
                            }
                        }
                        if (n == n2) break;
                        ++n;
                    }
                }
                if (n4 == n5) break;
                ++n4;
            }
        }
        return true;
    }

    public void Method2335(@Nullable fa3 fa32) {
        this.Field1634 = fa32;
    }

    @Nullable
    public fa3 Method2336() {
        return this.Field1634;
    }

    @NotNull
    public BlockPos Method2337() {
        return this.Field1638;
    }

    public double Method2338() {
        return this.Field1640;
    }

    public boolean Method2339(BlockPos blockPos, BlockPos blockPos2) {
        int n;
        int n2 = blockPos.getX();
        int n3 = blockPos2.getX();
        fa6 fa62 = this;
        boolean bl = false;
        int n4 = Math.min(n2, n3);
        n2 = blockPos.getY();
        n3 = blockPos2.getY();
        --n4;
        bl = false;
        int n5 = Math.min(n2, n3);
        n2 = blockPos.getZ();
        n3 = blockPos2.getZ();
        bl = false;
        int n6 = Math.min(n2, n3);
        int n7 = n6 - 1;
        int n8 = --n5;
        int n9 = n4;
        n2 = blockPos.getX();
        n3 = blockPos2.getX();
        BlockPos blockPos3 = new BlockPos(n9, n8, n7);
        bl = false;
        n5 = Math.max(n2, n3);
        n2 = blockPos.getY();
        n3 = blockPos2.getY();
        bl = false;
        n6 = Math.max(n2, n3);
        n2 = blockPos.getZ();
        n3 = blockPos2.getZ();
        bl = false;
        int n10 = n = Math.max(n2, n3);
        int n11 = ++n6;
        int n12 = n5;
        return fa62.Method2359(blockPos3, new BlockPos(n12, n11, n10));
    }

    @NotNull
    public World Method2340() {
        return this.Field1641;
    }

    public boolean Method2341(IBlockState iBlockState) {
        return iBlockState.getMaterial().isLiquid() ? false : Intrinsics.Method6572((Object)iBlockState.getMaterial(), (Object)Material.AIR) || Intrinsics.Method6572((Object)iBlockState.getMaterial(), (Object)Material.PLANTS);
    }

    public void Method2342(boolean bl) {
        this.Field1633 = bl;
    }

    @NotNull
    public Double[] Method2343() {
        return this.Field1629;
    }

    @NotNull
    public double[] Method2344() {
        return this.Field1627;
    }

    public boolean Method2345() {
        return this.Field1633;
    }

    @NotNull
    public LinkedList Method2346(@NotNull fa3 fa32) {
        LinkedList<fa3> linkedList = new LinkedList<fa3>();
        fa3 fa33 = fa32;
        do {
            linkedList.add(fa33);
        } while ((fa33 = fa33.Method2292()) != null);
        CollectionsKt.Method324((List)linkedList);
        return linkedList;
    }

    public long Method2347() {
        return this.Field1642;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @NotNull
    public fa4 Method2348() {
        var1_1 = new fdJ(fa5.Field1625, false, 2, null);
        this.Field1634 = var2_2 = new fa3(this, null, this.Field1637, 0.0);
        var3_3 = 0;
        while (true) {
            if (this.Field1634 == null) ** GOTO lbl-1000
            v0 = this.Field1634;
            if (v0 == null) {
                Intrinsics.Method6551();
            }
            if (!v0.Method2293(this.Field1638)) {
                var6_8 = fa2.Method2290();
                var7_9 = var6_8.length;
            } else lbl-1000:
            // 2 sources

            {
                v1 = this.Field1634;
                if (v1 == null) {
                    Intrinsics.Method6551();
                }
                this.Method2357(v1);
                v2 = this.Field1634;
                if (v2 == null) {
                    Intrinsics.Method6551();
                }
                this.Field1626 = this.Method2346(v2);
                return fa4.REACHED_GOAL;
            }
            for (var5_7 = 0; var5_7 < var7_9; ++var5_7) {
                block19: {
                    block18: {
                        var4_6 = var6_8[var5_7];
                        v3 = this.Field1634;
                        if (v3 == null) {
                            Intrinsics.Method6551();
                        }
                        var8_10 = v3.Method2295().add((Vec3i)var4_6.Method2287());
                        v4 = this.Field1634;
                        if (v4 == null) {
                            Intrinsics.Method6551();
                        }
                        if (!this.Method2339(v4.Method2295(), var8_10)) break block19;
                        v5 = this.Field1634;
                        if (v5 == null) {
                            Intrinsics.Method6551();
                        }
                        v6 = v5.Method2294();
                        if (this.Field1640 == 1.0) ** GOTO lbl-1000
                        v7 = this.Field1634;
                        if (v7 == null) {
                            Intrinsics.Method6551();
                        }
                        if (this.Method2330(v7.Method2295(), var8_10)) lbl-1000:
                        // 2 sources

                        {
                            v8 = var4_6.Method2288();
                        } else {
                            v8 = var4_6.Method2288() - 1.0 + this.Field1640;
                        }
                        var9_11 = v6 + v8;
                        var11_12 = new fa3(this, this.Field1634, var8_10, var9_11);
                        var13_14 = var1_1;
                        var14_15 = false;
                        for (T var16_17 : var13_14) {
                            var17_18 = (fa3)var16_17;
                            var18_19 = false;
                            if (!Intrinsics.Method6572((Object)var17_18.Method2295(), (Object)var8_10)) continue;
                            v9 = var16_17;
                            break block18;
                        }
                        v9 = null;
                    }
                    var12_13 = v9;
                    if (var12_13 != null || this.Field1630.contains((Object)var8_10) || this.Field1632.contains((Object)var8_10)) continue;
                    var1_1.add(var11_12);
                    this.Field1631.add(var8_10);
                    continue;
                }
                if (this.Field1632.contains((Object)var8_10)) continue;
                this.Field1632.add(var8_10);
                this.Field1631.add(var8_10);
            }
            var4_4 = (fa3)var1_1.poll();
            if (var4_4 != null) {
                if (!this.Field1641.isBlockLoaded(var4_4.Method2295(), false)) {
                    v10 = this.Field1634;
                    if (v10 == null) {
                        Intrinsics.Method6551();
                    }
                    this.Method2357(v10);
                    v11 = this.Field1634;
                    if (v11 == null) {
                        Intrinsics.Method6551();
                    }
                    this.Field1626 = this.Method2346(v11);
                    return fa4.UNLOADED_CHUNKS;
                }
                this.Field1634 = var4_4;
                this.Field1630.add(var4_4.Method2295());
                this.Field1631.remove((Object)var4_4.Method2295());
            }
            ++var3_3;
        }
    }

    @Nullable
    public LinkedList Method2349() {
        return this.Field1626;
    }

    public void Method2350(@NotNull BlockPos blockPos) {
        this.Field1638 = blockPos;
    }

    @NotNull
    public fa3[] Method2351() {
        return this.Field1628;
    }

    public void Method2352(@NotNull fa3[] arrfa3) {
        this.Field1628 = arrfa3;
    }

    @NotNull
    public BlockPos[] Method2353() {
        return this.Field1635;
    }

    @NotNull
    public BlockPos Method2354() {
        return this.Field1637;
    }

    @NotNull
    public CopyOnWriteArrayList Method2355() {
        return this.Field1631;
    }

    public void Method2356(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field1630 = copyOnWriteArrayList;
    }

    public void Method2357(@NotNull fa3 fa32) {
        fa3 fa33 = fa32;
        while (true) {
            fa3 fa34 = fa33.Method2292();
            if ((fa34 != null ? fa34.Method2292() : null) == null) break;
            BlockPos blockPos = fa33.Method2295();
            fa3 fa35 = fa33.Method2292();
            if (fa35 == null) {
                Intrinsics.Method6551();
            }
            fa3 fa36 = fa35.Method2292();
            if (fa36 == null) {
                Intrinsics.Method6551();
            }
            BlockPos blockPos2 = fa36.Method2295();
            fa3 fa37 = fa33.Method2292();
            if ((fa37 != null && (fa37 = fa37.Method2292()) != null ? fa37.Method2292() : null) != null) {
                fa3 fa38 = fa33.Method2292();
                if (fa38 == null) {
                    Intrinsics.Method6551();
                }
                fa3 fa39 = fa38.Method2292();
                if (fa39 == null) {
                    Intrinsics.Method6551();
                }
                fa3 fa310 = fa39.Method2292();
                if (fa310 == null) {
                    Intrinsics.Method6551();
                }
                BlockPos blockPos3 = fa310.Method2295();
                int n = 0;
                for (BlockPos blockPos4 : this.Field1635) {
                    if (!Intrinsics.Method6572((Object)blockPos, (Object)blockPos3.add((Vec3i)blockPos4))) continue;
                    if (!this.Method2339(blockPos3, blockPos)) break;
                    fa3 fa311 = fa33.Method2292();
                    if (fa311 == null) {
                        Intrinsics.Method6551();
                    }
                    fa3 fa312 = fa311.Method2292();
                    if (fa312 == null) {
                        Intrinsics.Method6551();
                    }
                    fa33.Method2297(fa312.Method2292());
                    n = 1;
                    break;
                }
                if (n != 0) {
                    if (fa33.Method2292() == null) {
                        Intrinsics.Method6551();
                    }
                    continue;
                }
            }
            for (BlockPos blockPos3 : this.Field1636) {
                if (!Intrinsics.Method6572((Object)blockPos, (Object)blockPos2.add((Vec3i)blockPos3))) continue;
                if (!this.Method2339(blockPos2, blockPos)) break;
                fa3 fa313 = fa33.Method2292();
                if (fa313 == null) {
                    Intrinsics.Method6551();
                }
                fa33.Method2297(fa313.Method2292());
                break;
            }
            if (fa33.Method2292() != null) continue;
            Intrinsics.Method6551();
        }
    }

    @NotNull
    public BlockPos[] Method2358() {
        return this.Field1636;
    }

    public boolean Method2359(BlockPos blockPos, BlockPos blockPos2) {
        int n = blockPos.getX();
        int n2 = blockPos2.getX();
        int n3 = 0;
        int n4 = Math.min(n, n2);
        n = blockPos.getX();
        n2 = blockPos2.getX();
        n3 = 0;
        int n5 = Math.max(n, n2);
        if (n4 <= n5) {
            while (true) {
                n3 = blockPos.getY();
                int n6 = blockPos2.getY();
                int n7 = 0;
                n = Math.min(n3, n6);
                n3 = blockPos.getY();
                n6 = blockPos2.getY();
                n7 = 0;
                n2 = Math.max(n3, n6);
                if (n <= n2) {
                    while (true) {
                        int n8;
                        int n9;
                        n3 = 1;
                        int n10 = blockPos.getZ();
                        int n11 = blockPos2.getZ();
                        int n12 = 0;
                        n6 = Math.min(n10, n11);
                        n10 = blockPos.getZ();
                        n11 = blockPos2.getZ();
                        n12 = 0;
                        n7 = Math.max(n10, n11);
                        if (n6 <= n7) {
                            while (true) {
                                IBlockState iBlockState = this.Field1641.getBlockState(new BlockPos(n4, n, n6));
                                if (!Intrinsics.Method6572((Object)iBlockState.getBlock(), (Object)Blocks.LAVA) && !Intrinsics.Method6572((Object)iBlockState.getBlock(), (Object)Blocks.FLOWING_LAVA)) {
                                    n3 = 0;
                                }
                                n11 = blockPos.getY();
                                n12 = blockPos2.getY();
                                n9 = n;
                                boolean bl = false;
                                n8 = Math.min(n11, n12);
                                if (n9 != n8 && !this.Method2341(iBlockState)) {
                                    return false;
                                }
                                if (n6 == n7) break;
                                ++n6;
                            }
                        }
                        n6 = blockPos.getY();
                        n7 = blockPos2.getY();
                        n9 = n;
                        n10 = 0;
                        n8 = Math.min(n6, n7);
                        if (n9 == n8 && n3 != 0) {
                            return false;
                        }
                        if (n == n2) break;
                        ++n;
                    }
                }
                if (n4 == n5) break;
                ++n4;
            }
        }
        return true;
    }

    public fa6(@NotNull BlockPos blockPos, @NotNull BlockPos blockPos2, double d, double d2, @NotNull World world, long l) {
        Double[] arrdouble;
        this.Field1637 = blockPos;
        this.Field1638 = blockPos2;
        this.Field1639 = d;
        this.Field1640 = d2;
        this.Field1641 = world;
        this.Field1642 = l;
        this.Field1627 = new double[]{1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0};
        this.Field1628 = new fa3[this.Field1627.length];
        int n = this.Field1627.length;
        fa6 fa62 = this;
        Double[] arrdouble2 = new Double[n];
        int n2 = 0;
        while (n2 < n) {
            Double d3;
            int n3 = n2;
            int n4 = n2++;
            arrdouble = arrdouble2;
            boolean bl = false;
            arrdouble[n4] = d3 = Double.valueOf(DoubleCompanionObject.Field5324.Method7366());
        }
        arrdouble = arrdouble2;
        fa62.Field1629 = arrdouble;
        this.Field1630 = new CopyOnWriteArrayList();
        this.Field1631 = new CopyOnWriteArrayList();
        this.Field1632 = new CopyOnWriteArrayList();
        this.Field1635 = new BlockPos[]{new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 1), new BlockPos(1, -1, -1), new BlockPos(-1, -1, -1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 1), new BlockPos(1, 1, -1), new BlockPos(-1, 1, -1)};
        this.Field1636 = new BlockPos[]{new BlockPos(-1, -1, 0), new BlockPos(1, 1, 0), new BlockPos(-1, 1, 0), new BlockPos(1, -1, 0), new BlockPos(0, -1, -1), new BlockPos(0, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 1)};
    }

    public void Method2360(@NotNull BlockPos blockPos) {
        this.Field1637 = blockPos;
    }
}

