
public class Student_Exec {

	public static void main(String[] args) {
//		new는 생성자
		Student s1 = new Student("홍길동", 100, 100, 100);
//		s1.name = "홍길동";
//		s1.korScore = 100;
//		s1.engScore = 100;
//		s1.mathScore = 100;

		Student s2 = new Student("둘리",50,10,90);
//		s2.name = "둘리";
//		s2.korScore = 50;
//		s2.engScore = 10;
//		s2.mathScore = 90;

		s1.printInfo();
		s2.printInfo();



//		s1.setName("홍길동");
//		s1.name = "홍길동"; // 프로퍼티에 직접 접근
//		s1.setKorScore(100);
//		s1.setEngScore(100);
//		s1.setMathScore(100);
//		
//		Student s2 = new Student();
//		s2.setName("둘리");
//		s2.setKorScore(50);
//		s2.setEngScore(20);
//		s2.setMathScore(90);

	}

}
