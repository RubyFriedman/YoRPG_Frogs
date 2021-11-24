/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.

DISCO:
 * Discovered how to use extends when extending a class with a lot of overlap.
 * Discovered how to create a colaborative repository.
 * Discovered how to use protected instance variables and why they're important for subclasses.
 * Discovered how to use try and catch commands to catch all possible outcomes.
 * Discovered how to effectively use subclasses to simplify and refactor code.

QCC:
 * How do we edit the rarer monsters to be more likely to appear with a higher difficulty?
 * How do we randomize the attack value for each turn rather than for each monster?
 * What other types of visability are there other than public, private and protected?

OUR DRIVER MODS:
 * Added the option to choose the type of protagonist including Healer, Archer, and Knight.
 * Added randomized types of Monsters, including Zombies, Centuar, and the Dragon with varying probability on having to fight
   each depending on their difficulty level.
 * Added new private instance variables to use later in the driver file depending on which type of protagonist or monster
   chose/got.
 * Printed out the protagonist types and definitions as well as the monster types and definitions.

 **********************************************/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

  private Healer H;
  private Knight K;
  private Archer A;

  private Zombies Z;
  private Centaur C;
  private Dragon D;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;
  private int choice;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    choice = 0;
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  
  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:  
    post: according to user input, modifies instance var for difficulty 
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }

    //instantiate the player's character

    s = "\n Select your warrior: \n ";
    s += "\t1: Healer- \t" + H.about() + "\n";
    s += "\t2: Knight-\t" + K.about() + "\n";
    s += "\t3: Archer-\t" + A.about() + "\n";
    s += "Selection: ";
    System.out.print(s);

    try {
            choice  = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    if (choice == 1) {
      pat = new Healer( name );
    }
    else if (choice == 2) {
      pat = new Knight( name );
    }
    else if (choice == 3) {
      pat = new Archer( name );
    }
    else {
      pat = new Protagonist( name );
    }
  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
      System.out.println( "\nNothing to see here. Move along!" );
    else {
      if (Math.random() > 0.9) {
        smaug = new Dragon();
        System.out.println( "\nLo, yonder monster approacheth! " + D.about());
      }
      else if (Math.random() > 0.55) {
	smaug = new Centaur();
        System.out.println( "\nLo, yonder monster approacheth! " + C.about());
      }
      else {
	smaug = new Zombies();
        System.out.println( "\nLo, yonder monster approacheth! " + Z.about());
      }

      while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
      }//end while

      //option 1: you & the monster perish
      if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " + 
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thee." );
        return false;
      }
      //option 2: you slay the beast
      else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
      }
      //option 3: the beast slays you
      else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
      }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively 
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
      if ( !game.playTurn() )
        break;
      encounters++;
      System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
      ================================================*/
  }//end main

}//end class YoRPG
