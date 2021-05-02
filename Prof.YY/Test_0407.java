public class Test_0407 {

	public static void main(String[] args) {
		int i = 1;
		while (i <= 10) {
			System.out.println("hello world " + i);
			i++;

			try {

				Thread.sleep(100);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}
	}
}