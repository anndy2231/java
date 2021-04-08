import java.util.Random;

public class PlayerType1 extends Player {
	public PlayerType1(String name) {
		this.hp = 100;
		this.power = 10;
		this.name = name;
		this.defense = 5;
		this.heal = 3;
	}

	@Override
	public void attack(Base enemy) {

		// 10% 확률로 크리티컬 공격
		Random r = new Random();
		int randNum = r.nextInt(10);
		int damage = 0;
		
		if (randNum == 1) {
			damage = this.power * 2 - enemy.defense;
			enemy.hp = enemy.hp - damage;
			System.out.print("[크리티컬 : 공격력 2배] ");
		} else {
			damage = this.power - enemy.defense;
			enemy.hp = enemy.hp - damage;
		}

		System.out.println(this.name + "은(는) " + enemy.name + "에게 " + damage + "의 피해를 입혔다." + " | " + enemy.name + " HP : " + enemy.hp);

		if (!enemy.isLive()) {
			System.out.println(this.name + "은(는) " + enemy.name + "을(를) 파괴했다.");
		}
	}
	
	@Override
	public void heal(Base player) {
		this.hp = this.hp + this.heal;
		System.out.println(
				this.name + "은(는) " + this.name + "에게 " + this.heal + "의 HP를 치유했습니다." + " | HP : " + player.hp);
	}
	
}