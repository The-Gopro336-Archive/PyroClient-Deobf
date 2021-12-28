/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.launcher;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2={"<anonymous>", "", "it", "Ljava/awt/event/ItemEvent;", "kotlin.jvm.PlatformType", "itemStateChanged", "dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$2", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$5"})
final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$1
implements ItemListener {
    final /* synthetic */ JComboBox Field960;
    final /* synthetic */ JComboBox Field961;
    final /* synthetic */ JButton Field962;
    final /* synthetic */ Map Field963;
    final /* synthetic */ Function0 Field964;
    final /* synthetic */ Function2 Field965;

    LoaderGui$getDownloadPanel$$inlined$apply$lambda$1(JComboBox jComboBox, JComboBox jComboBox2, JButton jButton, Map map, Function0 function0, Function2 function2) {
        this.Field960 = jComboBox;
        this.Field961 = jComboBox2;
        this.Field962 = jButton;
        this.Field963 = map;
        this.Field964 = function0;
        this.Field965 = function2;
    }

    @Override
    public final void itemStateChanged(ItemEvent it) {
        this.Field961.removeAllItems();
        Map map = this.Field963;
        Object object = this.Field960.getSelectedItem();
        boolean bl = false;
        Object v = map.get(object);
        if (v == null) {
            Intrinsics.Method6551();
        }
        Object[] $this$forEach$iv = (Object[])v;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it2 = (String)element$iv;
            boolean bl2 = false;
            this.Field961.addItem(it2);
        }
    }
}

