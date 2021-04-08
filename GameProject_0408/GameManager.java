import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	public void play() {
		Player[] player = { new PlayerType1("남덕"), new PlayerType1("피카츄") };
		Enemy[] enemy = { new EnemyType1("로켓단"), new EnemyType1("냐옹이") };

		Random r = new Random();
		for (int i = 0; i < 999999; i++) {
			System.out.println("\n\n" + (i + 1) + "턴\n");
			System.out.println("공격할 대상을 선정해주세요.");
			System.out.println(Arrays.toString(enemy));
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();

			// 플레이어 턴
				Enemy attackTarget1 = enemy[0];
				Enemy attackTarget2 = enemy[1];
				
				if (userInput.equals("로켓단")) {
					player[0].attack(enemy[0]);
				}
				else if (userInput.equals("냐옹이")) {
					player[0].attack(enemy[1]);
				}
				else if (userInput.equals("로켓단")) {
					player[1].attack(enemy[0]);
				}
				else if ( userInput.equals("냐옹이")) {
					player[1].attack(enemy[1]);
				}
				
				

//				int attackTarget = r.nextInt(enemy.length);
//				if (player[playerIndex].isLive() && enemy[attackTarget].isLive()) {
//					player[playerIndex].attack(enemy[attackTarget]);
//					player[playerIndex].heal(player[playerIndex]);
//				}
			
			// 적 턴
			for (int enemyIndex = 0; enemyIndex < enemy.length; enemyIndex++) {
				int attackTarget = r.nextInt(player.length);
				if (enemy[enemyIndex].isLive() && player[attackTarget].isLive()) {
					enemy[enemyIndex].attack(player[attackTarget]);
				}
			}
			// 게임 종료 여부 확인
			boolean isPlayerLive = false;
			for (int playerIndex = 0; playerIndex < player.length; playerIndex++) {
				if (player[playerIndex].isLive()) {
					isPlayerLive = true;
				}
			}
			boolean isEnemyLive = false;
			for (int enemyIndex = 0; enemyIndex < enemy.length; enemyIndex++) {
				if (enemy[enemyIndex].isLive()) {
					isEnemyLive = true;
				}
			}
			if (isPlayerLive && !isEnemyLive) {
				System.out.println("아군 승리!");
				break;
			} else if (!isPlayerLive && isEnemyLive) {
				System.out.println("적군 승리!");
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

		}
	}
}
