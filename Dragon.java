/** A class meant to extend Monster to create a dragon type monster
    Author: Aashiq Dina.
    Date of last modification: 15 Aprl 2022 */

import java.util.Random;

public class Dragon extends Monster{
/*gives the values given to the monster class**/
  public Dragon(String setMonsterName, int setMonsterHealth, int setMonsterAttackPower, int setCoinsDropped, int setMaxMonsterHealth){
    super(setMonsterName, setMonsterHealth, setMonsterAttackPower, setCoinsDropped, setMaxMonsterHealth);
  }
  /*Prints out statement using the object's monsterName variable**/
  public void monsterEncounter(){
    System.out.println("");
    System.out.println("You have encountered a " + this.getMonsterName() + "!");
    System.out.println("It has " + this.getMonsterHealth() + " health and an attack power of " + this.getMonsterAttackPower());
    System.out.println("It lets out a loud roar, prepared to claim its next victim");
    System.out.println("The nearby wildlife run away");
  }
  /*Hero object is given and is used to call a method using the variable monsterAttackPower but before this it prints out the statement as seen**/
  public void monsterAttack(Hero userHero){
    System.out.println("");
    System.out.println("The " + this.getMonsterName() + " releases a fierce attack!");
    userHero.takeDamage(this.getMonsterAttackPower());
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    if (randomNumber <= 2) {
      this.dragonAbility();
    }
  }
  /*Prints out statement as seen, and increases the value of the variable monsterHealth by 50 and prints out another statement**/
  private void dragonAbility(){
    System.out.println("The " + this.getMonsterName() + " has used its special ability 'health boost'");
    setMonsterHealth(this.getMonsterHealth() + 50);
    System.out.println("The " + this.getMonsterName() + "'s health is now " + this.getMonsterHealth());
  }
}
