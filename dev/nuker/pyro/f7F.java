/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.net.ServerSocket;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public class f7F extends Lambda implements Function0 {
   // $FF: renamed from: c dev.nuker.pyro.f7G
   public f7G field_46;

   // $FF: renamed from: c () void
   public void method_89() {
      while(true) {
         List var10000 = this.field_46.method_830();
         f7B var10001 = new f7B;
         f7G var10003 = this.field_46;
         ServerSocket var10004 = this.field_46.method_797();
         if (var10004 == null) {
            Intrinsics.throwNpe();
         }

         var10001.<init>(var10003, var10004.accept());
         var10000.add(var10001);
      }
   }

   public Object invoke() {
      this.method_89();
      return Unit.INSTANCE;
   }

   public f7F(f7G var1) {
      this.field_46 = var1;
      super(0);
   }
}
