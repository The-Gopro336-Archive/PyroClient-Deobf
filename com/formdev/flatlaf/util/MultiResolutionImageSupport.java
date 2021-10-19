package com.formdev.flatlaf.util;

import java.awt.Image;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class MultiResolutionImageSupport {
   public static boolean isAvailable() {
      return false;
   }

   public static boolean isMultiResolutionImage(Image image) {
      return false;
   }

   public static Image create(int baseImageIndex, Image... resolutionVariants) {
      return resolutionVariants[baseImageIndex];
   }

   public static Image map(Image image, Function mapper) {
      return (Image)mapper.apply(image);
   }

   public static Image getResolutionVariant(Image image, int destImageWidth, int destImageHeight) {
      return image;
   }

   public static List getResolutionVariants(Image image) {
      return Collections.singletonList(image);
   }
}
