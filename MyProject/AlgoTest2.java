import java.util.Arrays;
import java.util.Scanner;

public class AlgoTest2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {

			String[] arr = sc.nextLine().split(" ");
			int[] arr2 = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				arr2[j] = Integer.parseInt(arr[j]);
			}

			Arrays.sort(arr2);
			for (int j = 0; j < arr2.length; j++) {

				System.out.print(arr2[j] + " ");
			}
		}
	}
}