package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/BankDetails.txt";
        ArrayList<Transactions> transactions = new ArrayList<>();


        String line = "";
        String regex = ",";
        int transactionCount=0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(regex);


                String date = data[0];
                System.out.println(date);
                int amount = Integer.parseInt(data[1]);
                System.out.println(amount);
                String purpose = data[2];
                System.out.println(purpose);

                Transactions transaction = new Transactions(date, amount, purpose);
                transactions.add(transaction);

                transactionCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The total number of transactions is: "+ transactionCount);
        System.out.println("The total profit or loss is: "+ Analysis.profitOrLoss(transactions));
        System.out.println("The most expensive transaction is: "+ Analysis.mostExpense(transactions));
    }

}