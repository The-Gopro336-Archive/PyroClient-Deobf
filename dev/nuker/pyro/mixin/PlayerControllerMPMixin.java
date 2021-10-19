/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4f;
import dev.nuker.pyro.f4h;
import dev.nuker.pyro.f4l;
import dev.nuker.pyro.f4q;
import dev.nuker.pyro.f4w;
import dev.nuker.pyro.f4y;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PlayerControllerMP.class})
public abstract class PlayerControllerMPMixin {
   // $FF: renamed from: mc net.minecraft.client.Minecraft
   @Shadow
   @Final
   private Minecraft field_2465;
   @Shadow
   private GameType currentGameType;
   @Shadow
   private BlockPos currentBlock;
   @Shadow
   @Final
   private NetHandlerPlayClient connection;

   @Shadow
   private void syncCurrentPlayItem() {
   }

   @Shadow
   public abstract float getBlockReachDistance();

   @Inject(
      method = {"attackEntity"},
      at = {@At("HEAD")}
   )
   public void attackEntityPre(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
      Pyro.getEventManager().method_32(new f4h(f41.field_2120, targetEntity));
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("RETURN")}
   )
   public void attackEntityPost(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
      Pyro.getEventManager().method_32(new f4h(f41.field_2121, targetEntity));
   }

   @Redirect(
      method = {"onPlayerDestroyBlock"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/block/Block;removedByPlayer(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/player/EntityPlayer;Z)Z"
)
   )
   public boolean removedByPlayer(Block block, IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
      block.onBlockHarvested(world, pos, state, player);
      return (Boolean)PyroStatic.field_2522.c.method_3034() && (Boolean)PyroStatic.field_2522.field_861.c() ? false : world.setBlockState(pos, Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
   }

   @Inject(
      method = {"getBlockReachDistance"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getBlockReachDistance(CallbackInfoReturnable info) {
      if ((Boolean)PyroStatic.field_2543.c.method_3034()) {
         info.cancel();
         float attrib = (float)this.field_2465.player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
         info.setReturnValue((float)(Double)PyroStatic.field_2543.method_509().c() + (this.currentGameType.isCreative() ? attrib : attrib - 0.5F));
      }

   }

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onPlayerDamageBlock(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable info) {
      f4l event = new f4l(f41.field_2120, posBlock, directionFacing);
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
         info.setReturnValue(false);
      }

   }

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("RETURN")}
   )
   public void onPlayerDamageBlockPost(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable info) {
      Pyro.getEventManager().method_32(new f4l(f41.field_2121, posBlock, directionFacing));
   }

   @Inject(
      method = {"onStoppedUsingItem"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onStoppedUsingItem(CallbackInfo info) {
      f4q event = new f4q();
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"windowClick"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void windowClick(int windowId, int slotId, int mouseButton, ClickType type, EntityPlayer player, CallbackInfoReturnable callback) {
      f4f event = new f4f(windowId, slotId, mouseButton, type);
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         callback.cancel();
         if (event.method_3153() != slotId) {
            short short1 = player.openContainer.getNextTransactionID(player.inventory);
            ItemStack itemstack = player.openContainer.slotClick(slotId, mouseButton, type, player);
            this.connection.sendPacket(new CPacketClickWindow(windowId, slotId, mouseButton, type, itemstack, short1));
            callback.setReturnValue(itemstack);
         } else {
            callback.setReturnValue(ItemStack.EMPTY);
         }
      }

   }

   @Inject(
      method = {"processRightClick"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRightClick(EntityPlayer player, World worldIn, EnumHand hand, CallbackInfoReturnable info) {
      f4y event2 = new f4y(hand);
      Pyro.getEventManager().method_32(event2);
      if (event2.c()) {
         info.setReturnValue(EnumActionResult.FAIL);
      }

   }

   @Inject(
      method = {"processRightClickBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void processRightClickBlock(EntityPlayerSP player, WorldClient worldIn, BlockPos pos, EnumFacing direction, Vec3d vec, EnumHand hand, CallbackInfoReturnable info) {
      f4w event2 = new f4w(hand, pos);
      Pyro.getEventManager().method_32(event2);
      if (event2.c()) {
         info.setReturnValue(EnumActionResult.FAIL);
      } else {
         if ((Boolean)PyroStatic.field_2522.c.method_3034() && (Boolean)PyroStatic.field_2522.field_860.c()) {
            info.cancel();
            this.syncCurrentPlayItem();
            ItemStack itemstack = player.getHeldItem(hand);
            float f = (float)(vec.x - (double)pos.getX());
            float f1 = (float)(vec.y - (double)pos.getY());
            float f2 = (float)(vec.z - (double)pos.getZ());
            boolean flag = false;
            if (!this.field_2465.world.getWorldBorder().contains(pos)) {
               info.setReturnValue(EnumActionResult.FAIL);
            } else {
               RightClickBlock event = ForgeHooks.onRightClickBlock(player, hand, pos, direction, ForgeHooks.rayTraceEyeHitVec(player, (double)(this.getBlockReachDistance() + 1.0F)));
               if (event.isCanceled()) {
                  this.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
                  info.setReturnValue(event.getCancellationResult());
               }

               EnumActionResult result = EnumActionResult.PASS;
               if (this.currentGameType != GameType.SPECTATOR) {
                  EnumActionResult ret = itemstack.onItemUseFirst(player, worldIn, pos, hand, direction, f, f1, f2);
                  if (ret != EnumActionResult.PASS) {
                     this.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
                     info.setReturnValue(ret);
                  }

                  IBlockState iblockstate = worldIn.getBlockState(pos);
                  boolean bypass = player.getHeldItemMainhand().doesSneakBypassUse(worldIn, pos, player) && player.getHeldItemOffhand().doesSneakBypassUse(worldIn, pos, player);
                  if (!player.isSneaking() || bypass || event.getUseBlock() == Result.ALLOW) {
                     if (event.getUseBlock() != Result.DENY) {
                        flag = iblockstate.getBlock().onBlockActivated(worldIn, pos, iblockstate, player, hand, direction, f, f1, f2);
                     }

                     if (flag) {
                        result = EnumActionResult.SUCCESS;
                     }
                  }

                  if (!flag && itemstack.getItem() instanceof ItemBlock) {
                     ItemBlock itemblock = (ItemBlock)itemstack.getItem();
                     if (!itemblock.canPlaceBlockOnSide(worldIn, pos, direction, player, itemstack)) {
                        info.setReturnValue(EnumActionResult.FAIL);
                     }
                  }
               }

               this.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
               if ((flag || this.currentGameType == GameType.SPECTATOR) && event.getUseItem() != Result.ALLOW) {
                  info.setReturnValue(EnumActionResult.SUCCESS);
               } else if (itemstack.isEmpty()) {
                  info.setReturnValue(EnumActionResult.PASS);
               } else if (player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
                  info.setReturnValue(EnumActionResult.PASS);
               } else {
                  if (itemstack.getItem() instanceof ItemBlock && !player.canUseCommandBlock()) {
                     Block block = ((ItemBlock)itemstack.getItem()).getBlock();
                     if (block instanceof BlockCommandBlock || block instanceof BlockStructure) {
                        info.setReturnValue(EnumActionResult.FAIL);
                     }
                  }

                  if (this.currentGameType.isCreative()) {
                     int i = itemstack.getMetadata();
                     int j = itemstack.getCount();
                     if (event.getUseItem() != Result.DENY) {
                        EnumActionResult enumactionresult = itemstack.getItem() instanceof ItemBlock ? this.onItemUse((ItemBlock)itemstack.getItem(), player, worldIn, pos, hand, direction, f, f1, f2) : itemstack.onItemUse(player, worldIn, pos, hand, direction, f, f1, f2);
                        itemstack.setItemDamage(i);
                        itemstack.setCount(j);
                        info.setReturnValue(enumactionresult);
                     } else {
                        info.setReturnValue(result);
                     }
                  } else {
                     ItemStack copyForUse = itemstack.copy();
                     if (event.getUseItem() != Result.DENY) {
                        result = itemstack.getItem() instanceof ItemBlock ? this.onItemUse((ItemBlock)itemstack.getItem(), player, worldIn, pos, hand, direction, f, f1, f2) : itemstack.onItemUse(player, worldIn, pos, hand, direction, f, f1, f2);
                     }

                     if (itemstack.isEmpty()) {
                        ForgeEventFactory.onPlayerDestroyItem(player, copyForUse, hand);
                     }

                     info.setReturnValue(result);
                  }
               }
            }
         }

      }
   }

   public EnumActionResult onItemUse(ItemBlock stack, EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
      IBlockState iblockstate = worldIn.getBlockState(pos);
      Block block = iblockstate.getBlock();
      if (!block.isReplaceable(worldIn, pos)) {
         pos = pos.offset(facing);
      }

      ItemStack itemstack = player.getHeldItem(hand);
      if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(stack.getBlock(), pos, false, facing, (Entity)null)) {
         stack.getMetadata(itemstack.getMetadata());
         IBlockState iblockstate1 = worldIn.getBlockState(pos);
         SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, player);
         worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
         return EnumActionResult.SUCCESS;
      } else {
         return EnumActionResult.FAIL;
      }
   }
}
