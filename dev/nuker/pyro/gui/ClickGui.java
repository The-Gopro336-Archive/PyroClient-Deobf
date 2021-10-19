/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.class_37;
import dev.nuker.pyro.class_6;
import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import dev.nuker.pyro.f18;
import dev.nuker.pyro.f5j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \\2\u00020\u0001:\u0004[\\]^B\u0005¢\u0006\u0002\u0010\u0002JL\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0018\u00010\fR\u00020\u00000A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190C2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0CJ\b\u0010F\u001a\u00020\nH\u0016J \u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020KH\u0016J\u001c\u0010L\u001a\b\u0018\u00010\u000eR\u00020\u00002\u0006\u0010B\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019J\b\u0010M\u001a\u00020=H\u0016J\u0018\u0010N\u001a\u00020=2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0004H\u0014J(\u0010R\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J \u0010W\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J\u0006\u0010X\u001a\u00020=J\u0010\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u0004H\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00000+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u001a\u00103\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR$\u00109\u001a\f\u0012\b\u0012\u00060\u000eR\u00020\u00000+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/¨\u0006_"},
   d2 = {"Ldev/nuker/pyro/gui/ClickGui;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "SEGHEIGHT", "", "getSEGHEIGHT", "()I", "setSEGHEIGHT", "(I)V", "captureEvents", "", "capturingWindow", "Ldev/nuker/pyro/gui/ClickGui$Window;", "dragging", "Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;", "getDragging", "()Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;", "setDragging", "(Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;)V", "invisibleOverlays", "getInvisibleOverlays", "()Z", "setInvisibleOverlays", "(Z)V", "lastX", "", "getLastX", "()D", "setLastX", "(D)V", "lastY", "getLastY", "setLastY", "mode", "Ldev/nuker/pyro/gui/ClickGui$OpenMode;", "getMode", "()Ldev/nuker/pyro/gui/ClickGui$OpenMode;", "setMode", "(Ldev/nuker/pyro/gui/ClickGui$OpenMode;)V", "moduleWidth", "getModuleWidth", "setModuleWidth", "moduleWindows", "", "getModuleWindows", "()Ljava/util/List;", "setModuleWindows", "(Ljava/util/List;)V", "startDragButton", "getStartDragButton", "setStartDragButton", "startDragX", "getStartDragX", "setStartDragX", "startDragY", "getStartDragY", "setStartDragY", "windows", "getWindows", "setWindows", "addWindow", "", "name", "", "processor", "Ljava/util/function/Consumer;", "x", "Ldev/nuker/pyro/api/AbstractHandledValue;", "y", "expanded", "doesGuiPauseGame", "drawScreen", "mouseX", "mouseY", "delta", "", "getTopWindow", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClickMove", "button", "badmcp", "", "mouseClicked", "mouseReleased", "reloadWindowList", "requestModuleWidth", "width", "AbstractWindow", "Companion", "OpenMode", "Window", "pyroclient"}
)
public final class ClickGui extends GuiScreen {
   @NotNull
   private ClickGui$OpenMode mode;
   private int SEGHEIGHT;
   private boolean invisibleOverlays;
   @Nullable
   private ClickGui$AbstractWindow dragging;
   @NotNull
   private List moduleWindows;
   @NotNull
   private List windows;
   private int moduleWidth;
   private double startDragX;
   private double startDragY;
   private double startDragButton;
   private double lastX;
   private double lastY;
   private ClickGui$Window capturingWindow;
   private boolean captureEvents;
   private static double SCALE = 1.0D;
   private static double DSCALE;
   @NotNull
   private static f0H settings;
   public static final ClickGui$Companion Companion = new ClickGui$Companion((DefaultConstructorMarker)null);

   @NotNull
   public final ClickGui$OpenMode getMode() {
      return this.mode;
   }

   public final void setMode(@NotNull ClickGui$OpenMode var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.mode = var1;
   }

