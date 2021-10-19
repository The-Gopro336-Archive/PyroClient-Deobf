/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.launcher.LoaderGui.getLoginPanel..inlined.apply.lambda.1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u0018J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ*\u0010\u001d\u001a\u00020\u00042\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006$"},
   d2 = {"Ldev/nuker/pyro/launcher/LoaderGui;", "Ljavax/swing/JFrame;", "()V", "currentPanel", "Ljavax/swing/JPanel;", "lDir", "", "parentPanel", "progress", "", "getProgress", "()D", "setProgress", "(D)V", "getDownloadPanel", "text", "", "versionmap", "", "", "stopCallback", "Lkotlin/Function0;", "", "selectCallback", "Lkotlin/Function2;", "getLinkedPanel", "linktext", "link", "Ljava/net/URI;", "getLoginPanel", "callback", "failure", "getTextPanel", "setUI", "panel", "ImgBkg", "pyroclient"}
)
public final class LoaderGui extends JFrame {
   private double progress = -1.0D;
   private JPanel currentPanel = this.getTextPanel("Initializing");
   private int lDir = 1;
   private final JPanel parentPanel;

   public final double getProgress() {
      return this.progress;
   }

   public final void setProgress(double var1) {
      this.progress = var1;
   }

   @NotNull
   public final JPanel getLoginPanel(@NotNull Function2 callback, @NotNull String failure) {
      Intrinsics.checkParameterIsNotNull(callback, "callback");
      Intrinsics.checkParameterIsNotNull(failure, "failure");
      JPanel var3 = new JPanel();
      boolean var4 = false;
      boolean var5 = false;
      int var7 = false;
      var3.setLayout((LayoutManager)(new BoxLayout((Container)var3, 1)));
      Ref.ObjectRef uBox = new Ref.ObjectRef();
      uBox.element = (JTextField)null;
      Ref.ObjectRef pBox = new Ref.ObjectRef();
      pBox.element = (JPasswordField)null;
      JPanel var10 = new JPanel();
      boolean var12 = false;
      boolean var13 = false;
      int var15 = false;
      var10.setBackground(new Color(0, 0, 0, 0));
      var10.setLayout((LayoutManager)(new BoxLayout((Container)var10, 0)));
      var10.add(Box.createHorizontalStrut(20));
      JPanel var16 = new JPanel();
      boolean var18 = false;
      boolean var19 = false;
      int var21 = false;
      var16.setLayout((LayoutManager)(new BoxLayout((Container)var16, 1)));
      JLabel var22 = new JLabel("Username");
      boolean var24 = false;
      boolean var25 = false;
      int var27 = false;
      var22.setFont(new Font("Arial", 0, 16));
      var16.add((Component)var22, "South");
      JTextField var33 = new JTextField();
      var24 = false;
      var25 = false;
      var27 = false;
      uBox.element = var33;
      var16.add((Component)var33);
      var10.add((Component)var16);
      var10.add(Box.createHorizontalStrut(10));
      var16 = new JPanel();
      var18 = false;
      var19 = false;
      var21 = false;
      var16.setLayout((LayoutManager)(new BoxLayout((Container)var16, 1)));
      var22 = new JLabel("Password");
      var24 = false;
      var25 = false;
      var27 = false;
      var22.setFont(new Font("Arial", 0, 16));
      var16.add((Component)var22, "South");
      JPasswordField var34 = new JPasswordField();
      var24 = false;
      var25 = false;
      var27 = false;
      pBox.element = var34;
      var16.add((Component)var34);
      var10.add((Component)var16);
      var10.add(Box.createHorizontalStrut(20));
      var3.add((Component)var10);
      CharSequence var31 = (CharSequence)failure;
      var12 = false;
      if (var31.length() == 0) {
         var3.add(Box.createVerticalStrut(25));
      } else {
         var3.add(Box.createVerticalStrut(5));
         var10 = new JPanel();
         var12 = false;
         var13 = false;
         var15 = false;
         var10.setLayout((LayoutManager)(new BoxLayout((Container)var10, 0)));
         var10.add(Box.createHorizontalGlue());
         var10.add((Component)(new JLabel(failure)));
         var10.add(Box.createHorizontalGlue());
         var3.add((Component)var10);
         var3.add(Box.createVerticalStrut(5));
      }

      var10 = new JPanel();
      var12 = false;
      var13 = false;
      var15 = false;
      var10.setLayout((LayoutManager)(new BoxLayout((Container)var10, 0)));
      var10.add(Box.createHorizontalGlue());
      JButton var32 = new JButton("Login");
      var18 = false;
      var19 = false;
      var21 = false;
      var32.setPreferredSize(new Dimension(200, 25));
      var32.addActionListener((ActionListener)(new 1(uBox, pBox, failure, callback)));
      var10.add((Component)var32);
      var10.add(Box.createHorizontalGlue());
      var3.add((Component)var10);
      return var3;
   }

