public class Archer extends Protagonist {
	public Archer() {
		health = 100;
		strength = 150;
		defense = 30;
		attack = 0.4;
	}

        public Archer( String name ) {
                this();
                _name = name;
        }

	public String getName() {return _name;}
	public int getDefense() {return defense;}

	public static String about() {
		return "The Archer has a higher strength value, but lower defense.";
	}
}
