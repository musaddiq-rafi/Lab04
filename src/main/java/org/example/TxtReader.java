package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtReader {
    //complete the class
    public ArrayList<Transactions> readFromTextFile(String filePath) {
        ArrayList<Transactions> transactions = new ArrayList<>();
        String line;
        String regex = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(regex);
                String date = data[0];
                int amount = Integer.parseInt(data[1]);
                String purpose = data[2];
                Transactions transaction = new Transactions(date, amount, purpose);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
