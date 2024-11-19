// Analysis.java
package org.example;

import java.util.ArrayList;

public class Analysis {

    public Analysis(ArrayList<Transactions> transactions) {
        // Constructor can be used to initialize or process transactions if needed
    }

    static int profitOrLoss(ArrayList<Transactions> transactions) {
        int summation = 0;
        for (Transactions transaction : transactions) {
            summation += transaction.amount;
        }
        return summation;
    }

    static String mostExpense(ArrayList<Transactions> transactions) {
        int maxExpense = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).amount > maxExpense) {
                maxExpense = transactions.get(i).amount;
                index = i;
            }
        }
        return transactions.get(index).purpose;
    }
}