package com.lidiya.taxsystem.programmingcoursework.util;

public class ChecksumUtil {
    public static int calculateChecksum(String input) {
        // Count the number of uppercase letters, lowercase letters, and numeric digits
        int caps = input.replaceAll("[^A-Z]", "").length();
        int lows = input.replaceAll("[^a-z]", "").length();
        int nums = input.replaceAll("[^0-9.]", "").length();
        return caps + lows + nums;
    }

    public static boolean isValidItemCode(String code) {
        // Check if the item code contains only alphanumeric characters or underscores
        return code.matches("^[A-Za-z0-9_]+$");
    }
}
