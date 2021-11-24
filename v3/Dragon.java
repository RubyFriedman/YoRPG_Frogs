public class Dragon extends Monster {
	public Dragon() {
		health = 200;
		strength = 30 + (int)( Math.random() * 45 ); // [30,75)
		defense = 25;
		attack = 1.5;
	}
	public int getDefense() { return defense; }
}
