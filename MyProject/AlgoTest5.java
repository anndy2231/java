import java.util.Scanner;

public class AlgoTest5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 999999; i++) {
			System.out.println("학생 수 입력");
			int N = sc.nextInt();
			int bus45 = 0;
			int quotient45 = Math.floorDiv(N, 45);
			int remainder45 = Math.floorMod(N, 45);
			int bus25 = 0;
			int quotient25 = Math.floorDiv(N, 25);
			int remainder25 = Math.floorMod(N, 25);

			if (N < 1 || N > 1000) {
				System.out.println("1이상 1000미만 숫자만 입력 가능");
				break;
			}

			if (N % 45 == 0) {
				for (int j = 0; j < N / 45; j++) {
					bus45++;
				}
			} else if (N % 25 == 0) {
				for (int j = 0; j < N / 25; j++) {
					bus25++;
				}
			} 
			else if (26 <= N && N <= 45) {
				bus45++;
			} else if (1 <= N && N <= 25) {
				bus25++;
			} 
			else if (N % 95 == 0) {
				for (int j = 0; j < N / 95; j++) {
					bus45++;
					bus25 += 2;
				}
			} else if (quotient45 < quotient25) {
				bus45 += quotient45;
				if (remainder45 <= 25) {
					bus25++;
				} else {
					bus45++;
				}
			} else if (quotient25 < quotient45) {
				bus25 += quotient25;
				if (remainder25 <= 25) {
					bus25++;
				} else {
					bus45++;
				}
			}

			System.out.println("" + N + " : " + bus45 + " " + bus25);
		}
	}

}