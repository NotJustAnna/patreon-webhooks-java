package net.notjustanna.libs.patreonwebhooks.entity;

import org.jetbrains.annotations.NotNull;

/**
 * The record of a user's membership to a campaign. Remains consistent across months of pledging.
 * <br>
 * Due to the way that the Patreon API is, the Member object was split between {@link CampaignMember} and {@link CampaignPatron}.
 * <br>
 * Please use {@link CampaignMember#isPatron()} and {@link CampaignMember#asPatron()} to get the extra fields.
 */
public interface CampaignMember extends PatreonEntity {
    /**
     * Full name of the member user.
     */
    @NotNull
    String fullName();

    /**
     * If false, the Patron member doesn't follow your campaign.
     */
    boolean isFollower();

    /**
     * The user who is pledging to the campaign.
     */
    PatreonUser user();

    /**
     * The campaign that the membership is for.
     */
    Campaign campaign();

    /**
     * If false, apparently Patreon gave you someone who follows the campaign as a member.
     */
    default boolean isPatron() {
        return this instanceof CampaignPatron;
    }

    /**
     * Casts this object to a {@link CampaignPatron}, which has way more information.
     */
    default CampaignPatron asPatron() {
        if (this instanceof CampaignPatron) {
            return (CampaignPatron) this;
        }

        throw new IllegalStateException("the Member is not a Patron");
    }
}