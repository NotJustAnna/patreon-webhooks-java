package net.notjustanna.patreon.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

/**
 * The creator's page, and the top-level object for accessing lists of members, tiers, etc.
 */
public interface Campaign extends PatreonEntity {
    /**
     * Datetime that the creator first began the campaign creation process.
     *
     * @see Campaign#publishedAt()
     */
    @NotNull
    OffsetDateTime createdAt();

    /**
     * Number of patrons pledging to this creator.
     */
    int patronCount();

    /**
     * Relative (to patreon.com) URL for the pledge checkout flow for this campaign.
     */
    @NotNull
    String pledgeUrl();

    /**
     * @return <b>true</b> if the campaign charges upfront, <b>false</b> otherwise.
     */
    boolean chargedImmediately();

    /**
     * @return <b>true</b> if the campaign charges per month, <b>false</b> if the campaign charges per-post.
     */
    boolean monthly();

    /**
     * @return <b>true</b> if the creator has marked the campaign as containing nsfw content.
     */
    boolean nsfw();

    /**
     * Banner image URL for the campaign.
     * On the API, this field is called "image_url".
     */
    @NotNull
    String bannerUrl();

    /**
     * Avatar image URL for the campaign.
     * On the API, this field is called "image_small_url".
     */
    @NotNull
    String avatarUrl();

    /**
     * The type of content the creator is creating, as in "<b>vanity</b> is creating <b>creation_name</b>". Can be null.
     */
    @Nullable
    String creationName();

    /**
     * The ID of the external discord server that is linked to this campaign. Can be null.
     */
    @Nullable
    String discordServerId();

    /**
     * Can be null.
     */
    @Nullable
    String mainVideoEmbed();

    /**
     * Can be null.
     */
    @Nullable
    String mainVideoUrl();

    /**
     * Pithy one-liner for this campaign, displayed on the creator page. Can be null.
     */
    @Nullable
    String oneLiner();

    /**
     * The thing which patrons are paying per, as in "<b>vanity</b> is making $1000 per <b>pay_per_name</b>". Can be null.
     */
    @Nullable
    String payPerName();

    /**
     * Datetime that the creator most recently published (made publicly visible) the campaign. Can be null.
     */
    @Nullable
    OffsetDateTime publishedAt();

    /**
     * The creator's summary of their campaign. Can be null.
     */
    @Nullable
    String summary();

    /**
     * Can be null.
     */
    @Nullable
    String thanksEmbed();

    /**
     * Thank you message shown to patrons after they pledge to this campaign. Can be null.
     */
    @Nullable
    String thanksMessage();

    /**
     * URL for the video shown to patrons after they pledge to this campaign. Can be null.
     */
    @Nullable
    String thanksVideoUrl();
}
