package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {
    private static final String FILENAME = "cardHistory.ser";

    public static void saveCardHistory(Map<TarotCard, List<String>> cardHistory) {
        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(cardHistory);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static Map<TarotCard, List<String>> loadCardHistory() {
        Map<TarotCard, List<String>> loadedHistory = new HashMap<>();
        try (FileInputStream fileIn = new FileInputStream(FILENAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object obj = objectIn.readObject();
            if (obj instanceof Map) {
                loadedHistory = (Map<TarotCard, List<String>>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exception or return empty map
        }
        return loadedHistory;
    }

    // Other file I/O operations if needed
}


