package org.example;

import java.util.*;

public class TarotCardProgram {
    public static final Map<String, String> tarotCards = new HashMap<>();
    static {
        tarotCards.put("The Fool", "New beginnings, innocence, taking a leap of faith");
        tarotCards.put("The Magician", "Manifestation, skill, using ones power");
        tarotCards.put("The High Priestess", "Intuition, wisdom, the subconscious");
        tarotCards.put("The Empress", "Abundance, creativity, nurturing energy");
        tarotCards.put("The Emperor", "Structure, stability, authority");
        tarotCards.put("The Hierophant", "Tradition, teaching, spiritual guidance");
        tarotCards.put("The Lovers", "Choice, relationships, values");
        tarotCards.put("The Chariot", "Control, direction, willpower");
        tarotCards.put("Strength", "Inner strength, courage, overcoming challenges");
        tarotCards.put("The Hermit", "Introspection, solitude, seeking wisdom");
        tarotCards.put("Wheel of Fortune", "Change, cycles, unexpected events");
        tarotCards.put("Justice", "Fairness, accountability, karma");
        tarotCards.put("The Hanged Man", "Surrender, letting go, new perspectives");
        tarotCards.put("Death", "Transformation, endings, new beginnings");
        tarotCards.put("Temperance","Balance, moderation, integration");
        tarotCards.put("The Devil", "Temptation, shadow self, addiction");
        tarotCards.put("The Tower", "Sudden change, disruption, upheaval");
        tarotCards.put("The Star", "Hope, faith, renewal");
        tarotCards.put("The Moon", "Illusion, fear, the unknown");
        tarotCards.put("The Sun", "Joy, optimism, success");
        tarotCards.put("Judgement", "Awakening, reckoning, a new start");
        tarotCards.put("The World", "Completion, achievement, integration");

        tarotCards.put("Ace of Wands", "A Spark of inspiration, igniting new beginnings");
        tarotCards.put("King of Wands", "Leadership, vision, taking charge");
        tarotCards.put("Queen of Wands", "Courage, strength, passionate action");
        tarotCards.put("Knight of Wands", "Adventure, exploration, seeking opportunities");
        tarotCards.put("Page of Wands", "Enthusiasm, curiosity, learning new skills");
        tarotCards.put("10 of Wands", "Completion of a project, reaping rewards");
        tarotCards.put("9 of Wands", "Confidence, optimism, expansion");
        tarotCards.put("8 of Wands", "Swift action, overcoming obstacles, pushing forward");
        tarotCards.put("7 of Wands", "Challenges, delays, reevaluating your path");
        tarotCards.put("6 of Wands", "Collaboration, community, shared goals");
        tarotCards.put("5 of Wands", "Competition, conflict, testing your strength");
        tarotCards.put("4 of Wands", "Stability, rest, integrating experiences");
        tarotCards.put("3 of Wands", "Growth, development, building a foundation");
        tarotCards.put("2 of Wands", "Duality, choices, weighing options");

        tarotCards.put("Ace of Cups", "New relationships, emotional beginnings, open-heartedness");
        tarotCards.put("King of Cups", "Compassion, understanding, emotional depth");
        tarotCards.put("Queen of Cups", "Intuition, nurturing, unconditional love");
        tarotCards.put("Knight of Cups", "Following your heart, seeking romance, emotional expression");
        tarotCards.put("Page of Cups", "Imagination, dreams, exploring your feelings");
        tarotCards.put("10 of Cups", "Happiness, contentment, fulfilled relationships");
        tarotCards.put("9 of Cups", "Letting go, forgiveness, compassion for yourself and others");
        tarotCards.put("8 of Cups", "Secrecy, hidden emotions, intuition guiding you");
        tarotCards.put("7 of Cups", "Disappointment, disillusionment, facing harsh realities");
        tarotCards.put("6 of Cups", "Harmony, balance, sharing emotions freely");
        tarotCards.put("5 Of Cups", "Loss, grief, letting go of attachments");
        tarotCards.put("4 of Cups", "Introspection, reflection, processing emotions");
        tarotCards.put("3 of Cups", "Celebration, joy, abundance in love and life");
        tarotCards.put("2 of Cups", "Choice, indecision, weighing emotional options");

        tarotCards.put("Ace of Swords", "Clarity, insight, cutting through illusions");
        tarotCards.put("King of Swords", "Intellect, strategy, decisive action");
        tarotCards.put("Queen of Swords", "Communication, truth, speaking your mind");
        tarotCards.put("Knight of Swords", "Courage, facing challenges head-on, defending your beliefs");
        tarotCards.put("Page of Swords", "Curiosity, learning, questioning established ideas");
        tarotCards.put("10 of Swords", "Transformation endings, letting go of the past");
        tarotCards.put("9 of Swords", "Cruelty, severing ties, releasing negativity");
        tarotCards.put("8 of Swords", "Delay, frustration, feeling stuck in a rut");
        tarotCards.put("7 of Swords", "Deception, betrayal, facing hidden truths");
        tarotCards.put("6 of Swords", "Balance, negotiation, finding common ground");
        tarotCards.put("5 of Swords", "Defeat, surrender, learning from setbacks");
        tarotCards.put("4 of Swords", "Contemplation, mental rest, strategizing");
        tarotCards.put("3 of Swords", "Communication, conflict, expressing your ideas");
        tarotCards.put("2 of Swords", "Duality, indecision, weighing intellectual options");

        tarotCards.put("Ace of Pentacles", "Material growth, new opportunities, building foundations");
        tarotCards.put("King of Pentacles", "Security, stability, building wealth and success");
        tarotCards.put("Queen of Pentacles", "Practicality, resourcefulness, groundedness");
        tarotCards.put("Knight of Pentacles", "Hard work, determination, achieving goals");
        tarotCards.put("Page of Pentacles", "Learning, apprenticeship, building skills");
        tarotCards.put("10 of Pentacles", "Abundance, achievement, reaping the rewards of your efforts");
        tarotCards.put("9 of Pentacles", "Contentment, satisfaction, enjoying your success");
        tarotCards.put("8 of Pentacles", "Security, stability, protection of resources");
        tarotCards.put("7 of Pentacles", "Planning, organizing, setting goals");
        tarotCards.put("6 of Pentacles", "Generosity, sharing, giving back");
        tarotCards.put("5 of Pentacles", "Loss, financial setbacks, re-evaluating priorities");
        tarotCards.put("4 of Pentacles", "Material stability, practicality, building a secure future");
        tarotCards.put("3 of Pentacles", "Growth, expansion, multiplying your resources");
        tarotCards.put("2 of Pentacles", "Balance, choices, weighing material options");



    }
}
