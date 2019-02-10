package net.notjustanna.patreon.entity.impl;

import net.notjustanna.patreon.entity.PatreonUser;
import net.notjustanna.patreon.entity.SocialConnection;
import net.notjustanna.patreon.entity.SocialConnectionType;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

public class PatreonUserImpl implements PatreonUser {
    private final String id;
    private final OffsetDateTime created;
    private final String fullName;
    private final String firstName;
    private final String lastName;
    private final String about;
    private final String email;
    private final String thumbUrl;
    private final String imageUrl;
    private final Set<SocialConnection> socialConnections;

    public PatreonUserImpl(String id, OffsetDateTime created, String fullName, String firstName, String lastName, String about, String email, String thumbUrl, String imageUrl, Set<SocialConnection> socialConnections) {
        this.id = id;
        this.created = created;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = about;
        this.email = email;
        this.thumbUrl = thumbUrl;
        this.imageUrl = imageUrl;
        this.socialConnections = socialConnections;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public OffsetDateTime created() {
        return created;
    }

    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public String about() {
        return about;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String thumbUrl() {
        return thumbUrl;
    }

    @Override
    public String imageUrl() {
        return imageUrl;
    }

    @Override
    public Set<SocialConnection> socialConnections() {
        return socialConnections;
    }

    @Override
    public SocialConnection socialConnection(SocialConnectionType type) {
        for (SocialConnection connection : socialConnections) {
            if (connection.type() == type) {
                return connection;
            }
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatreonUserImpl)) return false;
        PatreonUserImpl that = (PatreonUserImpl) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "U:" + fullName + '(' + id + ')';
    }
}
