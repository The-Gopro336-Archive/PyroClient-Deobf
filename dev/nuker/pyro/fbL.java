/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.f4C;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fbi;
import dev.nuker.pyro.fbj;
import dev.nuker.pyro.fbk;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fbl
extends Module {
    @NotNull
    public IntegerSetting Field2108 = (IntegerSetting)this.Method7264(new IntegerSetting("range", "Range", null, 10, 5, 20, 0, 64, null));
    @NotNull
    public IntegerSetting Field2109 = (IntegerSetting)this.Method7264(new IntegerSetting("y_range", "Y-Range", null, 7, 3, 20, 0, 64, null));
    @NotNull
    public f0l Field2110 = (f0l)this.Method7264(new f0l("bedrock_color", "Bedrock", null, new f00(0.0f, 1.0f, 1.0f, 1.0f)));
    @NotNull
    public f0l Field2111 = (f0l)this.Method7264(new f0l("obsidian_color", "Obsidian", null, new f00(0.1666666f, 1.0f, 1.0f, 1.0f)));
    @NotNull
    public f0l Field2112 = (f0l)this.Method7264(new f0l("bedrockOutline", "BedrockOutline", null, new f00(0.0f, 1.0f, 1.0f, 1.0f)));
    @NotNull
    public f0l Field2113 = (f0l)this.Method7264(new f0l("obsidianOutline", "ObsidianOutline", null, new f00(0.1666666f, 1.0f, 1.0f, 1.0f)));
    @NotNull
    public IntegerSetting Field2114 = new IntegerSetting("holeglow_opacity", "GlowOpacity", null, 100, 0, 255, 0, 64, null);
    @NotNull
    public DoubleSetting Field2115 = new DoubleSetting("holeglow_height", "GlowHeight", null, 3.0, 1.0, 10.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field2116 = new DoubleSetting("height", "Height", null, 0.1, 0.0, 1.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field2117 = (BooleanSetting)this.Method7264(new BooleanSetting("doubleHoles", "Double", "Show holes you can move in center of", true));
    @NotNull
    public f0z<fbj> Field2118;
    @NotNull
    public List<fbi> Field2119;

    public void Method2744(@NotNull AxisAlignedBB axisAlignedBB, boolean bl, int n) {
        BufferBuilder bufferBuilder = fe5.Field252.getBuffer();
        double d = axisAlignedBB.minX + 0.001;
        double d2 = axisAlignedBB.minY + 0.001;
        double d3 = axisAlignedBB.minZ + 0.001;
        double d4 = (double)((float)(axisAlignedBB.maxX - axisAlignedBB.minX)) - 0.002;
        float f = bl ? (float)(axisAlignedBB.maxY - axisAlignedBB.minY) : (float)((Number)this.Field2115.Method7979()).doubleValue();
        double d5 = (double)((float)(axisAlignedBB.maxZ - axisAlignedBB.minZ)) - 0.002;
        int n2 = ((Number)this.Field2114.Method7979()).intValue();
        int n3 = n >>> 16 & 0xFF;
        int n4 = n >>> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = 25;
        bufferBuilder.pos(d + d4, d2, d3).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d, d2, d3).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d, d2 + (double)f, d3).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d + d4, d2 + (double)f, d3).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d, d2, d3 + d5).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d + d4, d2, d3 + d5).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d + d4, d2 + (double)f, d3 + d5).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d, d2 + (double)f, d3 + d5).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d, d2, d3).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d, d2, d3 + d5).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d, d2 + (double)f, d3 + d5).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d, d2 + (double)f, d3).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d + d4, d2, d3 + d5).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d + d4, d2, d3).color(n3, n4, n5, n2).endVertex();
        bufferBuilder.pos(d + d4, d2 + (double)f, d3).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos(d + d4, d2 + (double)f, d3 + d5).color(n3, n4, n5, n6).endVertex();
    }

    public int Method2745(@NotNull BlockPos blockPos, boolean bl) {
        int n = 3;
        for (EnumFacing enumFacing : EnumFacing.VALUES) {
            int n2;
            block12: {
                block11: {
                    if (enumFacing == EnumFacing.UP) continue;
                    n2 = this.Method2748(blockPos.offset(enumFacing));
                    if (n2 == 0) break block11;
                    if (n >= 0) break block12;
                    if (n2 != 1) break block12;
                }
                return 0;
            }
            if (n > 0) {
                if (n2 == 1) {
                    if (bl) {
                        for (EnumFacing enumFacing2 : EnumFacing.VALUES) {
                            if (enumFacing2 == EnumFacing.UP) continue;
                            if (enumFacing2.getOpposite() == enumFacing) continue;
                            int n3 = this.Method2748(blockPos.offset(enumFacing).offset(enumFacing2));
                            if (n3 < 2) {
                                return 0;
                            }
                            if (enumFacing2 == EnumFacing.DOWN) {
                                if (n <= n3) continue;
                                n = n3;
                                continue;
                            }
                            n = -1;
                        }
                        if (n == -1) {
                            n = -enumFacing.getIndex() - 1;
                            continue;
                        }
                        return 0;
                    }
                }
            }
            if (n <= n2) continue;
            n = n2;
        }
        int n4 = n;
        int n5 = n4;
        return -6 <= n5 && -1 >= n5 ? -n + 2 : (n4 == 0 || n4 == 1 ? 0 : n - 1);
    }

    @NotNull
    public f0l Method2746() {
        return this.Field2113;
    }

    @NotNull
    public f0l Method216() {
        return this.Field2112;
    }

    public fbl() {
        super("hole_esp", "HoleESP", "Shows bedrock and obsidian holes to help with crystal pvp");
        List list;
        List[] arrlist = new List[5];
        arrlist[0] = CollectionsKt.Method1014(this.Field2114, this.Field2115);
        int n = 1;
        List[] arrlist2 = arrlist;
        List[] arrlist3 = arrlist;
        Enum enum_ = fbj.Glow;
        String string = "The type of rendering";
        String string2 = "Type";
        String string3 = "type";
        Object object = this;
        fbl fbl2 = this;
        boolean bl = false;
        arrlist2[n] = list = CollectionsKt.Method1013();
        n = 2;
        arrlist2 = arrlist3;
        bl = false;
        arrlist2[n] = list = CollectionsKt.Method1013();
        n = 3;
        arrlist2 = arrlist3;
        bl = false;
        arrlist2[n] = list = CollectionsKt.Method1013();
        arrlist3[4] = CollectionsKt.Method9007(this.Field2116);
        List[] arrlist4 = arrlist3;
        Enum enum_2 = enum_;
        String string4 = string;
        String string5 = string2;
        String string6 = string3;
        fbl2.Field2118 = (f0z)((Module)object).Method7264(new f0z(string6, string5, string4, enum_2, arrlist4));
        fbl2 = this;
        bl = false;
        fbl2.Field2119 = object = (List)new ArrayList();
    }

    @NotNull
    public f0z Method2747() {
        return this.Field2118;
    }

    @NotNull
    public DoubleSetting Method236() {
        return this.Field2115;
    }

    public int Method2748(@NotNull BlockPos blockPos) {
        Block block = feg.Method690(blockPos);
        return Intrinsics.Method6572((Object)block, (Object)Blocks.BEDROCK) ? 3 : (Intrinsics.Method6572((Object)block, (Object)Blocks.OBSIDIAN) ? 2 : (Intrinsics.Method6572((Object)block, (Object)Blocks.AIR) ? 1 : 0));
    }

    @NotNull
    public f0l Method2368() {
        return this.Field2110;
    }

    @f0g
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        block21: {
            this.Field2119.clear();
            BlockPos blockPos = new BlockPos(this.Field5233.player.getPositionVector());
            int n = -((Number)this.Field2109.Method7979()).intValue();
            int n2 = ((Number)this.Field2109.Method7979()).intValue();
            if (n > n2) break block21;
            while (true) {
                block22: {
                    int n3;
                    int n4;
                    if ((n4 = -((Number)this.Field2108.Method7979()).intValue()) > (n3 = ((Number)this.Field2108.Method7979()).intValue())) break block22;
                    while (true) {
                        block23: {
                            int n5;
                            int n6;
                            if ((n6 = -((Number)this.Field2108.Method7979()).intValue()) > (n5 = ((Number)this.Field2108.Method7979()).intValue())) break block23;
                            while (true) {
                                block24: {
                                    int n7;
                                    AxisAlignedBB axisAlignedBB;
                                    BlockPos blockPos2;
                                    block25: {
                                        boolean bl;
                                        EnumFacing enumFacing;
                                        block20: {
                                            blockPos2 = blockPos.add(n4, n, n6);
                                            axisAlignedBB = new AxisAlignedBB(blockPos2);
                                            Entity entity = this.Field5233.getRenderViewEntity();
                                            if (entity == null) {
                                                Intrinsics.Method6551();
                                            }
                                            Entity entity2 = this.Field5233.getRenderViewEntity();
                                            if (entity2 == null) {
                                                Intrinsics.Method6551();
                                            }
                                            Entity entity3 = this.Field5233.getRenderViewEntity();
                                            if (entity3 == null) {
                                                Intrinsics.Method6551();
                                            }
                                            PyroRenderUtil.Field7388.setPosition(entity.posX, entity2.posY, entity3.posZ);
                                            if (!PyroRenderUtil.Field7388.isBoundingBoxInFrustum(axisAlignedBB) || !this.Field5233.world.isAirBlock(blockPos2) || this.Field5233.world.isAirBlock(blockPos2.down()) || !this.Field5233.world.isAirBlock(blockPos2.up()) || !this.Field5233.world.isAirBlock(blockPos2.up(2))) break block24;
                                            n7 = this.Method2745(blockPos2, (Boolean)this.Field2117.Method7979());
                                            if (n7 == 0) break block24;
                                            if (n7 <= 2) break block25;
                                            enumFacing = EnumFacing.VALUES[n7 - 3];
                                            Iterable iterable = this.Field2119;
                                            boolean bl2 = false;
                                            if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                                                bl = false;
                                            } else {
                                                for (Object t : iterable) {
                                                    fbi fbi2 = (fbi)t;
                                                    boolean bl3 = false;
                                                    if (!Intrinsics.Method6572((Object)fbi2.Method2736(), (Object)blockPos2.offset(enumFacing))) continue;
                                                    bl = true;
                                                    break block20;
                                                }
                                                bl = false;
                                            }
                                        }
                                        if (bl) break block24;
                                        EnumFacing enumFacing2 = enumFacing;
                                        if (enumFacing2 != null) {
                                            switch (fbk.Field2106[enumFacing2.ordinal()]) {
                                                case 1: {
                                                    axisAlignedBB = new AxisAlignedBB(blockPos2.add(1, 1, 1), blockPos2.offset(enumFacing));
                                                    break;
                                                }
                                                case 2: {
                                                    axisAlignedBB = new AxisAlignedBB(blockPos2, blockPos2.offset(enumFacing).add(1, 1, 1));
                                                    break;
                                                }
                                                case 3: {
                                                    axisAlignedBB = new AxisAlignedBB(blockPos2.add(1, 1, 1), blockPos2.offset(enumFacing));
                                                    break;
                                                }
                                                case 4: {
                                                    axisAlignedBB = new AxisAlignedBB(blockPos2, blockPos2.offset(enumFacing).add(1, 1, 1));
                                                }
                                            }
                                        }
                                    }
                                    this.Field2119.add(new fbi(this, axisAlignedBB, blockPos2, n7 == 2));
                                }
                                if (n6 == n5) break;
                                ++n6;
                            }
                        }
                        if (n4 == n3) break;
                        ++n4;
                    }
                }
                if (n == n2) break;
                ++n;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method2275(@NotNull f4C var1_1) {
        switch (fbk.Field2107[((fbj)this.Field2118.Method7991().Method7979()).ordinal()]) {
            case 1: {
                GlStateManager.enableBlend();
                GlStateManager.disableAlpha();
                GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
                GlStateManager.shadeModel((int)7425);
                GlStateManager.disableDepth();
                var2_2 = fdN.Method350(Objects.requireNonNull(this.Field5233.getRenderViewEntity()), var1_1.Method5640());
                fe5.Field252.getBuffer().setTranslation(-var2_2.x, -var2_2.y, -var2_2.z);
                fe5.Field252.Method408(1);
                var3_7 = this.Field2119;
                var4_12 = false;
                for (Object var6_24 : var3_7) {
                    var7_29 = (fbi)var6_24;
                    var8_34 = false;
                    fe5.Field252.Method411(var7_29.Method2735(), var7_29.Method2738(), 1);
                }
                fe5.Field252.Method405();
                fe5.Field252.Method408(7);
                GlStateManager.enableDepth();
                var3_7 = new BlockPos(this.Field5233.player.getPositionVector());
                var4_13 = this.Field2119;
                var5_19 = false;
                var6_24 = var4_13.iterator();
                while (true) {
                    if (!var6_24.hasNext()) {
                        fe5.Field252.Method405();
                        GlStateManager.shadeModel((int)7424);
                        GlStateManager.shadeModel((int)7424);
                        GlStateManager.disableBlend();
                        GlStateManager.enableAlpha();
                        GlStateManager.enableDepth();
                        return;
                    }
                    var8_35 = var7_29 = var6_24.next();
                    var9_40 = false;
                    v0 = var8_35.Method2735();
                    if (Intrinsics.Method6572(var3_7, (Object)var8_35.Method2736())) ** GOTO lbl-1000
                    if (var8_35.Method2735().intersects(this.Field5233.player.getEntityBoundingBox().expand(0.0, -2.0, 0.0))) lbl-1000:
                    // 2 sources

                    {
                        v1 = true;
                    } else {
                        v1 = false;
                    }
                    this.Method2744(v0, v1, var8_35.Method2737());
                }
            }
            case 2: {
                GlStateManager.enableBlend();
                GlStateManager.disableAlpha();
                GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
                GlStateManager.shadeModel((int)7425);
                GlStateManager.disableDepth();
                var2_3 = fdN.Method350(Objects.requireNonNull(this.Field5233.getRenderViewEntity()), var1_1.Method5640());
                fe5.Field252.getBuffer().setTranslation(-var2_3.x, -var2_3.y, -var2_3.z);
                fe5.Field252.Method408(7);
                var3_8 = this.Field2119;
                var4_14 = false;
                var5_20 = var3_8.iterator();
                while (true) {
                    if (!var5_20.hasNext()) {
                        fe5.Field252.Method405();
                        GlStateManager.shadeModel((int)7424);
                        GlStateManager.disableBlend();
                        GlStateManager.enableAlpha();
                        GlStateManager.enableDepth();
                        return;
                    }
                    var6_25 = var5_20.next();
                    var7_30 = (fbi)var6_25;
                    var8_36 = false;
                    fe5.Field252.Method416(var7_30.Method2735(), var7_30.Method2737(), 63);
                }
            }
            case 3: {
                GlStateManager.enableBlend();
                GlStateManager.disableAlpha();
                GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
                GlStateManager.shadeModel((int)7425);
                GlStateManager.disableDepth();
                var2_4 = fdN.Method350(Objects.requireNonNull(this.Field5233.getRenderViewEntity()), var1_1.Method5640());
                fe5.Field252.getBuffer().setTranslation(-var2_4.x, -var2_4.y, -var2_4.z);
                fe5.Field252.Method408(7);
                var3_9 = this.Field2119;
                var4_15 = false;
                for (T var6_26 : var3_9) {
                    var7_31 = (fbi)var6_26;
                    var8_37 = false;
                    fe5.Field252.Method416(var7_31.Method2735(), var7_31.Method2737(), 63);
                }
                fe5.Field252.Method405();
                GlStateManager.shadeModel((int)7424);
                GlStateManager.disableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.enableDepth();
                var3_9 = this.Field2119;
                var4_15 = false;
                var5_21 = var3_9.iterator();
                while (var5_21.hasNext() != false) {
                    var6_26 = var5_21.next();
                    var7_31 = (fbi)var6_26;
                    var8_37 = false;
                    v2 = this.Field5233.getRenderViewEntity();
                    if (v2 == null) {
                        Intrinsics.Method6551();
                    }
                    var9_41 = PyroRenderUtil.Method364(v2, this.Field5233.getRenderPartialTicks());
                    PyroRenderUtil.Method12310(var7_31.Method2735().offset(-var9_41.x, -var9_41.y, -var9_41.z), var7_31.Method2738(), 1.5f);
                }
                return;
            }
            case 4: {
                var2_5 = this.Field2119;
                var3_10 = false;
                var4_16 = var2_5.iterator();
                while (var4_16.hasNext() != false) {
                    var5_22 = var4_16.next();
                    var6_27 = (fbi)var5_22;
                    var7_32 = false;
                    v3 = this.Field5233.getRenderViewEntity();
                    if (v3 == null) {
                        Intrinsics.Method6551();
                    }
                    var8_38 = PyroRenderUtil.Method364(v3, this.Field5233.getRenderPartialTicks());
                    PyroRenderUtil.Method12310(var6_27.Method2735().offset(-var8_38.x, -var8_38.y, -var8_38.z), var6_27.Method2738(), 1.5f);
                }
                return;
            }
            case 5: {
                GlStateManager.enableBlend();
                GlStateManager.disableAlpha();
                GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
                GlStateManager.shadeModel((int)7425);
                GlStateManager.disableDepth();
                var2_6 = fdN.Method350(Objects.requireNonNull(this.Field5233.getRenderViewEntity()), var1_1.Method5640());
                fe5.Field252.getBuffer().setTranslation(-var2_6.x, -var2_6.y, -var2_6.z);
                fe5.Field252.Method408(7);
                var3_11 = this.Field2119;
                var4_17 = false;
                for (T var6_28 : var3_11) {
                    var7_33 = (fbi)var6_28;
                    var8_39 = false;
                    fe5.Field252.Method416(var7_33.Method2735().contract(0.0, (double)true - ((Number)this.Field2116.Method7979()).doubleValue(), 0.0), var7_33.Method2737(), 63);
                }
                fe5.Field252.Method405();
                GlStateManager.shadeModel((int)7424);
                GlStateManager.disableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.enableDepth();
                var3_11 = this.Field2119;
                var4_17 = false;
                var5_23 = var3_11.iterator();
                while (var5_23.hasNext() != false) {
                    var6_28 = var5_23.next();
                    var7_33 = (fbi)var6_28;
                    var8_39 = false;
                    v4 = this.Field5233.getRenderViewEntity();
                    if (v4 == null) {
                        Intrinsics.Method6551();
                    }
                    var9_42 = PyroRenderUtil.Method364(v4, this.Field5233.getRenderPartialTicks());
                    PyroRenderUtil.Method12310(var7_33.Method2735().contract(0.0, (double)true - ((Number)this.Field2116.Method7979()).doubleValue(), 0.0).offset(-var9_42.x, -var9_42.y, -var9_42.z), var7_33.Method2738(), 1.5f);
                }
                return;
            }
        }
    }

    @NotNull
    public IntegerSetting Method2749() {
        return this.Field2109;
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field2116;
    }

    @NotNull
    public List Method2750() {
        return this.Field2119;
    }

    @NotNull
    public IntegerSetting Method2619() {
        return this.Field2114;
    }

    @NotNull
    public IntegerSetting Method2751() {
        return this.Field2108;
    }

    @NotNull
    public BooleanSetting Method283() {
        return this.Field2117;
    }

    @NotNull
    public f0l Method2752() {
        return this.Field2111;
    }
}

