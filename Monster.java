/*
  class Monster -- Represents random incarnations of 
  the adventurer's natural enemy in Ye Olde RPG
**/

public class Monster extends Character {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
  private int health;
  private int strength;
  private int defense;
  private double attack;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


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

  public boolean isAlive() {
    return health > 0;
  }

  public int attack( Protagonist opponent ) {

    int damage = (int)( (strength * attack) - opponent.getDefense() );
    //System.out.println( "\t\t**DIAG** damage: " + damage );

    if ( damage < 0 )
      damage = 0;

    opponent.lowerHP( damage );

    return damage;
  }//end attack

  public void lowerHP( int damageInflicted ) {
    health = health - damageInflicted;
  }
}//end class Monster
