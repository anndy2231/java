import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4344 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {

			String[] arr1 = br.readLine().split(" ");
			String n = arr1[0];
			int N = Integer.parseInt(n);
	
			int arr2[]=new int[arr1.length-1];
			
			for (int j =0; j < arr1.length-1; j++) {
				arr2[j] = Integer.parseInt(arr1[j+1]);
			}
			
			int sum = 0;
			double avg = 0.0;
			int count = 0;
			double ratio = 0.0;

			for (int j = 0; j < arr2.length; j++) {
				sum += arr2[j];
			}

			avg = (double) sum / arr2.length;

			for (int k = 0; k < arr2.length; k++) {
				if (arr2[k] > avg) {
					count++;
				}
			}
			ratio = (double) count / arr2.length * 100;

			System.out.println(String.format("%.3f%%", ratio));

		}
	}
}