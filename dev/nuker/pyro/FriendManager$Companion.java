/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\nH\u0007J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006%"},
   d2 = {"Ldev/nuker/pyro/FriendManager$Companion;", "", "()V", "INSTANCE", "Ldev/nuker/pyro/FriendManager;", "getINSTANCE", "()Ldev/nuker/pyro/FriendManager;", "setINSTANCE", "(Ldev/nuker/pyro/FriendManager;)V", "addFriend", "", "name", "", "alias", "addFriendIfNeed", "", "getFriend", "Ldev/nuker/pyro/Friend;", "hasFriend", "isFriend", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "isFriendIgnoreEnable", "loadAresFriends", "overwrite", "loadFriends", "loadFutureFriends", "loadImpactFriends", "loadSummitFriends", "salhack", "removeFriend", "saveAresFriends", "saveFriends", "saveFutureFriends", "saveImpactFriends", "saveSummitFriends", "setAlias", "pyroclient"}
)
public final class FriendManager$Companion {
   @NotNull
   public final FriendManager getINSTANCE() {
      return FriendManager.access$getINSTANCE$cp();
   }

   public final void setINSTANCE(@NotNull FriendManager var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      FriendManager.access$setINSTANCE$cp(var1);
   }

   public final void saveFriends() {
      try {
         FileWriter writer = new FileWriter("pyro/friends.json");
         Pyro.GSON.toJson(((FriendManager$Companion)this).getINSTANCE(), (Appendable)writer);
         writer.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   @JvmStatic
   public final void loadFriends() {
      if ((new File("pyro/friends.json")).exists()) {
         try {
            FileReader reader = new FileReader("pyro/friends.json");
            FriendManager$Companion var10000 = (FriendManager$Companion)this;
            Object var10001 = Pyro.GSON.fromJson((Reader)reader, FriendManager.class);
            Intrinsics.checkExpressionValueIsNotNull(var10001, "Pyro.GSON.fromJson(reade…riendManager::class.java)");
            var10000.setINSTANCE((FriendManager)var10001);
            reader.close();
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

   }

   public final boolean hasFriend(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Iterator var3 = ((FriendManager$Companion)this).getINSTANCE().getFriends().iterator();

      class_17 friend;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         friend = (class_17)var3.next();
      } while(!StringsKt.equals(friend.method_3416(), name, true));

      return true;
   }

   public final boolean addFriendIfNeed(@NotNull String name, @Nullable String alias) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      if (((FriendManager$Companion)this).hasFriend(name)) {
         return false;
      } else {
         ((FriendManager$Companion)this).getINSTANCE().getFriends().add(new class_17(name, alias));
         return true;
      }
   }

   @Nullable
   public final class_17 getFriend(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Iterator var3 = ((FriendManager$Companion)this).getINSTANCE().getFriends().iterator();

      class_17 friend;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         friend = (class_17)var3.next();
      } while(!StringsKt.equals(friend.method_3416(), name, true));

      return friend;
   }

   public final boolean addFriendIfNeed(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      return ((FriendManager$Companion)this).addFriendIfNeed(name, name);
   }

   public final boolean loadFutureFriends(boolean overwrite) {
      File file = new File(System.getProperty("user.home") + "/Future/friends.json");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            Map[] futureFriends = (Map[])Pyro.GSON.fromJson((Reader)reader, Pyro.getMapArrayClass());
            if (overwrite) {
               ((FriendManager$Companion)this).getINSTANCE().getFriends().clear();
            }

            Map[] var7 = futureFriends;
            int var8 = futureFriends.length;

            for(int var6 = 0; var6 < var8; ++var6) {
               Map futureFriend = var7[var6];
               FriendManager$Companion var10000 = (FriendManager$Companion)this;
               Object var10001 = futureFriend.get("friend-label");
               if (var10001 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
               }

               var10000.addFriendIfNeed((String)var10001);
            }

            reader.close();
            ((FriendManager$Companion)this).saveFriends();
            return true;
         } catch (IOException var9) {
            var9.printStackTrace();
         }
      }

