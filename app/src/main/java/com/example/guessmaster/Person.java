//Name: Johnnie Tse, Student number: 20366054
package com.example.guessmaster;



//define concrete subclass 'Person' and extends Entity
public class Person extends Entity{


    //declare an instance variable 'gender' as a string
    private String gender;


    //created a constructor for initializing Person with entity's name, entity's birth date, gender, and difficulty
    public Person(String name, Date born, String gender, double difficulty) {

        //called the constructor of the superclass 'Entity' for initializing inherited attributes
        super(name, born, difficulty);

        //initialize 'gender' attribute
        this.gender = gender;
    }


    //Copy constructor for preventing privacy leaks and for invoking the copy constructor in its parent class
    public Person(Person copy) {

        //called the copy constructor in the superClass 'Entity' for initializing inherited attributes again
        super(copy);

        //initialize 'gender' attribute with copied object's value
        this.gender = copy.gender;
    }


    //define a clone method for creating deep copy of the Person object
    public Person clone() {
        return new Person(this);
    }


    //override toString method in order to represent Person as a string
    public String toString() {
        return (super.toString() + "\nGender: " + gender);
    }

    //implement the 'entityType' method to return a string that is an entityType
    public String entityType() {
        return ("This entity is a person!");
    }

}
