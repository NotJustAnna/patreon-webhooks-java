package net.notjustanna.patreon;

import org.json.JSONObject;
import net.notjustanna.patreon.builder.EntityBuilder;

public class PatreonWebhookJava {
    public static PatreonWebhookEvent parse(String type, String json) {
        return parse(type, new JSONObject(json));
    }

    public static PatreonWebhookEvent parse(String type, JSONObject json) {
        return EntityBuilder.createWebhookEvent(type, json);
    }
}
