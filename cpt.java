import java.util.Scanner;

// FIX wrap line length
public class cpt { // needed because you need a class to have a main method (in the lesson its just
                   // class main with no public)

    // ---------------------------------------------------------------VARIABLES------------------------------------------
    // always declare them here, and with public static before the variable
    public static int healthStats = 100, happinessStats = 100, intelligenceStats = 50, ageStats = 1;
    public static double netWorth = 0;
    public static boolean beginnerInformation = false; // so beginner information runs once
    public static String command;

    // ----------------------------------------------------------------COMMANDS------------------------------------------------
    // where all the commands for the game are

    public static void stats() {
        System.out.println("Health: " + healthStats);
        System.out.println("Happiness: " + happinessStats);
        System.out.println("Intelligence: " + intelligenceStats);
        System.out.println("Networth: " + netWorth);
        System.out.println("Age: " + ageStats);
    }

    // ----------------------------------------------------------------MAIN---------------------------------------------
    public static void commandProcess(String command) {
        if (command.startsWith("!")) {
            String actualCommand = command.substring(1); // removes the first char of the variable, the exclamation mark
            // this is to run all the different commands available
            switch (actualCommand) {
                case "stats":
                    stats();
                    main(null);
                    break;
                case "commands":

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
            System.out.println("Welcome to this game, the rules are x");
            System.out.println("\n");
            System.out.println("What username would you like for your character?");
            String userName = in.nextLine();
            System.out.println("Hi " + userName + ", your stats are: ");
            System.out.println("\n");
            System.out.println("Health: " + healthStats);
            System.out.println("Happiness: " + happinessStats);
            System.out.println("Intelligence: " + intelligenceStats);
            System.out.println("Age: " + ageStats);
            System.out.println("Networth: " + netWorth);
            beginnerInformation = true;
            System.out.println("To advance in this game, you must perform commands to build your player's profile.");
            System.out.println("\n");
            System.out.println("Try a command by saying \"!commamds\".");
            command = in.nextLine();
            commandProcess(command);
        }

        in.close(); // this ensures we do not have a resource leak (leave at the end)
    }
}
