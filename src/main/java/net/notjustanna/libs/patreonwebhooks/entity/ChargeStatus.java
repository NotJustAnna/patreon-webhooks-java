package net.notjustanna.libs.patreonwebhooks.entity;

public enum ChargeStatus {
    PAID,
    DECLINED,
    DELETED,
    PENDING,
    REFUNDED,
    FRAUD,
    OTHER,
    NOT_CHARGED_YET;


    public static ChargeStatus forStatus(String status) {
        if (status == null) return NOT_CHARGED_YET;

        for (ChargeStatus value : values()) {
            if (value.name().equalsIgnoreCase(status)) return value;
        }

        throw new IllegalArgumentException("Status " + status + " is not a valid status!");
    }
}
