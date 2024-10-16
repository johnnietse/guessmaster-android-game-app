//Name: Johnnie Tse, Student number: 20366054
package com.example.guessmaster;



//define an abstract class named Entity that holds information of a named entity
//implements the Cloneable interface as the 'Entity' class has a clone method
public abstract class Entity implements Cloneable{

    //these two instance variables are used to hold name and birth date of entity
    private String name;
    private Date born;

    //define another instance variable called difficulty according to assignment 2
    //the defined variable is a double
    //this variable is used to calculate the number of tickets a user will receive
    private double difficulty;


    //created a constructor that initializes objects for Entity with the provided name and birth date
    public Entity(String name, Date born, double difficulty) {
        this.name = name;
        this.born = born;
        //additional line for initializing objects for Entity with difficulty
        this.difficulty = difficulty;


    }

    //created a copy constructor for Entity that prevents privacy leak issue
    public Entity(Entity copy) {


        //checking if the parameter 'copy' is null
        if(copy == null) {

            //If 'copy' is null, then print the message below
            System.out.println("Fatal Error. It is not possible to copy from a null entity.");
            //Terminate the program with exit code 0
            System.exit(0);
        }


        this.name = new String(copy.name);
        this.born = new Date(copy.born);

		/*
		the 'difficulty' variable is a primitive data type (a double),
		and primitive data types are immutable in Java, so there is no risk
		of privacy leak associated with it
		*/
        this.difficulty = copy.difficulty;
    }


    //this mutator method is for setting the name of the entity
    public void setName(String name) {

        this.name = new String(name);

    }

    //this mutator method is for setting the birth date of the entity
    public void setBorn(Date born) {

        this.born = new Date(born);

    }




    //this accessor method is for getting the name of the entity
    public String getName() {

        return new String(name);

    }

    //this accessor method is for getting the birth date of the entity
    public Date getBorn() {

        return new Date(born);

    }






    //define a method to compare the name and the birth date (content) of two individual entities to see if they are equal
    public boolean equals(Entity entity) {
        if(entity == null) {
            return false;
        }

        else {
            return (name.equals(entity.name) && born.equals(entity.born));
        }

    }




    //new defined public method that returns the number of tickets as integer if the user correctly guesses an entity's birth date

    //this method also computes the number of tickets with 'difficulty'
    public int getAwardedTicketNumber() {
        double ticketVal = (this.difficulty*100);
        //type-cast 'ticketVal' to be an integer because ticket number is an integer
        int ticketNum = (int) ticketVal;

        return ticketNum;
    }



    //defined method that returns the content of an entity as a string
    public String toString() {

        return "\nName: " + this.name + "\nBorn at: " + this.born.toString();
    }



    //abstract method that does not take any parameter, returns a String, and gets the type of the entity
    //It will be used in other derived classes for returning a description of the entity type
    public abstract String entityType();

    //abstract method that clones an entity and does not take any parameter
    //Its return type is Entity
    public abstract Entity clone();


    //defined method for generating the welcoming message
    //the method also invokes 'entityType' to generate a proper welcoming message
    public String welcomeMessage() {
        return ("Welcome! Let’s start the game! " + this.entityType());
    }

    //defined method for generating a closing message
    //the method also invokes 'toString' to print out the related information of an entity
    public String closingMessage() {
        return ("Congratulations! The detailed information of the entity you guessed is: " + this.toString());
    }




}
