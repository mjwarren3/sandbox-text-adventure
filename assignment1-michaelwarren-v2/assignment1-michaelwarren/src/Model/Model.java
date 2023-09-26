package Model;
import java.util.List;

/*
* There are three primary areas of my model class
* Variables - These are primarily input from the user and summarized at the end of the program
* Verb + Noun Lists - These are predefined combinations of verbs and nouns that can be used during the program
* Getters - Primarily for getting string outputs from the variables
* Setters - Primarily for setting string values for the variables
* */

public class Model {

    /* CLASS VARIABLES
    * These are items of information that we will gather from the startup founder throughout their journey
    * It will be summarized back to the user at the end of the program
    * */

    public String companyType;
    public String companyName;
    public String companyMission;
    public String investor;
    public int investmentAmount;
    public String firstHire;
    public int price;
    public String channel;
    public String programmingLanguage;
    public String buildTime;

    /* VERB LISTS + NOUN LISTS
     * There are 20 verbs that the user may use throughout the story
     * There are 22 nouns that the user may use throughout the story
     * The user goes through the startup in stages, so they must enter the verb-noun combinations at the right stage in order to advance
     * Source: https://www.javaguides.net/2019/12/java-9-listof-method-create-immutable.html#:~:text=of()%20Method%20%2D%20Create%20Immutable%20List%20Example,-Author%3A%20Ramesh%20Fadatare&text=With%20Java%209%2C%20new%20factory,and%20in%20a%20concise%20way.
     * I used the list.of method to create lists of items
     * I decided not to use setters and getters for these, since they are defined by the programmer as constants
     * */

    /* Ideation Stage - verb + noun lists (defined above)*/
    public List<String> verbListIdeate = List.of("brainstorm", "think", "determine", "decide", "ideate", "choose", "pick");
    public List<String> nounListIdeate = List.of("product", "company", "idea", "service", "name", "mission");

    /* Financing Stage - verb + noun lists (defined above)*/
    public List<String> verbListRaise= List.of("fundraise", "raise");
    public List<String> nounListRaise = List.of("investment", "capital", "money", "cash");

    /* Hiring Stage - verb + noun lists (defined above)*/
    public List<String> verbListHire = List.of("hire", "find");
    public List<String> nounListHire = List.of("team", "cofounder", "cofounders", "employee", "employees");

    /* Building Stage - verb + noun lists (defined above)*/
    public List<String> verbListBuild = List.of("create", "build", "make", "start", "write", "launch");
    public List<String> nounListBuild = List.of("application", "app", "product", "code", "service");

    /* Selling Stage - verb + noun lists (defined above)*/
    public List<String> verbListSell = List.of("sell", "advertise", "grow");
    public List<String> nounListSell = List.of("product", "service", "app");

    /* SETTERS
    * All of these methods do similar things set a variable value based on user input
    * The variable that is getting set should also be self explanatory based on the method name (would be repetitive to comment each line)
    * */

    public void setCompanyName(String name){
        this.companyName = name;
    }
    public void setCompanyMission(String mission){
        this.companyMission = mission;
    }
    public void setCompanyType(String type){
        this.companyType = type;
    }
    public void setInvestmentAmount(int i) {this.investmentAmount = i;}
    public void setInvestor(String i) {this.investor = i;}
    public void setFirstHire(String i) {this.firstHire = i;}
    public void setProgrammingLanguage(String i) {this.programmingLanguage = i;}
    public void setBuildTime(String i) {this.buildTime = i;}
    public void setChannel(String i) {this.channel = i;}
    public void setPrice(int i) {this.price = i;}


    /* GETTERS
     * All of these methods do similar things: Get a variable's value
     * The variable that is beint retrieved should also be self explanatory based on the method name (would be repetitive to comment each line)
     * */

    public String getCompanyName(){
        return this.companyName;
    }
    public String getCompanyMission(){
        return this.companyMission;
    }
    public String getCompanyType(){
        return this.companyType;
    }
    public int getInvestmentAmount() {return this.investmentAmount;}
    public String getInvestor() {return this.investor;}
    public int getPrice() {return this.price;}
    public String getChannel() {return this.channel;}
    public String getFirstHire() {return this.firstHire;}
    public String getProgrammingLanguage() {return this.programmingLanguage;}
    public String getBuildTime() {return this.buildTime;}

    /* METHODS
    * I decided to include this in the Model object, since it is used to create new data type from existing data,
    * and it does not require interaction with the controller or view */

    /*This method takes an input list of strings and turns that list of strings into one string, separated by commas
    * It removes the last comma, so that it looks grammatically correct*/
    public StringBuilder getStringFromList(List<String> verb_list) {
        StringBuilder verb_string = new StringBuilder();
        for (String verb : verb_list) {
            verb_string.append(verb).append(", ");
        }

        verb_string.delete(verb_string.length() - 2, verb_string.length()); // Remove last comma and space

        return verb_string;
    }

}
