import java.util.Arrays;
import java.util.Scanner;

public class B10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int a1 = Integer.parseInt(a);
		int[] arr = new int[a1];

		String[] arr2 = sc.nextLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(arr2[i]);
		}
		Arrays.sort(arr);

		int min = arr[0];
		int max = arr[arr.length - 1];

		System.out.println("" + min + " " + max);
	}
}