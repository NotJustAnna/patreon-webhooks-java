package net.notjustanna.patreon.entity;

public interface CampaignMember extends PatreonEntity {
    String fullName();

    /**
     * If false, the Patron member doesn't follow your campaign.
     */
    boolean isFollower();

    PatreonUser user();

    Campaign campaign();

    /**
     * If false, apparently Patreon gave you someone who follows the campaign as a member.
     */
    boolean isPatron();

    default Patron asPatron() {
        if (this instanceof Patron) {
            return (Patron) this;
        }

        throw new IllegalStateException("the Member is not a Patron");
    }
}