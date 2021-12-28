/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f1s;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public class f1J
implements SingleRedirectModifier {
    public static f1J Field5586 = new f1J();

    @NotNull
    public f1s Method7926(CommandContext commandContext) {
        return ((f1s)commandContext.Method6876()).Method5490("position", (Object)new Vec3d(DoubleArgumentType.Method8094(commandContext, "x"), DoubleArgumentType.Method8094(commandContext, "y"), DoubleArgumentType.Method8094(commandContext, "z")));
    }

    public Object Method4086(CommandContext commandContext) {
        return this.Method7926(commandContext);
    }
}

