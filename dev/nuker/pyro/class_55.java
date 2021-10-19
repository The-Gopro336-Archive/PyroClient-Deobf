/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.ParticleFirework.Starter;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
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
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.SaveDataMemoryStorage;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent.Load;

// $FF: renamed from: dev.nuker.pyro.fv
public class class_55 extends World {
   // $FF: renamed from: c net.minecraft.client.network.NetHandlerPlayClient
   public NetHandlerPlayClient field_2700;
   // $FF: renamed from: c net.minecraft.client.multiplayer.ChunkProviderClient
   public ChunkProviderClient field_2701;
   // $FF: renamed from: c java.util.Set
   public Set field_2702 = Sets.newHashSet();
   // $FF: renamed from: 0 java.util.Set
   public Set field_2703 = Sets.newHashSet();
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_2704 = Minecraft.getMinecraft();
   // $FF: renamed from: 1 java.util.Set
   public Set field_2705 = Sets.newHashSet();
   // $FF: renamed from: c int
   public int field_2706;
   // $FF: renamed from: 2 java.util.Set
   public Set field_2707;

   public Entity getEntityByID(int var1) {
      return (Entity)(var1 == this.field_2704.player.getEntityId() ? this.field_2704.player : super.getEntityByID(var1));
   }

   // $FF: renamed from: c (int, int, boolean) void
   public void method_4065(int var1, int var2, boolean var3) {
      if (var3) {
         this.field_2701.loadChunk(var1, var2);
      } else {
         this.field_2701.unloadChunk(var1, var2);
         this.markBlockRangeForRenderUpdate(var1 * 16, 0, var2 * 16, var1 * 16 + 15, 256, var2 * 16 + 15);
      }

   }

   public IChunkProvider createChunkProvider() {
      this.field_2701 = new ChunkProviderClient(this);
      return this.field_2701;
   }

   public boolean spawnEntity(Entity var1) {
      boolean var2 = super.spawnEntity(var1);
      this.field_2702.add(var1);
      if (var2) {
         if (var1 instanceof EntityMinecart) {
            this.field_2704.getSoundHandler().playSound(new MovingSoundMinecart((EntityMinecart)var1));
         }
      } else {
         this.field_2703.add(var1);
      }

      return var2;
   }

