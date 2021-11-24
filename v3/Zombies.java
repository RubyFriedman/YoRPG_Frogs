public class Zombies extends Monster {
	public Zombies() {
		health = 75;
		strength = 10 + (int)( Math.random() * 45 ); // [10,55)
		defense = 10;
		attack = 0.75;
	}
	public int getDefense() { return defense; }

	public static String about() {
		return "The Zombie is the weakest type of Monster, it barely does any damage!";
	}
}
