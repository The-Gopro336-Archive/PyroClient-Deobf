/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Sets
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.MovingSoundMinecart
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleFirework$Starter
 *  net.minecraft.crash.CrashReport
 *  net.minecraft.crash.CrashReportCategory
 *  net.minecraft.crash.ICrashReportDetail
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.network.Packet
 *  net.minecraft.profiler.Profiler
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.EnumSkyBlock
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldSettings
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.storage.ISaveHandler
 *  net.minecraft.world.storage.SaveDataMemoryStorage
 *  net.minecraft.world.storage.SaveHandlerMP
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.world.WorldEvent$Load
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package dev.nuker.pyro;

import com.google.common.collect.Sets;
import dev.nuker.pyro.Class39;
import dev.nuker.pyro.Class40;
import dev.nuker.pyro.Class42;
import dev.nuker.pyro.Class59;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFirework;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveDataMemoryStorage;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Class60
extends World {
    public NetHandlerPlayClient Field4532;
    public ChunkProviderClient Field4533;
    public Set<Entity> Field4534 = Sets.newHashSet();
    public Set<Entity> Field4535 = Sets.newHashSet();
    public Minecraft Field4536 = Minecraft.getMinecraft();
    public Set<ChunkPos> Field4537 = Sets.newHashSet();
    public int Field4538 = this.rand.nextInt(12000);
    public Set<ChunkPos> Field4539 = Sets.newHashSet();

    public Entity getEntityByID(int n) {
        return n == this.Field4536.player.getEntityId() ? this.Field4536.player : super.getEntityByID(n);
    }

    public void Method6518(int n, int n2, boolean bl) {
        if (bl) {
            this.Field4533.loadChunk(n, n2);
        } else {
            this.Field4533.unloadChunk(n, n2);
            this.markBlockRangeForRenderUpdate(n * 16, 0, n2 * 16, n * 16 + 15, 256, n2 * 16 + 15);
        }
    }

    public IChunkProvider createChunkProvider() {
        this.Field4533 = new ChunkProviderClient((World)this);
        return this.Field4533;
    }

    public boolean spawnEntity(Entity entity) {
        boolean bl = super.spawnEntity(entity);
        this.Field4534.add(entity);
        if (bl) {
            if (entity instanceof EntityMinecart) {
                this.Field4536.getSoundHandler().playSound((ISound)new MovingSoundMinecart((EntityMinecart)entity));
            }
        } else {
            this.Field4535.add(entity);
        }
        return bl;
    }

    public void playMoodSoundAndCheckLight(int n, int n2, Chunk chunk) {
        super.playMoodSoundAndCheckLight(n, n2, chunk);
        if (this.Field4538 == 0) {
            this.updateLCG = this.updateLCG * 3 + 1013904223;
            int n3 = this.updateLCG >> 2;
            int n4 = n3 & 0xF;
            int n5 = n3 >> 8 & 0xF;
            int n6 = n3 >> 16 & 0xFF;
            BlockPos blockPos = new BlockPos(n4 + n, n6, n5 + n2);
            IBlockState iBlockState = chunk.getBlockState(blockPos);
            n4 += n;
            n5 += n2;
            if (iBlockState.getMaterial() == Material.AIR && this.getLight(blockPos) <= this.rand.nextInt(8)) {
                if (this.getLightFor(EnumSkyBlock.SKY, blockPos) <= 0) {
                    double d = this.Field4536.player.getDistanceSq((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5);
                    if (this.Field4536.player != null) {
                        if (d > 4.0 && d < 256.0) {
                            this.playSound((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5, SoundEvents.AMBIENT_CAVE, SoundCategory.AMBIENT, 0.7f, 0.8f + this.rand.nextFloat() * 0.2f, false);
                            this.Field4538 = this.rand.nextInt(12000) + 6000;
                        }
                    }
                }
            }
        }
    }

    public void Method6519(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public static Minecraft Method6520(Class60 class60) {
        return class60.Field4536;
    }

    public void Method6521(int n, Entity entity) {
        Entity entity2 = this.getEntityByID(n);
        if (entity2 != null) {
            this.removeEntity(entity2);
        }
        this.Field4534.add(entity);
        entity.setEntityId(n);
        if (!this.spawnEntity(entity)) {
            this.Field4535.add(entity);
        }
        this.entitiesById.addKey(n, (Object)entity);
    }

    public Class60(NetHandlerPlayClient netHandlerPlayClient, WorldSettings worldSettings, int n, EnumDifficulty enumDifficulty, Profiler profiler) {
        super((ISaveHandler)new SaveHandlerMP(), new WorldInfo(worldSettings, "MpServer"), DimensionManager.createProviderFor((int)n), profiler, true);
        this.Field4532 = netHandlerPlayClient;
        this.getWorldInfo().setDifficulty(enumDifficulty);
        this.provider.setWorld((World)this);
        this.setSpawnPoint(new BlockPos(8, 64, 8));
        this.chunkProvider = this.createChunkProvider();
        this.mapStorage = new SaveDataMemoryStorage();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        this.initCapabilities();
        MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.Load((World)this));
    }

    public static Set Method6522(Class60 class60) {
        return class60.Field4535;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method6523(int n, int n2, int n3) {
        int n4 = 32;
        Random random = new Random();
        ItemStack itemStack = this.Field4536.player.getHeldItemMainhand();
        boolean bl = this.Field4536.playerController.getCurrentGameType() == GameType.CREATIVE && !itemStack.isEmpty() && itemStack.getItem() == Item.getItemFromBlock((Block)Blocks.BARRIER);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int n5 = 0;
        while (n5 < 667) {
            this.Method6532(n, n2, n3, 16, random, bl, mutableBlockPos);
            this.Method6532(n, n2, n3, 32, random, bl, mutableBlockPos);
            ++n5;
        }
        return;
    }

    public void tick() {
        super.tick();
        this.setTotalWorldTime(this.getTotalWorldTime() + 1L);
        if (this.getGameRules().getBoolean("doDaylightCycle")) {
            this.setWorldTime(this.getWorldTime() + 1L);
        }
        this.profiler.startSection("reEntryProcessing");
        for (int i = 0; i < 10; ++i) {
            if (this.Field4535.isEmpty()) break;
            Entity entity = this.Field4535.iterator().next();
            this.Field4535.remove((Object)entity);
            if (this.loadedEntityList.contains((Object)entity)) continue;
            this.spawnEntity(entity);
        }
        this.profiler.endStartSection("chunkCache");
        this.Field4533.tick();
        this.profiler.endStartSection("blocks");
        this.updateBlocks();
        this.profiler.endSection();
    }

    public Entity Method6524(int n) {
        Entity entity = (Entity)this.entitiesById.removeObject(n);
        if (entity != null) {
            this.Field4534.remove((Object)entity);
            this.removeEntity(entity);
        }
        return entity;
    }

    public void updateWeather() {
    }

    public ChunkProviderClient Method6525() {
        return (ChunkProviderClient)super.getChunkProvider();
    }

    public IChunkProvider getChunkProvider() {
        return this.Method6525();
    }

    public void playSound(double d, double d2, double d3, SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2, boolean bl) {
        double d4 = this.Field4536.getRenderViewEntity().getDistanceSq(d, d2, d3);
        PositionedSoundRecord positionedSoundRecord = new PositionedSoundRecord(soundEvent, soundCategory, f, f2, (float)d, (float)d2, (float)d3);
        if (bl && d4 > 100.0) {
            double d5 = Math.sqrt(d4) / 40.0;
            this.Field4536.getSoundHandler().playDelayedSound((ISound)positionedSoundRecord, (int)(d5 * 20.0));
        } else {
            this.Field4536.getSoundHandler().playSound((ISound)positionedSoundRecord);
        }
    }

    public boolean isChunkLoaded(int n, int n2, boolean bl) {
        return bl || !this.Method6525().provideChunk(n, n2).isEmpty();
    }

    public void updateBlocks() {
        this.Method6529();
        if (this.Field4538 > 0) {
            --this.Field4538;
        }
        this.Field4537.retainAll(this.Field4539);
        if (this.Field4537.size() == this.Field4539.size()) {
            this.Field4537.clear();
        }
        int n = 0;
        for (ChunkPos chunkPos : this.Field4539) {
            if (this.Field4537.contains((Object)chunkPos)) continue;
            int n2 = chunkPos.x * 16;
            int n3 = chunkPos.z * 16;
            this.profiler.startSection("getChunk");
            Chunk chunk = this.getChunkFromChunkCoords(chunkPos.x, chunkPos.z);
            this.playMoodSoundAndCheckLight(n2, n3, chunk);
            this.profiler.endSection();
            this.Field4537.add(chunkPos);
            if (++n < 10) continue;
            return;
        }
    }

    public void sendPacketToServer(Packet packet) {
        this.Field4532.sendPacket(packet);
    }

    public void sendQuittingDisconnectingPacket() {
        this.Field4532.getNetworkManager().closeChannel((ITextComponent)new TextComponentString("Quitting"));
    }

    public void Method6526(Scoreboard scoreboard) {
        this.worldScoreboard = scoreboard;
    }

    public void Method6527(BlockPos blockPos, SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2, boolean bl) {
        this.playSound((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, soundEvent, soundCategory, f, f2, bl);
    }

    public void onEntityRemoved(Entity entity) {
        super.onEntityRemoved(entity);
        if (this.Field4534.contains((Object)entity)) {
            if (entity.isEntityAlive()) {
                this.Field4535.add(entity);
            } else {
                this.Field4534.remove((Object)entity);
            }
        }
    }

    @Deprecated
    public boolean Method6528(BlockPos blockPos, IBlockState iBlockState) {
        int n = blockPos.getX();
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ();
        this.Method6519(n, n2, n3, n, n2, n3);
        return super.setBlockState(blockPos, iBlockState, 3);
    }

    public CrashReportCategory addWorldInfoToCrashReport(CrashReport crashReport) {
        CrashReportCategory crashReportCategory = super.addWorldInfoToCrashReport(crashReport);
        crashReportCategory.addDetail("Forced entities", (ICrashReportDetail)new Class42(this));
        crashReportCategory.addDetail("Retry entities", (ICrashReportDetail)new Class39(this));
        crashReportCategory.addDetail("Server brand", (ICrashReportDetail)new Class40(this));
        crashReportCategory.addDetail("Server type", (ICrashReportDetail)new Class59(this));
        return crashReportCategory;
    }

    public void Method6529() {
        this.Field4539.clear();
        int n = this.Field4536.gameSettings.renderDistanceChunks;
        this.profiler.startSection("buildList");
        int n2 = MathHelper.floor((double)(this.Field4536.player.posX / 16.0));
        int n3 = MathHelper.floor((double)(this.Field4536.player.posZ / 16.0));
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                this.Field4539.add(new ChunkPos(i + n2, j + n3));
            }
        }
        this.profiler.endSection();
    }

    public void playSound(EntityPlayer entityPlayer, double d, double d2, double d3, SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2) {
        if (entityPlayer == this.Field4536.player) {
            this.playSound(d, d2, d3, soundEvent, soundCategory, f, f2, false);
        }
    }

    public void onEntityAdded(Entity entity) {
        super.onEntityAdded(entity);
        if (this.Field4535.contains((Object)entity)) {
            this.Field4535.remove((Object)entity);
        }
    }

    public void removeEntity(Entity entity) {
        super.removeEntity(entity);
        this.Field4534.remove((Object)entity);
    }

    public void setWorldTime(long l) {
        if (l < 0L) {
            l = -l;
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        } else {
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
        }
        super.setWorldTime(l);
    }

    public static Set Method6530(Class60 class60) {
        return class60.Field4534;
    }

    public void makeFireworks(double d, double d2, double d3, double d4, double d5, double d6, NBTTagCompound nBTTagCompound) {
        this.Field4536.effectRenderer.addEffect((Particle)new ParticleFirework.Starter((World)this, d, d2, d3, d4, d5, d6, this.Field4536.effectRenderer, nBTTagCompound));
    }

    public void Method6531() {
        int n;
        Entity entity;
        int n2;
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (n2 = 0; n2 < this.unloadedEntityList.size(); ++n2) {
            entity = (Entity)this.unloadedEntityList.get(n2);
            int n3 = entity.chunkCoordX;
            n = entity.chunkCoordZ;
            if (!entity.addedToChunk || !this.isChunkLoaded(n3, n, true)) continue;
            this.getChunkFromChunkCoords(n3, n).removeEntity(entity);
        }
        for (n2 = 0; n2 < this.unloadedEntityList.size(); ++n2) {
            this.onEntityRemoved((Entity)this.unloadedEntityList.get(n2));
        }
        this.unloadedEntityList.clear();
        for (n2 = 0; n2 < this.loadedEntityList.size(); ++n2) {
            entity = (Entity)this.loadedEntityList.get(n2);
            Entity entity2 = entity.getRidingEntity();
            if (entity2 != null) {
                if (!entity2.isDead && entity2.isPassenger(entity)) continue;
                entity.dismountRidingEntity();
            }
            if (!entity.isDead) continue;
            n = entity.chunkCoordX;
            int n4 = entity.chunkCoordZ;
            if (entity.addedToChunk && this.isChunkLoaded(n, n4, true)) {
                this.getChunkFromChunkCoords(n, n4).removeEntity(entity);
            }
            this.loadedEntityList.remove(n2--);
            this.onEntityRemoved(entity);
        }
    }

    public void Method6532(int n, int n2, int n3, int n4, Random random, boolean bl, BlockPos.MutableBlockPos mutableBlockPos) {
        int n5 = n + this.rand.nextInt(n4) - this.rand.nextInt(n4);
        int n6 = n2 + this.rand.nextInt(n4) - this.rand.nextInt(n4);
        int n7 = n3 + this.rand.nextInt(n4) - this.rand.nextInt(n4);
        mutableBlockPos.setPos(n5, n6, n7);
        IBlockState iBlockState = this.getBlockState((BlockPos)mutableBlockPos);
        iBlockState.getBlock().randomDisplayTick(iBlockState, (World)this, (BlockPos)mutableBlockPos, random);
        if (bl && iBlockState.getBlock() == Blocks.BARRIER) {
            this.spawnParticle(EnumParticleTypes.BARRIER, (float)n5 + 0.5f, (float)n6 + 0.5f, (float)n7 + 0.5f, 0.0, 0.0, 0.0, new int[0]);
        }
    }
}

