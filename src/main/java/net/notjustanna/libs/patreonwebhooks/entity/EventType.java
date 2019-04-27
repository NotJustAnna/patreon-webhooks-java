package net.notjustanna.libs.patreonwebhooks.entity;

public enum EventType {
    /**
     * Triggered when a new member is created.
     * <p>
     * Note that you may get more than one of these per patron if they delete and renew their membership.
     * Member creation only occurs if there was no prior payment between patron and creator.
     */
    CREATE_MEMBER("members:create"),

    /**
     * Triggered when the membership information is changed.
     * <p>
     * Includes updates on payment charging events
     */
    UPDATE_MEMBER("members:update"),

    /**
     * Triggered when a membership is deleted.
     * <p>
     * Note that you may get more than one of these per patron if they delete and renew their membership.
     * Deletion only occurs if no prior payment happened, otherwise pledge deletion is an update to member status.
     */
    DELETE_MEMBER("members:delete"),

    /**
     * Triggered when a new pledge is created for a member.
     * <p>
     * This includes when a member is created through pledging, and when a follower becomes a patron.
     */
    CREATE_PLEDGE("members:pledge:create"),

    /**
     * Triggered when a member updates their pledge.
     */
    UPDATE_PLEDGE("members:pledge:update"),

    /**
     * Triggered when a member deletes their pledge.
     */
    DELETE_PLEDGE("members:pledge:delete");

    private final String type;

    EventType(String type) {
        this.type = type;
    }

    public static EventType fromType(String type) {
        for (EventType value : values()) {
            if (value.type.equals(type)) return value;
        }

        throw new IllegalArgumentException("Type " + type + " is not a valid type!");
    }
}
