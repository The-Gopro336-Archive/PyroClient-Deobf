/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f6O;
import dev.nuker.pyro.fed;
import java.util.function.Consumer;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class f6M
implements Consumer {
    public f6O Field2933;
    public boolean Field2934;
    public Block Field2935;
    public int Field2936;
    public BlockPos Field2937;
    public EnumFacing Field2938;
    public Vec3d Field2939;
    public int Field2940;

    public void Method597(@Nullable EntityPlayerSP entityPlayerSP) {
        boolean bl;
        block5: {
            block4: {
                bl = false;
                if (fed.Field441.contains((Object)this.Field2935)) break block4;
                if (!fed.Field442.contains((Object)this.Field2935) && !this.Field2934) break block5;
            }
            f6O.Method4839((f6O)this.Field2933).player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)f6O.Method4839((f6O)this.Field2933).player, CPacketEntityAction.Action.START_SNEAKING));
            bl = true;
        }
        f6O.Method4839((f6O)this.Field2933).player.inventory.currentItem = this.Field2936;
        f6O.Method4839((f6O)this.Field2933).player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field2936));
        f6O.Method4839((f6O)this.Field2933).player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(this.Field2937, this.Field2938, EnumHand.MAIN_HAND, (float)this.Field2939.x, (float)this.Field2939.y, (float)this.Field2939.z));
        f6O.Method4839((f6O)this.Field2933).player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        f6O.Method4839((f6O)this.Field2933).player.inventory.currentItem = this.Field2940;
        f6O.Method4839((f6O)this.Field2933).player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field2940));
        if (bl) {
            f6O.Method4839((f6O)this.Field2933).player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)f6O.Method4839((f6O)this.Field2933).player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
    }

    public f6M(f6O f6O2, boolean bl, Block block, int n, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, int n2) {
        this.Field2933 = f6O2;
        this.Field2934 = bl;
        this.Field2935 = block;
        this.Field2936 = n;
        this.Field2937 = blockPos;
        this.Field2938 = enumFacing;
        this.Field2939 = vec3d;
        this.Field2940 = n2;
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }
}

