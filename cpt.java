import java.util.Scanner;

// FIX wrap line length
public class cpt {
    // ---------------------------------------------------------------VARIABLES------------------------------------------------
    // always declare them here, and with public static before the variable
    public static int healthStats = 100, happinessStats = 50, intelligenceStats = 50, ageStats = 1; // general stats for the user
    public static Scanner in = new Scanner(System.in);
    public static double netWorth = 100; // how much money the user has
    public static double netWorthAssets = 0; // the value of all the assets a user has.
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
    public static boolean whyisthisbroken = false;
    public static String[] inventory = {"none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", 
    "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", 
    "none", "none", "none", "none", "none", "none", }; // has 50 elements (49 indexes not including 0)

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

    public static void roulette() { //allows user to wager and gamble money
        int noDebt = 0;
        double wager = 0;
        while (noDebt == 0) {
            System.out.println("enter the amount you would like to wager");
            wager = in.nextDouble();
            if (wager > netWorth) {
                System.out.println("you can not wager more than you have!");
            } else {
                noDebt = 1;

            }
        }
            if (ageStats < 18) {
                System.out.println("Hey! you can't gamble unless you are 18 or older!");
                return;
            }
            netWorth = netWorth - wager;
            int colour = 0;
            System.out.println("Would you like to bet on black or red?"); //needs fixing
            while (colour == 0) {
                switch (in.nextLine()) {
                    case "Black":
                        colour = 1;
                        break;
                    case "black":
                        colour = 1;
                        break;
                    case "Red":
                        colour = 2;
                        break;
                    case "red":
                        colour = 2;
                        break;
                    default:
                        System.out.println("Please enter a valid colour");

                }
            }
            int rouletteColour = (int) (2 * Math.random() + 1);
            if (rouletteColour == colour){
                System.out.println("You won! You won 1.5x your wagers: " + wager*1.5);
                netWorth = netWorth + wager*1.5;
                happinessStats +=2;
            } else {
                System.out.println("You did not win :( and lost half your wagers: " + wager*0.5);
                netWorth = netWorth + wager*0.5;
                happinessStats -=2;
                intelligenceStats -=3;
            }
    }
    

