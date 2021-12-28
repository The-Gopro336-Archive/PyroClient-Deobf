/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.Class30;
import dev.nuker.pyro.Class32;
import dev.nuker.pyro.Class44;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

public class Class41 {
    public World Field4628;
    public Class30 Field4629;
    public EntityPlayerSP Field4630;
    public Minecraft Field4631 = Minecraft.getMinecraft();

    public void Method6783(Class44 class44, GameProfile gameProfile) {
        class44.Field4632 = new EntityOtherPlayerMP(this.Field4628, gameProfile);
    }

    /*
     * Exception decompiling
     */
    public void Method6784() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [19[TRYBLOCK]], but top level block is 36[UNCONDITIONALDOLOOP]
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

    public Class44 Method6785(GameProfile gameProfile) {
        if (this.Field4629 == null) {
            this.Method6784();
        }
        this.Field4629.Method6728(gameProfile);
        Class44 class44 = new Class44();
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(this.Field4628, AltManager.Field6702.Method9672(gameProfile, Class41::Method6788));
        if (class44.Field4632 == null) {
            class44.Field4632 = entityOtherPlayerMP;
        }
        return class44;
    }

    public Class44 Method6786(Alt alt) {
        GameProfile gameProfile = alt.Method1433();
        if (this.Field4629 != null) {
            this.Field4629.Method6728(gameProfile);
        }
        Class44 class44 = new Class44();
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(this.Field4628, AltManager.Field6702.Method9674(alt, arg_0 -> this.Method6783(class44, arg_0)));
        if (class44.Field4632 == null) {
            class44.Field4632 = entityOtherPlayerMP;
        }
        return class44;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void Method6787(int var1_1, int var2_2, int var3_3, EntityPlayer var4_4) {
        block30: {
            block29: {
                if (this.Field4630 == null || this.Field4630.world == null) {
                    this.Method6784();
                }
                v0 = this.Field4631;
                v1 = v0.getRenderManager();
                if (v1.world == null) ** GOTO lbl14
                v2 = this.Field4631;
                v3 = v2.getRenderManager();
                if (v3.renderViewEntity != null) break block29;
lbl14:
                // 2 sources

                v4 = this.Field4631;
                v5 = v4.getRenderManager();
                v6 = this.Field4628;
                v7 = this.Field4631.fontRenderer;
                v8 = this.Field4630;
                v9 = var4_4;
                v10 = this.Field4631.gameSettings;
                v11 = 0.0f;
                v5.cacheActiveRenderInfo(v6, v7, (Entity)v8, (Entity)v9, v10, v11);
            }
            if (this.Field4628 == null || this.Field4630 == null) break block30;
            if (var4_4 == null) break block30;
            this.Field4631.player = this.Field4630;
            v12 = v13;
            v14 = v13;
            v15 = this.Field4631;
            v12(v15);
            var5_5 = v14;
            v16 = Mouse.getX();
            v17 = var5_5;
            v18 = v17.getScaledWidth();
            var6_6 = v16 * v18 / this.Field4631.displayWidth;
            v19 = var5_5;
            v20 = v19.getScaledHeight();
            v21 = Mouse.getY();
            v22 = var5_5;
            v23 = v22.getScaledHeight();
            var7_7 = v20 - v21 * v23 / this.Field4631.displayHeight - 1;
            v24 = var1_1;
            v25 = var2_2;
            v26 = var3_3;
            v27 = var1_1 - var6_6;
            v28 = var2_2;
            v29 = var4_4.height * (float)var3_3;
            v30 = var4_4;
            v31 = v30.getEyeHeight();
            v32 = v28 - v29 * (v31 / var4_4.height) - (float)var7_7;
            v33 = var4_4;
            try {
                Class32.Method6736(v24, v25, v26, v27, v32, (EntityLivingBase)v33);
            }
            catch (Throwable var5_5) {
                var5_5.printStackTrace();
                this.Field4630 = null;
                this.Field4628 = null;
            }
        }
        this.Field4631.player = null;
        this.Field4631.world = null;
    }

    public static void Method6788(GameProfile gameProfile) {
    }

    public Class41() {
        this.Method6784();
    }
}

