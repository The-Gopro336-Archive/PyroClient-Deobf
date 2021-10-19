/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class fbS implements Runnable {
   // $FF: renamed from: c dev.nuker.pyro.fbT
   public fbT field_1614;

   public fbS(fbT var1) {
      this.field_1614 = var1;
      super();
   }

   public void run() {
      int var1 = (int)fbT.method_1039(this.field_1614).player.posX;
      int var2 = (int)fbT.method_1039(this.field_1614).player.posY;
      int var3 = (int)fbT.method_1039(this.field_1614).player.posZ;
      int var4 = fbT.method_1039(this.field_1614).gameSettings.renderDistanceChunks * 16;
      fbT.method_1039(this.field_1614).renderGlobal.markBlockRangeForRenderUpdate(var1 - var4, var2 - var4, var3 - var4, var1 + var4, var2 + var4, var3 + var4);
   }
}
