/** A class meant to represent a typical game shop
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

public class Shop
{
  /* Variables created to store values of the certain aspects of
   the hero such as the name, health, attack and more as seen**/
  private Items itemSellingOne;
  private Items itemSellingTwo;
  private Items itemSellingThree;
  private Items itemSellingFour;
  private Items itemSellingFive;
  /* Constructor to set the items of the shop when it is created**/
  public Shop(Items itemOne, Items itemTwo, Items itemThree, Items itemFour, Items itemFive){
    itemSellingOne = itemOne;
    itemSellingTwo = itemTwo;
    itemSellingThree = itemThree;
    itemSellingFour = itemFour;
    itemSellingFive = itemFive;
  }
  /*returns the value of the object itemSellingOne**/
  public Items returnItemOne(){
    return itemSellingOne;
  }
  /*returns the value of the object itemSellingTwo**/
  public Items returnItemTwo(){
    return itemSellingTwo;
  }
  /*returns the value of the object itemSellingThree**/
  public Items returnItemThree(){
    return itemSellingThree;
  }
  /*returns the value of the object itemSellingFour**/
  public Items returnItemFour(){
    return itemSellingFour;
  }
  /*returns the value of the object itemSellingFive**/
  public Items returnItemFive(){
    return itemSellingFive;
  }

  /*prints out statements as seen**/
  public void displayItems(){
    System.out.println("");
    System.out.println("---------------------------------------");
    System.out.println("Items For Sale:");
    System.out.println("");
    System.out.println("(1) - " + itemSellingOne.returnItemName() + " - " + itemSellingOne.returnItemPrice() + " coins");
    System.out.println("(2) - " + itemSellingTwo.returnItemName() + " - " + itemSellingTwo.returnItemPrice() + " coins");
    System.out.println("(3) - " + itemSellingThree.returnItemName() + " - " + itemSellingThree.returnItemPrice() + " coins");
    System.out.println("(4) - " + itemSellingFour.returnItemName() + " - " + itemSellingFour.returnItemPrice() + " coins");
    System.out.println("(5) - " + itemSellingFive.returnItemName() + " - " + itemSellingFive.returnItemPrice() + " coins");
    System.out.println("");
    System.out.println("---------------------------------------");
  }

  public boolean buyItem(String item, Hero userHero){
    if (item.equals(itemSellingOne.returnItemName())) {                                 // check if the user's input is equal to the name of the item
      if (userHero.useCoins(itemSellingOne.returnItemPrice()) == false) {               // checks if the user has sufficient funds to buy the item
        System.out.println("You lack the sufficient funds to purchase this item");      // prints out statement as seen
        return false;
      }
      return true;
    }
    else if (item.equals(itemSellingTwo.returnItemName())) {                            // check if the user's input is equal to the name of the item
      if (userHero.useCoins(itemSellingTwo.returnItemPrice()) == false) {               // checks if the user has sufficient funds to buy the item
        System.out.println("You lack the sufficient funds to purchase this item");      // prints out statement as seen
        return false;
      }
      return true;
    }
    else if (item.equals(itemSellingThree.returnItemName())) {                          // check if the user's input is equal to the name of the item
      if (userHero.useCoins(itemSellingThree.returnItemPrice()) == false) {               // checks if the user has sufficient funds to buy the item
        System.out.println("You lack the sufficient funds to purchase this item");      // prints out statement as seen
        return false;
      }
      return true;
    }
    else if (item.equals(itemSellingFour.returnItemName())) {                           // check if the user's input is equal to the name of the item
      if (userHero.useCoins(itemSellingFour.returnItemPrice()) == false) {               // checks if the user has sufficient funds to buy the item
        System.out.println("You lack the sufficient funds to purchase this item");      // prints out statement as seen
        return false;
      }
      return true;
    }
    else if (item.equals(itemSellingFive.returnItemName())) {                            // check if the user's input is equal to the name of the item
      if (userHero.useCoins(itemSellingFive.returnItemPrice()) == false) {               // checks if the user has sufficient funds to buy the item
        System.out.println("You lack the sufficient funds to purchase this item");      // prints out statement as seen
        return false;
      }
      return true;
    }
    else{
      System.out.println("The item you have selected does not exist");      // prints out statement as seen
    }
    return false;
  }
}
