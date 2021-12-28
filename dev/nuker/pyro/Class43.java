/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiPageButtonList$GuiResponder
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$LogicOp
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ChatAllowedCharacters
 *  net.minecraft.util.math.MathHelper
 */
package dev.nuker.pyro;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.math.MathHelper;

public class Class43
extends Gui {
    public int Field4633;
    public FontRenderer Field4634;
    public int Field4635;
    public int Field4636;
    public int Field4637;
    public int Field4638;
    public String Field4639 = "";
    public int Field4640 = 32;
    public int Field4641;
    public boolean Field4642 = true;
    public boolean Field4643 = true;
    public boolean Field4644;
    public boolean Field4645 = true;
    public int Field4646;
    public int Field4647;
    public int Field4648;
    public int Field4649 = 0xE0E0E0;
    public int Field4650 = 0x707070;
    public boolean Field4651 = true;
    public GuiPageButtonList.GuiResponder Field4652;
    public Predicate<String> Field4653 = Predicates.alwaysTrue();

    public void Method5686(boolean bl) {
        this.Field4651 = bl;
    }

    public String Method6789() {
        return this.Field4639;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method6790(int n, int n2, int n3) {
        boolean bl;
        boolean bl2 = bl = n >= this.Field4635 && n < this.Field4635 + this.Field4637 && n2 >= this.Field4636 && n2 < this.Field4636 + this.Field4638;
        if (this.Field4643) {
            this.Method4816(bl);
        }
        if (this.Field4644 && bl && n3 == 0) {
            int n4 = n - this.Field4635;
            if (this.Field4642) {
                n4 -= 4;
            }
            String string = this.Field4634.trimStringToWidth(this.Field4639.substring(this.Field4646), this.Method6816());
            this.Method6804(this.Field4634.trimStringToWidth(string, n4).length() + this.Field4646);
        }
    }

    public int Method6791() {
        return this.Field4640;
    }

    public int Method6792(int n) {
        return this.Method6812(n, this.Method5679());
    }

    public boolean Method6793() {
        return this.Field4651;
    }

    public void Method6794(GuiPageButtonList.GuiResponder guiResponder) {
        this.Field4652 = guiResponder;
    }

    public int Method6795() {
        return this.Field4648;
    }

    public int Method6796(int n, int n2, boolean bl) {
        int n3 = n2;
        boolean bl2 = n < 0;
        int n4 = Math.abs(n);
        for (int i = 0; i < n4; ++i) {
            if (!bl2) {
                int n5 = this.Field4639.length();
                if ((n3 = this.Field4639.indexOf(32, n3)) == -1) {
                    n3 = n5;
                    continue;
                }
                while (bl && n3 < n5 && this.Field4639.charAt(n3) == ' ') {
                    ++n3;
                }
                continue;
            }
            while (bl && n3 > 0 && this.Field4639.charAt(n3 - 1) == ' ') {
                --n3;
            }
            while (n3 > 0 && this.Field4639.charAt(n3 - 1) != ' ') {
                --n3;
            }
        }
        return n3;
    }

    public void Method6797() {
        this.Method6804(0);
    }

    public void Method6798(int n, int n2, int n3, int n4) {
        int n5;
        if (n < n3) {
            n5 = n;
            n = n3;
            n3 = n5;
        }
        if (n2 < n4) {
            n5 = n2;
            n2 = n4;
            n4 = n5;
        }
        if (n3 > this.Field4635 + this.Field4637) {
            n3 = this.Field4635 + this.Field4637;
        }
        if (n > this.Field4635 + this.Field4637) {
            n = this.Field4635 + this.Field4637;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.color((float)0.0f, (float)0.0f, (float)255.0f, (float)255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp((GlStateManager.LogicOp)GlStateManager.LogicOp.OR_REVERSE);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)n, (double)n4, 0.0).endVertex();
        bufferBuilder.pos((double)n3, (double)n4, 0.0).endVertex();
        bufferBuilder.pos((double)n3, (double)n2, 0.0).endVertex();
        bufferBuilder.pos((double)n, (double)n2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }

    public void Method5680(int n) {
        this.Field4640 = n;
        if (this.Field4639.length() > n) {
            this.Field4639 = this.Field4639.substring(0, n);
        }
    }

    public void Method6799(Predicate predicate) {
        this.Field4653 = predicate;
    }

    public void Method5681(boolean bl) {
        this.Field4643 = bl;
    }

    public void Method6800(int n) {
        this.Field4650 = n;
    }

    public boolean Method5694() {
        return this.Field4644;
    }

    public void Method6801() {
        this.Method6804(this.Field4639.length());
    }

    public void Method5691(String string) {
        int n;
        String string2 = "";
        String string3 = ChatAllowedCharacters.filterAllowedCharacters((String)string);
        int n2 = this.Field4647 < this.Field4648 ? this.Field4647 : this.Field4648;
        int n3 = this.Field4647 < this.Field4648 ? this.Field4648 : this.Field4647;
        int n4 = this.Field4640 - this.Field4639.length() - (n2 - n3);
        if (!this.Field4639.isEmpty()) {
            string2 = string2 + this.Field4639.substring(0, n2);
        }
        if (n4 < string3.length()) {
            string2 = string2 + string3.substring(0, n4);
            n = n4;
        } else {
            string2 = string2 + string3;
            n = string3.length();
        }
        if (!this.Field4639.isEmpty() && n3 < this.Field4639.length()) {
            string2 = string2 + this.Field4639.substring(n3);
        }
        if (this.Field4653.apply((Object)string2)) {
            this.Field4639 = string2;
            this.Method6802(n2 - this.Field4648 + n);
            this.Method6803(this.Field4633, this.Field4639);
        }
    }

    public void Method6802(int n) {
        this.Method6804(this.Field4648 + n);
    }

    public void Method6803(int n, String string) {
        if (this.Field4652 != null) {
            this.Field4652.setEntryValue(n, string);
        }
    }

    public void Method6804(int n) {
        this.Field4647 = n;
        int n2 = this.Field4639.length();
        this.Field4647 = MathHelper.clamp((int)this.Field4647, (int)0, (int)n2);
        this.Method6805(this.Field4647);
    }

    public int Method5679() {
        return this.Field4647;
    }

    public void Method6805(int n) {
        int n2 = this.Field4639.length();
        if (n > n2) {
            n = n2;
        }
        if (n < 0) {
            n = 0;
        }
        this.Field4648 = n;
        if (this.Field4634 != null) {
            if (this.Field4646 > n2) {
                this.Field4646 = n2;
            }
            int n3 = this.Method6816();
            String string = this.Field4634.trimStringToWidth(this.Field4639.substring(this.Field4646), n3);
            int n4 = string.length() + this.Field4646;
            if (n == this.Field4646) {
                this.Field4646 -= this.Field4634.trimStringToWidth(this.Field4639, n3, true).length();
            }
            if (n > n4) {
                this.Field4646 += n - n4;
            } else if (n <= this.Field4646) {
                this.Field4646 -= this.Field4646 - n;
            }
            this.Field4646 = MathHelper.clamp((int)this.Field4646, (int)0, (int)n2);
        }
    }

    public void Method5688(String string) {
        if (this.Field4653.apply((Object)string)) {
            this.Field4639 = string.length() > this.Field4640 ? string.substring(0, this.Field4640) : string;
            this.Method6801();
        }
    }

    public Class43(int n, FontRenderer fontRenderer, int n2, int n3, int n4, int n5) {
        this.Field4633 = n;
        this.Field4634 = fontRenderer;
        this.Field4635 = n2;
        this.Field4636 = n3;
        this.Field4637 = n4;
        this.Field4638 = n5;
    }

    public void Method6806(boolean bl) {
        this.Field4645 = bl;
    }

    public void Method6807(boolean bl) {
        this.Field4642 = bl;
    }

    public int Method6808() {
        return this.Field4633;
    }

    public void Method6809(int n) {
        this.Field4649 = n;
    }

    public void Method4816(boolean bl) {
        if (bl && !this.Field4644) {
            this.Field4641 = 0;
        }
        this.Field4644 = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method6810() {
        if (this.Method6793()) {
            if (this.Method6813()) {
                Class43.drawRect((int)(this.Field4635 - 1), (int)(this.Field4636 - 1), (int)(this.Field4635 + this.Field4637 + 1), (int)(this.Field4636 + this.Field4638 + 1), (int)-6250336);
                Class43.drawRect((int)this.Field4635, (int)this.Field4636, (int)(this.Field4635 + this.Field4637), (int)(this.Field4636 + this.Field4638), (int)-16777216);
            }
            int n = this.Field4645 ? this.Field4649 : this.Field4650;
            int n2 = this.Field4647 - this.Field4646;
            int n3 = this.Field4648 - this.Field4646;
            String string = this.Field4634.trimStringToWidth(this.Field4639.substring(this.Field4646), this.Method6816());
            boolean bl = n2 >= 0 && n2 <= string.length();
            boolean bl2 = this.Field4644 && this.Field4641 / 6 % 2 == 0 && bl;
            int n4 = this.Field4642 ? this.Field4635 + 4 : this.Field4635;
            int n5 = this.Field4642 ? this.Field4636 + (this.Field4638 - 8) / 2 : this.Field4636;
            int n6 = n4;
            if (n3 > string.length()) {
                n3 = string.length();
            }
            if (!string.isEmpty()) {
                String string2 = bl ? string.substring(0, n2) : string;
                n6 = this.Field4634.drawStringWithShadow(string2.replaceAll("(?s).", "*"), (float)n4, (float)n5, n);
            }
            boolean bl3 = this.Field4647 < this.Field4639.length() || this.Field4639.length() >= this.Method6791();
            int n7 = n6;
            if (!bl) {
                n7 = n2 > 0 ? n4 + this.Field4637 : n4;
            } else if (bl3) {
                n7 = n6 - 1;
                --n6;
            }
            if (!string.isEmpty() && bl && n2 < string.length()) {
                n6 = this.Field4634.drawStringWithShadow(string.substring(n2), (float)n6, (float)n5, n);
            }
            if (bl2) {
                if (bl3) {
                    Gui.drawRect((int)n7, (int)(n5 - 1), (int)(n7 + 1), (int)(n5 + 1 + this.Field4634.FONT_HEIGHT), (int)-3092272);
                } else {
                    this.Field4634.drawStringWithShadow("_", (float)n7, (float)n5, n);
                }
            }
            if (n3 != n2) {
                int n8 = n4 + this.Field4634.getStringWidth(string.substring(0, n3));
                this.Method6798(n7, n5 - 1, n8 - 1, n5 + 1 + this.Field4634.FONT_HEIGHT);
            }
        }
    }

    public boolean Method6811(char c, int n) {
        if (!this.Field4644) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA((int)n)) {
            this.Method6801();
            this.Method6805(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC((int)n)) {
            GuiScreen.setClipboardString((String)this.Method6814());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV((int)n)) {
            if (this.Field4645) {
                this.Method5691(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX((int)n)) {
            GuiScreen.setClipboardString((String)this.Method6814());
            if (this.Field4645) {
                this.Method5691("");
            }
            return true;
        }
        switch (n) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.Field4645) {
                        this.Method5692(-1);
                    }
                } else if (this.Field4645) {
                    this.Method6815(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.Method6805(0);
                } else {
                    this.Method6797();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.Method6805(this.Method6812(-1, this.Method6795()));
                    } else {
                        this.Method6805(this.Method6795() - 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.Method6804(this.Method6792(-1));
                } else {
                    this.Method6802(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.Method6805(this.Method6812(1, this.Method6795()));
                    } else {
                        this.Method6805(this.Method6795() + 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.Method6804(this.Method6792(1));
                } else {
                    this.Method6802(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.Method6805(this.Field4639.length());
                } else {
                    this.Method6801();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.Field4645) {
                        this.Method5692(1);
                    }
                } else if (this.Field4645) {
                    this.Method6815(1);
                }
                return true;
            }
        }
        if (ChatAllowedCharacters.isAllowedCharacter((char)c)) {
            if (this.Field4645) {
                this.Method5691(Character.toString(c));
            }
            return true;
        }
        return false;
    }

    public int Method6812(int n, int n2) {
        return this.Method6796(n, n2, true);
    }

    public boolean Method6813() {
        return this.Field4642;
    }

    public String Method6814() {
        int n = this.Field4647 < this.Field4648 ? this.Field4647 : this.Field4648;
        int n2 = this.Field4647 < this.Field4648 ? this.Field4648 : this.Field4647;
        return this.Field4639.substring(n, n2);
    }

    public void Method6815(int n) {
        if (!this.Field4639.isEmpty()) {
            if (this.Field4648 != this.Field4647) {
                this.Method5691("");
            } else {
                boolean bl = n < 0;
                int n2 = bl ? this.Field4647 + n : this.Field4647;
                int n3 = bl ? this.Field4647 : this.Field4647 + n;
                String string = "";
                if (n2 >= 0) {
                    string = this.Field4639.substring(0, n2);
                }
                if (n3 < this.Field4639.length()) {
                    string = string + this.Field4639.substring(n3);
                }
                if (this.Field4653.apply((Object)string)) {
                    this.Field4639 = string;
                    if (bl) {
                        this.Method6802(n);
                    }
                    this.Method6803(this.Field4633, this.Field4639);
                }
            }
        }
    }

    public void Method5692(int n) {
        if (!this.Field4639.isEmpty()) {
            if (this.Field4648 != this.Field4647) {
                this.Method5691("");
            } else {
                this.Method6815(this.Method6792(n) - this.Field4647);
            }
        }
    }

    public int Method6816() {
        return this.Method6813() ? this.Field4637 - 8 : this.Field4637;
    }

    public void Method6817() {
        ++this.Field4641;
    }
}

