/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.EnumHandSide
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0n;
import dev.nuker.pyro.f0t;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import org.jetbrains.annotations.NotNull;

public class fbm
extends Module {
    public double Field130 = 3.0;
    public double Field131 = 3.0;
    public double Field132 = 360.0;
    @NotNull
    public DoubleSetting Field133;
    @NotNull
    public DoubleSetting Field134;
    @NotNull
    public DoubleSetting Field135;
    @NotNull
    public DoubleSetting Field136;
    @NotNull
    public DoubleSetting Field137;
    @NotNull
    public DoubleSetting Field138;
    @NotNull
    public DoubleSetting Field139;
    @NotNull
    public DoubleSetting Field140;
    @NotNull
    public DoubleSetting Field141;
    @NotNull
    public DoubleSetting Field142;
    @NotNull
    public DoubleSetting Field143;
    @NotNull
    public DoubleSetting Field144;
    @NotNull
    public DoubleSetting Field145;
    @NotNull
    public DoubleSetting Field146;
    @NotNull
    public DoubleSetting Field147;
    @NotNull
    public DoubleSetting Field148;
    @NotNull
    public DoubleSetting Field149;
    @NotNull
    public DoubleSetting Field150;

    @NotNull
    public DoubleSetting Method217() {
        return this.Field134;
    }

    @NotNull
    public DoubleSetting Method218() {
        return this.Field144;
    }

    @NotNull
    public DoubleSetting Method219() {
        return this.Field139;
    }

    @NotNull
    public DoubleSetting Method220() {
        return this.Field148;
    }

    public double Method221() {
        return this.Field132;
    }

    @NotNull
    public DoubleSetting Method222() {
        return this.Field145;
    }

    @NotNull
    public DoubleSetting Method223() {
        return this.Field149;
    }

    @NotNull
    public DoubleSetting Method224() {
        return this.Field141;
    }

    @NotNull
    public DoubleSetting Method225() {
        return this.Field137;
    }

    @NotNull
    public DoubleSetting Method226() {
        return this.Field142;
    }

    @NotNull
    public DoubleSetting Method227() {
        return this.Field136;
    }

    @NotNull
    public DoubleSetting Method228() {
        return this.Field135;
    }

    public double Method229() {
        return this.Field131;
    }

    public double Method230() {
        return this.Field130;
    }

    public fbm() {
        super("itemViewModel", "ItemViewModel", "Changes the view model of hand items");
        this.Field130 = 3.0;
        this.Field131 = 3.0;
        this.Field132 = 360.0;
        this.Field133 = new DoubleSetting("x", "X", null, 0.0, -this.Field130, this.Field130, 0.0, 64, null);
        this.Field134 = new DoubleSetting("y", "Y", null, 0.0, -this.Field130, this.Field130, 0.0, 64, null);
        this.Field135 = new DoubleSetting("z", "Z", null, 0.0, -this.Field130, this.Field130, 0.0, 64, null);
        this.Field136 = new DoubleSetting("x", "X", null, 1.0, 0.0, this.Field131, 0.0, 64, null);
        this.Field137 = new DoubleSetting("y", "Y", null, 1.0, 0.0, this.Field131, 0.0, 64, null);
        this.Field138 = new DoubleSetting("z", "Z", null, 1.0, 0.0, this.Field131, 0.0, 64, null);
        this.Field139 = new DoubleSetting("x", "X", null, 0.0, 0.0, this.Field132, 0.0, 64, null);
        this.Field140 = new DoubleSetting("y", "Y", null, 0.0, 0.0, this.Field132, 0.0, 64, null);
        this.Field141 = new DoubleSetting("z", "Z", null, 0.0, 0.0, this.Field132, 0.0, 64, null);
        this.Field142 = new DoubleSetting("x", "X", null, 0.0, -this.Field130, this.Field130, 0.0, 64, null);
        this.Field143 = new DoubleSetting("y", "Y", null, 0.0, -this.Field130, this.Field130, 0.0, 64, null);
        this.Field144 = new DoubleSetting("z", "Z", null, 0.0, -this.Field130, this.Field130, 0.0, 64, null);
        this.Field145 = new DoubleSetting("x", "X", null, 1.0, 0.0, this.Field131, 0.0, 64, null);
        this.Field146 = new DoubleSetting("y", "Y", null, 1.0, 0.0, this.Field131, 0.0, 64, null);
        this.Field147 = new DoubleSetting("z", "Z", null, 1.0, 0.0, this.Field131, 0.0, 64, null);
        this.Field148 = new DoubleSetting("x", "X", null, 0.0, 0.0, this.Field132, 0.0, 64, null);
        this.Field149 = new DoubleSetting("y", "Y", null, 0.0, 0.0, this.Field132, 0.0, 64, null);
        this.Field150 = new DoubleSetting("z", "Z", null, 0.0, 0.0, this.Field132, 0.0, 64, null);
        this.Method7264(new f0t(new f0n("mainhand", "Mainhand", null), new f0t(new f0n("translate", "Translation", null), this.Field133, this.Field134, this.Field135), new f0t(new f0n("scale", "Scale", null), this.Field136, this.Field137, this.Field138), new f0t(new f0n("rotation", "Rotation", null), this.Field139, this.Field140, this.Field141)));
        this.Method7264(new f0t(new f0n("offhand", "Offhand", null), new f0t(new f0n("translate", "Translation", null), this.Field142, this.Field143, this.Field144), new f0t(new f0n("scale", "Scale", null), this.Field145, this.Field146, this.Field147), new f0t(new f0n("rotation", "Rotation", null), this.Field148, this.Field149, this.Field150)));
    }

    @NotNull
    public DoubleSetting Method231() {
        return this.Field140;
    }

    @NotNull
    public DoubleSetting Method232() {
        return this.Field147;
    }

    @NotNull
    public DoubleSetting Method233() {
        return this.Field138;
    }

    @NotNull
    public DoubleSetting Method234() {
        return this.Field146;
    }

    @NotNull
    public DoubleSetting Method235() {
        return this.Field143;
    }

    @NotNull
    public DoubleSetting Method236() {
        return this.Field150;
    }

    public void Method237(@NotNull EnumHandSide enumHandSide) {
        if (enumHandSide == EnumHandSide.RIGHT) {
            GlStateManager.translate((double)((Number)this.Field133.Method7979()).doubleValue(), (double)((Number)this.Field134.Method7979()).doubleValue(), (double)((Number)this.Field135.Method7979()).doubleValue());
            GlStateManager.scale((double)((Number)this.Field136.Method7979()).doubleValue(), (double)((Number)this.Field136.Method7979()).doubleValue(), (double)((Number)this.Field138.Method7979()).doubleValue());
            GlStateManager.rotate((float)((float)((Number)this.Field139.Method7979()).doubleValue()), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)((Number)this.Field140.Method7979()).doubleValue()), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)((Number)this.Field141.Method7979()).doubleValue()), (float)0.0f, (float)0.0f, (float)1.0f);
        } else {
            GlStateManager.translate((double)((Number)this.Field142.Method7979()).doubleValue(), (double)((Number)this.Field143.Method7979()).doubleValue(), (double)((Number)this.Field144.Method7979()).doubleValue());
            GlStateManager.scale((double)((Number)this.Field145.Method7979()).doubleValue(), (double)((Number)this.Field145.Method7979()).doubleValue(), (double)((Number)this.Field147.Method7979()).doubleValue());
            GlStateManager.rotate((float)((float)((Number)this.Field148.Method7979()).doubleValue()), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)((Number)this.Field149.Method7979()).doubleValue()), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)((Number)this.Field150.Method7979()).doubleValue()), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field133;
    }
}

