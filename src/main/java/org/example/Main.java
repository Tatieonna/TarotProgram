package org.example; // Defines the package name

import java.time.LocalDateTime; //Imports the LocalDateTime class for handling date and time
import java.time.format.DateTimeFormatter; // Imports the DateTimeFormatter class for formatting date and time
import java.util.*; // Imports all classes from the java.util package, which includes utility classes like List, Map, Scanner, etc.

// Declares the Main class
public class Main {
    // The main method - entry point for the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading the user input
        Random random = new Random(); // Creates a new Random object for generating random numbers
        Map<String, List<String>> cardHistory = FileHandler.loadCardHistory(); // Loads the card history from a file or other storage

        //Prints a welcome message to the console
        System.out.println("Welcome to the Tarot Card Program with Custom Interpretations and History!");
        System.out.print("Please enter your name: "); // Prompts the user to enter their name
        String userName = scanner.nextLine(); // Reads the user's name from the console

        boolean continueReading = true; //Flag to control the main loop

        // Main loop for the application
        while (continueReading) {
            //Prints the menu options
            System.out.println("\nHi, " + userName + "! Select an option:");
            System.out.println("1. Draw a single card");
            System.out.println("2. Draw multiple cards");
            System.out.println("3. Show card history");
            System.out.println("4. Exit");

            int choice = scanner.nextInt(); // Reads the user's menu choice
            scanner.nextLine(); // Consume newline left characters left after reading an integer

            //Switch statment to handle the users choice
            switch (choice) {
                case 1: //Case for drawing a single card
                    drawSingleCard(random, userName, scanner, cardHistory);
                    break;
                case 2: // Case for drawing multiple cards
                    drawMultipleCards(random, userName, scanner, cardHistory);
                    break;
                case 3: // Case for showing the card history
                    showCardHistory(userName, cardHistory);
                    break;
                case 4: // Case for exiting the program
                    continueReading = false; // Sets the flag to false to exit the loop
                    System.out.println("Exiting. Goodbye, " + userName + "!"); // Prints a goodbye message
                    FileHandler.saveCardHistory(cardHistory); // Saves the card history to a file or other storage
                    break;
                default: // Default case for invalid choices
                    System.out.println("Invalid choice. Please try again."); // Prints error message
                    break;
            }
        }
        scanner.close(); // Closes the scanner object to prevent resource leaks
    }

    //Method to get a random tarot card
    private static String getRandomCard(Random random) {
        List<String> keysAsArray = new ArrayList<>(TarotCardProgram.tarotCards.keySet()); //Converts the set of tarot card keys to a list
        int randomIndex = random.nextInt(keysAsArray.size()); // Generates a random index
        return keysAsArray.get(randomIndex); // Returns the tarot card at the random index
    }

    //Method to display the meaning of a tarot card and any custom interpretations
    private static void displayCardMeaning(String card, String userName, Map<String, List<String>> cardHistory) {
        //Prints the card meaning
        System.out.println("\nHi, " + userName + "! Here's the card meaning for " + card + ":");
        System.out.println(TarotCardProgram.tarotCards.get(card)); // Retrieves and prints the predefined meaning of the card
        List<String> interpretations = cardHistory.get(card); // Retrieves any custom interpretations for the card
        if (interpretations != null) { // Checks if there are any custom interpretations
            System.out.println("Interpretations:"); // prints a header for the interpretations
            for (String interpretation : interpretations) { // Iterates over the custom interpretations
                System.out.println("- " + interpretation); // Prints each interpretation
            }
        }
    }

    // Method to handle drawing a single tarot card
    private static void drawSingleCard(Random random, String userName, Scanner scanner, Map<String, List<String>> cardHistory) {
        String randomCard = getRandomCard(random); // Gets a random tarot card
        System.out.println("\nYou've chosen: " + randomCard); // Prints the chosen card
        displayCardMeaning(randomCard, userName, cardHistory); // Displays the card's meaning and interpreatations
        addCustomInterpretation(randomCard, scanner, cardHistory); // Prompts the user to add a custom interpreatation
    }

    //Method to handle drawing multiple tarot cards
    private static void drawMultipleCards(Random random, String userName, Scanner scanner, Map<String, List<String>> cardHistory) {
        System.out.print("Enter the number of cards to draw: "); // Prompts the user to enter the number of cards to draw
        int numOfCards = scanner.nextInt(); // Reads the number of cards to draw
        scanner.nextLine(); // Consume newline left by nextInt()

        if (numOfCards <= 0) { // Validates the number of cards
            System.out.println("Invalid number of cards. Please enter a positive number."); // Prints an error message fro an invalid input
            return; // Exits the method
        }

        System.out.println("\nDrawing " + numOfCards + " cards:"); // Prints a message indicating the number of cards being drawn
        for (int i = 0; i < numOfCards; i++) { // Loops through the number of cards to draw
            String randomCard = getRandomCard(random); // Gets a random tarot card
            System.out.println("\nCard " + (i + 1) + ": " + randomCard); // Prints the card number and the chosen card
            displayCardMeaning(randomCard, userName, cardHistory); // Displays the card's meaning and interpretations
            addCustomInterpretation(randomCard, scanner, cardHistory); // Prompts the user to add a custom interpretation
        }
    }

    // Method to allow the user to add a custom interpretation for a tarot card
    private static void addCustomInterpretation(String card, Scanner scanner, Map<String, List<String>> cardHistory) {
        System.out.print("Enter your interpretation for '" + card + "': "); // Prompts the user to enter their interpretation
        String interpretation = scanner.nextLine(); // Reads the user's interpretation
        List<String> interpretations = cardHistory.getOrDefault(card, new ArrayList<>()); // Retrieves the list of interpretations for the card, or creates a new list if none exists
        interpretations.add(getFormattedTimestamp() + " - " + interpretation); // Adds the new interpretation with a timestamp
        cardHistory.put(card, interpretations); // Updates the card history with the new interpretation
        System.out.println("Your interpretation has been added to the card history."); // Confirms that the interpretation has been added
    }

    // Method to get the current timestamp in a formatted string
    private static String getFormattedTimestamp() {
        LocalDateTime dateTime = LocalDateTime.now(); // Gets the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Defines the format for the timestamp
        return dateTime.format(formatter); // Returns the formatted timestamp
    }

    //Method to display the card history for a user
    private static void showCardHistory(String userName, Map<String, List<String>> cardHistory) {
        System.out.println("\nHi, " + userName + "! Your card history:"); // Prints the header for the card history
        // Check if the 'cardHistory' map is empty. This map stores the history of drawn tarot cards and their interpretations
        if (cardHistory.isEmpty()) { // if the map is empty
            System.out.println("No cards drawn yet."); // no cards have been drawn yet
        } else {
            // If the map is not empty, it means there is at least one card drawn and stored in the history
            // Iterate over each entry in the 'cardHistory' map. Each entry consists of a key-value pair where
            // the key is the name of the tarot card and the value is a list of interpretations for that card
            for (Map.Entry<String, List<String>> entry : cardHistory.entrySet()) {
                // Print the name of the tarot card (the key of the current entry in the map.)
                System.out.println("Card: " + entry.getKey());
                // Print a header for the interpretations of the current card
                System.out.println("Interpretations:");
                // Iterate over each interpretation in the list of interpretations for the current card ( the value of the current entry )
                for (String interpretation : entry.getValue()) {
                    // Print each interpretation, prefixed with a dash for better readability
                    System.out.println("- " + interpretation);
                }
                // Print an empty line for better separation between entries when displaying multiple cards and their interpretations
                System.out.println();
            }
        }
    }
}


