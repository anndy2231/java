import java.util.Scanner;

public class SaveBox2_Exec {

	public static void main(String[] args) {
		
		SaveBox2 box1 = new SaveBox2();
		
		for (int i = 0; i < 9999999; i++) {
			System.out.println();
			System.out.println("-------------------------");			
			System.out.println("원하시는 메뉴를 선택해주세요.");
			System.out.println("1 : 돈 넣기");
			System.out.println("2 : 돈 넣기 + 메시지 추가");
			System.out.println("종료를 원하시면 'crash'를 입력해주세요.");

			Scanner s1 = new Scanner(System.in);
			String userInputString = s1.nextLine();
			
		
			
			int convertNumber = Integer.parseInt(userInputString); // 문자열 -> 숫자
			if (convertNumber == 1) {
				System.out.println("얼마를 넣으시겠습니까?");
				int coin = s1.nextInt();
				box1.deposit1(coin);
			}
			
			if (convertNumber == 2) {				
				System.out.println("메시지를 입력해주세요.");
				String words = s1.nextLine();
				System.out.println("입력한 메시지 : " + words);
				System.out.println("입금할 금액 : ");
				int coin = s1.nextInt();
				System.out.println(coin + " 입금되었습니다.");
				box1.deposit2(coin, words);
			}
			
			if (userInputString.equals("crash")) { 
				break;
			}
		}
	}
}