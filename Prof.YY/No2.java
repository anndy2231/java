
public class No2 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("1이상 100이하의 자연수 중 짝수인 숫자의 총합은 "+sum+" 입니다.");
	}
}
