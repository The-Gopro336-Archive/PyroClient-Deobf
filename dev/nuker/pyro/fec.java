/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f4p;
import dev.nuker.pyro.fdZ;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.BlockPos;

public class fec
extends fdZ {
    public static double Method718() {
        float f = fec.Field313.player.rotationYaw;
        if (fec.Field313.player.moveForward < 0.0f) {
            f += 180.0f;
        }
        float f2 = 1.0f;
        if (fec.Field313.player.moveForward < 0.0f) {
            f2 = -0.5f;
        } else if (fec.Field313.player.moveForward > 0.0f) {
            f2 = 0.5f;
        }
        if (fec.Field313.player.moveStrafing > 0.0f) {
            f -= 90.0f * f2;
        }
        if (fec.Field313.player.moveStrafing < 0.0f) {
            f += 90.0f * f2;
        }
        return Math.toRadians(f);
    }

    public static double Method719() {
        return fec.Method725().posX;
    }

    public static double Method720() {
        return fec.Method725().posY;
    }

    public static boolean Method721() {
        return fec.Field313.player != null && (fec.Field313.player.movementInput.moveForward != 0.0f || fec.Field313.player.movementInput.moveStrafe != 0.0f) || fec.Field313.player.movementInput.jump || fec.Field313.player.movementInput.sneak;
    }

    public static void Method722(double d) {
        if (fec.Field313.player.getRidingEntity() != null) {
            MovementInput movementInput = fec.Field313.player.movementInput;
            double d2 = movementInput.moveForward;
            double d3 = movementInput.moveStrafe;
            float f = fec.Field313.player.rotationYaw;
            if (d2 == 0.0 && d3 == 0.0) {
                fec.Field313.player.getRidingEntity().motionX = 0.0;
                fec.Field313.player.getRidingEntity().motionZ = 0.0;
                return;
            }
            if (d2 != 0.0) {
                if (d3 > 0.0) {
                    f += (float)(d2 > 0.0 ? -45 : 45);
                } else if (d3 < 0.0) {
                    f += (float)(d2 > 0.0 ? 45 : -45);
                }
                d3 = 0.0;
                if (d2 > 0.0) {
                    d2 = 1.0;
                } else if (d2 < 0.0) {
                    d2 = -1.0;
                }
            }
            fec.Field313.player.getRidingEntity().motionX = d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f));
            fec.Field313.player.getRidingEntity().motionZ = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f));
        }
    }

    public static double[] Method723(double d) {
        double d2 = fec.Method729().moveForward;
        double d3 = fec.Method729().moveStrafe;
        float f = fec.Method730();
        if (d2 == 0.0 && d3 == 0.0) {
            return new double[]{0.0, 0.0};
        }
        if (d2 != 0.0) {
            if (d3 > 0.0) {
                f += (float)(d2 > 0.0 ? -45 : 45);
            } else if (d3 < 0.0) {
                f += (float)(d2 > 0.0 ? 45 : -45);
            }
            d3 = 0.0;
            if (d2 > 0.0) {
                d2 = 1.0;
            } else if (d2 < 0.0) {
                d2 = -1.0;
            }
        }
        return new double[]{d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f)), d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f))};
    }

    public static void Method724() {
        fec.Method458(fec.Method733());
    }

    public static EntityPlayerSP Method725() {
        return fec.Field313.player;
    }

    public static void Method726(double d) {
        double d2 = Math.toRadians(fec.Field313.player.rotationYaw);
        fec.Field313.player.setPosition(fec.Field313.player.posX + -Math.sin(d2) * d, fec.Field313.player.posY, fec.Field313.player.posZ + Math.cos(d2) * d);
    }

    public static boolean Method727() {
        return fec.Field313.player != null && (fec.Field313.player.movementInput.moveForward != 0.0f || fec.Field313.player.movementInput.moveStrafe != 0.0f);
    }

    public static double Method728(Entity entity) {
        double d = Math.pow(entity.posX - entity.lastTickPosX, 2.0);
        double d2 = Math.pow(entity.posZ - entity.lastTickPosZ, 2.0);
        return Math.round(Math.floor(Math.sqrt(d + d2) * 20.0 * 60.0 * 60.0) / 100.0) / 10L;
    }

    public static MovementInput Method729() {
        return fec.Method725().movementInput;
    }

    public static float Method730() {
        return fec.Method725().rotationYaw;
    }

    public static void Method731() {
        for (int i = 0; i < 70; ++i) {
            fec.Field313.player.connection.sendPacket((Packet)new CPacketPlayer.Position(fec.Field313.player.posX, fec.Field313.player.posY + 0.06, fec.Field313.player.posZ, false));
            fec.Field313.player.connection.sendPacket((Packet)new CPacketPlayer.Position(fec.Field313.player.posX, fec.Field313.player.posY, fec.Field313.player.posZ, false));
        }
        fec.Field313.player.connection.sendPacket((Packet)new CPacketPlayer.Position(fec.Field313.player.posX, fec.Field313.player.posY + 0.1, fec.Field313.player.posZ, false));
    }

    public static double[] Method732(double d) {
        if (!fec.Method727()) {
            return null;
        }
        double d2 = fec.Method718();
        double d3 = -Math.sin(d2) * d;
        double d4 = Math.cos(d2) * d;
        return new double[]{d3, d4};
    }

    public static float Method733() {
        return (float)Math.sqrt(fec.Field313.player.motionX * fec.Field313.player.motionX + fec.Field313.player.motionZ * fec.Field313.player.motionZ);
    }

    public static void Method734(double d) {
        fec.Method725().posX = d;
    }

    public static void Method735(float f) {
        fec.Method725().rotationPitch = f;
    }

    public static float Method736() {
        return fec.Method725().rotationPitch;
    }

    public static void Method737(float f) {
        fec.Method725().rotationYaw = f;
    }

    public static void Method738(double d) {
        fec.Method725().posZ = d;
    }

    public static void Method739(double d) {
        fec.Method725().posY = d;
    }

    public static float Method740() {
        return (float)Math.cbrt(fec.Field313.player.motionX * fec.Field313.player.motionX + fec.Field313.player.motionY * fec.Field313.player.motionY + fec.Field313.player.motionZ * fec.Field313.player.motionZ);
    }

    public static double Method741() {
        int n;
        double d = 0.2873;
        if (fec.Field313.player.isPotionActive(MobEffects.SPEED)) {
            n = fec.Field313.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d *= 1.0 + 0.2 * (double)(n + 1);
        }
        if (fec.Field313.player.isPotionActive(MobEffects.JUMP_BOOST)) {
            n = fec.Field313.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d /= 1.0 + 0.2 * (double)(n + 1);
        }
        return d;
    }

    public static double Method742() {
        return fec.Method725().posZ;
    }

    public static boolean Method743() {
        return fec.Field313.player.motionX != 0.0 && fec.Field313.player.motionZ != 0.0 && fec.Field313.player.motionY != 0.0;
    }

    public static void Method744(f4p f4p2, double d) {
        double d2 = fec.Method729().moveForward;
        double d3 = fec.Method729().moveStrafe;
        float f = fec.Method730();
        if (d2 == 0.0 && d3 == 0.0) {
            f4p2.Method5837(0.0);
            f4p2.Method5820(0.0);
        } else {
            if (d2 != 0.0) {
                if (d3 > 0.0) {
                    f += (float)(d2 > 0.0 ? -45 : 45);
                } else if (d3 < 0.0) {
                    f += (float)(d2 > 0.0 ? 45 : -45);
                }
                d3 = 0.0;
                if (d2 > 0.0) {
                    d2 = 1.0;
                } else if (d2 < 0.0) {
                    d2 = -1.0;
                }
            }
            f4p2.Method5837(d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f)));
            f4p2.Method5820(d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f)));
        }
    }

    public static void Method745(double[] arrd, BlockPos blockPos, double d) {
        double d2 = arrd[0];
        double d3 = arrd[1];
        double d4 = arrd[2];
        double d5 = (double)blockPos.getX() + 0.0;
        double d6 = (double)blockPos.getY() + 1.0;
        double d7 = (double)blockPos.getZ() + 0.0;
        double d8 = Math.abs(d2 - d5) + Math.abs(d3 - d6) + Math.abs(d4 - d7);
        int n = 0;
        double d9 = d8;
        while (d9 > d) {
            d8 = Math.abs(d2 - d5) + Math.abs(d3 - d6) + Math.abs(d4 - d7);
            if (n > 120) {
                return;
            }
            double d10 = d2 - d5;
            double d11 = d3 - d6;
            double d12 = d4 - d7;
            double d13 = (n & 1) == 0 ? 1.273197475E-314 : 0.0;
            double d14 = Math.min(Math.abs(d10), d13);
            if (d10 < 0.0) {
                d2 += d14;
                d9 = d11;
            } else {
                if (d10 > 0.0) {
                    d2 -= d14;
                }
                d9 = d11;
            }
            d10 = Math.min(Math.abs(d9), 0.0);
            if (d11 < 0.0) {
                d3 += d10;
                d9 = d12;
            } else {
                if (d11 > 0.0) {
                    d3 -= d10;
                }
                d9 = d12;
            }
            d10 = Math.min(Math.abs(d9), d13);
            if (d12 < 0.0) {
                d4 += d10;
            } else if (d12 > 0.0) {
                d4 -= d10;
            }
            ++n;
            fec.Field313.player.connection.sendPacket((Packet)new CPacketPlayer.Position(d2, d3, d4, true));
            d9 = d8;
        }
    }

    public static void Method458(float f) {
        if (!fec.Method727()) {
            return;
        }
        double d = fec.Method718();
        fec.Field313.player.motionX = -Math.sin(d) * (double)f;
        fec.Field313.player.motionZ = Math.cos(d) * (double)f;
    }
}

