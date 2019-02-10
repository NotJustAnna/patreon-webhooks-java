package net.notjustanna.patreon;

import net.notjustanna.patreon.entity.Campaign;
import net.notjustanna.patreon.entity.CampaignMember;
import net.notjustanna.patreon.entity.EventType;
import net.notjustanna.patreon.entity.PatreonUser;

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

    public EventType eventType() {
        return eventType;
    }

    public CampaignMember member() {
        return member;
    }

    public Campaign campaign() {
        return campaign;
    }

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
