package com.formdev.flatlaf.ui;

import java.awt.Component;
import javax.swing.UIManager;

public class FlatTextBorder extends FlatBorder {
   protected final int arc = UIManager.getInt("TextComponent.arc");

   protected int getArc(Component c) {
      return FlatUIUtils.isRoundRect(c) ? 32767 : this.arc;
   }
}
