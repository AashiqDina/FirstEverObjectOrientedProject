/** A class meant to represent a typical game monster
    Author: Aashiq Dina.
    Date of last modification: 15 Aprl 2022 */

import java.lang.Math;

public class Monster{

/**Used for scaling (when the user gets stronger the monsters will also get stronger)*/
  private static int monsterDefeated = 0;
  private static double calculatedScaling = 1.0;

/* Variables created to store values of the certain aspects of the monster such as the name, health,
 attack and the amount of coins it drops**/
  private String monsterName;
  private int monsterHealth;
  private int monsterAttackPower;
  private int coinsDropped;
  private int maxMonsterHealth;

/* Sets the monster's attributes**/
  public Monster(String setMonsterName, int setMonsterHealth, int setMonsterAttackPower, int setCoinsDropped, int setMaxMonsterHealth)
  {
    this.monsterName = setMonsterName;
    this.monsterHealth = setMonsterHealth;
    this.monsterAttackPower = setMonsterAttackPower;
    this.coinsDropped = setCoinsDropped;
    this.maxMonsterHealth = setMaxMonsterHealth;
  }
/* Returns the value of the the variable monsterName**/
  public String getMonsterName(){
    return this.monsterName;
  }
  /* Returns the value of the the variable monsterHealth**/
  public int getMonsterHealth(){
    return this.monsterHealth;
  }
  /* Returns the value of the the variable monsterAttackPower**/
  public int getMonsterAttackPower(){
    return this.monsterAttackPower;
  }
  /* Returns the value of the the variable maxMonsterHealth**/
  public int getMaxMonsterHealth(){
    return this.maxMonsterHealth;
  }
  /*Sets the monsters health to a given value (value is given when called)**/
  public void setMonsterHealth(int newMonsterHealth){
    this.monsterHealth = newMonsterHealth;
  }
  public void setMonsterAttackPower(int newMonsterAttack){
    this.monsterAttackPower = newMonsterAttack;
  }
  /*Prints out "Noise of monster approaching" as seen**/
  public void monsterEncounter(){
    System.out.println("*Noise of monster approaching*");
  }
  /*Hero variable is given and is used to call a method using the variable monsterAttackPower**/
  public void monsterAttack(Hero userHero){
    System.out.println("");
    System.out.println("The " + this.monsterName + " releases an attack!");
    userHero.takeDamage(this.monsterAttackPower);
  }
  /*When the monster is defeated the method is called with a Hero object and the
   following is done to calculate a new maxMonsterHealth and monsterAttackPower**/
  public void monsterDefeated(Hero userHero){
    monsterDefeated++;                                                      // monsterDefeated is increased by one
    calculatedScaling = ((monsterDefeated + 1));                            // new calculatedScaling is created
    userHero.gainCoins(coinsDropped);                                       // Uses hero object which was given when called to call a method giving the variable coinsDropped
    this.monsterHealth = this.maxMonsterHealth;                             // Heals the monster for the next time the monster is called
    this.maxMonsterHealth = (int) Math.round(this.maxMonsterHealth + calculatedScaling * 1.1);
    this.monsterAttackPower = (int) Math.round(this.monsterAttackPower + calculatedScaling * 1.1);
  }

}
