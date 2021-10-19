/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.process.ICustomGoalProcess;
import dev.nuker.pyro.mixin.GuiChestAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.function.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing.Plane;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.items.VanillaDoubleChestItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdF extends Module {
   // $FF: renamed from: c java.util.concurrent.ConcurrentHashMap
   @NotNull
   public ConcurrentHashMap field_864 = new ConcurrentHashMap();
   // $FF: renamed from: c java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_865 = new CopyOnWriteArrayList();
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_866 = (BooleanSetting)this.register((f0w)(new BooleanSetting("selectSort", "SelectSortChests", (String)null, false)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_867 = (BooleanSetting)this.register((f0w)(new BooleanSetting("selectOn", "SelectPullChests", (String)null, false)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_868 = (BooleanSetting)this.register((f0w)(new BooleanSetting("active", "Active", (String)null, false)));
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_869;
   // $FF: renamed from: 1 int
   public int field_870;
   // $FF: renamed from: c dev.nuker.pyro.fdr
   public fdr field_871;
   // $FF: renamed from: c boolean
   public boolean field_872;
   // $FF: renamed from: c net.minecraft.item.ItemStack
   public ItemStack field_873;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_874;
   // $FF: renamed from: 0 boolean
   public boolean field_875;
   // $FF: renamed from: 1 boolean
   public boolean field_876;
   // $FF: renamed from: 2 int
   public int field_877;

   // $FF: renamed from: c () java.util.Map.Entry
   @Nullable
   public Entry method_1285() {
      Map var1 = (Map)this.field_864;
      boolean var2 = false;
      Map var4 = (Map)(new LinkedHashMap());
      boolean var5 = false;
      boolean var7 = false;
      Iterator var9 = var1.entrySet().iterator();

      Entry var10;
      boolean var13;
      boolean var15;
      fdr var16;
      ItemStack var17;
      while(var9.hasNext()) {
         boolean var10000;
         label322: {
            var10 = (Entry)var9.next();
            var13 = false;
            var15 = false;
            var16 = (fdr)var10.getKey();
            var15 = false;
            var17 = (ItemStack)var10.getValue();
            if (var16.method_1995() != null) {
               IInventory var10001 = var16.method_1995();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               if (this.method_1306(var10001, (Function1)fdv.field_66)) {
                  var10000 = true;
                  break label322;
               }
            }

            var10000 = false;
         }

         if (var10000) {
            var4.put(var10.getKey(), var10.getValue());
         }
      }

      var2 = false;
      Map var3 = var4;
      var4 = (Map)(new LinkedHashMap());
      var5 = false;
      var7 = false;
      var9 = var3.entrySet().iterator();

      while(var9.hasNext()) {
         var10 = (Entry)var9.next();
         var13 = false;
         var15 = false;
         var16 = (fdr)var10.getKey();
         var15 = false;
         var17 = (ItemStack)var10.getValue();
         if (this.method_1306((IInventory)this.c.player.inventory, (Function1)(new fdu(var17, this)))) {
            var4.put(var10.getKey(), var10.getValue());
         }
      }

      var2 = false;
      Iterable var18 = (Iterable)var4.entrySet();
      boolean var19 = false;
      Iterator var20 = var18.iterator();
      Object var30;
      if (!var20.hasNext()) {
         var30 = null;
      } else {
         Object var6 = var20.next();
         if (!var20.hasNext()) {
            var30 = var6;
         } else {
            Entry var21 = (Entry)var6;
            boolean var23 = false;
            boolean var12 = false;
            fdr var26 = (fdr)var21.getKey();
            var12 = false;
            ItemStack var14 = (ItemStack)var21.getValue();
            double var22 = this.c.player.getDistanceSq(var26.method_1998());

            do {
               Object var24 = var20.next();
               var10 = (Entry)var24;
               var12 = false;
               boolean var27 = false;
               fdr var28 = (fdr)var10.getKey();
               var27 = false;
               ItemStack var29 = (ItemStack)var10.getValue();
               double var25 = this.c.player.getDistanceSq(var28.method_1998());
               if (Double.compare(var22, var25) > 0) {
                  var6 = var24;
                  var22 = var25;
               }
            } while(var20.hasNext());

            var30 = var6;
         }
      }

      return (Entry)var30;
   }

   // $FF: renamed from: c (java.util.concurrent.ConcurrentHashMap) void
   public void method_1286(@NotNull ConcurrentHashMap var1) {
      this.field_864 = var1;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fdF) boolean
   public static boolean method_1287(fdF var0) {
      return var0.field_875;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_1288(@Nullable BlockPos var1) {
      this.field_869 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_1289(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         GuiChestAccessor var10000;
         fdr var35;
         if (this.c.currentScreen instanceof GuiChest) {
            GuiChest var2 = (GuiChest)this.c.currentScreen;
            var10000 = (GuiChestAccessor)var2;
            if ((GuiChestAccessor)var2 == null) {
               Intrinsics.throwNpe();
            }

            IInventory var3 = var10000.getLowerChestInventory();
            Iterable var5 = (Iterable)this.field_865;
            boolean var6 = false;
            Iterator var7 = var5.iterator();

            Object var8;
            fdr var9;
            boolean var10;
            Object var34;
            while(true) {
               if (!var7.hasNext()) {
                  var34 = null;
                  break;
               }

               var8 = var7.next();
               var9 = (fdr)var8;
               var10 = false;
               if (Intrinsics.areEqual((Object)var9.method_2004(), (Object)this.field_869) || Intrinsics.areEqual((Object)var9.method_1997(), (Object)this.field_869)) {
                  var34 = var8;
                  break;
               }
            }

            var35 = (fdr)var34;
            if ((fdr)var34 == null) {
               var5 = (Iterable)((KeySetView)this.field_864.keySet());
               var6 = false;
               var7 = var5.iterator();

               while(true) {
                  if (!var7.hasNext()) {
                     var34 = null;
                     break;
                  }

                  var8 = var7.next();
                  var9 = (fdr)var8;
                  var10 = false;
                  if (Intrinsics.areEqual((Object)var9.method_2004(), (Object)this.field_869) || Intrinsics.areEqual((Object)var9.method_1997(), (Object)this.field_869)) {
                     var34 = var8;
                     break;
                  }
               }

               var35 = (fdr)var34;
            }

            fdr var4 = var35;
            if (var4 != null) {
               var4.method_2005(var3);
            }
         }

         if ((Boolean)this.field_868.c()) {
            Iterable var18;
            fdr var10003;
            boolean var20;
            Iterator var24;
            Object var27;
            ItemStack var29;
            boolean var31;
            fdr var38;
            boolean var39;
            GoalBlock var40;
            EntityPlayerSP var43;
            ICustomGoalProcess var46;
            switch(this.field_870) {
            case 0:
               if (!this.field_876) {
                  Entry var22 = this.method_1285();
                  if (var22 == null) {
                     this.field_876 = true;
                     return;
                  }

                  this.field_872 = true;
                  this.field_873 = (ItemStack)var22.getValue();
                  this.field_871 = (fdr)var22.getKey();
               } else {
                  this.field_871 = this.method_1305();
                  var18 = (Iterable)this.c.player.inventory.mainInventory;
                  var20 = false;
                  if (var18 instanceof Collection && ((Collection)var18).isEmpty()) {
                     var39 = true;
                  } else {
                     var24 = var18.iterator();

                     while(true) {
                        if (var24.hasNext()) {
                           var27 = var24.next();
                           var29 = (ItemStack)var27;
                           var31 = false;
                           if (!var29.isEmpty()) {
                              continue;
                           }

                           var39 = false;
                           break;
                        }

                        var39 = true;
                        break;
                     }
                  }

                  if (var39 || this.field_871 == null) {
                     this.field_876 = false;
                     return;
                  }

                  this.field_872 = false;
               }

               if (this.field_871 != null) {
                  var46 = BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess();
                  var40 = new GoalBlock;
                  var10003 = this.field_871;
                  if (var10003 == null) {
                     Intrinsics.throwNpe();
                  }

                  var40.<init>(var10003.method_1998());
                  var46.setGoal((Goal)var40);
                  BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().path();
                  this.field_870 = 1;
               }
               break;
            case 1:
               if (!this.method_1293()) {
                  if (this.field_877 > 0) {
                     this.field_877 += -1;
                  }

                  BlockPos var45 = new BlockPos(this.c.player.getPositionVector());
                  var38 = this.field_871;
                  if (var38 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (Intrinsics.areEqual((Object)var45, (Object)var38.method_1998()) ^ true) {
                     var43 = this.c.player;
                     var38 = this.field_871;
                     if (var38 == null) {
                        Intrinsics.throwNpe();
                     }

                     if (var43.getDistanceSq(var38.method_2004()) > (double)36) {
                        var46 = BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess();
                        var40 = new GoalBlock;
                        var10003 = this.field_871;
                        if (var10003 == null) {
                           Intrinsics.throwNpe();
                        }

                        var40.<init>(var10003.method_1998());
                        var46.setGoal((Goal)var40);
                        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().path();
                        this.field_877 = 20;
                        return;
                     }
                  }

                  this.field_870 = 2;
               }
               break;
            case 2:
               if (this.c.currentScreen instanceof GuiChest && this.field_875) {
                  this.field_875 = false;
                  this.field_870 = 4;
               }

               var43 = this.c.player;
               var38 = this.field_871;
               if (var38 == null) {
                  Intrinsics.throwNpe();
               }

               if (var43.getDistanceSq(var38.method_2004()) > (double)36) {
                  this.field_870 = 1;
                  return;
               }

               Pyro.INSTANCE.sendMessage("Attempting to open chest");
               var35 = this.field_871;
               if (var35 == null) {
                  Intrinsics.throwNpe();
               }

               EnumFacing var21 = few.method_1732(var35.method_2004(), true);
               few var44 = few.method_1716();
               var38 = this.field_871;
               if (var38 == null) {
                  Intrinsics.throwNpe();
               }

               float[] var25 = var44.method_1736(var38.method_2004(), var21);
               var1.0();
               var1.method_3139(var25[0]);
               var1.method_3140(var25[1]);
               if (this.field_874.method_1980(1000.0D)) {
                  if (this.c.currentScreen instanceof GuiChest) {
                     this.c.player.closeScreen();
                  }

                  this.field_874.method_1979();
                  var1.method_3133((Consumer)(new fdw(this, var25)));
               }
               break;
            case 3:
               if (this.c.currentScreen instanceof GuiChest) {
                  this.field_870 = 4;
               }
               break;
            case 4:
               if (this.c.currentScreen instanceof GuiChest) {
                  label1164: {
                     GuiScreen var10001;
                     GuiChestAccessor var36;
                     label1177: {
                        if (this.field_872) {
                           var18 = (Iterable)this.c.player.inventory.mainInventory;
                           var20 = false;
                           if (var18 instanceof Collection && ((Collection)var18).isEmpty()) {
                              var39 = false;
                           } else {
                              var24 = var18.iterator();

                              while(true) {
                                 if (var24.hasNext()) {
                                    var27 = var24.next();
                                    var29 = (ItemStack)var27;
                                    var31 = false;
                                    ItemStack var10002 = this.field_873;
                                    if (var10002 == null) {
                                       Intrinsics.throwNpe();
                                    }

                                    if (!this.method_1302(var29, var10002)) {
                                       continue;
                                    }

                                    var39 = true;
                                    break;
                                 }

                                 var39 = false;
                                 break;
                              }
                           }

                           if (var39) {
                              var10001 = this.c.currentScreen;
                              if (var10001 == null) {
                                 throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                              }

                              var36 = (GuiChestAccessor)((GuiChest)var10001);
                              if ((GuiChestAccessor)((GuiChest)var10001) == null) {
                                 Intrinsics.throwNpe();
                              }

                              if (this.method_1306(var36.getLowerChestInventory(), (Function1)fdx.field_65)) {
                                 break label1177;
                              }
                           }
                        }

                        if (this.field_872 || this.field_872) {
                           break label1164;
                        }

                        var18 = (Iterable)this.c.player.inventory.mainInventory;
                        var20 = false;
                        if (var18 instanceof Collection && ((Collection)var18).isEmpty()) {
                           var39 = false;
                        } else {
                           var24 = var18.iterator();

                           while(true) {
                              if (!var24.hasNext()) {
                                 var39 = false;
                                 break;
                              }

                              var27 = var24.next();
                              var29 = (ItemStack)var27;
                              var31 = false;
                              if (var29.isEmpty()) {
                                 var39 = true;
                                 break;
                              }
                           }
                        }

                        if (!var39) {
                           break label1164;
                        }

                        var10001 = this.c.currentScreen;
                        if (var10001 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                        }

                        var36 = (GuiChestAccessor)((GuiChest)var10001);
                        if ((GuiChestAccessor)((GuiChest)var10001) == null) {
                           Intrinsics.throwNpe();
                        }

                        if (!this.method_1306(var36.getLowerChestInventory(), (Function1)(new fdz(this)))) {
                           break label1164;
                        }
                     }

                     f8g var41 = PyroStatic.field_2595;
                     var10001 = this.c.currentScreen;
                     if (var10001 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                     }

                     var36 = (GuiChestAccessor)((GuiChest)var10001);
                     if ((GuiChestAccessor)((GuiChest)var10001) == null) {
                        Intrinsics.throwNpe();
                     }

                     var41.method_467(var36.getLowerChestInventory());
                     if (PyroStatic.field_2595.method_464().method_1980(((Number)PyroStatic.field_2595.method_475().c()).doubleValue() * (double)100)) {
                        GuiScreen var42 = this.c.currentScreen;
                        if (var42 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest");
                        }

                        var10000 = (GuiChestAccessor)((GuiChest)var42);
                        if ((GuiChestAccessor)((GuiChest)var42) == null) {
                           Intrinsics.throwNpe();
                        }

                        IInventory var19 = var10000.getLowerChestInventory();
                        int var23 = 0;
                        if (var19 == null) {
                           Intrinsics.throwNpe();
                        }

                        int var26 = var19.getSizeInventory();
                        if (var23 <= var26) {
                           while(true) {
                              ItemStack var28 = var19.getStackInSlot(var23);
                              if (var28.isEmpty()) {
                                 if (this.field_872) {
                                    PyroStatic.field_2595.method_473(var23, (Function1)(new fdA(this)));
                                    return;
                                 }
                              } else if (!this.field_872 && !var28.isEmpty()) {
                                 Map var30 = (Map)this.field_864;
                                 var31 = false;
                                 if (var30.isEmpty()) {
                                    var39 = false;
                                 } else {
                                    boolean var32 = false;
                                    Iterator var33 = var30.entrySet().iterator();

                                    while(true) {
                                       if (!var33.hasNext()) {
                                          var39 = false;
                                          break;
                                       }

                                       label993: {
                                          Entry var11 = (Entry)var33.next();
                                          boolean var13 = false;
                                          boolean var15 = false;
                                          fdr var16 = (fdr)var11.getKey();
                                          var15 = false;
                                          ItemStack var17 = (ItemStack)var11.getValue();
                                          if (this.method_1302(var17, var28)) {
                                             IInventory var37 = var16.method_1995();
                                             if (var37 == null) {
                                                Intrinsics.throwNpe();
                                             }

                                             if (this.method_1306(var37, (Function1)fdB.field_71)) {
                                                var39 = true;
                                                break label993;
                                             }
                                          }

                                          var39 = false;
                                       }

                                       if (var39) {
                                          var39 = true;
                                          break;
                                       }
                                    }
                                 }

                                 if (var39) {
                                    PyroStatic.field_2595.method_476(var23);
                                    return;
                                 }
                              }

                              if (var23 == var26) {
                                 return;
                              }

                              ++var23;
                           }
                        }
                     }
                     break;
                  }
               }

               this.field_870 = 5;
               break;
            case 5:
               this.c.player.closeScreen();
               Pyro.INSTANCE.sendMessage("Marked as done");
               this.field_870 = 6;
               break;
            case 6:
               this.field_870 = 0;
            }
         } else {
            this.field_870 = 0;
         }

      }
   }

   // $FF: renamed from: 5 () java.util.concurrent.ConcurrentHashMap
   @NotNull
   public ConcurrentHashMap method_1290() {
      return this.field_864;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1291() {
      return this.field_867;
   }

   // $FF: renamed from: 2 (dev.nuker.pyro.fdF) dev.nuker.pyro.fdr
   public static fdr method_1292(fdF var0) {
      return var0.field_871;
   }

   // $FF: renamed from: 6 () boolean
   public boolean method_1293() {
      return BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().getGoal() != null;
   }

   // $FF: renamed from: 1 (net.minecraft.inventory.IInventory, kotlin.jvm.functions.Function1) int
   public int method_1294(@NotNull IInventory var1, @NotNull Function1 var2) {
      int var3 = 0;
      int var4 = 0;

      for(int var5 = var1.getSizeInventory(); var4 < var5; ++var4) {
         if ((Boolean)var2.invoke(var1.getStackInSlot(var4))) {
            ++var3;
         }
      }

      return var3;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1295() {
      return this.field_866;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fdF) net.minecraft.item.ItemStack
   public static ItemStack method_1296(fdF var0) {
      return var0.field_873;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      fe5.field_1245.method_1915(7);
      Iterator var4 = this.field_865.iterator();

      fdr var3;
      boolean var5;
      int var6;
      fdq var7;
      fdq var10000;
      BlockPos var10001;
      BlockPos var10002;
      BlockPos var10003;
      fe5 var32;
      while(var4.hasNext()) {
         var3 = (fdr)var4.next();
         if (var3.method_2004() != null) {
            var5 = var3.method_1999();
            var6 = var5 ? 1351124992 : 1344414344;
            if (var3.method_1997() != null) {
               var10000 = new fdq;
               var10002 = var3.method_2004();
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var10003 = var3.method_1997();
               if (var10003 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.<init>(var10002, var10003);
               var7 = var10000;
               fe5.field_1245.method_1901((float)var7.method_1994().getX(), (float)var7.method_1994().getY(), (float)var7.method_1994().getZ(), (float)var7.method_1993().getX() - (float)var7.method_1994().getX() + 1.0F, (float)var7.method_1993().getY() - (float)var7.method_1994().getY() + 1.0F, (float)var7.method_1993().getZ() - (float)var7.method_1994().getZ() + 1.0F, var6, 63);
            } else {
               var32 = fe5.field_1245;
               var10001 = var3.method_2004();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var32.method_1917(var10001, var6, 63);
            }
         }
      }

      var4 = ((KeySetView)this.field_864.keySet()).iterator();

      while(var4.hasNext()) {
         var3 = (fdr)var4.next();
         if (var3.method_2004() != null) {
            IInventory var33 = var3.method_1995();
            var5 = var33 != null ? this.method_1310(var33, (Function1)fdE.field_73) : false;
            var6 = var5 ? 1342233890 : 1342234077;
            if (var3.method_1997() != null) {
               var10000 = new fdq;
               var10002 = var3.method_2004();
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var10003 = var3.method_1997();
               if (var10003 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.<init>(var10002, var10003);
               var7 = var10000;
               fe5.field_1245.method_1901((float)var7.method_1994().getX(), (float)var7.method_1994().getY(), (float)var7.method_1994().getZ(), (float)var7.method_1993().getX() - (float)var7.method_1994().getX() + 1.0F, (float)var7.method_1993().getY() - (float)var7.method_1994().getY() + 1.0F, (float)var7.method_1993().getZ() - (float)var7.method_1994().getZ() + 1.0F, var6, 63);
            } else {
               var32 = fe5.field_1245;
               var10001 = var3.method_2004();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var32.method_1917(var10001, var6, 63);
            }
         }
      }

      fe5.field_1245.method_1912();
      var4 = this.field_865.iterator();

      while(true) {
         boolean var8;
         EnumFacing var10004;
         EnumFacing var10005;
         Vec3d var34;
         double var37;
         EnumFacing var38;
         double var39;
         BlockPos var40;
         double var41;
         do {
            do {
               if (!var4.hasNext()) {
                  Map var23 = (Map)this.field_864;
                  boolean var26 = false;
                  var4 = var23.entrySet().iterator();

                  while(var4.hasNext()) {
                     Entry var21 = (Entry)var4.next();
                     var8 = false;
                     fdr var24 = (fdr)var21.getKey();
                     var8 = false;
                     ItemStack var27 = (ItemStack)var21.getValue();
                     if (var24.method_2004() != null && var24.method_1995() != null) {
                        if (var24.method_1997() != null) {
                           var34 = new Vec3d;
                           var10002 = var24.method_2004();
                           if (var10002 == null) {
                              Intrinsics.throwNpe();
                           }

                           var37 = (double)var10002.getX();
                           var38 = var24.method_2002();
                           if (var38 == null) {
                              Intrinsics.throwNpe();
                           }

                           var37 += (double)((float)var38.getFrontOffsetX() / 2.0F);
                           var10003 = var24.method_2004();
                           if (var10003 == null) {
                              Intrinsics.throwNpe();
                           }

                           var39 = (double)var10003.getY();
                           var10004 = var24.method_2002();
                           if (var10004 == null) {
                              Intrinsics.throwNpe();
                           }

                           var39 += (double)((float)var10004.getFrontOffsetY() / 2.0F);
                           var40 = var24.method_2004();
                           if (var40 == null) {
                              Intrinsics.throwNpe();
                           }

                           var41 = (double)var40.getZ();
                           var10005 = var24.method_2002();
                           if (var10005 == null) {
                              Intrinsics.throwNpe();
                           }

                           var34.<init>(var37, var39, var41 + (double)((float)var10005.getFrontOffsetZ() / 2.0F));
                        } else {
                           var34 = new Vec3d((Vec3i)var24.method_2004());
                        }

                        Vec3d var30 = var34;
                        IInventory var42 = var24.method_1995();
                        if (var42 == null) {
                           Intrinsics.throwNpe();
                        }

                        this.method_1301(var30, CollectionsKt.listOf(TuplesKt.method_2843(var27, String.valueOf(this.method_1294(var42, (Function1)fdD.field_74)))), var2);
                     }
                  }

                  GlStateManager.enableBlend();
                  return;
               }

               var3 = (fdr)var4.next();
            } while(var3.method_2004() == null);
         } while(var3.method_1995() == null);

         if (var3.method_1997() != null) {
            var34 = new Vec3d;
            var10002 = var3.method_2004();
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            var37 = (double)var10002.getX();
            var38 = var3.method_2002();
            if (var38 == null) {
               Intrinsics.throwNpe();
            }

            var37 += (double)((float)var38.getFrontOffsetX() / 2.0F);
            var10003 = var3.method_2004();
            if (var10003 == null) {
               Intrinsics.throwNpe();
            }

            var39 = (double)var10003.getY();
            var10004 = var3.method_2002();
            if (var10004 == null) {
               Intrinsics.throwNpe();
            }

            var39 += (double)((float)var10004.getFrontOffsetY() / 2.0F);
            var40 = var3.method_2004();
            if (var40 == null) {
               Intrinsics.throwNpe();
            }

            var41 = (double)var40.getZ();
            var10005 = var3.method_2002();
            if (var10005 == null) {
               Intrinsics.throwNpe();
            }

            var34.<init>(var37, var39, var41 + (double)((float)var10005.getFrontOffsetZ() / 2.0F));
         } else {
            var34 = new Vec3d((Vec3i)var3.method_2004());
         }

         Vec3d var22 = var34;
         Ref.ObjectRef var25 = new Ref.ObjectRef();
         boolean var28 = false;
         List var20 = (List)(new ArrayList());
         var25.element = var20;
         Iterable var29 = (Iterable)this.field_864.values();
         var8 = false;
         Iterator var9 = var29.iterator();

         while(var9.hasNext()) {
            Object var10 = var9.next();
            ItemStack var11 = (ItemStack)var10;
            boolean var12 = false;
            Iterable var13 = (Iterable)((List)var25.element);
            boolean var14 = false;
            boolean var36;
            if (var13 instanceof Collection && ((Collection)var13).isEmpty()) {
               var36 = false;
            } else {
               Iterator var15 = var13.iterator();

               while(true) {
                  if (!var15.hasNext()) {
                     var36 = false;
                     break;
                  }

                  Object var16 = var15.next();
                  Pair var17 = (Pair)var16;
                  boolean var18 = false;
                  if (this.method_1302((ItemStack)var17.getFirst(), var11)) {
                     var36 = true;
                     break;
                  }
               }
            }

            if (!var36) {
               IInventory var35 = var3.method_1995();
               if (var35 == null) {
                  Intrinsics.throwNpe();
               }

               int var31 = this.method_1294(var35, (Function1)(new fdC(var11, this, var25, var3)));
               if (var31 > 0) {
                  ((List)var25.element).add(TuplesKt.method_2843(var11, String.valueOf(var31)));
               }
            }
         }

         if (((List)var25.element).isEmpty()) {
            ((List)var25.element).add(TuplesKt.method_2843(new ItemStack(Blocks.BARRIER), ""));
         }

         this.method_1301(var22, (List)var25.element, var2);
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdF, boolean) void
   public static void method_1297(fdF var0, boolean var1) {
      var0.field_875 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdF, dev.nuker.pyro.fdr) void
   public static void method_1298(fdF var0, fdr var1) {
      var0.field_871 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdF, net.minecraft.client.Minecraft) void
   public static void method_1299(fdF var0, Minecraft var1) {
      var0.c = var1;
   }

   public fdF() {
      super("stashsorter", "StashSorter", (String)null);
      this.field_867.c((Consumer)(new fdn(this)));
      this.field_866.c((Consumer)(new fdo(this)));
      this.field_868.c((Consumer)(new fdp(this)));
      this.field_874 = new fe8();
      this.field_876 = true;
   }

   // $FF: renamed from: 0 () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_1300() {
      return this.field_865;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, java.util.List, float) void
   public void method_1301(@NotNull Vec3d var1, @NotNull List var2, float var3) {
      Entity var4 = this.c.getRenderViewEntity();
      Vec3d var5 = fdY.method_1817(var1, var3);
      double var6 = var5.x;
      double var8 = var5.y + 0.65D;
      double var10 = var5.z;
      double var12 = var8 + (double)0.08F;
      var5 = fdY.method_1816(var4, var3);
      if (var4 == null) {
         Intrinsics.throwNpe();
      }

      double var14 = var4.posX;
      double var16 = var4.posY;
      double var18 = var4.posZ;
      var4.posX = var5.x;
      var4.posY = var5.y;
      var4.posZ = var5.z;
      var4.getDistance(var6, var8, var10);
      double var20 = 0.05D;
      GlStateManager.pushMatrix();
      RenderHelper.enableStandardItemLighting();
      GlStateManager.enablePolygonOffset();
      GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
      GlStateManager.disableLighting();
      GlStateManager.translate(var6 + 0.5D, var12 - 0.25D, var10 + 0.5D);
      float var22 = -this.c.getRenderManager().playerViewY;
      float var23 = 1.0F;
      float var24 = 0.0F;
      GlStateManager.rotate(var22, var24, var23, var24);
      GlStateManager.rotate(this.c.getRenderManager().playerViewX, this.c.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F, 0.0F, (float)0);
      GlStateManager.scale(-var20, -var20, var20);
      GlStateManager.disableDepth();
      GlStateManager.enableBlend();
      float var25 = 0.0F;
      GlStateManager.pushMatrix();
      int var26 = 0;
      int var27 = 0;
      boolean var28 = false;
      int var29 = var2.size();
      int var30 = 1;
      int var31 = 1;

      for(int var32 = var29; var31 < var32; ++var31) {
         if (var29 / var31 < var31) {
            var30 = var31;
            break;
         }
      }

      float var35 = var29 == 2 ? 0.5F : 1.0F / (float)var30;
      GlStateManager.pushMatrix();
      GlStateManager.scale(var35, var35, var35);
      GlStateManager.translate((double)(-var30 * 8), (double)(-var30 * 8), 0.0D);
      Iterator var33 = var2.iterator();

      while(var33.hasNext()) {
         Pair var36 = (Pair)var33.next();
         GlStateManager.depthMask(true);
         GlStateManager.clear(256);
         RenderHelper.enableStandardItemLighting();
         this.c.getRenderItem().zLevel = -150.0F;
         GlStateManager.disableAlpha();
         GlStateManager.enableDepth();
         GlStateManager.disableCull();
         this.c.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)var36.getFirst(), var26 * 16, var27 * 16);
         String var34 = (String)var36.getSecond();
         GlStateManager.disableLighting();
         GlStateManager.disableDepth();
         GlStateManager.disableBlend();
         this.c.fontRenderer.drawStringWithShadow(var34, (float)(var26 * 16 + 19 - 2) - (float)this.c.fontRenderer.getStringWidth(var34), (float)9 + (float)var27 * 16.0F, 16777215);
         GlStateManager.enableLighting();
         GlStateManager.enableDepth();
         GlStateManager.enableBlend();
         this.c.getRenderItem().zLevel = 0.0F;
         RenderHelper.disableStandardItemLighting();
         GlStateManager.enableCull();
         GlStateManager.enableAlpha();
         ++var26;
         if (var26 % var30 == 0) {
            var26 = 0;
            ++var27;
         }
      }

      GlStateManager.popMatrix();
      GlStateManager.popMatrix();
      GlStateManager.enableDepth();
      GlStateManager.disableBlend();
      GlStateManager.disablePolygonOffset();
      GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
      GlStateManager.popMatrix();
      var4.posX = var14;
      var4.posY = var16;
      var4.posZ = var18;
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack, net.minecraft.item.ItemStack) boolean
   public boolean method_1302(@NotNull ItemStack var1, @NotNull ItemStack var2) {
      return Intrinsics.areEqual((Object)var2.getItem(), (Object)var1.getItem()) && var1.getMetadata() == var2.getMetadata() && Intrinsics.areEqual((Object)var1.getSubCompound("display"), (Object)var2.getSubCompound("display")) && Intrinsics.areEqual((Object)var1.getSubCompound("BlockEntityTag"), (Object)var2.getSubCompound("BlockEntityTag"));
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdF) net.minecraft.client.Minecraft
   public static Minecraft method_1303(fdF var0) {
      return var0.c;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1304() {
      return this.field_868;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.fdr
   @Nullable
   public fdr method_1305() {
      Iterable var1 = (Iterable)this.field_865;
      boolean var2 = false;
      Collection var4 = (Collection)(new ArrayList());
      boolean var5 = false;
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         Object var8 = var7.next();
         fdr var10 = (fdr)var8;
         boolean var11 = false;
         IInventory var10001 = var10.method_1995();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         if (this.method_1306(var10001, (Function1)(new fds(this)))) {
            var4.add(var8);
         }
      }

      var1 = (Iterable)((List)var4);
      var2 = false;
      Iterator var3 = var1.iterator();
      Object var10000;
      if (!var3.hasNext()) {
         var10000 = null;
      } else {
         Object var12 = var3.next();
         if (!var3.hasNext()) {
            var10000 = var12;
         } else {
            fdr var13 = (fdr)var12;
            boolean var15 = false;
            double var14 = this.c.player.getDistanceSq(var13.method_1998());

            do {
               Object var16 = var3.next();
               fdr var17 = (fdr)var16;
               boolean var19 = false;
               double var18 = this.c.player.getDistanceSq(var17.method_1998());
               if (Double.compare(var14, var18) > 0) {
                  var12 = var16;
                  var14 = var18;
               }
            } while(var3.hasNext());

            var10000 = var12;
         }
      }

      return (fdr)var10000;
   }

   // $FF: renamed from: 0 (net.minecraft.inventory.IInventory, kotlin.jvm.functions.Function1) boolean
   public boolean method_1306(@NotNull IInventory var1, @NotNull Function1 var2) {
      int var3 = 0;

      for(int var4 = var1.getSizeInventory(); var3 < var4; ++var3) {
         if ((Boolean)var2.invoke(var1.getStackInSlot(var3))) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: c (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_1307(@NotNull CopyOnWriteArrayList var1) {
      this.field_865 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4w) void
   @f0g
   @LauncherEventHide
   public void method_1308(@NotNull f4w var1) {
      IBlockState var2 = this.c.world.getBlockState(var1.method_3118());
      if (var2.getBlock() instanceof BlockChest) {
         this.field_869 = var1.method_3118();
         if (!(Boolean)this.field_867.c() && !(Boolean)this.field_866.c()) {
            return;
         }

         Iterable var4 = (Iterable)((Boolean)this.field_866.c() ? (Set)((KeySetView)this.field_864.keySet()) : CollectionsKt.toSet((Iterable)this.field_865));
         boolean var5 = false;
         Iterator var6 = var4.iterator();

         Object var10000;
         while(true) {
            if (!var6.hasNext()) {
               var10000 = null;
               break;
            }

            Object var7 = var6.next();
            fdr var8 = (fdr)var7;
            boolean var9 = false;
            if (Intrinsics.areEqual((Object)var8.method_2004(), (Object)var1.method_3118()) || Intrinsics.areEqual((Object)var8.method_1997(), (Object)var1.method_3118())) {
               var10000 = var7;
               break;
            }
         }

         fdr var3 = (fdr)var10000;
         if (var3 != null) {
            if ((Boolean)this.field_866.c()) {
               this.field_864.remove(var3);
            } else {
               this.field_865.remove(var3);
            }

            return;
         }

         fdr var10 = new fdr();
         var10.method_2000(var1.method_3118());
         TileEntity var16 = this.c.world.getTileEntity(var1.method_3118());
         if (var16 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.tileentity.TileEntityChest");
         }

         VanillaDoubleChestItemHandler var11 = ((TileEntityChest)var16).doubleChestHandler;
         EnumFacing[] var14 = Plane.HORIZONTAL.facings();
         int var15 = var14.length;

         for(int var13 = 0; var13 < var15; ++var13) {
            EnumFacing var12 = var14[var13];
            if (Intrinsics.areEqual((Object)this.c.world.getBlockState(var1.method_3118().offset(var12)).getBlock(), (Object)var2.getBlock())) {
               var10.method_2003(var1.method_3118().offset(var12));
               var10.method_2001(var12);
               break;
            }
         }

         if (var11 != null) {
            TileEntityChest var10002 = var11.getChest(false);
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            TileEntityChest var10001 = var11.getChest(Intrinsics.areEqual((Object)var10002.getPos(), (Object)var10.method_2004()));
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            var10.method_2003(var10001.getPos());
         }

         var10.method_1996(this.c.player.getPosition());
         if ((Boolean)this.field_866.c()) {
            if (this.c.player.getHeldItemMainhand().isEmpty()) {
               Pyro.INSTANCE.sendMessage("You must set a sorting item");
            } else {
               ((Map)this.field_864).put(var10, this.c.player.getHeldItemMainhand());
            }
         } else {
            this.field_865.add(var10);
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.inventory.IInventory, float) void
   public void method_1309(@NotNull Vec3d var1, @NotNull IInventory var2, float var3) {
      NonNullList var4 = NonNullList.create();
      int var5 = 0;

      for(int var6 = var2.getSizeInventory(); var5 < var6; ++var5) {
         var4.add(var2.getStackInSlot(var5));
      }

      Entity var33 = this.c.getRenderViewEntity();
      Vec3d var34 = fdY.method_1819(var1, var3);
      double var7 = var34.x;
      double var9 = var34.y + 0.65D;
      double var11 = var34.z;
      double var13 = var9 + (double)0.08F;
      var34 = fdY.method_1816(var33, var3);
      if (var33 == null) {
         Intrinsics.throwNpe();
      }

      double var15 = var33.posX;
      double var17 = var33.posY;
      double var19 = var33.posZ;
      var33.posX = var34.x;
      var33.posY = var34.y;
      var33.posZ = var34.z;
      var33.getDistance(var7, var9, var11);
      double var21 = 0.01D;
      GlStateManager.pushMatrix();
      RenderHelper.enableStandardItemLighting();
      GlStateManager.enablePolygonOffset();
      GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
      GlStateManager.disableLighting();
      GlStateManager.translate(var7 + 0.5D, var13, var11 + 0.5D);
      float var23 = -this.c.getRenderManager().playerViewY;
      float var24 = 1.0F;
      float var25 = 0.0F;
      GlStateManager.rotate(var23, var25, var24, var25);
      GlStateManager.rotate(this.c.getRenderManager().playerViewX, this.c.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F, 0.0F, (float)0);
      GlStateManager.scale(-var21, -var21, var21);
      GlStateManager.disableDepth();
      GlStateManager.enableBlend();
      float var26 = 0.0F;
      GlStateManager.pushMatrix();
      int var27 = -52;
      int var28 = -24;
      byte var29 = 0;
      int var30 = 0;

      for(int var31 = ((Collection)var4).size(); var30 < var31; ++var30) {
         ItemStack var32 = (ItemStack)var4.get(var30);
         PyroStatic.field_2497.method_1397(var32, var27, var28, var29);
         PyroStatic.field_2497.method_1399(var32, var27, var28 * 2);
         PyroStatic.field_2497.method_1393(var32, var27, var28 - 2);
         var27 += 16;
         if (var30 % 9 == 0) {
            var27 = -52;
            var28 += 16;
         }
      }

      GlStateManager.popMatrix();
      GlStateManager.enableDepth();
      GlStateManager.disableBlend();
      GlStateManager.disablePolygonOffset();
      GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
      GlStateManager.popMatrix();
      var33.posX = var15;
      var33.posY = var17;
      var33.posZ = var19;
   }

   // $FF: renamed from: c (net.minecraft.inventory.IInventory, kotlin.jvm.functions.Function1) boolean
   public boolean method_1310(@NotNull IInventory var1, @NotNull Function1 var2) {
      int var3 = 0;

      for(int var4 = var1.getSizeInventory(); var3 < var4; ++var3) {
         if ((Boolean)var2.invoke(var1.getStackInSlot(var3))) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: 1 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_1311() {
      return this.field_869;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdF, net.minecraft.item.ItemStack) void
   public static void method_1312(fdF var0, ItemStack var1) {
      var0.field_873 = var1;
   }
}
