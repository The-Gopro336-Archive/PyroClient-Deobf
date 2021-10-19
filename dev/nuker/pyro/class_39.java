/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// $FF: renamed from: dev.nuker.pyro.fX
public class class_39 {
   // $FF: renamed from: c dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2636;
   // $FF: renamed from: 0 dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2637;
   // $FF: renamed from: 1 dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2638;
   // $FF: renamed from: c java.lang.String
   @Nullable
   public String field_2639;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_2640;

   // $FF: renamed from: c (dev.nuker.pyro.fw) void
   public void method_3985(@NotNull class_6 var1) {
      this.field_2636 = var1;
   }

   // $FF: renamed from: 4 () java.util.List
   @NotNull
   public List method_3986() {
      return (List)this.field_2640.stream().filter((Predicate)class_41.field_2642).collect(Collectors.toList());
   }

   // $FF: renamed from: 2 () java.lang.String
   @Nullable
   public String method_3987() {
      return this.field_2639;
   }

   public class_39(@Nullable String var1, @NotNull List var2) {
      this.field_2639 = var1;
      this.field_2640 = var2;
      this.field_2636 = (class_6)(new class_7(false, (Consumer)class_19.field_2279));
      this.field_2637 = (class_6)(new class_7(0.0D, (Consumer)class_20.field_2280));
      this.field_2638 = (class_6)(new class_7(0.0D, (Consumer)class_40.field_2641));
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fw) void
   public void method_3988(@NotNull class_6 var1) {
      this.field_2638 = var1;
   }

   // $FF: renamed from: 3 () java.util.List
   @NotNull
   public List method_3989() {
      return this.field_2640;
   }

   // $FF: renamed from: c (dev.nuker.pyro.Module) void
   public void method_3990(@NotNull Module var1) {
      this.field_2640.add(var1);
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3991() {
      return this.field_2637;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3992() {
      return this.field_2636;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_3993(@NotNull List var1) {
      this.field_2640 = var1;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3994(@Nullable String var1) {
      this.field_2639 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.gui.ClickGui) void
   public void method_3995(@NotNull ClickGui var1) {
      String var10001 = this.field_2639;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var1.addWindow(var10001, (Consumer)(new class_38(this)), this.field_2637, this.field_2638, this.field_2636);
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fw) void
   public void method_3996(@NotNull class_6 var1) {
      this.field_2637 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3997() {
      return this.field_2638;
   }

   public class_39(@Nullable String var1, @NotNull Module... var2) {
      this(var1, (List)(new ArrayList((Collection)Arrays.asList((Module[])Arrays.copyOf(var2, var2.length)))));
   }
}
