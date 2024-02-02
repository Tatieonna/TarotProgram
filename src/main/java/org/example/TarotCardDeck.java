package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarotCardDeck {
        private List<TarotCard> deck;

        public TarotCardDeck() {
            deck = new ArrayList<>();
            // Populate the deck with TarotCard objects
            deck.add(new TarotCard("The Fool", "New beginnings, innocence, taking a leap of faith"));
            // Add other cards similarly
            // ...
        }

        public void shuffleDeck() {
            Collections.shuffle(deck);
        }

        public TarotCard drawCard() {
            if (deck.isEmpty()) {
                // Handle if deck is empty
                return null;
            }
            return deck.remove(0);
        }

        // Other methods related to managing the deck
    }


