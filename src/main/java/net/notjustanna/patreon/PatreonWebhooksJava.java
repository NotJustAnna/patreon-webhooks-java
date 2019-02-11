package net.notjustanna.patreon;

import org.json.JSONObject;
import net.notjustanna.patreon.builder.EntityBuilder;
import net.notjustanna.patreon.util.PatreonUtil;

/**
 * <p>Entry point of the API.</p>
 * <p>Gives access to event parsing and signature checking of the events.</p>
 * <br>
 * <p>Please note that the only events supported are from Patreon <b>APIv2</b> webhooks. <b>The deprecated webhook events aren't supported!</b></p>
 */
public class PatreonWebhooksJava {
    /**
     * Parses the received type and JSON as a {@link PatreonWebhookEvent}.
     *
     * @param type the type, received as the "X-Patreon-Signature" of the request.
     * @param json the json, received as a body of the request.
     * @return the event as a entity.
     */
    public static PatreonWebhookEvent parse(String type, JSONObject json) {
        return EntityBuilder.createWebhookEvent(type, json);
    }

    /**
     * Parses the received type and JSON as a {@link PatreonWebhookEvent}.
     *
     * @param type the type, received as the "X-Patreon-Event" of the request.
     * @param json the json, received as a body of the request.
     * @return the event as a entity.
     */
    public static PatreonWebhookEvent parse(String type, String json) {
        return parse(type, new JSONObject(json));
    }

    /**
     * Validates the received JSON against the signature, using the secret provided by Patreon.
     *
     * @param json      the json, received as a body of the request.
     * @param signature the signature, received as the "X-Patreon-Signature"
     * @param secret    the secret received from Patreon, preferentially loaded from a file.
     * @return <b>true</b> if the signature is valid. if <b>false</b>, the received JSON is a fraud.
     */
    public static boolean isValid(String json, String signature, String secret) {
        return signature != null && PatreonUtil.digest(secret, json).equalsIgnoreCase(signature);
    }

    /**
     * Validates the received JSON against the signature, using the secret provided by Patreon.
     *
     * @param json      the json, received as a body of the request.
     * @param signature the signature, received as the "X-Patreon-Signature"
     * @param secret    the secret received from Patreon, preferentially loaded from a file.
     * @throws IllegalSignatureException if the received signature is invalid.
     */
    public static void checkValid(String json, String signature, String secret) throws IllegalSignatureException {
        if (!isValid(json, signature, secret)) {
            throw new IllegalSignatureException("Received Signature is invalid!");
        }
    }

    /**
     * Validates the received JSON against the signature, using the secret provided by Patreon,
     * and if valid, parses the received type and JSON as a {@link PatreonWebhookEvent}.
     *
     * @param type      the type, received as the "X-Patreon-Event" of the request.
     * @param json      the json, received as a body of the request.
     * @param signature the signature, received as the "X-Patreon-Signature"
     * @param secret    the secret received from Patreon, preferentially loaded from a file.
     * @return the event as a entity, if the signature is valid.
     * @throws IllegalSignatureException if the signature is invalid.
     */
    public static PatreonWebhookEvent validateAndParse(String type, String json, String signature, String secret) throws IllegalSignatureException {
        checkValid(json, signature, secret);
        return parse(type, json);
    }
}
