import java.util.Random;

public class Student_Practice_Exec {

	public static void main(String[] args) {

		Student_Practice arr[] = new Student_Practice[11];
		int randNum1 = 0;
		int randNum2 = 0;

		for (int i = 1; i < arr.length; i++) {
			Random r1 = new Random();
			randNum1 = r1.nextInt(100);
			randNum2 = r1.nextInt(100);
			arr[i] = new Student_Practice("학생" + i, randNum1, randNum2);
			
			int totalScore = randNum1 + randNum2;
			double avg = (double) totalScore / 2;
			
			System.out.println(arr[i] + ", 총점 : " + totalScore + ", 평균 : " + avg);
		}

	}

}
