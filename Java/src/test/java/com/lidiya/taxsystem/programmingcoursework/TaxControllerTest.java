package com.lidiya.taxsystem.programmingcoursework;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.lidiya.taxsystem.programmingcoursework.controller.TaxController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;

public class TaxControllerTest {

    @Test
    public void testImportCSVFile() {
        TaxController controller = new TaxController();

        // Mocking the file input/output (you can use a mock file for testing)
        File file = new File("path/to/valid_file.csv");

        // Assuming you have a method to simulate file import
        controller.importCSVFile(file);

        // After import, check the number of records
        assertNotNull(controller.getTransactions(), "Transactions list should not be null");
        assertEquals(5, controller.getTransactions().size(), "There should be 5 transactions imported");
    }
}
