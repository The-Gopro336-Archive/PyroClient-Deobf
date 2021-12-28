/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0n;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4I;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f6n;
import dev.nuker.pyro.f6o;
import dev.nuker.pyro.f6p;
import dev.nuker.pyro.f6q;
import dev.nuker.pyro.f6r;
import dev.nuker.pyro.f6s;
import dev.nuker.pyro.fdM;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fdX;
import dev.nuker.pyro.fe3;
import dev.nuker.pyro.fe4;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.feh;
import dev.nuker.pyro.few;
import dev.nuker.pyro.fex;
import dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AutoCrystal
extends Module {
    @NotNull
    public f0o<f6o> Field6087 = new f0o("breakMode", "BreakModes", null, f6o.Smart);
    @NotNull
    public IntegerSetting Field6088 = new IntegerSetting("breakTickDelay", "BreakTickDelay", null, 0, 0, 10, 0, 64, null);
    @NotNull
    public IntegerSetting Field6089 = new IntegerSetting("placeTickDelay", "PlaceTickDelay", null, 0, 0, 10, 0, 64, null);
    @NotNull
    public DoubleSetting Field6090 = new DoubleSetting("randomDelay", "RandomDelay", "Random delay in seconds", 0.0, 0.0, 1.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field6091 = new DoubleSetting("breakRange", "BreakRange", null, 6.0, 1.0, 6.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field6092 = new DoubleSetting("placeRange", "PlaceRange", null, 6.0, 1.0, 6.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field6093 = new DoubleSetting("enemyRange", "EnemyRange", null, 6.0, 0.0, 6.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field6094 = new BooleanSetting("ncp", "NCP", null, true);
    @NotNull
    public DoubleSetting Field6095 = new DoubleSetting("wallsRange", "WallsRange", null, 3.0, 0.0, 6.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field6096 = new BooleanSetting("ak47", "AK47", "Crystalaura go brr", true);
    @NotNull
    public DoubleSetting Field6097 = new DoubleSetting("minDmg", "MinDMG", null, 6.0, 0.1, 20.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field6098 = new DoubleSetting("maxSelfDMG", "MaxSelfDMG", null, 6.0, 0.1, 20.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field6099 = new BooleanSetting("noSuicide", "NoSuicide", null, false);
    @NotNull
    public BooleanSetting Field6100 = new BooleanSetting("ignoreSelfDamage", "IgnoreSelfDamage", "May boost FPS", false);
    @NotNull
    public IntegerSetting Field6101 = new IntegerSetting("facePlaceHP", "FacePlace", null, 9, 0, 20, 0, 64, null);
    @NotNull
    public BindSetting Field6102 = new BindSetting("forceFacePlace", "ForceFacePlace", "Force's you to faceplace when this key is held down", -1);
    @NotNull
    public IntegerSetting Field6103 = new IntegerSetting("lethalMultiplier", "LethalMultiplier", null, 0, 0, 10, 0, 64, null);
    @NotNull
    public BooleanSetting Field6104 = new BooleanSetting("throughWalls", "ThroughWalls", null, true);
    @NotNull
    public f0o<f6p> Field6105 = new f0o("switchMode", "SwitchMode", null, f6p.Auto);
    @NotNull
    public BooleanSetting Field6106 = new BooleanSetting("armorBreaker", "ArmorBreaker", null, false);
    @NotNull
    public DoubleSetting Field6107 = new DoubleSetting("armorBreakerPct", "Pct", "Percentage of armor to faceplace at", 20.0, 0.0, 100.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field6108 = new BooleanSetting("antiweakness", "AntiWeakness", "Uses sword to break weakness crystals", false);
    @NotNull
    public BooleanSetting Field6109 = new BooleanSetting("rotate", "Rotate", "Uses rotation system of client", true);
    @NotNull
    public BooleanSetting Field6110 = new BooleanSetting("offhandBreak", "OffhandBreak", "Swings offhand instead of mainhand", false);
    @NotNull
    public BooleanSetting Field6111 = new BooleanSetting("players", "Players", null, true);
    @NotNull
    public BooleanSetting Field6112 = new BooleanSetting("onlyInFrustram", "OnlyInFrustram", "Only targets entities in the frustram", false);
    @NotNull
    public BooleanSetting Field6113 = new BooleanSetting("armorCheck", "ArmorCheck", "Only targets entities with armor", false);
    @NotNull
    public BooleanSetting Field6114 = new BooleanSetting("pauseWhileEating", "Eating", null, true);
    @NotNull
    public BooleanSetting Field6115 = new BooleanSetting("pauseWhileXPing", "XPing", null, true);
    @NotNull
    public BooleanSetting Field6116 = new BooleanSetting("pauseWhileMining", "Mining", null, true);
    @NotNull
    public DoubleSetting Field6117 = new DoubleSetting("pauseWhenBelow", "BelowHealth", "Pauses AutoCrystal when below a certain HP", 0.0, 0.0, 20.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field6118 = new BooleanSetting("autoPlace", "AutoPlace", null, true);
    @NotNull
    public BooleanSetting Field6119 = new BooleanSetting("useNewLogic", "1.13 Placements", null, false);
    @NotNull
    public BooleanSetting Field6120 = new BooleanSetting("placeInLiquid", "PlaceInLiquid", null, false);
    @NotNull
    public BooleanSetting Field6121 = new BooleanSetting("searchOffline", "SearchOffline", null, false);
    @NotNull
    public BooleanSetting Field6122 = new BooleanSetting("strict", "Strict", null, false);
    @NotNull
    public BooleanSetting Field6123 = new BooleanSetting("fpsFix", "FPSFix", "Does optimized calculations", true);
    @NotNull
    public BooleanSetting Field6124 = new BooleanSetting("chams", "Chams", "Renders chams on the targeted entity", true);
    @NotNull
    public f0l Field6125 = new f0l("targetColor", "Target", "Tint to render the targeted entity", new f00(0.85f, 0.85f, 1.0f, 0.166666f));
    @NotNull
    public BooleanSetting Field6126 = new BooleanSetting("blockOverlay", "BlockOverlay", "Renders an overlay over blocks", true);
    @NotNull
    public BooleanSetting Field6127 = new BooleanSetting("renderDamage", "RenderDamage", "Renders damage over blocks", false);
    @NotNull
    public f0l Field6128 = new f0l("placeOverlayColor", "Overlay Color", "Tint to render underneath the block being placed", new f00(0.0f, 1.0f, 0.5f, 0.3f));
    @NotNull
    public f0l Field6129 = new f0l("placeOutlineColor", "Outline", "Tint to render underneath the block being placed", new f00(0.0f, 1.0f, 0.5f, 1.0f));
    @NotNull
    public fe8 Field6130;
    public boolean Field6131;
    public float Field6132;
    public float Field6133;
    @Nullable
    public f6n Field6134;
    @Nullable
    public EntityLivingBase Field6135;
    @NotNull
    public CopyOnWriteArrayList<Integer> Field6136;
    @NotNull
    public fe8 Field6137;
    public int Field6138;
    public boolean Field6139;
    @NotNull
    public ConcurrentLinkedQueue<fe3<Long, BlockPos>> Field6140;
    @NotNull
    public fe8 Field6141;
    public int Field6142;
    public int Field6143;
    public double Field6144;
    public double Field6145;

    @NotNull
    public BooleanSetting Method8833() {
        return this.Field6119;
    }

    @NotNull
    public BooleanSetting Method8834() {
        return this.Field6104;
    }

    public int Method5414() {
        return this.Field6143;
    }

    @NotNull
    public DoubleSetting Method228() {
        return this.Field6093;
    }

    @NotNull
    public DoubleSetting Method8835() {
        return this.Field6090;
    }

    @NotNull
    public BooleanSetting Method8836() {
        return this.Field6127;
    }

    public boolean Method8837() {
        return this.Field6131;
    }

    @NotNull
    public BooleanSetting Method8838() {
        return this.Field6124;
    }

    public void Method8839(@Nullable EntityLivingBase entityLivingBase) {
        this.Field6135 = entityLivingBase;
    }

    public void Method4965(@NotNull fe8 fe82) {
        this.Field6130 = fe82;
    }

    @NotNull
    public BooleanSetting Method2714() {
        return this.Field6126;
    }

    @NotNull
    public f0l Method8840() {
        return this.Field6128;
    }

    @f0g
    @LauncherEventHide
    public void Method187(@Nullable f4J f4J2) {
        this.Field6136.clear();
        this.Field6135 = null;
    }

    public void Method2402(boolean bl) {
        this.Field6139 = bl;
    }

    @NotNull
    public BindSetting Method8841() {
        return this.Field6102;
    }

    @NotNull
    public BooleanSetting Method281() {
        return this.Field6109;
    }

    public int Method8842() {
        return this.Field6138;
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        block6: {
            block5: {
                if (!((Boolean)this.Field5236.Method5264()).booleanValue() || f4u2.Method7947()) break block5;
                if (f4u2.Method5619() == f41.Pre) break block6;
            }
            return;
        }
        if (!((Boolean)this.Field6109.Method7979()).booleanValue()) {
            return;
        }
        if (this.Field6131) {
            f4u2.Method7948();
            f4u2.Method5647(this.Field6132);
            f4u2.Method5653(this.Field6133);
        }
    }

    @NotNull
    public BooleanSetting Method8843() {
        return this.Field6112;
    }

    @Nullable
    public f6n Method8844() {
        return this.Field6134;
    }

    @NotNull
    public f0l Method8845() {
        return this.Field6125;
    }

    @NotNull
    public BooleanSetting Method8846() {
        return this.Field6099;
    }

    public void Method540(float f) {
        this.Field6132 = f;
    }

    @NotNull
    public fe8 Method8847() {
        return this.Field6141;
    }

    public double Method8848() {
        return this.Field6144;
    }

    @NotNull
    public IntegerSetting Method8849() {
        return this.Field6103;
    }

    @f0g
    @LauncherEventHide
    public void Method277(@NotNull f43 f432) {
        block29: {
            block28: {
                if (this.Field5233.player == null) {
                    return;
                }
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.Field4347 = System.currentTimeMillis();
                this.Field6140.removeIf(new f6s(longRef));
                this.Field6142 += -1;
                this.Field6143 += -1;
                if (!((Boolean)this.Field6121.Method7979()).booleanValue() && !((Boolean)this.Field5236.Method5264()).booleanValue()) {
                    return;
                }
                if (!this.Field6141.Method491(this.Field6144)) {
                    return;
                }
                if (((Boolean)this.Field5236.Method5264()).booleanValue() && this.Field6130.Method491(1000.0) && this.Field6131) {
                    this.Field6131 = false;
                }
                if (this.Field6137.Method491(500.0) && !this.Field6136.isEmpty()) {
                    this.Field6136.clear();
                }
                if (!((Boolean)this.Field5236.Method5264()).booleanValue() || this.Method4876()) break block28;
                if (this.Method2689()) break block29;
            }
            if (((Boolean)this.Field6118.Method7979()).booleanValue()) {
                this.Method8858();
                if (!this.Method4876()) {
                    if (((Boolean)this.Field5236.Method5264()).booleanValue() && this.Field6134 != null && this.Field6143 <= 0) {
                        Object object;
                        if (!this.Method8872()) {
                            return;
                        }
                        EnumFacing enumFacing = null;
                        boolean bl = Intrinsics.Method6572((Object)this.Field5233.player.getHeldItemOffhand().getItem(), (Object)Items.END_CRYSTAL);
                        f6n f6n2 = this.Field6134;
                        if (f6n2 == null) {
                            Intrinsics.Method6551();
                        }
                        if (f6n2.Method5106() != null) {
                            f6n f6n3 = this.Field6134;
                            if (f6n3 == null) {
                                Intrinsics.Method6551();
                            }
                            feh feh2 = f6n3.Method5106();
                            if (feh2 == null) {
                                Intrinsics.Method6551();
                            }
                            object = feh2.Method786().Method891();
                            this.Field6133 = ((Rotation)object).Method6942();
                            this.Field6132 = ((Rotation)object).Method6936();
                            this.Field6131 = true;
                            f6n f6n4 = this.Field6134;
                            if (f6n4 == null) {
                                Intrinsics.Method6551();
                            }
                            feh feh3 = f6n4.Method5106();
                            if (feh3 == null) {
                                Intrinsics.Method6551();
                            }
                            enumFacing = feh3.Method783();
                        } else {
                            enumFacing = few.Method848(this.Field6134, true);
                            object = few.Method835().Method850(this.Field6134, enumFacing);
                            this.Field6133 = (float)object[0];
                            this.Field6132 = (float)object[1];
                            this.Field6131 = true;
                        }
                        float f = this.Field5233.player.rotationPitch;
                        float f2 = this.Field5233.player.rotationYaw;
                        float f3 = this.Field5233.getRenderPartialTicks();
                        this.Field5233.player.rotationPitch = this.Field6132;
                        this.Field5233.player.rotationYaw = this.Field6133;
                        RayTraceResult rayTraceResult = this.Field5233.player.rayTrace((double)this.Field5233.playerController.getBlockReachDistance(), f3);
                        float f4 = 0.0f;
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        if (rayTraceResult != null) {
                            f6n f6n5 = this.Field6134;
                            if (f6n5 == null) {
                                Intrinsics.Method6551();
                            }
                            f4 = (float)(rayTraceResult.hitVec.x - (double)f6n5.getX());
                            f6n f6n6 = this.Field6134;
                            if (f6n6 == null) {
                                Intrinsics.Method6551();
                            }
                            f5 = (float)(rayTraceResult.hitVec.y - (double)f6n6.getY());
                            f6n f6n7 = this.Field6134;
                            if (f6n7 == null) {
                                Intrinsics.Method6551();
                            }
                            f6 = (float)(rayTraceResult.hitVec.z - (double)f6n7.getZ());
                        }
                        this.Field5233.player.rotationPitch = f;
                        this.Field5233.player.rotationYaw = f2;
                        NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
                        if (netHandlerPlayClient == null) {
                            Intrinsics.Method6551();
                        }
                        netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock((BlockPos)this.Field6134, enumFacing, bl ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, f4, f5, f6));
                        NetHandlerPlayClient netHandlerPlayClient2 = this.Field5233.getConnection();
                        if (netHandlerPlayClient2 == null) {
                            Intrinsics.Method6551();
                        }
                        netHandlerPlayClient2.sendPacket((Packet)new CPacketAnimation(bl ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
                        this.Field6143 = ((Number)this.Field6089.Method7979()).intValue();
                        this.Field6144 = RangesKt.Method4268(((Number)this.Field6090.Method7979()).doubleValue() * (double)1000, Math.random() * (double)1000);
                        if (this.Field6138 != -1 && (f6p)((Object)this.Field6105.Method7979()) == f6p.Packet) {
                            if (this.Field6138 != this.Field5233.player.inventory.currentItem) {
                                NetHandlerPlayClient netHandlerPlayClient3 = this.Field5233.getConnection();
                                if (netHandlerPlayClient3 == null) {
                                    Intrinsics.Method6551();
                                }
                                netHandlerPlayClient3.sendPacket((Packet)new CPacketHeldItemChange(this.Field5233.player.inventory.currentItem));
                            }
                        }
                    }
                }
            }
        }
    }

    @NotNull
    public DoubleSetting Method8850() {
        return this.Field6092;
    }

    @NotNull
    public BooleanSetting Method283() {
        return this.Field6120;
    }

    @NotNull
    public IntegerSetting Method8851() {
        return this.Field6101;
    }

    @NotNull
    public DoubleSetting Method8852() {
        return this.Field6117;
    }

    public void Method551(int n) {
        this.Field6142 = n;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        this.Field6136.clear();
        this.Field6140.clear();
        this.Field6142 = 0;
        this.Field6143 = 0;
    }

    public void Method8853(@NotNull ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.Field6140 = concurrentLinkedQueue;
    }

    public void Method2401(double d) {
        this.Field6145 = d;
    }

    @NotNull
    public BooleanSetting Method8854() {
        return this.Field6096;
    }

    public int Method8855() {
        return this.Field6142;
    }

    @NotNull
    public DoubleSetting Method223() {
        return this.Field6097;
    }

    @NotNull
    public fe8 Method8856() {
        return this.Field6130;
    }

    @NotNull
    public BooleanSetting Method273() {
        return this.Field6122;
    }

    @NotNull
    public BooleanSetting Method8857() {
        return this.Field6115;
    }

    /*
     * Exception decompiling
     */
    public void Method8858() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 15[UNCONDITIONALDOLOOP]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    @NotNull
    public ConcurrentLinkedQueue Method8859() {
        return this.Field6140;
    }

    public static boolean Method8860(AutoCrystal autoCrystal, EntityEnderCrystal entityEnderCrystal, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return autoCrystal.Method8874(entityEnderCrystal, bl);
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field6094;
    }

    public AutoCrystal() {
        super("autocrystal", "AutoCrystal", "Places and breaks Ender Crystals");
        this.Method7264(this.Field6087);
        this.Method7264(new f0t(new f0n("timers", "Timers", "Right click to view or modify the timers"), this.Field6088, this.Field6089, this.Field6090));
        this.Method7264(new f0t(new f0n("ranges", "Ranges", "Right click to view or modify the range settings"), this.Field6091, this.Field6092, this.Field6093, this.Field6094, this.Field6095));
        this.Method7264(new f0t(new f0n("general", "General", "Right click to view or modify the general settings"), this.Field6096, this.Field6108, this.Field6097, this.Field6098, this.Field6099, this.Field6100, this.Field6101, this.Field6102, this.Field6103, this.Field6104, new f0t(this.Field6106, this.Field6107), this.Field6105, this.Field6123, this.Field6109, this.Field6110));
        this.Method7264(new f0t(new f0n("targets", "Targets", "Right click to view or modify the target settings"), this.Field6111, this.Field6112, this.Field6113));
        this.Method7264(new f0t(new f0n("pauseWhen", "PauseWhen", "Right click to view or modify the pausing settings"), this.Field6117, this.Field6114, this.Field6116, this.Field6115));
        this.Method7264(new f0t(new f0n("placeOptions", "PlaceOptions", "Right click to view or modify the place settings"), this.Field6118, this.Field6119, this.Field6120, this.Field6121, this.Field6122));
        this.Method7264(new f0t(new f0n("render", "Render", "Right click to view or modify the render settings"), new f0t(this.Field6124, this.Field6125), new f0t(this.Field6126, this.Field6127, this.Field6128, this.Field6129)));
        Pyro.Method8978().Method7915(this);
        this.Field6130 = new fe8();
        this.Field6132 = -1337.0f;
        this.Field6133 = -1337.0f;
        this.Field6136 = new CopyOnWriteArrayList();
        this.Field6137 = new fe8();
        this.Field6138 = -1;
        this.Field6140 = new ConcurrentLinkedQueue();
        this.Field6141 = new fe8();
    }

    @NotNull
    public f0o Method8861() {
        return this.Field6105;
    }

    @NotNull
    public f0o Method4928() {
        return this.Field6087;
    }

    @NotNull
    public fe8 Method8862() {
        return this.Field6137;
    }

    @NotNull
    public BooleanSetting Method8863() {
        return this.Field6121;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean Method2689() {
        boolean bl;
        Entity entity;
        block16: {
            block17: {
                if ((f6o)((Object)this.Field6087.Method7979()) == f6o.Smart && this.Field6135 == null) {
                    return false;
                }
                Iterator iterator2 = this.Field5233.world.loadedEntityList.iterator();
                do {
                    if (!iterator2.hasNext()) return false;
                } while (!((entity = (Entity)iterator2.next()) instanceof EntityEnderCrystal) || entity.isDead || !AutoCrystal.Method8860(this, (EntityEnderCrystal)entity, false, 2, null) || !fdN.Method348(entity));
                boolean bl2 = few.Method835().Method852(entity, ((Number)this.Field6091.Method7979()).doubleValue());
                fex fex2 = null;
                if (!bl2 && !((Boolean)this.Field6109.Method7979()).booleanValue()) {
                    bl2 = true;
                }
                if (!bl2) {
                    fex2 = few.Method835().Method843(((EntityEnderCrystal)entity).getEntityBoundingBox(), false, false, false, (Boolean)this.Field6104.Method7979());
                }
                if (fex2 == null) {
                    if (!bl2) return true;
                }
                if (!bl2) {
                    if (fex2 == null) return true;
                    this.Field6133 = fex2.Method891().Method6942();
                    this.Field6132 = fex2.Method891().Method6936();
                    this.Field6131 = true;
                    this.Field6130.Method490();
                    return true;
                }
                bl = true;
                if (!((Boolean)this.Field6108.Method7979()).booleanValue()) break block16;
                double d = this.Field5233.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
                ItemStack itemStack = this.Field5233.player.getHeldItemMainhand();
                if (itemStack.getItem() instanceof ItemSword || itemStack.getItem() instanceof ItemTool) {
                    d = 3.0;
                } else if (this.Field5233.player.isPotionActive(MobEffects.WEAKNESS)) {
                    d = 0.0;
                }
                PotionEffect potionEffect = this.Field5233.player.getActivePotionEffect(MobEffects.STRENGTH);
                if (potionEffect != null && (float)potionEffect.getAmplifier() >= 1.0f) {
                    d = 1.0;
                }
                float f = EnchantmentHelper.getModifierForCreature((ItemStack)this.Field5233.player.getHeldItemMainhand(), (EnumCreatureAttribute)EnumCreatureAttribute.UNDEFINED);
                float f2 = this.Field5233.player.getCooledAttackStrength(0.5f);
                boolean bl3 = bl = (d *= (double)(0.2f + f2 * f2 * 0.8f)) > (double)0.0f || (f *= f2) > 0.0f;
                if (bl) break block16;
                if (this.Field5233.player.getHeldItemMainhand().isEmpty()) break block17;
                if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemSword) break block16;
                if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemTool) break block16;
            }
            int n = 8;
            for (int i = 0; i <= n; ++i) {
                ItemStack itemStack;
                this.Field5233.player.inventory.getStackInSlot(i);
                if (itemStack.isEmpty() || !(itemStack.getItem() instanceof ItemTool) && !(itemStack.getItem() instanceof ItemSword)) continue;
                this.Field5233.player.inventory.currentItem = i;
                this.Field5233.playerController.updateController();
                break;
            }
        }
        if (this.Field6142 > 0) return true;
        if (!bl) return true;
        this.Field6130.Method490();
        this.Field5233.playerController.attackEntity((EntityPlayer)this.Field5233.player, entity);
        if (((Boolean)this.Field6110.Method7979()).booleanValue()) {
            this.Field5233.player.swingArm(EnumHand.OFF_HAND);
        } else {
            this.Field5233.player.swingArm(EnumHand.MAIN_HAND);
        }
        if (((Boolean)this.Field6096.Method7979()).booleanValue()) {
            this.Field6136.add(((EntityEnderCrystal)entity).getEntityId());
        }
        this.Field6137.Method490();
        this.Field6142 = ((Number)this.Field6088.Method7979()).intValue();
        this.Field6144 = RangesKt.Method4268(((Number)this.Field6090.Method7979()).doubleValue() * (double)1000, Math.random() * (double)1000);
        return true;
    }

    public boolean Method8864(EntityEnderCrystal entityEnderCrystal) {
        Iterator<fe3<Long, BlockPos>> iterator2 = this.Field6140.iterator();
        while (iterator2.hasNext()) {
            fe3<Long, BlockPos> fe32 = iterator2.next();
            Object object = fe32.Method465();
            Object object2 = fe32.Method465();
            Object object3 = fe32.Method465();
            if (!(entityEnderCrystal.getDistance((double)((BlockPos)object).getX() + 0.5, (double)((BlockPos)object2).getY() + 0.5, (double)((BlockPos)object3).getZ() + 0.5) <= (double)3)) continue;
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public boolean Method8865(@NotNull BlockPos var1_1, @Nullable IBlockState var2_2, boolean var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [16[DOLOOP]], but top level block is 14[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    @NotNull
    public ArrayList Method8866() {
        ArrayList<f6n> arrayList;
        block9: {
            arrayList = new ArrayList<f6n>();
            BlockPos blockPos = new BlockPos(this.Field5233.player.getPositionVector());
            int n = (int)((float)blockPos.getY() + this.Field5233.player.getEyeHeight() - (float)10);
            int n2 = (int)((float)blockPos.getY() + this.Field5233.player.getEyeHeight() + (float)10);
            int n3 = blockPos.getX() - 10;
            int n4 = blockPos.getX() + 10;
            if (n3 > n4) break block9;
            while (true) {
                block10: {
                    int n5;
                    int n6;
                    if ((n6 = n) > (n5 = n2)) break block10;
                    while (true) {
                        block11: {
                            int n7;
                            int n8;
                            if ((n8 = blockPos.getZ() - 10) > (n7 = blockPos.getZ() + 10)) break block11;
                            while (true) {
                                block12: {
                                    BlockPos blockPos2;
                                    block14: {
                                        boolean bl;
                                        float f;
                                        feh feh2;
                                        block15: {
                                            block13: {
                                                float f2;
                                                IBlockState iBlockState;
                                                if (!this.Method4842(blockPos2 = new BlockPos(n3, n6, n8)) || (iBlockState = feg.Method701(blockPos2)).getBlock() != Blocks.OBSIDIAN && iBlockState.getBlock() != Blocks.BEDROCK || !this.Method8865(blockPos2, iBlockState, true)) break block12;
                                                float f3 = f2 = (Boolean)this.Field6100.Method7979() != false ? 0.0f : fdM.Method339(blockPos2, (EntityLivingBase)this.Field5233.player);
                                                if ((double)f2 > ((Number)this.Field6098.Method7979()).doubleValue()) break block12;
                                                if (!((Boolean)this.Field6099.Method7979()).booleanValue()) break block13;
                                                if (f2 + 1.0f >= this.Field5233.player.getHealth() + this.Field5233.player.getAbsorptionAmount()) break block12;
                                            }
                                            if (!((Boolean)this.Field6122.Method7979()).booleanValue()) break block14;
                                            boolean bl2 = false;
                                            feh2 = null;
                                            Vec3d vec3d = new Vec3d(this.Field5233.player.posX, this.Field5233.player.getEntityBoundingBox().minY + (double)this.Field5233.player.getEyeHeight(), this.Field5233.player.posZ);
                                            double[] arrd = new double[]{0.05, 0.95};
                                            double[] arrd2 = new double[]{0.05, 0.95};
                                            double[] arrd3 = new double[]{0.05, 0.95};
                                            for (double d : arrd) {
                                                block4: for (double d2 : arrd2) {
                                                    for (double d3 : arrd3) {
                                                        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos2).addVector(d, d2, d3);
                                                        double d4 = vec3d.distanceTo(vec3d2);
                                                        double d5 = vec3d2.x - vec3d.x;
                                                        double d6 = vec3d2.y - vec3d.y;
                                                        double d7 = vec3d2.z - vec3d.z;
                                                        float f4 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
                                                        Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(MathHelper.atan2((double)d7, (double)d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(MathHelper.atan2((double)d6, (double)f4))))));
                                                        Vec3d vec3d3 = few.Method835().Method834(rotation);
                                                        Vec3d vec3d4 = vec3d.addVector(vec3d3.x * d4, vec3d3.y * d4, vec3d3.z * d4);
                                                        RayTraceResult rayTraceResult = this.Field5233.world.rayTraceBlocks(vec3d, vec3d4, false, false, true);
                                                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object)blockPos2)) continue;
                                                        bl2 = true;
                                                        feh2 = new feh(blockPos2, rayTraceResult.sideHit, rayTraceResult.hitVec.subtract((double)blockPos2.getX(), (double)blockPos2.getY(), (double)blockPos2.getZ()), new fex(vec3d2, rotation, rayTraceResult.sideHit));
                                                        continue block4;
                                                    }
                                                }
                                            }
                                            f = 36.0f;
                                            bl = false;
                                            if (bl2) break block15;
                                            f = (float)(((Number)this.Field6095.Method7979()).doubleValue() * ((Number)this.Field6095.Method7979()).doubleValue());
                                            if (!((Boolean)this.Field6104.Method7979()).booleanValue()) break block12;
                                            bl = true;
                                        }
                                        if (!(this.Field5233.player.getDistanceSq(blockPos2) > (double)f)) {
                                            arrayList.add(new f6n(blockPos2, feh2, bl));
                                        }
                                        break block12;
                                    }
                                    arrayList.add(new f6n(blockPos2, null, false));
                                }
                                if (n8 == n7) break;
                                ++n8;
                            }
                        }
                        if (n6 == n5) break;
                        ++n6;
                    }
                }
                if (n3 == n4) break;
                ++n3;
            }
        }
        return arrayList;
    }

    public void Method541(int n) {
        this.Field6138 = n;
    }

    @NotNull
    public BooleanSetting Method8867() {
        return this.Field6123;
    }

    @NotNull
    public f0l Method2368() {
        return this.Field6129;
    }

    @NotNull
    public BooleanSetting Method8868() {
        return this.Field6116;
    }

    @NotNull
    public DoubleSetting Method8869() {
        return this.Field6107;
    }

    @NotNull
    public CopyOnWriteArrayList Method8870() {
        return this.Field6136;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method2425(Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        if (!((EntityLivingBase)entity).isEntityAlive()) {
            return false;
        }
        if (((Boolean)this.Field6112.Method7979()).booleanValue() && !PyroRenderUtil.Field7388.isBoundingBoxInFrustum(((EntityLivingBase)entity).getEntityBoundingBox())) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            if (((Boolean)this.Field6113.Method7979()).booleanValue()) {
                boolean bl = false;
                Iterator iterator2 = ((EntityPlayer)entity).inventory.armorInventory.iterator();
                while (iterator2.hasNext()) {
                    ItemStack itemStack = (ItemStack)iterator2.next();
                    if (itemStack.isEmpty()) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    return false;
                }
            }
            if ((Boolean)this.Field6111.Method7979() == false) return false;
            if (!fe4.Field250.Method387((EntityPlayer)entity)) return false;
            return true;
        }
        if (!(this.Field5233.player.getDistanceSq(entity) <= 300.0)) return false;
        return true;
    }

    @NotNull
    public BooleanSetting Method8871() {
        return this.Field6100;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        if (this.Field5233.player != null && this.Field6134 != null) {
            if (((Boolean)this.Field6126.Method7979()).booleanValue()) {
                fe5.Field252.Method408(7);
                f6n f6n2 = this.Field6134;
                if (f6n2 == null) {
                    Intrinsics.Method6551();
                }
                fe5.Field252.Method410(f6n2, ((f00)this.Field6128.Method7979()).Method7515(), 63);
                fe5.Field252.Method405();
                PyroRenderUtil.Method12305(this.Field6134, ((f00)this.Field6129.Method7979()).Method7515(), 1.5f, false);
                if (this.Field6135 != null) {
                    if (((Boolean)this.Field6127.Method7979()).booleanValue()) {
                        GlStateManager.pushMatrix();
                        EntityPlayer entityPlayer = this.Field5233.getRenderViewEntity() instanceof EntityPlayer ? (EntityPlayer)this.Field5233.getRenderViewEntity() : (EntityPlayer)this.Field5233.player;
                        f6n f6n3 = this.Field6134;
                        if (f6n3 == null) {
                            Intrinsics.Method6551();
                        }
                        float f2 = (float)f6n3.getX() + 0.5f;
                        f6n f6n4 = this.Field6134;
                        if (f6n4 == null) {
                            Intrinsics.Method6551();
                        }
                        float f3 = (float)f6n4.getY() + 0.5f;
                        f6n f6n5 = this.Field6134;
                        if (f6n5 == null) {
                            Intrinsics.Method6551();
                        }
                        PyroRenderUtil.Method12315(f2, f3, (float)f6n5.getZ() + 0.5f, (Entity)entityPlayer, 1.0f);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
                        String string = "%.1f";
                        Object[] arrobject = new Object[]{this.Field6145};
                        boolean bl = false;
                        String string2 = String.format(string, Arrays.copyOf(arrobject, arrobject.length));
                        GlStateManager.disableDepth();
                        GlStateManager.translate((double)(-((double)PyroRenderUtil.Method12314(string2) / 2.0)), (double)0.0, (double)0.0);
                        PyroRenderUtil.Method12313(string2, 0.0f, 0.0f, -1);
                        GlStateManager.popMatrix();
                    }
                }
            }
        }
    }

    public boolean Method8872() {
        if (Intrinsics.Method6572((Object)this.Field5233.player.getHeldItemMainhand().getItem(), (Object)Items.END_CRYSTAL) ^ true) {
            if (Intrinsics.Method6572((Object)this.Field5233.player.getHeldItemOffhand().getItem(), (Object)Items.END_CRYSTAL) ^ true) {
                if ((f6p)((Object)this.Field6105.Method7979()) != f6p.None) {
                    int n;
                    this.Field6138 = n = fdX.Field311.Method497(Items.END_CRYSTAL);
                    if (n != -1) {
                        if ((f6p)((Object)this.Field6105.Method7979()) == f6p.Auto) {
                            this.Field5233.player.inventory.currentItem = n;
                            this.Field5233.playerController.updateController();
                        } else if ((f6p)((Object)this.Field6105.Method7979()) == f6p.Packet) {
                            NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
                            if (netHandlerPlayClient == null) {
                                Intrinsics.Method6551();
                            }
                            netHandlerPlayClient.sendPacket((Packet)new CPacketHeldItemChange(n));
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void Method544(float f) {
        this.Field6133 = f;
    }

    public void Method557(boolean bl) {
        this.Field6131 = bl;
    }

    public boolean Method8873(@NotNull BlockPos blockPos, @Nullable IBlockState iBlockState) {
        return this.Method8865(blockPos, iBlockState, false);
    }

    @NotNull
    public IntegerSetting Method2749() {
        return this.Field6089;
    }

    public void Method5285(@Nullable f6n f6n2) {
        this.Field6134 = f6n2;
    }

    public boolean Method8874(EntityEnderCrystal entityEnderCrystal, boolean bl) {
        if (!bl) {
            if (this.Field6136.contains(entityEnderCrystal.getEntityId())) {
                return false;
            }
        }
        double d = this.Field5233.player.getDistanceSq((Entity)entityEnderCrystal);
        switch (f6q.Field3310[((f6o)((Object)this.Field6087.Method7979())).ordinal()]) {
            case 1: {
                if (this.Field6135 == null) {
                    return false;
                }
                float f = fdM.Method341(entityEnderCrystal, (EntityLivingBase)this.Field5233.player);
                float f2 = fdM.Method341(entityEnderCrystal, this.Field6135);
                if ((double)f >= ((Number)this.Field6098.Method7979()).doubleValue() + 1.0) {
                    return false;
                }
                if (!(!this.Field6139 ? (double)f2 <= ((Number)this.Field6097.Method7979()).doubleValue() - 1.0 : (double)f2 < 1.0)) break;
                return false;
            }
            case 2: {
                if (this.Field6135 == null) {
                    return false;
                }
                float f = fdM.Method341(entityEnderCrystal, (EntityLivingBase)this.Field5233.player);
                float f3 = fdM.Method341(entityEnderCrystal, this.Field6135);
                if ((double)f >= ((Number)this.Field6098.Method7979()).doubleValue() + 1.0) {
                    return false;
                }
                if (!((double)f3 < 1.0)) break;
                return false;
            }
            case 3: {
                if (this.Method8864(entityEnderCrystal)) break;
                return false;
            }
        }
        return ((Number)this.Field6091.Method7979()).doubleValue() * ((Number)this.Field6091.Method7979()).doubleValue() >= d;
    }

    public float Method8875() {
        return this.Field6133;
    }

    @NotNull
    public BooleanSetting Method8876() {
        return this.Field6106;
    }

    @NotNull
    public BooleanSetting Method8877() {
        return this.Field6111;
    }

    public double Method8878() {
        return this.Field6145;
    }

    @NotNull
    public BooleanSetting Method8879() {
        return this.Field6108;
    }

    public void Method5011(@NotNull fe8 fe82) {
        this.Field6141 = fe82;
    }

    public boolean Method4876() {
        if (((Boolean)this.Field6114.Method7979()).booleanValue()) {
            if (this.Field5233.player.isHandActive()) {
                if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemFood) {
                    return true;
                }
            }
        }
        if (((Boolean)this.Field6116.Method7979()).booleanValue()) {
            if (this.Field5233.playerController.getIsHittingBlock()) {
                if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
                    return true;
                }
            }
        }
        if (((Boolean)this.Field6115.Method7979()).booleanValue()) {
            if (this.Field5233.gameSettings.keyBindRight.isKeyDown()) {
                if (Intrinsics.Method6572((Object)this.Field5233.player.getHeldItemMainhand().getItem(), (Object)Items.EXPERIENCE_BOTTLE)) {
                    return true;
                }
            }
        }
        if (((Boolean)PyroStatic.Field6408.Field5236.Method5264()).booleanValue()) {
            if (!PyroStatic.Field6408.Method4852((Entity)this.Field5233.player)) {
                return true;
            }
        }
        if (((Boolean)PyroStatic.Field6444.Field5236.Method5264()).booleanValue() && PyroStatic.Field6444.Field3340) {
            return true;
        }
        if (((Boolean)PyroStatic.Field6506.Field5236.Method5264()).booleanValue()) {
            if (((Boolean)PyroStatic.Field6506.Field3067.Method7979()).booleanValue()) {
                if (PyroStatic.Field6408.Method4844((Entity)this.Field5233.player) && !PyroStatic.Field6506.Method4852((Entity)this.Field5233.player)) {
                    return true;
                }
            }
            if (!((Boolean)PyroStatic.Field6506.Field3067.Method7979()).booleanValue()) {
                return true;
            }
        }
        if (((Number)this.Field6117.Method7979()).doubleValue() > 0.0) {
            EntityPlayerSP entityPlayerSP = this.Field5233.player;
            EntityPlayerSP entityPlayerSP2 = this.Field5233.player;
            if ((double)(entityPlayerSP.getHealth() + entityPlayerSP2.getAbsorptionAmount()) < ((Number)this.Field6117.Method7979()).doubleValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean Method8880() {
        return this.Field6139;
    }

    public float Method8881() {
        return this.Field6132;
    }

    @NotNull
    public IntegerSetting Method8882() {
        return this.Field6088;
    }

    @NotNull
    public BooleanSetting Method8883() {
        return this.Field6113;
    }

    public void Method316(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field6136 = copyOnWriteArrayList;
    }

    public boolean Method4842(BlockPos blockPos) {
        double d = this.Field5233.player.posX - ((double)blockPos.getX() + 0.5);
        double d2 = this.Field5233.player.posY - ((double)blockPos.getY() + 0.5) + 1.5;
        double d3 = this.Field5233.player.posZ - ((double)blockPos.getZ() + 0.5);
        double d4 = d * d + d2 * d2 + d3 * d3;
        if (d4 > 36.0) {
            return false;
        }
        if (d4 > ((Number)this.Field6092.Method7979()).doubleValue() * ((Number)this.Field6092.Method7979()).doubleValue()) {
            return false;
        }
        if (((Boolean)this.Field6094.Method7979()).booleanValue()) {
            boolean bl = this.Field5233.playerController.gameIsSurvivalOrAdventure();
            double d5 = bl ? 27.0 : 31.0;
            if (d4 >= d5) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public DoubleSetting Method8884() {
        return this.Field6095;
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field6118;
    }

    @NotNull
    public DoubleSetting Method2279() {
        return this.Field6091;
    }

    @NotNull
    public DoubleSetting Method8885() {
        return this.Field6098;
    }

    @f0g
    @LauncherEventHide
    public void Method5022(@NotNull f4I f4I2) {
        if (f4I2.Method5702() instanceof EntityEnderCrystal && this.Field6136.contains(f4I2.Method5702().getEntityId())) {
            this.Field6136.remove((Object)f4I2.Method5702().getEntityId());
        }
    }

    @NotNull
    public BooleanSetting Method8886() {
        return this.Field6110;
    }

    @Nullable
    public EntityLivingBase Method8887() {
        return this.Field6135;
    }

    public void Method2415(double d) {
        this.Field6144 = d;
    }

    @NotNull
    public BooleanSetting Method2723() {
        return this.Field6114;
    }

    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        if (f492.Method5619() == f41.Pre && f492.Method5784() instanceof CPacketPlayerTryUseItemOnBlock) {
            Packet packet = f492.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock");
            }
            CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock = (CPacketPlayerTryUseItemOnBlock)packet;
            ItemStack itemStack = this.Field5233.player.getHeldItem(cPacketPlayerTryUseItemOnBlock.getHand());
            if (Intrinsics.Method6572((Object)itemStack.getItem(), (Object)Items.END_CRYSTAL)) {
                this.Field6140.removeIf(new f6r(cPacketPlayerTryUseItemOnBlock));
                this.Field6140.add(new fe3(System.currentTimeMillis() + (long)500, (Object)cPacketPlayerTryUseItemOnBlock.getPos()));
                if (cPacketPlayerTryUseItemOnBlock.getPos().getY() >= this.Field5233.world.getHeight() - 1 && cPacketPlayerTryUseItemOnBlock.getDirection() == EnumFacing.UP) {
                    CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock2 = cPacketPlayerTryUseItemOnBlock;
                    if (cPacketPlayerTryUseItemOnBlock2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor");
                    }
                    ((CPacketPlayerTryUseItemOnBlockAccessor)cPacketPlayerTryUseItemOnBlock2).Method6416(EnumFacing.DOWN);
                }
            }
        }
    }

    public void Method4977(int n) {
        this.Field6143 = n;
    }

    public void Method5003(@NotNull fe8 fe82) {
        this.Field6137 = fe82;
    }
}

