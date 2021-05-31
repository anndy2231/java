import java.util.Arrays;
import java.util.Scanner;

public class B2293_CoinCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 동전 종류
		int k = sc.nextInt(); // 동전 가치의 합
		
		int coin[] = new int [101]; // 동전 종류는 1~100
		int dp[] = new int[10001]; // 동전 가치의 합은 1~10000
		
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(coin));
		
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <=k; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[k]);
		sc.close();
	}
}
