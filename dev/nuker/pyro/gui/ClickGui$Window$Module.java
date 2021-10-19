/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.class_6;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f0S;
import dev.nuker.pyro.f13;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.Tuple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\u000fJ\b\u00109\u001a\u00020:H\u0004J\u0011\u0010;\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020<H\u0086\u0002J>\u0010=\u001a \u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001b0>\u0012\u0004\u0012\u00020\f\u0018\u00010>2\u0006\u0010?\u001a\u00020<2\u0006\u0010\u000e\u001a\u00020<2\u0006\u0010@\u001a\u00020\tH\u0004J\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u0006J\u0016\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<J\u0016\u0010G\u001a\u00020\t2\u0006\u0010?\u001a\u00020<2\u0006\u0010\u000e\u001a\u00020<J\u0016\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\fJ\u000e\u0010L\u001a\u00020:2\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020:J\u0016\u0010P\u001a\u00020:2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<J\u0016\u0010Q\u001a\u00020:2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<J\b\u0010R\u001a\u00020:H\u0004R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)¨\u0006S"},
   d2 = {"Ldev/nuker/pyro/gui/ClickGui$Window$Module;", "", "name", "", "controls", "", "Ldev/nuker/pyro/api/ui/control/UiControl;", "handler", "Ljava/util/function/Consumer;", "", "hotkey", "Ldev/nuker/pyro/api/AbstractHandledValue;", "", "expanded", "y", "(Ldev/nuker/pyro/gui/ClickGui$Window;Ljava/lang/String;Ljava/util/List;Ljava/util/function/Consumer;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;)V", "captureEvents", "getCaptureEvents", "()Z", "setCaptureEvents", "(Z)V", "capturingControl", "getCapturingControl", "()Ldev/nuker/pyro/api/ui/control/UiControl;", "setCapturingControl", "(Ldev/nuker/pyro/api/ui/control/UiControl;)V", "contexts", "Ldev/nuker/pyro/api/ui/GuiContext;", "getContexts", "()Ljava/util/List;", "setContexts", "(Ljava/util/List;)V", "", "getControls", "setControls", "enabled", "getEnabled", "setEnabled", "getExpanded", "()Ldev/nuker/pyro/api/AbstractHandledValue;", "setExpanded", "(Ldev/nuker/pyro/api/AbstractHandledValue;)V", "getHandler", "()Ljava/util/function/Consumer;", "setHandler", "(Ljava/util/function/Consumer;)V", "height_", "getHeight_", "()I", "setHeight_", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getY", "setY", "buildContexts", "", "contains", "", "getControlAt", "Lnet/minecraft/util/Tuple;", "x", "captureCounts", "getHeight", "getYOfControl", "control", "isCapturing", "mouseX", "mouseY", "isOnTop", "keyTyped", "typedChar", "", "keyCode", "mouseEvent", "event", "Ldev/nuker/pyro/api/ui/mouse/MouseEvent;", "onClickedElsewhere", "render", "renderCapture", "updateControlSizes", "pyroclient"}
)
public final class ClickGui$Window$Module {
   private boolean enabled;
   @NotNull
   private class_6 expanded;
   private int height_;
   // $FF: renamed from: y dev.nuker.pyro.fw
   @NotNull
   private class_6 field_2623;
   @NotNull
   private List controls;
   @NotNull
   private List contexts;
   @NotNull
   private Consumer handler;
   @Nullable
   private f13 capturingControl;
   private boolean captureEvents;
   @NotNull
   private String name;
   // $FF: synthetic field
   final ClickGui$Window this$0;

   public final boolean getEnabled() {
      return this.enabled;
   }

   public final void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   @NotNull
   public final class_6 getExpanded() {
      return this.expanded;
   }

   public final void setExpanded(@NotNull class_6 var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.expanded = var1;
   }

   public final int getHeight_() {
      return this.height_;
   }

   public final void setHeight_(int var1) {
      this.height_ = var1;
   }

   @NotNull
   public final class_6 getY() {
      return this.field_2623;
   }

   public final void setY(@NotNull class_6 var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.field_2623 = var1;
   }

   @NotNull
   public final List getControls() {
      return this.controls;
   }

   public final void setControls(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.controls = var1;
   }

   @NotNull
   protected final List getContexts() {
      return this.contexts;
   }

   protected final void setContexts(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.contexts = var1;
   }

   @NotNull
   protected final Consumer getHandler() {
      return this.handler;
   }

   protected final void setHandler(@NotNull Consumer var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.handler = var1;
   }

   @Nullable
   protected final f13 getCapturingControl() {
      return this.capturingControl;
   }

   protected final void setCapturingControl(@Nullable f13 var1) {
      this.capturingControl = var1;
   }

