/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockCommandBlock
 *  net.minecraft.block.BlockStructure
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameType
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickBlock
 *  net.minecraftforge.fml.common.eventhandler.Event$Result
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerControllerMP.class})
public abstract class PlayerControllerMPMixin {
    @Shadow
    @Final
    private Minecraft Field6226;
    @Shadow
    private GameType Field6227;
    @Shadow
    private BlockPos Field6228;
    @Shadow
    @Final
    private NetHandlerPlayClient Field6229;

    @Shadow
    private void Method9045() {
    }

    @Shadow
    public abstract float Method9046();

    @Inject(method={"attackEntity"}, at={@Class0(value="HEAD")})
    public void Method9047(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
        Pyro.Method8978().Method7918(new f4h(f41.Pre, targetEntity));
    }

    @Inject(method={"attackEntity"}, at={@Class0(value="RETURN")})
    public void Method9048(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
        Pyro.Method8978().Method7918(new f4h(f41.Post, targetEntity));
    }

    @Redirect(method={"onPlayerDestroyBlock"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/block/Block;removedByPlayer(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/player/EntityPlayer;Z)Z"))
    public boolean Method9049(Block block, IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        block.onBlockHarvested(world, pos, state, player);
        return (Boolean)PyroStatic.Field6458.Field5236.Method5264() != false && (Boolean)PyroStatic.Field6458.Field320.Method7979() != false ? false : world.setBlockState(pos, Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
    }

    @Inject(method={"getBlockReachDistance"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9050(CallbackInfoReturnable info) {
        if (((Boolean)PyroStatic.Field6479.Field5236.Method5264()).booleanValue()) {
            info.Method9034();
            float attrib = (float)this.Field6226.player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
            info.Method521(Float.valueOf((float)((Double)PyroStatic.Field6479.Method238().Method7979()).doubleValue() + (this.Field6227.isCreative() ? attrib : attrib - 0.5f)));
        }
    }

    @Inject(method={"onPlayerDamageBlock"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9051(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable info) {
        f4l event = new f4l(f41.Pre, posBlock, directionFacing);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
            info.Method521(false);
        }
    }

    @Inject(method={"onPlayerDamageBlock"}, at={@Class0(value="RETURN")})
    public void Method9052(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable info) {
        Pyro.Method8978().Method7918(new f4l(f41.Post, posBlock, directionFacing));
    }

    @Inject(method={"onStoppedUsingItem"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9053(CallbackInfo info) {
        f4q event = new f4q();
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
        }
    }

    @Inject(method={"windowClick"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9054(int windowId, int slotId, int mouseButton, ClickType type, EntityPlayer player, CallbackInfoReturnable callback) {
        f4f event = new f4f(windowId, slotId, mouseButton, type);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            callback.Method9034();
            if (event.Method5781() != slotId) {
                short short1 = player.openContainer.getNextTransactionID(player.inventory);
                ItemStack itemstack = player.openContainer.slotClick(slotId, mouseButton, type, player);
                this.Field6229.sendPacket((Packet)new CPacketClickWindow(windowId, slotId, mouseButton, type, itemstack, short1));
                callback.Method521(itemstack);
            } else {
                callback.Method521(ItemStack.EMPTY);
            }
        }
    }

    @Inject(method={"processRightClick"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method9055(EntityPlayer player, World worldIn, EnumHand hand, CallbackInfoReturnable info) {
        f4y event2 = new f4y(hand);
        Pyro.Method8978().Method7918(event2);
        if (event2.Method7947()) {
            info.Method521(EnumActionResult.FAIL);
        }
    }

    @Inject(method={"processRightClickBlock"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method9056(EntityPlayerSP player, WorldClient worldIn, BlockPos pos, EnumFacing direction, Vec3d vec, EnumHand hand, CallbackInfoReturnable info) {
        f4w event2 = new f4w(hand, pos);
        Pyro.Method8978().Method7918(event2);
        if (event2.Method7947()) {
            info.Method521(EnumActionResult.FAIL);
            return;
        }
        if (((Boolean)PyroStatic.Field6458.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6458.Field319.Method7979()).booleanValue()) {
            info.Method9034();
            this.Method9045();
            ItemStack itemstack = player.getHeldItem(hand);
            float f = (float)(vec.x - (double)pos.getX());
            float f1 = (float)(vec.y - (double)pos.getY());
            float f2 = (float)(vec.z - (double)pos.getZ());
            boolean flag = false;
            if (!this.Field6226.world.getWorldBorder().contains(pos)) {
                info.Method521(EnumActionResult.FAIL);
            } else {
                PlayerInteractEvent.RightClickBlock event = ForgeHooks.onRightClickBlock((EntityPlayer)player, (EnumHand)hand, (BlockPos)pos, (EnumFacing)direction, (Vec3d)ForgeHooks.rayTraceEyeHitVec((EntityLivingBase)player, (double)(this.Method9046() + 1.0f)));
                if (event.isCanceled()) {
                    this.Field6229.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
                    info.Method521(event.getCancellationResult());
                }
                EnumActionResult result = EnumActionResult.PASS;
                if (this.Field6227 != GameType.SPECTATOR) {
                    ItemBlock itemblock;
                    boolean bypass;
                    EnumActionResult ret = itemstack.onItemUseFirst((EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2);
                    if (ret != EnumActionResult.PASS) {
                        this.Field6229.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
                        info.Method521(ret);
                    }
                    IBlockState iblockstate = worldIn.getBlockState(pos);
                    boolean bl = bypass = player.getHeldItemMainhand().doesSneakBypassUse((IBlockAccess)worldIn, pos, (EntityPlayer)player) && player.getHeldItemOffhand().doesSneakBypassUse((IBlockAccess)worldIn, pos, (EntityPlayer)player);
                    if (!player.isSneaking() || bypass || event.getUseBlock() == Event.Result.ALLOW) {
                        if (event.getUseBlock() != Event.Result.DENY) {
                            flag = iblockstate.getBlock().onBlockActivated((World)worldIn, pos, iblockstate, (EntityPlayer)player, hand, direction, f, f1, f2);
                        }
                        if (flag) {
                            result = EnumActionResult.SUCCESS;
                        }
                    }
                    if (!flag && itemstack.getItem() instanceof ItemBlock && !(itemblock = (ItemBlock)itemstack.getItem()).canPlaceBlockOnSide((World)worldIn, pos, direction, (EntityPlayer)player, itemstack)) {
                        info.Method521(EnumActionResult.FAIL);
                    }
                }
                this.Field6229.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
                if (!flag && this.Field6227 != GameType.SPECTATOR || event.getUseItem() == Event.Result.ALLOW) {
                    if (itemstack.isEmpty()) {
                        info.Method521(EnumActionResult.PASS);
                    } else if (player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
                        info.Method521(EnumActionResult.PASS);
                    } else {
                        Block block;
                        if (itemstack.getItem() instanceof ItemBlock && !player.canUseCommandBlock() && ((block = ((ItemBlock)itemstack.getItem()).getBlock()) instanceof BlockCommandBlock || block instanceof BlockStructure)) {
                            info.Method521(EnumActionResult.FAIL);
                        }
                        if (this.Field6227.isCreative()) {
                            int i = itemstack.getMetadata();
                            int j = itemstack.getCount();
                            if (event.getUseItem() != Event.Result.DENY) {
                                EnumActionResult enumactionresult = itemstack.getItem() instanceof ItemBlock ? this.Method9057((ItemBlock)itemstack.getItem(), (EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2) : itemstack.onItemUse((EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2);
                                itemstack.setItemDamage(i);
                                itemstack.setCount(j);
                                info.Method521(enumactionresult);
                            } else {
                                info.Method521(result);
                            }
                        } else {
                            ItemStack copyForUse = itemstack.copy();
                            if (event.getUseItem() != Event.Result.DENY) {
                                EnumActionResult enumActionResult = result = itemstack.getItem() instanceof ItemBlock ? this.Method9057((ItemBlock)itemstack.getItem(), (EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2) : itemstack.onItemUse((EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2);
                            }
                            if (itemstack.isEmpty()) {
                                ForgeEventFactory.onPlayerDestroyItem((EntityPlayer)player, (ItemStack)copyForUse, (EnumHand)hand);
                            }
                            info.Method521(result);
                        }
                    }
                } else {
                    info.Method521(EnumActionResult.SUCCESS);
                }
            }
        }
    }

    public EnumActionResult Method9057(ItemBlock stack, EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack;
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        if (!block.isReplaceable((IBlockAccess)worldIn, pos)) {
            pos = pos.offset(facing);
        }
        if (!(itemstack = player.getHeldItem(hand)).isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(stack.getBlock(), pos, false, facing, (Entity)null)) {
            int i = stack.getMetadata(itemstack.getMetadata());
            IBlockState iblockstate1 = worldIn.getBlockState(pos);
            SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, (Entity)player);
            worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0f) / 2.0f, soundtype.getPitch() * 0.8f);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
}

