package com.thales.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Mixin to hook into Client Player Entity
 * Provides access to player-specific functionality for modules
 * 
 * Additional mixins can be added here for:
 * - Movement modifications
 * - Inventory access
 * - Combat features
 * - etc.
 */
@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    
    // Player-specific hooks will be added here as needed
    // Example: Override movement methods for speed/fly modules
}
