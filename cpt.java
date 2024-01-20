import java.util.Scanner;

// FIX wrap line length
public class cpt {
    // ---------------------------------------------------------------VARIABLES------------------------------------------------
    // always declare them here, and with public static before the variable
    public static int healthStats = 500, happinessStats = -10, intelligenceStats = 50, ageStats = 1; // general stats for the user
    public static Scanner in = new Scanner(System.in);
    public static double netWorth = 0; // how much money the user has
    public static boolean beginnerInformation = false; // so beginner information runs once
    public static String command; // the command the user inputted
    public static boolean alive = true; // checks if the user is alive or not
    public static boolean resetI = false; // resets commands that do not increase the command counter
    public static int commandCountStats = 1; // counts the number of commands run
    public static boolean jobStatus = false; // checks if user has a job
    public static String jobTitle = "none"; // user's job name
    public static String schoolTitle = "none"; // users's school name
    public static int workCount = 0; // number of times user has worked in a year
    public static boolean schoolStatus = false; // checks if user has a school
    public static String userName; // user's name
    public static boolean schoolStatusForStudy = false; // created so that when we check if the user is going to school, it does not count post secondary
    public static boolean resetSpecificI = false; // resets I for the buggy age
    public static int schoolYearCount = 0; // number of years in school
    public static boolean endingGame = false;

    // ----------------------------------------------------------------COMMANDS------------------------------------------------
    // where all the commands for the game are
    public static String deathFromStats() { // random events to happen to a user if they run out of health
        alive = false;
        String[] randomDeaths = { "cancer", "flu", "heart attack", "cardiac arrest",
                "bleeding out from little timmy stabbing you", "covid-19",
                "setting foot in oblock", "heart dissease", "stroke", "diabeties", "Stubbed toe", "Liver disease",
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

    public static void randomAgeEvents() { // when age is increased, random events will happen based on your age.
        System.out.println("Happy birthday! You turned " + ageStats + " years old!");
        // things to check on a yearly basis 
        if (schoolStatusForStudy == true) {
            schoolYearCount++;
        }
        if (schoolStatus == true && schoolYearCount == 5) {
            intelligenceStats += 100;
            schoolTitle = "none";
            System.out.println("Congrats! You graduated! You gained 100 intelligence. Your new intelligence is: "
                    + intelligenceStats);
        }
        
        if (workCount <= 12 && jobStatus == true) {
            if (ageStats != 18) {}
            System.out.println("You were fired at your job for working too little. You also lost -20% intelligence.");
            jobTitle = "none";
            jobStatus = false;
            intelligenceStats -= 20;
        }

        // random events per year
        if ((ageStats <= 3) && (ageStats >= 0)) { // baby events
            String[] babyEvents = { "pneumonia", "flu", "gotDropped", "noCake", "reallyGoodMilk", "newToy",
                    "learnedNewSkill", "gotAPet" };
            int random = (int) (8 * Math.random() + 1);
            random--;
            String event = babyEvents[random];
            callEventMethodBaby(event);
        } else if ((ageStats < 18) && (ageStats >= 4)) {
            if (ageStats == 6) {
                System.out.println("You are enrolled in MapleWood Elementary School");
                schoolTitle = "Maplewood Elementary School";
                schoolStatus = true;
            }
            if (ageStats == 14) {
                System.out.println("You are enrolled in Harmony High School");
                schoolTitle = "Harmony High School";
                schoolStatus = true;
            }
            String[] childEvents = { "hitByBus", "bullyEncounter", "fallDownStairs", "attackedBySquirrel", "faceplant",
                    "goodGrades",
                    "madeFriend", "ateGoodCandy", "learnedNewSkill", "goodPoopSession", "playedAtRecital", };
            int random = (int) (10 * Math.random() + 1);
            random--;
            String event = childEvents[random];
            callEventMethodChild(event);
        } else if (ageStats == 18) {
            schoolTitle = "none";
            System.out.println(
                    "You graduated from high school, what will you do now? Type 1 to look for a job, 2 to apply to university.");
            int graduationDecision = in.nextInt();
            if (graduationDecision == 1) {
                System.out.println("Currently these jobs are hiring. Pick a job!");
                jobTitle = pickajob();
            } else if (graduationDecision == 2) {
                System.out.println("Apply to a school! These schools are taking admissions");
                applytoaSchool();
            } else {

            }

        } else if ((ageStats <= 23) && (ageStats > 18)) {
            String[] studentEvents = { "drugdealer", "failedExam", "loudNoise", "foundMoney", "goodLab", "party", "wentOnVacation"};
            int random = (int) (7 * Math.random() + 1);
            random--;
            String event = studentEvents[random];
            callEventMethodStudent(event);
        }

        // checks if you've meet the threshold to stay alive every year
        if (netWorth <= -600000){
            endingGame = true;
            System.out.println("CRA has taken you to jail for being in too much debt. You declared Bankcruptcy. This caused you to die from " + deathFromStats());
            endgame();
        }
        if (intelligenceStats <= -50){
            endingGame = true;
            System.out.println("You have very little intelligence! This caused you to die from " + deathFromStats());
            endgame();
        }
        if (happinessStats <= -50){
            endingGame = true;
            System.out.println("You have very little happiness! This caused you to die from " + deathFromStats());
            endgame();
        }
    }

    // method that runs baby events
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

    // method that runs child events
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
                System.out.println("You made a new friend! +30% happiness. Your current happiness is: " + happinessStats);
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
            case "playedAtRecital":
                happinessStats += 30;
                intelligenceStats += 10;
                System.out.println(
                        "You played well at your recital! +30% happiness and +10% intelligence. Your current happiness is: "
                                + happinessStats + " and your current health is: " + healthStats);
            default:
                break;
        }
    }
    public static void callEventMethodStudent(String eventName) {
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
        System.out.println("School: " + schoolTitle);
        System.out.println("Job title: " + jobTitle);
        System.out.println("----------------------------------------");
    }

