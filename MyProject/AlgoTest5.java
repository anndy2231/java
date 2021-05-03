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

			

			System.out.println("" + N + " : " + bus45 + " " + bus25);
		}
	}

}