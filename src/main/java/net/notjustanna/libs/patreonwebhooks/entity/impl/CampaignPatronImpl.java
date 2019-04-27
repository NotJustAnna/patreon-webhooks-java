package net.notjustanna.libs.patreonwebhooks.entity.impl;

import org.jetbrains.annotations.NotNull;
import net.notjustanna.libs.patreonwebhooks.entity.*;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CampaignPatronImpl implements CampaignPatron {
    private final String id;
    private final String fullName;
    private final boolean isFollower;
    private final PatronStatus patronStatus;
    private final OffsetDateTime pledgeStartDate;
    private final ChargeStatus lastChargeStatus;
    private final OffsetDateTime lastChargeDate;
    private final int currentlyPaying;
    private final int lifetimePayed;
    private final PatreonUser user;
    private final Campaign campaign;

    public CampaignPatronImpl(String id, String fullName, boolean isFollower, PatronStatus patronStatus, OffsetDateTime pledgeStartDate, ChargeStatus lastChargeStatus, OffsetDateTime lastChargeDate, int currentlyPaying, int lifetimePayed, PatreonUser user, Campaign campaign) {
        this.id = id;
        this.fullName = fullName;
        this.isFollower = isFollower;
        this.patronStatus = patronStatus;
        this.pledgeStartDate = pledgeStartDate;
        this.lastChargeStatus = lastChargeStatus;
        this.lastChargeDate = lastChargeDate;
        this.currentlyPaying = currentlyPaying;
        this.lifetimePayed = lifetimePayed;
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

    @NotNull
    @Override
    public PatronStatus patronStatus() {
        return patronStatus;
    }

    @NotNull
    @Override
    public OffsetDateTime pledgeStartDate() {
        return pledgeStartDate;
    }

    @NotNull
    @Override
    public ChargeStatus lastChargeStatus() {
        return lastChargeStatus;
    }

    @Override
    public OffsetDateTime lastChargeDate() {
        return lastChargeDate;
    }

    @Override
    public boolean paidAtLeastOnce() {
        return lifetimePayed > 0;
    }

    @Override
    public int currentlyPaying() {
        return currentlyPaying;
    }

    @Override
    public int lifetimePayed() {
        return lifetimePayed;
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
        if (!(o instanceof CampaignPatronImpl)) return false;
        CampaignPatronImpl that = (CampaignPatronImpl) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "P:" + fullName + '(' + id + ')';
    }
}
