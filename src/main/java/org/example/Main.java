// Main.java
package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String textfilePath = "src/main/java/org/example/BankDetails.txt";
        String jsonfilePath = "src/main/java/org/example/BankDetails.json";
        String xmlfilePath = "src/main/java/org/example/BankDetails.xml";

        TxtReader txtReader = new TxtReader();
        JSONReader jsonReader = new JSONReader();
        XMLReader xmlReader = new XMLReader();

        ArrayList<Transactions> transactionsFromText = txtReader.readFromTextFile(textfilePath);
        ArrayList<Transactions> transactionsFromJson = jsonReader.readFromJsonFile(jsonfilePath);
        //ArrayList<Transactions> transactionsFromXml = xmlReader.readFromXmlFile(xmlfilePath);

        // You can now use the transactionsFromText, transactionsFromJson, and transactionsFromXml lists
        System.out.println("Transactions from Text File: " + transactionsFromText.size());
        System.out.println("Transactions from JSON File: " + transactionsFromJson.size());
       // System.out.println("Transactions from XML File: " + transactionsFromXml.size());
    }
}