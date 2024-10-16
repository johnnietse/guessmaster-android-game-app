//Name: Johnnie Tse, Student number: 20366054
package com.example.guessmaster;



//define concrete subclass 'Country' and extends Entity
public class Country extends Entity{

    //declare an instance variable 'capital' as a string
    private String capital;

    //created a constructor for initializing Country with entity's name, entity's birth date, capital, and difficulty
    public Country(String name, Date born, String capital, double difficulty) {


        //called the constructor of the superclass 'Entity' for initializing inherited attributes
        super(name, born, difficulty);
        //initialize 'capital' attribute
        this.capital = capital;
    }

    //Copy constructor for preventing privacy leaks and for invoking the copy constructor in its parent class
    public Country(Country copy) {

        //called the copy constructor in the superClass 'Entity' for initializing inherited attributes again
        super(copy);

        //initialize 'capital' attribute with copied object's value
        this.capital = copy.capital;

    }

    //define a clone method for creating deep copy of the Country object
    public Country clone() {
        return new Country(this);
    }


    //override toString method in order to represent Country as a string
    public String toString() {

        return (super.toString() + "\nCapital: " + capital);
    }

    //implement the 'entityType' method to return a string that is an entityType
    public String entityType() {
        return ("This entity is a country!");

    }




}
