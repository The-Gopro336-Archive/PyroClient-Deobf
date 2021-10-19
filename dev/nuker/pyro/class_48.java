/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.collect.Lists;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltManager;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;

// $FF: renamed from: dev.nuker.pyro.fm
public class class_48 extends GuiListExtended {
   // $FF: renamed from: c dev.nuker.pyro.fl
   public class_53 field_2672;
   // $FF: renamed from: c java.util.List
   public List field_2673 = Lists.newArrayList();
   // $FF: renamed from: c int
   public int field_2674 = -1;

   // $FF: renamed from: 0 () dev.nuker.pyro.fl
   public class_53 method_4047() {
      return this.field_2672;
   }

   // $FF: renamed from: c () void
   public void method_4048() {
      this.field_2673.clear();
      Iterator var1 = AltManager.INSTANCE.getAlts().iterator();

      while(var1.hasNext()) {
         Alt var2 = (Alt)var1.next();

         try {
            this.field_2673.add(new class_49(this, var2));
         } catch (Exception var4) {
         }
      }

   }

   public int getListWidth() {
      return super.getListWidth() + 50;
   }

   public int getSize() {
      return this.field_2673.size();
   }

   public IGuiListEntry getListEntry(int var1) {
      return this.method_4050(var1);
   }

   // $FF: renamed from: c (int) void
   public void method_4049(int var1) {
      this.field_2674 = var1;
   }

   // $FF: renamed from: 0 (int) dev.nuker.pyro.fn
   public class_49 method_4050(int var1) {
      return (class_49)this.field_2673.get(var1);
   }

   public class_48(class_53 var1, Minecraft var2, int var3, int var4, int var5, int var6, int var7) {
      super(var2, var3, var4, var5, var6, var7);
      this.field_2672 = var1;
      this.method_4048();
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fn
   @Nullable
   public class_49 method_4051() {
      return this.field_2674 >= 0 && this.field_2674 < this.getSize() ? this.method_4050(this.field_2674) : null;
   }

   public int getScrollBarX() {
      return super.getScrollBarX() + 20;
   }

   public boolean isSelected(int var1) {
      return var1 == this.field_2674;
   }
}
