/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeModContainer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f45;
import dev.nuker.pyro.fbQ;
import dev.nuker.pyro.fbR;
import dev.nuker.pyro.fbS;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class fbT
extends Module {
    @NotNull
    public IntegerSetting Field1946 = (IntegerSetting)this.Method7264(new IntegerSetting("opacity", "Wallhack Opacity", "Changes the opacity level of rendered blocks", 128, 0, 255, 0, 64, null));
    @NotNull
    public IntegerSetting Field1947 = (IntegerSetting)this.Method7264(new IntegerSetting("opacityXray", "Xray Opacity", "Same as above, but only affects xray", 128, 0, 255, 0, 64, null));
    @NotNull
    public BooleanSetting Field1948 = (BooleanSetting)this.Method7264(new BooleanSetting("xray", "Xray", "Enables Xray when wallhack is enabled", false));
    @NotNull
    public BindSetting Field1949 = (BindSetting)this.Method7264(new BindSetting("xrayBind", "Wallhack Bind", "Keybind to toggle xray, so you can use wallhack separately", -1));
    @NotNull
    public BooleanSetting Field1950 = (BooleanSetting)this.Method7264(new BooleanSetting("preload", "Preload", "Prerender everything as transparent (usually a bad idea)", false));
    @NotNull
    public fbR Field1951;
    public int Field1952 = 255;

    public void Method2608(@NotNull Block block, @NotNull IBlockState iBlockState, @NotNull IBlockAccess iBlockAccess, @NotNull BlockPos blockPos, @NotNull EnumFacing enumFacing, @NotNull CallbackInfoReturnable callbackInfoReturnable) {
        if (this.Method2485(block)) {
            callbackInfoReturnable.Method9034();
            callbackInfoReturnable.Method521(true);
        }
    }

    public void Method2609(@NotNull Block block, @NotNull CallbackInfoReturnable callbackInfoReturnable) {
        if (this.Method2485(block)) {
            callbackInfoReturnable.Method9034();
            callbackInfoReturnable.Method521(15);
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        if (((Number)this.Field1949.Method7979()).intValue() != -1 && bl) {
            this.Field1948.Method7975(false);
        }
    }

    public void Method2486() {
        if (new File("pyro/xray_blocks.json").exists()) {
            FileReader fileReader;
            FileReader fileReader2 = fileReader;
            FileReader fileReader3 = fileReader;
            String string = "pyro/xray_blocks.json";
            fileReader2(string);
            FileReader fileReader4 = fileReader3;
            fbT fbT2 = this;
            Gson gson = Pyro.Field6181;
            Reader reader = fileReader4;
            Class<fbR> class_ = fbR.class;
            Object object = gson.fromJson(reader, class_);
            fbT2.Field1951 = (fbR)object;
            FileReader fileReader5 = fileReader4;
            try {
                fileReader5.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        } else {
            Collection<String> collection;
            fbR fbR2 = this.Field1951 = new fbR();
            if (fbR2 == null) {
                Intrinsics.Method6554("storage");
            }
            Iterable iterable = CollectionsKt.Method1014(new Block[]{Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.COAL_ORE, Blocks.REDSTONE_ORE, Blocks.LAPIS_ORE, Blocks.QUARTZ_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.TNT, (Block)Blocks.BEACON, Blocks.MOB_SPAWNER, (Block)Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.FURNACE, Blocks.LIT_FURNACE, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX});
            fbR fbR3 = fbR2;
            boolean bl = false;
            Iterable iterable2 = iterable;
            Collection collection2 = new ArrayList(CollectionsKt.Method9458(iterable, 10));
            boolean bl2 = false;
            for (Object t : iterable2) {
                Block block = (Block)t;
                collection = collection2;
                boolean bl3 = false;
                String string = ((ResourceLocation)Block.REGISTRY.getNameForObject((Object)block)).toString();
                collection.add(string);
            }
            collection = (List)collection2;
            fbR3.Method2605(CollectionsKt.Method3150((Collection)collection));
        }
    }

    public static Minecraft Method2610(fbT fbT2) {
        return fbT2.Field5233;
    }

    @f0g
    @LauncherEventHide
    public void Method2611(@NotNull f45 f452) {
        int n;
        if (f452.Method5600() && (n = Keyboard.getEventKey()) == ((Number)this.Field1949.Method7979()).intValue()) {
            if (((Boolean)this.Field5236.Method5264()).booleanValue()) {
                if (((Boolean)this.Field1948.Method7979()).booleanValue()) {
                    this.Field5236.Method5266(false);
                    this.Field1948.Method7975(false);
                } else {
                    this.Field1948.Method7975(true);
                }
            } else {
                this.Field5236.Method5266(true);
                this.Field1948.Method7975(true);
            }
        }
    }

    @NotNull
    public BooleanSetting Method283() {
        return this.Field1950;
    }

    public static void Method2612(fbT fbT2, Minecraft minecraft) {
        fbT2.Field5233 = minecraft;
    }

    @NotNull
    public IntegerSetting Method2501() {
        return this.Field1947;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method2485(@Nullable Block block) {
        if (block == null) return false;
        if ((Boolean)this.Field5236.Method5264() == false) return false;
        if ((Boolean)this.Field1948.Method7979() == false) return false;
        fbR fbR2 = this.Field1951;
        if (fbR2 == null) {
            Intrinsics.Method6554("storage");
        }
        if (!fbR2.Method2604().contains(((ResourceLocation)Block.REGISTRY.getNameForObject((Object)block)).toString())) return false;
        return true;
    }

    public void Method541(int n) {
        this.Field1952 = n;
    }

    @NotNull
    public fbR Method2613() {
        fbR fbR2 = this.Field1951;
        if (fbR2 == null) {
            Intrinsics.Method6554("storage");
        }
        return fbR2;
    }

    public int Method2614() {
        return this.Field1952;
    }

    public fbT() {
        super("wallhack", "Wallhack", "See through walls");
        this.Method2486();
        this.Field1948.Method7980(new fbQ(this));
        Pyro.Method8978().Method7915(this);
    }

    @NotNull
    public BooleanSetting Method280() {
        return this.Field1948;
    }

    @NotNull
    public BindSetting Method2615() {
        return this.Field1949;
    }

    public void Method2616() {
        fbR fbR2;
        Gson gson;
        FileWriter fileWriter;
        block13: {
            FileWriter fileWriter2;
            FileWriter fileWriter3 = fileWriter2;
            FileWriter fileWriter4 = fileWriter2;
            String string = "pyro/xray_blocks.json";
            fileWriter3(string);
            fileWriter = fileWriter4;
            gson = Pyro.Field6181;
            fbR2 = this.Field1951;
            if (fbR2 != null) break block13;
            String string2 = "storage";
            Intrinsics.Method6554(string2);
        }
        Appendable appendable = fileWriter;
        gson.toJson((Object)fbR2, appendable);
        FileWriter fileWriter5 = fileWriter;
        try {
            fileWriter5.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public int Method2617() {
        return ((Boolean)this.Field5236.Method5264()).booleanValue() ? (((Boolean)this.Field1948.Method7979()).booleanValue() ? ((Number)this.Field1947.Method7979()).intValue() : ((Number)this.Field1946.Method7979()).intValue()) : 255;
    }

    public void Method2618(@NotNull fbR fbR2) {
        this.Field1951 = fbR2;
    }

    @NotNull
    public IntegerSetting Method2619() {
        return this.Field1946;
    }

    public void Method2620() {
        boolean bl = this.Method2622();
        if (this.Field1952 < this.Method2617()) {
            fbT fbT2 = this;
            int n = this.Method2617() - this.Field1952;
            int n2 = 10;
            int n3 = fbT2.Field1952;
            fbT fbT3 = fbT2;
            boolean bl2 = false;
            int n4 = Math.min(n, n2);
            fbT3.Field1952 = n3 + n4;
        } else if (this.Field1952 > this.Method2617()) {
            fbT fbT4 = this;
            int n = this.Field1952 - this.Method2617();
            int n5 = 10;
            int n6 = fbT4.Field1952;
            fbT fbT5 = fbT4;
            boolean bl3 = false;
            int n7 = Math.min(n, n5);
            fbT5.Field1952 = n6 - n7;
        }
        if (bl != this.Method2622()) {
            if (this.Field5233.world != null && this.Field5233.renderGlobal != null) {
                this.Field5233.addScheduledTask((Runnable)new fbS(this));
            }
            ForgeModContainer.forgeLightPipelineEnabled = !this.Method2622();
        }
    }

    public void Method2621(@NotNull Block block, @NotNull BlockRenderLayer blockRenderLayer, @NotNull CallbackInfoReturnable callbackInfoReturnable) {
        if (!this.Method2485(block)) {
            callbackInfoReturnable.Method9034();
            callbackInfoReturnable.Method521(blockRenderLayer == BlockRenderLayer.TRANSLUCENT);
        }
    }

    public boolean Method2622() {
        return this.Field1952 != 255 || (Boolean)this.Field1950.Method7979() != false;
    }
}

