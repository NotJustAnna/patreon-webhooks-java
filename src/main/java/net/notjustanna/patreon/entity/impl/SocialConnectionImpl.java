package net.notjustanna.patreon.entity.impl;

import net.notjustanna.patreon.entity.SocialConnection;
import net.notjustanna.patreon.entity.SocialConnectionType;

import java.util.Objects;

public class SocialConnectionImpl implements SocialConnection {
    private final SocialConnectionType type;
    private final String userId;

    public SocialConnectionImpl(SocialConnectionType type, String userId) {
        this.type = type;
        this.userId = userId;
    }

    @Override
    public SocialConnectionType type() {
        return type;
    }

    @Override
    public String userId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialConnectionImpl)) return false;
        SocialConnectionImpl that = (SocialConnectionImpl) o;
        return type == that.type &&
            userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, userId);
    }

    @Override
    public String toString() {
        return "SC to " + type + " (" + userId + ')';
    }
}
