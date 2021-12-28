/*
 * Decompiled with CFR 0.150.
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

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2={"<anonymous>", "", "it", "Ljava/awt/event/ActionEvent;", "kotlin.jvm.PlatformType", "actionPerformed", "dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$5", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$7"})
final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$3
implements ActionListener {
    final /* synthetic */ JComboBox Field984;
    final /* synthetic */ JComboBox Field985;
    final /* synthetic */ JButton Field986;
    final /* synthetic */ Map Field987;
    final /* synthetic */ Function0 Field988;
    final /* synthetic */ Function2 Field989;

    LoaderGui$getDownloadPanel$$inlined$apply$lambda$3(JComboBox jComboBox, JComboBox jComboBox2, JButton jButton, Map map, Function0 function0, Function2 function2) {
        this.Field984 = jComboBox;
        this.Field985 = jComboBox2;
        this.Field986 = jButton;
        this.Field987 = map;
        this.Field988 = function0;
        this.Field989 = function2;
    }

    @Override
    public final void actionPerformed(ActionEvent it) {
        this.Field988.Method945();
        this.Field986.setEnabled(true);
    }
}

