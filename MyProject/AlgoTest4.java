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
		System.out.println(Arrays.toString(arr));

//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

		int max1 = arr[0];
		int max2 = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max2 = arr[i];
			}

		}
		System.out.println("최대1 : " + max1 + ", " + "최대2 : " + max2);

		int result = 0;
		int count = 1;
		for (int i = 0; i < M; i++) {
			if (count > K) {
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
