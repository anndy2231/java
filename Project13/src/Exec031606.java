import java.util.Scanner;

public class Exec031606 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력해주세요.");

		Scanner s1 = new Scanner(System.in);
		int userNumber = s1.nextInt();
		System.out.println("입력받은 숫자는 " + userNumber + "입니다.");

		boolean isPrime = true;
		for (int i = 0; i < userNumber; i++) {
			if (i < 2) {
				continue;
			}
			if (userNumber % i == 0) {
				isPrime = false;
			}
		}
		if (isPrime) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}
	}
}