/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"},
   d2 = {"<anonymous>", "", "it", "Ljava/awt/event/ActionEvent;", "kotlin.jvm.PlatformType", "actionPerformed", "dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$4", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$6"}
)
final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$2 implements ActionListener {
   // $FF: synthetic field
   final JComboBox $channelBox$inlined;
   // $FF: synthetic field
   final JComboBox $versionBox$inlined;
   // $FF: synthetic field
   final JButton $button$inlined;
   // $FF: synthetic field
   final Map $versionmap$inlined;
   // $FF: synthetic field
   final Function0 $stopCallback$inlined;
   // $FF: synthetic field
   final Function2 $selectCallback$inlined;

   LoaderGui$getDownloadPanel$$inlined$apply$lambda$2(JComboBox var1, JComboBox var2, JButton var3, Map var4, Function0 var5, Function2 var6) {
      this.$channelBox$inlined = var1;
      this.$versionBox$inlined = var2;
      this.$button$inlined = var3;
      this.$versionmap$inlined = var4;
      this.$stopCallback$inlined = var5;
      this.$selectCallback$inlined = var6;
   }

   public final void actionPerformed(ActionEvent it) {
      this.$stopCallback$inlined.invoke();
   }
}
