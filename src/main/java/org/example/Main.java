package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        String textfilePath = "src/main/java/org/example/BankDetails.txt";
        String jsonfilePath = "src/main/java/org/example/BankDetails.json";

        // Reading from a text file
        ArrayList<Transactions> transactionsFromText = readfromTextFile(textfilePath);
        displayTransactionSummary(transactionsFromText, "Text File");

        //Reading from a json file
        ArrayList<Transactions> transactionsFromJson = readfromJsonFile(jsonfilePath);
        displayTransactionSummary(transactionsFromJson, "Json File");

    }



    private static void displayTransactionSummary(ArrayList<Transactions> transactionsFromText, String textFile) {
    }

    public static ArrayList<Transactions> readfromTextFile(String filePath){
            ArrayList<Transactions> transactions= new ArrayList();
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
            return transactions;
            }

    private static ArrayList<Transactions> readfromJsonFile(String jsonfilePath) {
        ArrayList<Transactions> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(jsonfilePath))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray jsonArray = new JSONArray(jsonString.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String date = jsonObject.getString("date");
                int amount = jsonObject.getInt("amount");
                String purpose = jsonObject.getString("description");

                Transactions transaction = new Transactions(date, amount, purpose);
                transactions.add(transaction);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }


}