   public final int getSEGHEIGHT() {
      return this.SEGHEIGHT;
   }

   public final void setSEGHEIGHT(int var1) {
      this.SEGHEIGHT = var1;
   }

   protected final boolean getInvisibleOverlays() {
      return this.invisibleOverlays;
   }

   protected final void setInvisibleOverlays(boolean var1) {
      this.invisibleOverlays = var1;
   }

   @Nullable
   public final ClickGui$AbstractWindow getDragging() {
      return this.dragging;
   }

   public final void setDragging(@Nullable ClickGui$AbstractWindow var1) {
      this.dragging = var1;
   }

   @NotNull
   public final List getModuleWindows() {
      return this.moduleWindows;
   }

   public final void setModuleWindows(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.moduleWindows = var1;
   }

   @NotNull
   public final List getWindows() {
      return this.windows;
   }

   public final void setWindows(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.windows = var1;
   }

   public final int getModuleWidth() {
      return this.moduleWidth;
   }

   public final void setModuleWidth(int var1) {
      this.moduleWidth = var1;
   }

   public final double getStartDragX() {
      return this.startDragX;
   }

   public final void setStartDragX(double var1) {
      this.startDragX = var1;
   }

   public final double getStartDragY() {
      return this.startDragY;
   }

   public final void setStartDragY(double var1) {
      this.startDragY = var1;
   }

   public final double getStartDragButton() {
      return this.startDragButton;
   }

   public final void setStartDragButton(double var1) {
      this.startDragButton = var1;
   }

   public final double getLastX() {
      return this.lastX;
   }

   public final void setLastX(double var1) {
      this.lastX = var1;
   }

   public final double getLastY() {
      return this.lastY;
   }

