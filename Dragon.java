public class Dragon extends Monster {
	public Dragon() {
		health = 200;
		strength = 30 + (int)( Math.random() * 45 ); // [30,75)
		defense = 25;
		attack = 1.5;
	}
	public int getDefense() { return defense; }

	public static String about() {
		return "Somehow you've encountered the mythical dragon, not much is known about this deadly beast because no one has survived to tell the tale!";
	}
}
