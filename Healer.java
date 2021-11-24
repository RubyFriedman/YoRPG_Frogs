public class Healer extends Protagonist {
	public Healer() {
		health = 300;
		strength = 50;
		defense = 40;
		attack = 0.25;
	}
	public Healer( String name ) {
        	this();
        	_name = name;
	}
	public String getName() {return _name;}
	public int getDefense() {return defense;}

	public static String about() {
		return "The healer has a huge amount of health, but its attacks barely do anything";
	}
}
