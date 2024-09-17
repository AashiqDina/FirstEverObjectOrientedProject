/** A class meant to extend Monster to create a slime type monster
    Author: Aashiq Dina.
    Date of last modification: 15 Aprl 2022 */

import java.util.Random;

public class Slime extends Monster{

  /*gives the values given to the monster class**/
  public Slime(String setMonsterName, int setMonsterHealth, int setMonsterAttackPower, int setCoinsDropped, int setMaxMonsterHealth){
    super(setMonsterName, setMonsterHealth, setMonsterAttackPower, setCoinsDropped, setMaxMonsterHealth);
  }

  /*Prints out statement using the object's monsterName variable**/
  public void monsterEncounter(){
    System.out.println("");
    System.out.println("You have encountered a " + this.getMonsterName() + "!");
    System.out.println("It has " + this.getMonsterHealth() + " health and an attack power of " + this.getMonsterAttackPower());
    System.out.println("It lets out a small squeak in anger!");
    System.out.println("Your shivering in your boots");
  }
  /*Hero object is given and is used to call a method using the variable
   monsterAttackPower but before this it prints out the statement as seen**/
  public void monsterAttack(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " releases a gentle attack!");
    userHero.takeDamage(this.getMonsterAttackPower());
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    if (randomNumber <= 4) {
      this.slimeAbility();
  }
}
  /*Prints out statement as seen and increases monsterAttack by three,
   it then prints out a statement**/
  public void slimeAbility(){
    System.out.println("The " + this.getMonsterName() + " has used its special ability 'Attack Boost'");
    setMonsterAttackPower(this.getMonsterAttackPower() + 3);
    System.out.println("The " + this.getMonsterName() + "'s Attack is now " + this.getMonsterAttackPower());
  }

}
