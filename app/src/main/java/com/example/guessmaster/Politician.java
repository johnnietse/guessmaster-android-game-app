//Name: Johnnie Tse, Student number: 20366054
package com.example.guessmaster;



//define concrete subclass 'Politician' and extends Person
public class Politician extends Person{

    //declare an instance variable 'party' as a string
    private String party;

    //created a constructor for initializing Politician with name, birth date, gender, party, and difficulty
    public Politician(String name, Date born, String gender, String party, double difficulty) {

        //called the constructor of the superclass 'Person' for initializing inherited attributes
        super(name, born, gender, difficulty);

        //initialize 'party' attribute
        this.party = party;

    }


    //Copy constructor for preventing privacy leaks and for invoking the copy constructor in its parent class
    public Politician(Politician copy) {

        //called the copy constructor in the superClass 'Person' for initializing inherited attributes again
        super(copy);

        //initialize 'party' attribute with copied object's value
        this.party = copy.party;
    }


    //define a clone method for creating deep copy of the Politician object
    public Politician clone() {
        return new Politician(this);
    }


    //override toString method in order to represent Politician as a string
    public String toString() {
        return (super.toString() + "\nParty: " + this.party);
    }


    //implement the 'entityType' method to return a string that is an entityType
    public String entityType() {
        return ("This entity is a politician!");
    }
}
