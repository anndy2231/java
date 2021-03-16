import java.util.Scanner;

public class Exec031605 {

	public static void main(String[] args) {

		System.out.println("숫자를 입력해주세요.");
		Scanner s1 = new Scanner(System.in);
		int userNumber = s1.nextInt();

		if (isPrime(userNumber)) {
			System.out.println(userNumber + "는 소수입니다.");
		} else {
			System.out.println(userNumber + "는 소수가 아닙니다.");
		}
	}

	private static boolean isPrime(final int in) {
		
		if (in < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(in); i++) {
			if (in % i == 0) {
				return false;
			}
		}
		return true;
	}
}
