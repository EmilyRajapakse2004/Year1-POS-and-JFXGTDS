package com.lidiya.taxsystem.programmingcoursework;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.lidiya.taxsystem.programmingcoursework.model.Transaction;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testTransactionValid() {
        // Creating a valid transaction object
        Transaction validTransaction = new Transaction("AB123", 100.0, 10.0, 90.0, 2, 10);

        // Assuming calculateChecksum returns the correct checksum, this should be valid
        assertTrue(validTransaction.isValid(), "Transaction should be valid");
    }

    @Test
    public void testTransactionInvalidChecksum() {
        // Creating an invalid transaction object (checksum mismatch)
        Transaction invalidTransaction = new Transaction("AB123", 100.0, 10.0, 90.0, 2, 99); // Invalid checksum

        assertFalse(invalidTransaction.isValid(), "Transaction should be invalid due to incorrect checksum");
    }

    @Test
    public void testTransactionInvalidItemCode() {
        // Creating a transaction with an invalid item code
        Transaction invalidTransaction = new Transaction("INVALID", 100.0, 10.0, 90.0, 2, 10);

        assertFalse(invalidTransaction.isValid(), "Transaction should be invalid due to incorrect item code");
    }

    @Test
    public void testTransactionInvalidNegativePrices() {
        // Creating a transaction with a negative price
        Transaction invalidTransaction = new Transaction("AB123", -100.0, 10.0, 90.0, 2, 10);

        assertFalse(invalidTransaction.isValid(), "Transaction should be invalid due to negative internal price");
    }
}
