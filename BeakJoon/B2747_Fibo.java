import java.util.Arrays;
import java.util.Scanner;

public class B2747_Fibo {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int Fibo[] = new int[n+1];
        Fibo[0] = 0;
        Fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            Fibo[i] = Fibo[i - 1] + Fibo[i - 2];
        }
        System.out.println(Fibo[n]);
        System.out.println(Arrays.toString(Fibo));

	}

}
