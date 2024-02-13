package org.example;

public class TarotCard {
    private String name;
    private String meaning;

    public TarotCard(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}


