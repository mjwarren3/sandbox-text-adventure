package Controller;
import Model.Model;
import View.View;
import java.util.List;

/* The Controller class is responsible for most of the functionality of the program
* It interacts with the model to set and get data, and it interacts with the View to read in or display messages
* This class is split up into a few sections
* 1) startGame - This is the primary flow of the program. It utilizes methods from sections 2 and 3
* 2) Methods for getting / displaying data - Between each scene, these methods will interact with the user to get
* information about the startup they are making
* 3) Scene class - This is a class within the Controller class that runs each scene. It requires an inputted verb and noun list
* and it checks the user input against those verb and noun lists
 */

public class Controller {
    public View view;
    public Model model;

    // Constructor
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    /* PRIMARY GAME FUNCTIONALITY
     * This determines the actual flow of the game and uses other functions from the Controller Class, Scene Class, View, and Model Classes*/
    /* All methods and variables referenced will be further commented in the locations in which they are defined*/
    public void startGame() {

        introGame(); // Displays intro text to user

        /*NOTE: All five scenes follow a similar structure - functionality commented in the first scene*/

        // Scene 1 - Ideation (tests noun-verb combinations, then gathers info related to this phase)
        List<String> verbIdeate = model.verbListIdeate; // Gets the list of verbs from the model
        List<String> nounIdeate = model.nounListIdeate; // Gets the list of nouns from the model
        Scene sceneIdeate = new Scene(verbIdeate, nounIdeate); // Creates a new scene object
        sceneIdeate.startScene(); // Checks whether user inputs a valid verb-noun combination and provides responses back

        getBusinessInfo();

        // Scene 2 - Fundraising (tests noun-verb combinations, then gathers info related to this phase)

        List<String> verbRaise = model.verbListRaise;
        List<String> nounRaise = model.nounListRaise;
        Scene sceneRaise = new Scene(verbRaise, nounRaise);
        sceneRaise.startScene();

        getInvestmentInfo();

        // Scene 3 - Hiring (tests noun-verb combinations, then gathers info related to this phase)

        List<String> verbHire = model.verbListHire;
        List<String> nounHire = model.nounListHire;
        Scene sceneHire = new Scene(verbHire, nounHire);
        sceneHire.startScene();

        getTeamInfo();

        // Scene 4 - Building Product (tests noun-verb combinations, then gathers info related to this phase)

        List<String> verbBuild = model.verbListBuild;
        List<String> nounBuild = model.nounListBuild;
        Scene sceneBuild = new Scene(verbBuild, nounBuild);
        sceneBuild.startScene();

        getBuildInfo();

        // Scene 5 - Selling Product (tests noun-verb combinations, then gathers info related to this phase)

        List<String> verbSell = model.verbListSell;
        List<String> nounSell = model.nounListSell;
        Scene sceneSell = new Scene(verbSell, nounSell);
        sceneSell.startScene();

        getSellInfo();

        // Summarizing story back to the user

        summarizeBusiness();
    }

    /* INTRO
    * This function displays text to the user to start the game, it asks them to type "y" to begin*/
    public void introGame() {
        // Display intro text
        view.displayMessage("Welcome to Sandbox, the startup accelerator of the future!");
        view.displayMessage("At Sandbox, you will be creating a tech startup from ground zero.");
        view.displayMessage("But not to worry, we will be assisting you along the way as your startup advisor.");
        view.displayMessage("");
        view.displayMessage("Are you ready to get started (type 'y' if yes)? Reminder, you may type 'quit' at any time to exit.");

        String firstResponse = view.inputMessage();

        while (!firstResponse.equals("y")) {
            view.displayMessage("Type y to get started!");
            firstResponse = view.inputMessage();
        }
    }

    /*GATHERING BUSINESS INFORMATION
    * These parts of the controller are responsible for gathering information from the user about their business
    * and using that information to set variable values in the Model.
    * Users will go through this flow after correctly identifying the right verb-noun combination for a stage
    * They are not commented separately, since they all follow a similar structure of outputting / receiving messages*/

    public void getBusinessInfo() {
        view.displayMessage("That's a wonderful idea! Let's capture some information about your company idea first! Please fill out the responses below:");
        view.displayMessage("");
        view.displayMessage("Company name: ");
        model.setCompanyName(view.inputMessage());
        view.displayMessage("Company type: ");
        model.setCompanyType(view.inputMessage());
        view.displayMessage("Company mission: ");
        model.setCompanyMission(view.inputMessage());
        view.displayMessage("Great, you've now come up with a mission and company name!");
        view.displayMessage("");
    }

    public void getInvestmentInfo() {
        view.displayMessage("It is a great idea to raise some money! How much money do you want to raise? Please enter a whole number in USD:");
        model.setInvestmentAmount(view.inputInteger());
        view.displayMessage("Who do you want to raise capital from? Some ideas include Angel Investor, Venture Capital, Friends And Family, Myself:");
        model.setInvestor(view.inputMessage());
        view.displayMessage("Awesome, looks like you have the capital raised to start your company!");
        view.displayMessage("");
    }

    public void getTeamInfo() {
        view.displayMessage("You definitely need a team! Who do you want to be your first hire? Enter the name of a role such as 'software developer' or 'salesperson':");
        model.setFirstHire(view.inputMessage());
        view.displayMessage("You've officially got yourself a team!");
        view.displayMessage("");
    }

