
# GuessMaster - Android Game

GuessMaster is an Android-based guessing game where players guess the birthdates of famous entities such as celebrities, countries, and politicians. Originally a command-line game, this project introduces a graphical user interface (GUI) using Android Studio to enhance the player experience with intuitive interactions via an interface featuring TextViews, ImageViews, EditTexts, and Buttons.


## Features

- Guessing Game: Players guess the birthdates of entities such as celebrities, politicians, and countries.

- GUI Interaction: The game includes a simple Android-based GUI for user interaction, including buttons, text fields, and images.

- Alerts: Provides feedback to users via AlertDialog popups, informing them whether their guesses are correct or need to try again.

- Entity Images: Each entity has an associated image displayed during the game.

- Ticket System: Players earn tickets for correct guesses, which are displayed during gameplay.

## Key Components
- Java Classes: Reuse of existing classes (Date, Entity, Person, Politician, Country, Singer) from the previous versions of the GuessMaster game.

- Main Activity: The GuessMaster.java class serves as the main activity and handles the game logic.

- User Interface (UI): Designed using XML layout files in Android Studio to create a clean and engaging interface for the game.

## Project Structure
- GuessMaster.java: Main game logic and user interaction.

- activity_guess_master.xml: Layout file defining the UI components (TextViews, ImageViews, Buttons, EditTexts).

- Additional Java classes: Date, Entity, Person, Politician, Country, Singer are reused to define the entities in the game.

## How to Play
- Welcome Screen: The player is welcomed with a message and asked to guess the birthday of a randomly selected entity.

- Guessing the Date: The player's task is to enter a date into the input field and submit it.

- Feedback: The game responds with hints such as "Try an earlier date" or "Try a later date" if the guess is incorrect, or "BINGO!" if the player is correct.

- Winning Tickets: Players earn tickets for each correct guess, which are tracked and displayed.


## Project Setup
To set up and run the project:

1. Download the GuessMaster.zip file:

- Navigate to the .zip-file folder above and download the GuessMaster.zip file.

2. Unzip the File:

- Extract the contents of the downloaded file.

3. Open in Android Studio:

- Open Android Studio and select the unzipped project folder. The project already includes necessary resources such as images (in the drawable folder) for the game entities.

4. Build and Run:

- Build the project and run it on an Android emulator or a physical Android device to start playing the game.
