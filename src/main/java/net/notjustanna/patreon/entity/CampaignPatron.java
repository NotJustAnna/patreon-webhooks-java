package net.notjustanna.patreon.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

/**
 * The record of a user's membership to a campaign. Remains consistent across months of pledging.
 * <br>
 * This class has all attributes from Member object, since Patreon API is inconsistent.
 */
public interface CampaignPatron extends CampaignMember {
    /**
     * The current status of the patron
     *
     * @see PatronStatus
     */
    @NotNull
    PatronStatus patronStatus();

    /**
     * Date of the first pledge.
     * On the API, this field is called "pledge_relationship_start".
     */
    @NotNull
    OffsetDateTime pledgeStartDate();

    /**
     * The result of the last attempted charge.
     *
     * @see ChargeStatus
     */
    @NotNull
    ChargeStatus lastChargeStatus();

    /**
     * Datetime of last attempted charge. <b>null</b> if never charged.
     */
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

    /**
     * Yes, this member is a Patron.
     */
    @Override
    default boolean isPatron() {
        return true;
    }

    /**
     * Yes, you can get this member is a Patron.
     */
    @Override
    default CampaignPatron asPatron() {
        return this;
    }
}
