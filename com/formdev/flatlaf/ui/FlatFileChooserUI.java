package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.ScaledImageIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.File;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.Box.Filler;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicFileChooserUI.BasicFileView;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class FlatFileChooserUI extends MetalFileChooserUI {
   private final FlatFileChooserUI.FlatFileView fileView = new FlatFileChooserUI.FlatFileView();

   public static ComponentUI createUI(JComponent c) {
      return new FlatFileChooserUI((JFileChooser)c);
   }

   public FlatFileChooserUI(JFileChooser filechooser) {
      super(filechooser);
   }

   public void installComponents(JFileChooser fc) {
      super.installComponents(fc);
      this.patchUI(fc);
   }

   private void patchUI(JFileChooser fc) {
      Component topPanel = fc.getComponent(0);
      Component topButtonPanel;
      if (topPanel instanceof JPanel && ((JPanel)topPanel).getLayout() instanceof BorderLayout) {
         topButtonPanel = ((JPanel)topPanel).getComponent(0);
         if (topButtonPanel instanceof JPanel && ((JPanel)topButtonPanel).getLayout() instanceof BoxLayout) {
            Insets margin = UIManager.getInsets("Button.margin");
            Component[] comps = ((JPanel)topButtonPanel).getComponents();

            for(int i = comps.length - 1; i >= 0; --i) {
               Component c = comps[i];
               if (!(c instanceof JButton) && !(c instanceof JToggleButton)) {
                  if (c instanceof Filler) {
                     ((JPanel)topButtonPanel).remove(i);
                  }
               } else {
                  AbstractButton b = (AbstractButton)c;
                  b.putClientProperty("JButton.buttonType", "toolBarButton");
                  b.setMargin(margin);
                  b.setFocusable(false);
               }
            }
         }
      }

      try {
         topButtonPanel = ((JPanel)topPanel).getComponent(2);
         if (topButtonPanel instanceof JComboBox) {
            int maximumRowCount = UIManager.getInt("ComboBox.maximumRowCount");
            if (maximumRowCount > 0) {
               ((JComboBox)topButtonPanel).setMaximumRowCount(maximumRowCount);
            }
         }
      } catch (ArrayIndexOutOfBoundsException var9) {
      }

   }

   public Dimension getPreferredSize(JComponent c) {
      return UIScale.scale(super.getPreferredSize(c));
   }

   public Dimension getMinimumSize(JComponent c) {
      return UIScale.scale(super.getMinimumSize(c));
   }

   public FileView getFileView(JFileChooser fc) {
      return this.fileView;
   }

   public void clearIconCache() {
      this.fileView.clearIconCache();
   }

   private class FlatFileView extends BasicFileView {
      private FlatFileView() {
         super(FlatFileChooserUI.this);
      }

      public Icon getIcon(File f) {
         Icon iconx = this.getCachedIcon(f);
         if (iconx != null) {
            return iconx;
         } else {
            Object icon;
            if (f != null) {
               icon = FlatFileChooserUI.this.getFileChooser().getFileSystemView().getSystemIcon(f);
               if (icon != null) {
                  if (icon instanceof ImageIcon) {
                     icon = new ScaledImageIcon((ImageIcon)icon);
                  }

                  this.cacheIcon(f, (Icon)icon);
                  return (Icon)icon;
               }
            }

            icon = super.getIcon(f);
            if (icon instanceof ImageIcon) {
               icon = new ScaledImageIcon((ImageIcon)icon);
               this.cacheIcon(f, (Icon)icon);
            }

            return (Icon)icon;
         }
      }

      // $FF: synthetic method
      FlatFileView(Object x1) {
         this();
      }
   }
}
