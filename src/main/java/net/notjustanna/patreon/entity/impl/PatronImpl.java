package net.notjustanna.patreon.entity.impl;

import net.notjustanna.patreon.entity.*;

import java.time.OffsetDateTime;
import java.util.Objects;

public class PatronImpl implements Patron {
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

    public PatronImpl(String id, String fullName, boolean isFollower, PatronStatus patronStatus, OffsetDateTime pledgeStartDate, ChargeStatus lastChargeStatus, OffsetDateTime lastChargeDate, int currentlyPaying, int lifetimePayed, PatreonUser user, Campaign campaign) {
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

    @Override
    public String id() {
        return id;
    }

    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public boolean isFollower() {
        return isFollower;
    }

    @Override
    public PatronStatus patronStatus() {
        return patronStatus;
    }

    @Override
    public OffsetDateTime pledgeStartDate() {
        return pledgeStartDate;
    }

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
    public boolean isPatron() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatronImpl)) return false;
        PatronImpl that = (PatronImpl) o;
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
