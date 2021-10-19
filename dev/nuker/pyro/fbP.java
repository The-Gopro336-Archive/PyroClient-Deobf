/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class fbP implements Runnable {
   // $FF: renamed from: c dev.nuker.pyro.fbQ
   public fbQ field_1624;

   public fbP(fbQ var1) {
      this.field_1624 = var1;
      super();
   }

   public void run() {
      int var1 = (int)fbT.method_1039(this.field_1624.field_1612).player.posX;
      int var2 = (int)fbT.method_1039(this.field_1624.field_1612).player.posY;
      int var3 = (int)fbT.method_1039(this.field_1624.field_1612).player.posZ;
      int var4 = fbT.method_1039(this.field_1624.field_1612).gameSettings.renderDistanceChunks * 16;
      fbT.method_1039(this.field_1624.field_1612).renderGlobal.markBlockRangeForRenderUpdate(var1 - var4, var2 - var4, var3 - var4, var1 + var4, var2 + var4, var3 + var4);
   }
}
