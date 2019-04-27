package net.notjustanna.libs.patreonwebhooks.entity;

import org.jetbrains.annotations.NotNull;

/**
 * Base of all Patreon-related Entities.
 */
public interface PatreonEntity {
    /**
     * The ID of the entity.
     */
    @NotNull
    String id();
}
