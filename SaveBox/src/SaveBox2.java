public class SaveBox2 {
	
	int coins = 0;
	public void deposit1(int coin) {
		coins = coins + coin;
		System.out.println("'딸그랑' 저금통에 " + coin + "원이 들어갔습니다.");
		System.out.println("현재 저금통의 잔액은 " + coins + "원 입니다.");
	}

	public void deposit2(int coin, String words) {
		coins = coin + coins;
		System.out.println("현재 저금통의 잔액은 " + coins + "원 입니다.");
	}

	public void crash() {
		System.out.println("현재 저금통의 잔액은 " + coins +"원 입니다.");
	}

}
