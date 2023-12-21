import java.util.Scanner;

// FIX wrap line length
public class cpt {
    // ---------------------------------------------------------------VARIABLES------------------------------------------
    // always declare them here, and with public static before the variable
    public static int healthStats = 100, happinessStats = 100, intelligenceStats = 50, ageStats = 1;
    public static double netWorth = 0;
    public static boolean beginnerInformation = false; // so beginner information runs once
    public static String command;
    public static boolean alive = true;
    public static boolean resetI = false;
    public static int commandCountStats = 1;

    // ----------------------------------------------------------------COMMANDS------------------------------------------------
    // where all the commands for the game are

    public static void randomAgeEvents() {
        if ((ageStats <= 3) && (ageStats >= 0)) { // baby events
            String[] babyEvents = { "pneumonia", "flu", "gotDropped", "noCake", "reallyGoodMilk", "newToy",
                    "learnedNewSkill", "gotAPet" };
            int random = (int) (8 * Math.random() + 1);
            random--;
            String event = babyEvents[random];
            callEventMethodBaby(event);
        }
    }

    // Method to dynamically call event methods
    public static void callEventMethodBaby(String eventName) {
        switch (eventName) {
            case "pneumonia":
                healthStats -= 10;
                System.out.println("You obtained pneumonia. -10% health. Your current health is: " + healthStats);
                break;
            case "flu":
                healthStats -= 10;
                System.out.println("You obtained the flu. -10% health. Your current health is: " + healthStats);
                break;
            case "gotDropped":
                intelligenceStats -= 50;
                System.out.println("You were dropped as a baby. -50% intelligence. Your current intelligence is: "
                        + intelligenceStats);
                break;
            case "noCake":
                happinessStats -= 30;
                System.out.println(
                        "You didnt get cake today. -30% happiness. Your current happiness is: " + happinessStats);
                break;
            case "reallyGoodMilk":
                healthStats += 20;
                System.out.println(
                        "Your mother gave you some milk and it tasted exqusite. +20% health. Your current happiness is: "
                                + healthStats);
                break;
            case "newToy":
                happinessStats += 30;
                System.out.println(
                        "Your parents bought you a new toy! +30% happiness. Your current happpiness is: "
                                + happinessStats);
                break;
            case "learnedNewSkill":
                intelligenceStats += 20;
                System.out
                        .println("You learned a new skill as a baby! +20% intelligence. Your currernt intelligence is: "
                                + intelligenceStats);
                break;
            case "gotAPet":
                happinessStats += 50;
                System.out.println(
                        "You got a pet dog! You named him Gojo Satoru. +50% happiness. Your current happiness is: "
                                + happinessStats);
                break;
            default:
                System.out.println("Gambling lesson #1: There are no losses, just intervals between winning");
        }
    }

    public static void stats() { // command to print out the stats of a player
        System.out.println("-------------------- STATS --------------------");
        System.out.println("Health: " + healthStats);
        System.out.println("Happiness: " + happinessStats);
        System.out.println("Intelligence: " + intelligenceStats);
        System.out.println("Networth: " + netWorth);
        System.out.println("Age: " + ageStats);
        System.out.println("Command Count: " + commandCountStats);
        System.out.println("----------------------------------------");
    }

    public static void leavegame() { // if the player wants to leave the game
        Scanner in = new Scanner(System.in); // needed in every method to call for a user input
        System.out.println("-------------------- ARE YOU SURE YOU WANT TO END THE GAME? (Y/N) --------------------");
        String reponse = in.nextLine();

        // checks if the user wants to quit or not
        if (reponse.equalsIgnoreCase("y")) { // ends the code
            alive = false;
            return;
        } else if (reponse.equalsIgnoreCase("n")) { // returns back to regular useage
            return;
        } else { // err message
            System.out.println("Please input Y or N, rerun the command to try again");
        }
        System.out.println("----------------------------------------");
    }

    public static boolean hilow() { // game to dictate if a player won or not
        Scanner in = new Scanner(System.in);
        int correctNum = (int) (25 * Math.random() + 1); // picks a random # between 1 and 25
        int numGuesses = 0; // guess count
        boolean winner = false; //
        int guess;
        // System.out.println("BLAHHHHHHHHHHHHHHHHHH" + correctNum); // only used for
        // debugging ------------------ REMOVE IN FINAL VERSION ------------------------
        while (numGuesses < 7) {
            System.out.println("Input a number between 1 and 25: ");
            guess = in.nextInt();
            numGuesses++;
            if (guess == correctNum) {
                System.out.println("Congrats, you win!");
                winner = true;
                numGuesses = 7;
                happinessStats++; // increases happiness due to a win
            } else if (guess > correctNum) {
                System.out.println("Too high, try again!");
            } else {
                System.out.println("Too low, try again!");
            }
        }
        if (!winner) {
            System.out.println("Oops, you lost. Sorry!");
            happinessStats--; // decreases happiness due to a loss
            System.out.println("The correct number is: " + correctNum);
        }
        return winner;
    }

