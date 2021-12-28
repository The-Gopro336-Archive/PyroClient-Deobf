/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f58;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class f57
extends f58 {
    public boolean Field4072 = false;

    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        if (n3 == 0) {
            boolean bl = this.Field4072 = !this.Field4072;
        }
        if (this.Field4072) {
            switch (n3) {
                case 0: 
                case 1: {
                    break;
                }
                default: {
                    BindSetting bindSetting = (BindSetting)this.Field4111;
                    bindSetting.Method7975(-n3);
                    this.Field4072 = false;
                }
            }
        }
    }

    @Override
    public String Method4820() {
        if (this.Field4072) {
            return "Listening";
        }
        BindSetting bindSetting = (BindSetting)this.Field4111;
        if ((Integer)bindSetting.Method7979() == 0 || (Integer)bindSetting.Method7979() == -1) {
            return bindSetting.Method5989() + ": NONE";
        }
        return bindSetting.Method5989() + ": " + ((Integer)bindSetting.Method7979() > 0 ? Keyboard.getKeyName((int)((Integer)bindSetting.Method7979())) : Mouse.getButtonName((int)(-((Integer)bindSetting.Method7979()).intValue())));
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        if (this.Field4072) {
            PyroRenderUtil.Method12316(this.Method4828() + 3.0f, this.Method4906() - 2.0f, -this.Method4828() + this.Method5094() - 2.0f, this.Method4906() + this.Method4908() - 3.0f, f0H.Field5479.Method7719());
        }
        PyroRenderUtil.Method12313(this.Method4820(), this.Method4828() + 5.0f, this.Method4906(), f0H.Field5479.Method7708());
        return false;
    }

    @Override
    public void Method4798(char c, int n) {
        super.Method4798(c, n);
        if (this.Field4072) {
            this.Field4072 = false;
            BindSetting bindSetting = (BindSetting)this.Field4111;
            if (Keyboard.getKeyName((int)n).equals("BACK")) {
                bindSetting.Method7975(-1);
            } else {
                bindSetting.Method7975(n);
            }
        }
    }

    public f57(f0w f0w2, float f, float f2) {
        super(f0w2, f, f2);
    }
}

