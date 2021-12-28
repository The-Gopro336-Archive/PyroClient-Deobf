/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentDamage
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.monster.EntityShulker
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.f04;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0n;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f6a;
import dev.nuker.pyro.f6b;
import dev.nuker.pyro.f6d;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fe4;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.few;
import dev.nuker.pyro.fex;
import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Comparator;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class aura
extends Module {
    public f0o<f6b> Field3538 = new f0o("mode", "Mode", null, f6b.Closest);
    public DoubleSetting Field3539 = new DoubleSetting("distance", "Distance", null, 6.0, 0.0, 6.0);
    public f0o<f6d> Field3540 = new f0o("switchMode", "Switch", null, f6d.BestSword);
    public IntegerSetting Field3541 = new IntegerSetting("APS", "APS", "Attacks per second with hitdelay off", 8, 0, 20);
    public BooleanSetting Field3542 = new BooleanSetting("hitDelay", "HitDelay", null, true);
    public BooleanSetting Field3543 = new BooleanSetting("throughWalls", "Through Walls", null, true);
    public BooleanSetting Field3544 = new BooleanSetting("tpsSync", "TPSSync", null, true);
    public BooleanSetting Field3545 = new BooleanSetting("autoBlock", "AutoBlock", null, true);
    public f0t Field3546 = new f0t(new f0n("Options", "Options", "Edit main options of Aura"), this.Field3542, this.Field3541, this.Field3543, this.Field3544, this.Field3545);
    public BooleanSetting Field3547 = new BooleanSetting("boats", "Boats", null, true);
    public BooleanSetting Field3548 = new BooleanSetting("projectiles", "Projectiles", null, true);
    public BooleanSetting Field3549 = new BooleanSetting("players", "Players", null, true);
    public BooleanSetting Field3550 = new BooleanSetting("monsters", "Monsters", null, true);
    public BooleanSetting Field3551 = new BooleanSetting("neutrals", "Neutrals", null, true);
    public BooleanSetting Field3552 = new BooleanSetting("animals", "Animals", null, true);
    public BooleanSetting Field3553 = new BooleanSetting("tamed", "Tamed", null, false);
    public BooleanSetting Field3554 = new BooleanSetting("shulkers", "Shulkers", null, true);
    public BooleanSetting Field3555 = new BooleanSetting("armorCheck", "ArmorCheck", null, false);
    public f0t Field3556 = new f0t(new f0n("targeting", "Targeting", "Edit targeting for Aura"), this.Field3549, this.Field3550, this.Field3551, this.Field3552, this.Field3553, this.Field3548, this.Field3554, this.Field3547, this.Field3555);
    public BooleanSetting Field3557 = new BooleanSetting("pauseWithAutoCrystal", "AutoCrystal", null, true);
    public BooleanSetting Field3558 = new BooleanSetting("eating", "Eating", null, true);
    public BooleanSetting Field3559 = new BooleanSetting("mining", "Mining", null, true);
    public BooleanSetting Field3560 = new BooleanSetting("xping", "XPing", null, true);
    public f0t Field3561 = new f0t(new f0n("pause", "Pause", "Edit pausing options for Aura"), this.Field3557, this.Field3558, this.Field3559, this.Field3560);
    public float[] Field3562 = null;
    public fe8 Field3563 = new fe8();
    public Entity Field3564 = null;
    public Entity Field3565 = null;
    public int Field3566 = 0;

    public Float Method5351(Entity entity) {
        return Float.valueOf(this.Field5233.player.getDistance(entity));
    }

    public boolean Method4844(Entity entity) {
        return this.Method5355(entity, null, true);
    }

    @f0g
    @LauncherEventHide
    public void Method277(f43 f432) {
        if (this.Field5233.player == null) {
            return;
        }
        this.Method7274(String.valueOf(this.Field3538.Method7979()));
        if (((Boolean)PyroStatic.Field6483.Field5236.Method5264()).booleanValue() && PyroStatic.Field6483.Field3271) {
            return;
        }
        boolean bl = this.Method4876();
        if (this.Field3563.Method491(1000.0) || bl) {
            this.Field3563.Method490();
            this.Field3562 = null;
            this.Field3564 = null;
            this.Field3565 = null;
        }
        if (bl) {
            return;
        }
        switch (f6a.Field3168[((f6b)((Object)this.Field3538.Method7979())).ordinal()]) {
            case 1: {
                this.Field3564 = this.Field5233.world.loadedEntityList.stream().filter(this::Method5352).min(Comparator.comparing(this::Method5353)).orElse(null);
                break;
            }
            case 2: {
                if (this.Field3564 == null) {
                    this.Field3564 = this.Field5233.world.loadedEntityList.stream().filter(this::Method5354).min(Comparator.comparing(this::Method5356)).orElse(null);
                    break;
                }
                if (!((double)this.Field3564.getDistance((Entity)this.Field5233.player) > (Double)this.Field3539.Method7979())) break;
                this.Field3564 = this.Field5233.world.loadedEntityList.stream().filter(this::Method4856).min(Comparator.comparing(this::Method5351)).orElse(null);
                break;
            }
            case 3: {
                this.Field3564 = this.Field5233.world.loadedEntityList.stream().filter(this::Method2425).min(Comparator.comparing(this::Method5358)).orElse(null);
                if (this.Field3564 != null) break;
                this.Field3564 = this.Field3565;
                break;
            }
            case 4: {
                this.Field3564 = this.Field5233.world.loadedEntityList.stream().filter(this::Method4844).min(Comparator.comparing(aura::Method5357)).orElse(null);
                break;
            }
        }
        if (this.Field3564 != null && (this.Field3564.isDead || this.Field3564 instanceof EntityLivingBase && ((EntityLivingBase)this.Field3564).getHealth() <= 0.0f)) {
            this.Field3564 = null;
        }
        if (this.Field3564 != null) {
            int n;
            switch (f6a.Field3169[((f6d)((Object)this.Field3540.Method7979())).ordinal()]) {
                case 1: {
                    break;
                }
                case 2: {
                    if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemSword) break;
                    return;
                }
                case 3: {
                    n = -1;
                    double d = 0.0;
                    for (int i = 0; i < 9; ++i) {
                        ItemStack itemStack = this.Field5233.player.inventory.getStackInSlot(i);
                        if (itemStack == null) continue;
                        if (!(itemStack.getItem() instanceof ItemSword) && !(itemStack.getItem() instanceof ItemTool)) continue;
                        if (n == -1) {
                            n = i;
                        }
                        for (Enchantment enchantment : EnchantmentHelper.getEnchantments((ItemStack)itemStack).keySet()) {
                            double d2;
                            if (!(enchantment instanceof EnchantmentDamage)) continue;
                            EnchantmentDamage enchantmentDamage = (EnchantmentDamage)enchantment;
                            if (enchantmentDamage.damageType != 0 || !((d2 = (double)EnchantmentHelper.getEnchantmentLevel((Enchantment)enchantment, (ItemStack)itemStack)) > d)) continue;
                            d = d2;
                            n = i;
                        }
                    }
                    if (n == -1) break;
                    this.Field5233.player.inventory.currentItem = n;
                    this.Field5233.playerController.updateController();
                    break;
                }
            }
            n = few.Method835().Method852(this.Field3564, (Double)this.Field3539.Method7979()) ? 1 : 0;
            fex fex2 = null;
            if (n == 0) {
                fex2 = few.Method835().Method843(this.Field3564.getEntityBoundingBox(), false, true, false, true);
            }
            if (fex2 != null) {
                Rotation rotation;
                if (fex2 != null && (rotation = few.Method835().Method832(few.Method835().Field511, fex2.Method891(), 180.0f)) != null) {
                    this.Field3562 = new float[]{rotation.Method6942(), rotation.Method6936()};
                    this.Field3563.Method490();
                }
            }
            if (n != 0) {
                if (this.Field3566 > 0) {
                    --this.Field3566;
                    return;
                }
                this.Field3563.Method490();
                boolean bl2 = this.Field5233.player.getHeldItemOffhand().getItem() instanceof ItemShield;
                if (this.Method2412()) {
                    if (!((Boolean)this.Field3542.Method7979()).booleanValue()) {
                        this.Field3566 = 40 / (Integer)this.Field3541.Method7979();
                    }
                    if (bl2 && ((Boolean)this.Field3545.Method7979()).booleanValue()) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, this.Field5233.player.getHorizontalFacing()));
                    }
                    this.Field5233.playerController.attackEntity((EntityPlayer)this.Field5233.player, this.Field3564);
                    this.Field5233.player.swingArm(EnumHand.MAIN_HAND);
                    this.Field3565 = this.Field3564;
                }
                if (bl2 && ((Boolean)this.Field3545.Method7979()).booleanValue()) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                }
            }
        }
    }

    public boolean Method2425(Entity entity) {
        return this.Method5355(entity, this.Field3565, true);
    }

    public boolean Method5352(Entity entity) {
        return this.Method5355(entity, null, true);
    }

    public Float Method5353(Entity entity) {
        return Float.valueOf(this.Field5233.player.getDistance(entity));
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field3563.Method490();
        this.Field3562 = null;
        this.Field3564 = null;
        this.Field3565 = null;
    }

    public boolean Method4856(Entity entity) {
        return this.Method5355(entity, null, true);
    }

    public boolean Method5354(Entity entity) {
        return this.Method5355(entity, null, true);
    }

    @f0g
    @LauncherEventHide
    public void Method2393(f49 f492) {
        if (f492.Method5619() == f41.Pre) {
            if (f492.Method5784() instanceof CPacketPlayer && this.Field3562 != null && this.Field5233.player.isRiding() && this.Field3564 != null) {
                CPacketPlayerAccessor cPacketPlayerAccessor = (CPacketPlayerAccessor)f492.Method5784();
                cPacketPlayerAccessor.Method8727(this.Field3562[0]);
                cPacketPlayerAccessor.Method8728(this.Field3562[1]);
            }
        } else if (f492.Method5619() == f41.Post) {
            if (f492.Method5784() instanceof CPacketPlayer) {
                if (this.Field3562 != null && this.Field5233.player.isRiding() && this.Field3564 != null && this.Method2412()) {
                    this.Field5233.playerController.attackEntity((EntityPlayer)this.Field5233.player, this.Field3564);
                    this.Field5233.player.swingArm(EnumHand.MAIN_HAND);
                    this.Field3565 = this.Field3564;
                }
            }
        }
    }

    public boolean Method5355(Entity entity, @Nullable Entity entity2, boolean bl) {
        boolean bl2;
        block33: {
            block32: {
                if (entity == entity2) break block32;
                if (this.Field5233.player == entity) break block32;
                if (entity != this.Field5233.player.getRidingEntity()) break block33;
            }
            return false;
        }
        if (!(entity instanceof EntityLivingBase)) {
            if (entity instanceof EntityBoat) {
                if (!((Boolean)this.Field3547.Method7979()).booleanValue()) {
                    return false;
                }
            } else {
                boolean bl3 = entity instanceof EntityShulkerBullet || entity instanceof EntityFireball ? true : (bl2 = false);
                if (!bl2) {
                    return false;
                }
                if (bl2 && !((Boolean)this.Field3548.Method7979()).booleanValue()) {
                    return false;
                }
            }
        }
        if (entity instanceof EntityPlayer && !((Boolean)this.Field3549.Method7979()).booleanValue() || entity instanceof EntityPlayer && !fe4.Field250.Method387((EntityPlayer)entity)) {
            return false;
        }
        if (entity instanceof EntityPlayer && ((Boolean)this.Field3555.Method7979()).booleanValue()) {
            bl2 = false;
            for (ItemStack itemStack : ((EntityPlayer)entity).inventory.armorInventory) {
                if (itemStack.isEmpty()) continue;
                bl2 = true;
                break;
            }
            if (!bl2) {
                return false;
            }
        }
        if (fdN.Method351(entity) && !((Boolean)this.Field3550.Method7979()).booleanValue()) {
            return false;
        }
        if (fdN.Method357(entity)) {
            if (!((Boolean)this.Field3551.Method7979()).booleanValue()) {
                return false;
            }
        }
        if (fdN.Method363(entity)) {
            bl2 = false;
            if (entity instanceof EntityTameable) {
                bl2 = true;
                if (((EntityTameable)entity).isTamed() && !((Boolean)this.Field3553.Method7979()).booleanValue()) {
                    return false;
                }
            } else if (entity instanceof AbstractHorse) {
                bl2 = true;
                if (((AbstractHorse)entity).isTame() && !((Boolean)this.Field3553.Method7979()).booleanValue()) {
                    return false;
                }
            }
            if (!bl2) {
                if (!((Boolean)this.Field3552.Method7979()).booleanValue()) {
                    return false;
                }
            }
        }
        if (entity instanceof EntityShulker && !((Boolean)this.Field3554.Method7979()).booleanValue()) {
            return false;
        }
        float f = entity.getDistance((Entity)this.Field5233.player);
        double d = entity.getDistanceSq((Entity)this.Field5233.player);
        boolean bl4 = this.Field5233.player.canEntityBeSeen(entity);
        if (!bl4 && !((Boolean)this.Field3543.Method7979()).booleanValue()) {
            return false;
        }
        if (bl) {
            if ((double)f > (Double)this.Field3539.Method7979()) {
                return false;
            }
            if (bl4) {
                if (d > 36.0) {
                    return false;
                }
            }
            if (!bl4 && d > 9.0) {
                return false;
            }
        }
        return entity.isEntityAlive();
    }

    @f0g
    @LauncherEventHide
    public void Method187(f4J f4J2) {
        this.Field3563.Method490();
        this.Field3562 = null;
        this.Field3564 = null;
        this.Field3565 = null;
    }

    public Float Method5356(Entity entity) {
        return Float.valueOf(this.Field5233.player.getDistance(entity));
    }

    public boolean Method4876() {
        if (((Boolean)this.Field3559.Method7979()).booleanValue() && this.Field5233.playerController.getIsHittingBlock()) {
            return true;
        }
        if (((Boolean)this.Field3558.Method7979()).booleanValue()) {
            if (this.Field5233.player.isHandActive() && this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemFood) {
                return true;
            }
        }
        if (((Boolean)this.Field3560.Method7979()).booleanValue() && this.Field5233.gameSettings.keyBindRight.isKeyDown() && this.Field5233.player.getHeldItemMainhand().getItem().equals((Object)Items.EXPERIENCE_BOTTLE)) {
            return true;
        }
        if (((Boolean)this.Field3557.Method7979()).booleanValue()) {
            if (((Boolean)PyroStatic.Field6416.Field5236.Method5264()).booleanValue()) {
                // empty if block
            }
        }
        return false;
    }

    @f0g
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre && !f4u2.Method7947() && this.Field3562 != null) {
            if (this.Field3564 != null) {
                f4u2.Method7948();
                f4u2.Method5653(this.Field3562[0]);
                f4u2.Method5647(this.Field3562[1]);
            }
        }
    }

    public aura() {
        super("aura", "Aura", "Attacks selectable enemies in range");
        this.Method7264(this.Field3538);
        this.Method7264(this.Field3539);
        this.Method7264(this.Field3540);
        this.Method7264(this.Field3546);
        this.Method7264(this.Field3556);
        this.Method7264(this.Field3561);
    }

    public static Float Method5357(Entity entity) {
        return Float.valueOf(entity instanceof EntityLivingBase ? ((EntityLivingBase)entity).getHealth() : 0.0f);
    }

    public Float Method5358(Entity entity) {
        return Float.valueOf(this.Field5233.player.getDistance(entity));
    }

    public boolean Method2412() {
        float f = 20.0f - f04.Field5418.Method7642();
        return ((Boolean)this.Field3542.Method7979()).booleanValue() ? this.Field5233.player.getCooledAttackStrength((Boolean)this.Field3544.Method7979() != false ? -f : 0.0f) >= 1.0f : true;
    }
}

