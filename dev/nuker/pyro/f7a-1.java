/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import net.minecraft.network.play.server.SPacketChunkData;
import org.jetbrains.annotations.NotNull;

public class f7a implements Predicate {
   // $FF: renamed from: c net.minecraft.network.play.server.SPacketChunkData
   public SPacketChunkData field_1825;

   public f7a(SPacketChunkData var1) {
      this.field_1825 = var1;
      super();
   }

   public boolean test(Object var1) {
      return this.method_3010((fe3)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe3) boolean
   public boolean method_3010(@NotNull fe3 var1) {
      Integer var10000 = (Integer)var1.method_1960();
      int var2 = this.field_1825.getChunkX();
      boolean var3;
      if (var10000 != null) {
         if (var10000 == var2) {
            var10000 = (Integer)var1.method_1959();
            var2 = this.field_1825.getChunkZ();
            if (var10000 != null) {
               if (var10000 == var2) {
                  var3 = true;
                  return var3;
               }
            }
         }
      }

      var3 = false;
      return var3;
   }
}
