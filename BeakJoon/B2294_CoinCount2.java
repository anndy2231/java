import java.util.Scanner;

public class B2294_CoinCount2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i, j;
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n + 1];
		int d[] = new int[k + 1];

		for (i = 1; i <= k; i++)
			d[i] = 100001;
		d[0] = 0;

		for (i = 1; i <= n; i++)
			a[i] = sc.nextInt();

		for (i = 1; i <= n; i++)
			for (j = a[i]; j <= k; j++)
				d[j] = Math.min(d[j], d[j - a[i]] + 1);

		if (d[k] == 100001)
			d[k] = -1;
		System.out.println(d[k]);

		sc.close();

	}

}
