/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityPlayerSPAccessor;
import dev.nuker.pyro.mixin.PlayerControllerMPAccessor;
import kotlin.TypeCastException;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;

public class f8l extends Module {
   // $FF: renamed from: c boolean
   public boolean field_277;
   // $FF: renamed from: 0 boolean
   public boolean field_278;

   // $FF: renamed from: c () void
   public void method_399() {
      PlayerControllerMP var10000 = this.c.playerController;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.PlayerControllerMPAccessor");
      } else {
         ((PlayerControllerMPAccessor)var10000).setIsHittingBlock(this.field_277);
      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_400(boolean var1) {
      this.field_277 = var1;
   }

   // $FF: renamed from: 4 () boolean
   public boolean method_401() {
      return this.field_278;
   }

   public f8l() {
      super("MultiTask", "MultiTask", "Allows you to click while mining");
   }

   // $FF: renamed from: 0 () void
   public void method_402() {
      this.field_278 = this.c.player.isHandActive();
      EntityPlayerSP var10000 = this.c.player;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityPlayerSPAccessor");
      } else {
         ((EntityPlayerSPAccessor)var10000).setHandActive(false);
      }
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_403() {
      return this.field_277;
   }

   // $FF: renamed from: 1 () void
   public void method_404() {
      this.field_277 = this.c.playerController.getIsHittingBlock();
      PlayerControllerMP var10000 = this.c.playerController;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.PlayerControllerMPAccessor");
      } else {
         ((PlayerControllerMPAccessor)var10000).setIsHittingBlock(false);
      }
   }

   // $FF: renamed from: 3 () void
   public void method_405() {
      EntityPlayerSP var10000 = this.c.player;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityPlayerSPAccessor");
      } else {
         ((EntityPlayerSPAccessor)var10000).setHandActive(this.field_278);
      }
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_406(boolean var1) {
      this.field_278 = var1;
   }
}
