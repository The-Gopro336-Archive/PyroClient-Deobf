/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.Class12;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.FriendManager$Companion$isFriend$1;
import dev.nuker.pyro.FriendManager$Companion$isFriendIgnoreEnable$1;
import dev.nuker.pyro.FriendManager$Companion$loadAresFriends$1;
import dev.nuker.pyro.FriendManager$Companion$loadImpactFriends$1;
import dev.nuker.pyro.FriendManager$Companion$removeFriend$1;
import dev.nuker.pyro.FriendManager$Companion$saveAresFriends$1;
import dev.nuker.pyro.FriendManager$Companion$saveImpactFriends$1;
import dev.nuker.pyro.Pyro;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\nH\u0007J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006%"}, d2={"Ldev/nuker/pyro/FriendManager$Companion;", "", "()V", "INSTANCE", "Ldev/nuker/pyro/FriendManager;", "getINSTANCE", "()Ldev/nuker/pyro/FriendManager;", "setINSTANCE", "(Ldev/nuker/pyro/FriendManager;)V", "addFriend", "", "name", "", "alias", "addFriendIfNeed", "", "getFriend", "Ldev/nuker/pyro/Friend;", "hasFriend", "isFriend", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "isFriendIgnoreEnable", "loadAresFriends", "overwrite", "loadFriends", "loadFutureFriends", "loadImpactFriends", "loadSummitFriends", "salhack", "removeFriend", "saveAresFriends", "saveFriends", "saveFutureFriends", "saveImpactFriends", "saveSummitFriends", "setAlias", "pyroclient"})
public final class FriendManager$Companion {
    @NotNull
    public final FriendManager Method8942() {
        return FriendManager.Method2783();
    }

    public final void Method8943(@NotNull FriendManager friendManager) {
        Intrinsics.Method6567(friendManager, "<set-?>");
        FriendManager.Method2784(friendManager);
    }

