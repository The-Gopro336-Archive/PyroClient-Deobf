/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.GuiChestAccessor;
import dev.nuker.pyro.mixin.InventoryBasicAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;

public class fbF extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_711 = new BooleanSetting("shulkers", "Shulkers", (String)null, true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_712 = new BooleanSetting("maps", "Maps", (String)null, true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_713 = new BooleanSetting("enderChests", "EnderChests", (String)null, true);
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_714 = new BooleanSetting("echestBackPack", "EChestBackPack", (String)null, false);
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_715 = new BooleanSetting("3dshulkers", "3DShulkers", (String)null, false);
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_716 = new DoubleSetting("scaling", "Scaling", "Allows you to scale the size of the nametags", 3.0D, 1.0D, 10.0D);
   // $FF: renamed from: c net.minecraft.util.NonNullList
   public NonNullList field_717;
   // $FF: renamed from: c java.util.List
   public List field_718 = new CopyOnWriteArrayList();
   // $FF: renamed from: c net.minecraft.util.ResourceLocation
   public static ResourceLocation field_719 = new ResourceLocation("textures/map/map_background.png");

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      if ((Boolean)this.field_715.c()) {
         Iterator var3 = this.field_718.iterator();

         while(true) {
            EntityItem var4;
            NBTTagCompound var7;
            do {
               NBTTagCompound var6;
               do {
                  do {
                     if (!var3.hasNext()) {
                        GlStateManager.enableBlend();
                        return;
                     }

                     var4 = (EntityItem)var3.next();
                     ItemStack var5 = var4.getItem();
                     var6 = var5.getTagCompound();
                  } while(var6 == null);
               } while(!var6.hasKey("BlockEntityTag", 10));

               var7 = var6.getCompoundTag("BlockEntityTag");
            } while(!var7.hasKey("Items", 9));

            NonNullList var8 = NonNullList.withSize(27, ItemStack.EMPTY);
            ItemStackHelper.loadAllItems(var7, var8);
            Entity var9 = this.c.getRenderViewEntity();
            Vec3d var10 = fdY.method_1816(var4, var2);
            double var11 = var10.x;
            double var13 = var10.y + 0.65D;
            double var15 = var10.z;
            double var17 = var13 + 0.07999999821186066D;
            var10 = fdY.method_1816(var9, var2);
            double var19 = var9.posX;
            double var21 = var9.posY;
            double var23 = var9.posZ;
            var9.posX = var10.x;
            var9.posY = var10.y;
            var9.posZ = var10.z;
            var13 = var9.getDistance(var11, var13, var15);
            double var25 = 0.04D;
            if (var13 > 0.0D) {
               var25 = 0.02D + (Double)this.field_716.c() / 1000.0D * var13;
            }

            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
            GlStateManager.disableLighting();
            GlStateManager.translate((float)var11, (float)var17 + 1.4F, (float)var15);
            float var27 = -this.c.getRenderManager().playerViewY;
            float var28 = 1.0F;
            float var29 = 0.0F;
            GlStateManager.rotate(var27, 0.0F, 1.0F, 0.0F);
            float var10001 = this.c.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F;
            GlStateManager.rotate(this.c.getRenderManager().playerViewX, var10001, 0.0F, 0.0F);
            GlStateManager.scale(-var25, -var25, var25);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            float var30 = 0.0F;
            GlStateManager.pushMatrix();
            int var31 = -72;
            int var32 = -16;
            byte var33 = 0;

            for(int var34 = 0; var34 < var8.size(); ++var34) {
               ItemStack var35 = (ItemStack)var8.get(var34);
               PyroStatic.field_2497.method_1397(var35, var31, var32, var33);
               PyroStatic.field_2497.method_1399(var35, var31, var32 * 2);
               PyroStatic.field_2497.method_1393(var35, var31, var32 - 2);
               var31 += 16;
               if (var34 == 8 || var34 == 17) {
                  var31 = -72;
                  var32 += 16;
               }
            }

            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
            GlStateManager.disableBlend();
            GlStateManager.disablePolygonOffset();
            GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
            GlStateManager.popMatrix();
            var9.posX = var19;
            var9.posY = var21;
            var9.posZ = var23;
         }
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4F) void
   @f0g
   @LauncherEventHide
   public void method_1057(f4F var1) {
      if (!var1.method_3161().isEmpty()) {
         int var4;
         if (var1.method_3161().getItem() instanceof ItemMap && (Boolean)this.field_712.c()) {
            MapData var16 = ((ItemMap)var1.method_3161().getItem()).getMapData(var1.method_3161(), this.c.world);
            if (var16 != null) {
               GlStateManager.pushMatrix();
               GlStateManager.color(1.0F, 1.0F, 1.0F);
               int var13 = var1.method_3164() + 6;
               var4 = var1.method_3159() + 6;
               GlStateManager.translate((double)var13, (double)var4, 0.0D);
               GlStateManager.disableDepth();
               var1.0();
               PyroRenderUtil.meth0(0.0F, -12.0F, 128.0F, 0.0F, -15987700);
               class_59.field_2713.method_4135().drawCenteredString(var1.method_3161().getDisplayName() + " " + var1.method_3161().getMetadata(), 64.0F, -10.0F, -1, true);
               this.c.entityRenderer.getMapItemRenderer().renderMap(var16, false);
               GlStateManager.enableDepth();
               GlStateManager.popMatrix();
            }
         } else {
            int var20;
            ItemStack var21;
            if (var1.method_3161().getItem() instanceof ItemShulkerBox && (Boolean)this.field_711.c()) {
               ItemStack var15 = var1.method_3161();
               NBTTagCompound var11 = var15.getTagCompound();
               if (var11 != null && var11.hasKey("BlockEntityTag", 10)) {
                  NBTTagCompound var14 = var11.getCompoundTag("BlockEntityTag");
                  if (var14.hasKey("Items", 9)) {
                     var1.0();
                     NonNullList var19 = NonNullList.withSize(27, ItemStack.EMPTY);
                     ItemStackHelper.loadAllItems(var14, var19);
                     GlStateManager.pushMatrix();
                     GlStateManager.translate((float)(var1.method_3164() + 10), (float)(var1.method_3159() + 10), 0.0F);
                     GlStateManager.disableLighting();
                     GlStateManager.disableDepth();
                     PyroRenderUtil.meth0(0.0F, -12.0F, 144.0F, 0.0F, -15987700);
                     PyroRenderUtil.meth0(0.0F, 0.0F, 144.0F, 48.0F, -938734580);
                     PyroRenderUtil.method_1428(0.0F, 0.0F, 144.0F, 48.0F, 1.0F, 1610547455);

                     for(var20 = 0; var20 < 2; ++var20) {
                        PyroRenderUtil.meth0(0.0F, (float)(16 * var20 + 16), 144.0F, (float)(16 * var20 + 16), 1.0F, 1610547455);
                     }

                     for(var20 = 0; var20 < 8; ++var20) {
                        PyroRenderUtil.meth0((float)(16 * var20 + 16), 0.0F, (float)(16 * var20 + 16), 48.0F, 1.0F, 1610547455);
                     }

                     class_59.field_2713.method_4135().drawCenteredString(var1.method_3161().getDisplayName(), 72.0F, -10.0F, -1, true);
                     GlStateManager.enableDepth();
                     this.c.getRenderItem().zLevel = 150.0F;
                     RenderHelper.enableGUIStandardItemLighting();

                     for(var20 = 0; var20 < var19.size(); ++var20) {
                        var21 = (ItemStack)var19.get(var20);
                        int var23 = var20 % 9 * 16;
                        int var9 = var20 / 9 * 16;
                        this.c.getRenderItem().renderItemAndEffectIntoGUI(var21, var23, var9);
                        this.c.getRenderItem().renderItemOverlayIntoGUI(this.c.fontRenderer, var21, var23, var9, (String)null);
                     }

                     RenderHelper.disableStandardItemLighting();
                     this.c.getRenderItem().zLevel = 0.0F;
                     GlStateManager.enableLighting();
                     GlStateManager.popMatrix();
                     if (Mouse.isButtonDown(2)) {
                        InventoryBasic var25 = new InventoryBasic(var1.method_3161().getDisplayName(), true, 27);

                        for(int var22 = 0; var22 < var19.size(); ++var22) {
                           ItemStack var24 = (ItemStack)var19.get(var22);
                           if (var24 != null) {
                              var25.addItem(var24);
                           }
                        }

                        this.c.displayGuiScreen(new GuiChest(this.c.player.inventory, var25));
                     }
                  }
               }
            } else if (ItemShulkerBox.getIdFromItem(var1.method_3161().getItem()) == 130 && (Boolean)this.field_713.c() && this.field_717 != null) {
               var1.0();
               GlStateManager.pushMatrix();
               GlStateManager.translate((float)(var1.method_3164() + 10), (float)(var1.method_3159() + 10), 0.0F);
               GlStateManager.disableLighting();
               GlStateManager.disableDepth();
               PyroRenderUtil.meth0(0.0F, -12.0F, 144.0F, 0.0F, -15987700);
               PyroRenderUtil.meth0(0.0F, 0.0F, 144.0F, 48.0F, -938734580);
               PyroRenderUtil.method_1428(0.0F, 0.0F, 144.0F, 48.0F, 1.0F, 1610547455);

               int var2;
               for(var2 = 0; var2 < 2; ++var2) {
                  PyroRenderUtil.meth0(0.0F, (float)(16 * var2 + 16), 144.0F, (float)(16 * var2 + 16), 1.0F, 1610547455);
               }

               for(var2 = 0; var2 < 8; ++var2) {
                  PyroRenderUtil.meth0((float)(16 * var2 + 16), 0.0F, (float)(16 * var2 + 16), 48.0F, 1.0F, 1610547455);
               }

               class_59.field_2713.method_4135().drawCenteredString(var1.method_3161().getDisplayName(), 72.0F, -10.0F, -1, true);
               GlStateManager.enableDepth();
               this.c.getRenderItem().zLevel = 150.0F;
               RenderHelper.enableGUIStandardItemLighting();

               for(var2 = 0; var2 < this.field_717.size(); ++var2) {
                  ItemStack var3 = (ItemStack)this.field_717.get(var2);
                  var4 = var2 % 9 * 16;
                  int var5 = var2 / 9 * 16;
                  this.c.getRenderItem().renderItemAndEffectIntoGUI(var3, var4, var5);
                  this.c.getRenderItem().renderItemOverlayIntoGUI(this.c.fontRenderer, var3, var4, var5, (String)null);
               }

               RenderHelper.disableStandardItemLighting();
               this.c.getRenderItem().zLevel = 0.0F;
               GlStateManager.enableLighting();
               GlStateManager.popMatrix();
               if (Mouse.isButtonDown(2)) {
                  TileEntityEnderChest var12 = null;
                  double var10 = 100.0D;
                  Iterator var17 = this.c.world.loadedTileEntityList.iterator();

                  while(var17.hasNext()) {
                     TileEntity var6 = (TileEntity)var17.next();
                     if (var6 instanceof TileEntityEnderChest) {
                        BlockPos var7 = var6.getPos();
                        double var8 = this.c.player.getDistanceSq((double)var7.getX() + 0.5D, (double)var7.getY() + 0.5D, (double)var7.getZ() + 0.5D);
                        if (!(var8 >= 64.0D) && var8 < var10) {
                           var10 = var8;
                           var12 = (TileEntityEnderChest)var6;
                        }
                     }
                  }

                  if (var12 != null && (Boolean)this.field_714.c()) {
                     Pyro.INSTANCE.sendMessage("You can edit this enderchest");
                     this.c.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(var12.getPos(), EnumFacing.UP, EnumHand.MAIN_HAND, 0.0F, 0.0F, 0.0F));
                  } else {
                     InventoryBasic var18 = new InventoryBasic(var1.method_3161().getDisplayName() + " <NOT EDITABLE>", true, 27);

                     for(var20 = 0; var20 < this.field_717.size(); ++var20) {
                        var21 = (ItemStack)this.field_717.get(var20);
                        if (var21 != null) {
                           var18.addItem(var21);
                        }
                     }

                     this.c.displayGuiScreen(new GuiChest(this.c.player.inventory, var18));
                  }
               }
            }
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4f) void
   @f0g
   @LauncherEventHide
   public void method_1058(f4f var1) {
      if (var1.c() == f41.field_2120 && this.c.player.openContainer != null && var1.method_3151() == 0 && this.c.currentScreen instanceof GuiChest) {
         GuiChest var2 = (GuiChest)this.c.currentScreen;
         IInventory var3 = ((GuiChestAccessor)var2).getLowerChestInventory();
         if (var3 instanceof InventoryBasic) {
            InventoryBasic var4 = (InventoryBasic)var3;
            if (var4.getName().contains("<NOT EDITABLE>")) {
               if (var1.method_3153() <= 26) {
                  Pyro.INSTANCE.sendMessage("You can not edit an enderchest preview");
                  var1.0();
               } else {
                  var1.method_3155(var1.method_3153() - 18);
               }
            }
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1059(f4t var1) {
      this.field_718.clear();
      if ((Boolean)this.field_715.c()) {
         Iterator var2 = this.c.world.loadedEntityList.iterator();

         while(var2.hasNext()) {
            Entity var3 = (Entity)var2.next();
            if (var3 instanceof EntityItem && ((EntityItem)var3).getItem().getItem() instanceof ItemShulkerBox) {
               this.field_718.add((EntityItem)var3);
            }
         }
      }

      if (this.c.currentScreen instanceof GuiChest) {
         GuiChest var5 = (GuiChest)this.c.currentScreen;
         IInventory var6 = ((GuiChestAccessor)var5).getLowerChestInventory();
         if (var6 instanceof InventoryBasic) {
            InventoryBasic var4 = (InventoryBasic)var6;
            if (var4.getName().equals("Ender Chest")) {
               this.field_717 = ((InventoryBasicAccessor)var4).getInventoryContents();
            }
         }
      }

   }

   public fbF() {
      super("tooltips", "Tooltips", (String)null);
      this.register(this.field_711);
      this.register(this.field_712);
      this.register(this.field_713);
      this.register(this.field_714);
      this.register(this.field_715);
      this.register(this.field_716);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_718.clear();
   }
}
