/*
  class Monster -- Represents random incarnations of 
  the adventurer's natural enemy in Ye Olde RPG
**/

public class Monster extends Character {


  /**
     default constructor
     pre:  instance vars are declared
     post: initializes instance vars.
  **/
  public Monster() {
    health = 150;
    strength = 20 + (int)( Math.random() * 45 ); // [20,65)
    defense = 20;
    attack = 1;
  }
  public int getDefense() { return defense; }

}//end class Monster
