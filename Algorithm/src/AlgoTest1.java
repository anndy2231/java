import java.util.Scanner;

public class AlgoTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int cnt = 0;
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			String a = sc.nextLine();
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == 'A') {
					cnt++;
				}
			}
			arr[i] = cnt;
			cnt = 0;
		}
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}

	}
}