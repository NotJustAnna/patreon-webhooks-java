package net.notjustanna.patreon.entity.impl;

import org.jetbrains.annotations.NotNull;
import net.notjustanna.patreon.entity.Campaign;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CampaignImpl implements Campaign {
    private final String id;
    private final OffsetDateTime createdAt;
    private final int patronCount;
    private final String pledgeUrl;
    private final boolean chargedImmediately;
    private final boolean monthly;
    private final boolean nsfw;
    private final String bannerUrl;
    private final String avatarUrl;
    private final String creationName;
    private final String discordServerId;
    private final String mainVideoEmbed;
    private final String mainVideoUrl;
    private final String oneLiner;
    private final String payPerName;
    private final OffsetDateTime publishedAt;
    private final String summary;
    private final String thanksEmbed;
    private final String thanksMessage;
    private final String thanksVideoUrl;

    public CampaignImpl(String id, OffsetDateTime createdAt, int patronCount, String pledgeUrl, boolean chargedImmediately, boolean monthly, boolean nsfw, String bannerUrl, String avatarUrl, String creationName, String discordServerId, String mainVideoEmbed, String mainVideoUrl, String oneLiner, String payPerName, OffsetDateTime publishedAt, String summary, String thanksEmbed, String thanksMessage, String thanksVideoUrl) {
        this.id = id;
        this.createdAt = createdAt;
        this.patronCount = patronCount;
        this.pledgeUrl = pledgeUrl;
        this.chargedImmediately = chargedImmediately;
        this.monthly = monthly;
        this.nsfw = nsfw;
        this.bannerUrl = bannerUrl;
        this.avatarUrl = avatarUrl;
        this.creationName = creationName;
        this.discordServerId = discordServerId;
        this.mainVideoEmbed = mainVideoEmbed;
        this.mainVideoUrl = mainVideoUrl;
        this.oneLiner = oneLiner;
        this.payPerName = payPerName;
        this.publishedAt = publishedAt;
        this.summary = summary;
        this.thanksEmbed = thanksEmbed;
        this.thanksMessage = thanksMessage;
        this.thanksVideoUrl = thanksVideoUrl;
    }

    @NotNull
    @Override
    public String id() {
        return id;
    }

    @NotNull
    @Override
    public OffsetDateTime createdAt() {
        return createdAt;
    }

    @Override
    public int patronCount() {
        return patronCount;
    }

    @NotNull
    @Override
    public String pledgeUrl() {
        return pledgeUrl;
    }

    @Override
    public boolean chargedImmediately() {
        return chargedImmediately;
    }

    @Override
    public boolean monthly() {
        return monthly;
    }

    @Override
    public boolean nsfw() {
        return nsfw;
    }

    @NotNull
    @Override
    public String bannerUrl() {
        return bannerUrl;
    }

    @NotNull
    @Override
    public String avatarUrl() {
        return avatarUrl;
    }

    @Override
    public String creationName() {
        return creationName;
    }

    @Override
    public String discordServerId() {
        return discordServerId;
    }

    @Override
    public String mainVideoEmbed() {
        return mainVideoEmbed;
    }

    @Override
    public String mainVideoUrl() {
        return mainVideoUrl;
    }

    @Override
    public String oneLiner() {
        return oneLiner;
    }

    @Override
    public String payPerName() {
        return payPerName;
    }

    @Override
    public OffsetDateTime publishedAt() {
        return publishedAt;
    }

    @Override
    public String summary() {
        return summary;
    }

    @Override
    public String thanksEmbed() {
        return thanksEmbed;
    }

    @Override
    public String thanksMessage() {
        return thanksMessage;
    }

    @Override
    public String thanksVideoUrl() {
        return thanksVideoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampaignImpl)) return false;
        CampaignImpl that = (CampaignImpl) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "C: " + id;
    }
}
