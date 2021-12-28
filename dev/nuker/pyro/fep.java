/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.tileentity.TileEntity
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.fbc;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.mixin.EntityWolfAccessor;
import java.awt.Color;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class fep
extends fdZ {
    public static fbc Field518 = PyroStatic.Field6434;

    public static void Method865() {
        GL11.glEnable((int)10754);
        GL11.glPolygonOffset((float)1.0f, (float)-2000000.0f);
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
    }

    public static void Method456() {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        fep.Field313.entityRenderer.disableLightmap();
        GL11.glDisable((int)3008);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glEnable((int)2960);
        GL11.glClear((int)1024);
        GL11.glClearStencil((int)15);
        GL11.glStencilFunc((int)512, (int)1, (int)255);
        int n = 7681;
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glLineWidth((float)((Double)Field518.Method227().Method7979()).floatValue());
        int n2 = 7681;
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glPolygonMode((int)1032, (int)6913);
    }

    public static void Method457(Color color) {
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
    }

    public static void Method461() {
        GL11.glStencilFunc((int)512, (int)0, (int)255);
        int n = 7681;
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glPolygonMode((int)1032, (int)6914);
    }

    /*
     * Exception decompiling
     */
    public static void Method458(float var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 32[UNCONDITIONALDOLOOP]
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

    public static void Method737(float f) {
        fep.Field313.world.loadedEntityList.forEach(arg_0 -> fep.Method867(f, arg_0));
    }

    public static void Method462() {
        GL11.glStencilFunc((int)514, (int)1, (int)15);
        int n = 7680;
        GL11.glStencilOp((int)7680, (int)7680, (int)7680);
        GL11.glPolygonMode((int)1032, (int)6913);
    }

    public static void Method866(TileEntity tileEntity) {
        fep.Method457(Field518.Method2729(tileEntity).Method7524());
    }

    public static void Method455() {
        GL11.glPolygonOffset((float)1.0f, (float)2000000.0f);
        GL11.glDisable((int)10754);
        GL11.glDisable((int)2960);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3008);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static void Method867(float f, Entity entity) {
        try {
            f00 f002 = Field518.Method2709(entity);
            if (f002 != null && PyroRenderUtil.Field7388.isBoundingBoxInFrustum(entity.getEntityBoundingBox())) {
                GL11.glPushMatrix();
                GL11.glPushAttrib((int)1048575);
                fep.Method457(f002.Method7524());
                boolean bl = false;
                if (entity instanceof EntityWolf) {
                    bl = ((EntityWolfAccessor)entity).Method12348();
                    ((EntityWolfAccessor)entity).Method12349(false);
                }
                Field313.getRenderManager().renderEntityStatic(entity, f, true);
                if (entity instanceof EntityWolf) {
                    ((EntityWolfAccessor)entity).Method12349(bl);
                }
                GL11.glPopAttrib();
                GL11.glPopMatrix();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

