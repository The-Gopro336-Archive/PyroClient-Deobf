/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f4C;
import dev.nuker.pyro.fa0;
import dev.nuker.pyro.fa3;
import dev.nuker.pyro.fa6;
import dev.nuker.pyro.fdU;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fa1
extends Module {
    public boolean Field1598;
    @NotNull
    public DoubleSetting Field1599 = (DoubleSetting)this.Method7264(new DoubleSetting("hmult", "Heuristic Multiplier", null, 2.0, 0.01, 10.0, 0.0, 64, null));
    @NotNull
    public DoubleSetting Field1600 = (DoubleSetting)this.Method7264(new DoubleSetting("floorCost", "FloorCost", "Don't go on the ground", 25.0, 1.0, 100.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field1601 = (BooleanSetting)this.Method7264(new BooleanSetting("showChecked", "Show Checked", null, false));
    @NotNull
    public BooleanSetting Field1602 = (BooleanSetting)this.Method7264(new BooleanSetting("showHorizon", "Show Horizon", null, false));
    @NotNull
    public BooleanSetting Field1603 = (BooleanSetting)this.Method7264(new BooleanSetting("showFailed", "Show Failed", null, false));
    @NotNull
    public BooleanSetting Field1604 = (BooleanSetting)this.Method7264(new BooleanSetting("showBoxes", "Show Boxes", null, false));
    @NotNull
    public BooleanSetting Field1605 = (BooleanSetting)this.Method7264(new BooleanSetting("debugClips", "DebugRenderClips", null, true));
    @Nullable
    public fa6 Field1606;
    @Nullable
    public Vec3d Field1607;
    @Nullable
    public LinkedList<BlockPos> Field1608;
    @Nullable
    public Thread Field1609;
    @NotNull
    public BlockPos Field1610 = new BlockPos(0, 0, 0);
    public float Field1611;
    public float Field1612;
    public long Field1613;

    public void Method2268(double d, double d2, double d3) {
        Pyro.Field6182.Method8989("Detected a rubberband, pausing");
        this.Field1613 = System.currentTimeMillis() + 2000L;
        this.Method209(new BlockPos(d, d2, d3));
    }

    public boolean Method2269() {
        return this.Field1598;
    }

    public long Method2270() {
        return this.Field1613;
    }

    @Nullable
    public fa6 Method2271() {
        return this.Field1606;
    }

    @NotNull
    public BooleanSetting Method279() {
        return this.Field1601;
    }

    @NotNull
    public DoubleSetting Method225() {
        return this.Field1600;
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field1603;
    }

    public void Method557(boolean bl) {
        this.Field1598 = bl;
    }

    public void Method2272(@NotNull BlockPos blockPos, @NotNull BlockPos blockPos2, int n) {
        Vec3d vec3d = new Vec3d((Vec3i)blockPos).addVector(0.0, 0.5, 0.0);
        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos2).addVector(0.0, 0.5, 0.0);
        this.Method2273(vec3d, vec3d2, n);
    }

    public void Method2273(@NotNull Vec3d vec3d, @NotNull Vec3d vec3d2, int n) {
        Color color = new Color(n);
        fe5.Field252.Method397(fe5.Field252.getBuffer(), vec3d.x, vec3d.y, vec3d.z, vec3d2.x, vec3d2.y, vec3d2.z, n, n);
    }

    @Nullable
    public Vec3d Method2274() {
        return this.Field1607;
    }

    @f0g
    @LauncherEventHide
    public void Method2275(@NotNull f4C f4C2) {
        if (this.Field5233.player != null && this.Field5233.world != null && this.Field1606 != null) {
            boolean bl;
            Object object;
            boolean bl2;
            Iterable iterable;
            GlStateManager.enableAlpha();
            fe5.Field252.Method408(7);
            if (!((Boolean)this.Field1605.Method7979()).booleanValue()) {
                GlStateManager.enableDepth();
            }
            if (((Boolean)this.Field1601.Method7979()).booleanValue()) {
                fa6 fa62 = this.Field1606;
                if (fa62 == null) {
                    Intrinsics.Method6551();
                }
                iterable = fa62.Method2331();
                bl2 = false;
                for (Object t : iterable) {
                    object = (BlockPos)t;
                    bl = false;
                    fe5.Field252.Method394((float)object.getX() - 0.3f, (float)object.getY() + 0.2f, (float)object.getZ() - 0.3f, 0.6f, 0.6f, 0.6f, 503382015, 63);
                }
            }
            if (((Boolean)this.Field1602.Method7979()).booleanValue()) {
                fa6 fa63 = this.Field1606;
                if (fa63 == null) {
                    Intrinsics.Method6551();
                }
                iterable = fa63.Method2355();
                bl2 = false;
                for (Object t : iterable) {
                    object = (BlockPos)t;
                    bl = false;
                    fe5.Field252.Method394((float)object.getX() - 0.3f, (float)object.getY() + 0.2f, (float)object.getZ() - 0.3f, 0.6f, 0.6f, 0.6f, 503381760, 63);
                }
            }
            if (((Boolean)this.Field1603.Method7979()).booleanValue()) {
                fa6 fa64 = this.Field1606;
                if (fa64 == null) {
                    Intrinsics.Method6551();
                }
                iterable = fa64.Method2327();
                bl2 = false;
                for (Object t : iterable) {
                    object = (BlockPos)t;
                    bl = false;
                    fe5.Field252.Method394((float)object.getX() - 0.3f, (float)object.getY() + 0.2f, (float)object.getZ() - 0.3f, 0.6f, 0.6f, 0.6f, 520028160, 63);
                }
            }
            fe5.Field252.Method405();
            fe5.Field252.Method408(1);
            GlStateManager.glLineWidth((float)1.5f);
            fa6 fa65 = this.Field1606;
            if ((fa65 != null ? fa65.Method2349() : null) != null) {
                fa6 fa66 = this.Field1606;
                if (fa66 == null) {
                    Intrinsics.Method6551();
                }
                LinkedList linkedList = fa66.Method2349();
                if (linkedList == null) {
                    Intrinsics.Method6551();
                }
                iterable = linkedList;
                bl2 = false;
                for (Object t : iterable) {
                    object = (fa3)t;
                    bl = false;
                    if (((fa3)object).Method2292() == null) continue;
                    fa3 fa32 = ((fa3)object).Method2292();
                    if (fa32 == null) {
                        Intrinsics.Method6551();
                    }
                    this.Method2272(fa32.Method2295(), ((fa3)object).Method2295(), Color.GREEN.getRGB());
                    if (!((Boolean)this.Field1604.Method7979()).booleanValue()) continue;
                    fa3 fa33 = ((fa3)object).Method2292();
                    if (fa33 == null) {
                        Intrinsics.Method6551();
                    }
                    fe5.Field252.Method411(new AxisAlignedBB(fa33.Method2295(), ((fa3)object).Method2295()).expand(0.75, 1.0, 0.75).expand(-0.75, 0.0, -0.75), Color.RED.getRGB(), 63);
                }
            } else {
                fa6 fa67 = this.Field1606;
                if ((fa67 != null ? fa67.Method2336() : null) != null) {
                    fa6 fa68 = this.Field1606;
                    if (fa68 == null) {
                        Intrinsics.Method6551();
                    }
                    fa6 fa69 = this.Field1606;
                    if (fa69 == null) {
                        Intrinsics.Method6551();
                    }
                    fa3 fa34 = fa69.Method2336();
                    if (fa34 == null) {
                        Intrinsics.Method6551();
                    }
                    iterable = fa68.Method2346(fa34);
                    bl2 = false;
                    for (Object t : iterable) {
                        object = (fa3)t;
                        bl = false;
                        if (((fa3)object).Method2292() == null) continue;
                        fa3 fa35 = ((fa3)object).Method2292();
                        if (fa35 == null) {
                            Intrinsics.Method6551();
                        }
                        this.Method2272(fa35.Method2295(), ((fa3)object).Method2295(), Color.MAGENTA.getRGB());
                        if (!((Boolean)this.Field1604.Method7979()).booleanValue()) continue;
                        fa3 fa36 = ((fa3)object).Method2292();
                        if (fa36 == null) {
                            Intrinsics.Method6551();
                        }
                        fe5.Field252.Method411(new AxisAlignedBB(fa36.Method2295(), ((fa3)object).Method2295()).expand(0.75, 1.0, 0.75).expand(-0.75, 0.0, -0.75), Color.RED.getRGB(), 63);
                    }
                }
            }
            if (this.Field1607 != null) {
                Vec3d vec3d = this.Field5233.player.getPositionVector();
                Vec3d vec3d2 = this.Field1607;
                if (vec3d2 == null) {
                    Intrinsics.Method6551();
                }
                this.Method2273(vec3d, vec3d2, Color.BLUE.getRGB());
            }
            fe5.Field252.Method405();
        }
    }

    @f0g
    @LauncherEventHide
    public void Method277(@NotNull f43 f432) {
        block13: {
            block11: {
                block12: {
                    block10: {
                        block9: {
                            if (this.Field5233.player == null || this.Field1606 == null) break block9;
                            fa6 fa62 = this.Field1606;
                            if (fa62 == null) {
                                Intrinsics.Method6551();
                            }
                            if (fa62.Method2349() != null) break block10;
                        }
                        return;
                    }
                    Collection collection = this.Field1608;
                    boolean bl = false;
                    boolean bl2 = false;
                    if (collection == null || collection.isEmpty()) break block11;
                    if (this.Field1607 == null) break block12;
                    if (this.Field5233.player.getRidingEntity() == null) break block13;
                    Entity entity = this.Field5233.player.getRidingEntity();
                    if (entity == null) {
                        Intrinsics.Method6551();
                    }
                    if (!(entity.getPositionVector().distanceTo(this.Field1607) < 0.5)) break block13;
                }
                LinkedList<BlockPos> linkedList = this.Field1608;
                if (linkedList == null) {
                    Intrinsics.Method6551();
                }
                this.Field1607 = new Vec3d((Vec3i)linkedList.removeFirst()).addVector(0.0, 0.1, 0.0);
                break block13;
            }
            fa1.Method2285(this, null, 1, null);
        }
    }

    public void Method2276(@Nullable Thread thread2) {
        this.Field1609 = thread2;
    }

    @NotNull
    public BooleanSetting Method271() {
        return this.Field1602;
    }

    public void Method2277(long l) {
        this.Field1613 = l;
    }

    @Nullable
    public Thread Method2278() {
        return this.Field1609;
    }

    @NotNull
    public DoubleSetting Method2279() {
        return this.Field1599;
    }

    public void Method2280(@Nullable fa6 fa62) {
        this.Field1606 = fa62;
    }

    public void Method2281(@Nullable LinkedList linkedList) {
        this.Field1608 = linkedList;
    }

    @Nullable
    public LinkedList Method2282() {
        return this.Field1608;
    }

    @NotNull
    public BlockPos Method211() {
        return this.Field1610;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field1605;
    }

    public fa1() {
        super("auto_pilot", "AutoPilot", null);
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (!bl) {
            this.Field1598 = false;
            this.Field1606 = null;
            this.Field1608 = null;
            this.Field1607 = null;
            if (this.Field1609 != null) {
                Thread thread2 = this.Field1609;
                if (thread2 == null) {
                    Intrinsics.Method6551();
                }
                thread2.stop();
            }
        } else if (entityPlayerSP != null) {
            if (this.Field5233.player.getRidingEntity() instanceof EntityBoat) {
                fa1.Method2285(this, null, 1, null);
                Pyro.Field6182.Method8989("To set destination type " + Config.Field3937.Field3931 + "path x y z");
            } else {
                this.Field5236.Method5266(false);
                Pyro.Field6182.Method8989((Object)ChatFormatting.RED + "AutoPilot only works in boats");
            }
        }
    }

    public void Method2283(@Nullable Vec3d vec3d) {
        this.Field1607 = vec3d;
    }

    public void Method209(@NotNull BlockPos blockPos) {
        this.Field1607 = null;
        fa6 fa62 = this.Field1606;
        if (fa62 != null) {
            fa62.Method2326(null);
        }
        if (this.Field1609 != null) {
            Thread thread2 = this.Field1609;
            if (thread2 == null) {
                Intrinsics.Method6551();
            }
            thread2.stop();
        }
        if (this.Field5233.player.getRidingEntity() != null) {
            double d = ((Number)this.Field1599.Method7979()).doubleValue();
            double d2 = ((Number)this.Field1600.Method7979()).doubleValue();
            WorldClient worldClient = this.Field5233.world;
            if (worldClient == null) {
                Intrinsics.Method6551();
            }
            this.Field1606 = new fa6(blockPos, this.Field1610, d, d2, (World)worldClient, (long)0.0);
            this.Field1609 = ThreadsKt.Method9564(true, false, null, null, 0, new fa0(this), 30, null);
        }
    }

    @Nullable
    public double[] Method2284(double d) {
        if (this.Field1613 != 0L) {
            if (this.Field1613 < System.currentTimeMillis()) {
                this.Field1613 = 0L;
            }
            return null;
        }
        if (this.Field1607 != null) {
            Entity entity = this.Field5233.player.getRidingEntity();
            fdU fdU2 = fdU.Field255.Method463();
            Vec3d vec3d = this.Field1607;
            if (vec3d == null) {
                Intrinsics.Method6551();
            }
            float f = fdU2.Method422((Vec3d)vec3d).x;
            Entity entity2 = this.Field5233.player.getRidingEntity();
            if (entity2 == null) {
                Intrinsics.Method6551();
            }
            Vec3d vec3d2 = this.Field1607;
            if (vec3d2 == null) {
                Intrinsics.Method6551();
            }
            Entity entity3 = this.Field5233.player.getRidingEntity();
            if (entity3 == null) {
                Intrinsics.Method6551();
            }
            double d2 = new Vec3d(entity2.posX, vec3d2.y, entity3.posZ).distanceTo(this.Field1607);
            boolean bl = false;
            if (Math.abs(d2) < 0.1) {
                d2 = 0.0;
            }
            boolean bl2 = false;
            double d3 = Math.min(d, d2);
            Vec3d vec3d3 = this.Field1607;
            if (vec3d3 == null) {
                Intrinsics.Method6551();
            }
            Entity entity4 = entity;
            if (entity4 == null) {
                Intrinsics.Method6551();
            }
            double d4 = vec3d3.y - entity4.posY;
            return new double[]{d3 * Math.cos(Math.toRadians((double)f + (double)90.0f)), d3 * Math.sin(Math.toRadians((double)f + (double)90.0f)), d4 > 0.1 ? d4 : (d4 < -0.1 ? d4 : 0.0)};
        }
        return null;
    }

    public static void Method2285(fa1 fa12, BlockPos blockPos, int n, Object object) {
        if ((n & 1) != 0) {
            Entity entity = fa12.Field5233.player.getRidingEntity();
            if (entity == null) {
                Intrinsics.Method6551();
            }
            Entity entity2 = fa12.Field5233.player.getRidingEntity();
            if (entity2 == null) {
                Intrinsics.Method6551();
            }
            double d = entity2.posY;
            double d2 = entity.posX;
            boolean bl = false;
            double d3 = Math.floor(d);
            Entity entity3 = fa12.Field5233.player.getRidingEntity();
            if (entity3 == null) {
                Intrinsics.Method6551();
            }
            double d4 = entity3.posZ;
            double d5 = d3;
            double d6 = d2;
            blockPos = new BlockPos(d6, d5, d4);
        }
        fa12.Method209(blockPos);
    }

    @NotNull
    public BooleanSetting Method280() {
        return this.Field1604;
    }

    public void Method2286(@NotNull BlockPos blockPos) {
        this.Field1610 = blockPos;
    }
}