    public final void Method8944() {
        try {
            FileWriter writer = new FileWriter("pyro/friends.json");
            Pyro.Field6181.toJson((Object)this.Method8942(), (Appendable)writer);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public final void Method8945() {
        if (new File("pyro/friends.json").exists()) {
            try {
                FileReader reader = new FileReader("pyro/friends.json");
                Object object = Pyro.Field6181.fromJson((Reader)reader, FriendManager.class);
                Intrinsics.Method6561(object, "Pyro.GSON.fromJson(reade\u2026riendManager::class.java)");
                this.Method8943((FriendManager)object);
                reader.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean Method8946(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        for (Class12 friend : this.Method8942().Method2781()) {
            if (!StringsKt.Method9963(friend.Method4896(), name, true)) continue;
            return true;
        }
        return false;
    }

    public final boolean Method8947(@NotNull String name, @Nullable String alias) {
        Intrinsics.Method6567(name, "name");
        if (this.Method8946(name)) {
            return false;
        }
        this.Method8942().Method2781().add(new Class12(name, alias));
        return true;
    }

    @Nullable
    public final Class12 Method8948(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        for (Class12 friend : this.Method8942().Method2781()) {
            if (!StringsKt.Method9963(friend.Method4896(), name, true)) continue;
            return friend;
        }
        return null;
    }

    public final boolean Method8949(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        return this.Method8947(name, name);
    }

    public final boolean Method8950(boolean overwrite) {
        File file = new File(System.getProperty("user.home") + "/Future/friends.json");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                Map[] futureFriends = (Map[])Pyro.Field6181.fromJson((Reader)reader, Pyro.Method8992());
                if (overwrite) {
                    this.Method8942().Method2781().clear();
                }
                for (Map futureFriend : futureFriends) {
                    Object v = futureFriend.get("friend-label");
                    if (v == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    this.Method8949((String)v);
                }
                reader.close();
                this.Method8944();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean Method8951(boolean overwrite) {
        File file = new File(System.getProperty("user.home") + "/Future/friends.json");
        if (file.exists()) {
            try {
                void $this$filterTo$iv$iv;
                FileReader reader = new FileReader(file);
                Map[] futureFriends = (Map[])Pyro.Field6181.fromJson((Reader)reader, Pyro.Method8992());
                boolean bl = false;
                List friends = new ArrayList();
                if (!overwrite) {
                    for (Map futureFriend : futureFriends) {
                        if (overwrite) {
                            Object v = futureFriend.get("friend-label");
                            if (v == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                            }
                            if (!this.Method8946((String)v)) continue;
                        }
                        Map map = futureFriend;
                        if (map == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                        }
                        friends.add(map);
                    }
                }
                reader.close();
                FileWriter writer = new FileWriter(file);
                Iterable $this$filter$iv = this.Method8942().Method2781();
                boolean $i$f$filter = false;
                Iterable iterable = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    void $this$mapTo$iv$iv;
                    Class12 it = (Class12)element$iv$iv;
                    boolean bl2 = false;
                    Iterable $this$map$iv = friends;
                    boolean $i$f$map = false;
                    Iterable iterable2 = $this$map$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.Method9458($this$map$iv, 10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it2;
                        Map map = (Map)item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl3 = false;
                        Object v = it2.get("friend-label");
                        if (v == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                        String string = (String)v;
                        collection.add(string);
                    }
                    if (!(!((List)destination$iv$iv2).contains(it.Method4896()))) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Iterable $this$forEach$iv = (List)destination$iv$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Class12 it = (Class12)element$iv;
                    boolean bl4 = false;
                    friends.add(MapsKt.Method8567(TuplesKt.Method2826("friend-label", it), TuplesKt.Method2826("friend-alias", it)));
                }
                Pyro.Field6181.toJson((Object)friends, (Appendable)writer);
                writer.close();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean Method8952(boolean overwrite, boolean salhack) {
        File file = new File((salhack ? "SalHack" : "Summit") + "/FriendList.json");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                Object object = Pyro.Field6181.fromJson((Reader)reader, Pyro.Method8993());
                if (object == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>");
                }
                Map summitFriends = (Map)object;
                if (overwrite) {
                    this.Method8942().Method2781().clear();
                }
                Map map = summitFriends;
                boolean bl = false;
                for (Map.Entry summitFriend : map.entrySet()) {
                    Object v = ((Map)summitFriend.getValue()).get("Name");
                    if (v == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    if (this.Method8946((String)v)) continue;
                    Object v2 = ((Map)summitFriend.getValue()).get("Name");
                    if (v2 == null) {
                        Intrinsics.Method6551();
                    }
                    this.Method8949((String)v2);
                }
                reader.close();
                this.Method8944();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean Method8953(boolean overwrite, boolean salhack) {
        File file = new File((salhack ? "SalHack" : "Summit") + "/FriendList.json");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                Object object = Pyro.Field6181.fromJson((Reader)reader, Pyro.Method8993());
                if (object == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>");
                }
                Map summitFriends = (Map)object;
                boolean bl = false;
                Map friends = new LinkedHashMap();
                Map map = summitFriends;
                boolean bl2 = false;
                for (Map.Entry summitFriend : map.entrySet()) {
                    if (overwrite) {
                        Object v = ((Map)summitFriend.getValue()).get("Name");
                        if (v == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                        if (!this.Method8946((String)v)) continue;
                    }
                    friends.put(summitFriend.getKey(), MapsKt.Method11577(TuplesKt.Method2826(summitFriend.getKey(), summitFriend.getValue())));
                }
                reader.close();
                FileWriter writer = new FileWriter(file);
                Iterable $this$forEach$iv = this.Method8942().Method2781();
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Class12 it = (Class12)element$iv;
                    boolean bl3 = false;
                    friends.put(it.Method4896(), MapsKt.Method8567(TuplesKt.Method2826("Name", it), TuplesKt.Method2826("Alias", it)));
                }
                Pyro.Field6181.toJson((Object)friends, (Appendable)writer);
                writer.close();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean Method8954(boolean overwrite) {
        File file = new File("Impact/friends.cfg");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                if (overwrite) {
                    this.Method8942().Method2781().clear();
                }
                TextStreamsKt.Method11738(reader, FriendManager$Companion$loadImpactFriends$1.Field2242);
                reader.close();
                this.Method8944();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean Method8955(boolean overwrite) {
        File file = new File("Impact/friends.cfg");
        if (file.exists()) {
            try {
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Class12 it;
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                FileReader reader = new FileReader(file);
                boolean bl = false;
                List friends = new ArrayList();
                TextStreamsKt.Method11738(reader, new FriendManager$Companion$saveImpactFriends$1(overwrite, friends));
                Iterable iterable = this.Method8942().Method2781();
                List list = friends;
                boolean $i$f$filter = false;
                void var7_11 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    it = (Class12)element$iv$iv;
                    boolean bl2 = false;
                    if (!(!friends.contains(it.Method4896()))) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Collection<String> collection = (List)destination$iv$iv;
                $this$filter$iv = collection;
                boolean $i$f$map = false;
                $this$filterTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.Method9458($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    it = (Class12)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl3 = false;
                    String string = it.Method4896();
                    collection.add(string);
                }
                collection = (List)destination$iv$iv;
                list.addAll((Collection)collection);
                reader.close();
                FileWriter writer = new FileWriter(file);
                Iterable $this$forEach$iv = friends;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    String it2 = (String)element$iv;
                    boolean bl4 = false;
                    writer.write(it2 + ':' + it2 + '\n');
                }
                writer.close();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean Method8956(boolean overwrite) {
        File file = new File("Ares/friends.txt");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                if (overwrite) {
                    this.Method8942().Method2781().clear();
                }
                TextStreamsKt.Method11738(reader, FriendManager$Companion$loadAresFriends$1.Field5704);
                reader.close();
                this.Method8944();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean Method8957(boolean overwrite) {
        File file = new File("Ares/friends.txt");
        if (file.exists()) {
            try {
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Class12 it;
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                FileReader reader = new FileReader(file);
                boolean bl = false;
                List friends = new ArrayList();
                TextStreamsKt.Method11738(reader, new FriendManager$Companion$saveAresFriends$1(overwrite, friends));
                Iterable iterable = this.Method8942().Method2781();
                List list = friends;
                boolean $i$f$filter = false;
                void var7_11 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    it = (Class12)element$iv$iv;
                    boolean bl2 = false;
                    if (!(!friends.contains(it.Method4896()))) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Collection<String> collection = (List)destination$iv$iv;
                $this$filter$iv = collection;
                boolean $i$f$map = false;
                $this$filterTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.Method9458($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    it = (Class12)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl3 = false;
                    String string = it.Method4896();
                    collection.add(string);
                }
                collection = (List)destination$iv$iv;
                list.addAll((Collection)collection);
                reader.close();
                FileWriter writer = new FileWriter(file);
                Iterable $this$forEach$iv = friends;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    String it2 = (String)element$iv;
                    boolean bl4 = false;
                    writer.write(it2 + '\n');
                }
                writer.close();
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean Method8958(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        return this.Method8942().Method2779() && this.Method8942().Method2781().stream().anyMatch(new FriendManager$Companion$isFriend$1(name));
    }

    public final boolean Method8959(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        return this.Method8942().Method2781().stream().anyMatch(new FriendManager$Companion$isFriendIgnoreEnable$1(name));
    }

    public final boolean Method8960(@NotNull EntityPlayer player) {
        Intrinsics.Method6567((Object)player, "player");
        GameProfile gameProfile = player.getGameProfile();
        Intrinsics.Method6561((Object)gameProfile, "player.gameProfile");
        String string = gameProfile.getName();
        Intrinsics.Method6561(string, "player.gameProfile.name");
        return this.Method8958(string);
    }

    public final void Method8961(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        if (!this.Method8946(name)) {
            this.Method8949(name);
            this.Method8944();
        }
    }

    public final void Method8962(@NotNull String name, @NotNull String alias) {
        Intrinsics.Method6567(name, "name");
        Intrinsics.Method6567(alias, "alias");
        if (!this.Method8946(name)) {
            this.Method8947(name, alias);
            this.Method8944();
        }
    }

    public final void Method8963(@NotNull String name) {
        Intrinsics.Method6567(name, "name");
        this.Method8942().Method2781().removeIf(new FriendManager$Companion$removeFriend$1(name));
        this.Method8944();
    }

    public final boolean Method8964(@NotNull String name, @Nullable String alias) {
        Intrinsics.Method6567(name, "name");
        Class12 friend = this.Method8948(name);
        if (friend != null) {
            friend.Method4894(alias);
            return true;
        }
        return false;
    }

    private FriendManager$Companion() {
    }

    public /* synthetic */ FriendManager$Companion(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

