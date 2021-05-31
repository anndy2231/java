import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2293_CoinCount {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr [] = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]); // 동전 종류 
		int k = Integer.parseInt(arr[1]); // 동전 가치의 합
		
		int coin[] = new int [101]; // 동전 종류는 1~100
		int dp[] = new int [10001]; // 동전 가치의 합은 1~10000
		
		/* 			0	1	2	3	4	5	6	7	8	9	10
		 * 1		1	1 	1	1	1	1	1	1	1	1	1	
		 * 1,2		1	1	2	2	3	3	4	4	5	5	6
		 * 1,2,5	1	1	2	2	3	4	5	6	7	8	*10	
		 * 	
		 */
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0]=1;

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = dp[j]+dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
