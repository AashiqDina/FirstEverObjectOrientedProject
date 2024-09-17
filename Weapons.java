/** A class meant to extend items to create a weapons sub category of items
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

public class Weapons extends Items{

  /* Variables created to store values of the certain aspects of the hero such
   as the name, health, attack and more as seen**/
  private int attack;
  private int itemPrice = 0;
  private String itemName;
  private String itemDescription;
  /* Constructor to set the value of variables when it is created**/
  public Weapons(String newWeaponName, int attackUp, int price){
    this.itemName = newWeaponName;
    this.attack = attackUp;
    this.itemPrice = price;
  }
  /* Returns the value of the variable attack**/
  public int getAttack(){
    return attack;
  }
  /* Method which brings a Hero object when called and is used to call the
   equipWeapon method and returns the returned value of that method**/
  public boolean useItem(Hero userHero){

    boolean successful = userHero.equipWeapon(attack);

    return successful;
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
    itemDescription = ("A Weapon which increases your attack by " + attack);
    System.out.println("");
    System.out.println(itemName + ":");
    System.out.println("");
    System.out.println(itemDescription);
  }
}
