/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4w;
import dev.nuker.pyro.f8m;
import dev.nuker.pyro.f8n;
import dev.nuker.pyro.f8o;
import dev.nuker.pyro.fed;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f8p
extends Module {
    public f0o<f8o> Field3598 = new f0o("mode", "Mode", null, f8o.Both);
    public f0o<f8n> Field3599 = new f0o("hand", "Hand", null, f8n.Both);
    public boolean Field3600 = false;

    public f8p() {
        super("noInteract", "NoInteract", "Disallows specific player interactions");
        this.Method7264(this.Field3598);
        this.Method7264(this.Field3599);
    }

    @f0g
    @LauncherEventHide
    public void Method2393(f49 f492) {
        block14: {
            block12: {
                boolean bl;
                Block block;
                block13: {
                    block15: {
                        if (!(f492.Method5784() instanceof CPacketPlayerTryUseItemOnBlock)) break block12;
                        CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock = (CPacketPlayerTryUseItemOnBlock)f492.Method5784();
                        switch (f8m.Field3616[((f8n)((Object)this.Field3599.Method7979())).ordinal()]) {
                            case 1: {
                                if (cPacketPlayerTryUseItemOnBlock.getHand() == EnumHand.MAIN_HAND) break;
                                return;
                            }
                            case 2: {
                                if (cPacketPlayerTryUseItemOnBlock.getHand() == EnumHand.OFF_HAND) break;
                                return;
                            }
                        }
                        block = feg.Method690(cPacketPlayerTryUseItemOnBlock.getPos());
                        bl = block.onBlockActivated((World)this.Field5233.world, cPacketPlayerTryUseItemOnBlock.getPos(), feg.Method701(cPacketPlayerTryUseItemOnBlock.getPos()), (EntityPlayer)this.Field5233.player, cPacketPlayerTryUseItemOnBlock.getHand(), cPacketPlayerTryUseItemOnBlock.getDirection(), 0.0f, 0.0f, 0.0f);
                        if (f492.Method5619() != f41.Pre) break block13;
                        if (this.Field3600) break block14;
                        if (fed.Field441.contains((Object)block)) break block15;
                        if (fed.Field442.contains((Object)block)) break block15;
                        if (!bl) break block14;
                    }
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field5233.player, CPacketEntityAction.Action.START_SNEAKING));
                    break block14;
                }
                if (this.Field3600 && (fed.Field441.contains((Object)block) || fed.Field442.contains((Object)block) || bl)) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field5233.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                break block14;
            }
            if (f492.Method5619() == f41.Pre) {
                if (f492.Method5784() instanceof CPacketEntityAction) {
                    CPacketEntityAction cPacketEntityAction = (CPacketEntityAction)f492.Method5784();
                    if (cPacketEntityAction.getAction() == CPacketEntityAction.Action.START_SNEAKING) {
                        this.Field3600 = true;
                    } else if (cPacketEntityAction.getAction() == CPacketEntityAction.Action.STOP_SNEAKING) {
                        this.Field3600 = false;
                    }
                }
            }
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
    }

    @f0g
    @LauncherEventHide
    public void Method317(f4w f4w2) {
        switch (f8m.Field3616[((f8n)((Object)this.Field3599.Method7979())).ordinal()]) {
            case 1: {
                if (f4w2.Method5856() != EnumHand.MAIN_HAND) break;
                if (!this.Field5233.player.getHeldItem(f4w2.Method5856()).getItem().equals((Object)Items.END_CRYSTAL)) break;
                f4w2.Method7948();
                break;
            }
            case 2: {
                if (f4w2.Method5856() != EnumHand.OFF_HAND || !this.Field5233.player.getHeldItem(f4w2.Method5856()).getItem().equals((Object)Items.END_CRYSTAL)) break;
                f4w2.Method7948();
                break;
            }
            default: {
                if (!this.Field5233.player.getHeldItem(f4w2.Method5856()).getItem().equals((Object)Items.END_CRYSTAL)) break;
                f4w2.Method7948();
                break;
            }
        }
    }
}

