package org.example;

// Declares a public class named "TarotCard"
// This class represents a model for a Tarot card with its name and meaning
public class TarotCard {
    //Declares a private instance variable 'name' of type String. It holds the meaning of the Tarot card.
   // Being private, it can only be accessed within this class
    private String name;

    // Declares a private instance variable 'meaning' of type String. It holds the meaning of the Tarot card.
    // Similar to 'name', it is private and only accessible in this class
    private String meaning;

    // Defines a constructor for the TarotCard class that takes two parameters: 'name' and 'meaning'
    // Constructors are special methods used to initialize new objects
    public TarotCard(String name, String meaning) {
        // The 'this keyword is used to refer to the current object.
        // Here, it's used to differentiate between the instance variables and parameters of the constructor
        // Assign the value of the 'name' parameter to the instance variable 'name'.
        this.name = name;
        //Assign the value of the 'meaning' parameter to the instance variable 'meaning'.
        this.meaning = meaning;
    }

    //Define a public method 'getName' that returns a String.
    // This is a getter method for the 'name' instance variable.
    // Public methods can be called from outside the class, providing controlled access to private variables.
    public String getName() {
        // Return the value of the 'name' instance variable.
        return name;
    }

    // Define a public method 'setName' that takes a String parameter 'name'.
    // This is a setter method for the 'name' instance variable
    // It allows the 'name' of a TarotCard object to be modified after it has been created
    public void setName(String name) {
        // Assign thr value of the 'name' parameter to the instance variable 'name'.
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}


