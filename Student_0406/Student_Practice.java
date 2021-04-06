
public class Student_Practice {
	String name;
	int midScore;
	int finalScore;
	
	Student_Practice(String name, int midScore, int finalScore) {
		this.name = name;
		this.midScore = midScore;
		this.finalScore = finalScore;
	}
	

	@Override // 명시해주기
	public String toString() {
		return "이름 : " + this.name + ", 중간고사성적 : " + this.midScore + ", 기말고사성적 : " + this.finalScore;
	}
}
