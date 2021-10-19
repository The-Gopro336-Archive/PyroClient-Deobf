/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.KeyBindingAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fd4 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_943;
   // $FF: renamed from: c dev.nuker.pyro.f0l
   public f0l field_944;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   public f0l field_945;
   // $FF: renamed from: 1 dev.nuker.pyro.f0l
   public f0l field_946;
   // $FF: renamed from: 2 dev.nuker.pyro.f0l
   public f0l field_947;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_948;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_949;
   // $FF: renamed from: c java.util.concurrent.ConcurrentLinkedQueue
   public ConcurrentLinkedQueue field_950;

   // $FF: renamed from: c (dev.nuker.pyro.fd4) net.minecraft.util.math.BlockPos
   public static BlockPos method_1381(fd4 var0) {
      return var0.field_949;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fd4, net.minecraft.util.math.BlockPos) void
   public static void method_1382(fd4 var0, BlockPos var1) {
      var0.field_949 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4k) void
   @f0g
   @LauncherEventHide
   public void method_1383(@NotNull f4k var1) {
      if ((fd1)this.field_943.c() == fd1.field_962) {
         if ((Boolean)this.field_948.c() && Intrinsics.areEqual((Object)this.field_949, (Object)BlockPos.ORIGIN) ^ true) {
            if (this.field_950.contains(var1.method_3268())) {
               this.field_950.remove(var1.method_3268());
            }

            this.field_950.add(var1.method_3268());
            return;
         }

         this.field_949 = var1.method_3268();
         class_2.field_982.method_1425((Module)this, var1.method_3268(), true, (Consumer)(new fd2(this)));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_1384(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && (fd1)this.field_943.c() == fd1.field_962 && this.field_949 != null) {
         if (class_2.field_982.method_1424() != null && Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fd4)this)) ^ true) {
            return;
         }

         if (Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fd4)this)) && this.field_949 != null) {
            BlockPos var10002 = this.field_949;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            this.method_1385(var1, var10002);
            return;
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      if (this.field_949 != null) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         BlockPos var10001 = this.field_949;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917(var10001, ((f00)this.field_944.c()).meth1(), 63);
         fe5.field_1245.method_1912();
         PyroRenderUtil.method_1433(this.field_949, ((f00)this.field_945.c()).meth1(), 1.0F, true);
      }

      if (!this.field_950.isEmpty() && (Boolean)this.field_948.c()) {
         int var3 = 0;
         Iterable var4 = (Iterable)this.field_950;
         boolean var5 = false;
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            BlockPos var8 = (BlockPos)var7;
            boolean var9 = false;
            ++var3;
            fe5.field_1245.method_1915(7);
            fe5.field_1245.method_1917(var8, ((f00)this.field_946.c()).meth1(), 63);
            fe5.field_1245.method_1912();
            PyroRenderUtil.method_1433(var8, ((f00)this.field_947.c()).meth1(), 1.0F, true);
            GlStateManager.pushMatrix();
            EntityPlayer var10 = this.c.getRenderViewEntity() instanceof EntityPlayer ? (EntityPlayer)this.c.getRenderViewEntity() : (EntityPlayer)this.c.player;
            PyroRenderUtil.method_1440((float)var8.getX() + 0.5F, (float)var8.getY() + 0.5F, (float)var8.getZ() + 0.5F, (Entity)var10, 1.0F);
            GlStateManager.disableDepth();
            GlStateManager.translate(-((double)PyroRenderUtil.method_1439(String.valueOf(var3)) / 2.0D), 0.0D, 0.0D);
            PyroRenderUtil.meth1(String.valueOf(var3), 0.0F, 0.0F, -1);
            GlStateManager.popMatrix();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u, net.minecraft.util.math.BlockPos) boolean
   public boolean method_1385(@NotNull f4u var1, @NotNull BlockPos var2) {
      fex var3 = few.method_1716().method_1708(var2);
      if (var3 != null) {
         var1.0();
         var1.method_3139(var3.method_2076().meth3());
         var1.method_3140(var3.method_2076().meth4());
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      KeyBinding var10000 = this.c.gameSettings.keyBindAttack;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.KeyBindingAccessor");
      } else {
         ((KeyBindingAccessor)var10000).setPressed(false);
         this.5(((fd1)this.field_943.c()).toString());
         this.field_950.clear();
      }
   }

   public fd4() {
      super("automine", "AutoMine", "Automatically holds down left click");
      this.field_943 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)fd1.field_961)));
      this.field_944 = (f0l)this.register((f0w)(new f0l("renderColor", "RenderColor", (String)null, new f00(0.0F, 1.0F, 0.5F, 0.3F))));
      this.field_945 = (f0l)this.register((f0w)(new f0l("rendeerOutline", "RenderOutline", (String)null, new f00(0.0F, 1.0F, 0.5F, 1.0F))));
      this.field_946 = new f0l("queueColor1", "QueueColor", (String)null, new f00(0.475F, 1.0F, 0.5F, 0.3F));
      this.field_947 = new f0l("queueOutline1", "QueueOutline", (String)null, new f00(0.475F, 1.0F, 0.5F, 1.0F));
      this.field_948 = new BooleanSetting("queue", "Queue", (String)null, false);
      this.field_949 = BlockPos.ORIGIN;
      this.field_950 = new ConcurrentLinkedQueue();
      this.register((f0w)(new f0t((f0w)this.field_948, new f0w[]{(f0w)this.field_946, (f0w)this.field_947})));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1386(@Nullable f4t var1) {
      if ((fd1)this.field_943.c() == fd1.field_961) {
         KeyBinding var10000 = this.c.gameSettings.keyBindAttack;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.KeyBindingAccessor");
         }

         ((KeyBindingAccessor)var10000).setPressed(true);
      } else if (Intrinsics.areEqual((Object)this.field_949, (Object)BlockPos.ORIGIN) && !this.field_950.isEmpty() && (Boolean)this.field_948.c()) {
         this.field_949 = (BlockPos)this.field_950.poll();
         class_2.field_982.method_1425((Module)this, this.field_949, true, (Consumer)(new fd3(this)));
      }

   }
}