   public void playMoodSoundAndCheckLight(int var1, int var2, Chunk var3) {
      super.playMoodSoundAndCheckLight(var1, var2, var3);
      if (this.field_2706 == 0) {
         this.updateLCG = this.updateLCG * 3 + 1013904223;
         int var4 = this.updateLCG >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 255;
         BlockPos var8 = new BlockPos(var5 + var1, var7, var6 + var2);
         IBlockState var9 = var3.getBlockState(var8);
         var5 += var1;
         var6 += var2;
         if (var9.getMaterial() == Material.AIR && this.getLight(var8) <= this.rand.nextInt(8) && this.getLightFor(EnumSkyBlock.SKY, var8) <= 0) {
            double var10 = this.field_2704.player.getDistanceSq((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D);
            if (this.field_2704.player != null && var10 > 4.0D && var10 < 256.0D) {
               this.playSound((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, SoundEvents.AMBIENT_CAVE, SoundCategory.AMBIENT, 0.7F, 0.8F + this.rand.nextFloat() * 0.2F, false);
               this.field_2706 = this.rand.nextInt(12000) + 6000;
            }
         }
      }

   }

   // $FF: renamed from: c (int, int, int, int, int, int) void
   public void method_4066(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fv) net.minecraft.client.Minecraft
   public static Minecraft method_4067(class_55 var0) {
      return var0.field_2704;
   }

   // $FF: renamed from: c (int, net.minecraft.entity.Entity) void
   public void method_4068(int var1, Entity var2) {
      Entity var3 = this.getEntityByID(var1);
      if (var3 != null) {
         this.removeEntity(var3);
      }

      this.field_2702.add(var2);
      var2.setEntityId(var1);
      if (!this.spawnEntity(var2)) {
         this.field_2703.add(var2);
      }

      this.entitiesById.addKey(var1, var2);
   }

   public class_55(NetHandlerPlayClient var1, WorldSettings var2, int var3, EnumDifficulty var4, Profiler var5) {
      super(new SaveHandlerMP(), new WorldInfo(var2, "MpServer"), DimensionManager.createProviderFor(var3), var5, true);
      this.field_2706 = this.rand.nextInt(12000);
      this.field_2707 = Sets.newHashSet();
      this.field_2700 = var1;
      this.getWorldInfo().setDifficulty(var4);
      this.provider.setWorld(this);
      this.setSpawnPoint(new BlockPos(8, 64, 8));
      this.chunkProvider = this.createChunkProvider();
      this.mapStorage = new SaveDataMemoryStorage();
      this.calculateInitialSkylight();
      this.calculateInitialWeather();
      this.initCapabilities();
      MinecraftForge.EVENT_BUS.post(new Load(this));
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fv) java.util.Set
   public static Set method_4069(class_55 var0) {
      return var0.field_2703;
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_4070(int var1, int var2, int var3) {
      boolean var4 = true;
      Random var5 = new Random();
      ItemStack var6 = this.field_2704.player.getHeldItemMainhand();
      boolean var7 = this.field_2704.playerController.getCurrentGameType() == GameType.CREATIVE && !var6.isEmpty() && var6.getItem() == Item.getItemFromBlock(Blocks.BARRIER);
      MutableBlockPos var8 = new MutableBlockPos();

      for(int var9 = 0; var9 < 667; ++var9) {
         this.method_4079(var1, var2, var3, 16, var5, var7, var8);
         this.method_4079(var1, var2, var3, 32, var5, var7, var8);
      }

   }

   public void tick() {
      super.tick();
      this.setTotalWorldTime(this.getTotalWorldTime() + 1L);
      if (this.getGameRules().getBoolean("doDaylightCycle")) {
         this.setWorldTime(this.getWorldTime() + 1L);
      }

      this.profiler.startSection("reEntryProcessing");

      for(int var1 = 0; var1 < 10 && !this.field_2703.isEmpty(); ++var1) {
         Entity var2 = (Entity)this.field_2703.iterator().next();
         this.field_2703.remove(var2);
         if (!this.loadedEntityList.contains(var2)) {
            this.spawnEntity(var2);
         }
      }

      this.profiler.endStartSection("chunkCache");
      this.field_2701.tick();
      this.profiler.endStartSection("blocks");
      this.updateBlocks();
      this.profiler.endSection();
   }

   // $FF: renamed from: c (int) net.minecraft.entity.Entity
   public Entity method_4071(int var1) {
      Entity var2 = (Entity)this.entitiesById.removeObject(var1);
      if (var2 != null) {
         this.field_2702.remove(var2);
         this.removeEntity(var2);
      }

      return var2;
   }

   public void updateWeather() {
   }

   // $FF: renamed from: c () net.minecraft.client.multiplayer.ChunkProviderClient
   public ChunkProviderClient method_4072() {
      return (ChunkProviderClient)super.getChunkProvider();
   }

   public IChunkProvider getChunkProvider() {
      return this.method_4072();
   }

   public void playSound(double var1, double var3, double var5, SoundEvent var7, SoundCategory var8, float var9, float var10, boolean var11) {
      double var12 = this.field_2704.getRenderViewEntity().getDistanceSq(var1, var3, var5);
      PositionedSoundRecord var14 = new PositionedSoundRecord(var7, var8, var9, var10, (float)var1, (float)var3, (float)var5);
      if (var11 && var12 > 100.0D) {
         double var15 = Math.sqrt(var12) / 40.0D;
         this.field_2704.getSoundHandler().playDelayedSound(var14, (int)(var15 * 20.0D));
      } else {
         this.field_2704.getSoundHandler().playSound(var14);
      }

   }

   public boolean isChunkLoaded(int var1, int var2, boolean var3) {
      return var3 || !this.method_4072().provideChunk(var1, var2).isEmpty();
   }

   public void updateBlocks() {
      this.method_4076();
      if (this.field_2706 > 0) {
         --this.field_2706;
      }

      this.field_2705.retainAll(this.field_2707);
      if (this.field_2705.size() == this.field_2707.size()) {
         this.field_2705.clear();
      }

      int var1 = 0;
      Iterator var2 = this.field_2707.iterator();

      while(var2.hasNext()) {
         ChunkPos var3 = (ChunkPos)var2.next();
         if (!this.field_2705.contains(var3)) {
            int var4 = var3.x * 16;
            int var5 = var3.z * 16;
            this.profiler.startSection("getChunk");
            Chunk var6 = this.getChunkFromChunkCoords(var3.x, var3.z);
            this.playMoodSoundAndCheckLight(var4, var5, var6);
            this.profiler.endSection();
            this.field_2705.add(var3);
            ++var1;
            if (var1 >= 10) {
               return;
            }
         }
      }

   }

   public void sendPacketToServer(Packet var1) {
      this.field_2700.sendPacket(var1);
   }

   public void sendQuittingDisconnectingPacket() {
      this.field_2700.getNetworkManager().closeChannel(new TextComponentString("Quitting"));
   }

   // $FF: renamed from: c (net.minecraft.scoreboard.Scoreboard) void
   public void method_4073(Scoreboard var1) {
      this.worldScoreboard = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.util.SoundEvent, net.minecraft.util.SoundCategory, float, float, boolean) void
   public void method_4074(BlockPos var1, SoundEvent var2, SoundCategory var3, float var4, float var5, boolean var6) {
      this.playSound((double)var1.getX() + 0.5D, (double)var1.getY() + 0.5D, (double)var1.getZ() + 0.5D, var2, var3, var4, var5, var6);
   }

   public void onEntityRemoved(Entity var1) {
      super.onEntityRemoved(var1);
      if (this.field_2702.contains(var1)) {
         if (var1.isEntityAlive()) {
            this.field_2703.add(var1);
         } else {
            this.field_2702.remove(var1);
         }
      }

   }

   /** @deprecated */
   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState) boolean
   @Deprecated
   public boolean method_4075(BlockPos var1, IBlockState var2) {
      int var3 = var1.getX();
      int var4 = var1.getY();
      int var5 = var1.getZ();
      this.method_4066(var3, var4, var5, var3, var4, var5);
      return super.setBlockState(var1, var2, 3);
   }

   public CrashReportCategory addWorldInfoToCrashReport(CrashReport var1) {
      CrashReportCategory var2 = super.addWorldInfoToCrashReport(var1);
      var2.addDetail("Forced entities", new class_45(this));
      var2.addDetail("Retry entities", new class_42(this));
      var2.addDetail("Server brand", new class_43(this));
      var2.addDetail("Server type", new class_60(this));
      return var2;
   }

   // $FF: renamed from: 0 () void
   public void method_4076() {
      this.field_2707.clear();
      int var1 = this.field_2704.gameSettings.renderDistanceChunks;
      this.profiler.startSection("buildList");
      int var2 = MathHelper.floor(this.field_2704.player.posX / 16.0D);
      int var3 = MathHelper.floor(this.field_2704.player.posZ / 16.0D);

      for(int var4 = -var1; var4 <= var1; ++var4) {
         for(int var5 = -var1; var5 <= var1; ++var5) {
            this.field_2707.add(new ChunkPos(var4 + var2, var5 + var3));
         }
      }

      this.profiler.endSection();
   }

   public void playSound(EntityPlayer var1, double var2, double var4, double var6, SoundEvent var8, SoundCategory var9, float var10, float var11) {
      if (var1 == this.field_2704.player) {
         this.playSound(var2, var4, var6, var8, var9, var10, var11, false);
      }

   }

   public void onEntityAdded(Entity var1) {
      super.onEntityAdded(var1);
      if (this.field_2703.contains(var1)) {
         this.field_2703.remove(var1);
      }

   }

   public void removeEntity(Entity var1) {
      super.removeEntity(var1);
      this.field_2702.remove(var1);
   }

   public void setWorldTime(long var1) {
      if (var1 < 0L) {
         var1 = -var1;
         this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
      } else {
         this.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
      }

      super.setWorldTime(var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.fv) java.util.Set
   public static Set method_4077(class_55 var0) {
      return var0.field_2702;
   }

   public void makeFireworks(double var1, double var3, double var5, double var7, double var9, double var11, NBTTagCompound var13) {
      this.field_2704.effectRenderer.addEffect(new Starter(this, var1, var3, var5, var7, var9, var11, this.field_2704.effectRenderer, var13));
   }

   // $FF: renamed from: 1 () void
   public void method_4078() {
      this.loadedEntityList.removeAll(this.unloadedEntityList);

      int var1;
      Entity var2;
      int var4;
      for(var1 = 0; var1 < this.unloadedEntityList.size(); ++var1) {
         var2 = (Entity)this.unloadedEntityList.get(var1);
         int var3 = var2.chunkCoordX;
         var4 = var2.chunkCoordZ;
         if (var2.addedToChunk && this.isChunkLoaded(var3, var4, true)) {
            this.getChunkFromChunkCoords(var3, var4).removeEntity(var2);
         }
      }

      for(var1 = 0; var1 < this.unloadedEntityList.size(); ++var1) {
         this.onEntityRemoved((Entity)this.unloadedEntityList.get(var1));
      }

      this.unloadedEntityList.clear();

      for(var1 = 0; var1 < this.loadedEntityList.size(); ++var1) {
         var2 = (Entity)this.loadedEntityList.get(var1);
         Entity var6 = var2.getRidingEntity();
         if (var6 != null) {
            if (!var6.isDead && var6.isPassenger(var2)) {
               continue;
            }

            var2.dismountRidingEntity();
         }

         if (var2.isDead) {
            var4 = var2.chunkCoordX;
            int var5 = var2.chunkCoordZ;
            if (var2.addedToChunk && this.isChunkLoaded(var4, var5, true)) {
               this.getChunkFromChunkCoords(var4, var5).removeEntity(var2);
            }

            this.loadedEntityList.remove(var1--);
            this.onEntityRemoved(var2);
         }
      }

   }

   // $FF: renamed from: c (int, int, int, int, java.util.Random, boolean, net.minecraft.util.math.BlockPos.MutableBlockPos) void
   public void method_4079(int var1, int var2, int var3, int var4, Random var5, boolean var6, MutableBlockPos var7) {
      int var8 = var1 + this.rand.nextInt(var4) - this.rand.nextInt(var4);
      int var9 = var2 + this.rand.nextInt(var4) - this.rand.nextInt(var4);
      int var10 = var3 + this.rand.nextInt(var4) - this.rand.nextInt(var4);
      var7.setPos(var8, var9, var10);
      IBlockState var11 = this.getBlockState(var7);
      var11.getBlock().randomDisplayTick(var11, this, var7, var5);
      if (var6 && var11.getBlock() == Blocks.BARRIER) {
         this.spawnParticle(EnumParticleTypes.BARRIER, (double)((float)var8 + 0.5F), (double)((float)var9 + 0.5F), (double)((float)var10 + 0.5F), 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }
}
