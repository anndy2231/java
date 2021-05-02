import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {
		Student[] student = {new Student("홍길동", 100, 500), new Student("둘리", 300, 400), new Student("임꺽정", 50, 550),
				new Student("장보고", 330, 80), new Student("고길동", 200, 300), new Student("희동", 150, 150),
				new Student("또치", 200, 700), new Student("도우너", 100, 600), new Student("장백산", 250, 150),
				new Student("광수", 150, 150)};
		
		int totalMiddleScore = 0;
		int totalFinalScore = 0;
		int totalScore = 0;
		for (int i = 0; i < student.length; i++) {
			totalMiddleScore = totalMiddleScore + student[i].middleScore;
			totalFinalScore = totalFinalScore + student[i].finalScore;
			totalScore = totalScore + student[i].totalScore;
		}
		
		double avgMiddleScore = (double)totalMiddleScore / student.length;
		double avgFinalScore = (double)totalFinalScore / student.length;
		double avgTotalScore = (double)totalScore / student.length;
		
		System.out.println("중간고사 총점 : " + totalMiddleScore + ", 중간고사 평균 : " + avgMiddleScore);
		System.out.println("기말고사 총점 : " + totalFinalScore + ", 기말고사 평균 : " + avgFinalScore);
		System.out.println("전체 총점 : " + totalScore + ", 전체 평균 : " + avgTotalScore);
		
		for (int i = 0; i < student.length - 1; i++) {
			for (int j = i + 1; j < student.length; j++) {
				if (student[i].totalScore < student[j].totalScore) {
					Student temp = student[i];
					student[i] = student[j];
					student[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(student));
	}
}
