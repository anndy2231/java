import java.util.Scanner;

public class B3052 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 0;

		int arr1[] = new int[10];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt() % 42;
			count++;
		}
		
		for (int i = 0; i < arr1.length; i++) {			
			for (int j = 0; j < i; j++) {
				if (arr1[i] == arr1[j]) {
					count--;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
