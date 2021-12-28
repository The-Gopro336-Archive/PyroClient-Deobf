/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonPrimitive
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import dev.nuker.pyro.f0c;
import java.awt.Color;
import org.jetbrains.annotations.NotNull;

public class f00 {
    public float Field5374;
    public float Field5375;
    public float Field5376;
    public float Field5377;
    @NotNull
    public static f00 Field5378;
    public static f0c Field5379;

    public void Method7507(float f) {
        this.Field5374 = f;
    }

    public void Method7508(float f) {
        float[] arrf = this.Method7533();
        arrf[2] = f;
        float[] arrf2 = Field5379.Method7936(arrf);
        this.Method7535(arrf2[0]);
        this.Field5375 = arrf2[1];
        this.Field5376 = arrf2[2];
    }

    public float Method7509() {
        return this.Field5374 < 0.0f ? (float)((int)((double)((float)(System.currentTimeMillis() % (long)0x100000) * -this.Field5374) * 0.4) % 255) / 255.0f : this.Field5374;
    }

    public float Method7510() {
        return this.Field5375;
    }

    @NotNull
    public float[] Method7511() {
        return new float[]{this.Method7509(), this.Field5375, this.Field5376, this.Field5377};
    }

    public void Method7512(float f) {
        float[] arrf = this.Method7533();
        arrf[0] = f;
        float[] arrf2 = Field5379.Method7936(arrf);
        this.Method7535(arrf2[0]);
        this.Field5375 = arrf2[1];
        this.Field5376 = arrf2[2];
    }

    public f00(@NotNull float[] arrf) {
        this(arrf[0], arrf[1], arrf[2], arrf[3]);
    }

    static {
        Field5379 = new f0c(null);
        Field5378 = new f00(0, 0, 0, 0);
    }

    @NotNull
    public f00 Method7513() {
        return new f00(this.Field5374, this.Field5375, this.Field5376, this.Field5377);
    }

    public float Method7514() {
        return this.Method7533()[0];
    }

    public int Method7515() {
        return this.Method7524().getRGB();
    }

    public void Method7516(float f) {
        this.Field5377 = f;
    }

    public float Method7517() {
        return this.Method7533()[1];
    }

    public float Method7518() {
        return this.Field5376;
    }

    @NotNull
    public Color Method7519(int n) {
        return Field5379.Method7938(this.Method7529(n));
    }

    public f00(int n, int n2, int n3, int n4) {
        this((float)n / 255.0f, (float)n2 / 255.0f, (float)n3 / 255.0f, (float)n4 / 255.0f);
    }

    public boolean Method7520() {
        return this.Field5374 < 0.0f;
    }

    public void Method7521(float f) {
        this.Method7535(-f);
    }

    public float Method7522() {
        return this.Field5377;
    }

    public float Method7523() {
        return Math.max(0.0f, -this.Field5374);
    }

    @NotNull
    public Color Method7524() {
        return Field5379.Method7938(this.Method7511());
    }

    public float Method7525(int n) {
        return this.Field5374 < 0.0f ? (float)((int)((double)((float)((System.currentTimeMillis() + (long)n) % (long)0x100000) * -this.Field5374) * 0.4) % 255) / 255.0f : this.Field5374;
    }

    @NotNull
    public JsonObject Method7526() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("hue_", (JsonElement)new JsonPrimitive((Number)Float.valueOf(this.Field5374)));
        jsonObject.add("saturation", (JsonElement)new JsonPrimitive((Number)Float.valueOf(this.Field5375)));
        jsonObject.add("value", (JsonElement)new JsonPrimitive((Number)Float.valueOf(this.Field5376)));
        jsonObject.add("alpha", (JsonElement)new JsonPrimitive((Number)Float.valueOf(this.Field5377)));
        return jsonObject;
    }

    public void Method7527(float f) {
        float[] arrf = this.Method7533();
        arrf[1] = f;
        float[] arrf2 = Field5379.Method7936(arrf);
        this.Method7535(arrf2[0]);
        this.Field5375 = arrf2[1];
        this.Field5376 = arrf2[2];
    }

    public static f00 Method7528() {
        return Field5378;
    }

    public f00(float f, float f2, float f3, float f4) {
        this.Field5374 = f;
        this.Field5375 = f2;
        this.Field5376 = f3;
        this.Field5377 = f4;
    }

    @NotNull
    public float[] Method7529(int n) {
        return new float[]{this.Method7525(n), this.Field5375, this.Field5376, this.Field5377};
    }

    public float Method7530() {
        return this.Field5374;
    }

    public float Method7531() {
        return this.Method7533()[2];
    }

    public void Method7532(float f) {
        this.Field5376 = f;
    }

    @NotNull
    public float[] Method7533() {
        return Field5379.Method7933(this.Method7509(), this.Field5375, this.Field5376, this.Field5377);
    }

    public void Method7534(float f) {
        this.Field5375 = f;
    }

    public void Method7535(float f) {
        this.Field5374 = f;
    }
}

