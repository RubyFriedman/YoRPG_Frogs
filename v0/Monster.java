public class Monster {
  int health = 100;
  public Monster() {

  }

  public int attack(Protagonist p) {
    int damage = (int) (Math.random()*20);
    p.health -= damage;
    return damage;
  }

  public boolean isAlive() {
    if (health > 0) {
      return true;
    } else {
      return false;
    }
  }
}
