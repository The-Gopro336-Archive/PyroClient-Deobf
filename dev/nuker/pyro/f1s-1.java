/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f1s {
   // $FF: renamed from: c java.util.Map
   @NotNull
   public Map field_2005;

   // $FF: renamed from: c () java.util.Map
   @NotNull
   public Map method_3081() {
      return this.field_2005;
   }

   // $FF: renamed from: c (java.util.Map) void
   public void method_3082(@NotNull Map var1) {
      this.field_2005 = var1;
   }

   public f1s() {
      boolean var1 = false;
      Map var3 = (Map)(new LinkedHashMap());
      this.field_2005 = var3;
   }

   // $FF: renamed from: c (net.minecraft.util.text.ITextComponent) void
   public void method_3083(@Nullable ITextComponent var1) {
      Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((new TextComponentString("")).appendSibling(Pyro.getPrefix()).appendSibling(var1));
   }

   // $FF: renamed from: c (java.lang.String, java.lang.Object) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3084(@NotNull String var1, @Nullable Object var2) {
      this.field_2005.put(var1, var2);
      return this;
   }
}