      return false;
   }

   public final boolean saveFutureFriends(boolean overwrite) {
      File file = new File(System.getProperty("user.home") + "/Future/friends.json");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            Map[] futureFriends = (Map[])Pyro.GSON.fromJson((Reader)reader, Pyro.getMapArrayClass());
            boolean var6 = false;
            List friends = (List)(new ArrayList());
            if (!overwrite) {
               Map[] var8 = futureFriends;
               int var9 = futureFriends.length;

               for(int var7 = 0; var7 < var9; ++var7) {
                  Map futureFriend = var8[var7];
                  if (overwrite) {
                     FriendManager$Companion var10000 = (FriendManager$Companion)this;
                     Object var10001 = futureFriend.get("friend-label");
                     if (var10001 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                     }

                     if (!var10000.hasFriend((String)var10001)) {
                        continue;
                     }
                  }

                  if (futureFriend == null) {
                     throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                  }

                  friends.add(futureFriend);
               }
            }

            reader.close();
            FileWriter writer = new FileWriter(file);
            Iterable $this$forEach$iv = (Iterable)((FriendManager$Companion)this).getINSTANCE().getFriends();
            int $i$f$forEach = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            int $i$f$filterTo = false;
            Iterator var12 = $this$forEach$iv.iterator();

            while(var12.hasNext()) {
               Object element$iv$iv = var12.next();
               f8 it = (class_17)element$iv$iv;
               int var15 = false;
               Iterable $this$map$iv = (Iterable)friends;
               int $i$f$map = false;
               Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
               int $i$f$mapTo = false;
               Iterator var21 = $this$map$iv.iterator();

               while(var21.hasNext()) {
                  Object item$iv$iv = var21.next();
                  Map it = (Map)item$iv$iv;
                  int var25 = false;
                  Object var36 = it.get("friend-label");
                  if (var36 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                  }

                  String var26 = (String)var36;
                  destination$iv$iv.add(var26);
               }

               if (!((List)destination$iv$iv).contains(it.method_3416())) {
                  destination$iv$iv.add(element$iv$iv);
               }
            }

            $this$forEach$iv = (Iterable)((List)destination$iv$iv);
            $i$f$forEach = false;
            Iterator var32 = $this$forEach$iv.iterator();

            while(var32.hasNext()) {
               Object element$iv = var32.next();
               f8 it = (class_17)element$iv;
               int var35 = false;
               friends.add(MapsKt.mapOf(new Pair[]{TuplesKt.method_2843("friend-label", it), TuplesKt.method_2843("friend-alias", it)}));
            }

            Pyro.GSON.toJson(friends, (Appendable)writer);
            writer.close();
            return true;
         } catch (IOException var27) {
            var27.printStackTrace();
         }
      }

      return false;
   }

   public final boolean loadSummitFriends(boolean overwrite, boolean salhack) {
      File file = new File((salhack ? "SalHack" : "Summit") + "/FriendList.json");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            Object var10000 = Pyro.GSON.fromJson((Reader)reader, Pyro.getMapClass());
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>");
            }

            Map summitFriends = (Map)var10000;
            if (overwrite) {
               ((FriendManager$Companion)this).getINSTANCE().getFriends().clear();
            }

            boolean var9 = false;
            Iterator var7 = summitFriends.entrySet().iterator();

            while(var7.hasNext()) {
               Entry summitFriend = (Entry)var7.next();
               FriendManager$Companion var11 = (FriendManager$Companion)this;
               Object var10001 = ((Map)summitFriend.getValue()).get("Name");
               if (var10001 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
               }

               if (!var11.hasFriend((String)var10001)) {
                  var11 = (FriendManager$Companion)this;
                  var10001 = ((Map)summitFriend.getValue()).get("Name");
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  var11.addFriendIfNeed((String)var10001);
               }
            }

            reader.close();
            ((FriendManager$Companion)this).saveFriends();
            return true;
         } catch (IOException var10) {
            var10.printStackTrace();
         }
      }

      return false;
   }

   public final boolean saveSummitFriends(boolean overwrite, boolean salhack) {
      File file = new File((salhack ? "SalHack" : "Summit") + "/FriendList.json");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            Object var10000 = Pyro.GSON.fromJson((Reader)reader, Pyro.getMapClass());
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>");
            }

            Map summitFriends = (Map)var10000;
            boolean var7 = false;
            Map friends = (Map)(new LinkedHashMap());
            boolean var10 = false;
            Iterator var8 = summitFriends.entrySet().iterator();

            while(true) {
               Entry summitFriend;
               Object var10001;
               FriendManager$Companion var19;
               do {
                  if (!var8.hasNext()) {
                     reader.close();
                     FileWriter writer = new FileWriter(file);
                     Iterable $this$forEach$iv = (Iterable)((FriendManager$Companion)this).getINSTANCE().getFriends();
                     int $i$f$forEach = false;
                     Iterator var18 = $this$forEach$iv.iterator();

                     while(var18.hasNext()) {
                        Object element$iv = var18.next();
                        f8 it = (class_17)element$iv;
                        int var13 = false;
                        friends.put(it.method_3416(), MapsKt.mapOf(new Pair[]{TuplesKt.method_2843("Name", it), TuplesKt.method_2843("Alias", it)}));
                     }

                     Pyro.GSON.toJson(friends, (Appendable)writer);
                     writer.close();
                     return true;
                  }

                  summitFriend = (Entry)var8.next();
                  if (!overwrite) {
                     break;
                  }

                  var19 = (FriendManager$Companion)this;
                  var10001 = ((Map)summitFriend.getValue()).get("Name");
                  if (var10001 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                  }
               } while(!var19.hasFriend((String)var10001));

               friends.put(summitFriend.getKey(), MapsKt.mapOf(TuplesKt.method_2843(summitFriend.getKey(), summitFriend.getValue())));
            }
         } catch (IOException var14) {
            var14.printStackTrace();
         }
      }

      return false;
   }

   public final boolean loadImpactFriends(boolean overwrite) {
      File file = new File("Impact/friends.cfg");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            if (overwrite) {
               ((FriendManager$Companion)this).getINSTANCE().getFriends().clear();
            }

            TextStreamsKt.forEachLine((Reader)reader, (Function1)FriendManager$Companion$loadImpactFriends$1.INSTANCE);
            reader.close();
            ((FriendManager$Companion)this).saveFriends();
            return true;
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      }

      return false;
   }

   public final boolean saveImpactFriends(boolean overwrite) {
      File file = new File("Impact/friends.cfg");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            boolean var5 = false;
            List friends = (List)(new ArrayList());
            TextStreamsKt.forEachLine((Reader)reader, (Function1)(new FriendManager$Companion$saveImpactFriends$1(overwrite, friends)));
            Iterable $this$map$iv = (Iterable)((FriendManager$Companion)this).getINSTANCE().getFriends();
            int $i$f$map = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            int $i$f$mapTo = false;
            Iterator var10 = $this$map$iv.iterator();

            Object item$iv$iv;
            class_17 it;
            boolean var13;
            while(var10.hasNext()) {
               item$iv$iv = var10.next();
               it = (class_17)item$iv$iv;
               var13 = false;
               if (!friends.contains(it.method_3416())) {
                  destination$iv$iv.add(item$iv$iv);
               }
            }

            List var15 = (List)destination$iv$iv;
            $this$map$iv = (Iterable)var15;
            $i$f$map = false;
            destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
            $i$f$mapTo = false;
            var10 = $this$map$iv.iterator();

            while(var10.hasNext()) {
               item$iv$iv = var10.next();
               it = (class_17)item$iv$iv;
               var13 = false;
               String var16 = it.method_3416();
               destination$iv$iv.add(var16);
            }

            var15 = (List)destination$iv$iv;
            friends.addAll((Collection)var15);
            reader.close();
            FileWriter writer = new FileWriter(file);
            Iterable $this$forEach$iv = (Iterable)friends;
            int $i$f$forEach = false;
            Iterator var21 = $this$forEach$iv.iterator();

            while(var21.hasNext()) {
               Object element$iv = var21.next();
               String it = (String)element$iv;
               int var24 = false;
               writer.write(it + ':' + it + '\n');
            }

            writer.close();
            return true;
         } catch (IOException var17) {
            var17.printStackTrace();
         }
      }

      return false;
   }

   public final boolean loadAresFriends(boolean overwrite) {
      File file = new File("Ares/friends.txt");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            if (overwrite) {
               ((FriendManager$Companion)this).getINSTANCE().getFriends().clear();
            }

            TextStreamsKt.forEachLine((Reader)reader, (Function1)FriendManager$Companion$loadAresFriends$1.INSTANCE);
            reader.close();
            ((FriendManager$Companion)this).saveFriends();
            return true;
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      }

      return false;
   }

   public final boolean saveAresFriends(boolean overwrite) {
      File file = new File("Ares/friends.txt");
      if (file.exists()) {
         try {
            FileReader reader = new FileReader(file);
            boolean var5 = false;
            List friends = (List)(new ArrayList());
            TextStreamsKt.forEachLine((Reader)reader, (Function1)(new FriendManager$Companion$saveAresFriends$1(overwrite, friends)));
            Iterable $this$map$iv = (Iterable)((FriendManager$Companion)this).getINSTANCE().getFriends();
            int $i$f$map = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            int $i$f$mapTo = false;
            Iterator var10 = $this$map$iv.iterator();

            Object item$iv$iv;
            class_17 it;
            boolean var13;
            while(var10.hasNext()) {
               item$iv$iv = var10.next();
               it = (class_17)item$iv$iv;
               var13 = false;
               if (!friends.contains(it.method_3416())) {
                  destination$iv$iv.add(item$iv$iv);
               }
            }

            List var15 = (List)destination$iv$iv;
            $this$map$iv = (Iterable)var15;
            $i$f$map = false;
            destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
            $i$f$mapTo = false;
            var10 = $this$map$iv.iterator();

            while(var10.hasNext()) {
               item$iv$iv = var10.next();
               it = (class_17)item$iv$iv;
               var13 = false;
               String var16 = it.method_3416();
               destination$iv$iv.add(var16);
            }

            var15 = (List)destination$iv$iv;
            friends.addAll((Collection)var15);
            reader.close();
            FileWriter writer = new FileWriter(file);
            Iterable $this$forEach$iv = (Iterable)friends;
            int $i$f$forEach = false;
            Iterator var21 = $this$forEach$iv.iterator();

            while(var21.hasNext()) {
               Object element$iv = var21.next();
               String it = (String)element$iv;
               int var24 = false;
               writer.write(it + '\n');
            }

            writer.close();
            return true;
         } catch (IOException var17) {
            var17.printStackTrace();
         }
      }

      return false;
   }

   public final boolean isFriend(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      return ((FriendManager$Companion)this).getINSTANCE().getEnabled() && ((FriendManager$Companion)this).getINSTANCE().getFriends().stream().anyMatch((Predicate)(new FriendManager$Companion$isFriend$1(name)));
   }

   public final boolean isFriendIgnoreEnable(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      return ((FriendManager$Companion)this).getINSTANCE().getFriends().stream().anyMatch((Predicate)(new FriendManager$Companion$isFriendIgnoreEnable$1(name)));
   }

   public final boolean isFriend(@NotNull EntityPlayer player) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      FriendManager$Companion var10000 = (FriendManager$Companion)this;
      GameProfile var10001 = player.getGameProfile();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "player.gameProfile");
      String var2 = var10001.getName();
      Intrinsics.checkExpressionValueIsNotNull(var2, "player.gameProfile.name");
      return var10000.isFriend(var2);
   }

   public final void addFriend(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      if (!((FriendManager$Companion)this).hasFriend(name)) {
         ((FriendManager$Companion)this).addFriendIfNeed(name);
         ((FriendManager$Companion)this).saveFriends();
      }

   }

   public final void addFriend(@NotNull String name, @NotNull String alias) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(alias, "alias");
      if (!((FriendManager$Companion)this).hasFriend(name)) {
         ((FriendManager$Companion)this).addFriendIfNeed(name, alias);
         ((FriendManager$Companion)this).saveFriends();
      }

   }

   public final void removeFriend(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      ((FriendManager$Companion)this).getINSTANCE().getFriends().removeIf((Predicate)(new FriendManager$Companion$removeFriend$1(name)));
      ((FriendManager$Companion)this).saveFriends();
   }

   public final boolean setAlias(@NotNull String name, @Nullable String alias) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      f8 friend = ((FriendManager$Companion)this).getFriend(name);
      if (friend != null) {
         friend.method_3414(alias);
         return true;
      } else {
         return false;
      }
   }

   private FriendManager$Companion() {
   }

   // $FF: synthetic method
   public FriendManager$Companion(DefaultConstructorMarker $constructor_marker) {
      this();
   }
}
