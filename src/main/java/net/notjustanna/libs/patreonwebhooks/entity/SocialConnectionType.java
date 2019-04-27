package net.notjustanna.libs.patreonwebhooks.entity;

import net.notjustanna.libs.patreonwebhooks.util.PatreonUtil;

public enum SocialConnectionType {
    YOUTUBE,
    TWITTER,
    DEVIANTART,
    DISCORD,
    TWITCH,
    FACEBOOK,
    SPOTIFY;

    public static SocialConnectionType fromKey(String key) {
        for (SocialConnectionType value : values()) {
            if (value.name().toLowerCase().equals(key)) return value;
        }

        throw new IllegalArgumentException("Key " + key + " is not a valid type!");
    }

    @Override
    public String toString() {
        return PatreonUtil.capitalize(name().toLowerCase());
    }
}
