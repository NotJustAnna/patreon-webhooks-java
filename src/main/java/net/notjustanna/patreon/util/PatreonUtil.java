package net.notjustanna.patreon.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PatreonUtil {
    private static final String hexLookup = "0123456789ABCDEF";

    public static String capitalize(String s) {
        return s.isEmpty() ? s : s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static OffsetDateTime parseDate(String date) {
        return date == null ? null : OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static String digest(String key, String message) {
        try {
            Mac md5 = Mac.getInstance("HmacMD5");
            md5.init(new SecretKeySpec(key.getBytes(UTF_8), "HmacMD5"));
            byte[] bytes = md5.doFinal(message.getBytes(UTF_8));
            return toHex(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Couldn't digest message: ", e);
        }
    }

    private static String toHex(byte[] raw) {
        char[] chars = new char[raw.length * 2];
        for (int i = 0; i < raw.length; i++) {
            int v = raw[i] & 0xFF;
            chars[i * 2] = hexLookup.charAt(v >> 4);
            chars[i * 2 + 1] = hexLookup.charAt(v & 0x0F);
        }
        return new String(chars);
    }
}
