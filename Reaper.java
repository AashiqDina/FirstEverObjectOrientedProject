/** A class meant to extend Monster to create a reaper type monster
    Author: Aashiq Dina.
    Date of last modification: 15 Aprl 2022 */

import java.util.Random;

public class Reaper extends Monster{
  /*gives the values given to the monster class**/
  public Reaper(String setMonsterName, int setMonsterHealth, int setMonsterAttackPower, int setCoinsDropped, int setMaxMonsterHealth){
    super(setMonsterName, setMonsterHealth, setMonsterAttackPower, setCoinsDropped, setMaxMonsterHealth);
  }
  /*Prints out statement using the object's monsterName variable**/
  public void monsterEncounter(){
    System.out.println("");
    System.out.println("You have encountered a " + this.getMonsterName() + "!");
    System.out.println("It has " + this.getMonsterHealth() + " health and an attack power of " + this.getMonsterAttackPower());
    System.out.println("It lets out a great roar in anger!");
    System.out.println("Almost as terrifying as the slime");
  }
  /*Hero object is given and is used to call a method using the variable monsterAttackPower
   but before this it prints out the statement as seen**/
  public void monsterAttack(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " releases a ferocious attack!");
    userHero.takeDamage(this.getMonsterAttackPower());
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    if (randomNumber <= 3) {
      reaperAbility(userHero);
  }
}
  /*Prints out statement as seen and calls method takeDamage using the object given when
   called it then adds 20 to the variable monsterHealth**/
  public void reaperAbility(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " has used its special ability 'Life Steal'");
    userHero.takeDamage(20);
    setMonsterHealth(this.getMonsterHealth() + 20);
    if (this.getMonsterHealth() > this.getMaxMonsterHealth()) {        // checks if the variable monsterHealth is less that the variable maxMonsterHealth
      this.setMonsterHealth(this.getMaxMonsterHealth());           // sets the value of the variable monsterHealth to the value of the variable maxMonsterHealth
    }
    System.out.println("The " + this.getMonsterName() + "'s health is now " + this.getMonsterHealth());                        // prints out the statement as seen
    System.out.println("Your health is now " + userHero.getHealth() + "/" + userHero.getMaxHealth());      // prints out the statement as seen
  }


}
