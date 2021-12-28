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
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2={"<anonymous>", "", "it", "Ljava/awt/event/ActionEvent;", "kotlin.jvm.PlatformType", "actionPerformed", "dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$8", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$10"})
final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$6
implements ActionListener {
    final /* synthetic */ JComboBox Field992;
    final /* synthetic */ JComboBox Field993;
    final /* synthetic */ JButton Field994;
    final /* synthetic */ Map Field995;
    final /* synthetic */ Function0 Field996;
    final /* synthetic */ Function2 Field997;

    LoaderGui$getDownloadPanel$$inlined$apply$lambda$6(JComboBox jComboBox, JComboBox jComboBox2, JButton jButton, Map map, Function0 function0, Function2 function2) {
        this.Field992 = jComboBox;
        this.Field993 = jComboBox2;
        this.Field994 = jButton;
        this.Field995 = map;
        this.Field996 = function0;
        this.Field997 = function2;
    }

    @Override
    public final void actionPerformed(ActionEvent it) {
        Object object = this.Field992.getSelectedItem();
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        Object object2 = this.Field993.getSelectedItem();
        if (object2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        this.Field997.Method943((String)object, (String)object2);
        this.Field994.setEnabled(false);
    }
}

