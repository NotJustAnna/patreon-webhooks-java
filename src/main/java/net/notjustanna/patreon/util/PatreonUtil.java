package net.notjustanna.patreon.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class PatreonUtil {
    public static String capitalize(String s) {
        return s.isEmpty() ? s : s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static OffsetDateTime parseDate(String date) {
        return date == null ? null : OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
