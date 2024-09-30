// JSONReader.java
package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONReader {
    public ArrayList<Transactions> readFromJsonFile(String jsonfilePath) {
        ArrayList<Transactions> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(jsonfilePath))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray jsonArray = new JSONArray(jsonString.toString());
            System.out.println("READING FROM JSON FILE");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String date = jsonObject.getString("date");
                int amount = jsonObject.getInt("amount");
                String purpose = jsonObject.getString("description");

                Transactions transaction = new Transactions(date, amount, purpose);
                transactions.add(transaction);

                System.out.println(date);
                System.out.println(amount);
                System.out.println(purpose);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}