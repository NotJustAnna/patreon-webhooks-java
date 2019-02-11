package net.notjustanna.patreon.entity.impl;

import org.jetbrains.annotations.NotNull;
import net.notjustanna.patreon.entity.Campaign;
import net.notjustanna.patreon.entity.CampaignMember;
import net.notjustanna.patreon.entity.PatreonUser;

import java.util.Objects;

public class CampaignMemberImpl implements CampaignMember {
    private final String id;
    private final String fullName;
    private final boolean isFollower;
    private final PatreonUser user;
    private final Campaign campaign;

    public CampaignMemberImpl(String id, String fullName, boolean isFollower, PatreonUser user, Campaign campaign) {
        this.id = id;
        this.fullName = fullName;
        this.isFollower = isFollower;
        this.user = user;
        this.campaign = campaign;
    }

    @NotNull
    @Override
    public String id() {
        return id;
    }

    @NotNull
    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public boolean isFollower() {
        return isFollower;
    }

    @Override
    public PatreonUser user() {
        return user;
    }

    @Override
    public Campaign campaign() {
        return campaign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampaignMemberImpl)) return false;
        CampaignMemberImpl that = (CampaignMemberImpl) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "M:" + fullName + '(' + id + ')';
    }
}
