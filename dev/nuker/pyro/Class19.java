/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

public class Class19
implements Comparator {
    public int compare(Object object, Object object2) {
        boolean bl;
        char c;
        char c2;
        int n;
        boolean bl2 = false;
        f0w f0w2 = (f0w)object;
        boolean bl3 = false;
        CharSequence charSequence = f0w2.Method7977();
        boolean bl4 = false;
        int n2 = 0;
        CharSequence charSequence2 = charSequence;
        for (n = 0; n < charSequence2.length(); ++n) {
            c = c2 = charSequence2.charAt(n);
            bl = false;
            if (!(c == '.')) continue;
            ++n2;
        }
        f0w2 = (f0w)object2;
        Comparable comparable = Integer.valueOf(n2);
        bl3 = false;
        charSequence = f0w2.Method7977();
        bl4 = false;
        n2 = 0;
        charSequence2 = charSequence;
        for (n = 0; n < charSequence2.length(); ++n) {
            c = c2 = charSequence2.charAt(n);
            bl = false;
            if (!(c == '.')) continue;
            ++n2;
        }
        Integer n3 = n2;
        return ComparisonsKt.Method8224(comparable, (Comparable)n3);
    }
}

