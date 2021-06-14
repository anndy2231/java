import java.util.Scanner;

public class Coin_Greedy {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int havingMoney = 1000;
		System.out.println("사용할 금액을 입력해주세요.");
		int spentMoney = sc.nextInt();
		int change = havingMoney - spentMoney;
		int count = 0;
		int[] arr = { 1, 5, 10, 50, 100, 500 };
		int coinNum = arr.length;

		for (int i = coinNum - 1; i >= 0; i--) {
			if (change >= arr[i]) {
				count += change / arr[i];
				change = change % arr[i];
			}
		}
		System.out.println(count);
	}

}
