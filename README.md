# Patreon Webhooks for Java
Parse webhooks of the Patreon APIv2 webhooks into Java entities.

Licensed under the [MIT License](https://github.com/notjustanna/patreon-webhooks-java/blob/master/LICENSE).

### Installation

![Latest Version](https://api.bintray.com/packages/notjustanna/maven/patreon-webhooks-java/images/download.svg)

Using in Gradle:

```gradle
repositories {
  jcenter()
}

dependencies {
  compile 'net.notjustanna.libs:patreon-webhooks-java:LATEST' // replace LATEST with the version above
}
```

Using in Maven:

```xml
<repositories>
  <repository>
    <id>central</id>
    <name>bintray</name>
    <url>http://jcenter.bintray.com</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>net.notjustanna.libs</groupId>
    <artifactId>patreon-webhooks-java</artifactId>
    <version>LATEST</version> <!-- replace LATEST with the version above -->
  </dependency>
</dependencies>
```

### Usage

The starting point of the library is the `PatreonWebhooksJava` class.

- Use `PatreonWebhooksJava.parse(type, json)` to parse the input as entities.
- Use `PatreonWebhooksJava.isValid(json, signature, secret)` to validate the signature of the request.
- `PatreonWebhooksJava.validateAndParse(type, json, signature, secret)` throws an `IllegalSignatureException` if the signature is invalid, and returns the entity if the signature is valid.

### Support




