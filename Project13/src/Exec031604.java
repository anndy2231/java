
public class Exec031604 {

	public static void main(String[] args) {

		// 이중 반복문
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.println("i : " + i + " j : " + j);
//			}
//		}

		// 구구단
		for (int i = 0; i < 9; i++) {
			int number1 = i + 1;
			System.out.println("\n\n" + number1 + "단");
			for (int j = 0; j < 9; j++) {
				int number2 = j + 1;
				int result = number1 * number2;
				System.out.println("" + number1 + " X " + number2 + " = " + result);
								// ""는 숫자를 문자열로 만들어준다
								// 1+2=3 -> 숫자 / ""+1+2=12 -> 문자
			}

		}

	}
}
