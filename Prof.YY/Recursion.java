
public class Recursion {

	public static void main(String[] args) {
//		f(n) = n + f(n+1)
//		100 <= n; then exit
//
		System.out.println(myRecursion1(1));
		System.out.println(myRecursion2(5));
		System.out.println(myRecursion3(100));
		System.out.println(myRecursion4(5));

	}

	public static int myRecursion1(int a) {

		if (a >= 100)
			return 100;
		return a + myRecursion1(a + 1);

//		return 1 + f(2)
//			return 2 + f(3)
//				return 3 + f(4)
//					return 4 + f(5)
//						return 5	
	}

	public static int myRecursion2(int b) {
		if (b == 1)
			return 1;
		return b * myRecursion2(b - 1);

	}

	public static int myRecursion3(int c) {
		if (c >= 200)
			return 200;
		return c + myRecursion3(c + 1);
	}

	public static int myRecursion4(int d) {
		// 피보나치 : f(n) = f(n-1) + f(n-2)
		if (d <= 1) {
			return d;
		} else {
			return myRecursion4(d - 1) + myRecursion4(d - 2);
		}
	}
	
}