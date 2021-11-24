public class Centaur extends Monster {
	public Centaur() {
		health = 150;
		strength = 15 + (int)( Math.random() * 45 ); // [15,60)
		defense = 10;
		attack = 2;
	}
	public int getDefense() { return defense; }
}
