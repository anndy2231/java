import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 어렵게 생각하지 않고 우리가 수업 때 배웠던 잔돈 문제를 생각하면 쉽게 풀 수 있어요~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		// 교수님은 버퍼드리더를 사용해 이번 문제를 푸셨어요~
		// 지난 번 수업 때 짧게 언급하셨는데 버퍼를 사용하면 입출력 효율이 엄청나게 좋아집니다.
		// 모았다가 보내는데 왜 입출력 효율이 좋아질까요?
		final int bus45 = 45;
		final int bus25 = 25;
		int res45 = 0; // 카운트를 위한 변수 설정
		int res25 = 0;

		while (true) {

			if (number <= 0) {

				System.out.println(res45 + " " + res25);

				break;

			} else if (number < 25) {

				number = number - bus25;

				res25++;

			} else if (number % bus25 == 0) {

				res25 = number / bus25;

				number = number - bus25 * res25;

			} else if (number % bus45 == 0) {

				res45 = number / bus45;

				number = number - bus45 * res45;

			} else if (number % bus25 > 20 && number % bus25 < 25) {

				number = number - bus25;

				res25++;

			} else if (number > bus25 && number < bus45) {

				number = number - bus45;

				res45++;

			} else if (number > 50) {

				number = number - bus45;

				res45++;

			}

		}

	}

}