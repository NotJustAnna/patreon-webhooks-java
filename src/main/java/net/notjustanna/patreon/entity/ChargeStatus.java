package net.notjustanna.patreon.entity;

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
        for (ChargeStatus value : values()) {
            if (value.name().equalsIgnoreCase(status)) return value;
        }

        return NOT_CHARGED_YET;
    }
}
