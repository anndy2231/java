import java.util.Arrays;
import java.util.Scanner;

public class AlgoTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int max1 = arr[arr.length - 1];
		int max2 = arr[arr.length - 2];

		int result = 0;
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (count == K) {
				result += max2;
				count = 0;
				continue;
			}
			result += max1;
			count++;
		}

		System.out.println(result);
	}
}
