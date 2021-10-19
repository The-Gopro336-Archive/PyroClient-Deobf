/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.mixin.EntityFlagAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fe4 {
   // $FF: renamed from: c java.util.List
   public static List field_1241;
   // $FF: renamed from: 0 java.util.List
   public static List field_1242;
   // $FF: renamed from: c dev.nuker.pyro.fe4
   public static fe4 field_1243;

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer) boolean
   public boolean method_1894(@Nullable EntityPlayer var1) {
      return var1 != null && Intrinsics.areEqual((Object)var1, (Object)Minecraft.getMinecraft().player) ^ true && !FriendManager.Companion.isFriend(var1) && (!CollectionsKt.contains((Iterable)field_1241, var1) || CollectionsKt.contains((Iterable)field_1242, var1));
   }

   static {
      fe4 var0 = new fe4();
      field_1243 = var0;
      boolean var1 = false;
      field_1241 = (List)(new ArrayList());
      var1 = false;
      field_1242 = (List)(new ArrayList());
   }

   // $FF: renamed from: c () void
   public void method_1895() {
      field_1241.clear();
      field_1242.clear();
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityOtherPlayerMP) void
   public void method_1896(@NotNull EntityOtherPlayerMP var1) {
      if (Minecraft.getMinecraft().world != null) {
         Minecraft.getMinecraft().world.removeEntityFromWorld(var1.getEntityId());
      }

      field_1241.remove(var1);
      field_1242.remove(var1);
   }

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer, int, boolean) net.minecraft.client.entity.EntityOtherPlayerMP
   @NotNull
   public EntityOtherPlayerMP method_1897(@NotNull EntityPlayer var1, int var2, boolean var3) {
      EntityOtherPlayerMP var4 = new EntityOtherPlayerMP(var1.world, var1.getGameProfile());
      var4.copyLocationAndAnglesFrom((Entity)var1);
      var4.rotationYaw = var1.rotationYaw;
      var4.rotationYawHead = var1.rotationYawHead;
      var4.inventory.copyInventory(var1.inventory);
      ((EntityFlagAccessor)var4).set(7, var1.isElytraFlying());
      Minecraft.getMinecraft().world.addEntityToWorld(var2, (Entity)var4);
      field_1241.add(var4);
      if (var3) {
         field_1242.add(var4);
      }

      if (var1.getRidingEntity() != null) {
         var4.startRiding(var1.getRidingEntity(), true);
      }

      return var4;
   }

   // $FF: renamed from: c (java.lang.String, int, boolean) net.minecraft.client.entity.EntityOtherPlayerMP
   @NotNull
   public EntityOtherPlayerMP method_1898(@NotNull String var1, int var2, boolean var3) {
      EntityOtherPlayerMP var4 = new EntityOtherPlayerMP((World)Minecraft.getMinecraft().world, new GameProfile((UUID)null, var1));
      Minecraft.getMinecraft().world.addEntityToWorld(var2, (Entity)var4);
      field_1241.add(var4);
      if (var3) {
         field_1242.add(var4);
      }

      return var4;
   }

   // $FF: renamed from: 0 (net.minecraft.entity.player.EntityPlayer, int, boolean) net.minecraft.client.entity.EntityOtherPlayerMP
   @NotNull
   public EntityOtherPlayerMP method_1899(@NotNull EntityPlayer var1, int var2, boolean var3) {
      EntityOtherPlayerMP var4 = new EntityOtherPlayerMP(var1.world, var1.getGameProfile());
      var4.copyLocationAndAnglesFrom((Entity)var1);
      var4.rotationYaw = var1.rotationYaw;
      var4.rotationYawHead = var1.rotationYawHead;
      Minecraft.getMinecraft().world.addEntityToWorld(var2, (Entity)var4);
      field_1241.add(var4);
      if (var3) {
         field_1242.add(var4);
      }

      return var4;
   }
}
