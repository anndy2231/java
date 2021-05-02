
public abstract class Enemy extends Base {
	
	public abstract void attack(Base player);
	
	public abstract void heal(Base enemy);
	
	public String toString() {
		return this.name ;
	}
}
