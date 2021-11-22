public class Protagonist {
  String Name;
  int health = 100;
  public Protagonist(String name) {
    Name = name;
  }

  public boolean isAlive() {
    if (health > 0) {
      return true;
    } else {
      return false;
    }
  }

  public String getName() {
    return Name;
  }

  public void specialize() {

  }

  public void normalize() {

  }

  public int attack(Monster m) {
    int damage = (int) (Math.random()*20);
    m.health -= damage;
    return damage;
  }
}
