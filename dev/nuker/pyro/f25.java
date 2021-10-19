/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f25 extends Lambda implements Function2 {
   // $FF: renamed from: c dev.nuker.pyro.f25
   public static f25 field_7 = new f25();

   public Object invoke(Object var1, Object var2) {
      this.method_50((String)var1, (Function1)var2);
      return Unit.INSTANCE;
   }

   // $FF: renamed from: c (java.lang.String, kotlin.jvm.functions.Function1) void
   public void method_50(@NotNull String var1, @NotNull Function1 var2) {
      f3e var10000 = f3e.field_2142;
      TextComponentString var10001 = new TextComponentString;
      boolean var3 = (Boolean)var2.invoke(true);
      String var10003;
      if (var3) {
         var10003 = TextFormatting.GREEN + "Overwrote " + var1 + " friends list with pyro friends list";
      } else {
         if (var3) {
            throw new NoWhenBranchMatchedException();
         }

         var10003 = TextFormatting.RED + "Could not access " + var1 + " friends list";
      }

      var10001.<init>(var10003);
      var10000.method_3218((ITextComponent)var10001);
   }

   public f25() {
      super(2);
   }
}
