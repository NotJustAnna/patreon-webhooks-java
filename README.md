# Patreon Webhooks for Java
Parse webhook events from Patreon into Java Entities.

The library is REALLY small and only depends on org.json.

### Get it on JCenter:

![Latest Version](https://api.bintray.com/packages/notjustanna/maven/patreon-webhooks-java/images/download.svg)

### Using It:

Your starting point is `net.notjustanna.patreon.PatreonWebhooksJava`.

- Use `PatreonWebhooksJava.parse(type, json)` to parse the input as entities.
- Use `PatreonWebhooksJava.isValid(json, signature, secret)` to validate the signature of the request.
- `PatreonWebhooksJava.validateAndParse(type, json, signature, secret)` throws an `IllegalSignatureException` if the signature is invalid, and returns the entity if the signature is valid.