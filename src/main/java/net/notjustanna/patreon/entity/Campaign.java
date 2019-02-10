package net.notjustanna.patreon.entity;

import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public interface Campaign extends PatreonEntity {
    OffsetDateTime createdAt();

    int patronCount();

    String pledgeUrl();

    boolean chargedImmediately();

    boolean monthly();

    boolean nsfw();

    String imageUrl();

    String imageSmallUrl();

    @Nullable
    String creationName();

    @Nullable
    String discordServerId();

    @Nullable
    String mainVideoEmbed();

    @Nullable
    String mainVideoUrl();

    @Nullable
    String oneLiner();

    @Nullable
    String payPerName();

    @Nullable
    OffsetDateTime publishedAt();

    @Nullable
    String summary();

    @Nullable
    String thanksEmbed();

    @Nullable
    String thanksMessage();

    @Nullable
    String thanksVideoUrl();
}
