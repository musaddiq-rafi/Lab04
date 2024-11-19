// AnalysisTest.java
package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalysisTest {
    @Test
    public void testProfitOrLoss() {
        ArrayList<Transactions> transactions = new ArrayList<>();
        transactions.add(new Transactions("30-01-2017", -100, "Deliveroo"));
        transactions.add(new Transactions("30-01-2017", -50, "Tesco"));
        transactions.add(new Transactions("01-02-2017", 6000, "Salary"));
        int profitOrLoss = Analysis.profitOrLoss(transactions);
        assertEquals(5850, profitOrLoss);
    }

    @Test
    public void testMostExpense() {
        ArrayList<Transactions> transactions = new ArrayList<>();
        transactions.add(new Transactions("30-01-2017", -100, "Deliveroo"));
        transactions.add(new Transactions("30-01-2017", -50, "Tesco"));
        transactions.add(new Transactions("01-02-2017", 6000, "Salary"));
        String mostExpensive = Analysis.mostExpense(transactions);
        assertEquals("Salary", mostExpensive);
    }
}