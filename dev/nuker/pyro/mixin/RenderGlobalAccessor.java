/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import java.util.Map;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({RenderGlobal.class})
public interface RenderGlobalAccessor {
   @Accessor("entityOutlineShader")
   ShaderGroup getEntityOutlineShader();

   @Accessor("damagedBlocks")
   Map getDamagedBlocks();
}
