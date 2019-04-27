package net.notjustanna.libs.patreonwebhooks.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Set;

/**
 * The Patreon user, which can be both patron and creator.
 */
public interface PatreonUser extends PatreonEntity {
    /**
     * Datetime of this user's account creation.
     */
    @NotNull
    OffsetDateTime created();

    /**
     * The user's about text, which appears on their profile. Can be null.
     */
    @Nullable
    String about();

    /**
     * The user's email address. Requires certain scopes to access.
     */
    @Nullable
    String email();

    /**
     * Combined first and last name.
     */
    @NotNull
    String fullName();

    /**
     * First name. Can be null.
     */
    @Nullable
    String firstName();

    /**
     * Last name. Can be null.
     */
    @Nullable
    String lastName();

    /**
     * The user's profile picture URL, scaled to width 400px.
     */
    @NotNull
    String imageUrl();

    /**
     * The user's profile picture URL, scaled to a square of size 100x100px.
     */
    @NotNull
    String thumbUrl();

    /**
     * Mapping from user's connected app names to external user id on the respective app.
     */
    @NotNull
    Set<SocialConnection> socialConnections();

    /**
     * Returns the social connection of the user to the respective app, if the user did connected them.
     */
    @Nullable
    default SocialConnection socialConnection(SocialConnectionType type) {
        for (SocialConnection connection : socialConnections()) {
            if (connection.type() == type) {
                return connection;
            }
        }
        return null;
    }
}
