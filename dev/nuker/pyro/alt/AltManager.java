/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.alt;

import com.google.gson.Gson;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import dev.nuker.pyro.Pyro;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Ldev/nuker/pyro/alt/AltManager;", "", "()V", "alts", "", "Ldev/nuker/pyro/alt/Alt;", "getAlts", "()Ljava/util/List;", "filledProfiles", "Lcom/mojang/authlib/GameProfile;", "makeRequestMethod", "Ljava/lang/reflect/Method;", "storage", "Ldev/nuker/pyro/alt/AltManager$AltStorage;", "addAlt", "", "alt", "fillProfileAsync", "profile", "callback", "Ljava/util/function/Consumer;", "getAltProfile", "loadAlts", "", "makeFirst", "removeAlt", "saveAlts", "AltStorage", "pyroclient"}
)
public final class AltManager {
   private static final Method makeRequestMethod;
   private static final List filledProfiles;
   private static AltManager$AltStorage storage;
   public static final AltManager INSTANCE;

   @NotNull
   public final GameProfile fillProfileAsync(@NotNull GameProfile profile, @Nullable Consumer callback) {
      Intrinsics.checkParameterIsNotNull(profile, "profile");
      List var3 = filledProfiles;
      boolean var4 = false;
      boolean var5 = false;
      synchronized(var3){}

      GameProfile var16;
      try {
         int var6 = false;
         if (!filledProfiles.stream().anyMatch((Predicate)(new AltManager$fillProfileAsync$$inlined$synchronized$lambda$1(profile, callback)))) {
            ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new AltManager$fillProfileAsync$$inlined$synchronized$lambda$3(profile, callback)), 30, (Object)null);
            GameProfile var15 = profile;
            return var15;
         }

         if (callback != null) {
            Iterable $this$first$iv = (Iterable)filledProfiles;
            int $i$f$first = false;
            Iterator var10 = $this$first$iv.iterator();

            Object element$iv;
            GameProfile it;
            do {
               if (!var10.hasNext()) {
                  throw (Throwable)(new NoSuchElementException("Collection contains no element matching the predicate."));
               }

               element$iv = var10.next();
               it = (GameProfile)element$iv;
               int var13 = false;
            } while(!Intrinsics.areEqual((Object)it.getId(), (Object)profile.getId()));

            callback.accept(element$iv);
         }

         Object var10000 = filledProfiles.stream().filter((Predicate)(new AltManager$fillProfileAsync$$inlined$synchronized$lambda$2(profile, callback))).findAny().get();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "filledProfiles.stream().…file.id }.findAny().get()");
         var16 = (GameProfile)var10000;
      } finally {
         ;
      }

      return var16;
   }

   // $FF: synthetic method
   public static GameProfile fillProfileAsync$default(AltManager var0, GameProfile var1, Consumer var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = (Consumer)null;
      }

      return var0.fillProfileAsync(var1, var2);
   }

   @NotNull
   public final GameProfile getAltProfile(@NotNull Alt alt, @Nullable Consumer callback) {
      Intrinsics.checkParameterIsNotNull(alt, "alt");
      return this.fillProfileAsync(alt.getGameProfile(), (Consumer)(new AltManager$getAltProfile$1(callback, alt)));
   }

   // $FF: synthetic method
   public static GameProfile getAltProfile$default(AltManager var0, Alt var1, Consumer var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = (Consumer)null;
      }

      return var0.getAltProfile(var1, var2);
   }

   @NotNull
   public final List getAlts() {
      AltManager$AltStorage var10000 = storage;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("storage");
      }

      return var10000.getAlts();
   }

   public final boolean addAlt(@NotNull Alt alt) {
      Intrinsics.checkParameterIsNotNull(alt, "alt");
      boolean var10000;
      if (this.getAlts().contains(alt)) {
         var10000 = false;
      } else {
         this.getAlts().add(alt);
         this.saveAlts();
         var10000 = true;
      }

      return var10000;
   }

   public final void removeAlt(@NotNull Alt alt) {
      Intrinsics.checkParameterIsNotNull(alt, "alt");
      this.getAlts().remove(alt);
      this.saveAlts();
   }

   public final void makeFirst(@NotNull Alt alt) {
      Intrinsics.checkParameterIsNotNull(alt, "alt");
      this.getAlts().remove(alt);
      this.getAlts().add(0, alt);
      this.saveAlts();
   }

   public final void saveAlts() {
      try {
         FileWriter writer = new FileWriter("pyro/alts.json");
         Gson var10000 = Pyro.GSON;
         AltManager$AltStorage var10001 = storage;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         var10000.toJson(var10001, (Appendable)writer);
         writer.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   public final void loadAlts() {
      if ((new File("pyro/alts.json")).exists()) {
         try {
            FileReader reader = new FileReader("pyro/alts.json");
            Object var10000 = Pyro.GSON.fromJson((Reader)reader, AltManager$AltStorage.class);
            Intrinsics.checkExpressionValueIsNotNull(var10000, "Pyro.GSON.fromJson(reader, AltStorage::class.java)");
            storage = (AltManager$AltStorage)var10000;
            reader.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      } else {
         storage = new AltManager$AltStorage();
      }

   }

   private AltManager() {
   }

   static {
      AltManager var0 = new AltManager();
      INSTANCE = var0;
      Method method = YggdrasilAuthenticationService.class.getDeclaredMethod("makeRequest", URL.class, Object.class, Class.class);
      Intrinsics.checkExpressionValueIsNotNull(method, "method");
      method.setAccessible(true);
      makeRequestMethod = method;
      var0.loadAlts();
      boolean var2 = false;
      filledProfiles = (List)(new ArrayList());
   }

   // $FF: synthetic method
   public static final Method access$getMakeRequestMethod$p(AltManager $this) {
      return makeRequestMethod;
   }

   // $FF: synthetic method
   public static final List access$getFilledProfiles$p(AltManager $this) {
      return filledProfiles;
   }
}
