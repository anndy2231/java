
public class Base {
	int hp;
	int power;
	int defense;
	String name;
	int heal;
	
	public boolean isLive() {
		if (this.hp < 1) {
			return false;
		}
		return true;
	}	
}
