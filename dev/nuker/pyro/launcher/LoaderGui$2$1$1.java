/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kotlin.Metadata;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"},
   d2 = {"<anonymous>", "", "it", "Ljava/awt/event/ActionEvent;", "kotlin.jvm.PlatformType", "actionPerformed"}
)
final class LoaderGui$2$1$1 implements ActionListener {
   public static final LoaderGui$2$1$1 INSTANCE = new LoaderGui$2$1$1();

   public final void actionPerformed(ActionEvent it) {
      PyroClientLoadingPlugin.shutdown();
   }
}
