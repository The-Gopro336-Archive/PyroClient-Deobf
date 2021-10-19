/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"},
   d2 = {"<anonymous>", "", "invoke", "dev/nuker/pyro/launcher/LoaderGui$1$1"}
)
final class LoaderGui$$special$$inlined$apply$lambda$11 extends Lambda implements Function0 {
   // $FF: synthetic field
   final LoaderGui$ImgBkg $img;
   // $FF: synthetic field
   final LoaderGui this$0;
   // $FF: synthetic field
   final LoaderGui $base$inlined;

   LoaderGui$$special$$inlined$apply$lambda$11(LoaderGui$ImgBkg var1, LoaderGui var2, LoaderGui var3) {
      super(0);
      this.$img = var1;
      this.this$0 = var2;
      this.$base$inlined = var3;
   }

   public final void invoke() {
      while(true) {
         Thread.sleep(1L);
         double var1 = this.this$0.getProgress();
         LoaderGui$ImgBkg var10000;
         if (var1 == -1.0D) {
            if (LoaderGui.access$getLDir$p(this.this$0) == 1) {
               var10000 = this.$img;
               var10000.setLightness(var10000.getLightness() + 5.0E-4F);
               if (this.$img.getLightness() > 1.0F) {
                  LoaderGui.access$setLDir$p(this.this$0, -1);
               }
            } else {
               var10000 = this.$img;
               var10000.setLightness(var10000.getLightness() - 5.0E-4F);
               if (this.$img.getLightness() < 0.6F) {
                  LoaderGui.access$setLDir$p(this.this$0, 1);
               }
            }

            this.$base$inlined.repaint();
         } else if (var1 == -2.0D) {
            if ((double)this.$img.getLightness() < 1.0D) {
               var10000 = this.$img;
               var10000.setLightness(var10000.getLightness() + 5.0E-4F);
               this.$base$inlined.repaint();
            }
         } else if (var1 == -5.0D) {
            if ((double)this.$img.getLightness() < 1.0D || (double)this.$img.getRedLightness() < 1.0D) {
               if (this.$img.getLightness() < 0.35F) {
                  var10000 = this.$img;
                  var10000.setLightness(var10000.getLightness() + 5.0E-4F);
               } else if (this.$img.getLightness() > 0.4F) {
                  var10000 = this.$img;
                  var10000.setLightness(var10000.getLightness() - 5.0E-4F);
               }

               if ((double)this.$img.getRedLightness() > 1.0D) {
                  var10000 = this.$img;
                  var10000.setRedLightness(var10000.getRedLightness() - 5.0E-4F);
               } else if ((double)this.$img.getRedLightness() < 0.9D) {
                  if (this.$img.getRedLightness() < this.$img.getLightness()) {
                     this.$img.setRedLightness(this.$img.getLightness());
                  }

                  var10000 = this.$img;
                  var10000.setRedLightness(var10000.getRedLightness() + 0.002F);
               }

               this.$base$inlined.repaint();
            }
         } else if (var1 == -3.0D) {
            if ((double)this.$img.getLightness() > 0.5D) {
               var10000 = this.$img;
               var10000.setLightness(var10000.getLightness() - 0.001F);
               this.$base$inlined.repaint();
            }
         } else {
            if ((double)this.$img.getLightness() > 0.5D) {
               var10000 = this.$img;
               var10000.setLightness(var10000.getLightness() - 0.001F);
               this.$base$inlined.repaint();
            }

            if (this.$img.getPercent() != this.this$0.getProgress()) {
               this.$img.setPercent(this.this$0.getProgress());
               this.$base$inlined.repaint();
            }
         }

         this.$img.onProgress();
      }
   }
}
