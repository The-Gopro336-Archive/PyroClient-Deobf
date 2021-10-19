/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.alt;

import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.HttpAuthenticationService;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import com.mojang.authlib.yggdrasil.response.MinecraftProfilePropertiesResponse;
import com.mojang.util.UUIDTypeAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.client.Minecraft;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"},
   d2 = {"<anonymous>", "", "invoke", "dev/nuker/pyro/alt/AltManager$fillProfileAsync$1$4"}
)
final class AltManager$fillProfileAsync$$inlined$synchronized$lambda$3 extends Lambda implements Function0 {
   // $FF: synthetic field
   final GameProfile $profile$inlined;
   // $FF: synthetic field
   final Consumer $callback$inlined;

   AltManager$fillProfileAsync$$inlined$synchronized$lambda$3(GameProfile var1, Consumer var2) {
      super(0);
      this.$profile$inlined = var1;
      this.$callback$inlined = var2;
   }

   public final void invoke() {
      try {
         URL url = HttpAuthenticationService.constantURL("https://sessionserver.mojang.com/session/minecraft/profile/" + UUIDTypeAdapter.fromUUID(this.$profile$inlined.getId()));
         url = HttpAuthenticationService.concatenateURL(url, "unsigned=false");
         Method var10000 = AltManager.access$getMakeRequestMethod$p(AltManager.INSTANCE);
         Minecraft var10001 = Minecraft.getMinecraft();
         Intrinsics.checkExpressionValueIsNotNull(var10001, "Minecraft.getMinecraft()");
         MinecraftSessionService var9 = var10001.getSessionService();
         if (var9 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");
         }

         MinecraftProfilePropertiesResponse response = (MinecraftProfilePropertiesResponse)var10000.invoke(((YggdrasilMinecraftSessionService)var9).getAuthenticationService(), url, null, MinecraftProfilePropertiesResponse.class);
         if (response != null) {
            GameProfile result = new GameProfile(response.getId(), response.getName());
            result.getProperties().putAll((Multimap)response.getProperties());
            this.$profile$inlined.getProperties().putAll((Multimap)response.getProperties());
            AltManager.access$getFilledProfiles$p(AltManager.INSTANCE).add(result);
            Consumer var7 = this.$callback$inlined;
            if (var7 != null) {
               var7.accept(this.$profile$inlined);
            }
         }
      } catch (InvocationTargetException var4) {
      } catch (AuthenticationException var5) {
      } catch (AuthenticationUnavailableException var6) {
      }

      Minecraft var8 = Minecraft.getMinecraft();
      Intrinsics.checkExpressionValueIsNotNull(var8, "Minecraft.getMinecraft()");
      var8.getSessionService().fillProfileProperties(this.$profile$inlined, true);
      AltManager.access$getFilledProfiles$p(AltManager.INSTANCE).add(this.$profile$inlined);
   }
}
