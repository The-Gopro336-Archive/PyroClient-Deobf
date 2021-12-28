/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.api.FontManager$CustomFontConfig;
import dev.nuker.pyro.util.font.GameFontRenderer;
import java.awt.Font;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Class55 {
    public static Class55 Field4429 = new Class55();
    public GameFontRenderer Field4430;
    public GameFontRenderer Field4431;
    public GameFontRenderer Field4432;
    public GameFontRenderer Field4433;
    public FontManager$CustomFontConfig Field4434;
    public FontManager$CustomFontConfig Field4435;

    public FontManager$CustomFontConfig Method6334() {
        return this.Field4433 != null ? this.Field4435 : this.Field4434;
    }

    public GameFontRenderer Method6335() {
        return this.Field4433 != null ? this.Field4433 : this.Field4430;
    }

    public boolean Method6336() {
        this.Field4433 = null;
        File file = new File("pyro/font.ttf");
        if (file.exists()) {
            block29: {
                FileWriter fileWriter;
                GameFontRenderer gameFontRenderer;
                Font font;
                File file2;
                FileInputStream fileInputStream;
                FileInputStream fileInputStream2;
                Closeable closeable;
                FontManager$CustomFontConfig fontManager$CustomFontConfig = new FontManager$CustomFontConfig();
                File file3 = new File("pyro/font.json");
                if (file3.exists()) {
                    FileReader fileReader;
                    FileReader fileReader2 = fileReader;
                    FileReader fileReader3 = fileReader;
                    File file4 = file3;
                    fileReader2(file4);
                    closeable = fileReader3;
                    Gson gson = Pyro.Field6181;
                    FileReader fileReader4 = closeable;
                    Class<FontManager$CustomFontConfig> class_ = FontManager$CustomFontConfig.class;
                    Object object = gson.fromJson((Reader)fileReader4, class_);
                    fontManager$CustomFontConfig = (FontManager$CustomFontConfig)object;
                    Closeable closeable2 = closeable;
                    try {
                        ((InputStreamReader)closeable2).close();
                    }
                    catch (IOException iOException) {
                        System.err.println("Pyro: Could not read font config");
                    }
                }
                try {
                    FileInputStream fileInputStream3;
                    fileInputStream2 = fileInputStream3;
                    fileInputStream = fileInputStream3;
                    file2 = file;
                }
                catch (Exception exception) {
                    System.err.println("Pyro: Could not load custom font");
                    return false;
                }
                fileInputStream2(file2);
                closeable = fileInputStream;
                int n = 0;
                Closeable closeable3 = closeable;
                Font font2 = Font.createFont(n, (InputStream)closeable3);
                Font font3 = font = font2;
                int n2 = 0;
                float f = fontManager$CustomFontConfig.Field1896;
                Font font4 = font3.deriveFont(n2, f);
                font = font4;
                Closeable closeable4 = closeable;
                ((InputStream)closeable4).close();
                Class55 class55 = this;
                GameFontRenderer gameFontRenderer2 = gameFontRenderer;
                GameFontRenderer gameFontRenderer3 = gameFontRenderer;
                Font font5 = font;
                FontManager$CustomFontConfig fontManager$CustomFontConfig2 = fontManager$CustomFontConfig;
                gameFontRenderer2(font5, fontManager$CustomFontConfig2);
                class55.Field4433 = gameFontRenderer3;
                this.Field4435 = fontManager$CustomFontConfig;
                File file5 = file3;
                boolean bl = file5.exists();
                if (bl) break block29;
                FileWriter fileWriter2 = fileWriter;
                FileWriter fileWriter3 = fileWriter;
                File file6 = file3;
                fileWriter2(file6);
                FileWriter fileWriter4 = fileWriter3;
                Gson gson = Pyro.Field6181;
                FontManager$CustomFontConfig fontManager$CustomFontConfig3 = fontManager$CustomFontConfig;
                FileWriter fileWriter5 = fileWriter4;
                gson.toJson((Object)fontManager$CustomFontConfig3, (Appendable)fileWriter5);
                FileWriter fileWriter6 = fileWriter4;
                fileWriter6.close();
            }
            return true;
        }
        return false;
    }

    public static Font Method6337(String string, float f) {
        Font font;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        try {
            StringBuilder stringBuilder3;
            stringBuilder2 = stringBuilder3;
            stringBuilder = stringBuilder3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new Font("default", 0, (int)f);
        }
        stringBuilder2();
        String string2 = "assets/fonts/";
        StringBuilder stringBuilder4 = stringBuilder.append(string2);
        String string3 = string;
        StringBuilder stringBuilder5 = stringBuilder4.append(string3);
        String string4 = stringBuilder5.toString();
        InputStream inputStream = Pyro.Method8990(string4);
        InputStream inputStream2 = inputStream;
        int n = 0;
        InputStream inputStream3 = inputStream2;
        Font font2 = Font.createFont(n, inputStream3);
        Font font3 = font = font2;
        int n2 = 0;
        float f2 = f;
        Font font4 = font3.deriveFont(n2, f2);
        font = font4;
        InputStream inputStream4 = inputStream2;
        inputStream4.close();
        return font;
    }

    public void Method6338() {
        this.Field4434 = new FontManager$CustomFontConfig();
        File file = new File("pyro/font_default.json");
        if (file.exists()) {
            FileReader fileReader;
            FileReader fileReader2 = fileReader;
            FileReader fileReader3 = fileReader;
            File file2 = file;
            fileReader2(file2);
            Object object5 = fileReader3;
            Class55 class55 = this;
            Gson gson = Pyro.Field6181;
            Object object2 = object5;
            Class<FontManager$CustomFontConfig> class_ = FontManager$CustomFontConfig.class;
            Object object3 = gson.fromJson((Reader)object2, class_);
            class55.Field4434 = (FontManager$CustomFontConfig)object3;
            Object object4 = object5;
            try {
                ((InputStreamReader)object4).close();
            }
            catch (IOException object5) {
                System.err.println("Pyro: Could not read default font config");
            }
        } else {
            FileWriter fileWriter;
            FileWriter fileWriter2 = fileWriter;
            FileWriter fileWriter3 = fileWriter;
            File file3 = file;
            fileWriter2(file3);
            FileWriter fileWriter4 = fileWriter3;
            Gson gson = Pyro.Field6181;
            FontManager$CustomFontConfig fontManager$CustomFontConfig = this.Field4434;
            FileWriter fileWriter5 = fileWriter4;
            gson.toJson((Object)fontManager$CustomFontConfig, (Appendable)fileWriter5);
            FileWriter fileWriter6 = fileWriter4;
            try {
                fileWriter6.close();
            }
            catch (IOException iOException) {
                System.err.println("Pyro: Could not save default font config");
            }
        }
        this.Field4430 = new GameFontRenderer(Class55.Method6337("Roboto-Medium.ttf", this.Field4434.Field1896), this.Field4434);
        this.Field4431 = new GameFontRenderer(Class55.Method6337("Roboto-Medium.ttf", 44.0f), this.Field4434);
        this.Field4432 = new GameFontRenderer(Class55.Method6337("badaboom.ttf", 40.0f), this.Field4434);
        this.Method6336();
    }

    public void Method6339() {
    }
}

