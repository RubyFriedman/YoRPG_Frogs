public class Character {

	protected int health;
	protected int strength;
	protected int defense;
	protected double attack;

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