   public final void setLastY(double var1) {
      this.lastY = var1;
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public final void reloadWindowList() {
      // $FF: Couldn't be decompiled
   }

   protected void keyTyped(char typedChar, int keyCode) {
      int keyCode = keyCode;
      KeyBinding var10001 = Pyro.KEY;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Pyro.KEY");
      if (keyCode == var10001.getKeyCode()) {
         keyCode = 1;
      }

      super.keyTyped(typedChar, keyCode);
      if (keyCode != 1) {
         Iterator var5 = this.windows.iterator();

         while(var5.hasNext()) {
            ClickGui$AbstractWindow window = (ClickGui$AbstractWindow)var5.next();
            window.keyTyped(typedChar, keyCode);
         }
      }

   }

   public void drawScreen(int mouseX, int mouseY, float delta) {
      super.drawScreen(mouseX, mouseY, delta);
      GlStateManager.pushMatrix();
      GlStateManager.scale(SCALE, SCALE, 1.0D);
      Iterator var5 = this.windows.iterator();

      while(var5.hasNext()) {
         ClickGui$AbstractWindow window = (ClickGui$AbstractWindow)var5.next();
         window.render((double)mouseX * DSCALE - window.getX((int)((double)this.width * DSCALE)), (double)mouseY * DSCALE - window.getY((int)((double)this.height * DSCALE)));
      }

      if (this.mode == ClickGui$OpenMode.MODULES) {
         this.capturingWindow = (ClickGui$Window)null;
         var5 = this.moduleWindows.iterator();

         while(var5.hasNext()) {
            ClickGui$Window window = (ClickGui$Window)var5.next();
            if (window.isCapturing((double)mouseX * DSCALE - window.getX((int)((double)this.width * DSCALE)), (double)mouseY * DSCALE - window.getY((int)((double)this.height * DSCALE)))) {
               this.capturingWindow = window;
               this.captureEvents = window.getCaptureEvents();
               break;
            }
         }

         if (this.capturingWindow != null) {
            ClickGui$Window var10000 = this.capturingWindow;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            double var10001 = (double)mouseX * DSCALE;
            ClickGui$Window var10002 = this.capturingWindow;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            var10001 -= var10002.getX((int)((double)this.width * DSCALE));
            double var9 = (double)mouseY * DSCALE;
            ClickGui$Window var10003 = this.capturingWindow;
            if (var10003 == null) {
               Intrinsics.throwNpe();
            }

            var10000.renderCapture(var10001, var9 - var10003.getY((int)((double)this.height * DSCALE)));
         }
      }

      f0J.method_3558(0, this.height - 16, 64, 16, settings.method_3490(), settings.method_3505(), 1);
      f0J var7 = f0J.field_2340;
      FontRenderer var8 = this.fontRenderer;
      Intrinsics.checkExpressionValueIsNotNull(var8, "fontRenderer");
      var7.method_3554(var8, this.mode == ClickGui$OpenMode.OVERLAYS ? "Modules" : "Overlays", 0, this.height - 16, 64, 16, f0G.field_2327, 0, settings.method_3494(), true);
      GlStateManager.popMatrix();
   }

   public void mouseClickMove(int mouseX, int mouseY, int button, long badmcp) {
      if (mouseX > 64 || mouseY < this.height - 16) {
         double deltaX = (double)mouseX - this.lastX;
         double deltaY = (double)mouseY - this.lastY;
         ClickGui$AbstractWindow var10000;
         if (this.startDragX == (double)Integer.MIN_VALUE && this.startDragY == (double)Integer.MIN_VALUE && this.dragging == null) {
            this.dragging = this.getTopWindow((double)mouseX, (double)mouseY);
            if (this.dragging != null) {
               label88: {
                  if (button == 0) {
                     var10000 = this.dragging;
                     if (var10000 == null) {
                        Intrinsics.throwNpe();
                     }

                     if (var10000.headerContains((double)mouseX * DSCALE, (double)mouseY * DSCALE)) {
                        break label88;
                     }
                  }

                  this.startDragX = (double)mouseX;
                  this.startDragY = (double)mouseY;
               }
            }

            this.startDragButton = (double)button;
         }

         if ((double)button != this.startDragButton) {
            this.dragging = (ClickGui$AbstractWindow)null;
            this.startDragX = (double)Integer.MIN_VALUE;
            this.startDragY = (double)Integer.MIN_VALUE;
         }

         if (this.startDragX != (double)Integer.MIN_VALUE && this.startDragY != (double)Integer.MIN_VALUE) {
            var10000 = this.dragging;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            f15 var15 = new f15;
            double var10003 = this.startDragX * DSCALE;
            ClickGui$AbstractWindow var10004 = this.dragging;
            if (var10004 == null) {
               Intrinsics.throwNpe();
            }

            var10003 -= var10004.getX((int)((double)this.width * DSCALE));
            double var16 = this.startDragY * DSCALE;
            ClickGui$AbstractWindow var10005 = this.dragging;
            if (var10005 == null) {
               Intrinsics.throwNpe();
            }

            var16 -= var10005.getY((int)((double)this.height * DSCALE));
            double var12 = (double)mouseX * DSCALE;
            ClickGui$AbstractWindow var10006 = this.dragging;
            if (var10006 == null) {
               Intrinsics.throwNpe();
            }

            var12 -= var10006.getX((int)((double)this.width * DSCALE));
            double var13 = (double)mouseY * DSCALE;
            ClickGui$AbstractWindow var10007 = this.dragging;
            if (var10007 == null) {
               Intrinsics.throwNpe();
            }

            var15.<init>(var10003, var16, var12, var13 - var10007.getY((int)((double)this.height * DSCALE)), deltaX * DSCALE, deltaY * DSCALE, button);
            var10000.mouseEvent((f17)var15);
         } else if (this.dragging != null) {
            var10000 = this.dragging;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            ClickGui$AbstractWindow var10001 = this.dragging;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            double var14 = var10001.getX((int)((double)this.width * DSCALE)) + deltaX * DSCALE;
            ClickGui$AbstractWindow var10002 = this.dragging;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            var10000.setPosition(var14, var10002.getY((int)((double)this.height * DSCALE)) + deltaY * DSCALE);
         }

         Iterator var11 = this.windows.iterator();

         while(var11.hasNext()) {
            ClickGui$AbstractWindow window = (ClickGui$AbstractWindow)var11.next();
            if (window != this.dragging) {
               window.onClickedElsewhere();
            }
         }

         this.lastX = (double)mouseX;
         this.lastY = (double)mouseY;
      }

   }

   public void mouseReleased(int mouseX, int mouseY, int button) {
      double var9;
      ClickGui$AbstractWindow var10000;
      double var10003;
      ClickGui$AbstractWindow var10004;
      ClickGui$AbstractWindow var10005;
      if (this.startDragX != (double)Integer.MIN_VALUE && this.startDragY != (double)Integer.MIN_VALUE) {
         var10000 = this.dragging;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         f16 var8 = new f16;
         var10003 = this.startDragX * DSCALE;
         var10004 = this.dragging;
         if (var10004 == null) {
            Intrinsics.throwNpe();
         }

         var10003 -= var10004.getX((int)((double)this.width * DSCALE));
         var9 = this.startDragY * DSCALE;
         var10005 = this.dragging;
         if (var10005 == null) {
            Intrinsics.throwNpe();
         }

         var9 -= var10005.getY((int)((double)this.height * DSCALE));
         double var6 = (double)mouseX * DSCALE;
         ClickGui$AbstractWindow var10006 = this.dragging;
         if (var10006 == null) {
            Intrinsics.throwNpe();
         }

         var6 -= var10006.getX((int)((double)this.width * DSCALE));
         double var7 = (double)mouseY * DSCALE;
         ClickGui$AbstractWindow var10007 = this.dragging;
         if (var10007 == null) {
            Intrinsics.throwNpe();
         }

         var8.<init>(var10003, var9, var6, var7 - var10007.getY((int)((double)this.height * DSCALE)), button);
         var10000.mouseEvent((f17)var8);
         this.startDragX = (double)Integer.MIN_VALUE;
         this.startDragY = (double)Integer.MIN_VALUE;
      } else {
         if (this.dragging == null) {
            this.dragging = this.getTopWindow((double)mouseX, (double)mouseY);
         }

         if (this.dragging != null) {
            var10000 = this.dragging;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            f18 var10001 = new f18;
            var10003 = (double)mouseX * DSCALE;
            var10004 = this.dragging;
            if (var10004 == null) {
               Intrinsics.throwNpe();
            }

            var10003 -= var10004.getX((int)((double)this.width * DSCALE));
            var9 = (double)mouseY * DSCALE;
            var10005 = this.dragging;
            if (var10005 == null) {
               Intrinsics.throwNpe();
            }

            var10001.<init>(var10003, var9 - var10005.getY((int)((double)this.height * DSCALE)), button);
            var10000.mouseEvent((f17)var10001);
         }
      }

      Iterator var5 = this.windows.iterator();

      while(var5.hasNext()) {
         ClickGui$AbstractWindow window = (ClickGui$AbstractWindow)var5.next();
         if (window != this.dragging) {
            window.onClickedElsewhere();
         }
      }

      this.dragging = (ClickGui$AbstractWindow)null;
   }

   public void mouseClicked(int mouseX, int mouseY, int button) {
      if (mouseX <= 64 && mouseY >= this.height - 16) {
         this.mode = this.mode == ClickGui$OpenMode.MODULES ? ClickGui$OpenMode.OVERLAYS : ClickGui$OpenMode.MODULES;
         this.reloadWindowList();
         if (this.mode == ClickGui$OpenMode.OVERLAYS) {
            this.mc.displayGuiScreen((GuiScreen)(new f5j()));
         }

      } else {
         ClickGui$AbstractWindow clicked = this.getTopWindow((double)mouseX, (double)mouseY);
         if (clicked != null) {
            clicked.mouseEvent((f17)(new f14((double)mouseX * DSCALE - clicked.getX((int)((double)this.width * DSCALE)), (double)mouseY * DSCALE - clicked.getY((int)((double)this.height * DSCALE)), button)));
            this.windows.remove(clicked);
            this.windows.add(clicked);
         }

         Iterator var6 = this.windows.iterator();

         while(var6.hasNext()) {
            ClickGui$AbstractWindow window = (ClickGui$AbstractWindow)var6.next();
            if (window != clicked) {
               window.onClickedElsewhere();
            }
         }

         this.lastX = (double)mouseX;
         this.lastY = (double)mouseY;
      }
   }

   @Nullable
   public final ClickGui$AbstractWindow getTopWindow(double x, double y) {
      if (this.capturingWindow != null) {
         ClickGui$Window var10000 = this.capturingWindow;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.getCaptureEvents()) {
            return (ClickGui$AbstractWindow)this.capturingWindow;
         }
      }

      int i = ((Collection)this.windows).size();
      --i;

      for(boolean var6 = false; i >= 0; --i) {
         ClickGui$AbstractWindow window = (ClickGui$AbstractWindow)this.windows.get(i);
         if (window.contains(x * DSCALE, y * DSCALE)) {
            return window;
         }
      }

      return null;
   }

