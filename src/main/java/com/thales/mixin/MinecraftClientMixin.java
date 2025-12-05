package com.thales.mixin;

import com.thales.integration.ThalesFabricMod;
import com.thales.event.events.TickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin to hook into Minecraft client tick
 * This allows modules to update every game tick (20 times per second)
 */
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ThalesFabricMod mod = ThalesFabricMod.getInstance();
        if (mod != null && mod.getModuleManager() != null) {
            // Update all enabled modules
            mod.getModuleManager().onUpdate();
            
            // Post tick event for event listeners
            mod.getEventManager().post(new TickEvent());
        }
    }
}
