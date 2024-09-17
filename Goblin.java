/** A class meant to extend Monster to create a goblin type monster
    Author: Aashiq Dina.
    Date of last modification: 15 Aprl 2022 */

import java.util.Random;

public class Goblin extends Monster{

  /*gives the values given to the monster class**/
  public Goblin(String setMonsterName, int setMonsterHealth, int setMonsterAttackPower, int setCoinsDropped, int setMaxMonsterHealth){
    super(setMonsterName, setMonsterHealth, setMonsterAttackPower, setCoinsDropped, setMaxMonsterHealth);
  }

  /*Prints out statement using the object's monsterName variable**/
  public void monsterEncounter(){
    System.out.println("");
    System.out.println("You have encountered a " + this.getMonsterName() + "!");
    System.out.println("It has " + this.getMonsterHealth() + " health and an attack power of " + this.getMonsterAttackPower());
    System.out.println("It lets out a bellowing screech in anger!");
    System.out.println("You can handle this!");
  }
  /*Hero object is given and is used to call a method using the variable
   monsterAttackPower but before this it prints out the statement as seen**/
  public void monsterAttack(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " releases a normal attack!");
    userHero.takeDamage(this.getMonsterAttackPower());
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    if (randomNumber <= 3) {
      goblinAbility(userHero);
  }
}
  /*Prints out statement as seen and increases monsterHealth and monsterAttack
   by three times, it then prints out a statement and...**/
  public void goblinAbility(Hero userHero){
    System.out.println("The " + this.getMonsterName() + " has used its special ability 'Goblin Horde'");
    setMonsterHealth(this.getMonsterAttackPower() * 3);
    System.out.println(this.getMonsterName() + "'s Attack has been multiplied by 3!");
    monsterAttack(userHero);                       // Calls method using hero object given
    setMonsterHealth(this.getMonsterAttackPower() / 3);           // returns monsterHealth and MonsterAttack back to normal
    System.out.println(this.getMonsterName() + "'s Attack has been returned to normal");      // Prints out final statement
  }

}
