/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.GuiChatAccessor;
import kotlin.TypeCastException;
import net.minecraft.client.gui.GuiChat;

public class f4M extends GuiChat {
   // $FF: renamed from: c int
   public int field_2150;
   // $FF: renamed from: c dev.nuker.pyro.f4N
   public f4N field_2151;
   // $FF: renamed from: c java.lang.String
   public String field_2152;

   public f4M(f4N var1, String var2, String var3) {
      this.field_2151 = var1;
      this.field_2152 = var2;
      super(var3);
      this.field_2150 = f4N.method_3239(var1);
   }

   // $FF: renamed from: c () int
   public int method_3223() {
      return this.field_2150;
   }

   // $FF: renamed from: c (int) void
   public void method_3224(int var1) {
      this.field_2150 = var1;
   }

   public void keyTyped(char var1, int var2) {
      if (this == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiChatAccessor");
      } else {
         ((GuiChatAccessor)this).setHistoryCursor(this.field_2150);
         super.keyTyped(var1, var2);
         this.field_2150 = ((GuiChatAccessor)this).getHistoryCursor();
      }
   }
}
