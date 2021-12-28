/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import org.lwjgl.opengl.GL11;

public class fel {
    public int Field460;
    public long Field461;
    public boolean Field462 = false;

    public void finalize() {
        if (!this.Field462) {
            GL11.glDeleteLists((int)this.Field460, (int)1);
        }
    }

    public void Method746(boolean bl) {
        this.Field462 = bl;
    }

    public void Method747(long l) {
        this.Field461 = l;
    }

    public fel(int n, long l, boolean bl) {
        this.Field460 = n;
        this.Field461 = l;
        this.Field462 = bl;
    }

    public int Method748() {
        return this.Field460;
    }

    public fel(int n, long l) {
        this.Field460 = n;
        this.Field461 = l;
    }

    public boolean Method749() {
        return this.Field462;
    }

    public long Method750() {
        return this.Field461;
    }
}

