
public class SaveBox1_Exec {
	public static void main(String[] args) {
		SaveBox1 box1 = new SaveBox1();
		SaveBox1 box2 = new SaveBox1();
		box1.deposit(100);
		box1.deposit(100);
		box2.deposit(200);
		box2.deposit(500);
		box1.withdraw();
		box2.withdraw();
	}
}
