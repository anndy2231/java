
public class Student {
//	프로퍼티
	String name;
	int korScore;
	int engScore;
	int mathScore;
	int totalScore;
	
	Student(String name, int korScore, int engScore, int mathScore){
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.totalScore = korScore + engScore + mathScore;
	}
	
	public void printInfo() {
		System.out.println(this.name + " : " 
				+ "국어 " + this.korScore + ", "
				+ "영어 " + this.engScore + ", "
				+ "수학 " + this.mathScore + ", "
				+ "총점 " + this.totalScore
				);
	}
	
	
	
////	this는 내 프로퍼티에 넣을 때 사용
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setKorScore(int score) {
//		korScore = score;
//	}
//	public void setEngScore(int score) {
//		this.engScore = score;
//	}
//	public void setMathScore(int mathScore) {
//		this.mathScore = mathScore;
//	}
//	
////	getter
//	public String getName() {
//		return this.name;
//		
//	}

}