   public final boolean getCaptureEvents() {
      return this.captureEvents;
   }

   public final void setCaptureEvents(boolean var1) {
      this.captureEvents = var1;
   }

   public final void keyTyped(char typedChar, int keyCode) {
      Iterator var4 = this.controls.iterator();

      while(var4.hasNext()) {
         f13 control = (f13)var4.next();
         control.method_23(typedChar, keyCode);
      }

   }

   public final void render(double mouseX, double mouseY) {
      ClickGui var10000 = this.this$0.this$0;
      int var10001 = ClickGui.access$getFontRenderer$p(this.this$0.this$0).getStringWidth(this.name);
      ClickGui.Companion.getSettings();
      var10000.requestModuleWidth(var10001 + f0H.field_2335 * 2);
      f0J var10 = f0J.field_2340;
      FontRenderer var12 = ClickGui.access$getFontRenderer$p(this.this$0.this$0);
      Intrinsics.checkExpressionValueIsNotNull(var12, "fontRenderer");
      String var10002 = this.name;
      int var10005 = this.this$0.this$0.getModuleWidth() - 4;
      int var10006 = this.this$0.this$0.getSEGHEIGHT();
      ClickGui.Companion.getSettings();
      f0G var10007 = f0H.field_2336;
      ClickGui.Companion.getSettings();
      f0J.method_3555(var10, var12, var10002, 0, 0, var10005, var10006, var10007, f0H.field_2335, this.enabled ? ClickGui.Companion.getSettings().method_3505() : ClickGui.Companion.getSettings().method_3494(), false, 512, (Object)null);
      if (this.isOnTop(mouseX, mouseY) && mouseY <= (double)this.this$0.this$0.getSEGHEIGHT() && mouseY >= (double)0) {
         Gui.drawRect(this.this$0.this$0.getModuleWidth() - 3, 1, this.this$0.this$0.getModuleWidth() - 1, this.this$0.this$0.getSEGHEIGHT() - 1, this.enabled ? ClickGui.Companion.getSettings().method_3488() : (new Color(209, 35, 0)).getRGB());
      }

      Object var11 = this.expanded.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var11, "expanded.value");
      if ((Boolean)var11) {
         int y = this.this$0.this$0.getSEGHEIGHT();
         int i = 0;

         for(int var7 = ((Collection)this.controls).size(); i < var7; ++i) {
            f13 control = (f13)this.controls.get(i);
            f0F context = (f0F)this.contexts.get(i);
            GlStateManager.pushMatrix();
            GlStateManager.translate(1.0F, (float)y, 0.0F);
            control.method_28(context, mouseX, mouseY - (double)y, ClickGui.Companion.getSettings());
            GlStateManager.popMatrix();
            y += context.method_3583();
         }

         Gui.drawRect(1, this.this$0.this$0.getSEGHEIGHT(), 2, y, ClickGui.Companion.getSettings().method_3505());
      }

   }

   public final void renderCapture(double mouseX, double mouseY) {
      if (this.capturingControl != null) {
         int y = this.this$0.this$0.getSEGHEIGHT();
         int i = 0;

         for(int var7 = ((Collection)this.controls).size(); i < var7; ++i) {
            f13 control = (f13)this.controls.get(i);
            f0F context = (f0F)this.contexts.get(i);
            if (control == this.capturingControl) {
               GlStateManager.pushMatrix();
               GlStateManager.translate(1.0F, (float)y, 0.0F);
               control.method_22(context, mouseX, mouseY - (double)y, ClickGui.Companion.getSettings());
               GlStateManager.popMatrix();
               break;
            }

            y += context.method_3583();
         }
      }

   }

   public final void mouseEvent(@NotNull f17 event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Object var10000;
      Object var10001;
      Tuple control;
      f13 var3;
      if (event instanceof f16) {
         if (((f16)event).method_3658() > (double)this.this$0.this$0.getSEGHEIGHT()) {
            control = this.getControlAt(((f16)event).method_3658(), ((f16)event).method_3658(), false);
            if (control != null) {
               if (this.captureEvents) {
                  var10000 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10000, "control.first");
                  var10000 = ((Tuple)var10000).getFirst();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = (f13)var10000;
                  var10001 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10001, "control.first");
                  var10001 = ((Tuple)var10001).getSecond();
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3.method_27((f0F)var10001, ClickGui.Companion.getSettings(), event.method_3648(1.0D, (double)((Number)control.getSecond()).intValue()));
               } else {
                  var10000 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10000, "control.first");
                  var10000 = ((Tuple)var10000).getFirst();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = (f13)var10000;
                  var10001 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10001, "control.first");
                  var10001 = ((Tuple)var10001).getSecond();
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3.method_24((f0F)var10001, ClickGui.Companion.getSettings(), event.method_3648(1.0D, (double)((Number)control.getSecond()).intValue()));
               }
            }
         }
      } else if (event instanceof f15) {
         if (((f15)event).method_3650() > (double)this.this$0.this$0.getSEGHEIGHT()) {
            control = this.getControlAt(((f15)event).method_3656(), ((f15)event).method_3650(), false);
            if (control != null) {
               if (this.captureEvents) {
                  var10000 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10000, "control.first");
                  var10000 = ((Tuple)var10000).getFirst();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = (f13)var10000;
                  var10001 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10001, "control.first");
                  var10001 = ((Tuple)var10001).getSecond();
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3.method_27((f0F)var10001, ClickGui.Companion.getSettings(), event.method_3648(1.0D, (double)((Number)control.getSecond()).intValue()));
               } else {
                  var10000 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10000, "control.first");
                  var10000 = ((Tuple)var10000).getFirst();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3 = (f13)var10000;
                  var10001 = control.getFirst();
                  Intrinsics.checkExpressionValueIsNotNull(var10001, "control.first");
                  var10001 = ((Tuple)var10001).getSecond();
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  var3.method_24((f0F)var10001, ClickGui.Companion.getSettings(), event.method_3648(1.0D, (double)((Number)control.getSecond()).intValue()));
               }
            }
         }
      } else if (event.method_3646() > (double)0 && event.method_3646() <= (double)this.this$0.this$0.getSEGHEIGHT()) {
         if (event instanceof f14) {
            if (event.method_3645() == 0) {
               this.enabled = !this.enabled;
               this.handler.accept(this.enabled);
            } else if (event.method_3645() == 1) {
               this.expanded.method_3033(!(Boolean)this.expanded.method_3034());
               this.updateControlSizes();
            }
         }
      } else {
         control = this.getControlAt(0.0D, event.method_3646(), true);
         if (control != null) {
            if (this.captureEvents) {
               var10000 = control.getFirst();
               Intrinsics.checkExpressionValueIsNotNull(var10000, "control.first");
               var10000 = ((Tuple)var10000).getFirst();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var3 = (f13)var10000;
               var10001 = control.getFirst();
               Intrinsics.checkExpressionValueIsNotNull(var10001, "control.first");
               var10001 = ((Tuple)var10001).getSecond();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var3.method_27((f0F)var10001, ClickGui.Companion.getSettings(), event.method_3648(1.0D, (double)((Number)control.getSecond()).intValue()));
            } else {
               var10000 = control.getFirst();
               Intrinsics.checkExpressionValueIsNotNull(var10000, "control.first");
               var10000 = ((Tuple)var10000).getFirst();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var3 = (f13)var10000;
               var10001 = control.getFirst();
               Intrinsics.checkExpressionValueIsNotNull(var10001, "control.first");
               var10001 = ((Tuple)var10001).getSecond();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var3.method_24((f0F)var10001, ClickGui.Companion.getSettings(), event.method_3648(1.0D, (double)((Number)control.getSecond()).intValue()));
            }
         }
      }

   }

   @Nullable
   protected final Tuple getControlAt(double x, double y, boolean captureCounts) {
      int cy;
      int i;
      if (this.capturingControl != null && this.captureEvents) {
         cy = this.this$0.this$0.getSEGHEIGHT();
         f0F context = (f0F)null;
         i = 0;

         for(int var9 = ((Collection)this.controls).size(); i < var9; ++i) {
            cy += ((f0F)this.contexts.get(i)).method_3583();
            context = (f0F)this.contexts.get(i);
            if ((f13)this.controls.get(i) == this.capturingControl) {
               if (captureCounts) {
                  return new Tuple(new Tuple(this.capturingControl, context), cy - context.method_3583());
               }

               f13 var10000 = this.capturingControl;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               if (var10000.method_25(context, x, (double)cy - y, ClickGui.Companion.getSettings())) {
                  return new Tuple(new Tuple(this.capturingControl, context), cy - context.method_3583());
               }
            }
         }
      }

      cy = this.this$0.this$0.getSEGHEIGHT();
      int i = 0;

      for(i = ((Collection)this.controls).size(); i < i; ++i) {
         f0F context = (f0F)this.contexts.get(i);
         cy += context.method_3583();
         if (y <= (double)cy) {
            return new Tuple(new Tuple(this.controls.get(i), context), cy - context.method_3583());
         }
      }

      return null;
   }

   public final double getYOfControl(@NotNull f13 control) {
      Intrinsics.checkParameterIsNotNull(control, "control");
      int y = this.this$0.this$0.getSEGHEIGHT();
      int i = 0;

      for(int var4 = ((Collection)this.controls).size(); i < var4; ++i) {
         if ((f13)this.controls.get(i) == control) {
            return (double)y;
         }
      }

      return 0.0D;
   }

   protected final void buildContexts() {
      this.contexts.clear();
      int i = 0;

      for(int var2 = ((Collection)this.controls).size(); i < var2; ++i) {
         List var10000 = this.contexts;
         Supplier var10003 = (Supplier)(new ClickGui$Window$Module$buildContexts$1(this));
         Runnable var10004 = (Runnable)(new ClickGui$Window$Module$buildContexts$2(this));
         BiFunction var10006 = (BiFunction)(new ClickGui$Window$Module$buildContexts$3(this, i));
         FontRenderer var10007 = ClickGui.access$getFontRenderer$p(this.this$0.this$0);
         Intrinsics.checkExpressionValueIsNotNull(var10007, "fontRenderer");
         var10000.add(new f0F(var10003, var10004, 0, var10006, var10007));
      }

   }

   protected final void updateControlSizes() {
      this.height_ = this.this$0.this$0.getSEGHEIGHT();
      int i = 0;

      for(int var2 = ((Collection)this.controls).size(); i < var2; ++i) {
         f13 control = (f13)this.controls.get(i);
         f0F context = (f0F)this.contexts.get(i);
         int controlHeight = control.method_26(context, ClickGui.Companion.getSettings());
         context.method_3578(controlHeight);
         int controlWidth = control.method_29(context, ClickGui.Companion.getSettings());
         if (controlWidth > this.this$0.this$0.getModuleWidth()) {
            this.this$0.this$0.setModuleWidth(controlWidth);
         }

         this.height_ += controlHeight;
      }

      this.this$0.updateModulePositions();
   }

   public final int getHeight() {
      Object var10000 = this.expanded.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "expanded.value");
      return (Boolean)var10000 ? this.height_ : this.this$0.this$0.getSEGHEIGHT();
   }

   public final boolean contains(double y) {
      Object var10001 = this.field_2623.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "this.y.value");
      return Double.compare(y, ((Number)var10001).doubleValue()) >= 0 && y <= (double)(((Number)this.field_2623.method_3034()).intValue() + this.getHeight());
   }

   public final boolean isOnTop(double x, double y) {
      return this.this$0.isOnTop(x, ((Number)this.field_2623.method_3034()).doubleValue() + y);
   }

   public final void onClickedElsewhere() {
      Iterator var2 = this.controls.iterator();

      while(var2.hasNext()) {
         f13 control = (f13)var2.next();
         control.method_20();
      }

   }

   public final boolean isCapturing(double mouseX, double mouseY) {
      int y = this.this$0.this$0.getSEGHEIGHT();
      int i = 0;

      for(int var7 = ((Collection)this.controls).size(); i < var7; ++i) {
         f13 control = (f13)this.controls.get(i);
         f0F context = (f0F)this.contexts.get(i);
         if (control.method_21(context, mouseX, mouseY - (double)y, ClickGui.Companion.getSettings())) {
            this.capturingControl = control;
            this.captureEvents = control.method_25(context, mouseX, mouseY - (double)y, ClickGui.Companion.getSettings());
            return true;
         }

         y += context.method_3583();
      }

      this.capturingControl = (f13)null;
      this.captureEvents = false;
      return false;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final void setName(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.name = var1;
   }

   public ClickGui$Window$Module(@NotNull ClickGui$Window $outer, @NotNull String name, @NotNull List controls, @NotNull Consumer handler, @NotNull class_6 hotkey, @NotNull class_6 expanded, class_6 y) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(controls, "controls");
      Intrinsics.checkParameterIsNotNull(handler, "handler");
      Intrinsics.checkParameterIsNotNull(hotkey, "hotkey");
      Intrinsics.checkParameterIsNotNull(expanded, "expanded");
      Intrinsics.checkParameterIsNotNull(y, "y");
      this.this$0 = $outer;
      super();
      this.name = name;
      this.height_ = $outer.this$0.getSEGHEIGHT();
      this.controls = controls;
      this.contexts = (List)(new ArrayList());
      this.handler = handler;
      this.expanded = expanded;
      this.field_2623 = y;
      controls.add(new f0S("Key", hotkey));
      this.buildContexts();
      int var10000 = ClickGui.access$getFontRenderer$p($outer.this$0).getStringWidth(this.name);
      ClickGui.Companion.getSettings();
      if (var10000 + f0H.field_2335 * 2 > $outer.this$0.getModuleWidth()) {
         ClickGui var8 = $outer.this$0;
         int var10001 = ClickGui.access$getFontRenderer$p($outer.this$0).getStringWidth(this.name);
         ClickGui.Companion.getSettings();
         var8.setModuleWidth(var10001 + f0H.field_2335 * 2);
      }

      this.updateControlSizes();
   }
}
