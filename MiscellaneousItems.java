/** A class meant to extend items to create a Miscellaneous Items sub category of items
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

public class MiscellaneousItems extends Items{

  /* Variables created to store values of the certain aspects of the hero such
   as the name, health, attack and more as seen**/
  private int itemPrice = 0;
  private String itemName;
  private String itemDescription;
  /* Constructor to set the value of variables when it is created**/
  public MiscellaneousItems(String newItemName, int price, String description){
    this.itemName = newItemName;
    this.itemDescription = description;
    this.itemPrice = price;
  }
  /*Prints out statement as shown due to the fact that MiscellaneousItems
   are just for show**/
  public boolean useItem(Hero userHero){
    System.out.println("It does nothing...");
    return true;
  }
  /* Returns the value of the variable itemName**/
  public String returnItemName(){
    return this.itemName;
  }
  /* Returns the value of the variable itemPrice**/
  public int returnItemPrice(){
    return this.itemPrice;
  }
  /* Prints out statements as shown**/
  public void checkItemDescription(){

    System.out.println(itemName + ":");
    System.out.println("");
    System.out.println(itemDescription);
  }
}
