import java.util.Scanner;

// FIX wrap line length
public class cpt {
    // ---------------------------------------------------------------VARIABLES------------------------------------------------
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
        } else if ((ageStats <= 18) && (ageStats >=4)) {
            String[] childEvents = { "hitByBus", "bullyEncounter", "fallDownStairs", "attackedBySquirrel", "faceplant", "goodGrades", 
            "madeFriend", "ateGoodCandy", "learnedNewSkill", "goodPoopSession" };
            int random = (int) (10 * Math.random() + 1);
            random--;
            String event = childEvents[random];
            callEventMethodChild(event);
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
                System.out.println("You were dropped as a baby. -50% intelligence. Your current intelligence is: " + intelligenceStats);
                break;
            case "noCake":
                happinessStats -= 30;
                System.out.println("You didnt get cake today. -30% happiness. Your current happiness is: " + happinessStats);
                break;
            case "reallyGoodMilk":
                healthStats += 20;
                System.out.println(
                    "Your mother gave you some milk and it tasted exqusite. +20% health. Your current happiness is: " + healthStats);
                break;
            case "newToy":
                happinessStats += 30;
                System.out.println(
                    "Your parents bought you a new toy! +30% happiness. Your current happpiness is: " + happinessStats);
                break;
            case "learnedNewSkill":
                intelligenceStats += 20;
                System.out.println("You learned a new skill as a baby! +20% intelligence. Your currernt intelligence is: " + intelligenceStats);
                break;
            case "gotAPet":
                happinessStats += 50;
                System.out.println("You got a pet dog! You named him Gojo Satoru. +50% happiness. Your current happiness is: " + happinessStats);
                break;
            default:
                System.out.println("Gambling lesson #1: There are no losses, just intervals between winning");
        }
    }

    public static void callEventMethodChild(String eventName) {
        switch (eventName) {
            case "hitByBus":
                healthStats -= 50;
                happinessStats -=20;
                System.out.println("You were hit by a bus! Ouchie!! -50% health and -20% happiness. Your current health is: " 
                + healthStats + " and your current happiness is: " + happinessStats);
                break;
            case "bullyEncounter":
                happinessStats -= 30;
                System.out.println("You were bullied by a bully named Dio Brando. -30% happiness. Your current happiness is: " + happinessStats);
                break;
            case "fallDownStairs":
                healthStats -= 20;
                System.out.println("You fell down the stairs because you didnt look where you were walking. -20% health. Your current health is: " + healthStats);
                break;
            case "attackedBySquirrel":
                healthStats -=10;
                System.out.println("A squirrel mauled you. -10% health. Your current health is: " + healthStats);
                break;
            case "faceplant":
                intelligenceStats -=20;
                System.out.println("You fell and hit your head hard. -20% intelligence. Your current intelligence is: " + intelligenceStats);
                break;
            case "goodGrades":
                happinessStats +=20;
                intelligenceStats +=10;
                System.out.println("You got a good mark on your last test! +20% happiness and +10% intelligence. Your current health is: " 
                + healthStats + " and your current intelligence is: " + intelligenceStats);
                break;
            case "madeFriend":
                happinessStats +=30;
                System.out.println("You made a new friend! +30% health. Your current health is" + healthStats);
                break;
            case "ateGoodCandy":
                happinessStats +=30;
                healthStats +=10;
                System.out.println("You had some super yummy candy. +30% happiness and +10% health. Your current happiness is: " +
                happinessStats + " and your current health is: " + healthStats);
                break;
            case "learnedNewSkill":
                intelligenceStats +=20;
                System.out.println("You learned a new skill after months of hard work. +20% intelligence. Your current intelligence is: " + intelligenceStats);
                break;
            case "goodPoopSession":
                happinessStats += 50;
                healthStats += 20;
                System.out.println("You had a massive poop on the toilet and now you feel amazing. +50% happiness and +20% health. Your current happiness is: " 
                + happinessStats + " and your current health is: " + healthStats);
                break;
            default:
                break;
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
        // needed in every method to end the calling of variables
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
                    stats();
                    // resetI = true; // add this to every method in this switch if not an essential
                    // program, to balance the rapidly increasing age
                    return;
                case "commands":
                case "event":
                case "increaseage":
                case "gambling":
                case "beg":
                    boolean winner = hilow();
                    if (winner == true) {
                        int winnings = (int) (1000 * Math.random() + 1);
                        netWorth += winnings;
                        System.out.println("You won: " + winnings);
                        System.out.println("Your new networth is: " + netWorth);
                    }

                    return;
                // randomize a number between 1 and 3 to play the different types of games
                case "leavegame":
                    leavegame();
                    return;
                default:
                    System.out.println("Unknown command, make sure it exists and try again!"); // FIGURE OUT A WAY TO
                                                                                               // BREAK THIS SYSTEM, AND
                                                                                               // ASK FOR THE REQUEST
                                                                                               // AGAIN AFTER REQUEST
                                                                                               // DONE
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
                    i = 0;
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
