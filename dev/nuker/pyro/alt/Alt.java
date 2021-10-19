/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.alt;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0004¨\u0006#"},
   d2 = {"Ldev/nuker/pyro/alt/Alt;", "", "username", "", "(Ljava/lang/String;)V", "email", "password", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "getGameProfile", "()Lcom/mojang/authlib/GameProfile;", "isCracked", "", "()Z", "getPassword", "setPassword", "getUsername", "setUsername", "getUuid", "setUuid", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "pyroclient"}
)
public final class Alt {
   @NotNull
   private String email;
   @NotNull
   private String username;
   @NotNull
   private String password;
   @NotNull
   private String uuid;

   public final boolean isCracked() {
      CharSequence var1 = (CharSequence)this.password;
      boolean var2 = false;
      return var1.length() == 0;
   }

   @NotNull
   public final GameProfile getGameProfile() {
      CharSequence var1 = (CharSequence)this.uuid;
      boolean var2 = false;
      boolean var5 = var1.length() == 0;
      UUID var10000 = var5 ? null : UUID.fromString(this.uuid);
      String var6 = this.username;
      UUID var7 = var10000;
      return new GameProfile(var7, var6);
   }

   @NotNull
   public final String getEmail() {
      return this.email;
   }

   public final void setEmail(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.email = var1;
   }

   @NotNull
   public final String getUsername() {
      return this.username;
   }

   public final void setUsername(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.username = var1;
   }

   @NotNull
   public final String getPassword() {
      return this.password;
   }

   public final void setPassword(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.password = var1;
   }

   @NotNull
   public final String getUuid() {
      return this.uuid;
   }

   public final void setUuid(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.uuid = var1;
   }

   public Alt(@NotNull String email, @NotNull String username, @NotNull String password, @NotNull String uuid) {
      Intrinsics.checkParameterIsNotNull(email, "email");
      Intrinsics.checkParameterIsNotNull(username, "username");
      Intrinsics.checkParameterIsNotNull(password, "password");
      Intrinsics.checkParameterIsNotNull(uuid, "uuid");
      super();
      this.email = email;
      this.username = username;
      this.password = password;
      this.uuid = uuid;
   }

   public Alt(@NotNull String username) {
      Intrinsics.checkParameterIsNotNull(username, "username");
      String var2 = "OfflinePlayer:" + username;
      Charset var10004 = Charsets.UTF_8;
      Intrinsics.checkExpressionValueIsNotNull(var10004, "Charsets.UTF_8");
      Charset var3 = var10004;
      String var8 = "";
      String var6 = "";
      boolean var4 = false;
      if (var2 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         byte[] var10000 = var2.getBytes(var3);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "(this as java.lang.String).getBytes(charset)");
         byte[] var9 = var10000;
         String var10 = UUID.nameUUIDFromBytes(var9).toString();
         Intrinsics.checkExpressionValueIsNotNull(var10, "UUID.nameUUIDFromBytes(\"…arsets.UTF_8)).toString()");
         this(var6, username, var8, var10);
      }
   }

   @NotNull
   public final String component1() {
      return this.email;
   }

   @NotNull
   public final String component2() {
      return this.username;
   }

   @NotNull
   public final String component3() {
      return this.password;
   }

   @NotNull
   public final String component4() {
      return this.uuid;
   }

   @NotNull
   public final Alt copy(@NotNull String email, @NotNull String username, @NotNull String password, @NotNull String uuid) {
      Intrinsics.checkParameterIsNotNull(email, "email");
      Intrinsics.checkParameterIsNotNull(username, "username");
      Intrinsics.checkParameterIsNotNull(password, "password");
      Intrinsics.checkParameterIsNotNull(uuid, "uuid");
      return new Alt(email, username, password, uuid);
   }

   // $FF: synthetic method
   public static Alt copy$default(Alt var0, String var1, String var2, String var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.email;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.username;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.password;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.uuid;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "Alt(email=" + this.email + ", username=" + this.username + ", password=" + this.password + ", uuid=" + this.uuid + ")";
   }

   public int hashCode() {
      String var10000 = this.email;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.username;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.password;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.uuid;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof Alt) {
            Alt var2 = (Alt)var1;
            if (Intrinsics.areEqual((Object)this.email, (Object)var2.email) && Intrinsics.areEqual((Object)this.username, (Object)var2.username) && Intrinsics.areEqual((Object)this.password, (Object)var2.password) && Intrinsics.areEqual((Object)this.uuid, (Object)var2.uuid)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
