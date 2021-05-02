import java.util.ArrayList;
import java.util.Scanner;

public class AlgoTest2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		arr.add(1);
		arr.add(11);
		System.out.println(arr);
		arr2.add(2);
		int val = arr2.get(0);
		arr.add(val);
		System.out.println(arr);
		
//		for (int i = 0; i < N; i++) {
//			arr.add(sc.nextInt());
//		}
		
	}
}