   public void initGui() {
      super.initGui();
      this.moduleWindows.clear();
      this.SEGHEIGHT = this.fontRenderer.FONT_HEIGHT + f0H.field_2335 * 2;
      class_37.field_2633.method_3974(this);
   }

   public final void addWindow(@NotNull String name, @NotNull Consumer processor, @NotNull class_6 x, @NotNull class_6 y, @NotNull class_6 expanded) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(processor, "processor");
      Intrinsics.checkParameterIsNotNull(x, "x");
      Intrinsics.checkParameterIsNotNull(y, "y");
      Intrinsics.checkParameterIsNotNull(expanded, "expanded");
      ClickGui$Window window = new ClickGui$Window(this, name, x, y, expanded);
      processor.accept(window);
      this.moduleWindows.add(window);
   }

   protected final void requestModuleWidth(int width) {
      if (width > this.moduleWidth) {
         this.moduleWidth = width;
      }

   }

   public ClickGui() {
      this.mode = ClickGui$OpenMode.MODULES;
      this.moduleWindows = (List)(new ArrayList());
      this.windows = (List)(new ArrayList());
      this.startDragX = (double)Integer.MIN_VALUE;
      this.startDragY = (double)Integer.MIN_VALUE;
      this.startDragButton = -1.0D;
   }

   static {
      DSCALE = 1.0D / SCALE;
      settings = f0H.field_2338;
   }

   // $FF: synthetic method
   public static final FontRenderer access$getFontRenderer$p(ClickGui $this) {
      return $this.fontRenderer;
   }

   // $FF: synthetic method
   public static final void access$setFontRenderer$p(ClickGui $this, FontRenderer var1) {
      $this.fontRenderer = var1;
   }

   // $FF: synthetic method
   public static final double access$getSCALE$cp() {
      return SCALE;
   }

   // $FF: synthetic method
   public static final void access$setSCALE$cp(double var0) {
      SCALE = var0;
   }

   // $FF: synthetic method
   public static final double access$getDSCALE$cp() {
      return DSCALE;
   }

   // $FF: synthetic method
   public static final void access$setDSCALE$cp(double var0) {
      DSCALE = var0;
   }

   // $FF: synthetic method
   public static final f0H access$getSettings$cp() {
      return settings;
   }

   // $FF: synthetic method
   public static final void access$setSettings$cp(f0H var0) {
      settings = var0;
   }
}
