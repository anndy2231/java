
public abstract class Player extends Base {

	public abstract void attack(Base enemy);
	
	public abstract void heal(Base player);
	
	public String toString() {
		return this.name ;
	}
	
}
