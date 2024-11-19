// Main.java
package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String textfilePath = "src/main/java/org/example/BankDetails.txt";
        String jsonfilePath = "src/main/java/org/example/BankDetails.json";
        String xmlfilePath = "src/main/java/org/example/BankDetails.xml";

        Reader txtReader = new TxtReader();
        Reader jsonReader = new JSONReader();
        Reader xmlReader = new XMLReader();

        ArrayList<Transactions> transactionsFromText = txtReader.readFromFile(textfilePath);
        ArrayList<Transactions> transactionsFromJson = jsonReader.readFromFile(jsonfilePath);
        ArrayList<Transactions> transactionsFromXml = xmlReader.readFromFile(xmlfilePath);

        // You can now use the transactionsFromText, transactionsFromJson, and transactionsFromXml lists
        System.out.println("Transactions from Text File: " + transactionsFromText.size());
        System.out.println("Transactions from JSON File: " + transactionsFromJson.size());
        System.out.println("Transactions from XML File: " + transactionsFromXml.size());

        // Perform analysis on transactions from text file
        Analysis analysis = new Analysis(transactionsFromText);
        int profitOrLoss = Analysis.profitOrLoss(transactionsFromText);
        String mostExpensive = Analysis.mostExpense(transactionsFromText);

        System.out.println("Total Profit or Loss from Text File: " + profitOrLoss);
        System.out.println("Most Expensive Transaction from Text File: " + mostExpensive);
    }
}