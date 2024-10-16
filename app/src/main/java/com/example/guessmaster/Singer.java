//Name: Johnnie Tse, Student number: 20366054
package com.example.guessmaster;


//define concrete subclass 'Singer' and extends Person
public class Singer extends Person{

    //declare the instance variable 'debutAlbum' as a string
    private String debutAlbum;
    //declare the instance variable 'debutAlbumReleaseDate' of type 'Date'
    private Date debutAlbumReleaseDate;


    //created a constructor for initializing Politician with name, birth date, gender, debut album, debut album release date, and difficulty
    public Singer(String name, Date born, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {

        //called the constructor of the superclass 'Person' for initializing inherited attributes
        super(name, born, gender, difficulty);

        //initialize 'debutAlbum' attribute
        this.debutAlbum = debutAlbum;

        //initialize 'debutAlbumReleaseDate' attribute
        this.debutAlbumReleaseDate = debutAlbumReleaseDate;
    }


    //Copy constructor for preventing privacy leaks and for invoking the copy constructor in its parent class
    public Singer(Singer copy) {

        //called the copy constructor in the superClass 'Person' for initializing inherited attributes again
        super(copy);

        //initialize 'debutAlbum' attribute with copied object's value
        this.debutAlbum = copy.debutAlbum;

        //create new Date object to prevent privacy leak
        this.debutAlbumReleaseDate = new Date(copy.debutAlbumReleaseDate);

    }


    //define a clone method for creating deep copy of the Singer object
    public Singer clone() {
        return new Singer(this);

    }

    //override toString method in order to represent Singer as a string
    public String toString() {
        return (super.toString() + "\nDebut Album: " + debutAlbum + "\nDebut Album Release Date: " + debutAlbumReleaseDate);


    }

    //implement the 'entityType' method to return a string that is an entityType
    public String entityType() {
        return ("This entity is a singer!");

    }
}
