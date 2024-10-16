//Name: Johnnie Tse, Student number: 20366054

package com.example.guessmaster;




//import necessary packages to be used in the code
import android.os.Bundle;

import android.view.View;

//import the widget class object as we will be using TextView, EditText, Button, and ImageView
//So we will add this: 'import android.widget.*;'
import android.widget.*;

import android.content.DialogInterface;







//import androidx packages
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;





//import Random class
import java.util.Random;



//specify the GuessMaster as an activiy class using the AppCompatActivity as stated in the assignment instructions
public class GuessMaster extends AppCompatActivity {


    //defining view components in the class-level of the GuessMaster class
    private TextView entityName;
    private TextView ticketsum;

    private TextView guessMasterTitle;
    private Button guessButton;
    private EditText userIn;
    private Button btnclearContent;
    private String user_input;
    private ImageView entityImage;
    String answer;





    //copying the instances and variables from the GuessMaster file in Assignment 2 and paste them in the class-level of the GuessMaster class too
    private int numOfEntities;
    private Entity[] entities;
    private int[] tickets;
    private int numOfTickets;
    String entName;
    int entityid = 0;
    int currentTicketWon = 0;

    private int totalTicketNum = 0;














    //the onCreate method is called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        //defining the layout file to be used by the activity
        //set the xml as the activity UI view
        setContentView(R.layout.activity_guess_activity);


        //applying window insets listener to the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });






        //initializing entities array
        numOfEntities = 0;
        entities = new Entity[10];

        //creating entity objects right after the view components
        Country usa= new Country("United States", new Date("July", 4, 1776), "Washingston DC", 0.1);
        Person myCreator= new Person("myCreator", new Date("May", 26, 2004), "Male", 1);
        Politician trudeau = new Politician("Justin Trudeau", new Date("December",25,1971), "Male", "Liberal", 0.25);
        Singer dion= new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November",6,1981), 0.5);



        addEntity(usa);
        addEntity(myCreator);
        addEntity(trudeau);
        addEntity(dion);


        //defining the view components
        entityName = (TextView) findViewById(R.id.entityName);
        //TextView for total tickets
        ticketsum = (TextView) findViewById(R.id.ticket);
        guessMasterTitle = (TextView) findViewById(R.id.guessMasterTitle);
        //specify the button in the view
        guessButton = (Button) findViewById(R.id.btnGuess);
        //EditText for user input
        userIn = (EditText) findViewById(R.id.guessinput);
        btnclearContent = (Button) findViewById(R.id.btnClear);
        entityImage = (ImageView) findViewById(R.id.entityImage);


        //setting GuessMaster title and total tickets
        //Now, since the assignment did not mention where we should update a text view to display the total number of tickets before actually playing the game with 'playGame()', we do this:
        guessMasterTitle.setText("GuessMaster");
        ticketsum.setText("Total Tickets: " + totalTicketNum);










        //setting OnClickListener action for the clear button

        btnclearContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeEntity();
            }

        });


        //setting OnClickListener action for the guess button
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // playing game
                playGame();
            }
        });



        //add final keyword so that we can access the class within.
        final GuessMaster gm = new GuessMaster();

        //welcome the user to the game
        welcomeToGame(entities[entityid]);


        updateEntityInfo();














    }






    //helper method
    //this method is intended to add a new entity to the entities array list
    public void addEntity(Entity entity) {
        //parameter entity to newEntity


        //Add a clone copy of the entity to the entities array list with the use of the clone method()
        entities[numOfEntities++] = entity.clone();



    }





    //this method is intended to play the guessing game regarding to the given entity for the parameter
    public void playGame() {



        //date object for getting the birth date of the given entity
        Date entityBornDate = entities[entityid].getBorn();


        //Name of the entity to be guessed in the entityName textview
        entityName.setText(entities[entityid].getName());


        //Get Input from the EditText
        answer = userIn.getText().toString();
        answer = answer.replace("\n", "").replace("\r", "");
        Date date = new Date(answer);

        //check if the user's inputted guess date is later than the entity's birthday using the
        //'precedes(Date otherDate)' method
        if(date.precedes(entityBornDate)) {
            //print out a message to notify the user that his/her guess is incorrect and ask him/her to
            //try to input a later date instead
            showIncorrectGuessDialog("Try a later date.");
        }


        //check if the user's inputted guess date is earlier than the entity's birthday using the
        //'precedes(Date otherDate)' method
        else if(entityBornDate.precedes(date)) {
            //print out a message to notify the user that his/her guess is incorrect and ask him/her to
            //try to input an earlier date instead
            showIncorrectGuessDialog("Try an earlier date.");
        }

        //if the user's inputted guess date matches the entity's birthday, then it will print out a
        //message stating that the user got his/her guess right
        else{


            //Use alert here to let user know they have won

            AlertDialog.Builder wonAlert = new AlertDialog.Builder(this);
            wonAlert.setTitle("You won");
            //alert message
            wonAlert.setMessage("BINGO! " + entities[entityid].closingMessage());
            wonAlert.setCancelable(false);
            wonAlert.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {


                    //adding the awarded ticket to the Toast.makeText() using the getAwardedTicketNumber() method in the Entity class

                    currentTicketWon = entities[entityid].getAwardedTicketNumber();
                    Toast.makeText(getBaseContext(), "Bingo! You won " + currentTicketWon + " tickets!", Toast.LENGTH_LONG).show();

                    totalTicketNum += currentTicketWon;
                    //using the setText() method to update the ticketsum textview with the total ticket obtained according to the instruction in the assignment.
                    ticketsum.setText("Total Tickets: " + totalTicketNum);




                    //Call the ContinueGame() method inside the onClick() method
                    //of the DialogInterface.
                    ContinueGame();

                }
            });

            AlertDialog wonDialog = wonAlert.create();
            wonDialog.show();







        }








    }


    //Continue Game Method - This method gets another Entity randomly
    //Updates the Image view and the Entity Name Field
    public void ContinueGame() {
        entityid = genRandomEntityId();

        Entity entity = entities[entityid];

        entName = entity.getName();

        //Call the ImageSetter method
        //Change the input parameter of this afterwards
        ImageSetter(entities[entityid]);

        //Print the name of the entity to be guessed
        //in the entityName textview
        entityName.setText(entName);


        //Clear Previous Entry
        userIn.getText().clear();
    }












    //helper method that generates random entity index
    public int genRandomEntityId() {

        //create an object of type Random
        Random rnd = new Random();

        //rndm is the short-form for the term 'random'
        //generate random numbers using the 'nextInt' method to get a random number between 0 and numberOfEntities
        return rnd.nextInt(numOfEntities);


    }






    //method to clear user entries from the userIn EditText and randomly choose another entity
    private void changeEntity() {
        // Clear user entries from the userIn EditText
        userIn.setText("");

        // Randomly choose another entity
        entityid = genRandomEntityId();

        updateEntityInfo();

    }


    //method to set the image based on the entity type
    private void ImageSetter(Entity entity) {

        if(entity instanceof Country){
            entityImage.setImageResource(R.drawable.usaflag);
        }

        else if(entity instanceof Politician) {
            entityImage.setImageResource(R.drawable.justint);
        }

        else if(entity instanceof Singer) {
            entityImage.setImageResource(R.drawable.celidion);
        }

        else if(entity instanceof Person) {
            entityImage.setImageResource(R.drawable.my_creator);
        }


    }


    //method to welcome the user to the game
    private void welcomeToGame(Entity entity) {
        //Welcome Alert
        AlertDialog.Builder welcomealert = new AlertDialog.Builder(this);
        welcomealert.setTitle("GuessMaster Game v3");
        //print the welcome message to screen using an AlertDialog
        welcomealert.setMessage(entity.welcomeMessage());
        welcomealert.setCancelable(false); //No Cancel Button

        welcomealert.setNegativeButton("START GAME", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Game is Starting...Enjoy!", Toast.LENGTH_SHORT).show();
            }
        });

        //Show Dialog
        AlertDialog dialog = welcomealert.create();
        dialog.show();

    }


    //method to show incorrect guess dialog
    private void showIncorrectGuessDialog(String message) {
        AlertDialog.Builder incorrectAlert = new AlertDialog.Builder(this);
        incorrectAlert.setTitle("Incorrect");
        incorrectAlert.setMessage(message);
        incorrectAlert.setCancelable(false);
        incorrectAlert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // We want it to do nothing when the user's guess is wrong
            }
        });


        AlertDialog incorrectDialog = incorrectAlert.create();
        incorrectDialog.show();
    }





    private void updateEntityInfo() {
        //set the text of the entityName TextView to the name of the current entity
        entityName.setText(entities[entityid].getName());
        //update the ImageView with appropriate image based on the entity being displayed
        ImageSetter(entities[entityid]);
    }



















}


