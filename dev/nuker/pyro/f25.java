/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f3e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f25
extends Lambda
implements Function2 {
    public static f25 Field5642 = new f25();

    public Object Method943(Object object, Object object2) {
        this.Method7993((String)object, (Function1)object2);
        return Unit.Field4531;
    }

    public void Method7993(@NotNull String string, @NotNull Function1 function1) {
        String string2;
        boolean bl = (Boolean)function1.Method41(true);
        if (bl) {
            string2 = (Object)TextFormatting.GREEN + "Overwrote " + string + " friends list with pyro friends list";
        } else if (!bl) {
            string2 = (Object)TextFormatting.RED + "Could not access " + string + " friends list";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        f3e.Field4001.Method5660((ITextComponent)new TextComponentString(string2));
    }

    public f25() {
        super(2);
    }
}

