import java.util.Scanner;

public class SaveBox2 {
	int coins = 0;

	public void deposit1(int coin) {
		coins = coins + coin;
		System.out.println("'딸그랑' " + coin + "원이 입금되었습니다.");
		System.out.println("현재 " + coins + "원이 들어있습니다.");
	}

	public void deposit2(int coin, String words) {
		coins = coin + coins;
		System.out.println("원하는 메시지를 입력해주세요 : " + words + "\n현재 잔액은 " + coins + " 원 입니다.");
	}

	public void crash() {
		System.out.println("현재 저금통에 있는 돈은 " + coins +" 원 입니다.");
	}
}
