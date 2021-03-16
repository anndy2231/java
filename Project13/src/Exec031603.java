
public class Exec031603 {

	public static void main(String[] args) {

		// 1~100합
		int number_total = 0; // 전역변수
		int even_total = 0;
		int odd_total = 0;
		for (int i = 0; i < 100; i++) {
			int number = i + 1; // number 지역변수

			number_total = number_total + number;

			if (number % 2 == 0) {
				even_total = even_total + number;
			} else {
				odd_total = odd_total + number;
			}

		}
//		System.out.println(number); // number는 지역변수라서 출력 불가
		System.out.println("1부터 100까지 의 합은 " + number_total);
		System.out.println("1부터 100까지 의 홀수의 합은 " + odd_total);
		System.out.println("1부터 100까지 의 짝수의 합은 " + even_total);

	}

}
