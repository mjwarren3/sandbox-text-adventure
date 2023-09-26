import Controller.Controller;
import Model.Model;
import View.View;

/* ABOUT THIS PROGRAM
 * The sandbox program walks a user through creating a startup from start to finish
 * They are prompted generally for ideas on what they should do to create a business
 * If they identify the correct step (based on valid verb-noun combination), they move on to the next phase
 * The program continues until the user successfully completes all of the stages
 * */

/*
* Controller: Controls interactions between View and Model - responsible for workflow of program
* Model: Holds data for the program (user inputs, valid verb-noun lists)
* View: Responsible for gathering user input and displaying messages to user
* */

public class Main {

    public static void main(String[] args) {
        View view = new View(); // Creates a new View object
        Model model = new Model(); // Creates a new Model object
        Controller controller = new Controller(view, model); // Creates a new controller object (with view and model as inputs)
        controller.startGame(); // Starts the Sandbox game
    }
}