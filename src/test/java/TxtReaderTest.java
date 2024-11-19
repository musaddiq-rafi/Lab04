// TxtReaderTest.java
package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TxtReaderTest {
    @Test
    public void testReadFromFile() {
        Reader txtReader = new TxtReader();
        ArrayList<Transactions> transactions = txtReader.readFromFile("src/main/java/org/example/BankDetails.txt");
        assertEquals(3, transactions.size());
        assertEquals("30-01-2017", transactions.get(0).date);
        assertEquals(-100, transactions.get(0).amount);
        assertEquals("Deliveroo", transactions.get(0).purpose);
    }
}