package com.lidiya.taxsystem.programmingcoursework;

import com.lidiya.taxsystem.programmingcoursework.util.ChecksumUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChecksumUtilTest {

    // Test for the checksum calculation with various types of input
    @Test
    public void testCalculateChecksum() {
        // Test cases with different combinations of lower, upper case letters and digits
        assertEquals(6, ChecksumUtil.calculateChecksum("abcDEF123")); // 3 lower + 3 upper + 3 digits = 6
        assertEquals(5, ChecksumUtil.calculateChecksum("abcde")); // 5 lower case letters
        assertEquals(4, ChecksumUtil.calculateChecksum("ABCDE")); // 4 upper case letters
        assertEquals(7, ChecksumUtil.calculateChecksum("1234567")); // 7 numeric digits
        assertEquals(0, ChecksumUtil.calculateChecksum("!@#$%^&*()")); // No alphanumeric characters
    }

    // Test for the validity of item codes
    @Test
    public void testIsValidItemCode() {
        // Valid item codes
        assertTrue(ChecksumUtil.isValidItemCode("Item_123")); // Contains letters, digits, and underscore
        assertTrue(ChecksumUtil.isValidItemCode("ABC123")); // Alphanumeric, no spaces or special chars
        assertTrue(ChecksumUtil.isValidItemCode("valid_Code_456")); // Alphanumeric and underscore

        // Invalid item codes
        assertFalse(ChecksumUtil.isValidItemCode("Item 123")); // Contains space
        assertFalse(ChecksumUtil.isValidItemCode("!Invalid@Code")); // Special characters
        assertFalse(ChecksumUtil.isValidItemCode("1234567!")); // Special character at the end
    }
}
