
public class 재귀함수 {

	public static void main(String[] args) {	
		System.out.println(myAdd(myAdd(1, 2), myAdd(1, 2)));
		
	}

	public static int myAdd(int a, int b) {
		return a+b;
	}
}
