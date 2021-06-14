import java.util.Arrays;
import java.util.Scanner;

public class AlgoTest2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String[] input = sc.nextLine().split(" ");
			int[] arr = new int[input.length];
			for (int k = 0; k < arr.length; k++) {
				arr[k] = Integer.parseInt(input[k]);
			}
			Arrays.sort(arr);
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
		}
	}
}