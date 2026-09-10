# PookieWookie

PookieWookie is a Java-based console life simulation game developed as a school programming project. The game allows the player to progress through a simulated life by making decisions, performing activities, developing skills, earning money, attending school, working, purchasing items, and reacting to random life events.

The project began as a paper-based design where the overall game structure, player progression, statistics, and possible actions were mapped out before development began. From that initial plan, the concept was expanded into a larger command-driven Java program with interconnected systems that allow a player's choices to influence their future opportunities.

---

## About the Game

The main idea behind PookieWookie is that the player is given control over how they spend their life.

Instead of progressing automatically, the player enters commands into the console to perform different actions. These actions can affect several parts of the character's life, including:

- Health
- Happiness
- Intelligence
- Money / Net Worth
- Assets
- Education
- Employment
- Inventory
- Age
- Future opportunities

Some actions provide immediate benefits, while others may have consequences later in the game.

For example, a player may choose to spend their time studying to increase intelligence, working to earn money, buying assets, or participating in other activities. As the player's statistics and age increase, additional opportunities become available.

---

## Life Progression System

The game uses a command-based aging system.

The player begins at a young age and is given a limited number of actions before progressing to the next year of their life.

After approximately **50 commands**, the player's age increases.

This means that the player can decide how they want to spend each stage of their life.

A player could:

- Use their available actions to earn money
- Improve intelligence
- Attend school
- Work
- Purchase items
- Participate in different activities
- Check their statistics
- Progress through commands quickly

As the player becomes older, additional systems and opportunities become accessible.

This creates a progression system where the player's decisions earlier in the game can influence what they are able to do later.

---

## Player Statistics

The game keeps track of several persistent player variables.

Some of the primary statistics include:

### Health

Represents the physical condition of the player.

Certain events may increase or decrease health. If health becomes too low, the player may die and the game can end.

### Happiness

Represents the overall happiness of the character.

Activities and random events can increase or decrease happiness throughout the player's life.

### Intelligence

Intelligence is an important progression statistic.

It can be increased through activities such as studying and may be required to qualify for certain jobs or opportunities later in the game.

### Net Worth

Tracks the amount of money the player currently owns.

Players can earn money by working and can spend it on items, activities, or other systems within the game.

### Assets

The game separately tracks the value of assets owned by the player.

This allows the player's overall financial position to extend beyond simply the amount of cash they currently have.

---

## Education System

Players can participate in the education system to increase their intelligence and improve future opportunities.

Education takes place over multiple years rather than providing an immediate reward.

If the player remains enrolled long enough to complete their education, they can receive a significant intelligence increase.

This creates a tradeoff between spending commands earning money immediately and investing time into education for better opportunities later.

---

## Employment System

Once the player reaches the appropriate age, they can begin applying for jobs.

Different jobs have different requirements.

The player's intelligence and other conditions can influence whether they qualify for a position.

Once employed, the player can use the work system to earn money.

However, employment also requires the player to remain active. Failing to work enough during a year can result in the character being fired.

This adds another decision-making element to the game because players must balance:

- Work
- Education
- Statistics
- Money
- Other activities

---

## Random Life Events

One of the major systems in PookieWookie is the random event system.

Whenever the player ages, different events can occur depending on their current stage of life.

The program contains separate event groups for different ages, including events that occur during:

- Early childhood
- Childhood
- Student years
- Adulthood

These events can affect the player's:

- Health
- Happiness
- Intelligence
- Money
- Overall progression

For example, some events may reward the player with increased happiness or intelligence, while others can cause financial losses or reduce health.

Because these events are randomized, each playthrough can develop differently.

---

## Economy and Inventory

PookieWookie includes an economy that allows players to earn, spend, and manage money.

Players can purchase different items and assets throughout the game.

Owned items are stored in an inventory system and can later be sold.

When an item is sold:

1. The item is removed from the player's inventory.
2. The player receives the item's sale value.
3. Their cash balance is updated.
4. Their asset value is adjusted.

This creates a basic financial system where players can build wealth through both cash and owned assets.

---

## Games and Risk

The game also contains optional activities that allow players to risk money.

These systems introduce probability and randomness into the simulation.

Depending on the outcome, the player may gain or lose money and their statistics may also change.

These mechanics were included to give the player additional choices for how they want to spend their available commands.

---

## Project Development

PookieWookie was originally developed as a school project.

Before programming began, the game was planned on paper. The initial design outlined:

- The main concept of the game
- Player statistics
- Available commands
- Character progression
- Aging
- Jobs
- Education
- Money
- Random events

Once the basic structure was established, the design was translated into Java.

As development continued, additional systems were added and connected together.

The final program grew into a large console application containing more than **1,900 lines of Java code**.

The project provided experience working with:

- Java
- Conditional statements
- Loops
- Methods
- Arrays
- User input
- Random number generation
- State management
- Game logic
- Progression systems
- Debugging
- Large program organization

---

## How to Run PookieWookie

PookieWookie runs completely through the terminal or command prompt.

You will need Java installed on your computer.

### 1. Check that Java is installed

Open a terminal and run:

```bash
java -version
