/** A class meant to represent typical videogame items
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

public abstract class Items{

  /*abstract method for using an item**/
  public abstract boolean useItem(Hero UserHero);
  /*abstract method for checking an item's description**/
  public abstract void checkItemDescription();
  /*abstract method for returning an item object**/
  public abstract String returnItemName();
  /*abstract method for returning an item's price**/
  public abstract int returnItemPrice();
}
