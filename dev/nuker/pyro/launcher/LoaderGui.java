/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.launcher.LoaderGui$getLinkedPanel$$inlined$apply$lambda$1
 *  dev.nuker.pyro.launcher.LoaderGui$getLoginPanel$$inlined$apply$lambda$1
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.launcher.LoaderGui$$special$$inlined$apply$lambda$11;
import dev.nuker.pyro.launcher.LoaderGui$2$1$1;
import dev.nuker.pyro.launcher.LoaderGui$ImgBkg;
import dev.nuker.pyro.launcher.LoaderGui$getDownloadPanel$$inlined$apply$lambda$1;
import dev.nuker.pyro.launcher.LoaderGui$getDownloadPanel$$inlined$apply$lambda$2;
import dev.nuker.pyro.launcher.LoaderGui$getDownloadPanel$$inlined$apply$lambda$3;
import dev.nuker.pyro.launcher.LoaderGui$getDownloadPanel$$inlined$apply$lambda$4;
import dev.nuker.pyro.launcher.LoaderGui$getDownloadPanel$$inlined$apply$lambda$5;
import dev.nuker.pyro.launcher.LoaderGui$getDownloadPanel$$inlined$apply$lambda$6;
import dev.nuker.pyro.launcher.LoaderGui$getLinkedPanel$;
import dev.nuker.pyro.launcher.LoaderGui$getLoginPanel$;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002JP\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u0018J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ*\u0010\u001d\u001a\u00020\u00042\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006$"}, d2={"Ldev/nuker/pyro/launcher/LoaderGui;", "Ljavax/swing/JFrame;", "()V", "currentPanel", "Ljavax/swing/JPanel;", "lDir", "", "parentPanel", "progress", "", "getProgress", "()D", "setProgress", "(D)V", "getDownloadPanel", "text", "", "versionmap", "", "", "stopCallback", "Lkotlin/Function0;", "", "selectCallback", "Lkotlin/Function2;", "getLinkedPanel", "linktext", "link", "Ljava/net/URI;", "getLoginPanel", "callback", "failure", "getTextPanel", "setUI", "panel", "ImgBkg", "pyroclient"})
public final class LoaderGui
extends JFrame {
    private double Field7515 = -1.0;
    private JPanel Field7516 = this.Method12443("Initializing");
    private int Field7517 = 1;
    private final JPanel Field7518;

    public final double Method12439() {
        return this.Field7515;
    }

    public final void Method12440(double d) {
        this.Field7515 = d;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final JPanel Method12441(@NotNull Function2 callback, @NotNull String failure) {
        void pBox;
        void uBox;
        Intrinsics.Method6567(callback, "callback");
        Intrinsics.Method6567(failure, "failure");
        JPanel jPanel = new JPanel();
        boolean bl = false;
        boolean bl2 = false;
        JPanel $this$apply = jPanel;
        boolean bl3 = false;
        $this$apply.setLayout(new BoxLayout($this$apply, 1));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.Field5552 = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.Field5552 = null;
        Object object = new JPanel();
        JPanel jPanel2 = $this$apply;
        boolean bl4 = false;
        boolean bl5 = false;
        Object $this$apply2 = object;
        boolean bl6 = false;
        ((JComponent)$this$apply2).setBackground(new Color(0, 0, 0, 0));
        ((Container)$this$apply2).setLayout(new BoxLayout((Container)$this$apply2, 0));
        ((Container)$this$apply2).add(Box.createHorizontalStrut(20));
        JComponent jComponent = new JPanel();
        Object object2 = $this$apply2;
        boolean bl7 = false;
        boolean bl8 = false;
        JPanel $this$apply3 = jComponent;
        boolean bl9 = false;
        $this$apply3.setLayout(new BoxLayout($this$apply3, 1));
        JComponent jComponent2 = new JLabel("Username");
        JPanel jPanel3 = $this$apply3;
        boolean bl10 = false;
        boolean bl11 = false;
        JLabel $this$apply4 = jComponent2;
        boolean bl12 = false;
        $this$apply4.setFont(new Font("Arial", 0, 16));
        JLabel jLabel = jComponent2;
        jPanel3.add((Component)jLabel, "South");
        jComponent2 = new JTextField();
        jPanel3 = $this$apply3;
        bl10 = false;
        bl11 = false;
        JComponent it = jComponent2;
        boolean bl13 = false;
        uBox.Field5552 = it;
        jLabel = jComponent2;
        jPanel3.add(jLabel);
        JPanel jPanel4 = jComponent;
        ((Container)object2).add(jPanel4);
        ((Container)$this$apply2).add(Box.createHorizontalStrut(10));
        jComponent = new JPanel();
        object2 = $this$apply2;
        bl7 = false;
        bl8 = false;
        $this$apply3 = jComponent;
        boolean bl14 = false;
        $this$apply3.setLayout(new BoxLayout($this$apply3, 1));
        jComponent2 = new JLabel("Password");
        jPanel3 = $this$apply3;
        bl10 = false;
        bl11 = false;
        $this$apply4 = jComponent2;
        boolean bl15 = false;
        $this$apply4.setFont(new Font("Arial", 0, 16));
        jLabel = jComponent2;
        jPanel3.add((Component)jLabel, "South");
        jComponent2 = new JPasswordField();
        jPanel3 = $this$apply3;
        bl10 = false;
        bl11 = false;
        it = jComponent2;
        boolean bl16 = false;
        pBox.Field5552 = it;
        jLabel = jComponent2;
        jPanel3.add(jLabel);
        jPanel4 = jComponent;
        ((Container)object2).add(jPanel4);
        ((Container)$this$apply2).add(Box.createHorizontalStrut(20));
        Object object3 = object;
        jPanel2.add((Component)object3);
        object = failure;
        bl4 = false;
        if (object.length() == 0) {
            $this$apply.add(Box.createVerticalStrut(25));
        } else {
            $this$apply.add(Box.createVerticalStrut(5));
            object = new JPanel();
            jPanel2 = $this$apply;
            bl4 = false;
            bl5 = false;
            $this$apply2 = object;
            boolean bl17 = false;
            ((Container)$this$apply2).setLayout(new BoxLayout((Container)$this$apply2, 0));
            ((Container)$this$apply2).add(Box.createHorizontalGlue());
            ((Container)$this$apply2).add(new JLabel(failure));
            ((Container)$this$apply2).add(Box.createHorizontalGlue());
            object3 = object;
            jPanel2.add((Component)object3);
            $this$apply.add(Box.createVerticalStrut(5));
        }
        object = new JPanel();
        jPanel2 = $this$apply;
        bl4 = false;
        bl5 = false;
        $this$apply2 = object;
        boolean bl18 = false;
        ((Container)$this$apply2).setLayout(new BoxLayout((Container)$this$apply2, 0));
        ((Container)$this$apply2).add(Box.createHorizontalGlue());
        jComponent = new JButton("Login");
        object2 = $this$apply2;
        bl7 = false;
        bl8 = false;
        $this$apply3 = jComponent;
        boolean bl19 = false;
        $this$apply3.setPreferredSize(new Dimension(200, 25));
        ((AbstractButton)((Object)$this$apply3)).addActionListener((ActionListener)new getLoginPanel$$inlined$apply$lambda$1((Ref.ObjectRef)uBox, (Ref.ObjectRef)pBox, failure, callback));
        jComponent2 = jComponent;
        ((Container)object2).add(jComponent2);
        ((Container)$this$apply2).add(Box.createHorizontalGlue());
        object3 = object;
        jPanel2.add((Component)object3);
        return jPanel;
    }

    public static /* synthetic */ JPanel Method12442(LoaderGui loaderGui, Function2 function2, String string, int n, Object object) {
        if ((n & 2) != 0) {
            string = "";
        }
        return loaderGui.Method12441(function2, string);
    }

    @NotNull
    public final JPanel Method12443(@NotNull String text) {
        Intrinsics.Method6567(text, "text");
        JPanel jPanel = new JPanel();
        boolean bl = false;
        boolean bl2 = false;
        JPanel $this$apply = jPanel;
        boolean bl3 = false;
        $this$apply.setLayout(new BoxLayout($this$apply, 0));
        JLabel jLabel = new JLabel(text);
        JPanel jPanel2 = $this$apply;
        boolean bl4 = false;
        boolean bl5 = false;
        JLabel $this$apply2 = jLabel;
        boolean bl6 = false;
        $this$apply2.setFont(new Font("Arial", 0, 26));
        JLabel jLabel2 = jLabel;
        jPanel2.add(jLabel2);
        return jPanel;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final JPanel Method12444(@NotNull String text, @NotNull String linktext, @NotNull URI link) {
        void fnt;
        Intrinsics.Method6567(text, "text");
        Intrinsics.Method6567(linktext, "linktext");
        Intrinsics.Method6567(link, "link");
        JPanel jPanel = new JPanel();
        boolean bl = false;
        boolean bl2 = false;
        JPanel $this$apply = jPanel;
        boolean bl3 = false;
        $this$apply.setLayout(new BoxLayout($this$apply, 1));
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = $this$apply;
        boolean bl4 = false;
        boolean bl5 = false;
        JPanel $this$apply2 = jPanel2;
        boolean bl6 = false;
        $this$apply2.setLayout(new BoxLayout($this$apply2, 0));
        Serializable serializable = new JLabel(text);
        JPanel jPanel4 = $this$apply2;
        boolean bl7 = false;
        boolean bl8 = false;
        JLabel $this$apply3 = serializable;
        boolean bl9 = false;
        $this$apply3.setFont(new Font("Arial", 0, 26));
        JLabel jLabel = serializable;
        jPanel4.add(jLabel);
        JPanel jPanel5 = jPanel2;
        jPanel3.add(jPanel5);
        $this$apply.add(Box.createVerticalStrut(20));
        jPanel2 = new JPanel();
        jPanel3 = $this$apply;
        bl4 = false;
        bl5 = false;
        $this$apply2 = jPanel2;
        boolean bl10 = false;
        $this$apply2.setLayout(new BoxLayout($this$apply2, 0));
        serializable = new Ref.ObjectRef();
        ((Ref.ObjectRef)serializable).Field5552 = new Font("Arial", 0, 16);
        Map<TextAttribute, ?> map = ((Font)fnt.Field5552).getAttributes();
        if (map == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<java.awt.font.TextAttribute, kotlin.Any?>");
        }
        HashMap attributes = new HashMap(map);
        Map map2 = attributes;
        TextAttribute textAttribute = TextAttribute.UNDERLINE;
        Intrinsics.Method6561(textAttribute, "TextAttribute.UNDERLINE");
        map2.put(textAttribute, TextAttribute.UNDERLINE_ON);
        Font font = ((Font)fnt.Field5552).deriveFont(attributes);
        Intrinsics.Method6561(font, "fnt.deriveFont(attributes)");
        fnt.Field5552 = font;
        JLabel jLabel2 = new JLabel(linktext);
        JPanel jPanel6 = $this$apply2;
        boolean bl11 = false;
        boolean bl12 = false;
        JLabel $this$apply4 = jLabel2;
        boolean bl13 = false;
        $this$apply4.setFont((Font)fnt.Field5552);
        $this$apply4.setCursor(Cursor.getPredefinedCursor(12));
        $this$apply4.addMouseListener((MouseListener)new getLinkedPanel$$inlined$apply$lambda$1((Ref.ObjectRef)fnt, text, linktext, link));
        JLabel jLabel3 = jLabel2;
        jPanel6.add(jLabel3);
        jPanel5 = jPanel2;
        jPanel3.add(jPanel5);
        return jPanel;
    }

    @NotNull
    public final JPanel Method12445(@NotNull String text, @NotNull Map versionmap, @NotNull Function0 stopCallback, @NotNull Function2 selectCallback) {
        Intrinsics.Method6567(text, "text");
        Intrinsics.Method6567(versionmap, "versionmap");
        Intrinsics.Method6567(stopCallback, "stopCallback");
        Intrinsics.Method6567(selectCallback, "selectCallback");
        JPanel jPanel = new JPanel();
        boolean bl = false;
        boolean bl2 = false;
        JPanel $this$apply = jPanel;
        boolean bl3 = false;
        $this$apply.setLayout(new BoxLayout($this$apply, 1));
        $this$apply.add(Box.createVerticalStrut(20));
        JComboBox<String> channelBox = new JComboBox<String>();
        JComboBox<String> versionBox = new JComboBox<String>();
        JButton button = new JButton("Run");
        button.setEnabled(false);
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = $this$apply;
        boolean bl4 = false;
        boolean bl5 = false;
        JPanel $this$apply2 = jPanel2;
        boolean bl6 = false;
        $this$apply2.setLayout(new BoxLayout($this$apply2, 0));
        $this$apply2.add(Box.createHorizontalGlue());
        Font fnt = new Font("Arial", 0, 16);
        Map<TextAttribute, ?> map = fnt.getAttributes();
        if (map == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<java.awt.font.TextAttribute, kotlin.Any?>");
        }
        HashMap attributes = new HashMap(map);
        Map map2 = attributes;
        TextAttribute textAttribute = TextAttribute.UNDERLINE;
        Intrinsics.Method6561(textAttribute, "TextAttribute.UNDERLINE");
        map2.put(textAttribute, TextAttribute.UNDERLINE_ON);
        Font font = fnt.deriveFont(attributes);
        Intrinsics.Method6561(font, "fnt.deriveFont(attributes)");
        fnt = font;
        Object[] $this$forEach$iv = versionmap.keySet();
        boolean $i$f$forEach232 = false;
        for (Object t : $this$forEach$iv) {
            String it = (String)t;
            boolean bl7 = false;
            channelBox.addItem(it);
        }
        channelBox.addItemListener(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$1(channelBox, versionBox, button, versionmap, stopCallback, selectCallback));
        versionBox.removeAllItems();
        $this$forEach$iv = versionmap;
        Object $i$f$forEach232 = channelBox.getSelectedItem();
        boolean bl8 = false;
        Object v = $this$forEach$iv.get($i$f$forEach232);
        if (v == null) {
            Intrinsics.Method6551();
        }
        $this$forEach$iv = (Object[])v;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl9 = false;
            versionBox.addItem(it);
        }
        channelBox.addActionListener(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$2(channelBox, versionBox, button, versionmap, stopCallback, selectCallback));
        versionBox.addActionListener(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$3(channelBox, versionBox, button, versionmap, stopCallback, selectCallback));
        channelBox.addFocusListener(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$4(channelBox, versionBox, button, versionmap, stopCallback, selectCallback));
        versionBox.addFocusListener(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$5(channelBox, versionBox, button, versionmap, stopCallback, selectCallback));
        $this$apply2.add(channelBox);
        $this$apply2.add(versionBox);
        button.addActionListener(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$6(channelBox, versionBox, button, versionmap, stopCallback, selectCallback));
        $this$apply2.add(button);
        $this$apply2.add(Box.createHorizontalGlue());
        JPanel jPanel4 = jPanel2;
        jPanel3.add(jPanel4);
        return jPanel;
    }

    public final void Method12446(@NotNull JPanel panel) {
        Intrinsics.Method6567(panel, "panel");
        this.Field7518.remove(this.Field7516);
        this.Field7516 = panel;
        this.Field7518.add(this.Field7516);
        this.Field7518.revalidate();
    }

    public LoaderGui() {
        super("Pyro Loader");
        this.setUndecorated(true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        LoaderGui base = this;
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        LoaderGui loaderGui = this;
        boolean bl = false;
        boolean bl2 = false;
        JPanel $this$apply = jPanel;
        boolean bl3 = false;
        this.Field7518 = $this$apply;
        $this$apply.setLayout(new BoxLayout($this$apply, 1));
        $this$apply.add(Box.createVerticalStrut(50));
        LoaderGui$ImgBkg img = new LoaderGui$ImgBkg(this);
        $this$apply.add(img);
        $this$apply.add(Box.createVerticalStrut(20));
        $this$apply.add(this.Field7516);
        ThreadsKt.Method9564(true, false, null, null, 0, new LoaderGui$$special$$inlined$apply$lambda$11(img, this, base), 30, null);
        JPanel jPanel2 = jPanel;
        loaderGui.add((Component)jPanel2, "North");
        jPanel = new JPanel();
        loaderGui = this;
        bl = false;
        bl2 = false;
        $this$apply = jPanel;
        boolean bl4 = false;
        JButton jButton = new JButton("Close");
        JPanel jPanel3 = $this$apply;
        boolean bl5 = false;
        boolean bl6 = false;
        JButton $this$apply2 = jButton;
        boolean bl7 = false;
        $this$apply2.addActionListener(LoaderGui$2$1$1.Field6767);
        JButton jButton2 = jButton;
        jPanel3.add(jButton2);
        jPanel2 = jPanel;
        loaderGui.add((Component)jPanel2, "South");
        this.setVisible(true);
    }

    public static final /* synthetic */ int Method12447(LoaderGui $this) {
        return $this.Field7517;
    }

    public static final /* synthetic */ void Method12448(LoaderGui $this, int n) {
        $this.Field7517 = n;
    }
}

