public class Knight extends Protagonist {
	public Knight() {
		health = 100;
		strength = 100;
		defense = 55;
		attack = 0.6;
	}

        public Knight( String name ) {
                this();
                _name = name;
        }

	public String getName() {return _name;}
	public int getDefense() {return defense;}

	public static String about() {
		return "The Knight has a higher defense and attack, but less health.";
	}
}

