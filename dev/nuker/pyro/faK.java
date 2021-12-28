/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.DestroyBlockProgress
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0n;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.mixin.RenderGlobalAccessor;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class faK
extends Module {
    public f0l Field1664 = new f0l("color", "EnemyColor", null, new f00(0.1f, 1.0f, 0.5f, 0.5f));
    public f0l Field1665 = new f0l("BarColor", "BarColor", null, new f00(0.0f, 1.0f, 0.5f, 1.0f));
    public BooleanSetting Field1666 = new BooleanSetting("renderPct", "Pct", "Renders the percentage of damage broken on the block", true);
    public BooleanSetting Field1667 = new BooleanSetting("renderBreakerName", "Breaker", "Renders the breaker name", true);
    public BooleanSetting Field1668 = new BooleanSetting("renderBar", "Bar", "Renders the break percentage bar", true);
    public f0t Field1669 = new f0t(new f0n("render", "Render", "Edit the render settings"), this.Field1666, this.Field1667, this.Field1668);

    public faK() {
        super("breakHighlight", "BreakHighlight", "Renders extra things on blocks that enemies are mining", true);
        this.Method7264(this.Field1669);
        this.Method7264(this.Field1664);
        this.Method7264(this.Field1665);
    }

    public void Method2375(Integer n, DestroyBlockProgress destroyBlockProgress) {
        if (n.intValue() != this.Field5233.player.getEntityId()) {
            float f;
            Object object;
            fe5.Field252.Method408(7);
            fe5.Field252.Method410(destroyBlockProgress.getPosition(), ((f00)this.Field1664.Method7979()).Method7515(), 63);
            fe5.Field252.Method405();
            GlStateManager.pushMatrix();
            EntityPlayerSP entityPlayerSP = this.Field5233.getRenderViewEntity() instanceof EntityPlayer ? (EntityPlayer)this.Field5233.getRenderViewEntity() : this.Field5233.player;
            PyroRenderUtil.Method12315((float)destroyBlockProgress.getPosition().getX() + 0.5f, (float)destroyBlockProgress.getPosition().getY() + 0.5f, (float)destroyBlockProgress.getPosition().getZ() + 0.5f, (Entity)entityPlayerSP, 1.0f);
            float f2 = (float)destroyBlockProgress.getPartialBlockDamage() * 10.0f;
            GlStateManager.disableDepth();
            if (((Boolean)this.Field1666.Method7979()).booleanValue()) {
                object = String.format("%.1f", Float.valueOf(f2)) + "%";
                GlStateManager.pushMatrix();
                f = PyroRenderUtil.Method12314((String)object);
                GlStateManager.translate((double)(-((double)f / 2.0)), (double)0.0, (double)0.0);
                PyroRenderUtil.Method12313((String)object, 0.0f, 0.0f, -1);
                GlStateManager.popMatrix();
            }
            if (((Boolean)this.Field1667.Method7979()).booleanValue()) {
                object = this.Field5233.world.getEntityByID(n.intValue());
                if (object != null) {
                    GlStateManager.pushMatrix();
                    f = PyroRenderUtil.Method12314(object.getName());
                    GlStateManager.translate((double)(-((double)f / 2.0)), (double)PyroRenderUtil.Method740(), (double)0.0);
                    PyroRenderUtil.Method12313(object.getName(), 0.0f, 0.0f, FriendManager.Field2145.Method8958(object.getName()) ? 65527 : -1);
                    GlStateManager.popMatrix();
                }
            }
            if (((Boolean)this.Field1668.Method7979()).booleanValue()) {
                GlStateManager.pushMatrix();
                float f3 = PyroRenderUtil.Method12314("wheelchair");
                GlStateManager.translate((double)(-((double)f3 / 2.0)), (double)(-PyroRenderUtil.Method740() - 5.0f), (double)0.0);
                PyroRenderUtil.Method12316(0.0f, 0.0f, f3, PyroRenderUtil.Method4908(), -1879048192);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                GlStateManager.shadeModel((int)7425);
                GlStateManager.enableBlend();
                GlStateManager.disableTexture2D();
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
                f3 = (float)((int)f3) * (f2 / 100.0f);
                int n2 = (int)PyroRenderUtil.Method4908();
                float f4 = ((f00)this.Field1665.Method7979()).Method7514();
                float f5 = ((f00)this.Field1665.Method7979()).Method7517();
                float f6 = ((f00)this.Field1665.Method7979()).Method7531();
                float f7 = ((f00)this.Field1665.Method7979()).Method7522();
                int n3 = 1;
                int n4 = 0;
                int n5 = (int)PyroRenderUtil.Method4908() - n2;
                float f8 = 0.0f;
                int n6 = (int)((float)n4 + f3);
                for (int i = n4; i < n6; ++i) {
                    float f9 = (float)(i - n4) / f3;
                    float[] arrf = new float[4];
                    float f64 = arrf[0] = n3 == 0 ? f8 : f4;
                    float f100 = n3 == 1 ? f8 : (arrf[1] = f5);
                    arrf[2] = n3 == 2 ? f8 : f6;
                    arrf[3] = n3 == 3 ? f8 : f7;
                    float[] arrf2 = arrf;
                    float[] arrf3 = new float[]{n3 == 0 ? f9 : f4, n3 == 1 ? f9 : f5, n3 == 2 ? f9 : f6, n3 == 3 ? f9 : f7};
                    bufferBuilder.pos((double)i, (double)(n5 + n2), 0.0).color(arrf2[0], arrf2[1], arrf2[2], arrf2[3]).endVertex();
                    bufferBuilder.pos((double)i + 1.0, (double)(n5 + n2), 0.0).color(arrf3[0], arrf3[1], arrf3[2], arrf3[3]).endVertex();
                    bufferBuilder.pos((double)i + 1.0, (double)n5, 0.0).color(arrf3[0], arrf3[1], arrf3[2], arrf3[3]).endVertex();
                    bufferBuilder.pos((double)i, (double)n5, 0.0).color(arrf2[0], arrf2[1], arrf2[2], arrf2[3]).endVertex();
                    f8 = f9;
                }
                tessellator.draw();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.shadeModel((int)7424);
                GlStateManager.popMatrix();
            }
            GlStateManager.popMatrix();
        }
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        RenderGlobalAccessor renderGlobalAccessor = (RenderGlobalAccessor)this.Field5233.renderGlobal;
        renderGlobalAccessor.Method12599().forEach((arg_0, arg_1) -> this.Method2375(arg_0, arg_1));
    }
}

