// Main.java
package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] filePaths = {
                "src/main/java/org/example/BankDetails.txt",
                "src/main/java/org/example/BankDetails.json",
                "src/main/java/org/example/BankDetails.xml"
        };

        for (String filePath : filePaths) {
            Reader reader = ReaderFactory.getReader(filePath);
            ArrayList<Transactions> transactions = reader.readFromFile(filePath);

            System.out.println("Transactions from " + filePath + ": " + transactions.size());

            // Perform analysis on transactions
            int profitOrLoss = Analysis.profitOrLoss(transactions);
            String mostExpensive = Analysis.mostExpense(transactions);

            System.out.println("Total Profit or Loss from " + filePath + ": " + profitOrLoss);
            System.out.println("Most Expensive Transaction from " + filePath + ": " + mostExpensive);
        }
    }
}