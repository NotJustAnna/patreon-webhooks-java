package net.notjustanna.libs.patreonwebhooks;

import org.jetbrains.annotations.NotNull;
import net.notjustanna.libs.patreonwebhooks.entity.Campaign;
import net.notjustanna.libs.patreonwebhooks.entity.CampaignMember;
import net.notjustanna.libs.patreonwebhooks.entity.EventType;
import net.notjustanna.libs.patreonwebhooks.entity.PatreonUser;

/**
 * This is the main data class of the API, and represents an event received from a webhook as an entity.
 */
public class PatreonWebhookEvent {
    private final EventType eventType;
    private final CampaignMember member;
    private final Campaign campaign;
    private final PatreonUser user;

    public PatreonWebhookEvent(EventType eventType, CampaignMember member, Campaign campaign, PatreonUser user) {
        this.eventType = eventType;
        this.member = member;
        this.campaign = campaign;
        this.user = user;
    }

    /**
     * The type of this event.
     *
     * @see EventType
     */
    @NotNull
    public EventType eventType() {
        return eventType;
    }

    /**
     * The member that triggered the event.
     */
    public CampaignMember member() {
        return member;
    }

    /**
     * The campaign of the member that triggered the event.
     */
    public Campaign campaign() {
        return campaign;
    }

    /**
     * The user associated with the member that triggered the event.
     */
    public PatreonUser user() {
        return user;
    }

    @Override
    public String toString() {
        return "PatreonWebhookEvent: " + eventType +
            "(" + member +
            ", " + campaign +
            ", " + user +
            ')';
    }
}
