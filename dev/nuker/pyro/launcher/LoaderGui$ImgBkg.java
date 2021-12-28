/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.launcher.LoaderGui$ImgBkg$onProgress$2
 *  dev.nuker.pyro.launcher.LoaderGui$ImgBkg$paintComponent$1
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.launcher.LoaderGui$ImgBkg;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020/J\u0012\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u000e\u00103\u001a\u00020/2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00064"}, d2={"Ldev/nuker/pyro/launcher/LoaderGui$ImgBkg;", "Ljavax/swing/JPanel;", "(Ldev/nuker/pyro/launcher/LoaderGui;)V", "image", "Ljava/awt/image/BufferedImage;", "getImage", "()Ljava/awt/image/BufferedImage;", "setImage", "(Ljava/awt/image/BufferedImage;)V", "lightness", "", "getLightness", "()F", "setLightness", "(F)V", "oImage", "getOImage", "pbar", "Ljavax/swing/JProgressBar;", "getPbar", "()Ljavax/swing/JProgressBar;", "setPbar", "(Ljavax/swing/JProgressBar;)V", "percent", "", "getPercent", "()D", "setPercent", "(D)V", "redLightness", "getRedLightness", "setRedLightness", "size", "", "getSize", "()I", "setSize", "(I)V", "usePBar", "", "getUsePBar", "()Z", "setUsePBar", "(Z)V", "getPreferredSize", "Ljava/awt/Dimension;", "onProgress", "", "paintComponent", "g", "Ljava/awt/Graphics;", "setImgSize", "pyroclient"})
public final class LoaderGui$ImgBkg
extends JPanel {
    @NotNull
    public BufferedImage Field5664;
    @NotNull
    private final BufferedImage Field5665;
    private double Field5666;
    private float Field5667 = 0.6f;
    private int Field5668;
    private float Field5669;
    private boolean Field5670;
    @NotNull
    public JProgressBar Field5671;
    final /* synthetic */ LoaderGui Field5672;

    @NotNull
    public final BufferedImage Method8039() {
        BufferedImage bufferedImage = this.Field5664;
        if (bufferedImage == null) {
            Intrinsics.Method6554("image");
        }
        return bufferedImage;
    }

    public final void Method8040(@NotNull BufferedImage bufferedImage) {
        Intrinsics.Method6567(bufferedImage, "<set-?>");
        this.Field5664 = bufferedImage;
    }

    @NotNull
    public final BufferedImage Method8041() {
        return this.Field5665;
    }

    public final double Method8042() {
        return this.Field5666;
    }

    public final void Method8043(double d) {
        this.Field5666 = d;
    }

    public final float Method8044() {
        return this.Field5667;
    }

    public final void Method8045(float f) {
        this.Field5667 = f;
    }

    public final int Method113() {
        return this.Field5668;
    }

    public final void Method8046(int n) {
        this.Field5668 = n;
    }

    public final float Method8047() {
        return this.Field5669;
    }

    public final void Method8048(float f) {
        this.Field5669 = f;
    }

    public final boolean Method8049() {
        return this.Field5670;
    }

    public final void Method8050(boolean bl) {
        this.Field5670 = bl;
    }

    @NotNull
    public final JProgressBar Method8051() {
        JProgressBar jProgressBar = this.Field5671;
        if (jProgressBar == null) {
            Intrinsics.Method6554("pbar");
        }
        return jProgressBar;
    }

    public final void Method8052(@NotNull JProgressBar jProgressBar) {
        Intrinsics.Method6567(jProgressBar, "<set-?>");
        this.Field5671 = jProgressBar;
    }

    public final void Method8053(int size) {
        BufferedImage bufferedImage = this.Field5664 = new BufferedImage(size, size, 2);
        if (bufferedImage == null) {
            Intrinsics.Method6554("image");
        }
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(this.Field5665, 0, 0, size, size, null);
        g.dispose();
        this.Field5668 = size;
    }

    @Override
    protected void paintComponent(@Nullable Graphics g) {
        block10: {
            super.paintComponent(g);
            if (!this.Field5670) {
                try {
                    int x = this.getWidth() / 2 - this.Field5668 / 2;
                    Graphics graphics = g;
                    if (graphics == null) {
                        Intrinsics.Method6551();
                    }
                    if (graphics == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.awt.Graphics2D");
                    }
                    Graphics2D graphics2D = (Graphics2D)graphics;
                    BufferedImage bufferedImage = this.Field5664;
                    if (bufferedImage == null) {
                        Intrinsics.Method6554("image");
                    }
                    graphics2D.drawImage((Image)bufferedImage, x, 0, null);
                    Shape oldClip = g.getClip();
                    g.setClip(new Rectangle(x, 0, this.Field5668, (int)((1.0 - this.Field5666) * (double)this.Field5668)));
                    if (this.Field5669 != 0.0f) {
                        Graphics2D graphics2D2 = (Graphics2D)g;
                        BufferedImage bufferedImage2 = this.Field5664;
                        if (bufferedImage2 == null) {
                            Intrinsics.Method6554("image");
                        }
                        graphics2D2.drawImage(bufferedImage2, new RescaleOp(new float[]{this.Field5669, this.Field5667, this.Field5667}, new float[]{0.0f, 0.0f, 0.0f}, null), x, 0);
                    } else {
                        Graphics2D graphics2D3 = (Graphics2D)g;
                        BufferedImage bufferedImage3 = this.Field5664;
                        if (bufferedImage3 == null) {
                            Intrinsics.Method6554("image");
                        }
                        graphics2D3.drawImage(bufferedImage3, new RescaleOp(this.Field5667, 0.0f, null), x, 0);
                    }
                    ((Graphics2D)g).setClip(oldClip);
                }
                catch (Throwable e) {
                    if (this.Field5670) break block10;
                    this.Field5670 = true;
                    EventQueue.invokeLater((Runnable)new paintComponent.1(this));
                }
            }
        }
    }

    public final void Method8054() {
        if (this.Field5671 != null) {
            EventQueue.invokeAndWait((Runnable)new onProgress.2(this));
        }
    }

    @Override
    @NotNull
    public Dimension getPreferredSize() {
        return new Dimension(this.Field5668, this.Field5670 ? 100 : this.Field5668);
    }

    public LoaderGui$ImgBkg(LoaderGui $outer) {
        BufferedImage img;
        this.Field5672 = $outer;
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(new BorderLayout());
        InputStream inputStream = PyroClientLoadingPlugin.Method12460("logo.png");
        boolean bl = false;
        System.out.println(inputStream);
        BufferedImage bufferedImage = img = ImageIO.read(PyroClientLoadingPlugin.Method12460("logo.png"));
        Intrinsics.Method6561(bufferedImage, "img");
        this.Field5665 = bufferedImage;
        this.Method8053(200);
    }
}