    public void getBuildInfo() {
        view.displayMessage("That's a good next step! What type of programming language do you want to use to build your product?");
        model.setProgrammingLanguage(view.inputMessage());
        view.displayMessage("How long do you think it will take to build your product? Examples include '3 Months' or '1 year'");
        model.setBuildTime(view.inputMessage());
        view.displayMessage("Sounds like a plan! You successfully built your product!");
        view.displayMessage("");
    }

    public void getSellInfo(){
        view.displayMessage("Of course! You'll need to sell your product to make money! Where do you want to sell your product? Examples include online, in-store");
        model.setChannel(view.inputMessage());
        view.displayMessage("How much do you want to sell your product for? Enter a whole number in USD:");
        model.setPrice(view.inputInteger());
        view.displayMessage("That seems like a good price! Customers have started to buy your product!");
        view.displayMessage("");
    }

    /* SUMMARIZING BUSINESS
     * This function summarizes the entire story back to the user at the end of the program
     * It gets information from the Model and displays it back using the View object
     * */

    public void summarizeBusiness() {
        view.displayMessage("Wow, you've come along way since you joined Sandbox!");
        view.displayMessage("");
        view.displayMessage("You started a company called " + model.getCompanyName() + " in the " + model.getCompanyType() + " industry, with a mission to " + model.getCompanyMission()+"!");
        view.displayMessage("");
        view.displayMessage("Then you raised $" + model.getInvestmentAmount() + " from " + model.getInvestor());
        view.displayMessage("");
        view.displayMessage("Then hired your first employee! Your first employee was a " + model.getFirstHire());
        view.displayMessage("");
        view.displayMessage("You built your product in " + model.getProgrammingLanguage() + " in " + model.getBuildTime());
        view.displayMessage("");
        view.displayMessage("And finally you decided to sell your product for $" + model.getPrice() + " at the following locations: " + model.getChannel());
        view.displayMessage("");
        view.displayMessage("I would say this is quite the success! We are very proud of what you were able to accomplish at Sandbox!");
    }

    /* SCENE CLASS
     * This class takes an inputted verb list and noun list and creates a flow (using model and controller)
     * to test whether the user is inputting a correct verb and noun combination
     * If a user does not get a valid noun, verb, or noun-verb combo, an apppropriate message is displayed to the user
     * It continues until the users enters a valid response (boolean correct_response)
     * */
    public class Scene {

        public List<String> verb_list; // Valid verbs
        public List<String> noun_list; // Valid nouns
        public boolean found_verb; // Whether verb was found
        public boolean found_noun; // Whether noun was found
        public boolean correct_response; // Whether valid verb-noun combo entered
        public String the_noun; // The correct noun that was entered
        public String the_verb; // The correct verb that was entered
        public StringBuilder verb_string; // All verbs in the list, displayed as a string
        public StringBuilder noun_string; // All nouns in the list, displayed as a string

        // Constructor
        public Scene(List<String> verb_list, List<String> noun_list) {
            this.verb_list = verb_list;
            this.noun_list = noun_list;
            this.found_noun = false;
            this.found_verb = false;
            this.the_verb = "";
            this.the_noun = "";
            this.verb_string = model.getStringFromList(verb_list);
            this.noun_string = model.getStringFromList(noun_list);
            this.correct_response = false;
        }

        // Scene Flow
        public void startScene() {

            view.displayMessage("So... what do you think you should do next?");

            while (!correct_response) {
                String userInput = view.inputLowerCaseMessage(); // Lower case to check against verb and noun lists
                String[] words = userInput.split(" ");

                List<String> verb_list = this.verb_list;
                List<String> noun_list = this.noun_list;

                boolean found_verb = false;
                boolean found_noun = false;

                String the_verb = "";
                String the_noun = "";

                StringBuilder verb_string = model.getStringFromList(verb_list);
                StringBuilder noun_string = model.getStringFromList(noun_list);

                // For each word in the user input
                for (String word : words) {
                    // Checks if user entered a valid verb
                    if (!found_verb) {
                        for (String verb : verb_list) {
                            if (verb.equals(word)) {
                                found_verb = true;
                                the_verb = verb;
                                break;
                            }
                        }
                    }

                    // Checks if user entered a valid noun
                    if (!found_noun) {
                        for (String noun : noun_list) {
                            if (noun.equals(word)) {
                                found_noun = true;
                                the_noun = noun;
                                break;
                            }
                        }
                    }
                }

                // Logic for response based on whether noun, verb, or noun-verb is valid
                if (found_verb && found_noun) {
                    view.displayMessage("");
                    correct_response = true;
                } else if (found_verb && !found_noun) {
                    view.displayMessage("It is a great idea to " + the_verb + " something!");
                    view.displayMessage("Maybe you should try to " + the_verb + " one of these instead: " + noun_string);

                } else if (!found_verb && found_noun) {
                    view.displayMessage("It is a great idea to do something with a " + the_noun + "!");
                    view.displayMessage("Maybe you should try to do one of these instead: " + verb_string);
                    view.displayMessage("Could you do any of those things with a " + the_noun + "? Maybe try again!");
                } else {
                    view.displayMessage("Ah it seems like you are unsure of what to do next...");
                    view.displayMessage("Maybe you want to " + verb_string + " something...?");
                }
            }

        }


    }
}


