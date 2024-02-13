package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Map<String, List<String>> cardHistory = FileHandler.loadCardHistory();

        System.out.println("Welcome to the Tarot Card Program with Custom Interpretations and History!");
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        boolean continueReading = true;

        while (continueReading) {
            System.out.println("\nHi, " + userName + "! Select an option:");
            System.out.println("1. Draw a single card");
            System.out.println("2. Draw multiple cards");
            System.out.println("3. Show card history");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            switch (choice) {
                case 1:
                    drawSingleCard(random, userName, scanner, cardHistory);
                    break;
                case 2:
                    drawMultipleCards(random, userName, scanner, cardHistory);
                    break;
                case 3:
                    showCardHistory(userName, cardHistory);
                    break;
                case 4:
                    continueReading = false;
                    System.out.println("Exiting. Goodbye, " + userName + "!");
                    FileHandler.saveCardHistory(cardHistory);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static String getRandomCard(Random random) {
        List<String> keysAsArray = new ArrayList<>(TarotCardProgram.tarotCards.keySet());
        int randomIndex = random.nextInt(keysAsArray.size());
        return keysAsArray.get(randomIndex);
    }

    private static void displayCardMeaning(String card, String userName, Map<String, List<String>> cardHistory) {
        System.out.println("\nHi, " + userName + "! Here's the card meaning for " + card + ":");
        System.out.println(TarotCardProgram.tarotCards.get(card));
        List<String> interpretations = cardHistory.get(card);
        if (interpretations != null) {
            System.out.println("Interpretations:");
            for (String interpretation : interpretations) {
                System.out.println("- " + interpretation);
            }
        }
    }

    private static void drawSingleCard(Random random, String userName, Scanner scanner, Map<String, List<String>> cardHistory) {
        String randomCard = getRandomCard(random);
        System.out.println("\nYou've chosen: " + randomCard);
        displayCardMeaning(randomCard, userName, cardHistory);
        addCustomInterpretation(randomCard, scanner, cardHistory);
    }

    private static void drawMultipleCards(Random random, String userName, Scanner scanner, Map<String, List<String>> cardHistory) {
        System.out.print("Enter the number of cards to draw: ");
        int numOfCards = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        if (numOfCards <= 0) {
            System.out.println("Invalid number of cards. Please enter a positive number.");
            return;
        }

        System.out.println("\nDrawing " + numOfCards + " cards:");
        for (int i = 0; i < numOfCards; i++) {
            String randomCard = getRandomCard(random);
            System.out.println("\nCard " + (i + 1) + ": " + randomCard);
            displayCardMeaning(randomCard, userName, cardHistory);
            addCustomInterpretation(randomCard, scanner, cardHistory);
        }
    }

    private static void addCustomInterpretation(String card, Scanner scanner, Map<String, List<String>> cardHistory) {
        System.out.print("Enter your interpretation for '" + card + "': ");
        String interpretation = scanner.nextLine();
        List<String> interpretations = cardHistory.getOrDefault(card, new ArrayList<>());
        interpretations.add(getFormattedTimestamp() + " - " + interpretation);
        cardHistory.put(card, interpretations);
        System.out.println("Your interpretation has been added to the card history.");
    }

    private static String getFormattedTimestamp() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    private static String getTimestamp() {
        return LocalDateTime.now().toString();
    }

    private static void showCardHistory(String userName, Map<String, List<String>> cardHistory) {
        System.out.println("\nHi, " + userName + "! Your card history:");

        if (cardHistory.isEmpty()) {
            System.out.println("No cards drawn yet.");
        } else {
            for (Map.Entry<String, List<String>> entry : cardHistory.entrySet()) {
                System.out.println("Card: " + entry.getKey());
                System.out.println("Interpretations:");
                for (String interpretation : entry.getValue()) {
                    System.out.println("- " + interpretation);
                }
                System.out.println();
            }
        }
    }
}


