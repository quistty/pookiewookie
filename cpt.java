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
    public static String deathFromStats() {
        alive = false;
        String[] randomDeaths = { "cancer", "flu", "heart attack", "cardiac arrest",
                "bleeding out from little timmy stabbing you", "covid-19",
                "set foot in oblock", "heart dissease", "stroke", "diabeties", "Stubbed toe", "Liver disease",
                "Struck by car", "Struck by lightning", "Died in a submarine (titan submersible from oceangate)" };
        int randomDeathNumber = (int) (15 * Math.random() + 1);
        randomDeathNumber--;
        String randomdeathString = randomDeaths[randomDeathNumber];
        return randomdeathString;
    }

    public static void blackJack() {

    }

    public static void roulette() {

    }

    public static void slots() {

    }

    public static void randomAgeEvents() {
        System.out.println("Happy birthday! You turned " + ageStats + " years old!");

        if ((ageStats <= 3) && (ageStats >= 0)) { // baby events
            String[] babyEvents = { "pneumonia", "flu", "gotDropped", "noCake", "reallyGoodMilk", "newToy",
                    "learnedNewSkill", "gotAPet" };
            int random = (int) (8 * Math.random() + 1);
            random--;
            String event = babyEvents[random];
            callEventMethodBaby(event);
        } else if ((ageStats <= 18) && (ageStats >= 4)) {
            String[] childEvents = { "hitByBus", "bullyEncounter", "fallDownStairs", "attackedBySquirrel", "faceplant",
                    "goodGrades",
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

    public static void callEventMethodChild(String eventName) {
        switch (eventName) {
            case "hitByBus":
                healthStats -= 50;
                happinessStats -= 20;
                System.out.println(
                        "You were hit by a bus! Ouchie!! -50% health and -20% happiness. Your current health is: "
                                + healthStats + " and your current happiness is: " + happinessStats);
                break;
            case "bullyEncounter":
                happinessStats -= 30;
                System.out.println(
                        "You were bullied by a bully named Dio Brando. -30% happiness. Your current happiness is: "
                                + happinessStats);
                break;
            case "fallDownStairs":
                healthStats -= 20;
                System.out.println(
                        "You fell down the stairs because you didnt look where you were walking. -20% health. Your current health is: "
                                + healthStats);
                break;
            case "attackedBySquirrel":
                healthStats -= 10;
                System.out.println("A squirrel mauled you. -10% health. Your current health is: " + healthStats);
                break;
            case "faceplant":
                intelligenceStats -= 20;
                System.out.println("You fell and hit your head hard. -20% intelligence. Your current intelligence is: "
                        + intelligenceStats);
                break;
            case "goodGrades":
                happinessStats += 20;
                intelligenceStats += 10;
                System.out.println(
                        "You got a good mark on your last test! +20% happiness and +10% intelligence. Your current health is: "
                                + healthStats + " and your current intelligence is: " + intelligenceStats);
                break;
            case "madeFriend":
                happinessStats += 30;
                System.out.println("You made a new friend! +30% health. Your current health is" + healthStats);
                break;
            case "ateGoodCandy":
                happinessStats += 30;
                healthStats += 10;
                System.out.println(
                        "You had some super yummy candy. +30% happiness and +10% health. Your current happiness is: " +
                                happinessStats + " and your current health is: " + healthStats);
                break;
            case "learnedNewSkill":
                intelligenceStats += 20;
                System.out.println(
                        "You learned a new skill after months of hard work. +20% intelligence. Your current intelligence is: "
                                + intelligenceStats);
                break;
            case "goodPoopSession":
                happinessStats += 50;
                healthStats += 20;
                System.out.println(
                        "You had a massive poop on the toilet and now you feel amazing. +50% happiness and +20% health. Your current happiness is: "
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
            System.out.println("Input a NUMBER between 1 and 25: ");
            guess = in.nextInt();
            numGuesses++;
            if (guess == correctNum) {
                System.out.println("Congrats, you win!");
                winner = true;
                numGuesses = 5;
                happinessStats++; // increases happiness due to a win
                break;
            } else if (guess > correctNum) {
                System.out.println("Too high, try again!");
            } else if (guess < correctNum) {
                System.out.println("Too low, try again!");
            } else {
                System.out.println("Incorrect input! how did you get here?");
                numGuesses = 1000000000;
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
                    System.out.println("1. stats - Displays stats");
                    System.out.println("2. help - Tells you how to play the game");
                    System.out.println("3. work - work at your job, so you don't get fired and to gain money!");
                    System.out.println(
                            "4. beg - play a mini game to beg people for money. If you win you gain money, but you can lose too!");
                    System.out.println("5. increaseage - Increase your age, and a random event will happen");
                    System.out.println("6. gambling - blackjack, roulette, slots");
                    System.out.println("7. buy - buy items to add to your inventory!");
                    System.out.println("8. leavegame - Quit the program");
                    return;
                case "increaseage":
                    Scanner in = new Scanner(System.in); // needed in every method to call for a user input
                    System.out.println(
                            "-------------------- ARE YOU SURE YOU WANT TO INCREASE YOUR AGE? (Y/N) --------------------");
                    String increaseAgeReponse = in.nextLine();

                    // checks if the user wants to quit or not
                    if (increaseAgeReponse.equalsIgnoreCase("y")) { // ends the code
                        ageStats++;
                        resetI = true;
                        System.out.println("You are " + ageStats + " years old");
                        randomAgeEvents();
                        return;
                    } else if (increaseAgeReponse.equalsIgnoreCase("n")) { // returns back to regular useage
                        return;
                    } else { // err message
                        System.out.println("Please input Y or N, rerun the command to try again");
                    }
                    System.out.println("----------------------------------------");
                    return;
                case "gambling":
                    Scanner youwanttobespecial = new Scanner(System.in); // needed in every method to call for a user
                                                                         // input
                    System.out.println("-------------------- PICK A NUMBER BETWEEN ONE AND THREE --------------------");
                    System.out.println("1 for BlackJack, 2 for roulette, 3 for slots");
                    int gamblingResponse = youwanttobespecial.nextInt();

                    // checks if the user wants to quit or not
                    if (gamblingResponse == 1) { // ends the code
                        blackJack();
                        return;
                    } else if (gamblingResponse == 2) { // returns back to regular useage
                        roulette();
                        return;
                    } else if (gamblingResponse == 3) {
                        slots();
                        return;
                    } else { // err message
                        System.out.println("Please input a number between 1 and 3, rerun the command to try again");
                    }
                    System.out.println("----------------------------------------");
                    return;
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
                    return;
            }
        } else {
            System.out.println("Unknown command, please make sure it exists and your command starts with \"!\"");
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        if (!beginnerInformation) {
            beginnerInformation = true;
            System.out.println("Welcome to pookiewookie, a game made by Gianluca and David");
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
            System.out.println("Try a command by saying \"!stats\" or \"!commands\".");
            command = in.nextLine();
            commandProcess(command);
            System.out.println(
                    "See! its that easy! If you need help, do !help to guide you, or !commands to get a list of commands. Good luck, and may the odds be ever in your favour");
        }

        do {
            for (int i = 1; i > 0; i++) { // counts the amount of commands that have occured
                System.out.println("command count: " + i);
                if (i % 50 == 0) {
                    System.out.println("BOSS ITS RUNNING AGAIN: " + i);
                    ageStats++;
                    randomAgeEvents();
                }
                // System.out.println("Command count: " + i); // REMOVE ONLY FOR DEBUGGING
                if (alive != true) {
                    break;
                }

                if (healthStats <= 0) {
                    String deathCause;
                    deathCause = deathFromStats();
                    System.out.println("You died from: " + deathCause);
                    break;
                }
                // when ages goes up, by 1, do random event

                // THIS SHOULD BE WHERE ALL THE CODE THAT HAPPENS AFTER A CERTAIN AGE OR RANDOM
                // STUFF OCCURS GOES.

                System.out.println("Input a command:");
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
