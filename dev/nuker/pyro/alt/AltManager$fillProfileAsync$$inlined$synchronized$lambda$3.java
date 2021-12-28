/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.HttpAuthenticationService
 *  com.mojang.authlib.exceptions.AuthenticationException
 *  com.mojang.authlib.exceptions.AuthenticationUnavailableException
 *  com.mojang.authlib.minecraft.MinecraftSessionService
 *  com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService
 *  com.mojang.authlib.yggdrasil.response.MinecraftProfilePropertiesResponse
 *  com.mojang.util.UUIDTypeAdapter
 *  net.minecraft.client.Minecraft
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
import dev.nuker.pyro.alt.AltManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.UUID;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.client.Minecraft;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2={"<anonymous>", "", "invoke", "dev/nuker/pyro/alt/AltManager$fillProfileAsync$1$4"})
final class AltManager$fillProfileAsync$$inlined$synchronized$lambda$3
extends Lambda
implements Function0 {
    final /* synthetic */ GameProfile Field4103;
    final /* synthetic */ Consumer Field4104;

    AltManager$fillProfileAsync$$inlined$synchronized$lambda$3(GameProfile gameProfile, Consumer consumer) {
        this.Field4103 = gameProfile;
        this.Field4104 = consumer;
        super(0);
    }

    public final void Method3860() {
        try {
            URL url = HttpAuthenticationService.constantURL((String)("https://sessionserver.mojang.com/session/minecraft/profile/" + UUIDTypeAdapter.fromUUID((UUID)this.Field4103.getId())));
            url = HttpAuthenticationService.concatenateURL((URL)url, (String)"unsigned=false");
            Method method = AltManager.Method9682(AltManager.Field6702);
            Minecraft minecraft = Minecraft.getMinecraft();
            Intrinsics.Method6561((Object)minecraft, "Minecraft.getMinecraft()");
            MinecraftSessionService minecraftSessionService = minecraft.getSessionService();
            if (minecraftSessionService == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");
            }
            MinecraftProfilePropertiesResponse response = (MinecraftProfilePropertiesResponse)method.invoke((Object)((YggdrasilMinecraftSessionService)minecraftSessionService).getAuthenticationService(), url, null, MinecraftProfilePropertiesResponse.class);
            if (response != null) {
                GameProfile result = new GameProfile(response.getId(), response.getName());
                result.getProperties().putAll((Multimap)response.getProperties());
                this.Field4103.getProperties().putAll((Multimap)response.getProperties());
                AltManager.Method9683(AltManager.Field6702).add(result);
                Consumer consumer = this.Field4104;
                if (consumer != null) {
                    consumer.accept(this.Field4103);
                }
            }
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (AuthenticationException authenticationException) {
        }
        catch (AuthenticationUnavailableException authenticationUnavailableException) {
            // empty catch block
        }
        Minecraft minecraft = Minecraft.getMinecraft();
        Intrinsics.Method6561((Object)minecraft, "Minecraft.getMinecraft()");
        minecraft.getSessionService().fillProfileProperties(this.Field4103, true);
        AltManager.Method9683(AltManager.Field6702).add(this.Field4103);
    }
}

