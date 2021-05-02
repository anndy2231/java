import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LottoApp {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int lotto[] = new int[6];
//		Integer lotto[] = new Integer[6]; // 내림차순
//
//		for (int a = 0; a < 999999; a++) {
//			System.out.println("-----------------");
//			System.out.println("로또 번호 생성 프로그램");
//			System.out.println("1 : 실행");
//			System.out.println("2 : 종료");
//			System.out.println("-----------------");
//			int userInput = sc.nextInt();
			
//			if (userInput == 1) {
				for (int i = 0; i < lotto.length; i++) {
					lotto[i] = rd.nextInt(45) + 1;
					for (int j = 0; j < i; j++) {
						if (lotto[i] == lotto[j]) {
							i--;
						}
					}
				}
				Arrays.sort(lotto);
//				Arrays.sort(lotto, Collections.reverseOrder()); // 내림치순
				System.out.println();
				System.out.println("이번주 행운의 숫자 : " + Arrays.toString(lotto));
				System.out.println();
//			} else if (userInput == 2) {
//				System.out.println();
//				System.out.println("- 프로그램 종료 -");
//				break;
//			} else {
//				System.out.println("숫자 '1' 또는 '2'만 입력해주세요.");
//			}
//		}
	}
}
