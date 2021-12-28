/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 */
package dev.nuker.pyro;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class faR
extends Lambda
implements Function0 {
    public int Field1689;
    public BufferBuilder Field1690;
    public ScaledResolution Field1691;
    public Tessellator Field1692;

    public Object Method945() {
        this.Method2267();
        return Unit.Field4531;
    }

    public faR(int n, BufferBuilder bufferBuilder, ScaledResolution scaledResolution, Tessellator tessellator) {
        this.Field1689 = n;
        this.Field1690 = bufferBuilder;
        this.Field1691 = scaledResolution;
        this.Field1692 = tessellator;
        super(0);
    }

    public void Method2267() {
        int n = this.Field1689;
        for (int i = 0; i < n; ++i) {
            this.Field1690.begin(7, DefaultVertexFormats.POSITION_TEX);
            this.Field1690.pos(0.0, (double)this.Field1691.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
            this.Field1690.pos((double)this.Field1691.getScaledWidth(), (double)this.Field1691.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
            this.Field1690.pos((double)this.Field1691.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
            this.Field1690.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
            this.Field1692.draw();
        }
    }
}

