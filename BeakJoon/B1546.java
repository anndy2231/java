import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1546 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		while ((input = br.readLine()) != null) {

			String[] arr1 = br.readLine().split(" ");
			int arr2[] = new int[arr1.length];

			for (int j = 0; j < arr1.length; j++) {
				arr2[j] = Integer.parseInt(arr1[j]);
			}

			Arrays.sort(arr2);

			int max = arr2[arr2.length - 1];
			double arr3[] = new double[arr2.length];
			for (int j = 0; j < arr2.length; j++) {
				arr3[j] = ((arr2[j] / (double) max) * 100.0);
			}
			
			double sum = 0.0;
			double avg = 0.0;

			for (int j = 0; j < arr3.length; j++) {
				sum += arr3[j];
			}

			avg = (double) sum / arr3.length;

			System.out.println(avg);
		}
	}
}
