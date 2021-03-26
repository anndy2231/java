import java.util.Scanner;

public class Method2_Kaup {

	int weight = 0;
	int height = 0;
	
//	 	키를 'm'로 하고 싶을 때
//		double weight = 0;
//		double height = 0;
		
	public void userData() {
		Scanner sc = new Scanner(System.in);

		System.out.println("귀하의 '체중(kg)'을 입력해주세요.");
		String userWeight = sc.nextLine();
		weight = Integer.parseInt(userWeight);
//		weight = Double.parseDouble(userWeight);

		System.out.println("귀하의 '키(cm)'를 입력해주세요.");
		String userHeight = sc.nextLine();
		height = Integer.parseInt(userHeight);
//		height = Double.parseDouble(userHeight);
	}

	public void calc() {
		double heightTrans = (double) height / 100;
		double Kaup = (double) weight / (heightTrans * heightTrans);
		
		System.out.println(Kaup);
		
		if (Kaup >= 30) {
			System.out.println("비만");
		} else if (Kaup >= 24) {
			System.out.println("과체중");
		} else if (Kaup >= 20) {
			System.out.println("정상");
		} else if (Kaup > 15) {
			System.out.println("저체중");
		} else if (Kaup >= 13) {
			System.out.println("여윔");
		} else if (Kaup >= 10) {
			System.out.println("영양 실조증");
		} else {
			System.out.println("소모증");
		}
	}
}

//	교수님 return 사용 
//
//import java.util.Scanner;
//
//public class Method2_Kaup {
//	public double userInputWeight() {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("체중을 입력해주세요(kg) : ");
//		String userInputText = scanner.nextLine();
//		double weight = Double.parseDouble(userInputText);
//		return weight;
//	}
//	public double userInputHeight() {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("신장을 입력해주세요(m) : ");
//		String userInputText2 = scanner.nextLine();
//		double height = Double.parseDouble(userInputText2);
//		return height;
//	}
//	public void calcKaup(double weight, double height) {
//		double kaup = (double)weight / (height * height);
//		
//		if (kaup >= 30) {
//			System.out.println("비만");
//		} else if (kaup >= 24) {
//			System.out.println("과체중");
//		} else if (kaup >= 20) {
//			System.out.println("정상");
//		} else if (kaup > 15) {
//			System.out.println("저체중");
//		} else if (kaup >= 13) {
//			System.out.println("여윔");
//		} else if (kaup >= 10) {
//			System.out.println("영양 실조증");
//		} else {
//			System.out.println("소모증");
//		}
//	}
//}
