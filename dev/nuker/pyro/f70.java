/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f6Z;
import dev.nuker.pyro.f7c;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.fed;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class f70
extends Module {
    @NotNull
    public BooleanSetting Field2959 = (BooleanSetting)this.Method7264(new BooleanSetting("toggles", "Toggle", "Toggles off after surrounded", false));
    @NotNull
    public BooleanSetting Field2960 = (BooleanSetting)this.Method7264(new BooleanSetting("center", "Center", "Tries to center you in the middle of the block", true));
    @NotNull
    public BooleanSetting Field2961 = (BooleanSetting)this.Method7264(new BooleanSetting("toggleOffGround", "ToggleOffGround", "Toggles when your offground", true));
    @NotNull
    public BooleanSetting Field2962 = (BooleanSetting)this.Method7264(new BooleanSetting("toggleInHole", "EnableInHole", "Enables surround when you jump in a hole", false));
    @NotNull
    public BooleanSetting Field2963 = (BooleanSetting)this.Method7264(new BooleanSetting("doubles", "Double", "Surrounds two layers", false));
    @NotNull
    public BindSetting Field2964 = (BindSetting)this.Method7264(new BindSetting("doubles", "Double", "Surrounds two layers", -1));
    @NotNull
    public f0l Field2965 = (f0l)this.Method7264(new f0l("unplaced_color", "Unplaced Color", null, new f00(0.0f, 1.0f, 1.0f, 0.13636f)));
    @NotNull
    public f0l Field2966 = (f0l)this.Method7264(new f0l("placed_color", "Placed Color", null, new f00(0.35f, 1.0f, 0.46666f, 0.13636f)));
    @NotNull
    public BooleanSetting Field2967 = (BooleanSetting)this.Method7264(new BooleanSetting("checkCollision", "CheckCollision", "Checks for entity collision before trying to place", true));
    @NotNull
    public BooleanSetting Field2968 = (BooleanSetting)this.Method7264(new BooleanSetting("instant", "Instant", null, false));
    public Vec3d Field2969 = Vec3d.ZERO;
    public boolean Field2970;
    @Nullable
    public BlockPos[] Field2971;
    public boolean[] Field2972;
    public static f6Z Field2973 = new f6Z(null);

    public boolean Method4844(@NotNull Entity entity) {
        for (BlockPos blockPos : this.Method4851(entity)) {
            block4: {
                IBlockState iBlockState;
                block3: {
                    iBlockState = this.Field5233.world.getBlockState(blockPos);
                    if (this.Field5233.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN) break block3;
                    if (this.Field5233.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK) break block4;
                }
                if (!(iBlockState.getBlock() instanceof BlockLiquid) && !iBlockState.getBlock().isReplaceable((IBlockAccess)this.Field5233.world, blockPos)) continue;
            }
            return false;
        }
        return true;
    }

    public static void Method4845(f70 f702, Minecraft minecraft) {
        f702.Field5233 = minecraft;
    }

    public static Minecraft Method4846(f70 f702) {
        return f702.Field5233;
    }

    public f70() {
        super("surround", "Surround", "Automatically surrounds you with obsidian to prevent being crystalled");
    }

    @NotNull
    public BlockPos[] Method4847(@NotNull BlockPos blockPos) {
        BlockPos[] arrblockPos = new BlockPos[5];
        arrblockPos[0] = blockPos.down();
        arrblockPos[1] = blockPos.north();
        arrblockPos[2] = blockPos.south();
        arrblockPos[3] = blockPos.west();
        arrblockPos[4] = blockPos.east();
        return arrblockPos;
    }

    public Vec3d Method4848() {
        return this.Field2969;
    }

    @Nullable
    public BlockPos[] Method4849() {
        return this.Field2971;
    }

    @NotNull
    public f0l Method239() {
        return this.Field2966;
    }

    @NotNull
    public f0l Method4850() {
        return this.Field2965;
    }

    @NotNull
    public BlockPos[] Method4851(@NotNull Entity entity) {
        BlockPos blockPos = new BlockPos(MathHelper.floor((double)entity.posX), MathHelper.floor((double)entity.posY), MathHelper.floor((double)entity.posZ));
        return this.Method4847(blockPos);
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field2961;
    }

    @NotNull
    public BooleanSetting Method279() {
        return this.Field2967;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        if (this.Field2971 != null) {
            fe5.Field252.Method408(7);
            int n = 0;
            if (this.Field2971 == null) {
                Intrinsics.Method6551();
            }
            int n2 = this.Field2971.length;
            while (n < n2) {
                if (this.Field2971 == null) {
                    Intrinsics.Method6551();
                }
                BlockPos blockPos = this.Field2971[n];
                float f2 = (float)blockPos.getX() - 0.001f;
                float f3 = (float)blockPos.getY() - 0.001f;
                float f4 = (float)blockPos.getZ() - 0.001f;
                if (this.Field2972 == null) {
                    Intrinsics.Method6554("filledArr");
                }
                fe5.Field252.Method394(f2, f3, f4, 1.002f, 1.002f, 1.002f, this.Field2972[n] ? ((f00)this.Field2966.Method7979()).Method7515() : ((f00)this.Field2965.Method7979()).Method7515(), 63);
                ++n;
            }
            GlStateManager.enableDepth();
            fe5.Field252.Method405();
        }
    }

    @NotNull
    public BooleanSetting Method2424() {
        return this.Field2968;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (this.Field5233.player == null) {
            return;
        }
        boolean bl2 = this.Field2970 = !this.Field5233.player.onGround;
        if (((Boolean)this.Field2960.Method7979()).booleanValue()) {
            this.Field2969 = Field2973.Method4970(this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ);
            this.Field5233.player.motionX = 0.0;
            this.Field5233.player.motionZ = 0.0;
        } else {
            this.Field2969 = Vec3d.ZERO;
        }
    }

    public boolean Method4852(@NotNull Entity entity) {
        for (BlockPos blockPos : this.Method4851(entity)) {
            IBlockState iBlockState = this.Field5233.world.getBlockState(blockPos);
            if (!this.Field5233.world.isAirBlock(blockPos)) {
                if (!(iBlockState.getBlock() instanceof BlockLiquid) && !iBlockState.getBlock().isReplaceable((IBlockAccess)this.Field5233.world, blockPos)) continue;
            }
            return false;
        }
        return true;
    }

    public void Method4853(@Nullable BlockPos[] arrblockPos) {
        this.Field2971 = arrblockPos;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field2959;
    }

    public void Method2283(Vec3d vec3d) {
        this.Field2969 = vec3d;
    }

    @NotNull
    public BooleanSetting Method276() {
        return this.Field2962;
    }

    public void Method2691(@NotNull BooleanSetting booleanSetting) {
        this.Field2962 = booleanSetting;
    }

    @NotNull
    public BlockPos[] Method4854(@NotNull Entity entity) {
        BlockPos[] arrblockPos;
        BlockPos blockPos = new BlockPos(MathHelper.floor((double)entity.posX), MathHelper.floor((double)entity.posY), MathHelper.floor((double)entity.posZ));
        if (((Boolean)this.Field2963.Method7979()).booleanValue() || (((Number)this.Field2964.Method7979()).intValue() > 1 ? Keyboard.isKeyDown((int)((Number)this.Field2964.Method7979()).intValue()) : (((Number)this.Field2964.Method7979()).intValue() < -1 ? Mouse.isButtonDown((int)(-((Number)this.Field2964.Method7979()).intValue())) : false))) {
            BlockPos[] arrblockPos2 = new BlockPos[12];
            arrblockPos2[0] = blockPos.north().down();
            arrblockPos2[1] = blockPos.south().down();
            arrblockPos2[2] = blockPos.west().down();
            arrblockPos2[3] = blockPos.east().down();
            arrblockPos2[4] = blockPos.north();
            arrblockPos2[5] = blockPos.south();
            arrblockPos2[6] = blockPos.west();
            arrblockPos2[7] = blockPos.east();
            arrblockPos2[8] = blockPos.north().up();
            arrblockPos2[9] = blockPos.south().up();
            arrblockPos2[10] = blockPos.west().up();
            arrblockPos = arrblockPos2;
            arrblockPos2[11] = blockPos.east().up();
        } else {
            BlockPos[] arrblockPos3 = new BlockPos[8];
            arrblockPos3[0] = blockPos.north().down();
            arrblockPos3[1] = blockPos.south().down();
            arrblockPos3[2] = blockPos.west().down();
            arrblockPos3[3] = blockPos.east().down();
            arrblockPos3[4] = blockPos.north();
            arrblockPos3[5] = blockPos.south();
            arrblockPos3[6] = blockPos.west();
            arrblockPos = arrblockPos3;
            arrblockPos3[7] = blockPos.east();
        }
        return arrblockPos;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field2963;
    }

    @NotNull
    public BindSetting Method4855() {
        return this.Field2964;
    }

    public boolean Method4856(@NotNull Entity entity) {
        for (BlockPos blockPos : this.Method4854(entity)) {
            IBlockState iBlockState = this.Field5233.world.getBlockState(blockPos);
            if (!this.Field5233.world.isAirBlock(blockPos)) {
                if (!(iBlockState.getBlock() instanceof BlockLiquid)) {
                    if (!iBlockState.getBlock().isReplaceable((IBlockAccess)this.Field5233.world, blockPos)) continue;
                }
            }
            return false;
        }
        return true;
    }

    public void Method557(boolean bl) {
        this.Field2970 = bl;
    }

    public boolean Method4842(@NotNull BlockPos blockPos) {
        for (BlockPos blockPos2 : this.Method4847(blockPos)) {
            IBlockState iBlockState = this.Field5233.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() == Blocks.OBSIDIAN || iBlockState.getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field2960;
    }

    @f0g(value=2)
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        this.Field2971 = this.Method4854((Entity)this.Field5233.player);
        if (this.Field2971 == null) {
            Intrinsics.Method6551();
        }
        this.Field2972 = new boolean[this.Field2971.length];
        int n = 0;
        if (this.Field2971 == null) {
            Intrinsics.Method6551();
        }
        int n2 = this.Field2971.length;
        while (n < n2) {
            if (this.Field2972 == null) {
                Intrinsics.Method6554("filledArr");
            }
            if (this.Field2971 == null) {
                Intrinsics.Method6551();
            }
            this.Field2972[n] = !feg.Method700(this.Field2971[n]);
            ++n;
        }
        if (this.Method4856((Entity)this.Field5233.player)) {
            if (((Boolean)this.Field2959.Method7979()).booleanValue()) {
                this.Field5236.Method5266(false);
            }
            return;
        }
        if (this.Field2970) {
            if (this.Field5233.player.onGround) {
                this.Field2970 = false;
            }
        }
        if (!this.Field2970 && !this.Field5233.player.onGround) {
            if (((Boolean)this.Field2961.Method7979()).booleanValue()) {
                this.Field5236.Method5266(false);
                Pyro.Field6182.Method8989(ChatFormatting.AQUA.toString() + "[Surround]: " + (Object)ChatFormatting.RESET + " you are off ground, toggling!");
                return;
            }
        }
        if (((Boolean)this.Field2960.Method7979()).booleanValue() && this.Field2969 != Vec3d.ZERO) {
            double d = Math.abs(this.Field2969.x - this.Field5233.player.posX);
            double d2 = Math.abs(this.Field2969.z - this.Field5233.player.posZ);
            if (d <= 0.1 && d2 <= 0.1) {
                this.Field2969 = Vec3d.ZERO;
            } else {
                double d3 = this.Field2969.x - this.Field5233.player.posX;
                double d4 = this.Field2969.z - this.Field5233.player.posZ;
                this.Field5233.player.motionX = d3 / (double)2;
                this.Field5233.player.motionZ = d4 / (double)2;
            }
        }
        n = -1;
        n2 = 1;
        if (!this.Field5233.player.getHeldItemMainhand().isEmpty()) {
            if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
                Item item = this.Field5233.player.getHeldItemMainhand().getItem();
                if (item == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                }
                ItemBlock itemBlock = (ItemBlock)item;
                if (Intrinsics.Method6572((Object)itemBlock.getBlock(), (Object)Blocks.OBSIDIAN)) {
                    n2 = 0;
                }
            }
        }
        if (n2 != 0) {
            int n3 = 8;
            for (int i = 0; i <= n3; ++i) {
                if (!(this.Field5233.player.inventory.getStackInSlot(i).getItem() instanceof ItemBlock)) continue;
                Item item = this.Field5233.player.inventory.getStackInSlot(i).getItem();
                if (item == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                }
                ItemBlock itemBlock = (ItemBlock)item;
                if (!Intrinsics.Method6572((Object)itemBlock.getBlock(), (Object)Blocks.OBSIDIAN)) continue;
                n = i;
                break;
            }
            if (n == -1) {
                return;
            }
        }
        int n4 = this.Field5233.player.inventory.currentItem;
        BlockPos[] arrblockPos = this.Method4854((Entity)this.Field5233.player);
        boolean bl = false;
        BlockPos blockPos = null;
        for (BlockPos blockPos2 : arrblockPos) {
            if ((double)blockPos2.getY() < this.Field5233.player.posY) {
                if (!feg.Method700(blockPos2.up())) continue;
            }
            if (((Boolean)this.Field2967.Method7979()).booleanValue() && !this.Field5233.world.checkNoEntityCollision(new AxisAlignedBB(blockPos2)) || !feg.Method700(blockPos2)) continue;
            if (n2 != 0) {
                if (!bl) {
                    this.Field5233.player.inventory.currentItem = n;
                    this.Field5233.playerController.updateController();
                    bl = true;
                }
            }
            if (((Boolean)this.Field2968.Method7979()).booleanValue()) {
                fed.Method658(blockPos2, 8.0f, true, true);
                continue;
            }
            Vec3d vec3d = new Vec3d(this.Field5233.player.posX, this.Field5233.player.posY + (double)this.Field5233.player.getEyeHeight(), this.Field5233.player.posZ);
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos3 = blockPos2.offset(enumFacing);
                EnumFacing enumFacing2 = enumFacing.getOpposite();
                if (!this.Field5233.world.getBlockState(blockPos3).getBlock().canCollideCheck(this.Field5233.world.getBlockState(blockPos3), false)) continue;
                Vec3d vec3d2 = new Vec3d((Vec3i)blockPos3).addVector(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
                if (!(vec3d.distanceTo(vec3d2) <= (double)8.0f)) continue;
                blockPos = blockPos2;
                f4u2.Method7948();
                float[] arrf = fed.Method654(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), enumFacing);
                f4u2.Method5653(arrf[0]);
                f4u2.Method5647(arrf[1]);
                boolean bl2 = bl;
                BlockPos blockPos4 = blockPos;
                f4u2.Method5816(new f7c(this, blockPos4, bl2, n4));
                return;
            }
            break;
        }
        if (bl) {
            this.Field5233.player.inventory.currentItem = n4;
            this.Field5233.playerController.updateController();
        }
    }

    public boolean Method2269() {
        return this.Field2970;
    }
}

