/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.class_6;
import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002:\u0001EB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ^\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u00101\u001a\u00020\u0018J\u0010\u0010#\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0018H\u0016J\u0018\u00104\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0018H\u0016J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020(H\u0016J\u0018\u0010A\u001a\u00020(2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0016J\u0016\u0010B\u001a\u00020(2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007J\u0018\u0010C\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010D\u001a\u00020(R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\f\u0018\u00010\u0012R\u00060\u0000R\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n0\u0012R\u00060\u0000R\u00020\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u0006F"},
   d2 = {"Ldev/nuker/pyro/gui/ClickGui$Window;", "Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;", "Ldev/nuker/pyro/gui/ClickGui;", "name", "", "x", "Ldev/nuker/pyro/api/AbstractHandledValue;", "", "y", "expanded", "", "(Ldev/nuker/pyro/gui/ClickGui;Ljava/lang/String;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;)V", "captureEvents", "getCaptureEvents", "()Z", "setCaptureEvents", "(Z)V", "capturingModule", "Ldev/nuker/pyro/gui/ClickGui$Window$Module;", "getExpanded", "()Ldev/nuker/pyro/api/AbstractHandledValue;", "setExpanded", "(Ldev/nuker/pyro/api/AbstractHandledValue;)V", "height_", "", "getHeight_", "()I", "setHeight_", "(I)V", "modules", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getX", "setX", "getY", "setY", "addModule", "", "module", "enabled", "controls", "Ldev/nuker/pyro/api/ui/control/UiControl;", "handler", "Ljava/util/function/Consumer;", "hotkey", "contains", "getHeight", "width", "height", "headerContains", "isCapturing", "mouseX", "mouseY", "isOnTop", "keyTyped", "typedChar", "", "keyCode", "mouseEvent", "event", "Ldev/nuker/pyro/api/ui/mouse/MouseEvent;", "onClickedElsewhere", "render", "renderCapture", "setPosition", "updateModulePositions", "Module", "pyroclient"}
)
public final class ClickGui$Window extends ClickGui$AbstractWindow {
   private int height_;
   private List modules;
   private ClickGui$Window$Module capturingModule;
   private boolean captureEvents;
   @NotNull
   private String name;
   // $FF: renamed from: x dev.nuker.pyro.fw
   @NotNull
   private class_6 field_2208;
   // $FF: renamed from: y dev.nuker.pyro.fw
   @NotNull
   private class_6 field_2209;
   @NotNull
   private class_6 expanded;
   // $FF: synthetic field
   final ClickGui this$0;

   public final int getHeight_() {
      return this.height_;
   }

   public final void setHeight_(int var1) {
      this.height_ = var1;
   }

   public final boolean getCaptureEvents() {
      return this.captureEvents;
   }

   public final void setCaptureEvents(boolean var1) {
      this.captureEvents = var1;
   }

   public boolean headerContains(double x, double y) {
      return this.contains(x, y) && y <= ((Number)this.field_2209.method_3034()).doubleValue() + (double)this.this$0.getSEGHEIGHT();
   }

   public final boolean isCapturing(double mouseX, double mouseY) {
      Iterator var6 = this.modules.iterator();

      Object var10003;
      ClickGui$Window$Module module;
      do {
         if (!var6.hasNext()) {
            this.capturingModule = (ClickGui$Window$Module)null;
            this.captureEvents = false;
            return false;
         }

         module = (ClickGui$Window$Module)var6.next();
         var10003 = module.getY().method_3034();
         Intrinsics.checkExpressionValueIsNotNull(var10003, "module.y.value");
      } while(!module.isCapturing(mouseX, mouseY - ((Number)var10003).doubleValue()));

      this.capturingModule = module;
      this.captureEvents = module.getCaptureEvents();
      return true;
   }

