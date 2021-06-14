import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_FindBracket_0517 {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input_0517.txt"));

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());

		Scanner sc = new Scanner(System.in);
		String T1 = sc.nextLine();
		int T = Integer.parseInt(T1);

		for (int i = 0; i < T; i++) {

			String arr1[] = sc.nextLine().split("");
			// 찾을 괄호 인덱스
			int N = Integer.parseInt(arr1[0]) - 1;
			String arr2[] = new String[arr1.length - 2];

			for (int j = 0; j < arr1.length - 2; j++) {
				arr2[j] = arr1[j + 2];
			}

			// 괄호 개수 설정
			int left = 0;
			int right = 0;

			for (int j = 0; j < arr2.length; j++) {
				if (arr2[j].equals("(")) {
					left++;
				} else if (arr2[j].equals(")")) {
					right++;
				}
			}

			// 짝이 맞지 않는 경우
			if (left != right) {
				System.out.println("#" + (i + 1) + " " + 0);
			} else { // 짝이 맞는 경우
				int count = 0;
				String arr3[] = Arrays.copyOfRange(arr2, N, arr2.length);
				for (int j = 0; j < arr3.length; j++) {
					if (arr3[j].equals("(")) {
						count++;
					} else if (arr3[j].equals(")")) {
						count--;
					}
					if (count == 0) {
						System.out.println("#" + (i + 1) + " " + (j + N + 1));
						break;
					}
				}

			}
		}

	}

}
