/**
  class Protagonist -- protagonist of Ye Olde RPG
  **/

public class Protagonist extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
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
    public Protagonist() {
        health = 125;
        strength = 100;
        defense = 40;
        attack = .4;
    }


    /**
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      **/
    public Protagonist( String name ) {
        this();
        _name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    public int getDefense() { return defense; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public boolean isAlive() {
        return health > 0;
    }

    public void lowerHP( int damageInflicted ) {
        health = health - damageInflicted;
    }

    public int attack( Monster opponent ) {

        int damage = (int)( (strength * attack) - opponent.getDefense() );
        //System.out.println( "\t\t**DIAG** damage: " + damage );

        if ( damage < 0 )
            damage = 0;

        opponent.lowerHP( damage );

        return damage;
    }//end attack

    //prepare a Protagonist for a special attack
    public void specialize() {
        attack = .75;
        defense = 20;
    }

    //revert to normal mode
    public void normalize() {
        attack = .4;
        defense = 40;
    }

}//end class Protagonist