    // ----------------------------------------------------------------MAIN---------------------------------------------
    public static void commandProcess(String command) {
        if (command.startsWith("!")) {
            String actualCommand = command.substring(1); // removes the first char of the variable, the exclamation mark
                                                         // this is to run all the different commands available
            switch (actualCommand) {
                case "stats":
                    resetI = true;
                    stats();
                    // resetI = true; // add this to every method in this switch if not an essential
                    // program, to balance the rapidly increasing age
                    return;
                case "help":
                    resetI = true;
                    System.out.println(
                            "The objective of the game is to make the most money, have the highest stats and live the longest, all using commands given to you.");
                    System.out.println("Use !commands to see all the different commands you can do");
                    System.out.println(
                            "You can perform commands at any time, unless currently in a command. You start at age 0 and you go up in age every 50 commands (though doing basic commands such as !stats will not increase this).");
                    System.out.println(
                            "Every time your age goes up, a random event can happen to you, based on your stats. For example, if you have low health, you have a higher chance of a bad event (such as sickness) occurring to you.");
                    System.out.println(
                            "You can increase your stats by performing commands, and winning games within those commands.");
                    return;
                case "commands":
                    resetI = true;
                    System.out.println("Available Functions:");
                    System.out.println("0. Commands - This one! Gives you a list of all the commands");
                    System.out.println("1. stats - Display available functions");
                    System.out.println("2. help - Request and save integers");
                    System.out.println("3. event - Ask for and save user's name");
                    System.out.println("4. beg - Display a menu and allow user to buy items");
                    System.out.println("5. increaseage - Quit the program");
                    System.out.println("6. gambling - Quit the program");
                    System.out.println("7. leavegame - Quit the program");
                case "event":
                case "increaseage":
                    Scanner in = new Scanner(System.in); // needed in every method to call for a user input
                    System.out.println(
                            "-------------------- ARE YOU SURE YOU WANT TO INCREASE YOUR AGE? (Y/N) --------------------");
                    String reponse = in.nextLine();

                    // checks if the user wants to quit or not
                    if (reponse.equalsIgnoreCase("y")) { // ends the code
                        ageStats++;
                        resetI = true;
                        System.out.println("You are " + ageStats + " years old");
                        randomAgeEvents();
                        return;
                    } else if (reponse.equalsIgnoreCase("n")) { // returns back to regular useage
                        return;
                    } else { // err message
                        System.out.println("Please input Y or N, rerun the command to try again");
                    }
                    System.out.println("----------------------------------------");
                    return;
                case "gambling":
                case "beg":
                    boolean winner = hilow();
                    if (winner == true) {
                        int winnings = (int) (1000 * Math.random() + 1);
                        netWorth += winnings;
                        System.out.println("You won: " + winnings);
                        System.out.println("Your new networth is: " + netWorth);
                    } else {
                        int winnings = (int) (1000 * Math.random() + 1);
                        netWorth -= winnings;
                        System.out.println("You lost: " + winnings);
                        System.out.println("Your new networth is: " + netWorth);
                    }
                    return;
                // randomize a number between 1 and 3 to play the different types of games
                case "leavegame":
                    resetI = true;
                    leavegame();
                    return;
                default:
                    System.out.println("Unknown command, make sure it exists and try again!");
            }
        } else {
            System.out.println("Unknown command, please make sure it exists and your command starts with \"!\"");
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        if (!beginnerInformation) {
            beginnerInformation = true;
            System.out.println("Welcome to this game, the rules are 1. this game is fun. 2. i like chocolate");
            System.out.println("\n");
            System.out.println("What username would you like for your character?");
            String userName = in.nextLine();
            System.out.println("Hi " + userName + ", your stats are: ");
            System.out.println("\n");
            System.out.println("----------------------------------------");
            System.out.println("Health: " + healthStats);
            System.out.println("Happiness: " + happinessStats);
            System.out.println("Intelligence: " + intelligenceStats);
            System.out.println("Age: " + ageStats);
            System.out.println("Networth: " + netWorth);
            System.out.println("----------------------------------------");
            System.out.println("To advance in this game, you must perform commands to build your player's profile.");
            System.out.println("\n");
            System.out.println("Try a command by saying \"!stats\".");
            command = in.nextLine();
            commandProcess(command);
            System.out.println(
                    "See! its that easy! If you need help, do !help to guide you, or !commands to get a list of commands. Good luck, and may the odds be ever in your favour");
        }

        do {
            for (int i = 1; i > 0; i++) { // counts the amount of commands that have occured
                if (i % 50 == 0) {
                    ageStats++;
                    randomAgeEvents();
                }
                System.out.println("Command count: " + i); // REMOVE ONLY FOR DEBUGGING
                if (alive != true) {
                    break;
                }

                // when ages goes up, by 1, do random event

                // THIS SHOULD BE WHERE ALL THE CODE THAT HAPPENS AFTER A CERTAIN AGE OR RANDOM
                // STUFF OCCURS GOES.

                System.out.println("Input a command");
                command = in.nextLine();
                commandProcess(command);
                commandCountStats++;
                if (resetI == true) { // if the method is not an essential method, such as checking stats it will not
                                      // increase age stat
                    resetI = false;
                    i--;
                }
            }
        } while (alive == true);

        System.out.println("Thanks for playing!");
        if (ageStats < 80) { // average life span is around 80, if it is done it is
            System.out.println("The odds were never in your favour.");
            stats();
        } else {
            System.out.println("The odds were in your favour");
            stats();
        }
        in.close(); // this ensures we do not have a resource leak (leave at the end)
    }
}
