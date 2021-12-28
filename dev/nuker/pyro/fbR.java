/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fbp;
import dev.nuker.pyro.fbq;
import dev.nuker.pyro.fdK;
import dev.nuker.pyro.fdY;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class fbr
extends Module {
    public DoubleSetting Field110 = new DoubleSetting("scaling", "Scaling", "Allows you to scale the size of the nametags", 3.0, 1.0, 10.0);
    public f0o Field111 = (f0o)this.Method7264(new f0o("infoMode", "Info Mode", "Where health and ping are shown", fbq.End));
    public f0o Field112 = (f0o)this.Method7264(new f0o("enchantMode", "Enchant Mode", "How enchants/items render", fbp.Down));
    public List<Integer> Field113 = new CopyOnWriteArrayList<Integer>();

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        this.Field113.clear();
        ArrayList arrayList = new ArrayList();
        this.Field5233.world.playerEntities.stream().filter(this::Method194).forEach(arg_0 -> this.Method190(arrayList, arg_0));
        arrayList.sort((arg_0, arg_1) -> this.Method192(arg_0, arg_1));
        for (EntityPlayer entityPlayer : arrayList) {
            this.Field113.add(entityPlayer.getEntityId());
        }
    }

    public static int Method184(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantments((ItemStack)itemStack).size();
    }

    public int Method185(float f, float f2) {
        Color color = new Color(72, 255, 94);
        Color color2 = new Color(255, 250, 57);
        Color color3 = new Color(255, 35, 40);
        float f3 = f / 2.0f;
        if (f2 <= f3) {
            return fdK.Method328(color2, color3, f2 / f3).getRGB();
        }
        if (f2 <= f3 * 2.0f) {
            return fdK.Method328(color, color2, (f2 - f3) / f3).getRGB();
        }
        return color.getRGB();
    }

    public String Method186(Enchantment enchantment, int n) {
        int n2;
        if (enchantment.getTranslatedName(n).contains("Vanish")) {
            return (Object)ChatFormatting.RED + "Van";
        }
        if (enchantment.getTranslatedName(n).contains("Bind")) {
            return (Object)ChatFormatting.RED + "Bind";
        }
        String string = enchantment.getTranslatedName(n);
        int n3 = n2 = n > 1 ? 2 : 3;
        if (string.length() > n2) {
            string = string.substring(0, n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = string;
        boolean bl = false;
        String string3 = stringBuilder.insert(0, string2.substring(0, 1).toUpperCase()).append(string.substring(1)).toString();
        if (n > 1) {
            string3 = new StringBuilder().insert(0, string3).append(n).toString();
        }
        return string3;
    }

    @f0g
    @LauncherEventHide
    public void Method187(f4J f4J2) {
        this.Field113.clear();
    }

    public String Method188(EntityPlayer entityPlayer) {
        String string = entityPlayer.getName();
        boolean bl = FriendManager.Field2145.Method8958(string);
        if (bl) {
            if (((Boolean)PyroStatic.Field6476.Field5236.Method5264()).booleanValue()) {
                string = FriendManager.Field2145.Method8948(string).Method4889();
            }
            string = (Object)ChatFormatting.AQUA + string + (Object)ChatFormatting.RESET;
        } else {
            string = entityPlayer.isSneaking() ? (Object)ChatFormatting.GOLD + string + (Object)ChatFormatting.RESET : (Object)ChatFormatting.WHITE + string + (Object)ChatFormatting.RESET;
        }
        if (this.Field111.Method7979() != fbq.Above) {
            string = (this.Field111.Method7979() == fbq.Inline ? this.Method198(entityPlayer) + (Object)ChatFormatting.RESET + "  " + string : string + (Object)ChatFormatting.RESET + "  " + this.Method198(entityPlayer)) + (Object)ChatFormatting.RESET + "  " + this.Method191(entityPlayer);
        }
        return string;
    }

    public fbr() {
        super("nametags", "NameTags", "Renders nametags showing extra information on top of another player's head");
        this.Method7264(this.Field110);
    }

    public void Method189(ItemStack itemStack, int n, int n2) {
        if (itemStack.getMaxDamage() > 1) {
            GlStateManager.pushMatrix();
            GlStateManager.scale((float)0.25f, (float)0.25f, (float)0.25f);
            GlStateManager.disableDepth();
            this.Method197(itemStack, n * 4, n2 * 4);
            GlStateManager.enableDepth();
            GlStateManager.popMatrix();
        }
    }

    public void Method190(List list, EntityPlayer entityPlayer) {
        PyroRenderUtil.Field7388.setPosition(this.Field5233.getRenderViewEntity().posX, this.Field5233.getRenderViewEntity().posY, this.Field5233.getRenderViewEntity().posZ);
        if (PyroRenderUtil.Field7388.isBoundingBoxInFrustum(entityPlayer.getEntityBoundingBox())) {
            list.add(entityPlayer);
        }
    }

    public String Method191(EntityPlayer entityPlayer) {
        return "" + (int)Math.floor(entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount());
    }

    public int Method192(EntityPlayer entityPlayer, EntityPlayer entityPlayer2) {
        return Double.compare(entityPlayer2.getDistance(this.Field5233.getRenderViewEntity()), entityPlayer.getDistance(this.Field5233.getRenderViewEntity()));
    }

    public void Method193(ItemStack itemStack, int n, int n2, int n3) {
        GlStateManager.pushMatrix();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        this.Field5233.getRenderItem().zLevel = -150.0f;
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableCull();
        int n4 = n3 > 4 ? (n3 - 4) * 8 / 2 : 0;
        this.Field5233.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n, n2 + n4);
        this.Field5233.getRenderItem().renderItemOverlays(this.Field5233.fontRenderer, itemStack, n, n2 + n4);
        this.Field5233.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableCull();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
    }

    public boolean Method194(EntityPlayer entityPlayer) {
        return entityPlayer instanceof EntityPlayer && entityPlayer != this.Field5233.getRenderViewEntity();
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        for (int n : this.Field113) {
            Object object;
            Object object2;
            Entity entity = this.Field5233.world.getEntityByID(n);
            if (entity == null || !(entity instanceof EntityPlayer)) continue;
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            Entity entity2 = this.Field5233.getRenderViewEntity();
            Vec3d vec3d2 = fdY.Method364((Entity)entityPlayer, f);
            double d = vec3d2.x;
            double d2 = vec3d2.y + 0.65;
            double d3 = vec3d2.z;
            double d4 = d2 + (entityPlayer.isSneaking() ? 0.0 : (double)0.08f);
            vec3d2 = fdY.Method364(entity2, f);
            double d5 = entity2.posX;
            double d6 = entity2.posY;
            double d7 = entity2.posZ;
            entity2.posX = vec3d2.x;
            entity2.posY = vec3d2.y;
            entity2.posZ = vec3d2.z;
            d2 = entity2.getDistance(d, d2, d3);
            double d8 = 0.04;
            if (d2 > 0.0) {
                d8 = 0.02 + (Double)this.Field110.Method7979() / 1000.0 * d2;
            }
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
            GlStateManager.disableLighting();
            GlStateManager.translate((float)((float)d), (float)((float)d4 + 1.4f), (float)((float)d3));
            float f2 = -this.Field5233.getRenderManager().playerViewY;
            float f3 = 1.0f;
            float f4 = 0.0f;
            GlStateManager.rotate((float)f2, (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)this.Field5233.getRenderManager().playerViewX, (float)(this.Field5233.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
            GlStateManager.scale((double)(-d8), (double)(-d8), (double)d8);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            String string = this.Method188(entityPlayer);
            float f5 = PyroRenderUtil.Method12314(string) / 2.0f;
            float f6 = PyroRenderUtil.Method740();
            float f7 = this.Field112.Method7979() == fbp.BelowName ? f6 + 16.0f : 0.0f;
            float f8 = f5 + 2.0f;
            GlStateManager.enableBlend();
            PyroRenderUtil.Method12300(-f5 - 1.0f, -(f7 + f6 + 1.0f) + 3.0f, f8, 2.0f - f7, 0.33f, -16119286);
            PyroRenderUtil.Method12316(-f5 - 1.0f, -(f7 + f6 + 1.0f) + 3.0f, f8, 2.0f - f7, 1594493450);
            GlStateManager.disableBlend();
            PyroRenderUtil.Method5741(string, -f5 + 1.0f, -f7 - f6 + 3.5f, this.Method185(entityPlayer.getMaxHealth(), entityPlayer.getHealth()));
            if (this.Field111.Method7979() == fbq.Above) {
                object2 = this.Method198(entityPlayer);
                object = this.Method191(entityPlayer);
                float f9 = PyroRenderUtil.Method12314((String)object2) / 2.0f;
                float f64 = PyroRenderUtil.Method12314((String)object) / 2.0f;
                if (f64 + f9 > f5) {
                    String string2 = (String)object2 + "  " + (Object)ChatFormatting.RESET + (String)object;
                    float f100 = PyroRenderUtil.Method12314(string2) / 2.0f;
                    GlStateManager.enableBlend();
                    PyroRenderUtil.Method12316(-f100 - 1.0f, -(f7 + f6 * 2.0f + 1.0f) + 3.0f, f100 + 2.0f, 2.0f - f6 - f7, 1594493450);
                    GlStateManager.disableBlend();
                    PyroRenderUtil.Method12313(string2, -f100 + 1.0f, -f7 - f6 * 2.0f + 3.0f, this.Method185(entityPlayer.getMaxHealth(), entityPlayer.getHealth()));
                } else {
                    GlStateManager.enableBlend();
                    PyroRenderUtil.Method12316(-f5 - 1.0f, -(f7 + f6 * 2.0f + 1.0f) + 3.0f, f5 + 2.0f, 2.0f - f7 - f6, 1594493450);
                    GlStateManager.disableBlend();
                    PyroRenderUtil.Method12313((String)object2, -f5 + 1.0f, -f7 - f6 * 2.0f + 3.0f, this.Method185(entityPlayer.getMaxHealth(), entityPlayer.getHealth()));
                    PyroRenderUtil.Method12313((String)object, f5 - f64 * 2.0f + 1.0f, -f7 - f6 * 2.0f + 3.0f, this.Method185(entityPlayer.getMaxHealth(), entityPlayer.getHealth()));
                }
            }
            GlStateManager.pushMatrix();
            object2 = entityPlayer.getArmorInventoryList().iterator();
            object = new ArrayList();
            ((ArrayList)object).add(entityPlayer.getHeldItemOffhand());
            while (object2.hasNext()) {
                ItemStack itemStack = (ItemStack)object2.next();
                if (itemStack.isEmpty()) continue;
                ((ArrayList)object).add(itemStack);
            }
            ((ArrayList)object).add(entityPlayer.getHeldItemMainhand());
            Collections.reverse(object);
            int n2 = -(((ArrayList)object).size() * 8);
            int n3 = this.Field112.Method7979() == fbp.BelowName ? -16 : -((int)(this.Field111.Method7979() == fbq.Above ? f6 * 2.0f : f6)) - 16;
            int n4 = 0;
            if (this.Field112.Method7979() == fbp.Down) {
                int n5 = object.stream().max(Comparator.comparingInt(fbr::Method184)).map(fbr::Method199).orElse(0);
                if (n5 < 0) {
                    n5 = 0;
                }
                n3 -= n5 * 4;
            }
            Iterator iterator2 = ((ArrayList)object).iterator();
            while (iterator2.hasNext()) {
                ItemStack itemStack = (ItemStack)iterator2.next();
                this.Method193(itemStack, n2, n3, n4);
                GlStateManager.pushMatrix();
                GlStateManager.scale((float)0.5f, (float)0.5f, (float)0.5f);
                if (this.Field112.Method7979() != fbp.Off) {
                    if (this.Field112.Method7979() == fbp.Up) {
                        int n6 = EnchantmentHelper.getEnchantments((ItemStack)itemStack).size();
                        this.Method196(itemStack, n2, n3 * 2 - (n6 > 4 ? (n6 - 4) * 8 : 0));
                    } else {
                        this.Method196(itemStack, n2, n3 * 2);
                    }
                }
                GlStateManager.popMatrix();
                this.Method189(itemStack, n2, this.Field112.Method7979() == fbp.Up ? n3 + 16 : n3 - 2);
                n2 += 16;
            }
            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
            GlStateManager.disableBlend();
            GlStateManager.disablePolygonOffset();
            GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
            GlStateManager.popMatrix();
            entity2.posX = d5;
            entity2.posY = d6;
            entity2.posZ = d7;
        }
        GlStateManager.enableBlend();
    }

    public void Method196(ItemStack itemStack, int n, int n2) {
        Iterator iterator2;
        int n3 = -1;
        Iterator iterator3 = iterator2 = EnchantmentHelper.getEnchantments((ItemStack)itemStack).keySet().iterator();
        while (iterator3.hasNext()) {
            Enchantment enchantment = (Enchantment)iterator2.next();
            if (enchantment == null) {
                iterator3 = iterator2;
                continue;
            }
            PyroRenderUtil.Method12313(this.Method186(enchantment, EnchantmentHelper.getEnchantmentLevel((Enchantment)enchantment, (ItemStack)itemStack)), n * 2, n2, -1);
            n2 += 8;
            iterator3 = iterator2;
        }
        if (itemStack.getItem().equals((Object)Items.GOLDEN_APPLE) && itemStack.hasEffect()) {
            PyroRenderUtil.Method12313((Object)ChatFormatting.DARK_RED + "God", n * 2, n2, -1);
        }
    }

    public void Method197(ItemStack itemStack, int n, int n2) {
        float f = (float)(itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float)itemStack.getMaxDamage() * 100.0f;
        int n3 = 0x1FFF00;
        if (f > 30.0f && f < 70.0f) {
            n3 = 0xFFFF00;
        } else if (f <= 30.0f) {
            n3 = 0xFF0000;
        }
        GlStateManager.disableDepth();
        PyroRenderUtil.Method12313(String.format("%.1f%%", Float.valueOf(f)), n, n2, n3);
        GlStateManager.enableDepth();
    }

    public String Method198(EntityPlayer entityPlayer) {
        String string = "";
        int n = -1;
        Minecraft minecraft = this.Field5233;
        NetHandlerPlayClient netHandlerPlayClient = minecraft.getConnection();
        EntityPlayer entityPlayer2 = entityPlayer;
        UUID uUID = entityPlayer2.getUniqueID();
        NetworkPlayerInfo networkPlayerInfo = netHandlerPlayClient.getPlayerInfo(uUID);
        int n2 = networkPlayerInfo.getResponseTime();
        try {
            n = n2;
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        if (n > 200) {
            string = string + (Object)ChatFormatting.RED;
        } else if (n <= 200 && n >= 100) {
            string = string + (Object)ChatFormatting.YELLOW;
        } else if (n < 100) {
            string = string + (Object)ChatFormatting.GREEN;
        }
        return string + n + "ms";
    }

    public static Integer Method199(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantments((ItemStack)itemStack).size() - 4;
    }
}

