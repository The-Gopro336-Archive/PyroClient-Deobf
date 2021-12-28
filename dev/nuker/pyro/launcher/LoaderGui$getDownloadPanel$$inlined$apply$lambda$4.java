/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
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

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0007\u00b8\u0006\b"}, d2={"dev/nuker/pyro/launcher/LoaderGui$getDownloadPanel$1$1$6", "Ljava/awt/event/FocusListener;", "focusGained", "", "e", "Ljava/awt/event/FocusEvent;", "focusLost", "pyroclient", "dev/nuker/pyro/launcher/LoaderGui$$special$$inlined$apply$lambda$8"})
public final class LoaderGui$getDownloadPanel$$inlined$apply$lambda$4
implements FocusListener {
    final /* synthetic */ JComboBox Field966;
    final /* synthetic */ JComboBox Field967;
    final /* synthetic */ JButton Field968;
    final /* synthetic */ Map Field969;
    final /* synthetic */ Function0 Field970;
    final /* synthetic */ Function2 Field971;

    LoaderGui$getDownloadPanel$$inlined$apply$lambda$4(JComboBox jComboBox, JComboBox jComboBox2, JButton jButton, Map map, Function0 function0, Function2 function2) {
        this.Field966 = jComboBox;
        this.Field967 = jComboBox2;
        this.Field968 = jButton;
        this.Field969 = map;
        this.Field970 = function0;
        this.Field971 = function2;
    }

    @Override
    public void focusLost(@Nullable FocusEvent e) {
    }

    @Override
    public void focusGained(@Nullable FocusEvent e) {
        this.Field970.Method945();
        this.Field968.setEnabled(true);
    }
}

