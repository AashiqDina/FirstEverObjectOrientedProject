/** A class meant to put everything together to complete the game
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game{

/*Method used to print out startine statement as seen, record the user's input and return it to where the method was called**/
  public static String enterName(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Hello Adventurer, What is your name?");
    String userInput = scanner.nextLine();
    System.out.println("Hello there " + userInput + ", it is time to begin your journey...");

    return userInput;
  }
/*A method which takes in a Hero, Monster, Shop object and an ArrayList of items,
 with ths it prints out the statement as seen and takes in the user's input and...**/
  public static boolean userChoice(Hero userHero, Monster enemy, Shop theShop, ArrayList<Items> userInventory){
    Scanner scanner = new Scanner(System.in);
    boolean monsterDead = false;

    System.out.println("");
    System.out.println("");
    System.out.println("It's your turn, what will you do? (Type the options exactly)");
    System.out.println("   Attack   |   Items   |   Stats   |   Shop   |   Run   ");
    System.out.println("");
    String userInput = scanner.nextLine();
    while (!userInput.equals("Attack") && !userInput.equals("Run")){            // whilst the student user's input is equal not equal to "Attack" or "Run" the loop will continue
      if (userInput.equals("Stats")) {
        userHero.stats();                                                       // calls the method stats from the hero class if the user's input is "Stats"
      }
      if (userInput.equals("Shop")) {
        theShop.displayItems();                                                 // calls the method displayItems from the Shop method
        System.out.println("Type exactly what you would like to buy");          // prints statement as seen
        userInput = scanner.nextLine();                                         // the user's input is stored in the variable userInput
        boolean canBuy = theShop.buyItem(userInput, userHero);                  // calls the method buyItem from the class Shop and stores the returned boolean value
        if (canBuy == true) {
          if (theShop.returnItemOne().returnItemName().equals(userInput)) {                                         // calls method to return a String value and checks if it is the same as the user input
            userInventory.add(theShop.returnItemOne());                                                             // calls method to return an item and adds that item to the array list
            System.out.println("You have successfully bought a " + theShop.returnItemOne().returnItemName());       // prints statement as seen
          }
          else if (theShop.returnItemTwo().returnItemName().equals(userInput)) {                                    // repeat of the above code but with a different item
            userInventory.add(theShop.returnItemTwo());
            System.out.println("You have successfully bought a " + theShop.returnItemTwo().returnItemName());
          }
          else if (theShop.returnItemThree().returnItemName().equals(userInput)) {                                  // repeat of the above code but with a different item
            userInventory.add(theShop.returnItemThree());
            System.out.println("You have successfully bought a " + theShop.returnItemThree().returnItemName());
          }
          else if (theShop.returnItemFour().returnItemName().equals(userInput)) {                                   // repeat of the above code but with a different item
            userInventory.add(theShop.returnItemFour());
            System.out.println("You have successfully bought a " + theShop.returnItemFour().returnItemName());
          }
          else if (theShop.returnItemFive().returnItemName().equals(userInput)) {                                   // repeat of the above code but with a different item
            userInventory.add(theShop.returnItemFive());
            System.out.println("You have successfully bought a " + theShop.returnItemFive().returnItemName());
          }
          else{
            System.out.println("An error has occured.");                        // prints out statement as seen
          }
        }
      }

      if (userInput.equals("Items")) {
        System.out.println("--------------------------------------------------------------");                     // prints statement as seen
        System.out.println("");

        for (int i = 0; i<=userInventory.size()-1; i++ ) {                                                        // prints out all the items in the array list
          System.out.println(i+1 + ": " + userInventory.get(i).returnItemName());
        }

        System.out.println("");                                                                                   // prints as seen
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        System.out.println("Type the number of the item you wish to select");
        userInput = scanner.nextLine();                                                                           // takes in user input and converts it into an int
        int intUserInput = Integer.parseInt(userInput) - 1;

        try {                                                                                                     // checks this section of code for errors
          System.out.println("What would you like to do with the " + userInventory.get(intUserInput).returnItemName() + " (Type exactly)");      // prints statement as seen
          System.out.println("   Use Item   |   View Item Description");
          userInput = scanner.nextLine();                                                                         // takes user input and checks if its the same as what is seen
          if (userInput.equals("Use Item")) {
            boolean outcome = userInventory.get(intUserInput).useItem(userHero);                                  // calls method and returned value is stored in the variable outcome
            if (outcome == true) {
              System.out.println("You have successfully used the item");                                          // checks if outcome is true and if it is
              userInventory.remove(intUserInput);                                                                 // then it removes the number the user inputed from the arraylist
            }
            else{
              System.out.println("You were unable to use the item");                                              // prints statement as seen
            }
          }
          else if (userInput.equals("View Item Description")){                                                    // prints statement as seen
            userInventory.get(intUserInput).checkItemDescription();                                               // gets item object and calls method
          }
        }
        catch (IndexOutOfBoundsException e){                                                                      // If there is an index out of bounds error then it
          System.out.println("That item number does not exist");                                                  // prints statement as seen
        }
        catch (NumberFormatException e){                                                                          // if the user's input is not a number and anything else is tried to be converted to an int it
          System.out.println("Thats not a number");                                                               // it prints out the statement as seen
        }

      }
      System.out.println("");                                                                                      // prints statements as seen
      System.out.println("");
      System.out.println("Please choose one of the following:");
      System.out.println("   Attack   |   Items   |   Stats   |   Shop   |   Run   ");
      System.out.println("");


      userInput = scanner.nextLine();                                                                              // user input is stored in the variable userInput
    }
    if (userInput.equals("Attack")) {                                                     // checks if the value of userInput is equal to "Attack" and if it is...
      monsterDead = userHero.attackEnemy(enemy);                                          // it calls the method and the returned value is stored in the variable monsterDead
      if (monsterDead == true) {
        userHero.gainExperience(enemy.getMaxMonsterHealth());                             // calls the gain experience method from the hero class using the monster's health
        System.out.println("You have defeated the " + enemy.getMonsterName() + "!");      // prints statement as seen
        enemy.monsterDefeated(userHero);                                                  // calls monsterDefeated method from the monster class
      }
    }
    if (userInput.equals("Run")){                                                         // is the user's input is "Run" then monsterDead is set to true and the following statement is printed
      monsterDead = true;
      System.out.println("You have ran away from the " + enemy.getMonsterName() + "!");
    }

    return monsterDead;                                                         // returns the value of monsterDead
  }
  /*Takes in 5 monster variable and generates a random number, depending on that number a monster is returned**/
  public static Monster randomMonster(Monster dragon, Monster reaper, Monster ogre, Monster goblin, Monster slime){
    Random random = new Random();                          // create new random variable
    int randomNumber = random.nextInt(1000);               // a random number is generated between 0-999

    if (randomNumber <= 500) {                             // returns slime if the random number is less than 501
      return slime;
    }
    else if (randomNumber <= 700) {                        // returns goblin if the random number is less than 701
      return goblin;
    }
    else if (randomNumber <= 850) {                        // returns ogre if the random number is less than 851
      return ogre;
    }
    else if (randomNumber <= 950) {                        // returns reaper if the random number is less than 951
      return reaper;
    }
    else if (randomNumber <= 1000) {                        // returns dragon if the random number is less than 1001
      return dragon;
    }
    else{
      return slime;                                         // returns slime
    }
  }

  /*Creates all the variables and sets everything for the actual game**/
  public static void main(String[] args){
      Hero userCharacter = new Hero(enterName());                               // creates a variety of objects for Hero, Monster, Items and Shop
      Monster theSlime = new Slime("Slime", 15, 2, 5, 55);
      Monster theGoblin = new Goblin("Goblin", 50, 4, 20, 50);
      Monster theOgre = new Ogre("Ogre", 100, 6, 50, 100);
      Monster theReaper = new Reaper("Reaper", 150, 8, 75, 150);
      Monster theDragon = new Dragon("Dragon", 200, 10, 100, 200);
      Items miniPotion = new HealingItem("Mini Potion", 5, 5);
      Items potion = new HealingItem("Potion", 20, 15);
      Items largePotion = new HealingItem("Large Potion", 50, 30);
      Items skySword = new Weapons("Sword of the Sky", 100, 100);
      Items luckyAmulet = new MiscellaneousItems("Lucky Amulet", 999, "An amulet said to bring good fortune");
      Shop shop = new Shop(miniPotion, potion, largePotion, skySword, luckyAmulet);
      boolean monsterDead = false;

      ArrayList<Items> inventory = new ArrayList<Items>();                      // creates an ArrayList for the inventory

      for (int i = 1;i<=30 ;i++ ) {                                                                       // creates a loop for different monsters
        Monster randomMonster = randomMonster(theDragon, theReaper, theOgre, theGoblin, theSlime);        // generates a random monster (using the above method)
        randomMonster.monsterEncounter();                                                                 // calls method monsterEncounter
        while(monsterDead == false){                                                                      // repeats user's choice whilst a certain monster is alive
          monsterDead = userChoice(userCharacter, randomMonster, shop, inventory);
          if (monsterDead == false) {
            randomMonster.monsterAttack(userCharacter);                                                   // if monster is still alive then the monster can still attack each turn
            System.out.println("");
            System.out.println("Your Health is: " + userCharacter.getHealth());                           // prints statement as seen
          }
          if (userCharacter.getHealth() <= 0) {                                                           // if the user's health is less than 1 then it breaks out of the loop
            break;
          }
        }
        if (monsterDead == true) {                                              // if the monster's dead then it is set to false
          monsterDead = false;
        }
        if (userCharacter.getHealth() <= 0) {                                   // if the user's health is less than 1 it prints the statement and  breaks out of the loop
          System.out.println("You have DIED!!!");
          break;
        }
      }
      System.out.println("");                                                   // prints the statement as seen
      System.out.println("");
      System.out.println("Your Final Stats are:");
      System.out.println("");
      userCharacter.stats();
    }
}