    public static void slots() {
        int noDebt = 0;
        double wager = 0;
        while (noDebt == 0) {
            System.out.println("enter the amount you would like to wager");
            wager = in.nextDouble();
            if (wager > netWorth) {
                System.out.println("you can not wager more than you have!");
            } else {
                noDebt = 1;

            }
        }
            if (ageStats < 18) {
                System.out.println("Hey! you can't gamble unless you are 18 or older!");
                return;
            }
            netWorth = netWorth - wager;
            System.out.println("Slots are rolling!");
            if ((int) (216 * Math.random() + 1) == 216) {
                System.out.println("CONGRATS YOU WON!!!! you won" + wager*100);
                netWorth = netWorth + wager*100;
                happinessStats +=20;
            } else {
                System.out.println("You didnt win :( and you lost your wager");
        }

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
        
        if (workCount <= 5 && jobStatus == true) {
            if (ageStats != 18) {}
            System.out.println("You were fired at your job for working too little. You also lost -20% intelligence.");
            jobTitle = "none";
            jobStatus = false;
            intelligenceStats -= 20;
        }
        workCount = 0;
        // random events per year
        if ((ageStats <= 3) && (ageStats >= 0)) { // baby events
            String[] babyEvents = { "pneumonia", "flu", "gotDropped", "noCake", "reallyGoodMilk", "newToy",
                    "learnedNewSkill", "gotAPet" }; // seed bank of the random events
            int random = (int) (8 * Math.random() + 1); // picks random number for the event
            random--;
            String event = babyEvents[random]; // gathers the string from the corresponding index
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
                    "goodGrades", "madeFriend", "ateGoodCandy", "learnedNewSkill", "goodPoopSession", "playedAtRecital", }; // seed bank of the random events
            int random = (int) (10 * Math.random() + 1); // picks random number for the event
            random--;
            String event = childEvents[random]; // gathers the string from the corresponding index
            callEventMethodChild(event);
        } else if (ageStats == 18) { // puts user in school or a job
            schoolTitle = "none"; 
            schoolStatus = false; // makes them out of school
            schoolStatusForStudy = false;
            System.out.println("You graduated from high school, what will you do now? Type 1 to look for a job, 2 to apply to university. You can always sign up for the other one later! Use !commands to find out more.");
            int graduationDecision = in.nextInt();
            if (graduationDecision == 1) { // puts user in job
                System.out.println("Currently these jobs are hiring. Pick a job!");
                jobTitle = pickajob();
            } else if (graduationDecision == 2) { // puts user in school
                System.out.println("Apply to a school! These schools are taking admissions");
                applytoaSchool();
            } else {
                System.out.println("How could you not pick one? Use !school or !job to get either one."); // err message
                whyisthisbroken = true;
            }

        } else if ((ageStats <= 23) && (ageStats > 18) && schoolStatusForStudy == true) { 
            String[] studentEvents = { "drugdealer", "failedExam", "loudNoise", "foundMoney", "goodLab", "party", "wentOnVacation"}; // seed bank of the random events
            int random = (int) (7 * Math.random() + 1); // picks random number for the event
            random--;
            String event = studentEvents[random]; // gathers the string from the corresponding index
            callEventMethodStudent(event);
        } else if (ageStats == 40){
            callEventMethodAdult("deadParents");
        }
        else {
            String[] adultEvents = { "payTaxes", "bankError", "cancer", "midlifecrisis", "Infidelity", "friendDied", "burntOut", "identityTheft", "addiction", "fraud", "robbed", "inheritedDebt", 
                                    "stalked", "party", "jobBonus", "vacation", "scratchTicket", "hitBenchPR", "goodDay", "newFriend", "richFriend", "hobbyMaster", "cookedDish"}; // seed bank of the random events
            int random = (int) (23 * Math.random() + 1); // picks random number for the event
            random--;
            String event = adultEvents[random]; // gathers the string from the corresponding index
            callEventMethodAdult(event);
            }// 24

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
                System.out.println("You didnt get cake today. -30% happiness. Your current happiness is: " + happinessStats);
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
        switch (eventName) { // changes the user's stats based on the random event
            case "hitByBus":
                healthStats -= 25;
                happinessStats -= 20;
                System.out.println(
                        "You were hit by a bus! Ouchie!! -25% health and -20% happiness. Your current health is: "
                                + healthStats + " and your current happiness is: " + happinessStats);
                break;
            case "bullyEncounter":
                happinessStats -= 30;
                System.out.println(
                        "You were bullied by a bully named Dio. -30% happiness. Your current happiness is: "
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
        switch (eventName) { // changes the user's stats based on the random event
            case "pneumonia":
                healthStats -= 20;
                System.out.println("You were approached by a drug dealer. You didn't buy his good and his gang jumped you. You lost 20% hp. Your current health is: " + healthStats);
                break;
            case "failedExam":
                happinessStats -= 20;
                intelligenceStats -= 10;
                System.out.println("You failed your exam. You lost 20% happiness and 10% intelligence. Your current happiness is: " + happinessStats + " and your current intelligence is: " + intelligenceStats);
                break;
            case "gotDropped":
                happinessStats -= 5;
                System.out.println("You kept hearing loud noises from upstains, making it hard to sleep. -5% happiness. Your current happiness is: " + happinessStats);
                break;
            case "foundMoney":
                happinessStats += 30;
                netWorth += 100;
                System.out.println("You found $100 on the floor. +30% happiness. Your current happiness is: " + happinessStats);
                break;
            case "goodLab":
                intelligenceStats += 10;
                System.out.println("You did good on your lab. +10 intelligence. Your current intelligence is: " + intelligenceStats);
                break;
            case "party":
                happinessStats += 30;
                System.out.println("You were invited to a party and got laid! +30% happiness. Your current happpiness is: " + happinessStats);
                break;
            case "wentOnVacation":
                happinessStats += 20;
                System.out.println("You went on vacation with your family! +20% happiness. Your currernt happiness is: " + happinessStats);
                break;
            default:
                System.out.println("idk how u got here, there is an error in the code.");
        }
    }

    public static void callEventMethodAdult(String eventName){
        switch(eventName){ // changes the user's stats based on the random event
            case "payTaxes": 
                netWorth -= 5000;
                System.out.println("Your employer didn't pay your income taxes, and you got fined $5000. Your current netWorth is: $" + netWorth);
                break;
            case "bankError":
                netWorth -= 674;
                System.out.println("The bank had an error and you lost $674. Your current netWorth is: $" + netWorth);
                break;
            case "cancer":
                healthStats -= 50;
                System.out.println("The doctor diagnosed you with stage 4 lung cancer. You overcame it but became very sick. -50% hp. Your current health is: " + healthStats);
                break;
            case "midlifecrisis":
                happinessStats -= 15;
                netWorth -= 5000;
                System.out.println("You bought some random junk as you're experiencing a mid life criss. -15% happiness. Your current happiness is: " + happinessStats);
                break;
            case "Infidelity":
                happinessStats -= 60;
                System.out.println("You found out someone you were seeing has a wife and kids. -60% happiness. Your current happiness is: " + happinessStats);
                break;
            case "friendDied":
                happinessStats -= 50;
                System.out.println("Your best friend from elementary school died. -50% happiness. Your current happiness is: " + happinessStats);
                break;
            case "burntOut":
                healthStats -= 60;
                System.out.println("You got burnt out at your job and resorted to bad eating habits. -10% health. Your current health is: " + healthStats);
                break;
            case "identityTheft":
                netWorth -= 80460;
                System.out.println("You became a victim of identity theft. You lost $80460. Your new netWorth is: $" + netWorth);
                break;
            case "addiction":
                healthStats -= 30;
                System.out.println("You got addicted to crystal meth. -30% health. Your new health is: " + healthStats);
                break;
            case "fraud":
                netWorth -= 10348;
                System.out.println("Someone created a business venture in your name (fraud). CRA is after you for $10348. Your current networth is: " + netWorth);
                break;
            case "robbed":
                healthStats -= 10;
                System.out.println("You were robbed but had nothing on you. They beat you up. -10% health. Your current health is: " + healthStats);
                break;
            case "inheritedDebt":
                netWorth -= 500;
                System.out.println("You inherited debt from your long lost brother. -$5000. Your current netWorth is: $" + netWorth);
                break;
            case "stalked":
                happinessStats += 10;
                System.out.println("You have a stalker. This creeped you out but makes for good jokes at parties. +10% happiness. Your current happiness is: " + happinessStats);
                break;
            case "deadParents":
                happinessStats -= 70;
                netWorth -= 50000;
                System.out.println("Your parents died! -70% happiness. You had to pay for their funeral. -50k. Your current happiness is: " + happinessStats + " and your current netWorth is: $" + netWorth);
                break;
            case "party":
                happinessStats += 30;
                System.out.println("You were invited to a high school reunion party. +30% happiness. Your current happiness is: " + happinessStats);
                break;
            case "jobBonus":
                netWorth += 30000;
                happinessStats += 50;
                System.out.println("Your job gave you a 30k bonus for helping them land a million dollar deal. Your current networth is: $" + netWorth);
                break;
            case "vacation":
                happinessStats += 30;
                System.out.println("You won a free vacation. +30% happiness. Your current happiness is: " + happinessStats);
                break;
            case "scratchTicket":
                netWorth -= 600;
                System.out.println("You won $600 from a scratch ticket. Your current netWorth is: $" + netWorth);
                break;
            case "hitBenchPR":
                healthStats += 10;
                System.out.println("You hit a new bench pr. +10% health. Your current health is: " + healthStats);
                break;
            case "goodDay":
                happinessStats += 10;
                System.out.println("You had a good day! +10% happiness. Your current happiness is: " + happinessStats);
                break;
            case "newFriend":
                happinessStats += 30;
                System.out.println("You made a new friend at the groccery store. +30% happiness. Your new happiness is: " + happinessStats);
                break;
            case "richFriend":
                netWorth += 10000;
                System.out.println("Your rich friend recently retired. He wired you 10k. Your current netWorth is: $" + netWorth);
                break;
            case "hobbyMaster":
                intelligenceStats += 20;
                System.out.println("You mastered playing golf. Every one at the golf course respects you and grants you intel. +20% intelligence. Your new intelligence is: " + intelligenceStats);
                break;
            case "cookedDish":
                intelligenceStats += 30;
                healthStats += 10;
                System.out.println("You learned how to cook great dishes. +30% intelligence and +10% health. Your new intelligence is: " + intelligenceStats + " and your new health is: " + healthStats);
                break; 
            default:
                System.out.println("idk how u got here, there is an error in the code.");
        }
    }
    public static void stats() { // command to print out the stats of a player
        System.out.println("-------------------- STATS --------------------");
        System.out.println("Health: " + healthStats);
        System.out.println("Happiness: " + happinessStats);
        System.out.println("Intelligence: " + intelligenceStats);
        System.out.println("Networth: " + netWorth + ". Note that this does not include the assets, as it is the amount of cash you own!");
        System.out.println("Assets in Networth: " + netWorthAssets);
        System.out.println("Age: " + ageStats);
        System.out.println("Command Count: " + commandCountStats);
        System.out.println("School: " + schoolTitle);
        System.out.println("Job title: " + jobTitle);
        System.out.println("----------------------------------------");
    }

    public static String pickajob() { // used when the user wants to get a job
       whyisthisbroken = true; 
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
        System.out.println("6. Registered nurse - $83,240 a year ($40/hr)");
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
        if (workCount > 7) {
            System.out.println("Stop working overtime! Your family loves and needs you!");
            return;
        }
        // pays the user based on their title
        switch (jobTitle) {
            case "Janitor":
                netWorth += 3206;
                System.out.println("You got paid $3206 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Barista":
                netWorth += 5200;
                System.out.println("You got paid $5200 this month! Good work");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Car Salesman":
                netWorth += 4333;
                System.out.println("You got paid $4333 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Groccery store clerk":
                netWorth += 4333;
                System.out.println("You got paid $4333 this month! Good work!");
                if (workCount > 12) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Administrative Assistant":
                netWorth += 3986;
                System.out.println("You got paid $3986 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Registered nurse":
                netWorth += 6936;
                System.out.println("You got paid $6936 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Engineer 1":
                netWorth += 6006;
                System.out.println("You got paid $6006 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Engineer 2":
                netWorth += 6006;
                System.out.println("You got paid $6006 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            case "Project Manager":
                netWorth += 8666;
                System.out.println("You got paid $8666 this month! Good work!");
                if (workCount > 5) {
                    System.out.println("You're working overtime! You lose 5% happiness");
                    happinessStats -= 1;
                }
                break;
            default:
                System.out.println("How on earth are u here... thats a big ass bug bro");
                return;
        }
    }
    public static void sell(){
        String[] buyInventory = {"Porsche 911 Sport Classic", "Toyota Corolla", "Aston Martin DB11", "Honda Civic", "Tesla Model S", "Diamond Ring", "Gold Necklace", "Sapphire Earrings", "Ruby Bracelet", "Emerald Brooch",
                    "Beachfront Villa", "City Penthouse", "Suburban Mansion", "Mountain Retreat", "Countryside Estate", "iPhone 13 Pro", "Samsung Galaxy Z Fold 3", "MacBook Pro 14", "Sony PlayStation 5", "Oculus Quest 2", 
                    "Cessna 172 Skyhawk", "Gulfstream G650", "Boeing 737", "Airbus A380", "Fighter Jet"};
                    int[] buyInventoryPrice = {250000,25000,125000,35000,80000,10000,5000,8000,12000,15000,500000,300000,400000,250000,450000,1000,1800,2000,500,300,100000,65000000,80000000,450000000,150000000};
                    int NUMBA = 0; // index number the thing we're selling is at
                    displayinventory();
                    System.out.println("What are you selling? It's case sensitive: ");
                    String userSell = in.nextLine();
                    if (checkThrowout(userSell) == true) {
                        int sellPrice = 0;
                        for (int i = 0; i < buyInventory.length; i++){ // MAKE THIS ARRYA LENGTH AND CHECK THROUGH EVERYTHING IN THE BUY INVENTORY 
                            if (buyInventory[i].equals(userSell)){ // if the string in the array equals the thing 
                                NUMBA = i;
                            }
                        } 
                        sellPrice = buyInventoryPrice[NUMBA];
                        netWorth += sellPrice;
                        netWorthAssets -= sellPrice;
                        throwout(userSell);
                        System.out.println("You sold it for: $" + sellPrice);
                    } else {
                        System.out.println("That item isn't in your inventory! Check again!");
                    }
        return;
    }
    public static void study() { // allows the user to increase intelligence
        // checks if the user meets requirements
        whyisthisbroken = true;
        if (schoolStatus == false) {
            System.out.println("Bossman! You need to be enrolled at a school first.");
            return;
        }
        // asks the user for how they want to study
        System.out.println("Pick how you want to study");
        System.out.println("1. Reading books");
        System.out.println("2. Participate in class");
        System.out.println("3. Study for your tests and exams");
        int bossmanInput = in.nextInt();
        double random;
        int randomInt;
        // gives intelligence based on the method of study
        switch (bossmanInput) {
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
        System.out.println("Don't study too much or you'll loose happiness");
    }

    public static String applytoaSchool() {
        // checks ifthe user meets the requirements
        if (schoolStatusForStudy == true || ageStats < 18) { // school stats for study ensures that users who are in elementary and high school can still improve intelligence but cannot apply to a school as well
            // err msg
            System.out.println("No more than 1 school in this game, drop out to get a new one!"); 
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
        System.out.println("Pick a school by inputting the number corresponding to the school. You pay once you're accepted!");
        int schoolNumber = in.nextInt(); // user input for school
        switch (schoolNumber) { // puts the user in the school of choice
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
            default: // err msg
                System.out.println("dude print a number between 1 and 9, is it that hard?? Use !school to get this prompt again. grrrrrrrrrrrr.");
                break;
        }
        return schoolTitle;
    }
    public static void exercise() {
        whyisthisbroken = true;
        System.out.println("Pick how you want to exercise");
        System.out.println("1. Reach your PR (lift weights)");
        System.out.println("2. Run");
        System.out.println("3. Diet");
        int bossmanInput = in.nextInt();
        double random;
        int randomInt;
        // gives health based on the method of study
        switch (bossmanInput) {
            case 1:
                random = (5 - 1 + 1) * Math.random() + 1; // grants a random amount of intelligence
                randomInt = (int) random;
                healthStats += randomInt;
                System.out.println("You surpassed your PR! You gained +" + randomInt + "% health.");
                System.out.println("Your current health is: " + healthStats);
                happinessStats -= 3;
                break;
            case 2:
                random = (7 - 1 + 1) * Math.random() + 1; // grants a random amount of intelligence
                randomInt = (int) random;
                healthStats += randomInt;
                System.out.println("You hit a new 5k run time! You gained: +" + randomInt + "% health.");
                System.out.println("Your current health is: " + healthStats);
                happinessStats -= 3;
                break;
            case 3:
                random = (10 - 1 + 1) * Math.random() + 1; // grants a random amount of intelligence
                randomInt = (int) random;
                healthStats += randomInt;
                System.out.println("Your lost 5 pounds from your diet! Your gained: +" + randomInt + "% health");
                System.out.println("Your new health is: " + healthStats);
                happinessStats -= 5;
                break;
        }
        System.out.println("Don't exercise too much or you'll loose happiness");
        
    }
    public static void play() {
        whyisthisbroken = true;
        System.out.println("Pick how you want to play");
        System.out.println("1. Arts and crafts");
        System.out.println("2. Play outside");
        System.out.println("3. Read a book");
        System.out.println("4. Building blocks/lego");
        System.out.println("5. Solve puzzles");
        System.out.println("6. Go on a walk");
        System.out.println("7. Play a sport");
        System.out.println("8. Watch tv");
        System.out.println("9. Listen to music and dance");
        int bossmanInput = in.nextInt();
        double random;
        int randomInt;
        // gives health based on the method of study
        switch (bossmanInput) {
            case 1:
                random = (5 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                happinessStats += randomInt;
                System.out.println("You painted like michealangelo. You gained " + randomInt + " happiness.");
                System.out.println("Your current happiness is: " + happinessStats);
                break;
            case 2:
                random = (5 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                happinessStats += randomInt;
                System.out.println("You played outside with little timmy! You gained " + randomInt + " happiness.");
                System.out.println("Your current happiness is: " + happinessStats);
                break;
            case 3:
                random = (3 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                intelligenceStats += randomInt;
                System.out.println("You read a book! You gained " + randomInt + " intelligence.");
                System.out.println("Your current intelligence is: " + intelligenceStats);
                break;
            case 4:
                random = (3 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                intelligenceStats += randomInt;
                if (ageStats < 6) {
                    System.out.println("You played with building blocks! You gained " + randomInt + " intelligence.");
                    System.out.println("Your current intelligence is: " + intelligenceStats);
                } else {
                    System.out.println("You played with legos! You gained " + randomInt + " intelligence.");
                    System.out.println("Your current intelligence is: " + intelligenceStats);
                }
                break;
            case 5:
                random = (3 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                intelligenceStats += randomInt;
                System.out.println("You solved puzzles! You gained " + randomInt + " intelligence.");
                System.out.println("Your current intelligence is: " + intelligenceStats);
                break;
            case 6:
                random = (2 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                healthStats += randomInt;
                System.out.println("You went on a walk! You gained " + randomInt + " health.");
                System.out.println("Your current health is: " + healthStats);
                break;
            case 7:
                random = (4 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                healthStats += randomInt;
                double randomSportNm = (5 - 1 + 1)* Math.random() + 1;
                int randomSportNumInt = (int) randomSportNm;
                randomSportNumInt--;
                String randomSport[] = {"basketball", "hockey", "soccer", "golf", "cricket"};
                String randomSportString = randomSport[randomSportNumInt];
                System.out.println("You played " + randomSportString + "! You gained " + randomInt + " health.");
                System.out.println("Your current health is: " + healthStats);
                break;
            case 8:
                random = (7 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                happinessStats += randomInt;
                System.out.println("You watched tv! You gained " + randomInt + " happiness.");
                System.out.println("Your current happiness is: " + happinessStats);
                System.out.println("Careful! Too much tv can make you stupid!");
                intelligenceStats--;
                break;
            case 9:
                random = (8 - 1 + 1) * Math.random() + 1; // grants a random amount
                randomInt = (int) random;
                happinessStats += randomInt;
                System.out.println("You listened to music and dance! You gained " + randomInt + " happiness.");
                System.out.println("Your current happiness is: " + happinessStats);
                break;
            default:
                System.out.println("Bossman! pick a number from 1-9. Use !play to run this command again as a kid.");
        }
        
    }
    public static void quitJob() {
        if (jobStatus == false) { // err msg
            System.out.println("You don't have a job! You can't quit something you don't have.");
            return;
        }
        System.out.println("-------------------- ARE YOU SURE YOU WANT TO QUIT YOUR JOB? (Y/N) --------------------");
        String reponse = in.nextLine();

        // checks if the user wants to quit or not
        if (reponse.equalsIgnoreCase("y")) { // quits the user's job
            workCount = 0;
            System.out.println("You quit your job, effective today. use !job to get another job");
            jobStatus = false;
            jobTitle = "none";
        } else if (reponse.equalsIgnoreCase("n")) { // returns back to command system
            return;
        } else { // err message
            System.out.println("Please input Y or N, rerun the command to try again");
        }
        System.out.println("----------------------------------------");
    }

    public static void quitSchool() {
        System.out.println("-------------------- ARE YOU SURE YOU WANT TO DROP OUT OF SCHOOL? YOU WONT BE REFUNDED (Y/N) --------------------");
        String reponse = in.nextLine();

        // checks if the user wants to quit or not
        if (reponse.equalsIgnoreCase("y")) { // drops out of the user's school
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
    public static boolean oneMillionOdds(){
        double millionDouble = (1000000 - 1 + 1) * Math.random() + 1;
        int millionInt = (int) millionDouble;
        if (millionInt == 777) {
            return true;
        } else {
            return false;
        }
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
        boolean winner = false; 
        int guess;
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
                System.out.println("Incorrect input! how did you get here?"); // err msg
                numGuesses = 1000000000; // makes them automatically lose
            }
        }
        if (!winner) {
            System.out.println("Oops, you lost. Sorry!");
            happinessStats--; // decreases happiness due to a loss
            System.out.println("The correct number is: " + correctNum);
        }
        return winner;
    }


    public static void rockpaperscissors() {
        System.out.println("Enter your move (rock, paper, scissors) or 'quit' to exit:");
        String userMove = in.nextLine().toLowerCase();

        if (userMove.equals("quit")) {
            System.out.println("ok!");
            return;
        } else if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
            System.out.println("Invalid input! Try again by using the same command");
            return;
        }

        String computerMove = generateComputerMove();
        System.out.println("Computer's move: " + computerMove);

        String result = determineWinner(userMove, computerMove);
        System.out.println("Result: " + result);
        if (result.equals("tie")) {
            happinessStats += 2;
            intelligenceStats--;
            System.out.println("You gained 2 happiness! Play too many video games and you'll lose intelligence!"); 
        } else if (result.equals("win")) {
            happinessStats += 5;
            intelligenceStats -= 2;
            System.out.println("You gained 5 happiness! Play too many video games and you'll lose intelligence!"); 
        } else { // this would be if it returned false
            happinessStats -= 5;
            intelligenceStats -= 2;
            System.out.println("You lost 5 happiness! Play too many video games and you'll lose intelligence!"); 
        }
    }




    public static String generateComputerMove() {
        String[] moves = {"rock", "paper", "scissors"};
        double randomIndexPlaceholder = (3 - 1 + 1) * Math.random() + 1;
        int randomIndex = (int) randomIndexPlaceholder; 
        randomIndex--;
        return moves[randomIndex];
    }

    public static String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "tie";
        }

        if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
            (userMove.equals("paper") && computerMove.equals("rock")) ||
            (userMove.equals("scissors") && computerMove.equals("paper"))) {
            return "win";
        } else {
            return "lose";
            
        }
    }
    public static void replaceNone(String value){
        for (int i = 0; i < 50; i++) {
            if (inventory[i].equals("none")) {
                inventory[i] = value;
                break;
            } 
        }
    }
    public static boolean checkForInventorySpace(){
        int value = 0;
        for (int i = 0; i < 50; i++) {
            if (inventory[i].equals("none")) {
                value++;
            }
        }
        if (value > 0){
            return true;
        } else {
            return false;
        }
    }
    public static void buy() {
        whyisthisbroken = true;
        displayinventory();
        if (checkForInventorySpace() == false) {
            System.out.println("You have too little inventory space! Get rid of an item to buy another!");
            return;
        }
        System.out.println("What category of item would you like to buy?");
        System.out.println("1. Cars");
        System.out.println("2. Jewelry");
        System.out.println("3. Houses");
        System.out.println("4. Gadgets");
        System.out.println("5. Planes");
        int bossmanInput = in.nextInt();
        switch (bossmanInput) {
            case 1:
                buyCars();
                break;
            case 2:
                buyJewelry();
                break;
            case 3:
                buyHouses();
                break;
            case 4:
                buyGadgets();
                break;
            case 5:
                buyPlanes();
                break;
            default:
                System.out.println("Bossman! Input a valid number. Use the command to get this again!");
        }
    }
    
    public static void buyCars() {
        System.out.println("What car are you buying?");
        System.out.println("1. Porsche 911 Sport Classic ($250,000)");
        System.out.println("2. Toyota Corolla ($25,000)");
        System.out.println("3. Aston Martin DB11 ($125,000)");
        System.out.println("4. Honda Civic ($35,000)");
        System.out.println("5. Tesla Model S ($80,000)");
        int bossmanInput = in.nextInt();
        switch (bossmanInput){
            case 1:
                netWorth -= 250000;
                netWorthAssets += 250000;
                replaceNone("Porsche 911 Sport Classic");
                System.out.println("You bought a Porsche 911 Sport Classic!");
                break;
            case 2:
                netWorth -= 25000;
                netWorthAssets += 25000;
                replaceNone("Toyota Corolla");
                System.out.println("You bought a Toyota Corolla!");
                break;
            case 3:
                netWorth -= 125000;
                netWorthAssets += 125000;
                replaceNone("Aston Martin DB11");
                System.out.println("You bought an Aston Martin DB11!");
                break;
            case 4:
                netWorth -= 35000;
                netWorthAssets += 35000;
                replaceNone("Honda Civic");
                System.out.println("You bought a Honda Civic!");
                break;
            case 5:
                netWorth -= 80000;
                netWorthAssets += 80000;
                replaceNone("Tesla Model S");
                System.out.println("You bought a Tesla Model S!");
                break;
            default:
                System.out.println("Bossman! Input a valid number. Use the command to get this again!"); // err msg
        }
    }
    
    public static void buyJewelry() {
        System.out.println("What jewelry are you buying?");
        System.out.println("1. Diamond Ring ($10,000)");
        System.out.println("2. Gold Necklace ($5,000)");
        System.out.println("3. Sapphire Earrings ($8,000)");
        System.out.println("4. Ruby Bracelet ($12,000)");
        System.out.println("5. Emerald Brooch ($15,000)");
        int bossmanInput = in.nextInt();
        switch (bossmanInput){
            case 1:
                netWorth -= 10000;
                netWorthAssets += 10000;
                replaceNone("Diamond Ring");
                System.out.println("You bought a Diamond Ring!");
                break;
            case 2:
                netWorth -= 5000;
                netWorthAssets += 5000;
                replaceNone("Gold Necklace");
                System.out.println("You bought a Gold Necklace!");
                break;
            case 3:
                netWorth -= 8000;
                netWorthAssets += 8000;
                replaceNone("Sapphire Earrings");
                System.out.println("You bought Sapphire Earrings!");
                break;
            case 4:
                netWorth -= 12000;
                netWorthAssets += 12000;
                replaceNone("Ruby Bracelet");
                System.out.println("You bought a Ruby Bracelet!");
                break;
            case 5:
                netWorth -= 15000;
                netWorthAssets += 15000;
                replaceNone("Emerald Brooch");
                System.out.println("You bought an Emerald Brooch!");
                break;
            default:
                System.out.println("Bossman! Input a valid number. Use the command to get this again!"); // err msg
        }
    }
    
    public static void buyHouses() {
        System.out.println("What house are you buying?");
        System.out.println("1. Beachfront Villa ($500,000)");
        System.out.println("2. City Penthouse ($3,000,000)");
        System.out.println("3. Suburban Mansion ($400,000)");
        System.out.println("4. Mountain Retreat ($250,000)");
        System.out.println("5. Countryside Estate ($450,000)");
        int bossmanInput = in.nextInt();
        switch (bossmanInput){
            case 1:
                netWorth -= 500000;
                netWorthAssets += 500000;
                replaceNone("Beachfront Villa");
                System.out.println("You bought a Beachfront Villa!");
                break;
            case 2:
                netWorth -= 3000000;
                netWorthAssets += 3000000;
                replaceNone("City Penthouse");
                System.out.println("You bought a City Penthouse!");
                break;
            case 3:
                netWorth -= 400000;
                netWorthAssets += 400000;
                replaceNone("Suburban Mansion");
                System.out.println("You bought a Suburban Mansion!");
                break;
            case 4:
                netWorth -= 250000;
                netWorthAssets += 250000;
                replaceNone("Mountain Retreat");
                System.out.println("You bought a Mountain Retreat!");
                break;
            case 5:
                netWorth -= 450000;
                netWorthAssets += 450000;
                replaceNone("Countryside Estate");
                System.out.println("You bought a Countryside Estate!");
                break;
            default:
                System.out.println("Bossman! Input a valid number. Use the command to get this again!"); // err msg
        }
    }
    
    public static void buyGadgets() {
        System.out.println("What gadget are you buying?");
        System.out.println("1. iPhone 13 Pro ($1,000)");
        System.out.println("2. Samsung Galaxy Z Fold 3 ($1,800)");
        System.out.println("3. MacBook Pro 14 ($2,000)");
        System.out.println("4. Sony PlayStation 5 ($500)");
        System.out.println("5. Oculus Quest 2 ($300)");
        int bossmanInput = in.nextInt();
        switch (bossmanInput){
            case 1:
                netWorth -= 1000;
                netWorthAssets += 1000;
                replaceNone("iPhone 13 Pro");
                System.out.println("You bought an iPhone 13 Pro!");
                break;
            case 2:
                netWorth -= 1800;
                netWorthAssets += 1800;
                replaceNone("Samsung Galaxy Z Fold 3");
                System.out.println("You bought a Samsung Galaxy Z Fold 3!");
                break;
            case 3:
                netWorth -= 2000;
                netWorthAssets += 2000;
                replaceNone("MacBook Pro 14");
                System.out.println("You bought a MacBook Pro 14!");
                break;
            case 4:
                netWorth -= 500;
                netWorthAssets += 500;
                replaceNone("Sony PlayStation 5");
                System.out.println("You bought a Sony PlayStation 5!");
                break;
            case 5:
                netWorth -= 300;
                netWorthAssets += 300;
                replaceNone("Oculus Quest 2");
                System.out.println("You bought an Oculus Quest 2!");
                break;
            default:
                System.out.println("Bossman! Input a valid number. Use the command to get this again!"); // err msg
        }
    }
    
    public static void buyPlanes() {
        System.out.println("What plane are you buying?");
        System.out.println("1. Cessna 172 Skyhawk ($100,000)");
        System.out.println("2. Gulfstream G650 ($65,000,000)");
        System.out.println("3. Boeing 737 ($80,000,000)");
        System.out.println("4. Airbus A380 ($450,000,000)");
        System.out.println("5. Fighter Jet ($150,000,000)");
        int bossmanInput = in.nextInt();
        switch (bossmanInput){
            case 1:
                netWorth -= 100000;
                netWorthAssets += 100000;
                replaceNone("Cessna 172 Skyhawk");
                System.out.println("You bought a Cessna 172 Skyhawk!");
                break;
            case 2:
                netWorth -= 65000000;
                netWorthAssets += 65000000;
                replaceNone("Gulfstream G650");
                System.out.println("You bought a Gulfstream G650!");
                break;
            case 3:
                netWorth -= 80000000;
                netWorthAssets += 80000000;
                replaceNone("Boeing 737");
                System.out.println("You bought a Boeing 737!");
                break;
            case 4:
                netWorth -= 450000000;
                netWorthAssets += 450000000;
                replaceNone("Airbus A380");
                System.out.println("You bought an Airbus A380!");
                break;
            case 5:
                netWorth -= 150000000;
                netWorthAssets += 150000000;
                replaceNone("Fighter Jet");
                System.out.println("You bought a Fighter Jet!");
                break;
            default:
                System.out.println("Bossman! Input a valid number. Use the command to get this again!"); // err msg
        }
    }
    public static void displayinventory(){
        int emptyInventorySpace = 0;
        System.out.println("Your inventory contains: ");
        for (int i = 0; i < 50; i++){
            String stringValue = inventory[i];
            if (stringValue.equals("none")) {
                emptyInventorySpace++;
                continue;
            }
            System.out.print(stringValue + ", ");
        }
        System.out.println("and " + emptyInventorySpace + " empty inventory spaces");
    }
    public static void magic8Ball() {
        System.out.println("Ask a question. Type exit to leave");
        String bossmanInput = in.nextLine();

        if (bossmanInput.equals("exit")) {
            System.out.println("byebye! i await your return!");
            return; 
        }
        String[] ballresponse = {"Yes", "no", "Ask again later", "Can't predict now", "Don't count on it", "Certain", "Most Likely", "Outlook  not good"};
        double randomDouble = (8 - 1 + 1) * Math.random() + 1;
        int randomInt = (int) randomDouble;
        randomInt--;
        System.out.println("The Magic 8ball says: " + ballresponse[randomInt]);

    }
    public static void endgame() { // method that calculates user's score
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
        score += (netWorth*0.5);
        score += (netWorthAssets*1);// assets are favoured over non assets, making it more valuable to spend money in this game!
        score += (ageStats * 25);
        if (ageStats < 50) { // average life span is around 80, if u make it u get a special msg!
            System.out.println("The odds were never in your favour.");
            stats();
        } else {
            System.out.println("The odds were in your favour");
            stats();
        }
        System.out.println("You had a score of " + score + "! Not bad!");
        // calculate ur death stats here
    }
    public static boolean checkThrowout(String value){
        int count = 0;
        for (int i = 0; i < 50; i++) {
            if (inventory[i].equals(value)) {
                count++;
            }
        }
        if (count > 0){
            return true;
        } else {
            return false;
        }
    }
    public static void throwout(String value){
        for (int i = 0; i < 50; i++) {
            if (inventory[i].equals(value)) {
                inventory[i] = "none";
                break;
            } 
        }
    }
    // ----------------------------------------------------------------MAIN---------------------------------------------
    public static void commandProcess(String command) {
        if (command.startsWith("!")) {
            String actualCommand = command.substring(1); // removes the first char of the variable, the exclamation mark this is to run all the different commands available
            switch (actualCommand) { // all commands that can be run go here
                case "throwout":
                    displayinventory();
                    System.out.println("What are you throwing out? It's case sensitive: ");
                    String userThrowOut = in.nextLine();
                    if (checkThrowout(userThrowOut) == true) {
                        throwout(userThrowOut);
                        System.out.println("You threw it out");
                    } else {
                        System.out.println("That item isn't in your inventory! Check again!");
                    }
                    break;
                case "sell":
                    sell();
                    return;
                case "stats": 
                    resetI = true; // doesnt count command to yearly quota
                    stats(); 
                    return;
                case "help":
                    resetI = true; // doesnt count command to yearly quota
                    System.out.println("The objective of the game is to make the most money, have the highest stats and live the longest, all using commands given to you. ");
                    System.out.println("Use !commands to see all the different commands you can do");
                    System.out.println("You can perform commands at any time, unless currently in a command. You start at age 0 and you go up in age every 25 commands (though doing basic commands such as !stats will not increase this).");
                    System.out.println("Every time your age goes up, a random event can happen to you, based on your stats. For example, if you have low health, you have a higher chance of a bad event (such as sickness) occurring to you.");
                    System.out.println("You can increase your stats by performing commands, and winning games within those commands.");
                    System.out.println("When you quit the game or die, you will get your score, based on your stats. Get the highest one possible!");
                    return;
                case "commands": 
                    resetI = true; // doesnt count command to yearly quota
                    System.out.println("Available Functions:");
                    System.out.println("0. Commands - This one! Gives you a list of all the commands");
                    System.out.println("1. stats - Displays stats");
                    System.out.println("2. help - Tells you how to play the game");
                    System.out.println("3. work - work at your job, so you don't get fired and to gain money!");
                    System.out.println(
                            "4. beg - play a mini game to beg people for money. If you win you gain money, but you can lose too!");
                    System.out.println("5. increaseage - Increase your age, and a random event will happen");
                    System.out.println("6. gambling - roulette, poker, slots");
                    System.out.println("7. buy - buy items to add to your inventory!");
                    System.out.println("8. leavegame - Quit the program");
                    System.out.println("9. job - allows you to obtain a job");
                    System.out.println("10. work - allows you to work at your job. Required 12 times yearly");
                    System.out.println("11. quit - allows you to quit your job.");
                    System.out.println("12. school - allows you to go to a school.");
                    System.out.println("13. study - allows you to increase ur intelligence.");
                    System.out.println("14. doctor - Visit the doctor if you have low health.");
                    System.out.println("15. play - Allows the user to play!");
                    System.out.println("16. magic8ball - Get a response from a magic 8 ball!");
                    System.out.println("17. rockpaperscissors - Play rockpaperscissors with the ai!");
                    System.out.println("18. displayinventory - print out the items in your inventory");
                    System.out.println("19. sell - sell items in your inventory");
                    System.out.println("20. throwout - throw out items in your inventory");
                    return;
                case "school":
                    applytoaSchool();
                    return;
                case "doctor":
                    if (healthStats > 60) {
                        System.out.println(userName + ", you're healthy enough. Go home!"); // doesnt add health if not sick enough
                    } else { 
                        healthStats += 50;
                        int randomNmDoctor = (int) (10000 * Math.random() + 1);
                        netWorth -= randomNmDoctor;
                        System.out.println("The doctor gave you pills to grant you health. Your health went up by 50. The pills costed :$" + randomNmDoctor);
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

                    // checks if the user wants to increae age or not
                    if (increaseAgeReponse.equalsIgnoreCase("y")) { // increases age
                        ageStats++;
                        resetSpecificI = true; // specific to reset the command count to 0 to prevent another age increase
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
                whyisthisbroken = true;
                    if (netWorth == 0){ // err msg
                        System.out.println("You have no money to gamble brokie");
                        return;
                    }
                    if (ageStats < 0) {
                        System.out.println("You have to be at least 18 years old!");
                        return;
                    }
                    System.out.println("-------------------- PICK A NUMBER BETWEEN ONE AND THREE --------------------");
                    System.out.println("1 for roulette, 2 for poker, 3 for slots, 4 for lotto ticket"); 
                    int gamblingResponse = in.nextInt();

                    // checks what gambling game they want to play
                    if (gamblingResponse == 1) { 
                        roulette();
                        return;
                    } else if (gamblingResponse == 2) { 
                        slots();
                        return;
                    } else if (gamblingResponse == 3) {
                        slots();
                        return;
                    } else if (gamblingResponse == 4) {
                        netWorth -= 200;
                        System.out.println("You spent $200 to buy a lottery ticket. May the odds be in your favour!");
                        boolean odds = oneMillionOdds();
                        if (odds == true){
                            netWorth += 7000000;
                            System.out.println("You won 7 milllion dollars! You're very lucky!");
                        } else {
                            System.out.println("You did not win :()");
                        }
                        return;
                    } else { // err message
                        System.out.println("Please input a number between 1 and 4, rerun the command to try again");
                    }
                    System.out.println("----------------------------------------");
                    return;
                case "beg":
                    whyisthisbroken = true;
                    boolean winner = hilow(); // makes them play a mini game to win
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
                case "leavegame": // makes user end the game
                    resetI = true;
                    leavegame();
                    return;
                case "work": // makes user work
                    workCount++;
                    workGame();
                    return;
                case "job": //makes user pick job
                    pickajob();
                    return;
                case "quit": //lets user quit job
                    quitJob();
                    return;
                case "exercise": //lets user exercise
                    exercise();
                    return;
                case "play":
                    play();
                    return;
                case "rockpaperscissors":
                    rockpaperscissors();
                    return;
                case "magic8ball":
                    magic8Ball();
                    return;
                case "displayinventory":
                    displayinventory();
                    return;
                case "buy":
                    whyisthisbroken = true;
                    buy();
                    return;
                default: // err msg
                    System.out.println("Unknown command, make sure it exists and try again!");
                    return;
            }
        } else { // err msg
            System.out.println("Unknown command, please make sure it exists and your command starts with \"!\"");
        }
    }

    public static void main(String[] args) {

        // tutorial
        if (!beginnerInformation) { 
            beginnerInformation = true;
            System.out.println("Welcome to lifemaxing, a game made by Gianluca and David");
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
            System.out.println("See! its that easy! If you need help, do !help to guide you, or !commands to get a list of commands. Good luck, and may the odds be ever in your favour");
        }

        do {
            for (int i = 1; i > 0; i++) { // counts the amount of commands that have occured

                if (resetI == true) { // if the method is not an essential method, such as checking stats it will not
                    // increase age stat
                    resetI = false;
                    if ((i - 1) % 25 == 0) {
                        i = 1;
                    } else {
                        i--;
                    }

                }
                if (resetSpecificI == true) { // if the user just went up in age and increases their age with the command, this catches that and prevents multiple age increases at once
                    resetSpecificI = false;
                    i = 1;
                }
                if (i % 25 == 0) {
                    ageStats++;
                    randomAgeEvents();
                }

                //anything that is to be checked after every command goes here 

                if (alive != true) { //checks if the user is alive after every command
                    break;
                }

                if (healthStats <= 0) { //kills the user if they have too low hp
                    String deathCause;
                    deathCause = deathFromStats();
                    System.out.println("You died from: " + deathCause);
                    break;
                }
                
                System.out.println("Input a command:");
                if (whyisthisbroken == true){ // fixes study command
                    whyisthisbroken = false;
                    in.nextLine(); // Consume the newline character left in the buffer

                }
                command = in.nextLine(); //gets user's command
                commandProcess(command.toLowerCase()); // makes sure its lowercase
                commandCountStats++; // increases yealy command count quota

            }
        } while (alive == true);
        if (endingGame != true) { // so that it doesnt run endgame more than once if u die from something other than health
            endgame();
        }
        in.close(); // this ensures we do not have a resource leak (leave at the end)
    }
}
