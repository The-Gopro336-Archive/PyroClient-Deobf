/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f1l;
import dev.nuker.pyro.f1s;
import dev.nuker.pyro.fdZ;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1k
implements Command {
    public static f1k Field3747 = new f1k();

    public int Method152(CommandContext commandContext) {
        Minecraft minecraft = fdZ.Field313;
        int n = 0;
        Object object = minecraft.world.loadedEntityList;
        boolean bl = false;
        Iterator iterator2 = object.iterator();
        block0: while (iterator2.hasNext()) {
            int n2;
            Object t = iterator2.next();
            Entity entity = (Entity)t;
            boolean bl2 = false;
            if (!(entity instanceof EntityAnimal)) continue;
            if (!f1l.Method5491(f1l.Field3772, (EntityAnimal)entity)) continue;
            int n3 = n2 = 36;
            while (n3 < 45) {
                ItemStack itemStack = minecraft.player.inventoryContainer.getSlot(n2).getStack();
                if (!itemStack.isEmpty() && f1l.Method5494(f1l.Field3772, (EntityAnimal)entity, itemStack)) {
                    NetHandlerPlayClient netHandlerPlayClient;
                    minecraft.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2 - 36));
                    ++n;
                    netHandlerPlayClient.sendPacket((Packet)new CPacketUseEntity(entity, EnumHand.MAIN_HAND));
                    if (minecraft.player.capabilities.isCreativeMode) continue block0;
                    int n4 = itemStack.getCount();
                    if (--n4 > 0) continue block0;
                    minecraft.player.inventory.setInventorySlotContents(n2, itemStack);
                    continue block0;
                }
                n3 = ++n2;
            }
        }
        minecraft.player.connection.sendPacket((Packet)new CPacketHeldItemChange(minecraft.player.inventory.currentItem));
        object = n == 1 ? "" : "s";
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Bred " + n + " animal" + (String)object + '.'));
        return 0;
    }
}