    public static String pickajob() { // used when the user wants to get a job
        // checks if user meets requirement to get a job
        if (jobStatus == true) {
            System.out.println("No more than 1 job in this game, quit your job to get a new one!");
            return jobTitle;
        } else if (ageStats < 14) {
            System.out.println("Bossman! No jobs allowed at your age! Wait till you're 14!");
            return jobTitle;
        }
        // print all jobs, with the title and the pay per year/hour
        System.out.println("1. School Janitor - $38,480 a year ($20/hr)");
        System.out.println("2. Barista - $62,400 a year ($30/hr)");
        System.out.println("3. Car Salesman - $52,000 a year ($25/hr)");
        System.out.println("4. Groccery store clerk - $31,200 a year ($15/hr)");
        System.out.println("5. Administrative Assistant - $47,840 a year ($23/hr)");
        System.out.println("6. Registered nurse - $83,240 a year ($23/hr)");
        System.out.println("7. Engineer 1 - $72,800 a year ($35/hr)");
        System.out.println("8. Engineer 2 - $72,800 a year ($35/hr)");
        System.out.println("9. Project manager - $104,000 a year ($50/hr)");
        System.out.println("Pick a job by inputting the number corresponding to the job");
        int jobNumber = in.nextInt(); // gets the job the user wants
        boolean jobMiniGameWinnings; // checks to see if the user was successful in winning the minigame for the job
        switch (jobNumber) {
            case 1:
                if (intelligenceStats > 10) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Janitor";
                        System.out.println("You were hired as a janitor, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 2:
                if (intelligenceStats > 10) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Barista";
                        System.out.println("You were hired as a Barista, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 3:
                if (intelligenceStats > 20) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Car Salesman";
                        System.out.println("You were hired as a car salesman, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 4:
                if (intelligenceStats > 10) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Groccey Store clerk";
                        System.out.println("You were hired as a Groccey Store clerk, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }

                break;
            case 5:
                if (intelligenceStats > 30) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Administrative Assistant";
                        System.out.println("You were hired as a Administrative Assistant, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 6:
                if (intelligenceStats > 60) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Registered nurse";
                        System.out.println("You were hired as a Registered nurse, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 7:
                if (intelligenceStats > 70) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Engineer 1";
                        System.out.println("You were hired as an Engineer 1, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 8:
                if (intelligenceStats > 70) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Engineer 2";
                        System.out.println("You were hired as an Engineer 2, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }
                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            case 9:
                if (intelligenceStats > 50) {
                    jobMiniGameWinnings = hilow();
                    if (jobMiniGameWinnings == true) {
                        jobTitle = "Project Manager";
                        System.out.println("You were hired as a Project Manager, you start tomorrow.");
                        jobStatus = true;
                    } else {
                        System.out.println("You were not hired, use !job to try again!");
                        break;
                    }

                } else {
                    System.out.println("You were not hired, use !job to try again!");
                }
                break;
            default:
                System.out.println(
                        "dude print a number between 1 and 9, is it that hard?? Use !job to get this prompt again. grrrrrrrrrrrr.");
                break;
        }
        return jobTitle;

    }

    public static void workGame() { // allows the user to work to get money
        // checks to see if the user meets the requirements
        if (jobStatus == false) {
            System.out.println("You don't have a job, use !job to try get a job!");
            return;
        }
        if (workCount > 14) {
            System.out.println("Stop working overtime! Your family loves and needs you!");
            return;
        }
        // pays the user based on their title
        switch (jobTitle) {
            case "Janitor":
                netWorth += 3206;
                System.out.println("You got paid $3206 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Barista":
                netWorth += 5200;
                System.out.println("You got paid $5200 this month! Good work");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Car Salesman":
                netWorth += 4333;
                System.out.println("You got paid $4333 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Groccery Store clerk":
                netWorth += 4333;
                System.out.println("You got paid $4333 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Administrative Assistant":
                netWorth += 3986;
                System.out.println("You got paid $3986 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Registered nurse":
                netWorth += 6936;
                System.out.println("You got paid $6936 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Engineer 1":
                netWorth += 6006;
                System.out.println("You got paid $6006 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Engineer 2":
                netWorth += 6006;
                System.out.println("You got paid $6006 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            case "Project Manager":
                netWorth += 8666;
                System.out.println("You got paid $8666 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 5;
                }
                break;
            default:
                System.out.println("How on earth are u here... thats a big ass bug bro");
                return;
        }
    }

    public static void study() { // allows the user to increase intelligence
        // checks if the user meets requirements
        if (schoolStatus == false) {
            System.out.println("Bossman! You need to be enrolled at a school first.");
            return;
        }
        // asks the user for how they want to study
        System.out.println("Pick how you want to study");
        System.out.println("1. Reading books");
        System.out.println("2. Participate in class");
        System.out.println("3. Study for your tests and exams");
        int userInput = in.nextInt();
        double random;
        int randomInt;
        // gives intelligence based on the method of study
        switch (userInput) {
            case 1:
                random = (5 - 1 + 1) * Math.random() + 1; // grants a random amount of intelligence
                randomInt = (int) random;
                intelligenceStats += randomInt;
                System.out.println("Your intelligence went up by " + randomInt);
                System.out.println("Your new intelligence is: " + intelligenceStats);
                happinessStats -= 3;
                break;
            case 2:
                random = (7 - 1 + 1) * Math.random() + 1; // grants a random amount of intelligence
                randomInt = (int) random;
                intelligenceStats += randomInt;
                System.out.println("Your intelligence went up by " + randomInt);
                System.out.println("Your new intelligence is: " + intelligenceStats);
                happinessStats -= 3;
                break;
            case 3:
                random = (10 - 1 + 1) * Math.random() + 1; // grants a random amount of intelligence
                randomInt = (int) random;
                intelligenceStats += randomInt;
                System.out.println("Your intelligence went up by " + randomInt);
                System.out.println("Your new intelligence is: " + intelligenceStats);
                happinessStats -= 3;
                break;
        }
    }

    public static String applytoaSchool() {
        // checks ifthe user meets the requirements
        if (schoolStatusForStudy == true || ageStats < 18) { // school stats for study ensures that users who are in
                                                             // elementary and high school can still improve
                                                             // intelligence but cannot apply to a school as well
            System.out.println("No more than 1 school in this game, drop out to get a new one!"); // hrdhsjhsdjkhkdshfkh hkjshfkjskdfhksdh fjkshdkfjdshkfjdsf
            System.out.println("you must be 18 or older to get another school");
            return schoolTitle;
        }
        // print all jobs, with the title and the pay per yea
        System.out.println("1. WoodBridge college - trades ($30,000))");
        System.out.println("2. Seneca college - trades ($40,000)");
        System.out.println("3. Brock - gender studies ($10,000)");
        System.out.println("4. York - Business ($50,000)");
        System.out.println("5. Western - BioMedical ($70,000)");
        System.out.println("6. McMaster - Accountant ($80,000)");
        System.out.println("7. Queens - Dental Studies ($175,000)");
        System.out.println("8. U of T - Neurosurgian doctor ($250,000)");
        System.out.println("9. Waterloo - Software Engineer ($125,000)");
        System.out.println(
                "Pick a school by inputting the number corresponding to the school. You pay once you're accepted!");
        int schoolNumber = in.nextInt();
        switch (schoolNumber) {
            case 1:
                if (intelligenceStats > 10) {
                    schoolTitle = "WoodBridge college";
                    System.out.println(
                            "You were accepted into WoodBridge College for any trade you want, you start tomorrow.");
                    schoolStatus = true;
                    happinessStats += 8;
                    netWorth -= 30000;
                    schoolStatusForStudy = true;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 2:
                if (intelligenceStats > 10) {
                    schoolTitle = "Seneca college";
                    System.out.println(
                            "You were accepted into Seneca College for any trade you want! You start tomorrow.");
                    schoolStatus = true;
                    happinessStats += 8;
                    netWorth -= 40000;
                    schoolStatusForStudy = true;

                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 3:
                if (intelligenceStats > 0) {
                    schoolTitle = "Brock (gender studies)";
                    System.out.println(
                            "You were accepted into Brock for gender studies, you start tomorrow. I would be suprised if you show up tomorrow ¯\\_(ツ)_/¯ ");
                    schoolStatus = true;
                    happinessStats += 8;
                    netWorth -= 10000;
                    schoolStatusForStudy = true;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 4:
                if (intelligenceStats > 0) {
                    schoolTitle = "York";
                    System.out.println(
                            "You were accepted into York for Business, you start tomorrow. If you can hold a fork you can go to york!");
                    schoolStatus = true;
                    happinessStats += 8;
                    netWorth -= 50000;
                    schoolStatusForStudy = true;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 5:
                if (intelligenceStats > 40) {
                    schoolTitle = "Western";
                    System.out.println("You were accepted into Western for BioMedical, you start tomorrow.");
                    schoolStatus = true;
                    happinessStats += 8;
                    netWorth -= 70000;
                    schoolStatusForStudy = true;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 6:
                if (intelligenceStats > 60) {
                    schoolTitle = "McMaster";
                    System.out.println(
                            "You were accepted into McMaster for accounting, you start tomorrow. (good luck its boring)");
                    schoolStatus = true;
                    happinessStats += 8;
                    netWorth -= 80000;
                    schoolStatusForStudy = true;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 7:
                if (intelligenceStats > 80) {
                    schoolTitle = "Queens";
                    System.out.println("You were accepted into Queens for Dental Studies, you start tomorrow.");
                    schoolStatus = true;
                    happinessStats += 8;
                    schoolStatusForStudy = true;
                    netWorth -= 175000;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 8:
                if (intelligenceStats > 100) {
                    schoolTitle = "U of T";
                    System.out.println("You were accepted into U of T to be a Neurosurgian, you start tomorrow.");
                    schoolStatus = true;
                    happinessStats += 8;
                    schoolStatusForStudy = true;
                    netWorth -= 250000;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            case 9:
                if (intelligenceStats > 100) {
                    schoolTitle = "Waterloo";
                    System.out.println("You were accepted into Waterloo for Software Engineering, you start tomorrow.");
                    schoolStatus = true;
                    happinessStats += 8;
                    schoolStatusForStudy = true;
                    netWorth -= 125000;
                    System.out.println("Your new netWorth is: $" + netWorth);
                } else {
                    System.out.println("You were not accepted, use !school to try again!");
                    happinessStats -= 10;
                }
                break;
            default:
                System.out.println(
                        "dude print a number between 1 and 9, is it that hard?? Use !school to get this prompt again. grrrrrrrrrrrr.");
                break;
        }
        return schoolTitle;
    }

    public static void quitJob() {
        System.out.println("-------------------- ARE YOU SURE YOU WANT TO QUIT YOUR JOB? (Y/N) --------------------");
        String reponse = in.nextLine();

        // checks if the user wants to quit or not
        if (reponse.equalsIgnoreCase("y")) { // ends the code
            workCount = 0;
            System.out.println("You quit your job, effective today. use !job to get another job");
            jobStatus = false;
            jobTitle = "none";
        } else if (reponse.equalsIgnoreCase("n")) { // returns back to regular useage
            return;
        } else { // err message
            System.out.println("Please input Y or N, rerun the command to try again");
        }
        System.out.println("----------------------------------------");
    }

    public static void quitSchool() {
        System.out.println(
                "-------------------- ARE YOU SURE YOU WANT TO DROP OUT OF SCHOOL? YOU WONT BE REFUNDED (Y/N) --------------------");
        String reponse = in.nextLine();

        // checks if the user wants to quit or not
        if (reponse.equalsIgnoreCase("y")) { // ends the code
            schoolYearCount = 0;
            System.out.println("You dropped out of school, effective today. use !school to go back to school.");
            schoolStatusForStudy = false;
            schoolStatus = false;
            schoolTitle = "none";
        } else if (reponse.equalsIgnoreCase("n")) { // returns back to regular useage
            return;
        } else { // err message
            System.out.println("Please input Y or N, rerun the command to try again");
        }
        System.out.println("----------------------------------------");
    }

    public static void leavegame() { // if the player wants to leave the game
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
        int correctNum = (int) (25 * Math.random() + 1); // picks a random # between 1 and 25
        int numGuesses = 0; // guess count
        boolean winner = false; //
        int guess;
        // System.out.println("BLAHHHHHHHHHHHHHHHHHH" + correctNum); // only used for
        // debugging ------------------ REMOVE IN FINAL VERSION ------------------------
        while (numGuesses < 6) {
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
    public static void endgame() {
        System.out.println("Thanks for playing!");
        int score = 0;
        // makes sure the score isnt 0 when the numbers are calculated
        if (intelligenceStats != 0) { 
            score += (intelligenceStats * 5);
        } else {
            intelligenceStats--;
            score += (intelligenceStats * 5);
        }
        if (happinessStats != 0) {
            score += (happinessStats * 3);
        } else {
            happinessStats--;
            score += (happinessStats * 3);
        }
        if (healthStats != 0) {
            score += (intelligenceStats * 10);
        } else {
            healthStats--;
            score += (healthStats * 10);
        }
        score += (netWorth);
        score += (ageStats * 25);
        if (ageStats < 80) { // average life span is around 80, if u make it u win!
            System.out.println("The odds were never in your favour.");
            stats();
        } else {
            System.out.println("The odds were in your favour");
            stats();
        }
        System.out.println("You had a score of " + score + "! Not bad!");
        // calculate ur death stats here
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
                    System.out.println("9. job - allows you to obtain a job");
                    System.out.println("10. work - allows you to work at your job. Required 12 times yearly");
                    System.out.println("11. quit - allows you to quit your job.");
                    System.out.println("12. school - allows you to go to a school.");
                    System.out.println("13. study - allows you to increase ur intelligence.");
                    System.out.println("14. doctor - Visit the doctor if you have low health.");
                    return;
                case "school":
                    applytoaSchool();
                    return;
                case "doctor":
                    if (healthStats > 60) {
                        System.out.println(userName + ", you're healthy enough. Go home!");
                    } else {
                        healthStats += 50;
                        int randomNmDoctor = (int) (10000 * Math.random() + 1);
                        netWorth -= randomNmDoctor;
                        System.out.println("Your health went up by 50. This costed :$" + randomNmDoctor);
                        System.out.println("Your new net worth is :$" + netWorth);
                    }
                    return;
                case "study":
                    study();
                    return;
                case "increaseage":
                    System.out.println(
                            "-------------------- ARE YOU SURE YOU WANT TO INCREASE YOUR AGE? (Y/N) --------------------");
                    String increaseAgeReponse = in.nextLine();

                    // checks if the user wants to quit or not
                    if (increaseAgeReponse.equalsIgnoreCase("y")) { // ends the code
                        ageStats++;
                        resetSpecificI = true;
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
                case "work":
                    workCount++;
                    workGame();
                    return;
                case "job":
                    pickajob();
                    return;
                case "quit":
                    quitJob();
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


        if (!beginnerInformation) {
            beginnerInformation = true;
            System.out.println("Welcome to pookiewookie, a game made by Gianluca and David");
            System.out.println("\n");
            System.out.println("What username would you like for your character?");
            userName = in.nextLine();
            System.out.println("Hi " + userName + ", your stats are: ");
            System.out.println("\n");
            System.out.println("----------------------------------------");
            System.out.println("Health: " + healthStats);
            System.out.println("Happiness: " + happinessStats);
            System.out.println("Intelligence: " + intelligenceStats);
            System.out.println("Age: " + ageStats);
            System.out.println("Networth: " + netWorth);
            System.out.println("Job title: " + jobTitle);
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
                if (resetI == true) { // if the method is not an essential method, such as checking stats it will not
                    // increase age stat
                    resetI = false;
                    if ((i - 1) % 35 == 0) {
                        i = 1;
                    } else {
                        i--;
                    }

                }
                if (resetSpecificI == true) { // if the user just went up in age and increases their age with the
                                              // command, this catches that and prevents multiple age increases at once
                    resetSpecificI = false;
                    i = 1;
                }
                if (i % 35 == 0) {
                    ageStats++;
                    randomAgeEvents();
                }

                if (alive != true) { //checks if the user is alive after every command
                    break;
                }

                if (healthStats <= 0) { //kills the user if they have too low hp
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

            }
        } while (alive == true);
        if (endingGame != true) { // so that it doesnt run endgame more than once if u die from something other than health
            endgame();
        }
        in.close(); // this ensures we do not have a resource leak (leave at the end)
    }
}