   public final void renderCapture(double mouseX, double mouseY) {
      if (this.capturingModule != null) {
         GlStateManager.pushMatrix();
         Object var10000 = this.field_2208.method_3034();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "x.value");
         double var5 = ((Number)var10000).doubleValue();
         double var10001 = ((Number)this.field_2209.method_3034()).doubleValue();
         ClickGui$Window$Module var10002 = this.capturingModule;
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         Object var7 = var10002.getY().method_3034();
         Intrinsics.checkExpressionValueIsNotNull(var7, "capturingModule!!.y.value");
         GlStateManager.translate(var5, var10001 + ((Number)var7).doubleValue(), 0.0D);
         ClickGui$Window$Module var6 = this.capturingModule;
         if (var6 == null) {
            Intrinsics.throwNpe();
         }

         ClickGui$Window$Module var10003 = this.capturingModule;
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         Object var8 = var10003.getY().method_3034();
         Intrinsics.checkExpressionValueIsNotNull(var8, "capturingModule!!.y.value");
         var6.renderCapture(mouseX, mouseY - ((Number)var8).doubleValue());
         GlStateManager.popMatrix();
      }

   }

   public double getX(int width) {
      Object var10000 = this.field_2208.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "x.value");
      return ((Number)var10000).doubleValue();
   }

   public double getY(int height) {
      Object var10000 = this.field_2209.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "y.value");
      return ((Number)var10000).doubleValue();
   }

   public void setPosition(double x, double y) {
      this.field_2208.method_3033(x);
      this.field_2209.method_3033(y);
   }

   public final int getHeight() {
      Object var10000 = this.expanded.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "expanded.value");
      return (Boolean)var10000 ? this.height_ + 1 : this.this$0.getSEGHEIGHT();
   }

   public final boolean isOnTop(double x, double y) {
      return this.this$0.getTopWindow((((Number)this.field_2208.method_3034()).doubleValue() + x) * ClickGui.Companion.getSCALE(), (((Number)this.field_2209.method_3034()).doubleValue() + y) * ClickGui.Companion.getSCALE()) == (ClickGui$Window)this;
   }

   public void keyTyped(char typedChar, int keyCode) {
      Iterator var4 = this.modules.iterator();

      while(var4.hasNext()) {
         ClickGui$Window$Module module = (ClickGui$Window$Module)var4.next();
         module.keyTyped(typedChar, keyCode);
      }

   }

   public void render(double mouseX, double mouseY) {
      ClickGui var10000 = this.this$0;
      int var10001 = ClickGui.access$getFontRenderer$p(this.this$0).getStringWidth(this.name);
      ClickGui.Companion.getSettings();
      var10000.requestModuleWidth(var10001 + f0H.field_2335 * 2);
      GlStateManager.pushMatrix();
      Object var7 = this.field_2208.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var7, "x.value");
      double var8 = ((Number)var7).doubleValue();
      Object var10 = this.field_2209.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10, "y.value");
      GlStateManager.translate(var8, ((Number)var10).doubleValue(), 0.0D);
      f0J.method_3558(0, 0, this.this$0.getModuleWidth(), this.getHeight() + 1, ClickGui.Companion.getSettings().method_3490(), ClickGui.Companion.getSettings().method_3505(), 1);
      f0J var9 = f0J.field_2340;
      FontRenderer var11 = ClickGui.access$getFontRenderer$p(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(var11, "fontRenderer");
      String var10002 = this.name;
      int var10005 = this.this$0.getModuleWidth();
      int var10006 = this.this$0.getSEGHEIGHT();
      ClickGui.Companion.getSettings();
      f0G var10007 = f0H.field_2336;
      ClickGui.Companion.getSettings();
      f0J.method_3555(var9, var11, var10002, 0, 0, var10005, var10006, var10007, f0H.field_2335, ClickGui.Companion.getSettings().method_3494(), false, 512, (Object)null);
      var7 = this.expanded.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var7, "expanded.value");
      if ((Boolean)var7) {
         Gui.drawRect(0, this.this$0.getSEGHEIGHT(), this.this$0.getModuleWidth(), this.this$0.getSEGHEIGHT() + 1, ClickGui.Companion.getSettings().method_3505());
         Iterator var6 = this.modules.iterator();

         while(var6.hasNext()) {
            ClickGui$Window$Module module = (ClickGui$Window$Module)var6.next();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0D, (double)((Number)module.getY().method_3034()).intValue(), 0.0D);
            Object var10003 = module.getY().method_3034();
            Intrinsics.checkExpressionValueIsNotNull(var10003, "module.y.value");
            module.render(mouseX, mouseY - ((Number)var10003).doubleValue());
            GlStateManager.popMatrix();
         }
      }

      GlStateManager.popMatrix();
   }

   public final void addModule(@Nullable String module, boolean enabled, @NotNull List controls, @NotNull Consumer handler, @NotNull class_6 hotkey, @NotNull class_6 expanded, @NotNull class_6 y) {
      Intrinsics.checkParameterIsNotNull(controls, "controls");
      Intrinsics.checkParameterIsNotNull(handler, "handler");
      Intrinsics.checkParameterIsNotNull(hotkey, "hotkey");
      Intrinsics.checkParameterIsNotNull(expanded, "expanded");
      Intrinsics.checkParameterIsNotNull(y, "y");
      ClickGui$Window$Module var10000 = new ClickGui$Window$Module;
      if (module == null) {
         Intrinsics.throwNpe();
      }

      var10000.<init>(this, module, controls, handler, hotkey, expanded, y);
      ClickGui$Window$Module module1 = var10000;
      module1.setEnabled(enabled);
      this.modules.add(module1);
      this.updateModulePositions();
   }

   public final void updateModulePositions() {
      this.height_ = this.this$0.getSEGHEIGHT();

      ClickGui$Window$Module module;
      for(Iterator var2 = this.modules.iterator(); var2.hasNext(); this.height_ += module.getHeight()) {
         module = (ClickGui$Window$Module)var2.next();
         module.getY().method_3033(this.height_ + 1);
      }

   }

   public boolean contains(double x, double y) {
      Object var10001 = this.field_2208.method_3034();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "this.x.value");
      boolean var10000;
      if (x >= ((Number)var10001).doubleValue()) {
         var10001 = this.field_2209.method_3034();
         Intrinsics.checkExpressionValueIsNotNull(var10001, "this.y.value");
         if (y >= ((Number)var10001).doubleValue() && x <= ((Number)this.field_2208.method_3034()).doubleValue() + (double)this.this$0.getModuleWidth() && y <= ((Number)this.field_2209.method_3034()).doubleValue() + (double)this.getHeight()) {
            var10000 = true;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   public void mouseEvent(@NotNull f17 event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Object var10000;
      double var10001;
      double var10002;
      ClickGui$Window$Module module;
      ClickGui$Window$Module var10003;
      Iterator var3;
      ClickGui$Window$Module var4;
      Object var5;
      if (event instanceof f16) {
         if (((f16)event).method_3658() > (double)this.this$0.getSEGHEIGHT()) {
            var10000 = this.expanded.method_3034();
            Intrinsics.checkExpressionValueIsNotNull(var10000, "expanded.value");
            if ((Boolean)var10000) {
               label161: {
                  if (this.capturingModule != null && this.captureEvents) {
                     var4 = this.capturingModule;
                     if (var4 == null) {
                        Intrinsics.throwNpe();
                     }

                     var10001 = ((f16)event).method_3660();
                     var10002 = ((f16)event).method_3658();
                     var10003 = this.capturingModule;
                     if (var10003 == null) {
                        Intrinsics.throwNpe();
                     }

                     var5 = var10003.getY().method_3034();
                     Intrinsics.checkExpressionValueIsNotNull(var5, "capturingModule!!.y.value");
                     if (var4.isCapturing(var10001, var10002 - ((Number)var5).doubleValue())) {
                        var4 = this.capturingModule;
                        if (var4 == null) {
                           Intrinsics.throwNpe();
                        }

                        var10003 = this.capturingModule;
                        if (var10003 == null) {
                           Intrinsics.throwNpe();
                        }

                        var4.mouseEvent(event.method_3648(0.0D, (double)((Number)var10003.getY().method_3034()).intValue()));
                        break label161;
                     }
                  }

                  var3 = this.modules.iterator();

                  while(var3.hasNext()) {
                     module = (ClickGui$Window$Module)var3.next();
                     if (module.contains(((f16)event).method_3658())) {
                        module.mouseEvent(event.method_3648(0.0D, (double)((Number)module.getY().method_3034()).intValue()));
                        return;
                     }
                  }
               }

               this.updateModulePositions();
            }

            var3 = this.modules.iterator();

            while(var3.hasNext()) {
               module = (ClickGui$Window$Module)var3.next();
               module.onClickedElsewhere();
            }
         }
      } else if (event instanceof f15) {
         if (((f15)event).method_3650() > (double)this.this$0.getSEGHEIGHT()) {
            var10000 = this.expanded.method_3034();
            Intrinsics.checkExpressionValueIsNotNull(var10000, "expanded.value");
            if ((Boolean)var10000) {
               label166: {
                  if (this.capturingModule != null && this.captureEvents) {
                     var4 = this.capturingModule;
                     if (var4 == null) {
                        Intrinsics.throwNpe();
                     }

                     var10001 = ((f15)event).method_3656();
                     var10002 = ((f15)event).method_3650();
                     var10003 = this.capturingModule;
                     if (var10003 == null) {
                        Intrinsics.throwNpe();
                     }

                     var5 = var10003.getY().method_3034();
                     Intrinsics.checkExpressionValueIsNotNull(var5, "capturingModule!!.y.value");
                     if (var4.isCapturing(var10001, var10002 - ((Number)var5).doubleValue())) {
                        var4 = this.capturingModule;
                        if (var4 == null) {
                           Intrinsics.throwNpe();
                        }

                        var10003 = this.capturingModule;
                        if (var10003 == null) {
                           Intrinsics.throwNpe();
                        }

                        var4.mouseEvent(event.method_3648(0.0D, (double)((Number)var10003.getY().method_3034()).intValue()));
                        break label166;
                     }
                  }

                  var3 = this.modules.iterator();

                  while(var3.hasNext()) {
                     module = (ClickGui$Window$Module)var3.next();
                     if (module.contains(((f15)event).method_3650())) {
                        module.mouseEvent(event.method_3648(0.0D, (double)((Number)module.getY().method_3034()).intValue()));
                        return;
                     }
                  }
               }

               this.updateModulePositions();
            }

            var3 = this.modules.iterator();

            while(var3.hasNext()) {
               module = (ClickGui$Window$Module)var3.next();
               module.onClickedElsewhere();
            }
         }
      } else if (event.method_3646() <= (double)this.this$0.getSEGHEIGHT()) {
         if (event.method_3645() == 1 && event instanceof f14) {
            this.expanded.method_3033(!(Boolean)this.expanded.method_3034());
         }
      } else {
         var10000 = this.expanded.method_3034();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "expanded.value");
         if ((Boolean)var10000) {
            if (this.capturingModule != null && this.captureEvents) {
               var4 = this.capturingModule;
               if (var4 == null) {
                  Intrinsics.throwNpe();
               }

               var10003 = this.capturingModule;
               if (var10003 == null) {
                  Intrinsics.throwNpe();
               }

               var4.mouseEvent(event.method_3648(0.0D, (double)((Number)var10003.getY().method_3034()).intValue()));
            } else {
               var3 = this.modules.iterator();

               while(var3.hasNext()) {
                  module = (ClickGui$Window$Module)var3.next();
                  if (module.contains(event.method_3646())) {
                     module.mouseEvent(event.method_3648(0.0D, (double)((Number)module.getY().method_3034()).intValue()));
                     return;
                  }

                  module.onClickedElsewhere();
               }

               this.updateModulePositions();
            }
         }
      }

   }

   public void onClickedElsewhere() {
      Iterator var2 = this.modules.iterator();

      while(var2.hasNext()) {
         ClickGui$Window$Module module = (ClickGui$Window$Module)var2.next();
         module.onClickedElsewhere();
      }

   }

   @NotNull
   protected final String getName() {
      return this.name;
   }

   protected final void setName(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.name = var1;
   }

   @NotNull
   public final class_6 getX() {
      return this.field_2208;
   }

   public final void setX(@NotNull class_6 var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.field_2208 = var1;
   }

   @NotNull
   public final class_6 getY() {
      return this.field_2209;
   }

   public final void setY(@NotNull class_6 var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.field_2209 = var1;
   }

   @NotNull
   protected final class_6 getExpanded() {
      return this.expanded;
   }

   protected final void setExpanded(@NotNull class_6 var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.expanded = var1;
   }

   public ClickGui$Window(@NotNull ClickGui $outer, @NotNull String name, @NotNull class_6 x, @NotNull class_6 y, class_6 expanded) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(x, "x");
      Intrinsics.checkParameterIsNotNull(y, "y");
      Intrinsics.checkParameterIsNotNull(expanded, "expanded");
      this.this$0 = $outer;
      super($outer);
      this.name = name;
      this.field_2208 = x;
      this.field_2209 = y;
      this.expanded = expanded;
      this.height_ = $outer.getSEGHEIGHT();
      this.modules = (List)(new ArrayList());
   }
}
