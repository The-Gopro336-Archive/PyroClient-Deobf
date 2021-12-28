/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameType
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.nuker.pyro.f1E;
import dev.nuker.pyro.f1F;
import dev.nuker.pyro.f1G;
import dev.nuker.pyro.f1H;
import dev.nuker.pyro.f1I;
import dev.nuker.pyro.f1J;
import dev.nuker.pyro.f1K;
import dev.nuker.pyro.f1L;
import dev.nuker.pyro.f1M;
import dev.nuker.pyro.f1N;
import dev.nuker.pyro.f1O;
import dev.nuker.pyro.f1P;
import dev.nuker.pyro.f1Q;
import dev.nuker.pyro.f3e;
import dev.nuker.pyro.fe4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.NotNull;

public class f1R {
    @NotNull
    public static List<EntityOtherPlayerMP> Field5608;
    public static int Field5609;
    public static f1R Field5610;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method7953(String string) {
        Object v1;
        Iterable iterable;
        block5: {
            Iterable iterable2;
            EntityOtherPlayerMP entityOtherPlayerMP;
            iterable = Field5608;
            boolean bl = false;
            if (iterable instanceof Collection) {
                if (((Collection)iterable).isEmpty()) {
                    return false;
                }
            }
            Iterator iterator2 = iterable.iterator();
            do {
                if (!iterator2.hasNext()) return false;
                iterable2 = iterator2.next();
                entityOtherPlayerMP = (EntityOtherPlayerMP)iterable2;
                boolean bl2 = false;
            } while (!Intrinsics.Method6572(entityOtherPlayerMP.getGameProfile().getName(), string));
            boolean bl3 = true;
            if (!bl3) return false;
            Iterable iterable3 = Field5608;
            boolean bl4 = false;
            iterable2 = iterable3;
            boolean bl5 = false;
            for (Object t : iterable2) {
                EntityOtherPlayerMP entityOtherPlayerMP2 = (EntityOtherPlayerMP)t;
                boolean bl6 = false;
                if (!Intrinsics.Method6572(entityOtherPlayerMP2.getGameProfile().getName(), string)) continue;
                v1 = t;
                break block5;
            }
            v1 = null;
        }
        Iterable iterable4 = iterable = (EntityOtherPlayerMP)v1;
        if (iterable4 == null) {
            Intrinsics.Method6551();
        }
        fe4.Field250.Method389((EntityOtherPlayerMP)iterable4);
        Field5608.remove(iterable);
        return true;
    }

    public void Method7954(int n) {
        Field5609 = n;
    }

    @JvmStatic
    public static void Method7955(@NotNull CommandDispatcher commandDispatcher) {
        LiteralCommandNode literalCommandNode = commandDispatcher.Method8399(f3e.Method5657("fakeplayer"));
        commandDispatcher.Method8399((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657("fakeplayer").Method12041(f3e.Method5657("spawn").Method12044(f1E.Field5596))).Method12041(f3e.Method5657("position").Method12041(f3e.Method5658("x", DoubleArgumentType.Method8091()).Method12041(f3e.Method5658("y", DoubleArgumentType.Method8091()).Method12041(f3e.Method5658("z", DoubleArgumentType.Method8091()).Method12049(literalCommandNode, f1J.Field5586)))))).Method12041(f3e.Method5657("name").Method12041(f3e.Method5658("name", StringArgumentType.Method5877()).Method12049(literalCommandNode, f1K.Field5590)))).Method12041(((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.Method5657("gamemode").Method12041(f3e.Method5657("creative").Method12049(literalCommandNode, f1L.Field5616))).Method12041(f3e.Method5657("survival").Method12049(literalCommandNode, f1M.Field5621))).Method12041(f3e.Method5657("spectator").Method12049(literalCommandNode, f1N.Field5622)))).Method12041(f3e.Method5657("health").Method12041(f3e.Method5658("health", FloatArgumentType.Method9247(0.0f)).Method12049(literalCommandNode, f1O.Field5623)))).Method12041(f3e.Method5657("rotate").Method12041(f3e.Method5658("yaw", FloatArgumentType.Method9248(0.0f, 360.0f)).Method12041(f3e.Method5658("pitch", FloatArgumentType.Method9248(-90.0f, 90.0f)).Method12049(literalCommandNode, f1P.Field5600))))).Method12041(f3e.Method5657("modsignore").Method12049(literalCommandNode, f1Q.Field5602))).Method12041(f3e.Method5657("naked").Method12049(literalCommandNode, f1F.Field5598))).Method12041(f3e.Method5657("remove").Method12041(f3e.Method5658("name", StringArgumentType.Method5877()).Method12044(f1G.Field5599)))).Method12041(f3e.Method5657("list").Method12044(f1H.Field5578))).Method12041(f3e.Method5657("purge").Method12044(f1I.Field5584)));
    }

    public boolean Method7956(String string, Vec3d vec3d, Vec2f vec2f, GameType gameType, float f, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4;
        int n;
        Iterable iterable;
        block6: {
            iterable = Field5608;
            n = 0;
            if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                bl4 = false;
            } else {
                for (Object t : iterable) {
                    EntityOtherPlayerMP entityOtherPlayerMP = (EntityOtherPlayerMP)t;
                    boolean bl5 = false;
                    if (!Intrinsics.Method6572(entityOtherPlayerMP.getGameProfile().getName(), string)) continue;
                    bl4 = true;
                    break block6;
                }
                bl4 = false;
            }
        }
        if (!bl4) {
            n = Field5609;
            Field5609 = n + 1;
            iterable = fe4.Field250.Method391(string, -10000 - n, bl);
            iterable.setGameType(gameType);
            iterable.capabilities.disableDamage = true;
            iterable.setPositionAndRotation(vec3d.x, vec3d.y, vec3d.z, vec2f.x, vec2f.y);
            ((EntityOtherPlayerMP)iterable).rotationYawHead = vec2f.x;
            iterable.setHealth(f);
            if (!bl2) {
                ((EntityOtherPlayerMP)iterable).inventory.copyInventory(Minecraft.getMinecraft().player.inventory);
            }
            Field5608.add((EntityOtherPlayerMP)iterable);
            bl3 = true;
        } else {
            bl3 = false;
        }
        return bl3;
    }

    public void Method7957(@NotNull List list) {
        Field5608 = list;
    }

    public void Method7958() {
        while (true) {
            Collection collection = Field5608;
            boolean bl = false;
            if (!(!collection.isEmpty())) break;
            EntityOtherPlayerMP entityOtherPlayerMP = Field5608.get(0);
            if (entityOtherPlayerMP == null) {
                Intrinsics.Method6551();
            }
            this.Method7953(entityOtherPlayerMP.getGameProfile().getName());
        }
        Field5609 = 0;
    }

    public static boolean Method7959(f1R f1R2, String string) {
        return f1R2.Method7953(string);
    }

    static {
        f1R f1R2;
        Field5610 = f1R2 = new f1R();
        boolean bl = false;
        Field5608 = new ArrayList();
    }

    public static boolean Method7960(f1R f1R2, String string, Vec3d vec3d, Vec2f vec2f, GameType gameType, float f, boolean bl, boolean bl2) {
        return f1R2.Method7956(string, vec3d, vec2f, gameType, f, bl, bl2);
    }

    @NotNull
    public List Method7961() {
        return Field5608;
    }

    public int Method7962() {
        return Field5609;
    }
}

