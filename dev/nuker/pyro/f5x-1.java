/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import org.jetbrains.annotations.Nullable;

public class f5x implements Predicate {
   // $FF: renamed from: c dev.nuker.pyro.f5x
   public static f5x field_1735 = new f5x();

   // $FF: renamed from: c (net.minecraft.tileentity.TileEntity) boolean
   public boolean method_2973(@Nullable TileEntity var1) {
      return var1 instanceof TileEntityChest;
   }

   public boolean test(Object var1) {
      return this.method_2973((TileEntity)var1);
   }
}
