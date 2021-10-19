package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.MultiResolutionImageSupport;
import com.formdev.flatlaf.util.ScaledImageIcon;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FlatTitlePaneIcon extends ScaledImageIcon {
   private final List images;

   public static Icon create(List images, Dimension size) {
      List allImages = new ArrayList();
      Iterator var3 = images.iterator();

      while(var3.hasNext()) {
         Image image = (Image)var3.next();
         if (MultiResolutionImageSupport.isMultiResolutionImage(image)) {
            allImages.addAll(MultiResolutionImageSupport.getResolutionVariants(image));
         } else {
            allImages.add(image);
         }
      }

      allImages.sort((image1, image2) -> {
         return image1.getWidth((ImageObserver)null) - image2.getWidth((ImageObserver)null);
      });
      return new FlatTitlePaneIcon(allImages, size);
   }

   private FlatTitlePaneIcon(List images, Dimension size) {
      super(new ImageIcon((Image)images.get(0)), size.width, size.height);
      this.images = images;
   }

   protected Image getResolutionVariant(int destImageWidth, int destImageHeight) {
      Iterator var3 = this.images.iterator();

      Image image;
      do {
         if (!var3.hasNext()) {
            return (Image)this.images.get(this.images.size() - 1);
         }

         image = (Image)var3.next();
      } while(destImageWidth > image.getWidth((ImageObserver)null) || destImageHeight > image.getHeight((ImageObserver)null));

      return image;
   }
}
