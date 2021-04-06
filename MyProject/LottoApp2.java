import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoApp2 {

	public static void main(String[] args) {
		Random randNum = new Random();
		int lotto[] = new int[6];
		Scanner sc = new Scanner(System.in);

		for (int a = 0; a < 999999; a++) {
			System.out.println("------------------");
			System.out.println("로또 번호 생성 프로그램");
			System.out.println("1 : 실행");
			System.out.println("2 : 종료");
			System.out.println("------------------");
			String userInput = sc.nextLine();
			int userInputNum = Integer.parseInt(userInput);

			if (userInputNum == 1) {
				for (int i = 0; i < lotto.length; i++) {
					lotto[i] = randNum.nextInt(45) + 1;
					for (int j = 0; j < i; j++) {
						if (lotto[i] == lotto[j]) {
							i--;
						}
					}

				}
				Arrays.sort(lotto);
				System.out.println();
				System.out.println("이번주 행운의 숫자 : " + Arrays.toString(lotto));
				System.out.println();
			} else if (userInputNum == 2) {
				System.out.println();
				System.out.println("- 프로그램 종료 -");
				break;
			}
		}
	}
}
