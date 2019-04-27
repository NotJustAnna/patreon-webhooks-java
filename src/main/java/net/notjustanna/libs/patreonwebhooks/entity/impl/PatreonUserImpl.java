package net.notjustanna.libs.patreonwebhooks.entity.impl;

import org.jetbrains.annotations.NotNull;
import net.notjustanna.libs.patreonwebhooks.entity.PatreonUser;
import net.notjustanna.libs.patreonwebhooks.entity.SocialConnection;

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

    @NotNull
    @Override
    public String id() {
        return id;
    }

    @NotNull
    @Override
    public OffsetDateTime created() {
        return created;
    }

    @NotNull
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

    @NotNull
    @Override
    public String thumbUrl() {
        return thumbUrl;
    }

    @NotNull
    @Override
    public String imageUrl() {
        return imageUrl;
    }

    @NotNull
    @Override
    public Set<SocialConnection> socialConnections() {
        return socialConnections;
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
