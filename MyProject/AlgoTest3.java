import java.util.Arrays;
import java.util.Scanner;

public class AlgoTest3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int Y = sc.nextInt();

		int[][] arr = new int[H + 1][Y + 1];

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= Y; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i <= H; i++) {
			for (int j = 0; j <= Y; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		int M = sc.nextInt();
		for (int k = 0; k < M; k++) {
			int val1 = 0;
			int val2 = 0;
			int V1 = sc.nextInt();
			int V2 = sc.nextInt();

			for (int i = 1; i <= H; i++) {
				val1 += arr[i][V2];
			}

			for (int j = 1; j <= Y; j++) {
				val2 += arr[V1][j];
			}

			System.out.println("" + val1 + " " + val2);
		}
	}
}
