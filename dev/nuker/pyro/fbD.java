/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public class fbD extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_735 = (f0l)this.register((f0w)(new f0l("overworld", "Overworld", (String)null, new f00(0.5416667F, 1.0F, 0.9F, 0.5F))));
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_736 = (f0l)this.register((f0w)(new f0l("nether", "Nether", (String)null, new f00(0.0F, 0.81F, 0.31F, 0.5F))));
   // $FF: renamed from: 1 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_737 = (f0l)this.register((f0w)(new f0l("end", "End", (String)null, new f00(0.0F, 0.0F, 0.0F, 0.5F))));

   // $FF: renamed from: 0 (dev.nuker.pyro.f0l) void
   public void method_1076(@NotNull f0l var1) {
      this.field_736 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1077() {
      return this.field_735;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0l) void
   public void method_1078(@NotNull f0l var1) {
      this.field_737 = var1;
   }

   // $FF: renamed from: 1 () net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_1079() {
      switch(this.c.player.dimension) {
      case -1:
         return new Vec3d((double)((f00)this.field_736.c()).meth7(), (double)((f00)this.field_736.c()).method_3446(), (double)((f00)this.field_736.c()).meth22());
      case 0:
         return new Vec3d((double)((f00)this.field_735.c()).meth7(), (double)((f00)this.field_735.c()).method_3446(), (double)((f00)this.field_735.c()).meth22());
      case 1:
         return new Vec3d((double)((f00)this.field_737.c()).meth7(), (double)((f00)this.field_737.c()).method_3446(), (double)((f00)this.field_737.c()).meth22());
      default:
         return new Vec3d((double)((f00)this.field_735.c()).meth7(), (double)((f00)this.field_735.c()).method_3446(), (double)((f00)this.field_735.c()).meth22());
      }
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.f0l) void
   public void method_1080(@NotNull f0l var1) {
      this.field_735 = var1;
   }

   // $FF: renamed from: 3 () float[]
   @NotNull
   public float[] method_1081() {
      switch(this.c.player.dimension) {
      case -1:
         return new float[]{((f00)this.field_736.c()).meth7(), ((f00)this.field_736.c()).method_3446(), ((f00)this.field_736.c()).meth22(), ((f00)this.field_736.c()).meth9()};
      case 0:
         return new float[]{((f00)this.field_735.c()).meth7(), ((f00)this.field_735.c()).method_3446(), ((f00)this.field_735.c()).meth22(), ((f00)this.field_735.c()).meth9()};
      case 1:
         return new float[]{((f00)this.field_737.c()).meth7(), ((f00)this.field_737.c()).method_3446(), ((f00)this.field_737.c()).meth22(), ((f00)this.field_737.c()).meth9()};
      default:
         return new float[]{((f00)this.field_735.c()).meth7(), ((f00)this.field_735.c()).method_3446(), ((f00)this.field_735.c()).meth22(), ((f00)this.field_735.c()).meth9()};
      }
   }

   public fbD() {
      super("skycolor", "SkyColor", (String)null);
   }

   // $FF: renamed from: 4 () float
   public float method_1082() {
      switch(this.c.player.dimension) {
      case -1:
         return ((f00)this.field_736.c()).meth9();
      case 0:
         return ((f00)this.field_735.c()).meth9();
      case 1:
         return ((f00)this.field_737.c()).meth9();
      default:
         return ((f00)this.field_735.c()).meth9();
      }
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1083() {
      return this.field_736;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1084() {
      return this.field_737;
   }
}
