/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fbJ extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_721 = (BooleanSetting)this.register((f0w)(new BooleanSetting("players", "Players", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_722 = (BooleanSetting)this.register((f0w)(new BooleanSetting("friends", "Friends", (String)null, true)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_723 = (BooleanSetting)this.register((f0w)(new BooleanSetting("invisibles", "Invisibles", (String)null, false)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_724 = (BooleanSetting)this.register((f0w)(new BooleanSetting("monsters", "Monsters", (String)null, false)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_725 = (BooleanSetting)this.register((f0w)(new BooleanSetting("neutrals", "Neutrals", (String)null, false)));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_726 = (BooleanSetting)this.register((f0w)(new BooleanSetting("animals", "Animals", (String)null, false)));
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_727 = (BooleanSetting)this.register((f0w)(new BooleanSetting("vehicles", "Vehicles", (String)null, false)));
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_728 = (BooleanSetting)this.register((f0w)(new BooleanSetting("items", "Items", (String)null, false)));
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_729 = (BooleanSetting)this.register((f0w)(new BooleanSetting("others", "Others", (String)null, false)));
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_730;
   // $FF: renamed from: 8 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_731;
   // $FF: renamed from: 0 dev.nuker.pyro.f0o
   @NotNull
   public f0o field_732;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_733;
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_734;

   // $FF: renamed from: 1 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1060() {
      return this.field_730;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1061() {
      return this.field_734;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1062() {
      return this.field_729;
   }

   // $FF: renamed from: d () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1063() {
      return this.field_721;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1064() {
      return this.field_724;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1065() {
      return this.field_723;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1066() {
      return this.field_732;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.entity.Entity) boolean
   public boolean method_1067(Entity var1, Entity var2) {
      if (!(var1 instanceof EntityLivingBase)) {
         return false;
      } else if (var1 instanceof EntityPlayer && !(Boolean)this.field_721.c()) {
         return false;
      } else if (FriendManager.Companion.isFriend(var1.getName()) && !(Boolean)this.field_722.c()) {
         return false;
      } else if (fdN.method_1862(var1) && !(Boolean)this.field_724.c()) {
         return false;
      } else if (((EntityLivingBase)var1).isInvisible() && !(Boolean)this.field_723.c()) {
         return false;
      } else if (fdN.method_1874(var1) && !(Boolean)this.field_726.c()) {
         return false;
      } else if ((var1 instanceof EntityMinecart || var1 instanceof EntityBoat) && !(Boolean)this.field_727.c()) {
         return false;
      } else if (var1 instanceof EntityItem && !(Boolean)this.field_728.c()) {
         return false;
      } else if (var1 instanceof EntityEnderCrystal && !(Boolean)this.field_729.c()) {
         return false;
      } else {
         if (this.c.player.isRiding()) {
            Entity var10000 = this.c.player.getRidingEntity();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            if (Intrinsics.areEqual((Object)var10000, (Object)var1)) {
               return false;
            }
         }

         return fdN.method_1868(var1) && !(Boolean)this.field_725.c() ? false : Intrinsics.areEqual((Object)var1, (Object)var2) ^ true;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0l) void
   public void method_1068(@NotNull f0l var1) {
      this.field_734 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1069() {
      return this.field_722;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1070() {
      return this.field_728;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1071() {
      return this.field_731;
   }

   public fbJ() {
      super("tracers", "Tracers", "Draw lines to entities around you", true);
      this.field_730 = (f0o)this.register((f0w)(new f0o("target", "Target", (String)null, (Enum)fbH.field_1610)));
      this.field_731 = (BooleanSetting)this.register((f0w)(new BooleanSetting("lines", "Lines", (String)null, true)));
      this.field_732 = (f0o)this.register((f0w)(new f0o("design", "Design", (String)null, (Enum)fbG.field_1603)));
      this.field_733 = (DoubleSetting)this.register((f0w)(new DoubleSetting("width", "Width", (String)null, 1.6D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_734 = (f0l)this.register((f0w)(new f0l("defaultColor", "DefaultColor", (String)null, new f00(1.0F, 0.5F, 0.55F, 1.0F))));
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1072() {
      return this.field_726;
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1073() {
      return this.field_727;
   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1074() {
      return this.field_725;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1075() {
      return this.field_733;
   }
}
