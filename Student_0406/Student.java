
public class Student {
	String name;
	int middleScore;
	int finalScore;
	
	int totalScore;
	
	Student(String name, int middleScore, int finalScore) {
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.sumScore();
	}
	public void sumScore() {
		this.totalScore = this.middleScore + this.finalScore;
	}
	
	@Override
	public String toString() {
		return this.name + " : " + this.totalScore;
	}
}
