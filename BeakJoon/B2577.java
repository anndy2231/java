import java.util.Scanner;

public class B2577 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();

		int v0 = 0;
		int v1 = 0;
		int v2 = 0;
		int v3 = 0;
		int v4 = 0;
		int v5 = 0;
		int v6 = 0;
		int v7 = 0;
		int v8 = 0;
		int v9 = 0;

		int result = A * B * C;
		String arr[] = Integer.toString(result).split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("0")) {
				v0++;
			} else if (arr[i].equals("1")) {
				v1++;
			} else if (arr[i].equals("2")) {
				v2++;
			} else if (arr[i].equals("3")) {
				v3++;
			} else if (arr[i].equals("4")) {
				v4++;
			} else if (arr[i].equals("5")) {
				v5++;
			} else if (arr[i].equals("6")) {
				v6++;
			} else if (arr[i].equals("7")) {
				v7++;
			} else if (arr[i].equals("8")) {
				v8++;
			} else if (arr[i].equals("9")) {
				v9++;
			}
		}
		System.out.println(v0);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
		System.out.println(v7);
		System.out.println(v8);
		System.out.println(v9);
	}
}
