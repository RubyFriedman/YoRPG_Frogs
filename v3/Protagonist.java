/**
  class Protagonist -- protagonist of Ye Olde RPG
  **/

public class Protagonist extends Character {
	private String _name;

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
