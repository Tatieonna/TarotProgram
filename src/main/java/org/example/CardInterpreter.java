package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardInterpreter {
    private Map<TarotCard, List<String>> cardHistory;

    public CardInterpreter() {
        cardHistory = new HashMap<>();
        // Initialize card history
    }

    public String getCardMeaning(TarotCard card) {
        return card.getMeaning();
    }

    public void addCustomInterpretation(TarotCard card, String interpretation) {
        List<String> interpretations = cardHistory.getOrDefault(card, new ArrayList<>());
        interpretations.add(interpretation);
        cardHistory.put(card, interpretations);
    }

    // Other methods for managing card interpretations
}


