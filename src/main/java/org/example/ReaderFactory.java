// ReaderFactory.java
package org.example;

public class ReaderFactory {
    public static Reader getReader(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new TxtReader();
        } else if (filePath.endsWith(".json")) {
            return new JSONReader();
        } else if (filePath.endsWith(".xml")) {
            return new XMLReader();
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }
}