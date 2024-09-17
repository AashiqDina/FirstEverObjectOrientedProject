/** A class meant to extend Monster to create a ogres type monster
    Author: Aashiq Dina.
    Date of last modification: 15 Aprl 2022 */

import java.util.Random;

public class Ogre extends Monster{

  /*gives the values given to the monster class**/
  public  Ogre(String setMonsterName, int setMonsterHealth, int setMonsterAttackPower, int setCoinsDropped, int setMaxMonsterHealth){
    super(setMonsterName, setMonsterHealth, setMonsterAttackPower, setCoinsDropped, setMaxMonsterHealth);
  }

  /*Prints out statement using the object's monsterName variable**/
  public void monsterEncounter(){
    System.out.println("");
    System.out.println("You have encountered a " + this.getMonsterName() + "!");
    System.out.println("It has " + this.getMonsterHealth() + " health and an attack power of " + this.getMonsterAttackPower());
    System.out.println("It lets out a loud roar in anger!");
    System.out.println("Reminds you of a certain movie...");
  }
  /*Hero object is given and is used to call a method using the variable
   monsterAttackPower but before this it prints out the statement as seen**/
  public void monsterAttack(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " releases a large attack!");
    userHero.takeDamage(this.getMonsterAttackPower());
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    if (randomNumber <= 4) {
      ogreAbility(userHero);
  }
}
  /*Prints out statement as seen and calls method takeDamage using the object
   given when called it then adds 20 to the variable monsterHealth**/
  public void ogreAbility(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " has used its special ability 'Thunder Clap'");
    userHero.takeDamage(this.getMonsterAttackPower()*2);
  }

}
