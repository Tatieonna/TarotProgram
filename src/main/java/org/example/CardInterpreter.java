package org.example;

import java.util.List;
import java.util.Map;

public class CardInterpreter {
    private Map<String, List<String>> cardHistory;

    public CardInterpreter() {
        cardHistory = FileHandler.loadCardHistory();
        // Initialize card history
    }

    public TarotCard getCardMeaning(TarotCard card) {
        return card;
    }
}
