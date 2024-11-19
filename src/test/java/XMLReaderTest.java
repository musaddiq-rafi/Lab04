// XMLReaderTest.java
package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLReaderTest {
    @Test
    public void testReadFromFile() {
        Reader xmlReader = new XMLReader();
        ArrayList<Transactions> transactions = xmlReader.readFromFile("src/main/java/org/example/BankDetails.xml");
        assertEquals(4, transactions.size());
        assertEquals("30-01-2017", transactions.get(0).date);
        assertEquals(-100, transactions.get(0).amount);
        assertEquals("Deliveroo", transactions.get(0).purpose);
    }
}