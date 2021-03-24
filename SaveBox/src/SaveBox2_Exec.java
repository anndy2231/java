import java.util.Scanner;

public class SaveBox2_Exec {

	public static void main(String[] args) {

		SaveBox2 box1 = new SaveBox2();

		for (int i = 0; i < 9999999; i++) {
			System.out.println("==============================");
			System.out.println("원하는 숫자를 입력해주세요.");
			System.out.println("1 : 돈 넣기");
			System.out.println("2 : 돈 넣기 + 메시지 추가");
			System.out.println("종료를 원하시면 'crash'를 입력해주세요.");
			System.out.println("==============================");

			Scanner s1 = new Scanner(System.in);
			String userInputString = s1.nextLine();

			if (userInputString.equals("crash")) {
				box1.crash();
				System.out.println("- 프로그램 종료 -");
				break;
			}

			// 문자열을 정수로 변환
			int convertNumber = Integer.parseInt(userInputString);

			if (convertNumber == 1) {
				System.out.println("얼마를 넣으시겠습니까?");
				int coin = s1.nextInt();
				box1.deposit1(coin);
			}

			if (convertNumber == 2) {
				System.out.println("메시지를 입력해주세요.");
				String words = s1.nextLine();
				System.out.println("얼마를 넣으시겠습니까?");
				int coin = s1.nextInt();
				System.out.println("'메시지 : " + words + "' 저금통에 " + coin + "원이 들어갔습니다.");
				box1.deposit2(coin, words);
			}

			if (convertNumber < 1 || convertNumber > 2) {
				System.out.println("숫자 '1' 또는 '2'만 입력하실 수 있습니다.");
			}

		}
	}
}