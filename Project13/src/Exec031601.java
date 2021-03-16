
public class Exec031601 {

	public static void main(String[] args) {

		// for문
//		for (int i = 0; i < 10; i++) {
//			System.out.println("*" + "(" + i + "번째 반복)");
//		}

//		int number1 = 2;
		// 초기값, 범위, 증감
//		for (int i = 0; i < 9; i++) {
//			int number2 = i + 1;
//			int resultNumber = number1*number2;
//			System.out.println(""+number1+"X"+number2+"="+resultNumber);
//		}

		// while 문
//		int number1 = 2;
//		int i = 0;
//		while(i < 9) {
//			int number2 = i + 1;
//			int resultNumber = number1*number2;
//			System.out.println(""+number1+"X"+number2+"="+resultNumber);
//			i++; <- 설정하지 않으면 무한루프
//		}

		// 1~10중 짝수만 출력 
		int number = 2;
		for (int i = 0; i < 5; i++) {
			int number1 = i + 1;
			int resultNumber = number * number1;
			System.out.println(resultNumber);
		}

		
		
	}
}
