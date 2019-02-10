package net.notjustanna.patreon;

public class PatreonParseTest {

    //examples on Patreon Docs v2
    public static String MESSAGE = "{\n" +
        "  \"data\": {\n" +
        "    \"attributes\": {\n" +
        "      \"currently_entitled_amount_cents\": null,\n" +
        "      \"full_name\": \"Platform\",\n" +
        "      \"is_follower\": true,\n" +
        "      \"last_charge_date\": null,\n" +
        "      \"last_charge_status\": null,\n" +
        "      \"lifetime_support_cents\": 0,\n" +
        "      \"note\": \"\",\n" +
        "      \"patron_status\": null,\n" +
        "      \"pledge_relationship_start\": null\n" +
        "    },\n" +
        "    \"id\": \"d485d5ac-6c82-42c6-9c08-c50cf01b73d7\",\n" +
        "    \"relationships\": {\n" +
        "      \"address\": {\n" +
        "        \"data\": null\n" +
        "      },\n" +
        "      \"campaign\": {\n" +
        "        \"data\": {\n" +
        "          \"id\": \"123456\",\n" +
        "          \"type\": \"campaign\"\n" +
        "        }\n" +
        "      },\n" +
        "      \"currently_entitled_tiers\": {\n" +
        "        \"data\": [\n" +
        "          \n" +
        "        ]\n" +
        "      },\n" +
        "      \"user\": {\n" +
        "        \"data\": {\n" +
        "          \"id\": \"987654321\",\n" +
        "          \"type\": \"user\"\n" +
        "        }\n" +
        "      }\n" +
        "    },\n" +
        "    \"type\": \"member\"\n" +
        "  },\n" +
        "  \"included\": [\n" +
        "    {\n" +
        "      \"data\": {\n" +
        "        \"attributes\": {\n" +
        "          \"created_at\": \"2018-04-01T15:27:11+00:00\",\n" +
        "          \"creation_name\": \"online communities\",\n" +
        "          \"discord_server_id\": \"1234567890\",\n" +
        "          \"image_small_url\": \"https://example.url\",\n" +
        "          \"image_url\": \"https://example.url\",\n" +
        "          \"is_charged_immediately\": false,\n" +
        "          \"is_monthly\": true,\n" +
        "          \"is_nsfw\": false,\n" +
        "          \"main_video_embed\": null,\n" +
        "          \"main_video_url\": null,\n" +
        "          \"one_liner\": null,\n" +
        "          \"patron_count\": 1000,\n" +
        "          \"pay_per_name\": \"month\",\n" +
        "          \"pledge_url\": \"/bePatron?c=12345\",\n" +
        "          \"published_at\": \"2018-04-01T18:15:34+00:00\",\n" +
        "          \"summary\": \"The most creator-first API\",\n" +
        "          \"thanks_embed\": \"\",\n" +
        "          \"thanks_msg\": null,\n" +
        "          \"thanks_video_url\": null\n" +
        "        },\n" +
        "        \"id\": \"12345\",\n" +
        "        \"type\": \"campaign\"\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"data\": {\n" +
        "        \"attributes\": {\n" +
        "          \"about\": \"A Patreon Platform User\",\n" +
        "          \"created\": \"2018-04-01T00:36:26+00:00\",\n" +
        "          \"email\": \"platform@patreon.com\",\n" +
        "          \"first_name\": \"Platform\",\n" +
        "          \"full_name\": \"Platform Team\",\n" +
        "          \"image_url\": \"https://url.example\",\n" +
        "          \"last_name\": \"Platform\",\n" +
        "          \"social_connections\": {\n" +
        "            \"deviantart\": null,\n" +
        "            \"discord\": null,\n" +
        "            \"facebook\": null,\n" +
        "            \"reddit\": null,\n" +
        "            \"spotify\": null,\n" +
        "            \"twitch\": null,\n" +
        "            \"twitter\": {\n" +
        "              \"user_id\": \"12345\"\n" +
        "            },\n" +
        "            \"youtube\": null\n" +
        "          },\n" +
        "          \"thumb_url\": \"https://url.example\",\n" +
        "          \"url\": \"https://www.patreon.com/example\",\n" +
        "          \"vanity\": \"platform\"\n" +
        "        },\n" +
        "        \"id\": \"12345\",\n" +
        "        \"type\": \"user\"\n" +
        "      }\n" +
        "    }\n" +
        "  ]\n" +
        "}";

    public static void main(String[] args) {
        PatreonWebhookEvent event = PatreonWebhookJava.parse("members:create", MESSAGE);

        System.out.println(event);
        System.out.println(event.user().socialConnections());
    }
}
