import java.util.Scanner;

public class B2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int index = 0;
		int max = 0;

		for (int j = 0; j < arr.length; j++) {
			if(max < arr[j]) {
				max = arr[j];
				index = j+1;
			}
		}  
		
		System.out.println(max);
		System.out.println(index);
	}
}
