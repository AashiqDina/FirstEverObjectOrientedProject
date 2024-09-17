/** A class meant to represent a typical game hero
    Author: Aashiq Dina.
    Date of last modification: 13 Aprl 2022 */

import java.lang.Math;

public class Hero{

  /* Variables created to store values of the certain aspects of the hero such
   as the name, health, attack and more as seen**/
  private String name;
  private int maxHealth = 100;
  private int health = 100;
  private int level = 1;
  private int experiencePoints = 0;
  private int experienceToLevelUp = 100;
  private int attackPower = 20;
  private int coins = 0;
  private boolean weaponEquipped = false;

  /* Constructor to set the name of the hero when it is created**/
  public Hero(String chosenName){
    this.name = chosenName;
  }
  /*returns the value of the variable health**/
  public int getHealth(){
    return this.health;
  }
  /*returns the value of the variable maxHealth**/
  public int getMaxHealth(){
    return this.maxHealth;
  }
  /*returns the value of the variable attackPower**/
  public int getAttackPower(){
    return this.attackPower;
  }
  /*returns the value of the variable name**/
  public String getName(){
    return this.name;
  }
  /*returns the value of the variable level**/
  public int getLevel(){
    return this.level;
  }
  /*returns the value of the variable experiencePoints**/
  public int getExperiencePoints(){
    return this.experiencePoints;
  }
  /*returns the value of the variable experienceToLevelUp**/
  public int getExperienceToLevelUp(){
    return this.experienceToLevelUp;
  }
  /*returns the value of the variable weaponEquipped**/
  public boolean getEquippedStatus(){
    return this.weaponEquipped;
  }
  /*takes an int when the method's called and takes away the health from that
   value, this is then stored in the variable health**/
  public void takeDamage(int monsterAttackPower){
    health = health - monsterAttackPower;
  }
  /*checks if weaponEquipped is false if it is then the attack is increased by
   the weaponsAttack given and sets it to true, if its true then it prints the
    statement as seen and returns false**/
  public boolean equipWeapon(int weaponAttack){
    if (weaponEquipped == false) {
      this.attackPower = this.attackPower + weaponAttack;
      weaponEquipped = true;
      return true;
    }
    else{
      System.out.println("You already have a weapon equipped");
    }
    return false;
  }
  /*checks if health is greater that or equal to maxHealth if it is then it
   prints out the statement as seen otherwise... **/
  public void healHero(int amountToHeal){
    if (health >= maxHealth) {
      health = maxHealth;
      System.out.println("Wow, that was a waste you were already at max health!");
    }
    else{
      health = health + amountToHeal;                  // it adds the amount give to the variable amount to heal
      if (health > maxHealth){                         // checks if health is greater than maxHealth
        health = maxHealth;                            // if it is then health will get the value of maxHealth
      }
    }
  }
/*when called an int is given and the variable experiencePoints is increased by
 int given and whilst the variable experiencePoints is greater than or equal
  to the variable experienceToLevelUp**/
  public void gainExperience(int experienceGained){


    this.experiencePoints = this.experiencePoints + experienceGained;

    while (this.experiencePoints >= this.experienceToLevelUp){
      this.level = this.level + 1;                                                                  // the value of the variable level is increased by one
      this.experiencePoints = this.experiencePoints - this.experienceToLevelUp;                     // the value of the variable experiencePoints is decreased by the variable experienceToLevelUp
      this.attackPower = (int) Math.round (this.attackPower + (1.2 * (this.attackPower) + (this.level * this.level)));   // the value of the variable attackPower is increased in correspondence to the level
      this.maxHealth =( int) Math.round (this.maxHealth + (1.2 * (this.health) + (this.level*this.level)));              // the value of the variable maxHealth is increased in correspondence to the level
      this.experienceToLevelUp = this.experienceToLevelUp + (100 * this.level);                     // the value of the variable experienceToLevelUp in increased in correspondence to the level
      this.health = this.maxHealth;                                                                 // health is set to the maxHealth
    }
  }
/*when called the variable coins is increased by the int given when the method is called**/
  public void gainCoins(int amountToGain){
    this.coins = this.coins + amountToGain;
  }
/*checks if the int given when called is greater than coins and if it is,
 false is returned if not then the variable coins is decreased by the int given **/
  public boolean useCoins(int amountToUse){
    if (amountToUse > this.coins) {
      return false;
    }
    else{
      this.coins = this.coins - amountToUse;
      return true;
    }
  }
/*when method is called a Monster object is given with it which is used to
 take away attackPower from the monster's health and sets it to the variable
  just calculated (newMonsterHealth and...)**/
  public boolean attackEnemy(Monster enemy){

    int newMonsterHealth = enemy.getMonsterHealth() - attackPower;
    enemy.setMonsterHealth(newMonsterHealth);
    System.out.println("The " + enemy.getMonsterName() + "'s health has been reduced to " + enemy.getMonsterHealth());     // prints out statement as seen
    if (enemy.getMonsterHealth() <= 0) {                                        //checks if monsterHealth is less that or equal to 0 and then...
      return true;
    }
    return false;
  }
/*prints out the statement as seen below**/
  public void stats(){

    System.out.println("");
    System.out.println("---------------------------------------");
    System.out.println("  " + this.name + "'s Stats:");
    System.out.println("                            ");
    System.out.println("   Level: " + this.level);
    System.out.println("  Health: " + this.health + "/" + this.maxHealth);
    System.out.println("  Attack: " + this.attackPower);
    System.out.println("   Coins: " + this.coins);
    System.out.println("     EXP: " + this.experiencePoints + "/" + this.experienceToLevelUp);
    System.out.println("                            ");
    System.out.println("---------------------------------------");
    System.out.println("");
  }
}
