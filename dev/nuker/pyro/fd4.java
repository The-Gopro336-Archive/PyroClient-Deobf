/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Class58;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4k;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.fd1;
import dev.nuker.pyro.fd2;
import dev.nuker.pyro.fd3;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.few;
import dev.nuker.pyro.fex;
import dev.nuker.pyro.mixin.KeyBindingAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fd4
extends Module {
    public f0o<fd1> Field114 = (f0o)this.Method7264(new f0o("mode", "Mode", null, fd1.Legit));
    public f0l Field115 = (f0l)this.Method7264(new f0l("renderColor", "RenderColor", null, new f00(0.0f, 1.0f, 0.5f, 0.3f)));
    public f0l Field116 = (f0l)this.Method7264(new f0l("rendeerOutline", "RenderOutline", null, new f00(0.0f, 1.0f, 0.5f, 1.0f)));
    public f0l Field117 = new f0l("queueColor1", "QueueColor", null, new f00(0.475f, 1.0f, 0.5f, 0.3f));
    public f0l Field118 = new f0l("queueOutline1", "QueueOutline", null, new f00(0.475f, 1.0f, 0.5f, 1.0f));
    public BooleanSetting Field119 = new BooleanSetting("queue", "Queue", null, false);
    public BlockPos Field120 = BlockPos.ORIGIN;
    public ConcurrentLinkedQueue<BlockPos> Field121 = new ConcurrentLinkedQueue();

    public static BlockPos Method200(fd4 fd42) {
        return fd42.Field120;
    }

    public static void Method201(fd4 fd42, BlockPos blockPos) {
        fd42.Field120 = blockPos;
    }

    @f0g
    @LauncherEventHide
    public void Method202(@NotNull f4k f4k2) {
        if ((fd1)((Object)this.Field114.Method7979()) == fd1.ClickSelect) {
            if (((Boolean)this.Field119.Method7979()).booleanValue() && Intrinsics.Method6572((Object)this.Field120, (Object)BlockPos.ORIGIN) ^ true) {
                if (this.Field121.contains((Object)f4k2.Method5785())) {
                    this.Field121.remove((Object)f4k2.Method5785());
                }
                this.Field121.add(f4k2.Method5785());
                return;
            }
            this.Field120 = f4k2.Method5785();
            Class58.Field4487.Method6420(this, f4k2.Method5785(), true, new fd2(this));
        }
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre && (fd1)((Object)this.Field114.Method7979()) == fd1.ClickSelect) {
            if (this.Field120 != null) {
                if (Class58.Field4487.Method5755() != null) {
                    if (Intrinsics.Method6572(Class58.Field4487.Method5755(), this) ^ true) {
                        return;
                    }
                }
                if (Intrinsics.Method6572(Class58.Field4487.Method5755(), this) && this.Field120 != null) {
                    BlockPos blockPos = this.Field120;
                    if (blockPos == null) {
                        Intrinsics.Method6551();
                    }
                    this.Method204(f4u2, blockPos);
                    return;
                }
            }
        }
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        if (this.Field120 != null) {
            fe5.Field252.Method408(7);
            BlockPos blockPos = this.Field120;
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            fe5.Field252.Method410(blockPos, ((f00)this.Field115.Method7979()).Method7515(), 63);
            fe5.Field252.Method405();
            PyroRenderUtil.Method12305(this.Field120, ((f00)this.Field116.Method7979()).Method7515(), 1.0f, true);
        }
        if (!this.Field121.isEmpty() && ((Boolean)this.Field119.Method7979()).booleanValue()) {
            int n = 0;
            Iterable iterable = this.Field121;
            boolean bl = false;
            for (Object t : iterable) {
                BlockPos blockPos = (BlockPos)t;
                boolean bl2 = false;
                fe5.Field252.Method408(7);
                fe5.Field252.Method410(blockPos, ((f00)this.Field117.Method7979()).Method7515(), 63);
                fe5.Field252.Method405();
                PyroRenderUtil.Method12305(blockPos, ((f00)this.Field118.Method7979()).Method7515(), 1.0f, true);
                GlStateManager.pushMatrix();
                EntityPlayer entityPlayer = this.Field5233.getRenderViewEntity() instanceof EntityPlayer ? (EntityPlayer)this.Field5233.getRenderViewEntity() : (EntityPlayer)this.Field5233.player;
                PyroRenderUtil.Method12315((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f, (Entity)entityPlayer, 1.0f);
                GlStateManager.disableDepth();
                GlStateManager.translate((double)(-((double)PyroRenderUtil.Method12314(String.valueOf(++n)) / 2.0)), (double)0.0, (double)0.0);
                PyroRenderUtil.Method12313(String.valueOf(n), 0.0f, 0.0f, -1);
                GlStateManager.popMatrix();
            }
        }
    }

    public boolean Method204(@NotNull f4u f4u2, @NotNull BlockPos blockPos) {
        fex fex2 = few.Method835().Method828(blockPos);
        if (fex2 != null) {
            f4u2.Method7948();
            f4u2.Method5653(fex2.Method891().Method6942());
            f4u2.Method5647(fex2.Method891().Method6936());
            return true;
        }
        return false;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        KeyBinding keyBinding = this.Field5233.gameSettings.keyBindAttack;
        if (keyBinding == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.KeyBindingAccessor");
        }
        ((KeyBindingAccessor)keyBinding).Method5505(false);
        this.Method7274(((fd1)((Object)this.Field114.Method7979())).toString());
        this.Field121.clear();
    }

    public fd4() {
        super("automine", "AutoMine", "Automatically holds down left click");
        this.Method7264(new f0t(this.Field119, this.Field117, this.Field118));
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        if ((fd1)((Object)this.Field114.Method7979()) == fd1.Legit) {
            KeyBinding keyBinding = this.Field5233.gameSettings.keyBindAttack;
            if (keyBinding == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.KeyBindingAccessor");
            }
            ((KeyBindingAccessor)keyBinding).Method5505(true);
        } else if (Intrinsics.Method6572((Object)this.Field120, (Object)BlockPos.ORIGIN) && !this.Field121.isEmpty() && ((Boolean)this.Field119.Method7979()).booleanValue()) {
            this.Field120 = this.Field121.poll();
            Class58.Field4487.Method6420(this, this.Field120, true, new fd3(this));
        }
    }
}

