/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.fd8;
import dev.nuker.pyro.fdX;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class fd9
extends Module {
    public IntegerSetting Field199 = new IntegerSetting("delay", "Delay", "The amount of delay between right clicks.", 1, 0, 6, 1);
    public BooleanSetting Field200 = new BooleanSetting("xp", "XP", "Only activates on XP", false);
    public BindSetting Field201 = new BindSetting("packetXp", "PacketXP", "Automatically faces down and xps you without switching the item clientside", -1);
    public IntegerSetting Field202 = new IntegerSetting("removePiecesPct", "MovePct", null, 100, 0, 100);
    public IntegerSetting Field203 = new IntegerSetting("untilPct", "UntilPct", null, 100, 0, 100);
    public boolean Field204 = false;

    public void Method290(boolean bl, int n, EntityPlayerSP entityPlayerSP) {
        if (bl) {
            this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n));
        }
        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        if (bl) {
            this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field5233.player.inventory.currentItem));
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        ((MinecraftAccessor)this.Field5233).Method6088(6);
    }

    public fd9() {
        super("fastplace", "FastPlace", "Allows you to change the default placing delay");
        this.Method7264(this.Field199);
        this.Method7264(this.Field200);
        this.Method7264(this.Field201);
        this.Method7264(this.Field202);
    }

    @f0g(value=50)
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (this.Field5233.currentScreen != null && !(this.Field5233.currentScreen instanceof GuiInventory)) {
            return;
        }
        if (f4u2.Method5619() == f41.Pre) {
            if ((Integer)this.Field201.Method7979() != -1 && (Integer)this.Field201.Method7979() != 0 && ((Integer)this.Field201.Method7979() > 0 ? Keyboard.isKeyDown((int)((Integer)this.Field201.Method7979())) : Mouse.isButtonDown((int)(-((Integer)this.Field201.Method7979()).intValue())))) {
                int n = -1;
                for (int i = 0; i < 9; ++i) {
                    if (!this.Field5233.player.inventory.getStackInSlot(i).getItem().equals((Object)Items.EXPERIENCE_BOTTLE)) continue;
                    n = i;
                    break;
                }
                if (n != -1) {
                    Iterator iterator2 = this.Field5233.player.getArmorInventoryList().iterator();
                    int n2 = 0;
                    int n3 = 44;
                    int n4 = 44;
                    while (n4 >= 9) {
                        if (this.Field5233.player.inventoryContainer.getSlot(n3).getStack().isEmpty()) {
                            ++n2;
                        }
                        n4 = --n3;
                    }
                    this.Field204 = false;
                    LinkedList<Integer> linkedList = new LinkedList<Integer>();
                    while (iterator2.hasNext()) {
                        ItemStack itemStack = (ItemStack)iterator2.next();
                        if (itemStack.isEmpty()) continue;
                        float f = (float)(itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float)itemStack.getMaxDamage() * 100.0f;
                        if (f >= (float)((Integer)this.Field202.Method7979()).intValue()) {
                            int n5 = 0;
                            if (itemStack.getItem().equals((Object)Items.ELYTRA)) {
                                n5 = 6;
                            } else if (itemStack.getItem() instanceof ItemArmor) {
                                ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
                                switch (fd8.Field197[itemArmor.getEquipmentSlot().ordinal()]) {
                                    case 1: {
                                        n5 = 5;
                                        break;
                                    }
                                    case 2: {
                                        n5 = 6;
                                        break;
                                    }
                                    case 3: {
                                        n5 = 7;
                                        break;
                                    }
                                    case 4: {
                                        n5 = 8;
                                    }
                                }
                            }
                            linkedList.add(n5);
                            if (--n2 != 0) continue;
                            break;
                        }
                        if (!(f <= (float)((Integer)this.Field203.Method7979()).intValue())) continue;
                        this.Field204 = true;
                    }
                    if (!this.Field204) {
                        return;
                    }
                    while (!linkedList.isEmpty()) {
                        this.Field5233.playerController.windowClick(0, ((Integer)linkedList.poll()).intValue(), 0, ClickType.QUICK_MOVE, (EntityPlayer)this.Field5233.player);
                    }
                    boolean bl = n != this.Field5233.player.inventory.currentItem;
                    f4u2.Method7948();
                    f4u2.Method5647(90.0f);
                    int n6 = n;
                    f4u2.Method5816(arg_0 -> this.Method290(bl, n6, arg_0));
                }
            }
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        boolean bl = true;
        if (((Boolean)this.Field200.Method7979()).booleanValue()) {
            bl = this.Field5233.player.getHeldItemMainhand().getItem().equals((Object)Items.EXPERIENCE_BOTTLE);
            this.Method7274("XP: " + fdX.Field311.Method492(Items.EXPERIENCE_BOTTLE));
        }
        if (bl) {
            ((MinecraftAccessor)this.Field5233).Method6088((Integer)this.Field199.Method7979());
        }
    }
}

