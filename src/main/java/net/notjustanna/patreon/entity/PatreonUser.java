package net.notjustanna.patreon.entity;

import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Set;

public interface PatreonUser extends PatreonEntity {
    OffsetDateTime created();

    @Nullable
    String about();

    @Nullable
    String email();

    String fullName();

    @Nullable
    String firstName();

    @Nullable
    String lastName();

    String imageUrl();

    String thumbUrl();

    Set<SocialConnection> socialConnections();

    @Nullable
    SocialConnection socialConnection(SocialConnectionType type);
}