   // $FF: synthetic method
   public static JPanel getLoginPanel$default(LoaderGui var0, Function2 var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = "";
      }

      return var0.getLoginPanel(var1, var2);
   }

   @NotNull
   public final JPanel getTextPanel(@NotNull String text) {
      Intrinsics.checkParameterIsNotNull(text, "text");
      JPanel var2 = new JPanel();
      boolean var3 = false;
      boolean var4 = false;
      int var6 = false;
      var2.setLayout((LayoutManager)(new BoxLayout((Container)var2, 0)));
      JLabel var7 = new JLabel(text);
      boolean var9 = false;
      boolean var10 = false;
      int var12 = false;
      var7.setFont(new Font("Arial", 0, 26));
      var2.add((Component)var7);
      return var2;
   }

   @NotNull
   public final JPanel getLinkedPanel(@NotNull String text, @NotNull String linktext, @NotNull URI link) {
      Intrinsics.checkParameterIsNotNull(text, "text");
      Intrinsics.checkParameterIsNotNull(linktext, "linktext");
      Intrinsics.checkParameterIsNotNull(link, "link");
      JPanel var4 = new JPanel();
      boolean var5 = false;
      boolean var6 = false;
      int var8 = false;
      var4.setLayout((LayoutManager)(new BoxLayout((Container)var4, 1)));
      JPanel var9 = new JPanel();
      boolean var11 = false;
      boolean var12 = false;
      int var14 = false;
      var9.setLayout((LayoutManager)(new BoxLayout((Container)var9, 0)));
      JLabel var15 = new JLabel(text);
      boolean var17 = false;
      boolean var18 = false;
      int var20 = false;
      var15.setFont(new Font("Arial", 0, 26));
      var9.add((Component)var15);
      var4.add((Component)var9);
      var4.add(Box.createVerticalStrut(20));
      var9 = new JPanel();
      var11 = false;
      var12 = false;
      var14 = false;
      var9.setLayout((LayoutManager)(new BoxLayout((Container)var9, 0)));
      Ref.ObjectRef fnt = new Ref.ObjectRef();
      fnt.element = new Font("Arial", 0, 16);
      HashMap var10000 = new HashMap;
      Map var10002 = ((Font)fnt.element).getAttributes();
      if (var10002 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<java.awt.font.TextAttribute, kotlin.Any?>");
      } else {
         var10000.<init>(var10002);
         HashMap attributes = var10000;
         Map var26 = (Map)attributes;
         TextAttribute var10001 = TextAttribute.UNDERLINE;
         Intrinsics.checkExpressionValueIsNotNull(var10001, "TextAttribute.UNDERLINE");
         var26.put(var10001, TextAttribute.UNDERLINE_ON);
         Font var27 = ((Font)fnt.element).deriveFont((Map)attributes);
         Intrinsics.checkExpressionValueIsNotNull(var27, "fnt.deriveFont(attributes)");
         fnt.element = var27;
         JLabel var28 = new JLabel(linktext);
         boolean var19 = false;
         var20 = false;
         int var23 = false;
         var28.setFont((Font)fnt.element);
         var28.setCursor(Cursor.getPredefinedCursor(12));
         var28.addMouseListener((MouseListener)(new dev.nuker.pyro.launcher.LoaderGui.getLinkedPanel..inlined.apply.lambda.1(fnt, text, linktext, link)));
         var9.add((Component)var28);
         var4.add((Component)var9);
         return var4;
      }
   }

   @NotNull
   public final JPanel getDownloadPanel(@NotNull String text, @NotNull Map versionmap, @NotNull Function0 stopCallback, @NotNull Function2 selectCallback) {
      Intrinsics.checkParameterIsNotNull(text, "text");
      Intrinsics.checkParameterIsNotNull(versionmap, "versionmap");
      Intrinsics.checkParameterIsNotNull(stopCallback, "stopCallback");
      Intrinsics.checkParameterIsNotNull(selectCallback, "selectCallback");
      JPanel var5 = new JPanel();
      boolean var6 = false;
      boolean var7 = false;
      int var9 = false;
      var5.setLayout((LayoutManager)(new BoxLayout((Container)var5, 1)));
      var5.add(Box.createVerticalStrut(20));
      JComboBox channelBox = new JComboBox();
      JComboBox versionBox = new JComboBox();
      JButton button = new JButton("Run");
      button.setEnabled(false);
      JPanel var13 = new JPanel();
      boolean var15 = false;
      boolean var16 = false;
      int var18 = false;
      var13.setLayout((LayoutManager)(new BoxLayout((Container)var13, 0)));
      var13.add(Box.createHorizontalGlue());
      Font fnt = new Font("Arial", 0, 16);
      HashMap var10000 = new HashMap;
      Map var10002 = fnt.getAttributes();
      if (var10002 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<java.awt.font.TextAttribute, kotlin.Any?>");
      } else {
         var10000.<init>(var10002);
         HashMap attributes = var10000;
         Map var30 = (Map)attributes;
         TextAttribute var10001 = TextAttribute.UNDERLINE;
         Intrinsics.checkExpressionValueIsNotNull(var10001, "TextAttribute.UNDERLINE");
         var30.put(var10001, TextAttribute.UNDERLINE_ON);
         Intrinsics.checkExpressionValueIsNotNull(fnt.deriveFont((Map)attributes), "fnt.deriveFont(attributes)");
         Iterable $this$forEach$iv = (Iterable)versionmap.keySet();
         int $i$f$forEach = false;
         Iterator var23 = $this$forEach$iv.iterator();

         while(var23.hasNext()) {
            Object element$iv = var23.next();
            String it = (String)element$iv;
            int var26 = false;
            channelBox.addItem(it);
         }

         channelBox.addItemListener((ItemListener)(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$1(channelBox, versionBox, button, versionmap, stopCallback, selectCallback)));
         versionBox.removeAllItems();
         Object var33 = channelBox.getSelectedItem();
         boolean var34 = false;
         Object var31 = versionmap.get(var33);
         if (var31 == null) {
            Intrinsics.throwNpe();
         }

         Object[] $this$forEach$iv = (Object[])var31;
         $i$f$forEach = false;
         Object[] var35 = $this$forEach$iv;
         int var36 = $this$forEach$iv.length;

         for(int var37 = 0; var37 < var36; ++var37) {
            Object element$iv = var35[var37];
            String it = (String)element$iv;
            int var28 = false;
            versionBox.addItem(it);
         }

         channelBox.addActionListener((ActionListener)(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$2(channelBox, versionBox, button, versionmap, stopCallback, selectCallback)));
         versionBox.addActionListener((ActionListener)(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$3(channelBox, versionBox, button, versionmap, stopCallback, selectCallback)));
         channelBox.addFocusListener((FocusListener)(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$4(channelBox, versionBox, button, versionmap, stopCallback, selectCallback)));
         versionBox.addFocusListener((FocusListener)(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$5(channelBox, versionBox, button, versionmap, stopCallback, selectCallback)));
         var13.add((Component)channelBox);
         var13.add((Component)versionBox);
         button.addActionListener((ActionListener)(new LoaderGui$getDownloadPanel$$inlined$apply$lambda$6(channelBox, versionBox, button, versionmap, stopCallback, selectCallback)));
         var13.add((Component)button);
         var13.add(Box.createHorizontalGlue());
         var5.add((Component)var13);
         return var5;
      }
   }

   public final void setUI(@NotNull JPanel panel) {
      Intrinsics.checkParameterIsNotNull(panel, "panel");
      this.parentPanel.remove((Component)this.currentPanel);
      this.currentPanel = panel;
      this.parentPanel.add((Component)this.currentPanel);
      this.parentPanel.revalidate();
   }

   public LoaderGui() {
      super("Pyro Loader");
      this.setUndecorated(true);
      this.setSize(400, 400);
      this.setLocationRelativeTo((Component)null);
      LoaderGui base = (LoaderGui)this;
      this.setLayout((LayoutManager)(new BorderLayout()));
      JPanel var2 = new JPanel();
      boolean var3 = false;
      boolean var4 = false;
      int var6 = false;
      this.parentPanel = var2;
      var2.setLayout((LayoutManager)(new BoxLayout((Container)var2, 1)));
      var2.add(Box.createVerticalStrut(50));
      LoaderGui$ImgBkg img = new LoaderGui$ImgBkg(this);
      var2.add((Component)img);
      var2.add(Box.createVerticalStrut(20));
      var2.add((Component)this.currentPanel);
      ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new LoaderGui$$special$$inlined$apply$lambda$11(img, this, base)), 30, (Object)null);
      this.add((Component)var2, "North");
      var2 = new JPanel();
      var3 = false;
      var4 = false;
      var6 = false;
      JButton var16 = new JButton("Close");
      boolean var9 = false;
      boolean var10 = false;
      int var12 = false;
      var16.addActionListener((ActionListener)LoaderGui$2$1$1.INSTANCE);
      var2.add((Component)var16);
      this.add((Component)var2, "South");
      this.setVisible(true);
   }

   // $FF: synthetic method
   public static final int access$getLDir$p(LoaderGui $this) {
      return $this.lDir;
   }

   // $FF: synthetic method
   public static final void access$setLDir$p(LoaderGui $this, int var1) {
      $this.lDir = var1;
   }
}
