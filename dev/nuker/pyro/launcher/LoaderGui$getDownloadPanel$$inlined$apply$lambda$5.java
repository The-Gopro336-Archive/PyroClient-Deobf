/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\b"},
   d2 = {"dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$7", "Ljava/awt/event/FocusListener;", "focusGained", "", "e", "Ljava/awt/event/FocusEvent;", "focusLost", "pyroclient", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$9"}
)
public final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$5 implements FocusListener {
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

   LoaderGui$getDownloadPanel$$inlined$apply$lambda$5(JComboBox var1, JComboBox var2, JButton var3, Map var4, Function0 var5, Function2 var6) {
      this.$channelBox$inlined = var1;
      this.$versionBox$inlined = var2;
      this.$button$inlined = var3;
      this.$versionmap$inlined = var4;
      this.$stopCallback$inlined = var5;
      this.$selectCallback$inlined = var6;
   }

   public void focusLost(@Nullable FocusEvent e) {
   }

   public void focusGained(@Nullable FocusEvent e) {
      this.$stopCallback$inlined.invoke();
      this.$button$inlined.setEnabled(true);
   }
}
