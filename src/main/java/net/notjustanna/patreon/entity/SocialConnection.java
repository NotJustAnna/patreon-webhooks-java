package net.notjustanna.patreon.entity;

import org.jetbrains.annotations.NotNull;

/**
 * Mapping from user's connected app names to external user id on the respective app.
 */
public interface SocialConnection {
    /**
     * The app connected to.
     *
     * @see SocialConnectionType
     */
    @NotNull
    SocialConnectionType type();

    /**
     * The user ID on the connected app.
     */
    @NotNull
    String userId();
}
