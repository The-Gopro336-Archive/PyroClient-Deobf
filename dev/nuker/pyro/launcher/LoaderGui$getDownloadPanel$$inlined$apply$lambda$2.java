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

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2={"<anonymous>", "", "it", "Ljava/awt/event/ActionEvent;", "kotlin.jvm.PlatformType", "actionPerformed", "dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$4", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$6"})
final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$2
implements ActionListener {
    final /* synthetic */ JComboBox Field978;
    final /* synthetic */ JComboBox Field979;
    final /* synthetic */ JButton Field980;
    final /* synthetic */ Map Field981;
    final /* synthetic */ Function0 Field982;
    final /* synthetic */ Function2 Field983;

    LoaderGui$getDownloadPanel$$inlined$apply$lambda$2(JComboBox jComboBox, JComboBox jComboBox2, JButton jButton, Map map, Function0 function0, Function2 function2) {
        this.Field978 = jComboBox;
        this.Field979 = jComboBox2;
        this.Field980 = jButton;
        this.Field981 = map;
        this.Field982 = function0;
        this.Field983 = function2;
    }

    @Override
    public final void actionPerformed(ActionEvent it) {
        this.Field982.Method945();
    }
}

