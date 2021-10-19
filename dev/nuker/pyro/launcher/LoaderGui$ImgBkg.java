/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.LoaderGui.ImgBkg.onProgress.2;
import dev.nuker.pyro.launcher.LoaderGui.ImgBkg.paintComponent.1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
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

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020/J\u0012\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u000e\u00103\u001a\u00020/2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00064"},
   d2 = {"Ldev/nuker/pyro/launcher/LoaderGui$ImgBkg;", "Ljavax/swing/JPanel;", "(Ldev/nuker/pyro/launcher/LoaderGui;)V", "image", "Ljava/awt/image/BufferedImage;", "getImage", "()Ljava/awt/image/BufferedImage;", "setImage", "(Ljava/awt/image/BufferedImage;)V", "lightness", "", "getLightness", "()F", "setLightness", "(F)V", "oImage", "getOImage", "pbar", "Ljavax/swing/JProgressBar;", "getPbar", "()Ljavax/swing/JProgressBar;", "setPbar", "(Ljavax/swing/JProgressBar;)V", "percent", "", "getPercent", "()D", "setPercent", "(D)V", "redLightness", "getRedLightness", "setRedLightness", "size", "", "getSize", "()I", "setSize", "(I)V", "usePBar", "", "getUsePBar", "()Z", "setUsePBar", "(Z)V", "getPreferredSize", "Ljava/awt/Dimension;", "onProgress", "", "paintComponent", "g", "Ljava/awt/Graphics;", "setImgSize", "pyroclient"}
)
public final class LoaderGui$ImgBkg extends JPanel {
   @NotNull
   public BufferedImage image;
   @NotNull
   private final BufferedImage oImage;
   private double percent;
   private float lightness;
   private int size;
   private float redLightness;
   private boolean usePBar;
   @NotNull
   public JProgressBar pbar;
   // $FF: synthetic field
   final LoaderGui this$0;

   @NotNull
   public final BufferedImage getImage() {
      BufferedImage var10000 = this.image;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("image");
      }

      return var10000;
   }

   public final void setImage(@NotNull BufferedImage var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.image = var1;
   }

   @NotNull
   public final BufferedImage getOImage() {
      return this.oImage;
   }

   public final double getPercent() {
      return this.percent;
   }

   public final void setPercent(double var1) {
      this.percent = var1;
   }

   public final float getLightness() {
      return this.lightness;
   }

   public final void setLightness(float var1) {
      this.lightness = var1;
   }

   public final int getSize() {
      return this.size;
   }

   public final void setSize(int var1) {
      this.size = var1;
   }

   public final float getRedLightness() {
      return this.redLightness;
   }

   public final void setRedLightness(float var1) {
      this.redLightness = var1;
   }

   public final boolean getUsePBar() {
      return this.usePBar;
   }

   public final void setUsePBar(boolean var1) {
      this.usePBar = var1;
   }

   @NotNull
   public final JProgressBar getPbar() {
      JProgressBar var10000 = this.pbar;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("pbar");
      }

      return var10000;
   }

   public final void setPbar(@NotNull JProgressBar var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.pbar = var1;
   }

   public final void setImgSize(int size) {
      this.image = new BufferedImage(size, size, 2);
      BufferedImage var10000 = this.image;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("image");
      }

      Graphics2D g = var10000.createGraphics();
      g.drawImage((Image)this.oImage, 0, 0, size, size, (ImageObserver)null);
      g.dispose();
      this.size = size;
   }

   protected void paintComponent(@Nullable Graphics g) {
      super.paintComponent(g);
      if (!this.usePBar) {
         try {
            int x = this.getWidth() / 2 - this.size / 2;
            if (g == null) {
               Intrinsics.throwNpe();
            }

            if (g == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.awt.Graphics2D");
            }

            Graphics2D var10000 = (Graphics2D)g;
            BufferedImage var10001 = this.image;
            if (var10001 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("image");
            }

            var10000.drawImage((Image)var10001, x, 0, (ImageObserver)null);
            Shape oldClip = g.getClip();
            g.setClip((Shape)(new Rectangle(x, 0, this.size, (int)((1.0D - this.percent) * (double)this.size))));
            if (this.redLightness != 0.0F) {
               var10000 = (Graphics2D)g;
               var10001 = this.image;
               if (var10001 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("image");
               }

               var10000.drawImage(var10001, (BufferedImageOp)(new RescaleOp(new float[]{this.redLightness, this.lightness, this.lightness}, new float[]{0.0F, 0.0F, 0.0F}, (RenderingHints)null)), x, 0);
            } else {
               var10000 = (Graphics2D)g;
               var10001 = this.image;
               if (var10001 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("image");
               }

               var10000.drawImage(var10001, (BufferedImageOp)(new RescaleOp(this.lightness, 0.0F, (RenderingHints)null)), x, 0);
            }

            ((Graphics2D)g).setClip(oldClip);
         } catch (Throwable var4) {
            if (!this.usePBar) {
               this.usePBar = true;
               EventQueue.invokeLater((Runnable)(new 1(this)));
            }
         }
      }

   }

   public final void onProgress() {
      if (((LoaderGui$ImgBkg)this).pbar != null) {
         EventQueue.invokeAndWait((Runnable)(new 2(this)));
      }

   }

   @NotNull
   public Dimension getPreferredSize() {
      return new Dimension(this.size, this.usePBar ? 100 : this.size);
   }

   public LoaderGui$ImgBkg(LoaderGui $outer) {
      this.this$0 = $outer;
      this.lightness = 0.6F;
      this.setBackground(new Color(0, 0, 0, 0));
      this.setLayout((LayoutManager)(new BorderLayout()));
      InputStream var2 = PyroClientLoadingPlugin.getResourceAsStream("logo.png");
      boolean var3 = false;
      System.out.println(var2);
      BufferedImage img = ImageIO.read(PyroClientLoadingPlugin.getResourceAsStream("logo.png"));
      Intrinsics.checkExpressionValueIsNotNull(img, "img");
      this.oImage = img;
      this.setImgSize(200);
   }
}
