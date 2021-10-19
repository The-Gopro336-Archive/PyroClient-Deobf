/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class fd7 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_884 = new BooleanSetting("fire", "Fire", "Prevents walking into fire", true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_885 = new BooleanSetting("cactus", "Cactus", "Prevents walking into cactus", true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_886 = new BooleanSetting("unloaded", "Unloaded", "Prevents walking into unloaded chunks", true);

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable) void
   public void method_1316(BlockPos var1, CallbackInfoReturnable var2) {
      if (this.c.world != null && (Boolean)this.c.method_3034()) {
         Block var3 = feg.method_1779(var1);
         if (var3.equals(Blocks.FIRE) && (Boolean)this.field_884.c() || var3.equals(Blocks.CACTUS) && (Boolean)this.field_885.c() || (!this.c.world.isBlockLoaded(var1, false) || var1.getY() < 0) && (Boolean)this.field_886.c()) {
            var2.cancel();
            var2.setReturnValue(Block.FULL_BLOCK_AABB);
         }

      }
   }

   public fd7() {
      super("avoid", "Avoid", "Avoids fire, cactus and optionally unloaded chunks");
      this.register(this.field_884);
      this.register(this.field_885);
      this.register(this.field_886);
   }
}
