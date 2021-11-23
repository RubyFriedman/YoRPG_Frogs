public class Character {

	private int health;
	private int strength;
	private int defense;
	private double attack;

	public boolean isAlive() {
		return health > 0;
	}

	public int getDefense() {
		return defense;
	}

	public void lowerHP(int damage) {
		health = health - damage;
	}

	public int attack(Character opponent) {
		int damage = (int) ((strength * attack) - opponent.getDefense());
		if ( damage < 0 )
            		damage = 0;

	        opponent.lowerHP( damage );

        	return damage;
    }//end attack
}
