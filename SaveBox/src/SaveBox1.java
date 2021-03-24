
public class SaveBox1 {
	int coins = 0;
	public void deposit(int coin) {
		coins = coins + coin;
	}
	public void withdraw() {
		System.out.println("모든 돈 : " + coins);
	}
}
