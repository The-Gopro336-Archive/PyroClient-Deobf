/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Ldev/nuker/pyro/WaypointManager;", "", "()V", "folder", "Ljava/io/File;", "waypoints", "", "Ldev/nuker/pyro/Waypoint;", "getWaypoints", "()Ljava/util/Collection;", "waypointsMap", "", "", "deleteWaypoint", "", "waypoint", "findNextEmpty", "name", "getExistingFilename", "getFile", "load", "saveWaypoint", "pyroclient"}
)
public final class WaypointManager {
   private static File folder;
   private static Map waypointsMap;
   public static final WaypointManager INSTANCE;

   @NotNull
   public final Collection getWaypoints() {
      return waypointsMap.values();
   }

   public final void load(@NotNull String folder) {
      Intrinsics.checkParameterIsNotNull(folder, "folder");
      WaypointManager.folder = new File("pyro/server/" + folder + "/waypoints/");
      File var10000 = WaypointManager.folder;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("folder");
      }

      var10000.mkdirs();
      waypointsMap.clear();
      var10000 = WaypointManager.folder;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("folder");
      }

      File[] var15 = var10000.listFiles();
      Intrinsics.checkExpressionValueIsNotNull(var15, "this.folder.listFiles()");
      Object[] $this$forEach$iv = var15;
      int $i$f$forEach = false;
      File[] var4 = $this$forEach$iv;
      int var5 = $this$forEach$iv.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object element$iv = var4[var6];
         int var9 = false;
         FileReader var10 = new FileReader(element$iv);
         boolean var11 = false;
         boolean var12 = false;
         int var14 = false;
         Map var16 = waypointsMap;
         Intrinsics.checkExpressionValueIsNotNull(element$iv, "file");
         String var10001 = element$iv.getName();
         Intrinsics.checkExpressionValueIsNotNull(var10001, "file.name");
         Object var10002 = Pyro.GSON.fromJson((Reader)var10, Waypoint.class);
         Intrinsics.checkExpressionValueIsNotNull(var10002, "Pyro.GSON.fromJson(it, Waypoint::class.java)");
         var16.put(var10001, var10002);
         var10.close();
      }

   }

   public final void deleteWaypoint(@NotNull Waypoint waypoint) {
      Intrinsics.checkParameterIsNotNull(waypoint, "waypoint");
      if (waypointsMap.containsValue(waypoint)) {
         String filename = this.getExistingFilename(waypoint);
         if (filename != null) {
            waypointsMap.remove(filename);
            (new File(this.getFile(filename))).delete();
         }
      }

   }

   public final void saveWaypoint(@NotNull Waypoint waypoint) {
      Intrinsics.checkParameterIsNotNull(waypoint, "waypoint");
      String var10000;
      if (waypointsMap.containsValue(waypoint)) {
         var10000 = this.getExistingFilename(waypoint);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }
      } else {
         var10000 = this.findNextEmpty(waypoint.getName());
      }

      String name = var10000;
      if (!waypointsMap.containsValue(waypoint)) {
         waypointsMap.put(name, waypoint);
      }

      FileWriter var3 = new FileWriter(this.getFile(name));
      boolean var4 = false;
      boolean var5 = false;
      int var7 = false;
      Pyro.GSON.toJson(waypoint, (Appendable)var3);
      var3.close();
   }

   private final String getFile(String name) {
      StringBuilder var10000 = new StringBuilder();
      File var10001 = folder;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("folder");
      }

      return var10000.append(var10001).append('/').append(name).append(".json").toString();
   }

   private final String getExistingFilename(Waypoint waypoint) {
      Iterable $this$firstOrNull$iv = (Iterable)waypointsMap.entrySet();
      int $i$f$firstOrNull = false;
      Iterator var4 = $this$firstOrNull$iv.iterator();

      Object var10000;
      while(true) {
         if (var4.hasNext()) {
            Object element$iv = var4.next();
            Entry it = (Entry)element$iv;
            int var7 = false;
            if (!Intrinsics.areEqual((Object)((Waypoint)it.getValue()), (Object)waypoint)) {
               continue;
            }

            var10000 = element$iv;
            break;
         }

         var10000 = null;
         break;
      }

      Object var8 = var10000;
      $i$f$firstOrNull = false;
      boolean var9 = false;
      Entry it = (Entry)var8;
      int var11 = false;
      return it != null ? (String)it.getKey() : null;
   }

   @NotNull
   public final String findNextEmpty(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      String var10000;
      if ((new File(name)).exists()) {
         int num;
         for(num = 0; (new File(name + '_' + num)).exists(); ++num) {
         }

         var10000 = name + '_' + num;
      } else {
         var10000 = name;
      }

      return var10000;
   }

   private WaypointManager() {
   }

   static {
      WaypointManager var0 = new WaypointManager();
      INSTANCE = var0;
      boolean var1 = false;
      waypointsMap = (Map)(new LinkedHashMap());
   }
}
