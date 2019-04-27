package net.notjustanna.libs.patreonwebhooks.builder;

import org.json.JSONObject;
import net.notjustanna.libs.patreonwebhooks.PatreonWebhookEvent;
import net.notjustanna.libs.patreonwebhooks.entity.*;
import net.notjustanna.libs.patreonwebhooks.entity.impl.*;
import net.notjustanna.libs.patreonwebhooks.util.PatreonUtil;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class EntityBuilder {
    public static PatreonWebhookEvent createWebhookEvent(String type, JSONObject json) {
        EventType eventType = EventType.fromType(type);
        RawWebhookEvent raw = createRawWebhookEvent(json);

        PatreonUser user = createUser(raw.user);
        Campaign campaign = createCampaign(raw.campaign);
        CampaignMember member = createMember(raw.member, campaign, user);

        return new PatreonWebhookEvent(eventType, member, campaign, user);
    }

    private static PatreonUser createUser(JSONObject json) {
        if (json == null) return null;
        JSONObject attributes = json.getJSONObject("attributes");

        String id = json.getString("id");
        OffsetDateTime created = PatreonUtil.parseDate(attributes.getString("created"));
        String fullName = attributes.getString("full_name");
        String firstName = attributes.optString("first_name");
        String lastName = attributes.optString("last_name");
        String about = attributes.optString("about");
        String email = attributes.optString("email");
        String thumbUrl = attributes.getString("thumb_url");
        String imageUrl = attributes.getString("image_url");
        Set<SocialConnection> socialConnections = createSocialConnections(attributes.getJSONObject("social_connections"));

        return new PatreonUserImpl(id, created, fullName, firstName, lastName, about, email, thumbUrl, imageUrl, socialConnections);
    }

    private static Set<SocialConnection> createSocialConnections(JSONObject json) {
        if (json == null) return Collections.emptySet();

        Set<SocialConnection> connections = new LinkedHashSet<>();
        for (String key : json.keySet()) {
            if (json.isNull(key)) continue;
            JSONObject value = json.getJSONObject(key);

            SocialConnectionType type = SocialConnectionType.fromKey(key);
            String userId = value.getString("user_id");
            connections.add(new SocialConnectionImpl(type, userId));
        }

        return Collections.unmodifiableSet(connections);
    }

    private static Campaign createCampaign(JSONObject json) {
        if (json == null) return null;
        JSONObject attributes = json.getJSONObject("attributes");

        String id = json.getString("id");
        OffsetDateTime createdAt = PatreonUtil.parseDate(attributes.getString("created_at"));
        int patronCount = attributes.getInt("patron_count");
        String pledgeUrl = attributes.getString("pledge_url");
        boolean chargedImmediately = attributes.optBoolean("is_charged_immediately");
        boolean monthly = attributes.getBoolean("is_monthly");
        boolean nsfw = attributes.getBoolean("is_nsfw");
        String bannerUrl = attributes.getString("image_url");
        String avatarUrl = attributes.getString("image_small_url");
        String creationName = attributes.optString("creation_name");
        String discordServerId = attributes.optString("discord_server_id");
        String mainVideoEmbed = attributes.optString("main_video_embed");
        String mainVideoUrl = attributes.optString("main_video_url");
        String oneLiner = attributes.optString("one_liner");
        String payPerName = attributes.optString("pay_per_name");
        OffsetDateTime publishedAt = PatreonUtil.parseDate(attributes.optString("published_at"));
        String summary = attributes.optString("summary");
        String thanksEmbed = attributes.optString("thanks_embed");
        String thanksMessage = attributes.optString("thanks_message");
        String thanksVideoUrl = attributes.optString("thanks_video_url");

        return new CampaignImpl(id, createdAt, patronCount, pledgeUrl, chargedImmediately, monthly, nsfw,
            bannerUrl, avatarUrl, creationName, discordServerId, mainVideoEmbed, mainVideoUrl, oneLiner,
            payPerName, publishedAt, summary, thanksEmbed, thanksMessage, thanksVideoUrl);
    }

    private static CampaignMember createMember(JSONObject json, Campaign campaign, PatreonUser user) {
        if (json == null) return null;
        JSONObject attributes = json.getJSONObject("attributes");

        //common stuff
        String id = json.getString("id");
        String fullName = attributes.getString("full_name");
        boolean isFollower = attributes.getBoolean("is_follower");

        PatronStatus patronStatus = PatronStatus.forStatus(attributes.optString("status"));
        if (patronStatus == null) {
            //it's a member
            return new CampaignMemberImpl(id, fullName, isFollower, user, campaign);
        }

        //it's a patron
        OffsetDateTime pledgeStartDate = PatreonUtil.parseDate(attributes.optString("pledge_relationship_start"));
        ChargeStatus lastChargeStatus = ChargeStatus.forStatus(attributes.optString("last_charge_status"));
        OffsetDateTime lastChargeDate = PatreonUtil.parseDate(attributes.optString("last_charge_date"));
        int currentlyPaying = attributes.getInt("currently_entitled_amount_cents");
        int lifetimePayed = attributes.getInt("lifetime_support_cents");

        return new CampaignPatronImpl(id, fullName, isFollower, patronStatus, pledgeStartDate,
            lastChargeStatus, lastChargeDate, currentlyPaying, lifetimePayed, user, campaign);
    }

    private static RawWebhookEvent createRawWebhookEvent(JSONObject json) {
        RawWebhookEvent event = new RawWebhookEvent();

        event.member = json.getJSONObject("data");

        for (Object v : json.getJSONArray("included")) {
            if (v instanceof JSONObject) {
                JSONObject j = ((JSONObject) v).getJSONObject("data");

                String type = j.getString("type");

                if (type.equals("campaign")) {
                    event.campaign = j;
                } else if (type.equals("user")) {
                    event.user = j;
                }
            }
        }

        return event;
    }

    static class RawWebhookEvent {
        JSONObject member;
        JSONObject campaign;
        JSONObject user;
    }
}
