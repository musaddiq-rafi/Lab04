// XMLReader.java
package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.util.ArrayList;

public class XMLReader implements Reader {
    @Override
    public ArrayList<Transactions> readFromFile(String xmlfilePath) {
        ArrayList<Transactions> transactions = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlfilePath));
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("transaction");
            System.out.println("READING FROM XML FILE");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String date = eElement.getElementsByTagName("date").item(0).getTextContent();
                    int amount = Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent());
                    String purpose = eElement.getElementsByTagName("description").item(0).getTextContent();

                    Transactions transaction = new Transactions(date, amount, purpose);
                    transactions.add(transaction);

                    System.out.println(date);
                    System.out.println(amount);
                    System.out.println(purpose);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}