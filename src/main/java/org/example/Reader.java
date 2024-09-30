// Reader.java
package org.example;

import java.util.ArrayList;

public interface Reader {
    ArrayList<Transactions> readFromFile(String filePath);
}