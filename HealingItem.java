/** A class meant to extend items to create a healing items sub category of items
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

public class HealingItem extends Items{

  /* Variables created to store values of the certain aspects of the hero such
   as the name, health, attack and more as seen**/
  private int healingFactor = 0;
  private int amountOfItem = 1;
  private int itemPrice = 0;
  private String itemName;
  private String itemDescription;
  /* Constructor to set the value of variables when it is created**/
  public HealingItem(String newItemName, int newHealingFactor, int newItemPrice){
    this.itemName = newItemName;
    this.healingFactor = newHealingFactor;
    this.itemPrice = newItemPrice;
  }
  /* Method which brings a Hero object when called and is used to call the
   healHero method and decrease the variable amountOfItem by 1**/
  public boolean useItem(Hero userHero){
    userHero.healHero(this.healingFactor);
    this.amountOfItem = this.amountOfItem - 1;
    if (this.amountOfItem <= 0) {                    // Checks if amountOfItem is less than or equal to zero
      return true;
    }
    return false;
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
    itemDescription = "A potion which heals " + this.healingFactor + " of your health.";
    System.out.println(itemName + ":");
    System.out.println("");
    System.out.println(itemDescription);
  }
}
