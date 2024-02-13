package org.example;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {
    private static final String FILENAME = "src/main/java/org/example/cardHistory.ser";

    public static void saveCardHistory(Map<String, List<String>> cardHistory) {
        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(cardHistory);
        } catch (IOException e) {
            System.err.println("Error saving card history: " + e.getMessage());
        }
    }

    public static Map<String, List<String>> loadCardHistory() {
        Map<String, List<String>> loadedHistory = new HashMap<>();
        try (FileInputStream fileIn = new FileInputStream(FILENAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object obj = objectIn.readObject();
            if (obj instanceof Map) {
                loadedHistory = (Map<String, List<String>>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading card history: " + e.getMessage());
        }
        return loadedHistory;
    }

    // Other file I/O operations if needed
}



