package net.notjustanna.patreon.entity;

import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public interface Patron extends CampaignMember {
    PatronStatus patronStatus();

    /**
     * Date of the first pledge.
     * On the API, this field is called "pledge_relationship_start".
     */
    OffsetDateTime pledgeStartDate();

    ChargeStatus lastChargeStatus();

    @Nullable
    OffsetDateTime lastChargeDate();

    /**
     * Returns true if the patron already gave money to you once.
     */
    boolean paidAtLeastOnce();

    /**
     * How much the member will pay next month, in cents of dollar.
     * On the API, this field is called "currently_entitled_amount_cents".
     */
    int currentlyPaying();

    /**
     * How much the member payed during its lifetime as patron, in cents of dollar.
     * On the API, this field is called "lifetime_support_cents".
     */
    int lifetimePayed();
}
